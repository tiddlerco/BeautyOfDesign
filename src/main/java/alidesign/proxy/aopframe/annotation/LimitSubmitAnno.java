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
 * 用于登录限制
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LimitSubmitAnno {

    /**
     * 单位时间
     */
    int unitTime() default 3;

    /**
     * 调用次数
     */
    int count() default 1;
}
