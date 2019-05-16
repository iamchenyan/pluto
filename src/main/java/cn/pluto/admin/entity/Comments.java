package cn.pluto.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年5月15日 下午12:30:32 
*/
@Data
@Table(name = "tb_comments")
public class Comments {
	
	@Id
	private Long id ;
	@Column(name = "p_id")
	private Long pId ;
	@Column(name = "c_id")
	private Long cId ;
	@Column(name = "article_title")
	private String articleTitle ;
	@Column(name = "article_id")
	private Long articleId ;
	@NotNull
	private String name ;
	@Column(name = "c_name")
	private String cName ;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "CMT+8")
	private Date time ;
	private String content ;
	private String email ;
	private String url ;
	private Long type ;
	private String ip ;
	private String device ;
	private String address;
	
}
