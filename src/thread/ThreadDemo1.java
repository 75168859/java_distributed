package thread;

public class ThreadDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					System.out.println("hello");
				}
			}
		}).start();
		new Thread(){
			public void run() {
				while(true){
					System.out.println("world");
				}
			}
			
		}.start();
	}

}
