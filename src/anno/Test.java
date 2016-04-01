package anno;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<U> hs = new HashSet<U>();
		U u1 = new U(1000,"zhangsan",30);
		U u2 = new U(2000,"wangwun",30);
		hs.add(u1);
		hs.add(u2);
		System.out.println(hs.size());
		u1.setId(500);
		hs.remove(u1);
		System.out.println(hs.size());
	
		/*HashMap<U, String> hm = new HashMap<U, String>();
		hm.put(u1, "hello");
		System.out.println(hm.get(u1));
		u1.setId(10000);
		System.out.println(hm.get(u1));*/
		String s = "hello"+"world";
		String s1 = "helloworld";
		System.out.println(s==s1);
		String s2 = "hello";
		String s3 = s2 +"world";//new StringBuilder(s2).appendTo("world");
		System.out.println(s1==s3);

	

	}

}
class U{
	private int id;
	private String name;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public U(){}
	public U(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
		U other = (U) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
