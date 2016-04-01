package reflect;

import java.lang.reflect.Field;
class Person{
	private String name = "zhangsan";
	private int age = 30;
	private double h = 175;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+","+age+","+h;
	}
}
public class FieldDemo {
	public static void main(String[] args) {
	    Person p = new Person();
	    changeValue(p);
	    System.out.println(p);
	}
	/**
	 * 如果该对象有字符串属性，把字符串属性值都大写
	 * 如果有整数属性，把整数都加100
	 * @param obj
	 */
	public static void changeValue(Object obj){
		Field[] fs = obj.getClass().getDeclaredFields();
		try {
			for (Field field : fs) {
				if(field.getType()==String.class){
					field.setAccessible(true);
					String oldValue =(String) field.get(obj);
					field.set(obj, oldValue.toUpperCase());
				}
				if(field.getType()==int.class){
					field.setAccessible(true);
					int oldValue = (Integer)field.get(obj);
					field.set(obj, oldValue+100);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
