package reflect;

import java.lang.reflect.Method;

public class MethodDemo1 {
	public static void main(String[] args) {
		try {
			UserService us = new UserService();
			Class c = us.getClass();
			us.add("hello", "world");
			Method m = c.getMethod("add", String.class, String.class);
			String s = (String) m.invoke(us, "hello", "world");
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 标准的javaBean1.无参数的构造函数2.所有属性都有getter/setter方法
	 * 
	 * @param propertyName
	 *            标准javaBean的属性名称
	 * @param obj
	 *            标准javaBean对象
	 * @return 这个属性的值
	 */
	public static Object getValue(String propertyName, Object obj) {
		Class c = obj.getClass();
		String methodName = "get" + propertyName.substring(0, 1).toUpperCase()
				+ propertyName.substring(1);
	    try {
	    	Method m = c.getMethod(propertyName);
	    	return m.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}

class UserService {
	public String add(String a, String b) {
		return a + b;
	}

	public int add(int a, int b, int c) {
		return a + b + c;
	}
}