package cn.pluto.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年5月15日 下午10:05:24 
*/
@Data
@Table(name = "tb_stting")
public class Setting implements Serializable{
	
	@Id
	private Long id ;
	@Column(name = "site_name")
	private String siteName ;
	@Column(name = "site_links")
	private Object siteLinks ;
	@Column(name = "site_donation")
	private Object siteDonation ;
	@Column(name = "site_music")
	private String siteMusic ;
	private String about ;
	@Column(name = "about_md")
	private String aboutMd ;
	
}
