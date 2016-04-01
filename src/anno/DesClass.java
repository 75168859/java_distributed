package anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*这是一个注解的实例化
 * 注解的实例化其实就是@注解(方法名1=返回值,方法名2=返回值... ...)
 * 当注解实例化时，如果方法只要用一个且名称为value,那么value=可以省略
 */
@Target(ElementType.TYPE)//写一个注解首先需要声明注解用来修饰谁?
@Retention(RetentionPolicy.RUNTIME)//注解什么时候有效
public @interface DesClass {
	String testClass() default "";
	int[]  getArray();
}
