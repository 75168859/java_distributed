package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {
	private static int flag = 0;
	private static int BLOCK = 4096;
	private static ByteBuffer sendBuffer = ByteBuffer.allocate(BLOCK);
	private static ByteBuffer receiveBuffer = ByteBuffer.allocate(BLOCK);
	private static final InetSocketAddress SERVER_ADDRESS = new InetSocketAddress("localhost",8888);
	public static void main(String[] args)throws IOException{
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		Selector selector = Selector.open();
		socketChannel.register(selector,SelectionKey.OP_CONNECT);
		socketChannel.connect(SERVER_ADDRESS);
		Set<SelectionKey> selectionKeys;
		SelectionKey selectionKey ;
		Iterator<SelectionKey> iterator;
		SocketChannel client;
		String receiveText;
		String sendText;
		int count = 0;
		int i = 0;
		while(true){
			selector.select();
			selectionKeys = selector.selectedKeys();
			iterator = selectionKeys.iterator();
			while(iterator.hasNext()){
				selectionKey = iterator.next();
				if(selectionKey.isConnectable()){
					System.out.println("connect client..");
					client = (SocketChannel)selectionKey.channel();
					if(client.isConnectionPending()){
						client.finishConnect();
						System.out.println("完成连接!");
						sendBuffer.clear();
						sendBuffer.put("Hello Server".getBytes());
						sendBuffer.flip();
						client.write(sendBuffer);
					}
					client.register(selector, SelectionKey.OP_READ);
				}else if(selectionKey.isReadable()){
					client = (SocketChannel)selectionKey.channel();
					receiveBuffer.clear();
					count = client.read(receiveBuffer);
					if(count > 0){
						receiveText = new String(receiveBuffer.array(),0,count);
						System.out.println("客户端接收服务器端数据:"+receiveText);
						client.register(selector,SelectionKey.OP_WRITE);
					}
				}else if(selectionKey.isWritable()){
					sendBuffer.clear();
					client = (SocketChannel)selectionKey.channel();
					sendText = "message from client:"+flag++;
					sendBuffer.put(sendText.getBytes());
					sendBuffer.flip();
					client.write(sendBuffer);
					System.out.println("客户端向服务器发送数据:"+sendText);
					client.register(selector, SelectionKey.OP_READ);
				}
			}
			selectionKeys.clear();
		}
		
	}

}
