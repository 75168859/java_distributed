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
		 *   java中的每个对象都是一把锁有且只有一把钥匙
		 *   线程要同步，要保证多个线程共用同一把锁
		 */
		synchronized (Output.class) {
			for(int i = 0; i <name.length();i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();	
		}
	}
	//同步函数也是有对象锁，那这个锁是谁呢?锁就是当前对象
	public synchronized void print1(String name){
		for(int i = 0; i <name.length();i++){
			System.out.print(name.charAt(i));
		}
		System.out.println();	
	}
	//静态的方法也是有锁的，锁是谁?类类型(class type)-->字节码
	//静态方法的锁  就是方法所属类的类类型
	public static synchronized void print2(String name){
		for(int i = 0; i <name.length();i++){
			System.out.print(name.charAt(i));
		}
		System.out.println();	
	}
	//java5之后  直接有锁对象
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
	//读的时候所有线程都可以直接访问，只要有一个线程修改数据，就需要互斥
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
