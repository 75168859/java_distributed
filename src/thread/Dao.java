package thread;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
	public T findById(Serializable id,String sql,RowMapper<T> rm);
	public List<T> getAll(String sql,RowMapper<T> rm,Object...obj);
	public int saveOrUpdateOrDelete(String sql,Object...obj);
}
