package design.behavior.visitor.单委派理解;

/**
 * @Author 喻可
 * @Date 2021/7/21 10:05
 */
public class DemoMain {
    public static void main(String[] args) {
        SingleDispatchClass demo = new SingleDispatchClass();
        //在编译时，根据传递进函数的参数的声明类型,来决定调用哪个重载函数
        ParentClass p = new ChildClass();
        demo.polymorphismFunction(p);//执行哪个对象的方法，由对象的实际类型决定
        demo.overloadFunction(p);//执行对象的哪个方法，由参数对象的声明类型决定
    }

    //代码执行结果:
    //I am ChildClass's f();
    // I am overloadFunction(ParentClass p);
}

