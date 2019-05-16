package cn.pluto.admin.service;

import java.util.List;

import cn.pluto.admin.entity.Setting;
import cn.pluto.admin.entity.User;
import cn.pluto.common.service.BaseService;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年5月15日 下午9:50:03 
*/
public interface UserService extends BaseService<User> {
	
	/**
	 *  根据ID查询
	 * @param id
	 * @return
	 */
	User findById(Long id) ;

	/**
	 *  根据Name查询用户数据
	 * @param username
	 * @return
	 */
	User findByName(String username) ;
	
	/**
	 *  更新
	 * @param user
	 */
	void update(User user) ;
	
	/**
	 *  删除
	 * @param ids
	 */
	void delete(List<Long> ids) ;
	
	/**
	 *  获取系统设置数据
	 * @return
	 */
	Setting findSetting() ;
	
	/**
	 *  更新设置信息
	 * @param setting
	 */
	void updateSetting(Setting setting) ;
	
}
