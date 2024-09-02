import org.easymock.EasyMock;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArticleTest {
    @Test
    public void skipToNextArticle(){
        ArticleReader mockArticleReader = mock(ArticleReader.class);
        EasyArticle easyArticle = new EasyArticle(mockArticleReader);

        expect(mockArticleReader.next()).andReturn(null);  //method to be called when a reader skips an article
        //With expect(…), EasyMock is expecting the method to return a value or throw an Exception.
        replay(mockArticleReader);

        easyArticle.readNext();

        verify(mockArticleReader);
    }

    @Test
    public void skipToNext_checkTopics(){
//       A "strict mock" enforces the exact order of method calls;
//       if the code calls methods on the mock object in a different order than expected, the test will fail.
        ArticleReader mockArticleReader = strictMock(ArticleReader.class);
//      the class you're testing, and you're injecting the mock ArticleReader into it
//      to isolate the EasyArticle class's behavior

        // Create an instance of EasyArticle with the mockArticleReader
        EasyArticle easyArticle = new EasyArticle(mockArticleReader);

        // Set up the expectations in the exact order they will be called
        expect(mockArticleReader.next()).andReturn(null);
        expect(mockArticleReader.ofTopic("easymock")).andReturn(null);

        // Switch the mock to replay mode to start using it
        replay(mockArticleReader);

        // Call the methods to be tested in the exact order expected
        easyArticle.readNext();
        easyArticle.readTopic("easymock");

        // Verify that the interactions with the mock happened as expected
        verify(mockArticleReader);

    }

    @Test
    public void skipToNextOthers_checkTopics() {
        // Create a mock of ArticleReader
        ArticleReader mockArticleReader = niceMock(ArticleReader.class);

        // Create an instance of EasyArticle with the mockArticleReader
        EasyArticle easyArticle = new EasyArticle(mockArticleReader);

        // Set up the expectations
        expect(mockArticleReader.next()).andReturn(null);
        expect(mockArticleReader.ofTopic("easymock")).andReturn(null);

        // Switch the mock to replay mode to start using it
        replay(mockArticleReader);

        // Call the methods to be tested
        easyArticle.readNext();
        easyArticle.readTopic("easymock");

        // Verify that the interactions with the mock happened as expected
        verify(mockArticleReader);
    }

    @Test
    public void whenWriteMaliciousContent_thenArgumentIllegal() {
        // Create a mock of ArticleWriter
        ArticleWriter mockArticleWriter = niceMock(ArticleWriter.class);

        // Create an instance of EasyArticle with the mockArticleWriter
        EasyArticle easyArticle = new EasyArticle(mockArticleWriter);

        // Set up the expectation that writing malicious content throws IllegalArgumentException
        expect(mockArticleWriter
                .write("easymock", "<body onload=alert('shit')>"))
                .andThrow(new IllegalArgumentException());
        // Switch the mock to replay mode to start using it
        replay(mockArticleWriter);

        // Capture the exception that is expected to be thrown
        Exception expectedException = null;
        try {
            easyArticle.write("easymock", "<body onload=alert('shit')>");
        } catch (Exception e) {
            expectedException = e;
        }

        // Assert that the exception thrown is indeed IllegalArgumentException
        assertNotNull("Expected exception not thrown", expectedException);
        assertEquals(IllegalArgumentException.class, expectedException.getClass());

        // Verify that the interactions with the mock happened as expected
        verify(mockArticleWriter);
    }
}
