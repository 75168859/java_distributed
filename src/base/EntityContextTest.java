package base;

import java.util.HashMap;

public class EntityContextTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    EntityContext entityContext  = new EntityContext();
	    HashMap<Integer,User> users = entityContext.getUsers();
	    for(Integer key : users.keySet()){
	    	System.out.println(users.get(key));
	    }
	}

}
