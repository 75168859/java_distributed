package thread;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {
	DaoSupport<User> userdao = new DaoSupport<User>();
	public List<User> getAllUsers(){
		return userdao.getAll("select * from user where age =? and name=?", new UserRM(),30,"zhangsan");
	}
	public User findById(String id){
		return userdao.findById(id, "select * from user where id=?", new UserRM());
	}
	class UserRM implements RowMapper<User>{

		@Override
		public User getRow(ResultSet rs) throws SQLException {
		     User user = new User();
		     user.setId(rs.getInt("id"));
		     user.setAge(rs.getInt("age"));
		     
		     
		     return user;
		}
		
	}
}
