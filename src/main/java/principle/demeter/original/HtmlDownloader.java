package principle.demeter.original;

import principle.demeter.original.entity.Html;
import principle.demeter.original.entity.HtmlRequest;

/**
 * 用来通过 URL 获取网页
 * 这个类的设计没有问题
 */
public class HtmlDownloader {

    private NetworkTransporter transporter;//通过构造函数或IOC注入

    public Html downloadHtml(String url) {
        Byte[] rawHtml = transporter.send(new HtmlRequest(url));
        return new Html(rawHtml);
    }
}
