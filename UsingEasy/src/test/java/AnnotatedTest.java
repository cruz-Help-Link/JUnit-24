import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import static org.easymock.EasyMock.*;

public class AnnotatedTest {
    @Rule
    public EasyMockRule mockRule = new EasyMockRule(this);

    @Mock
    ArticleReader mockArticleReader;

    @TestSubject
    EasyArticle easyArticle = new EasyArticle();

    @Test
    public void whenReadNext_thenNextArticleRead() {
        expect(mockArticleReader.next()).andReturn(null);
        replay(mockArticleReader);
        easyArticle.readNext();
        verify(mockArticleReader);
    }

    EasyMockSupport easyMockSupport = new EasyMockSupport();

    @Test
    public void whenReadAndWriteSequencially_thenWorks(){
        ArticleReader mockArticleReader = easyMockSupport
                .createMock(ArticleReader.class);
        ArticleWriter mockArticleWriter = easyMockSupport
                .createMock(ArticleWriter.class);
        easyArticle = new EasyArticle(
                mockArticleReader, mockArticleWriter);

        expect(mockArticleReader.next()).andReturn(null);
        expect(mockArticleWriter.write("title", "Mocking Perfectly with EasyMock"))
                .andReturn("");
        easyMockSupport.replayAll();

        easyArticle.readNext();
        easyArticle.write("title", "Mocking Perfectly with EasyMock");

        easyMockSupport.verifyAll();
    }
}