package thread;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoSupport<T> implements Dao<T>{

	@Override
	public T findById(Serializable id, String sql,RowMapper<T> rm) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T t = null;
		try {
			con = JdbcUitl.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				t = rm.getRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<T> getAll(String sql,RowMapper<T> rm,Object...obj) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			con = JdbcUitl.getConn();
			pstmt = con.prepareStatement(sql);
			for(int i = 0; i < obj.length;i++){
				pstmt.setObject(i+1, obj[i]);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				T t = rm.getRow(rs);
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int saveOrUpdateOrDelete(String sql, Object... obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
