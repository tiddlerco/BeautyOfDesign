package principle.demeter.original;


import principle.demeter.original.entity.HtmlRequest;

/**
 * 负责底层网络通信，根据请求获取数据
 * 问题：依赖了不该有直接依赖关系的 HtmlRequest 类
 */
public class NetworkTransporter {
    // 省略属性和其他方法...
    public Byte[] send(HtmlRequest htmlRequest) {
        //...
        return new Byte[0];
    }
}




