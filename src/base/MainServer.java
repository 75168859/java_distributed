package base;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

public class MainServer {
	private static EntityContext entityContext ;
	public static void setEntityContext(EntityContext entityContext) {
		MainServer.entityContext = entityContext;
	}
	private static  HashMap<String, UserServiceImpl> service = new HashMap<String, UserServiceImpl>();
    public static Object invokeMethod(UserServiceImpl us,Request request)throws Exception{
    	Class c = us.getClass();
        try {
        	Method m = c.getMethod(request.getMethodName(), request.getParamTypes());
			Object obj = m.invoke(us, request.getObjs());
			return obj;
		} catch (InvocationTargetException e) {
		     throw new RuntimeException(e.getTargetException());
		}catch(Exception e){
			throw e;
		}
		
    }
	public static UserServiceImpl getService(Request request){
		String sessionId = request.getSessionId();
		if(sessionId==null){
			UserServiceImpl us = new UserServiceImpl();
			us.setEntityContext(entityContext);
			sessionId = UUID.randomUUID().toString();
			service.put(sessionId, us);
			request.setSessionId(sessionId);
		}
		return service.get(sessionId);
	}
	public static Request getRequest(Socket socket){
		try {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			return (Request)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	static class MyThread extends Thread{
		private Socket socket;
		public MyThread(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			Response response = new Response();
			ObjectOutputStream oos = null;
			try {
				Request request = getRequest(socket);
				UserServiceImpl us = getService(request);
				response.setSessionId(request.getSessionId());
				Object obj = invokeMethod(us, request);
				response.setObj(obj);
			} catch (Exception e) {
			    response.setException(e);
			}finally{
				try {
					response.setSuccess();
					oos = new ObjectOutputStream(socket.getOutputStream());
				    oos.writeObject(response);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(9000);
			System.out.println("¿ªÆô·þÎñ...");
			EntityContext entityContext = new EntityContext();
			MainServer.setEntityContext(entityContext);
			while(true){
				Socket socket = s.accept();
				new MyThread(socket).start();
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}


