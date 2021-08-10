package design.structure.decorate.example1.decorateClass;

import design.structure.decorate.example1.FilterInputStream;
import design.structure.decorate.example1.InputStream;

/**
 * 装饰器类是对功能的增强
 * 继承自装饰器父类。这样，装饰器类只需要实现它需要增强的方法就可以了
 */
public class BufferedInputStream extends FilterInputStream {

    protected BufferedInputStream(InputStream in) {
        super(in);
    }


    //...实现基于缓存的读数据接口...
}
