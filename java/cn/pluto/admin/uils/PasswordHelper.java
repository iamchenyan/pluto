package cn.pluto.admin.uils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import cn.pluto.admin.entity.User;
import lombok.Getter;
import lombok.Setter;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月11日 上午10:21:48 
*/
@Component
public class PasswordHelper {

	//实例化 RandomNumberGenerator对象，用于生成一个随机数
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator() ;
	@Getter
	@Setter
	private String algorithName = "MD5" ;
	@Getter
	@Setter
	private int hashInterations = 2 ;
	
	public RandomNumberGenerator getRandomNumberGenerator() {
		return randomNumberGenerator ;
	}
	
	//加密算法
	public void encryptPassword(User user) {
		if(user.getPassword() != null) {
			//如果没有盐值就随机生成盐值，但shiro 进行密码校验并不会再次生成盐值，因为是随机盐，shiro会根据数据库中存储的盐值以及你注入的加密方式进行校验，而不是使用这个工具类进行校验。
			//对user对象设置盐：salt；这个盐值是 randomNumberGenerator生成的随机数，所以盐值并不需要我们指定
			user.setSalt(randomNumberGenerator.nextBytes().toHex()) ;
			
			String newPassword = new SimpleHash(
					algorithName ,
					user.getPassword() ,
					ByteSource.Util.bytes(user.getSalt()) ,
					hashInterations).toHex() ;
			user.setPassword(newPassword) ;
		}
	}
	
}
