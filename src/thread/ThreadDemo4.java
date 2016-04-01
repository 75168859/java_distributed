package thread;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadDemo4 {
	public static void main(String[] args) {
		final Output output = new Output();
		final Output output1 = new Output();
		new Thread(new Runnable() {
			@Override
			public void run() {
			   while(true){
				   output.print("hello");
			   }
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
			   while(true){
				   output.print3("WORLD");
			   }
			}
		}).start();
	}
}
class Output{
	public void print(String name){
		/*
		 *   java�е�ÿ��������һ��������ֻ��һ��Կ��
		 *   �߳�Ҫͬ����Ҫ��֤����̹߳���ͬһ����
		 */
		synchronized (Output.class) {
			for(int i = 0; i <name.length();i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();	
		}
	}
	//ͬ������Ҳ���ж����������������˭��?�����ǵ�ǰ����
	public synchronized void print1(String name){
		for(int i = 0; i <name.length();i++){
			System.out.print(name.charAt(i));
		}
		System.out.println();	
	}
	//��̬�ķ���Ҳ�������ģ�����˭?������(class type)-->�ֽ���
	//��̬��������  ���Ƿ����������������
	public static synchronized void print2(String name){
		for(int i = 0; i <name.length();i++){
			System.out.print(name.charAt(i));
		}
		System.out.println();	
	}
	//java5֮��  ֱ����������
	Lock lock = new ReentrantLock();
	public  void print3(String name){
		lock.lock();
        try {
    		for(int i = 0; i <name.length();i++){
    			System.out.print(name.charAt(i));
    		}
    		System.out.println();	
		} finally{
			lock.unlock();
		}
	}
}
class Cache{
	private HashMap<String, String> cache = new HashMap<String, String>();
	//����ʱ�������̶߳�����ֱ�ӷ��ʣ�ֻҪ��һ���߳��޸����ݣ�����Ҫ����
	private ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();
	private String value;
	public String getValue(String key){
		rrw.readLock().lock();
	    try{
	    	value = cache.get(key);
	    	if(value==null){
	    		rrw.readLock().unlock();
	    		rrw.writeLock().lock();
	    		try{
	    			if(value==null){
	    				value = "hello";
	    				cache.put(key, value);
	    				
	    			}
	    		}finally{
	    			rrw.writeLock().unlock();
	    			rrw.readLock().lock();
	    		}
	    	}
	    }finally{
	    	rrw.readLock().unlock();
	    }
	    return value;
	}
}
