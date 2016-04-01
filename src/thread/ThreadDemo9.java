package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo9 {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
	  
		Future<String> future=	threadPool.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				Thread.sleep(5000);
				return "hello";
			}
		});
	    try {
			System.out.println(future.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}

}
