package base;

import java.io.Serializable;

public class Response implements Serializable {
	private String sessionId;
	private Object obj;
	private Exception exception;
	private boolean success;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess() {
		this.success = this.exception==null;
	}
	
}
