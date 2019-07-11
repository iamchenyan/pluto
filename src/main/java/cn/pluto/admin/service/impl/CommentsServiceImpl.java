package cn.pluto.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.pluto.admin.dto.CommentsDTO;
import cn.pluto.admin.entity.Article;
import cn.pluto.admin.entity.Comments;
import cn.pluto.admin.exception.GlobalException;
import cn.pluto.admin.mapper.CommentsMapper;
import cn.pluto.admin.service.CommentsService;
import cn.pluto.common.service.impl.BaseServiceImpl;
import tk.mybatis.mapper.entity.Example;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月2日 上午11:39:08 
*/
@Service
@SuppressWarnings("all")
public class CommentsServiceImpl extends  BaseServiceImpl<Comments> implements CommentsService {

	@Autowired
	private CommentsMapper commentMapper ;
	
	@Override
	public Long findAllCount() {
		return Long.valueOf(commentMapper.selectCount(new Comments()));
	}
	
	@Override
	public List<Comments> findAll() {
		Example example = new Example(Article.class) ;
		example.setOrderByClause("`id` desc") ;
		return commentMapper.selectByExampleAndRowBounds(example, new RowBounds(0 ,8)) ;
	}
	
	@Override
	public List<Comments> findByPage(Comments comment) {
		Example example = new Example(Comments.class) ;
		if (!StringUtils.isEmpty(comment.getName())) {
			example.createCriteria().andLike("name", "%" + comment.getName() + "%") ;
		}
		return commentMapper.selectByExample(example) ;
	}
	
	@Override
	public Map<String, Object> findCommentsList(Integer pageCode, Integer pageSize, Integer articleId, Integer sort) {
		Map<String ,Object> map = new HashMap<>() ;
		PageHelper.startPage(pageCode ,pageSize) ;
		Page<Comments> page = commentMapper.findAllId(articleId, sort) ;
		List<Comments> list = commentMapper.findCommentsList(articleId, sort) ;
		List<CommentsDTO> commentsDTOS = new ArrayList<CommentsDTO>() ;
		
		list.forEach(comments -> {
			List<Comments> commentList = new ArrayList<Comments>() ;
			if(comments.getPId() == 0 && comments.getCId() == 0) {
				// 说明是顶层的文章留言信息
				list.forEach(parent -> {
					if (parent.getPId().equals(comments.getId())) {
						// 说明属于当前父节点
						commentList.add(parent) ;
					}
				});
				commentsDTOS.add(new CommentsDTO(comments ,commentList)) ;
			}
		});
		if (page.getTotal() < (pageCode * pageSize) - 1) {
			map.put("total", page.getTotal()) ;
			map.put("rows", commentsDTOS.subList((pageCode - 1) * pageSize, commentsDTOS.size())) ;
			return map ;
		} else {
			map.put("total", page.getTotal()) ;
			map.put("rows", commentsDTOS.subList((pageCode - 1) * pageSize, (pageCode * pageSize) - 1)) ;
			return map ;
		}
	}
	
	@Override
	public Long findCountByArticle(Long articleId) {
		if (!articleId.equals(null) && articleId != 0) {
			Comments comment = new Comments() ;
			comment.setArticleId(articleId) ;
			return Long.valueOf(commentMapper.selectCount(comment)) ;
		} else {
			throw new GlobalException("参数错误") ;
		}
	}
	
	@Override
	public Comments findById(Long id) {
		if (!id.equals(null) && id != 0) {
			return commentMapper.selectByPrimaryKey(id) ;
		} else {
			throw new GlobalException("参数错误") ;
		}
	}
	
	@Override
	public void save(Comments comment) {
		try {
			commentMapper.insert(comment) ;
		} catch (Exception e) {
			e.printStackTrace() ;
			throw new GlobalException(e.getMessage()) ;
		}
	}
	
	@Override
	@Transactional
	public void update(Comments comment) {
		if (comment.getId() != 0) {
			try {
				this.updateNotNull(comment) ;
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
				this.batchDelete(ids, "id", Comments.class);
			} catch (Exception e) {
				e.printStackTrace() ;
				throw new GlobalException(e.getMessage()) ;
			}
		}
	}

}
