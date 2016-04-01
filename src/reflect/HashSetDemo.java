package reflect;

import java.util.HashSet;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u1 = new User(1,"zhangsan",30);
		User u2 = new User(2,"lisi",30);
		HashSet<User> hs = new HashSet<User>();
		hs.add(u1);
		hs.add(u2);
		System.out.println(hs.size());
		u1.setId(1000);
		hs.remove(u1);
		System.out.println(hs.size());

	}

}
class User{
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	private String name;
	private int age;
	public User(){}
	
	public User(int id,String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
