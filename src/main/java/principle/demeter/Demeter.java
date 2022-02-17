package principle.demeter;

import principle.demeter.improve.NetworkTransporter;
import principle.demeter.improve.entity.Html;

/**
 * 迪米特法则朋友的理解
 * 一个类C中的方法只能调用：
 * 1、C中其他实例方法
 * 2、它自己的参数方法
 * 3、它创建对象的方法
 * 4、不要调用全局变量（包括可变对象、可变单例）
 *
 * @title: Demeter
 * @Author yuke
 * @Date: 2021/12/29 23:16
 */
public class Demeter {
    Html html;

    public void downloadHtml(NetworkTransporter trans, String addr, String url) {
        if (checkUrl(url)) {// ok 自己的实例方法
            // return
        }
        Byte[] bytes = trans.send(addr, url);// ok 参数对象的方法
        Html html = createHtml(bytes); // ok 它创建的对象
        html.save();// ok  它创建对象的方法
    }

    private Html createHtml(Byte[] bytes) {
        return null;
    }

    private boolean checkUrl(String url) {
        // check
        return false;
    }

}
