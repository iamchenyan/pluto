package cn.pluto.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.pluto.common.service.BaseService;
import lombok.Getter;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午3:08:44 
*/
public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	@Getter
	private Mapper<T> mapper ;
	
	@Override
	public List<T> selectAll(){
		return mapper.selectAll() ;
	}
	
	@Override
	public T selectByKey(Object key) {
		return mapper.selectByPrimaryKey(key) ;
	}

	@Override
	public void save(T entity) {
		mapper.insert(entity) ;
	}

	@Override
	public void delete(Object key) {
		mapper.deleteByPrimaryKey(key) ;
	}

	@Override
	public void batchDelete(List<Long> ids, String property, Class<T> clazz) {
		Example example = new Example(clazz) ;
		example.createCriteria().andIn(property, ids) ;
		this.mapper.deleteByExample(example) ;
	}

	@Override
	public void updateAll(T entity) {
		mapper.updateByPrimaryKey(entity) ;
	}
	
	/**
	 * updateByPrimaryKeySelective()字段检验再更新，如果字段值为null就不更新
	 * @param entity
	 */
	@Override
	public void updateNotNull(T entity) {
		mapper.updateByPrimaryKeySelective(entity) ;
	}
	
	@Override
	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example) ;
	}

	
	
	
}
