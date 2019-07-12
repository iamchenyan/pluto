package cn.pluto.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;

import cn.pluto.admin.entity.Article;
import cn.pluto.admin.entity.ArticleTags;
import cn.pluto.admin.entity.Tags;
import cn.pluto.admin.exception.GlobalException;
import cn.pluto.admin.mapper.ArticleTagMapper;
import cn.pluto.admin.service.ArticleTagsService;
import cn.pluto.common.service.impl.BaseServiceImpl;
import tk.mybatis.mapper.entity.Example;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月12日 上午10:57:12 
*/
@Service
@SuppressWarnings("all")
public class ArticleTagsServiceImpl extends BaseServiceImpl<ArticleTags> implements ArticleTagsService {

	@Autowired
	private ArticleTagMapper articleTagMapper ;
	
	@Override
	@Transactional
	public void save(ArticleTags articleTag) {
		try {
			if (!exists(articleTag)) {
				articleTagMapper.insert(articleTag) ;
			}
		} catch (Exception e) {
			e.printStackTrace() ;
			throw new GlobalException(e.getMessage()) ;
		}
	}
	
	private boolean exists(ArticleTags articleTag) {
		return articleTagMapper.selectCount(articleTag) > 0 ? true : false ;
	}
	
	@Override
	public List<Tags> findByArticleId(Long articleId) {
		if (!articleId.equals(null) && articleId != 0) {
			return articleTagMapper.findByArticleId(articleId) ;
		} else {
			throw new GlobalException("参数错误") ;
		}
	}
	
	@Override
	public List<ArticleTags> findByTagId(Long tagId) {
		if (!tagId.equals(null) && tagId != 0) {
			Example example = new Example(ArticleTags.class) ;
			example.createCriteria().andCondition("tag_id" ,tagId) ;
			return articleTagMapper.selectByExample(example) ;
		} else {
			throw new GlobalException("参数错误") ;
		}
	}
	
	@Override
	@Transactional
	public void deleteByArticleId(Long id) {
		if (!id.equals(null) && id != 0) {
			try {
				if (exists(new ArticleTags(id ,0L))) {
					Example example = new Example(ArticleTags.class) ;
					example.createCriteria().andCondition("article_id" ,id) ;
					articleTagMapper.deleteByExample(example) ;
				}
			} catch (Exception e) {
				e.printStackTrace() ;
				throw new GlobalException(e.getMessage()) ;
			}
		} else {
			throw new GlobalException("参数错误") ;
		}
	}

	@Override
	@Transactional
	public void deleteByTagsId(Long id) {
		if (!id.equals(null) && id != 0) {
			try {
				if (exists(new ArticleTags(0L ,id))) {
					Example example = new Example(ArticleTags.class) ;
					example.createCriteria().andCondition("tag_id" ,id) ;
					articleTagMapper.deleteByExample(example) ;
				}
			} catch (Exception e) {
				e.printStackTrace() ;
				throw new GlobalException(e.getMessage()) ;
			}
		} else {
			throw new GlobalException("参数错误") ;
		}
			
	}
	
	@Override
	public List<Article> findByTagName(String tag) {
		if (!StringUtils.isEmpty(tag)) {
			return articleTagMapper.findByTagName(tag) ;
		} else {
			throw new GlobalException("参数错误") ;
		}
	}

}
