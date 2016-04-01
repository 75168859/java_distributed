package proxy;

public class PersonServiceProxy implements PersonService {
	private PersonServiceImpl ps ;
	public void setPs(PersonServiceImpl ps) {
		this.ps = ps;
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("方法执行前的日志、事务、权限等处理...");
		ps.delete();
		System.out.println("方法执行后的日志、事务、权限等处理...");
	}

	@Override
	public void update() {
		System.out.println("方法执行前的日志、事务、权限等处理...");
		ps.update();
		System.out.println("方法执行后的日志、事务、权限等处理...");
		
	}

}
