package thread;

class ServiceProxy implements Service {
	public ServiceProxy() {
		_service = new ServiceImp();
		_active_object = new ActiveObject();
	}

	public void sayHello() {
		//包装成队列期望看到的类型 ---->对象适配器
		MethodRequest mr = new SayHello(_service);
		//扔到队列里去
		_active_object.enqueue(mr);
	}
	
	

	private Service _service;
	private ActiveObject _active_object;
}
