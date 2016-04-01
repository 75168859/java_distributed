package thread;

import java.sql.Connection;

public class TransactionManager {
	public static void begin(){
		try {
			Connection con = JdbcUitl.getConn();
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void commit(){
		try {
			Connection con = JdbcUitl.getConn();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(){
		try {
			Connection con = JdbcUitl.getConn();
			con.rollback();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
