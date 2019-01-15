package com.jmu.users.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.users.dao.UserDao;
import com.jmu.users.model.User;
import com.jmu.utils.WechatUtil;

/** 
* @author janzz 
* @version 创建时间：2018年12月24日 下午3:18:18 
* 
*/
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	public Info createUser(User user, String code){
		Info info = new Info();
		String openId = WechatUtil.getOpenId(code);
		if(openId == null){
			info.setMsg("code有误，请重新授权!");
			info.setOk(false);
			return info;
		}
		user.setUserWechat(openId);
		info.setDetail("openId", openId);
		List<User> userList = userDao.findUser(user);
		if(userList != null && userList.size() != 0){
			info.setOk(false);
			info.setMsg("该用户已经存在");
		}
		else{
			Boolean isCreate = userDao.addUser(user);
			info.setOk(isCreate);
			if(isCreate){
				info.setMsg("创建成功");
			}
			else{
				info.setMsg("创建失败");
			}
		}
		return info;
	}
	
	public Info toUpdate(User user){
		Info info = new Info();
		if(user.getUserWechat() == null || "".equals(user.getUserWechat().trim())){
			info.setMsg("用户微信id不能为空！");
			info.setOk(false);
			return info;
		}
		Boolean isUpdate = userDao.updateUser(user);
		info.setOk(isUpdate);
		if(isUpdate){
			info.setMsg("修改信息成功！");
		}
		else{
			info.setMsg("修改信息失败");
		}
		return info;
	}
	
	public Info getUser(User user){
		Info info = new Info();
		List<User> userInfo = userDao.findUser(user);
//		System.out.print(userInfo.get(0).getUserPhone());
		if(userInfo.size() != 0){
			info.setDetail("userInfo", userInfo.get(0));
		}
		else{
			info.setDetail("userInfo", "");
		}
		return info;
	}
}
