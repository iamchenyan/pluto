package cn.pluto.admin.mapper;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import cn.pluto.admin.config.MyMapper;
import cn.pluto.admin.entity.Comments;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月2日 上午11:51:53 
*/
public interface CommentsMapper extends MyMapper<Comments> {

	/**
	 *  分页查询指定文章评论数据
	 * @param articleId
	 * @param sort
	 * @return
	 */
	Page<Comments> findCommentsList(@Param("articleId") int articleId ,@Param("sort") int sort) ;

	/**
	 *  查询所有评论数据，用于从中筛选实现分页
	 * @param articleId
	 * @param sort
	 * @return
	 */
	Page<Comments> findAllId(@Param("articleId") int articleId ,@Param("sort") int sort) ;
}
