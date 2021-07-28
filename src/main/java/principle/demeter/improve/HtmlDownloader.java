package principle.demeter.improve;


import principle.demeter.improve.entity.Html;
import principle.demeter.improve.entity.HtmlRequest;

/**
 * 用来通过 URL 获取网页
 */

public class HtmlDownloader {

    private NetworkTransporter transporter;//通过构造函数或IOC注入

    // HtmlDownloader这里也要有相应的修改
    public Html downloadHtml(String url) {
        HtmlRequest htmlRequest = new HtmlRequest(url);
        Byte[] rawHtml = transporter.send(htmlRequest.getAddress(), htmlRequest.getBytes());
        return new Html(rawHtml);
    }
}
