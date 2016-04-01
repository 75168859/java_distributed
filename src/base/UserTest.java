package base;

public class UserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserServiceImpl us = new UserServiceImpl();
		EntityContext entityContext = new EntityContext();
		us.setEntityContext(entityContext);
//		try {
//			User user = us.logon(10001, "12345");
//			System.out.println(user);
//		} catch (IdPassException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    UserServiceProxy up = new UserServiceProxy();
		try {
			User user =up.logon(10002, "12345");
			System.out.println(user.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		   System.out.println(e.getMessage());
		}

	}

}
