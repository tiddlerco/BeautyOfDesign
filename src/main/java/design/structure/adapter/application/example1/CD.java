package design.structure.adapter.application.example1;

/**
 * 封装有缺陷的接口设计
 * 假设我们依赖的外部系统在接口设计方面有缺陷（比如包含大量静态方法），
 * 引入之后会影响到我们自身代码的可测试性
 * <p>
 * 这个类来自外部sdk，我们无权修改它的代码
 *
 * @Author 喻可
 * @Date 2021/7/14 10:53
 */

public class CD {

    public static void staticFunction1() {

    }

    public void uglyNamingFunction2() {

    }

    public void tooManyParamsFunction3(String paramsWrapper) {


    }

    public void lowPerformanceFunction4() {

    }
}




