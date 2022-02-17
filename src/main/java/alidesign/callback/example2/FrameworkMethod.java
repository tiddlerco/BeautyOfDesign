package alidesign.callback.example2;

/**
 * @Author 喻可
 * @Date 2022/2/17 14:34
 */
public class FrameworkMethod {

    public Object invokeExplosively() throws Throwable {

        return new ReflectiveCallable() {
            @Override
            protected Object runReflectiveCall() throws Throwable {
                return "I am callback";
            }
        }.run();
    }
}
