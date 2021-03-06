package principle.demeter.improve;


import principle.demeter.improve.entity.Document;
import principle.demeter.improve.entity.Html;

/**
 * @Author 喻可
 * @Date 2021/7/28 9:47
 */
// 通过一个工厂方法来创建Document
public class DocumentFactory {
    private HtmlDownloader downloader;

    public DocumentFactory(HtmlDownloader downloader) {
        this.downloader = downloader;
    }

    public Document createDocument(String url) {
        Html html = downloader.downloadHtml(url);
        return new Document(url, html);
    }
}
