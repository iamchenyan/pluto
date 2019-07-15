package cn.pluto.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pluto.admin.entity.Links;
import cn.pluto.admin.exception.GlobalException;
import cn.pluto.admin.mapper.LinksMapper;
import cn.pluto.admin.service.LinksService;
import cn.pluto.common.service.impl.BaseServiceImpl;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月11日 上午11:36:42 
*/
@Service
@SuppressWarnings("all")
public class LinksServiceImpl extends BaseServiceImpl<Links> implements LinksService {

	@Autowired
	private LinksMapper linkMapper ;
	
	@Override
	public Long findAllCount() {
		return Long.valueOf(linkMapper.selectCount(new Links()));
	}
	
	@Override
	public List<Links> findAll() {
		return linkMapper.selectAll() ;
	}
	
	@Override
	public List<Links> findByPage(Links link) {
		return linkMapper.select(link) ;
	}
	
	@Override
	public Links findById(Long id) {
		if(!id.equals(null) && id != 0) {
			return linkMapper.selectByPrimaryKey(id) ;
		} else {
			throw new GlobalException("参数错误") ;
		}
	}
	
	@Override
	@Transactional
	public void save(Links link) {
		try {
			linkMapper.insert(link) ;
		} catch (Exception e) {
			e.printStackTrace() ;
			throw new GlobalException(e.getMessage()) ;
		}
	}
	
	@Override
	@Transactional
	public void update(Links link) {
		if (link.getId() != 0) {
			try {
				this.updateNotNull(link) ;
			} catch (Exception e) {
				e.printStackTrace() ;
				throw new GlobalException(e.getMessage()) ;
			}
		}

	}
	
	@Override
	@Transactional
	public void delete(List<Long> ids) {
		if (!ids.isEmpty()) {
			try {
					this.batchDelete(ids, "id", Links.class) ;
			} catch (Exception e) {
				e.printStackTrace() ;
				throw new GlobalException(e.getMessage()) ;
			}
		}
	}

}
