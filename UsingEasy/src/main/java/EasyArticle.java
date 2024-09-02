import java.util.List;

public class EasyArticle{

    private ArticleReader articleReader;
    private ArticleWriter articleWriter;

    public EasyArticle(ArticleReader mockArticleReader) {
        this.articleReader = mockArticleReader;
    }

    public EasyArticle(ArticleWriter mockArticleWriter) {
        this.articleWriter = mockArticleWriter;
    }
    public EasyArticle() {}

    public EasyArticle(ArticleReader mockArticleReader, ArticleWriter mockArticleWriter) {
        this.articleWriter = mockArticleWriter;
        this.articleReader = mockArticleReader;
    }

    public void readNext(){
        articleReader.next();
    }

    public List<EasyArticle> readTopic(String topic){
        return articleReader.ofTopic(topic);
    }

    public String write(String title, String content){
        return articleWriter.write(title, content);
    }
}