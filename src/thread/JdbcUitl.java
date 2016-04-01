package thread;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUitl {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	public static Connection getConn(){
		Connection con = tl.get();
		if(con==null){
			try {
				Class.forName("");
				con = DriverManager.getConnection("","","");
				tl.set(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static void close(Connection con){
		try {
			if(con!=null){
				con.close();
				tl.remove();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
