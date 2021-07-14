package design.structure.adapter.application.example3;

import design.structure.adapter.application.example3.useadaptor.B;
import design.structure.adapter.application.example3.useadaptor.BAdaptor;

/**
 * @Author 喻可
 * @Date 2021/7/14 14:38
 */


// 在我们的项目中，外部系统A的使用示例
public class Demo {
    private IA a;

    public Demo(IA a) {
        this.a = a;
    }

    public static void main(String[] args) {

        //未使用适配时 外部系统A的使用示例
        Demo d1 = new Demo(new A());

        // 使用适配器后借助BAdaptor，Demo的代码中，调用IA接口的地方都无需改动，
        // 只需要将BAdaptor如下注入到Demo即可。
        Demo d2 = new Demo(new BAdaptor(new B()));
    }

}
