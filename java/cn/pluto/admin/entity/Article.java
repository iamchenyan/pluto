package cn.pluto.admin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/** 
*  文章信息
* @author 作者 chenyan
* @version 创建时间：2019年5月14日 上午9:25:43 
*/
@Data
@Table(name = "tb_article")
public class Article implements Serializable {

	@Id
	private Long id ;
	
	@NotNull
	private String title ;
	private String cover ;
	private String author ;
	private String content ;
	@Column(name = "content_md")
	private String contentMd ;
	private String category ;
	private String origin ;
	private String state ;
	private Long views ;
	private Long type ;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "publish_time" )
	private Date publishTime ;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "edit_time")
	private Date editTime ;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "create_time")
	private Date createTime ;
	
	@Transient
	private String tags ;
	
	public Article(){ }
	
	public Article(String category) {
		this.category = category ;
	}
	
	public Article(Long id, String category) {
		this.id = id ;
		this.category = category ;
	}
	
	public Article(String title, String category) {
		this.title = title ;
		this.category = category ;
	}
	
}
