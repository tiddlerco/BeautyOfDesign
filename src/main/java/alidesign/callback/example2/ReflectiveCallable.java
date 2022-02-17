package alidesign.callback.example2;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author 喻可
 * @Date 2022/2/17 14:34
 */
public abstract class ReflectiveCallable {

    public Object run() throws Throwable {
        try {
            //添加逻辑
            return runReflectiveCall();
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    protected abstract Object runReflectiveCall() throws Throwable;
}
