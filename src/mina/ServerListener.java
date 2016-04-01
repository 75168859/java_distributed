package mina;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ServerListener implements IoServiceListener {

	@Override
	public void serviceActivated(IoService service) throws Exception {
		System.out.println("service Ativated.............");
	}

	@Override
	public void serviceDeactivated(IoService arg0) throws Exception {
		System.out.println("service deactivated.............");
	}

	@Override
	public void serviceIdle(IoService arg0, IdleStatus arg1) throws Exception {
		System.out.println("session idle............."+ arg1.toString());

	}

	@Override
	public void sessionCreated(IoSession arg0) throws Exception {
		System.out.println("session created.............");
	}

	@Override
	public void sessionDestroyed(IoSession arg0) throws Exception {
		System.out.println("session destroyed.............");
	}

}
