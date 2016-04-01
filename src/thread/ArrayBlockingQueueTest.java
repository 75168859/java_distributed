package thread;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayBlockingQueueTest {
	public static void main(String[] args) {
		
		final Bus4 bus = new Bus4();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1 ;i <= 50;i++){
					bus.send();
				}
			}
		}).start();
new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1 ;i <= 50;i++){
					bus.rec();
				}
			}
		}).start();
	}

}
class Bus4{

	BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
	BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);
	//定义初始化快
	{
		try {
			queue2.put(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void send(){
		try {
			queue1.put(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1; i <= 10;i++){
			System.out.println("老大循环"+i+"次");
		}
		try {
			queue2.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rec(){
		try {
			queue2.put(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1; i <= 20;i++){
			System.out.println("老二循环"+i+"次");
		}
		try {
			queue1.take();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
