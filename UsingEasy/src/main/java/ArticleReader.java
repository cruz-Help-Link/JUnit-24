import java.util.List;

public interface ArticleReader {
    EasyArticle next();

    List<EasyArticle> ofTopic(String topic);
}
