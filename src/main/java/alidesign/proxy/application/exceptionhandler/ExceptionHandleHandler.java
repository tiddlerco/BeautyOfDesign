package alidesign.proxy.application.exceptionhandler;

import alidesign.proxy.aopframe.methodadvice.BaseMethodAdviceHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 拓展：假设我们要在目标方法抛出异常时进行处理：
 * 抛出异常时，把异常信息异步发送到邮箱或者钉钉，然后根据方法的返回值类型，返回相应的错误响应。
 * 实现方法增强处理器
 *
 * @Author 喻可
 * @Date 2021/10/28 16:01
 */
@Component
public class ExceptionHandleHandler extends BaseMethodAdviceHandler<Object> {

    /**
     * 抛出异常时的处理
     */
    @Override
    public void onThrow(ProceedingJoinPoint point, Throwable e) {
        super.onThrow(point, e);
        // 发送异常到邮箱或者钉钉的逻辑
    }

    /**
     * 抛出异常时的返回值
     */
    @Override
    public Object getOnThrow(ProceedingJoinPoint point, Throwable e) {
        // 获得返回值类型
        Class<?> returnType = getTargetMethod(point).getReturnType();

        // 如果返回值类型是 Map 或者其子类
        if (Map.class.isAssignableFrom(returnType)) {
            Map<String, Object> result = new HashMap<>(4);
            result.put("success", false);
            result.put("message", "调用出错");

            return result;
        }

        return null;
    }
}
