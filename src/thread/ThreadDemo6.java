package thread;

import java.util.Random;

public class ThreadDemo6 {
	public static void main(String[] args) {
		final Business bus = new Business();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				bus.send();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				bus.rec();
			}
		});
		t2.setDaemon(true);
		t1.start();
		t2.start();
	}
}
class Business{
	private int thevalue;
	private boolean flag;
	public void send(){
		for(int i = 1; i <= 5;i++){
		     synchronized (this) {
				while(flag){
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				thevalue = new Random().nextInt();
				System.out.println("send the value is :"+thevalue);
				flag = true;
				this.notify();
			}
		}
	}
	public void rec(){
		while(true){
			synchronized (this) {
				while(!flag){
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("recevier the value is:"+thevalue);
				flag = false;
				this.notify();
			}
		}
	}
}
