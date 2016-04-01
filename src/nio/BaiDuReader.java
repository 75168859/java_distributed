package nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class BaiDuReader {
	private Charset charSet = Charset.forName("GBK");
	private SocketChannel channel;

	/**
	 * @param args
	 */
	public  void readHTML() {
		// TODO Auto-generated method stub
		try {
			InetSocketAddress address = new InetSocketAddress("www.baidu.com",80);
			channel = SocketChannel.open(address);
			 //step2:发送请求，使用GBK编码   
			channel.write(charSet.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));   
			//step3:读取数据   
			// 创建1024字节的缓冲  
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while(channel.read(buffer)!=-1){
				buffer.flip();
				System.out.println(charSet.decode(buffer));
				buffer.clear();
			}
		    channel.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		new BaiDuReader().readHTML();
	}

}
