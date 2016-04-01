package mina;
import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;



public class Demo2Client {

	private Logger logger = Logger.getLogger(Demo2Client.class);
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 3005;

	public static void main(String[] args) {
		// 创建一个非阻塞的客户端程序
		IoConnector connector = new NioSocketConnector();
		// 设置连接超时时间 单位毫秒
		connector.setConnectTimeout(30000);
		// 添加过滤器
		connector.getFilterChain().addLast(
				"codec",
				new ProtocolCodecFilter(new MyTextLineCodecFactory()));
		// 添加业务逻辑处理类
		connector.setHandler(new Demo2ClientHandler());
		// 创建连接
		IoSession session = null;
		try {
			ConnectFuture connect = connector.connect(new InetSocketAddress(
					HOST, PORT));
			// 等待连接创建完成
			connect.awaitUninterruptibly();
			// 获取session
			session = connect.getSession();
			session.write("我爱你，mina！！！！");
		} catch (Exception e) {
			System.out.println("客户端连接异常");
		}
		session.getCloseFuture().awaitUninterruptibly();
		connector.dispose();
	}
}
