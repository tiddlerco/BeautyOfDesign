package design.structure.decorate.decorateClass;

import design.structure.decorate.FilterInputStream;
import design.structure.decorate.InputStream;

/**
 * 装饰类
 */
public class DataInputStream extends FilterInputStream {

    protected DataInputStream(InputStream in) {
        super(in);
    }


    //...实现读取基本类型数据的接口
}
