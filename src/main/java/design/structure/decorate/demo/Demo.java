package design.structure.decorate.demo;


import java.io.*;

public class Demo {

    public static void main(String[] args) throws IOException {
        //FileInputStream原始类 和装饰器类继承同样的父类InputStream
        InputStream in = new FileInputStream("/user/wangzheng/test.txt");

        //BufferedInputStream对FileInputStream进行增强
        InputStream bin = new BufferedInputStream(in);
        DataInputStream din = new DataInputStream(bin);

        int data = din.readInt();
    }

}
