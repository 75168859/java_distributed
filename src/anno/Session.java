package anno;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Session {
	public static void main(String[] args) {
		Session session = new Session();
		System.out.println(session.getSql(new User()));
	}
	/*
	 * 类---->表 属性--->列 对象--->记录
	 */
	public void save(Object obj) throws Exception{
		/*
		 * 1.生成sql语句 insert into 表名(字段1,字段2...)values(?,?...)
		 * 2.假设表名和类名相同，属性名和列名相同
		 */
		Connection con = null;
		PreparedStatement pstmt = getStatement(con, obj);
		pstmt.executeUpdate();
	}
	public PreparedStatement getStatement(Connection con,Object obj)throws Exception{
		PreparedStatement pstmt = con.prepareStatement(getSql(obj));
		Field[] fs = obj.getClass().getDeclaredFields();
		for(int i = 0; i < fs.length;i++){
			fs[i].setAccessible(true);
			pstmt.setObject(i+1, fs[i].get(obj));
		}
		return pstmt;
	}

	public String getSql(Object obj) {
		StringBuffer s = new StringBuffer();
		s.append("insert into ");
		Class c = obj.getClass();
		String tablename = c.getSimpleName();
		Entity entity = (Entity)c.getAnnotation(Entity.class);
		if(entity!=null)
			tablename = entity.value();
		s.append(tablename).append("(");
		Field[] fs = c.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			String columnName = fs[i].getName();
			Column column = fs[i].getAnnotation(Column.class);
			if(column!=null)
				columnName=column.name();
			s = i == 0 ? s.append(columnName) : s.append(",").append(columnName);
		}
		s.append(")values").append(getString(fs.length));
		return s.toString();
	}

	public String getString(int length) {
		StringBuffer s = new StringBuffer();
		s.append("(");
		for (int i = 0; i < length; i++) {
			s = i == 0 ? s.append("?") : s.append(",?");
		}
		return s.append(")").toString();
	}
}
@Entity("bbs_user")
class User{
	private int id;
	@Column(name="user_name")
	private String name;
	@Column(name="user_pass")
	private String pass;
	@Column(name="user_age")
	private int age;

}
