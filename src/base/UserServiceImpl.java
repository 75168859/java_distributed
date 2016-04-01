package base;

public class UserServiceImpl implements UserService{
	private EntityContext entityContext;
	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	@Override
	public User logon(int id, String password) throws IdPassException {
		// TODO Auto-generated method stub
		//System.out.println(entityContext);
		User user = entityContext.getUsers().get(id);
		if(user==null){
			throw new IdPassException(id+" is not exits");
		}
		if(!password.equals(user.getPass())){
			throw new IdPassException("password is error");
		}
		return user;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
