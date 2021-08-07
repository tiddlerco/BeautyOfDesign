package design.structure.proxy.aliaspect.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 领域对象方法需要资源库增改删方法做持久化操作时
 * 可以通过该标签声明资源库和调用的方法
 */
@Retention(RUNTIME)
@Target(METHOD)
@Inherited
public @interface Persistence {
	/**
	 * 持久化调用的资源库Bean名称
	 * @return
	 */
	String repositoryName() default "";
	
	/**
	 * 持久化调用的资源库内的方法名
	 * @return
	 */
	String method() default "";
}
