package cn.pluto.admin.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午5:35:26 
*/
@Data
@Table(name = "tb_category")
public class Category implements Serializable {

	@Id
	private Long id ;
	@NotNull
	private String name ;
	
	public Category() {
		
	}
	
	public Category(String name) {
		this.name = name ;
	}
}
