package cn.pluto.common.service;

import java.util.List;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年5月14日 上午12:00:30 
*/
public interface BaseService<T> {
	
	List<T> selectAll() ;
	
	T selectByKey(Object key) ;
	
	void save(T entity) ;
	
	void delete(Object key) ;
	
	void batchDelete(List<Long> ids, String property, Class<T> cl) ;
	
	void updateAll(T entity) ;
	
	void updateNotNull(T entity);
	
	List<T> selectByExample(Object example) ;

}
