package cn.pluto.admin.mapper;

import java.util.List;

import cn.pluto.admin.config.MyMapper;
import cn.pluto.admin.entity.Article;
import cn.pluto.admin.entity.ArticleTags;
import cn.pluto.admin.entity.Tags;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月12日 上午11:04:54 
*/
public interface ArticleTagMapper extends MyMapper<ArticleTags> {
	
	List<Tags> findByArticleId(long articleId) ;
	
	List<Article> findByTagName(String name) ;

}
