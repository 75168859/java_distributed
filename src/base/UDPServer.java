package base;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	public static void main(String[] rrgs) throws IOException {
		DatagramSocket socket = new DatagramSocket(14567);
		while (true) {
			
			byte data[] = new byte[1024];
			// 创建一个空的DatagramPacket对象
			DatagramPacket packet = new DatagramPacket(data, data.length);
			// 使用receive方法接收客户端所发送的数据，
			// 如果客户端没有发送数据，该进程就停滞在这里
			socket.receive(packet);
			String result = new String(packet.getData(), packet.getOffset(),
					packet.getLength());
			System.out.println("result--->" + result);
		}

	}

}