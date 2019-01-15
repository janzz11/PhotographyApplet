package com.jmu.users.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.users.model.User;
import com.jmu.users.service.UserService;

/** 
* @author janzz 
* @version 创建时间：2018年12月24日 下午3:16:33 
* 
*/
@Controller
@RequestMapping("/wechat/user")
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(params = "method=createUser", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String createUser(User user, String code){
		System.out.println(code);
		
		Info info = userService.createUser(user, code);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(params = "method=updateUser", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String doUserUpdate(User user){
		Info info = userService.toUpdate(user);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(params = "method=userDetail", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getUserInfo(User user){
		Info info = userService.getUser(user);
		return JSON.toJSONString(info);
	}
}
