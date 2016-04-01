package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JButton;

public class ClassDemo2 {
	public static void main(String[] args) {
		//String s = "hello";
		JButton button = new JButton("aa");
		printClassMessage(button);
	}
	public static void printClassMessage(Object obj){
		Class c = obj.getClass();//传递的是哪个类的对象就获取得是哪个类的类类型
	    String className = c.getName();//c.getSimpleName();
	    Method[] ms = c.getMethods();//c.getDeclaredMethods();
	    for (Method method : ms) {
	    	//返回值类型
			Class returnType = method.getReturnType();
			System.out.print(returnType.getName()+"  "+method.getName()+"(");
			//参数列表
			Class[] paramTypes = method.getParameterTypes();
			for(int i = 0; i <paramTypes.length;i++){
				System.out.print(paramTypes[i].getName()+",");
			}
			System.out.print(")");
			System.out.println();
		}
	    System.out.println("======================");
	    Field[] fs = c.getDeclaredFields();//c.getFields();
	    for (Field field : fs) {
			Class fieldType = field.getType();
			System.out.println(fieldType.getName()+"  "+field.getName());
		}
	}
}

