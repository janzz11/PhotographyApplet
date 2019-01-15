package com.jmu.users.dao;

import java.util.List;

import com.jmu.users.model.User;

/** 
* @author janzz 
* @version 创建时间：2018年12月24日 下午3:19:58 
* 
*/
public interface UserDao {
	public Boolean addUser(User user);
	public List<User> findUser(User user);
	public Boolean updateUser(User user);
}
