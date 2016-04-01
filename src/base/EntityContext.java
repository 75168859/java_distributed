package base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class EntityContext {
	private HashMap<Integer, User> users = new HashMap<Integer, User>();

	public EntityContext() {
		loadUsers();
	}

	public void loadUsers() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					"d:/users.txt")));
			String str = null;
			while ((str = br.readLine()) != null) {
				User u = new User();
				u.setUid(Integer.parseInt(str.split(":")[0]));
				u.setName(str.split(":")[1]);
				u.setPass(str.split(":")[2]);
				u.setEmail(str.split(":")[3]);
				users.put(u.getUid(), u);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<Integer, User> getUsers() {
		return users;
	}

}
