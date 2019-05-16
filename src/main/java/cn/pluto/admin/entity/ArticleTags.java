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
* @version 创建时间：2019年5月16日 下午1:13:46 
*/
@Data
@Table(name = "tb_article_tags")
public class ArticleTags implements Serializable{
	
	@Id
	private Long id ;
	@NotNull
	@Column(name = "article_id")
	private Long articleId ;
	@NotNull
	@Column(name = "tag_id")
	private Long  tagId ;
	
	public ArticleTags() { }
	
	public ArticleTags(Long articleId ,Long tagId) {
		this.articleId = articleId ;
		this.tagId = tagId ;
	}
	
}
