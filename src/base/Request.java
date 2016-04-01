package base;

import java.io.Serializable;

public class Request implements Serializable {
	private static final long serialVersionUID = 1L;
	private  String sessionId;
	private String methodName;
	private Class[] paramTypes;
	private Object[] objs;
	public Request (){}
	public Request(String methodName, Class[] paramTypes, Object[] objs) {
		super();
		this.methodName = methodName;
		this.paramTypes = paramTypes;
		this.objs = objs;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Class[] getParamTypes() {
		return paramTypes;
	}
	public void setParamTypes(Class[] paramTypes) {
		this.paramTypes = paramTypes;
	}
	public Object[] getObjs() {
		return objs;
	}
	public void setObjs(Object[] objs) {
		this.objs = objs;
	}
	
}
