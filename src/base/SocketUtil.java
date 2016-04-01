package base;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketUtil {
	public static Response remoteCall(Request request){
		try {
			Socket socket = new Socket("127.0.0.1",9000);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(request);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			return (Response)ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
