package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 *  万事万物皆对象，类是不是对象呢？当然是
 *  类是谁的对象呢？java.lang.Class
 *  这个对象如何表示呢?3中方式
 */
public class ClassDemo {
	public static void main(String[] args) {
		
		
		Class c = A.class;
		A a = new A();
		Class c2 = a.getClass();
		try {
			Class c3 = Class.forName("reflect.A");//也代表了动态加载类
			System.out.println(c==c2);
			System.out.println(c2==c3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("====================");
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
	    Class cc1 = list.getClass();
	    Class cc2 = list1.getClass();
	    System.out.println(cc1==cc2);
	    /*上一行打印true，说明java编译后是去泛型化的
	     * java的泛型只在编译阶段有效，是为了防止错误
	     * 输入，如果绕过编译，就可以绕过泛型
	     * 反射的操作都是绕过编译的。
	      */
	    list.add("hello");
	    try {
			Method m = cc1.getMethod("add", Object.class);
			m.invoke(list, 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println(list.size());
	  /*  for(String string :list){
	    	System.out.println(string);
	    }*/
	    
	    Class cc3 = int.class;
	    Class cc5 = Integer.class;
	    Class cc4 = void.class;
	}
}
class A{
	
}
