package com.jmu.users.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.users.model.User;
import com.jmu.users.service.UserService;

/** 
* @author janzz 
* @version 创建时间：2018年12月24日 下午3:16:33 
* 
*/
@RestController
@CrossOrigin
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/wechat/user", params = "method=createUser", produces="application/json;charset=UTF-8")
	public String createUser(User user, String code){
		System.out.println(code);
		
		Info info = userService.createUser(user, code);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/wechat/user", params = "method=updateUser", produces="application/json;charset=UTF-8")
	public String doUserUpdate(User user){
		Info info = userService.toUpdate(user);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/wechat/user", params = "method=userDetail", produces = "application/json;charset=UTF-8")
	public String getUserInfo(User user){
		Info info = userService.getUser(user);
		return JSON.toJSONString(info);
	}
}
