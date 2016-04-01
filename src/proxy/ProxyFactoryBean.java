package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理处理器
public class ProxyFactoryBean implements InvocationHandler {
	private Object target;// 目标对象
    public void setTarget(Object target) {
		this.target = target;
	}
    
	// 这个对象的任何方法调用都会被invoke方法拦截
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("权限、日志、事务处理....");
		//method.invoke(target, args);
		System.out.println("方法执行完成后的日志、事务处理");
		return null;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}

}
