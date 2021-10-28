package alidesign.proxy.aopframe.annotation;

/**
 * @Author 喻可
 * @Date 2021/10/28 15:57
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于异常处理的注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionHandleAnno { }
