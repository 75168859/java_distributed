package mina;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class Demo1ServerHandler extends IoHandlerAdapter{
    Logger logger = Logger.getLogger(Demo1ServerHandler.class);
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		logger.info("服务器发送信息异常....");
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String msg =message.toString();
		System.out.println(msg);
		logger.info("服务端接受到得数据为：" + message);
		if("bye".equals(msg)){
			session.close();
		}
		Date date = new Date();
		session.write(date);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
        //发送消息成功之后，关闭session，即关闭与客户端的连接，短连接方式
		//session.close();
		logger.info("服务器发送信息成功....");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		logger.info("服务端与客户端创建连接.....");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		logger.info("服务器进入空闲状态....");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("服务端与客户端连接打开.....");
	}

}
