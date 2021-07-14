package design.adapter.应用.example3.useadaptor;

import design.adapter.应用.example3.IA;

/**
 * 使用适配器示例
 *
 * @Author 喻可
 * @Date 2021/7/14 14:38
 */


// 将外部系统A替换成外部系统B
public class BAdaptor implements IA {

    private B b;

    public BAdaptor(B b) {
        this.b = b;
    }

    public void fa() {
        //...
        b.fb();
    }
}
