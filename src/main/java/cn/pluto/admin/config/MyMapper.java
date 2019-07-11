package cn.pluto.admin.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午3:32:21 
*/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
