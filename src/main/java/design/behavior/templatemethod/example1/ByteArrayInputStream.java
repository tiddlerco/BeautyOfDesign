package design.behavior.templatemethod.example1;

import java.io.IOException;

/**
 * @Author 喻可
 * @Date 2021/7/19 14:39
 */
public class ByteArrayInputStream extends InputStream {
    //...省略其他代码...

    @Override
    public synchronized int read() {
        return -1;
    }

}
