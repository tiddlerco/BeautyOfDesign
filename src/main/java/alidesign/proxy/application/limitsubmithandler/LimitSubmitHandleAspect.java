package alidesign.proxy.application.limitsubmithandler;

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
@Order(2)
@Component
public class LimitSubmitHandleAspect extends BaseMethodAspect {

    /**
     * 指定切点（处理打上 LimitSubmitAnno 的方法）
     */
    @Override
    @Pointcut("@annotation(alidesign.proxy.aopframe.annotation.LimitSubmitAnno)")
    protected void pointcut() { }

    /**
     * 指定该切面绑定的方法切面处理器为 ExceptionHandleHandler
     */
    @Override
    protected Class<? extends MethodAdviceHandler<?>> getAdviceHandlerType() {
        return LimitSubmitHandleHandler.class;
    }
}