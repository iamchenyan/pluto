package cn.pluto.admin.service;

import java.util.List;

import cn.pluto.admin.entity.Article;
import cn.pluto.admin.entity.ArticleTags;
import cn.pluto.admin.entity.Tags;
import cn.pluto.common.service.BaseService;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年5月16日 下午1:12:55 
*/
public interface ArticleTagsService extends BaseService<ArticleTags> {

	/**
	 *  根据文章ID查询文章+标签数据
	 * @param articleId
	 * @return
	 */
	List<Tags> findByArticleId(Long articleId) ;
	
	/**
	 *  根据标签ID查询文章+标签数据
	 * @param tagId
	 * @return
	 */
	List<ArticleTags> findByTagId(Long tagId) ;
	
	/**
	 *  根据文章ID删除
	 * @param id
	 */
	void deleteByArticleId(Long id) ;
	
	/**
	 *  根据标签ID删除
	 * @param id
	 */
	void deleteByTagsId(Long id) ;
	
	/**
	 *  根据标签名称查询关联文章
	 * @param tag
	 * @return
	 */
	List<Article> findByTagName(String tag) ;
}
