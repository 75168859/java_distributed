package anno;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		//如何获取注解   类的注解用Class，方法的注解Method,成员变量的注解Field
		Class c = A.class;
		//获取注解的实例
		DesClass dc = (DesClass)c.getAnnotation(DesClass.class);
		System.out.println(dc.testClass());
		System.out.println(Arrays.toString(dc.getArray()));
		
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			DesField df = field.getAnnotation(DesField.class);
			if(df!=null){
				System.out.println(df.getName());
			}
		}
		
	}
}
@DesClass(testClass="这是类A",getArray={1,2,3})
class A{
	@DesField(getName="姓名")
	private String name;
	@DesField(getName="年龄")
	private int age;
	

}
