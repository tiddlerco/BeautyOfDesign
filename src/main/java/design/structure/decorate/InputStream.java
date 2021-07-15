package design.structure.decorate;


import java.io.IOException;


/**
 * 装饰器类和原始类的父类
 */
public abstract class InputStream {


    public abstract int read() throws IOException;

    //...
    public int read(byte b[]) throws IOException {
        return read(b, 0, b.length);
    }

    public int read(byte b[], int off, int len) throws IOException {
        //...
        return off;
    }

    public long skip(long n) throws IOException {
        //...
        return n;
    }

    public int available() throws IOException {
        return 0;
    }

    public void close() throws IOException {
    }

    public synchronized void mark(int readlimit) {
    }

    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public boolean markSupported() {
        return false;
    }
}



