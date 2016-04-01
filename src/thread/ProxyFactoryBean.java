package thread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactoryBean implements InvocationHandler{
	private Object target;
	public void setTarget(Object target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
	      //开启事务
		TransactionManager.begin();
		try {
			method.invoke(target, args);
			//事务提交
			TransactionManager.commit();
		} catch (Exception e) {
			//回滚事务
			TransactionManager.rollback();
		}finally{
			//关闭连接 
			JdbcUitl.close(JdbcUitl.getConn());
		}
		return null;
		
	}
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

}
