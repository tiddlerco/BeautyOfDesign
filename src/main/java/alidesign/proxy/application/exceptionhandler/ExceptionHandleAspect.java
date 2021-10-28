package alidesign.proxy.application.exceptionhandler;

import alidesign.proxy.aopframe.aspect.BaseMethodAspect;
import alidesign.proxy.aopframe.methodadvice.MethodAdviceHandler;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author 喻可
 * @Date 2021/10/28 16:02
 */
@Aspect
//异常处理一般是非常内层的切面，所以我们将@Order 设置为 10，
// 让 ExceptionHandleAspect 在 InvokeRecordAspect 更内层（即之后进入、之前结束）
// 从而外层的 InvokeRecordAspect 也可以记录到抛出异常时的返回值
@Order(10)
@Component
public class ExceptionHandleAspect extends BaseMethodAspect {

    /**
     * 指定切点（处理打上 ExceptionHandleAnno 的方法）
     */
    @Override
    @Pointcut("@annotation(alidesign.proxy.aopframe.annotation.ExceptionHandleAnno)")
    protected void pointcut() { }

    /**
     * 指定该切面绑定的方法切面处理器为 ExceptionHandleHandler
     */
    @Override
    protected Class<? extends MethodAdviceHandler<?>> getAdviceHandlerType() {
        return ExceptionHandleHandler.class;
    }
}