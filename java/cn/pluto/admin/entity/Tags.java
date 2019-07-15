package cn.pluto.admin.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import lombok.Data;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年5月16日 上午11:05:10 
*/
@Data
@Table(name = "tb_tags")
public class Tags implements Serializable {

	@Id
	private Long id ;
	@NotNull
	private String name ;
	
	@Transient
	private Long count ;
	
	public Tags() { }
	
	public Tags(String name) {
		this.name = name ;
	}
}
