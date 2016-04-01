package thread;

public class ThreadDemo3 {
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		t1.start();
		try {
		  t1.join();//主线程等待t1线程运行结束
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1; i <=10;i++){
			System.out.println("hello");
		}
	}
}
class MyThread1 extends Thread{
	@Override
	public void run() {
		for(int i = 1; i <= 10;i++){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("world");
		}
	}
}