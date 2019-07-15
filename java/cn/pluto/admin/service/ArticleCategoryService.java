package cn.pluto.admin.service;

import cn.pluto.admin.entity.ArticleCategory;
import cn.pluto.common.service.BaseService;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午5:43:28 
*/
public interface ArticleCategoryService extends BaseService<ArticleCategory>{

	/**
	 * 根据文章ID删除
	 * @param id
	 */
	void deleteByArticleId(Long id) ;
	
	/**
	 * 根据分类ID删除
	 * @param id
	 */
	void deleteByCategoryId(Long id) ;
	
}
