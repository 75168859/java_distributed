package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutrue {
	public static void main(String[] args) {

		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
		for (int i = 0; i < 10; i++) {
			final Integer seq = i + 1;
			completionService.submit(new Callable<Integer>() {

				public Integer call() throws Exception {
					try {
						Thread.sleep((long) (Math.random() * 1000));
					} catch (Exception e) {
					}
					return seq;
				}

			});
		}

		try {
			for (int i = 0; i < 10; i++) {
				Future<Integer> f = completionService.take();
				System.out.println(f.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
