package cn.pluto.admin.dto;

import java.io.Serializable;
import java.util.List;

import cn.pluto.admin.entity.Comments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月2日 下午12:12:38 
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDTO implements Serializable {
	
	/**
	 *  父级留言
	 */
	private Comments parent ;
	
	/**
	 *  所有子级回复、评论
	 */
	private List<Comments> childrenList ;
	

}
