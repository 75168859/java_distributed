package reflect;

import java.lang.ref.SoftReference;

public class Test {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner = null;
		
		A a1 = new A();
		SoftReference<A> x = new SoftReference<A>(a1);
	    a1 = null;
	   
	    
	}
}
class Outer{
	class Inner{
		void innertest(){
			System.out.println("inner world");
			Outer.this.test();
		}
	}
	void test(){
		System.out.println("helloworld");
	}
}
