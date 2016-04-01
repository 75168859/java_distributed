package mina;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;


public class Demo1Server {

	private static Logger logger = Logger.getLogger(Demo1Server.class);
	private static final int PORT = 3005;

	public static void main(String[] args) {
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.addListener(new ServerListener());
		acceptor.getFilterChain().addLast(
				"codec",
				new ProtocolCodecFilter(new MyTextLineCodecFactory()));
		// 设置读取数据的缓冲区大小
		acceptor.getSessionConfig().setReadBufferSize(2048);
		// 读写通道10秒内无操作进入空闲状态
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		// 绑定逻辑处理起器
		acceptor.setHandler(new Demo1ServerHandler());
		// 绑定端口
		try {
			acceptor.bind(new InetSocketAddress(PORT));
			logger.info("服务器启动成功。。。。端口为：" + PORT);
		} catch (IOException e) {
			logger.error("服务器启动异常。。。。", e);
			e.printStackTrace();
		}
	}
}
