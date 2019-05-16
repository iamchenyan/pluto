package cn.pluto.admin.service;

import java.util.List;
import java.util.Map;

import cn.pluto.admin.entity.Comments;
import cn.pluto.common.service.BaseService;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年5月15日 下午12:27:49 
*/
public interface CommentsService extends BaseService<Comments> {
	
	/**
	 *  查询总数量
	 * @return
	 */
	Long findAllCount() ;
	
	/**
	 *  查询所有，为博客前台服务，仅查询最新8条数据
	 * @return
	 */
	List<Comments> findAll() ;
	
	/**
	 *  分页查询
	 * @param comment 查询条件
	 * @return
	 */
	List<Comments> findByPage(Comments comment) ;
	
	/**
	 *  根据ID查询
	 * @param id
	 * @return
	 */
	Comments findById(Long id) ;
	
	/**
	 * 更新
	 * @param comment
	 */
	void update(Comments comment) ;
	
	/**
	 *  删除
	 * @param ids
	 */
	void delete(List<Long> ids) ;
	
	/**
	 *  分页查询并过滤留言数据
	 * @param pageCode 当前页
	 * @param pageSize 每页显示的记录数
	 * @param articleId 当前访问的文章
	 * @param sort 分类，规定：sort=0 表示文章详情页的评论信息；sort=1 表示友链页的评论；sort=2 表示关于我页的评论
	 * @return
	 */
	Map<String, Object> findCommentsList(Integer pageCode ,Integer pageSize ,Integer articleId ,Integer sort) ;
	
	/**
	 *  查询指定文章的评论量
	 * @param articleId
	 * @return
	 */
	Long findCountByArticle(Long articleId) ;
	
}
