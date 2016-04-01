package proxy;

public class PersonServiceImpl implements PersonService{

	@Override
	public void delete() {
		//权限、日志、事务处理等
		System.out.println("delete...");
		//权限、日志、事务提交
	}

	@Override
	public void update() {
		System.out.println("udapte...");
	}

}
