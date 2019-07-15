package cn.pluto.admin.mapper;

import java.util.List;

import cn.pluto.admin.config.MyMapper;
import cn.pluto.admin.entity.Tags;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月11日 下午3:20:58 
*/
public interface TagsMapper extends MyMapper<Tags> {

	List<Tags> findByArticleId(long id) ;
}
