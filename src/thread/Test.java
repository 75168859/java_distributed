package thread;

public class Test {
	public static void main(String[] args) {
		C c = new C();
	}
}
/*
 * 什么this:调用这个函数的那个对象（的引用)
 * 哪有this:一个非静态的成员函数访问另外一个非静态的成员都省略了this
 */
class B{
	B(){this.test();}
	public void test(){
		System.out.println("hello");
	}
}
class C extends B{
//	private int i = 11;
	private int i ;
	{i = 11;}
	public void test() {
		System.out.println(i);
	}
}
