package design.decorate.decorateClass;

import design.decorate.FilterInputStream;
import design.decorate.InputStream;

/**
 * 装饰类
 * 继承自装饰器父类。这样，装饰器类只需要实现它需要增强的方法就可以了
 */
public class BufferedInputStream extends FilterInputStream {

    protected BufferedInputStream(InputStream in) {
        super(in);
    }


    //...实现基于缓存的读数据接口...
}
