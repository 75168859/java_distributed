package mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServer {
	public static void main(String[] args) {
		try {
			/*
			 * 第一步：编写IoService 初始化了服务端的TCP/IP 的基于NIO 的套接字，
			 * 然后调用IoSessionConfig设置读取数据的缓冲 区大小、读写通道均在10 秒内无任何操作就进入 空闲状态。
			 */
			IoAcceptor acceptor = new NioSocketAcceptor();
			acceptor.getSessionConfig().setReadBufferSize(2048);
			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
			

			/*
			 * 第二步：编写过滤器
			 */
			acceptor.getFilterChain().addLast(
					"codec",
					new ProtocolCodecFilter(new TextLineCodecFactory(Charset
							.forName("UTF-8"),
							LineDelimiter.WINDOWS.getValue(),
							LineDelimiter.WINDOWS.getValue())));

			// 第三步：编写IoHandler  MyIoHandler
			
			//注册
			acceptor.setHandler(new MyIoHandler());

			
			acceptor.bind(new InetSocketAddress(8000));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

class MyIoHandler extends IoHandlerAdapter {
	// 这里我们使用的SLF4J作为日志门面，至于为什么在后面说明。
	private final static Logger log = LoggerFactory
			.getLogger(MyIoHandler.class);

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String str = message.toString();
		System.out.println(str);
		log.info("The message received is [" + str + "]");
		if (str.endsWith("quit")) {
			session.close(true);
			return;
		}
	}
	
	
}