package cn.pluto.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pluto.admin.entity.Setting;
import cn.pluto.admin.entity.User;
import cn.pluto.admin.exception.GlobalException;
import cn.pluto.admin.mapper.SettingMapper;
import cn.pluto.admin.mapper.UserMapper;
import cn.pluto.admin.service.UserService;
import cn.pluto.admin.uils.PasswordHelper;
import cn.pluto.common.service.impl.BaseServiceImpl;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年7月11日 上午10:15:17 
*/
@Service
@SuppressWarnings("all")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired
	private UserMapper userMapper ;
	
	@Autowired
	private SettingMapper settingMapper ;
	
	@Autowired
	private PasswordHelper passwordHelper ;
	
	@Override
	public User findById(Long id) {
		return userMapper.selectByPrimaryKey(id) ;
	}
	
	@Transactional
	public void save(User user) {
		try {
			passwordHelper.encryptPassword(user) ; //加密
			userMapper.insert(user) ;
		} catch (Exception e) {
			e.printStackTrace() ;
			throw new GlobalException(e.getMessage()) ;
		}
	}
	
	@Override
	@Transactional
	public void update(User user) {
		if(user.getId() != 0) {
			try {
				if(user.getPassword() != null && !"".equals(user.getPassword())) {
					passwordHelper.encryptPassword(user) ; //加密
				}
				this.updateNotNull(user) ;
			} catch (Exception e) {
				e.printStackTrace() ;
				throw new GlobalException(e.getMessage()) ;
			}
		}
		
	}
	
	@Override
	@Transactional
	public void delete(List<Long> ids) {
		if(!ids.isEmpty()) {
			try {
				this.batchDelete(ids, "id", User.class) ;
			} catch (Exception e) {
				e.printStackTrace() ;
				throw new GlobalException(e.getMessage()) ;
			}
		}
		
	}

	@Override
	public User findByName(String username) {
		if(!username.isEmpty()) {
			User user = new User() ;
			user.setUsername(username) ;
			return userMapper.select(user).get(0) ;
		} else {
			return new User() ;
		}
		
	}

	@Override
	public Setting findSetting() {
		return settingMapper.selectAll().get(0) ;
	}

	@Override
	@Transactional
	public void updateSetting(Setting setting) {
		settingMapper.updateByPrimaryKeySelective(setting) ;
	}

}
