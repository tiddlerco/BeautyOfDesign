package design.structure.proxy.annotationAop;


import java.lang.annotation.*;

/**
 * 利用AOP实现自定义注解
 * <p>
 * 对用户的某些操作进行监控，操作记录要写入数据库，
 * 首先想到了使用Filter过滤器和Spring的Interceptor(拦截器)，
 * 这两种都需要复杂的配置（能用代码解决的问题绝不上手）
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented

public @interface EagleEye {

    String desc() default "";

}

