package design.behavior.templatemethod.example1;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author 喻可
 * @Date 2021/7/19 14:39
 */

public abstract class InputStream implements Closeable {

    //把不变的方法放在抽象类中作为模板方法，子类需要重写的方法作为抽象方法
    public int read(byte b[], int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }
        //这里调用当前抽象类里需要重写的方法
        int c = read();
        if (c == -1) {
            return -1;
        }
        b[off] = (byte) c;

        int i = 1;
        try {
            for (; i < len; i++) {
                c = read();
                if (c == -1) {
                    break;
                }
                b[off + i] = (byte) c;
            }
        } catch (IOException ee) {
        }
        return i;
    }

    public abstract int read() throws IOException;
}


