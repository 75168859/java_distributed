package base;

public interface UserService {
	public User logon(int id,String password)throws IdPassException;
	public void update();
}
