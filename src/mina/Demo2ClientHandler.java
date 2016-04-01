package mina;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class Demo2ClientHandler extends IoHandlerAdapter{

	private Logger logger = Logger.getLogger(Demo2ClientHandler.class);

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		logger.info("客户端发送信息异常....");
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String msg = message.toString();
		System.out.println("客户端接收到的消息为：" + msg);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		String msg = message.toString();
		System.out.println("客户端发送的消息为：" + msg);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		logger.info("客户端与服务端断开连接.....");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		logger.info("客户端与服务端创建连接.....");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		logger.info("客户端进入空闲状态....");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("客户端与服务端连接打开.....");
	}
	
}
