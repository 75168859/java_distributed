package base;

public class UserServiceProxy implements UserService {

	@Override
	public User logon(int id, String password) throws IdPassException {
		Request request = new Request("logon", new Class[]{int.class, String.class},new Object[]{id,password});
		Response response = (Response)SocketUtil.remoteCall(request);
		if(!response.isSuccess())throw new RuntimeException(response.getException().getMessage());
	    User user = (User)response.getObj();
	    return user;
	}

	@Override
	public void update() {
		//首先要包装sessionId;
		Request reqeust = new Request();
	//reqeust.setSessionId(sessionId);
		
	}
	
}
