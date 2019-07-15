package cn.pluto.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午5:44:19 
*/
@Data
@Table(name = "tb_article_category")
public class ArticleCategory implements Serializable {

	@Id
	private Long id ;
	@NotNull
	@Column(name = "article_id")
	private Long articleId ;
	@NotNull
	@Column(name = "category_id")
	private Long categoryId ;
	
	public ArticleCategory() { }
	
	public ArticleCategory(Long articleId, Long categoryId) {
		this.articleId = articleId ;
		this.categoryId = categoryId ;
	}
}
