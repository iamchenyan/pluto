package cn.pluto.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import cn.pluto.admin.dto.ArticleArchives;
import cn.pluto.admin.entity.Article;
import cn.pluto.admin.mapper.ArticleMapper;
import cn.pluto.admin.service.ArticleService;
import cn.pluto.common.service.impl.BaseServiceImpl;
import tk.mybatis.mapper.entity.Example;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午3:06:09 
*/
@Service
@SuppressWarnings("all")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper ;
	
	
	@Override
	public Long findAllCount() {
		return Long.valueOf(articleMapper.selectCount(new Article()));
	}

	@Override
	public List<Article> findAll() {
		Example example = new Example(Article.class) ;
		example.setOrderByClause("`id` desc") ;
		return articleMapper.selectByExampleAndRowBounds(example, new RowBounds(0,8)) ;
	}

	@Override
	public List<Article> findByPage(Article article) {
		Example example = new Example(Article.class) ;
		if(!StringUtils.isEmpty(article.getTitle())) {
			example.createCriteria().andLike("title", "%" + article.getTitle() + "%") ;
		}
		List<Article> list = articleMapper.selectByExample(example) ;
		findInit(list) ;
		return list;
	}

	/**
	 * 封装文章分类、标签数据
	 * @param list
	 */
	private void findInit(List<Article> list) {
		if(!list.isEmpty()) {
			list.forEach(article ->{
				
			});
		}
		
	}

	@Override
	public Article findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> findByPageForSite(int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleArchives> findArchives() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findFuzzyByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addViews(Long id) {
		// TODO Auto-generated method stub
		
	}

}
