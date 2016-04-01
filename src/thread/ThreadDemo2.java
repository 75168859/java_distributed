package thread;

public class ThreadDemo2 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();
		try {
			//t1.sleep(10000);
			Thread.sleep(10000);//哪个线程执行到sleep哪个线程就sleep
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1; i <=10;i++){
			System.out.println("hello");
		}
	}
}
class MyThread extends Thread{
	@Override
	public void run() {
		for(int i = 1; i <= 10;i++){
			System.out.println("world");
		}
	}
}