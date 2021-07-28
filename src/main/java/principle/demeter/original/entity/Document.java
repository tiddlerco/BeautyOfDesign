package principle.demeter.original.entity;

import principle.demeter.HtmlDownloader;

/**
 * 表示网页文档，后续的网页内容抽取、分词、索引都是以此为处理对象
 */
public class Document {

    private Html html;

    private String url;

    public Document(String url) {
        this.url = url;
        HtmlDownloader downloader = new HtmlDownloader();
        this.html = downloader.downloadHtml(url);
    }
    //...
}
