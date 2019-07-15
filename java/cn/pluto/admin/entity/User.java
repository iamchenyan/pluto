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
* @version 创建时间：2019年5月15日 下午9:51:00 
*/
@Data
@Table(name = "tb_user")
public class User implements Serializable{
	
	@Id
	private Long id ;
	@NotNull
	private String username ;
	@NotNull
	private String password ;
	private String salt ;
	private String avatar ;
	private String introduce ;
	private String remark ;
	
	@Transient
	private String checkPass ;
	
}
