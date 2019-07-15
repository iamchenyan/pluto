package cn.pluto.admin.exception;

import lombok.Getter;
import lombok.Setter;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午6:02:35 
*/
public class GlobalException extends RuntimeException {

	@Getter
	@Setter
	private String msg ;
	
	public GlobalException(String message) {
		this.msg = message ;
	}
}
