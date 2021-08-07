package design.structure.proxy.annotationAop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @description: 定义AOP切面
 * @author: 喻可
 * @create: 2021-08-07
 **/

@Aspect
@Component
public class LogAspect {

    // 定义切点
    @Pointcut("@annotation(EagleEye)")
    public void eagleEye() {

    }

    // 利用环绕增强来实现我们的功能
    @Around("eagleEye()")
    public Object surroundInform(ProceedingJoinPoint proceedingJoinPoint) {

        System.out.println("环绕通知开始...");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println("请求路径 : " + request.getRequestURL());
        System.out.println("请求方式 : " + request.getMethod());
        System.out.println("方法名 : " + proceedingJoinPoint.getSignature().getName());
        System.out.println("类路径 : " + proceedingJoinPoint.getSignature().getDeclaringTypeName());
        System.out.println("参数 : " + Arrays.toString(proceedingJoinPoint.getArgs()));
        System.out.println("被代理对象 : " + proceedingJoinPoint.getTarget());

        try {
            // 真实业务代码，这里是伪代码
            Object o = proceedingJoinPoint.proceed();
            System.out.println("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}

