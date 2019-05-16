package cn.pluto.admin.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年5月15日 下午11:47:24 
*/
@Data
@Table(name = "tb_links")
public class Links implements Serializable{

	@Id
	private Long id ;
	@NotNull
	private String name ;
	private String url ;
}
