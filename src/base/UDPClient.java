package base;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) {
		try {
			// 首先创建一个DatagramSocket对象
			DatagramSocket socket = new DatagramSocket();
			// 创建一个InetAddree
			InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
			String str = "hello"; // 这是要传输的数据
			byte data[] = str.getBytes(); // 把传输内容分解成字节
			// 创建一个DatagramPacket对象，并指定要讲这个数据包发送到网络当中的哪个、地址，以及端口号
			DatagramPacket packet = new DatagramPacket(data, data.length,
					serverAddress, 14567);
			// 调用socket对象的send方法，发送数据
			socket.send(packet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
