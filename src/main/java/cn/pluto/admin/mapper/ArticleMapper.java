package cn.pluto.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;

import cn.pluto.admin.config.MyMapper;
import cn.pluto.admin.entity.Article;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午3:38:39 
*/
public interface ArticleMapper extends MyMapper<Article> {

	@Select("select * from tb_article where state = '1' order by id desc")
	Page<Article> findByPageForSite() ;
	
	@Select("select id from tb_article order by id desc limit 1")
	long getLastId() ;
  
	@Select("select distinct date_format(publish_time, '%Y-%m') from tb_article order by date_format(publish_time, '%Y-%m') desc")
	List<String> findArchivesByDates() ;
	
	@Select("select id, title, publish_time from tb_article where publish_time like concat('%', #{date}, '%')")
	List<String> findArchivesByDate(String date) ;
	
	@Select("select * from tb_article where title like concat('%', #{date}, '%')")
	List<Article> findFuzzyByTitle(String title) ;
	
	@Select("update tb_article set views = (views + 1) where id = #{id}")
	void addViews(long id) ;
}
