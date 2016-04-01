package prototype;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		Address address = new Address();
		user.setAddress(address);
		try {
			//User user1 =(User) user.clone();
			User user1 = (User)user.deepClone();
			System.out.println(user==user1);
			System.out.println(user.getAddress()==user1.getAddress());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
