package cn.pluto.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pluto.admin.entity.ArticleTags;
import cn.pluto.admin.entity.Tags;
import cn.pluto.admin.exception.GlobalException;
import cn.pluto.admin.mapper.TagsMapper;
import cn.pluto.admin.service.ArticleTagsService;
import cn.pluto.admin.service.TagsService;
import cn.pluto.common.service.impl.BaseServiceImpl;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月11日 下午3:18:07 
*/
@Service
@SuppressWarnings("all")
public class TagsServiceImpl extends BaseServiceImpl<Tags> implements TagsService {

	@Autowired
	private TagsMapper tagMapper ;
	
	@Autowired
	private ArticleTagsService articleTagService ;
	
	@Override
	public Long findAllCount() {
		return Long.valueOf(tagMapper.selectCount(new Tags()));
	}
	
	@Override
	public List<Tags> findAll() {
		List<Tags> list = tagMapper.selectAll() ;
		list.forEach(tag ->{
			List<ArticleTags> articleTagList = articleTagService.findByTagId(tag.getId()) ;
			tag.setCount(Long.valueOf(articleTagList.size())) ;
		}) ;
		return tagMapper.selectAll() ;
	}
	
	@Override
	public List<Tags> findByPage(Tags tag) {
		return tagMapper.select(tag) ;
	}
	
	@Override
	public Tags findById(Long id) {
		if(!id.equals(null) && id != 0) {
			return tagMapper.selectByPrimaryKey(id) ;
		} else {
			throw new GlobalException("参数错误") ;
		}
	}
	
	@Override
	@Transactional
	public void save(Tags tag) {
		try {
			if(!exists(tag)) {
				tagMapper.insert(tag) ;
			}
		} catch (Exception e) {
			e.printStackTrace() ;
			throw new GlobalException(e.getMessage()) ;
		}

	}
	
	private boolean exists(Tags tag) {
		return tagMapper.selectCount(tag) > 0 ? true : false ;
	}
	
	@Override
	@Transactional
	public void update(Tags tag) {
		try {
			if(tag.getId() != 0) {
				this.updateNotNull(tag) ;
			} else {
				throw new GlobalException("参数错误") ;
			}
		} catch (Exception e) {
			e.printStackTrace() ;
			throw new GlobalException(e.getMessage()) ;
		}

	}

	@Override
	@Transactional
	public void delete(List<Long> ids) {
		if(!ids.isEmpty()) {
			try {
				ids.forEach(id ->{
					tagMapper.deleteByPrimaryKey(id) ;
					
					//删除该标签与文章有关联的关联信息
					articleTagService.deleteByTagsId(id) ;
				}) ;
			} catch (Exception e) {
				e.printStackTrace() ;
				throw new GlobalException(e.getMessage()) ;
			}
		} else {
			throw new GlobalException("参数错误") ;
		}

	}

	@Override
	public Tags findByName(String name) {
		if(!name.isEmpty()) {
			Tags tag = new Tags() ;
			tag.setName(name) ;
			return tagMapper.select(tag).get(0) ;
		} else {
			throw new GlobalException("参数错误") ;
		}
	}

	@Override
	public List<Tags> findByArticleId(Long id) {
		if(!id.equals(null) && id != 0) {
			return tagMapper.findByArticleId(id) ;
		} else {
			throw new GlobalException("参数错误") ;
		}
	}

}
