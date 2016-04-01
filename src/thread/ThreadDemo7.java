package thread;

import java.util.HashMap;
import java.util.Random;

public class ThreadDemo7 {
	private static HashMap<Thread, Integer> hm = new HashMap<Thread, Integer>();
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
	public static void main(String[] args) {
		for(int i = 1; i <= 2;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt(1000);
					hm.put(Thread.currentThread(), data);
					tl.set(data);
					System.out.println(Thread.currentThread().getName()+"put the data is:"+data);
					A a1 = new A();
					a1.getData();
					B b1 = new B();
					b1.getData();
				}
			}).start();
		}
	}
	static class A{
		void getData(){	
			int data = hm.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+"from A getData is:"+data+"from ThreadLocal"+tl.get());
		   
		}
	}
	static class B{
		void getData(){	
			int data = hm.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+"from B getData is:"+data+"from ThreadLocal"+tl.get());
		}
	}
}

