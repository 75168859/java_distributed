package base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {
	public static void main(String[] args) {
		Client1 client1 = new Client1();
		client1.startClient();
	}
	public void startClient(){
		try {
			Socket socket = new Socket("127.0.0.1",9000);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			new AcceptData(socket);
			while(true){
				String str = br.readLine();
				if("exit".equals(str))break;
				out.println(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class AcceptData extends Thread {
	private Socket socket;
	private BufferedReader br;
	public AcceptData(Socket socket) {
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.start();
	}

	public void run() {
		try {
			while (true) {
				String str = br.readLine();
				if("".equals(str)||str==null){
					continue;
				}
				if("exit".equals(str)){
					System.out.println("有客户端退出...");
				}
				int index = str.indexOf("/");
				if(index==-1){//群聊的内容
					System.out.println("群聊的内容是:"+str);
				}else{//私聊的内容
					String[] message = str.split("/");
					System.out.println(message[0]+"对我说:"+message[1]);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
