package thread;

import java.util.Random;

public class ThreadDemo5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Send send = new Send();
		Receiver r = new Receiver(send);
		Thread t1 = new Thread(send);
		Thread t2 = new Thread(r);
		t2.setDaemon(true);//守护线程
		t1.start();
		t2.start();
	}
}
/*模型*/
class Send implements Runnable{
	int thevalue;
	boolean flag;
	@Override
	public void run() {
		for(int i = 1; i <= 5;i++){
			synchronized (this) {
				while(flag){
					try {
						this.wait();//wait会释放钥匙
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				thevalue = new Random().nextInt(10000);
				System.out.println("send thevalue is:"+thevalue);
				flag = true;
				this.notify();
			}
		}
	}
}
class Receiver implements Runnable{
	private Send send;
	public Receiver(Send send){
		this.send = send;
	}
	@Override
	public void run() {
		while(true){
			synchronized (send) {
				while(!send.flag){
					try {
						send.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("receiver the value is:"+send.thevalue);
				send.flag = false;
				send.notify();
			}
		}
	}
	
}
