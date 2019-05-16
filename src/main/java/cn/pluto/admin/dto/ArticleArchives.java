package cn.pluto.admin.dto;

import java.io.Serializable;
import java.util.List;

import cn.pluto.admin.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
*  用于封装 Article表 按时间归档的 DTO
* @author 作者 chenyan
* @version 创建时间：2019年5月15日 上午9:14:33 
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleArchives implements Serializable {

	private String date ;
	private List<Article> articles ;
	
}
