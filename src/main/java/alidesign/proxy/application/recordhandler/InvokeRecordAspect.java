package alidesign.proxy.application.recordhandler;

import alidesign.proxy.aopframe.aspect.BaseMethodAspect;
import alidesign.proxy.aopframe.methodadvice.MethodAdviceHandler;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 方法切面的实现
 *
 * @Author 喻可
 * @Date 2021/10/28 14:54
 */
@Aspect
//@Order 是用来标记这个切面应该在哪一层，数字越小，则在越外层（越先进入，越后结束）
// 方法调用记录的切面很明显应该在最外层，
// 因为方法调用记录的切面应该最后结束，所以我们给一个小点的数字。
@Order(1)
@Component
public class InvokeRecordAspect extends BaseMethodAspect {

    /**
     * 指定切点（处理打上 InvokeRecordAnno 的方法）
     */
    @Override
    @Pointcut("@annotation(alidesign.proxy.aopframe.annotation.InvokeRecordAnno)")
    protected void pointcut() {
    }


    /**
     * 指定该切面绑定的方法切面处理器为 InvokeRecordHandler
     */
    @Override
    protected Class<? extends MethodAdviceHandler<?>> getAdviceHandlerType() {
        return InvokeRecordHandler.class;
    }
}
