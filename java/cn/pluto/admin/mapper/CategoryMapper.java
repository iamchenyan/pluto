package cn.pluto.admin.mapper;

import java.util.List;

import cn.pluto.admin.config.MyMapper;
import cn.pluto.admin.entity.Category;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午5:34:21 
*/
public interface CategoryMapper extends MyMapper<Category> {

	List<Category> findCategoryByArticleId(long id) ;
}
