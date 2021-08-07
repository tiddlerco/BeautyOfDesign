package design.structure.proxy.aliaspect.annotation;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 该切面在埋点对象的方法执行前，调用埋点对象的会话校验方法校验对象是否处于会话状态，如果不处于会话状态则抛出异常停止调用。
 */
@Aspect
@Component
public class PersistenceAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext context;

    //切面拦截module包下所以类的所以public方法
    @Pointcut("execution(public * design.structure.proxy.aliaspect.module.*.*(..))")
    public void domainModelImpl() {
    }

    @After(value = "domainModelImpl() && @annotation(persistence)")
    public void doDomainModelImplAfter(JoinPoint joinPoint, Persistence persistence) throws Exception {
        //注解标注的repositoryName    首字母小写
        String repositoryName = StringUtils.uncapitalize(persistence.repositoryName());
        //注解标注的方法
        String method = persistence.method();
        //获得被代理的对象 这里用于45行 获取getMethod里的父对象入参
        //ModuleRepository
        Object proxyObject = joinPoint.getTarget();

        //根据className在容器中获取bean对象
        Object beanName = this.context.getBean(repositoryName);
        //这里利用反射，第二个参数是方法入参对象的class对象。这里是一种特殊情况，入参是当前对象的父对象class
        Method methodName = proxyObject.getClass().getMethod(method, beanName.getClass().getSuperclass());
        //被代理的对象 需要执行的是ModuleRepositoryimpl的父类ModuleRepository的add方法
        // 方法入参是实体类对象Module  传入的参数是被代理的对象EdgeCloudInfModule,继承自Module
        methodName.invoke(beanName, proxyObject);

    }

}
