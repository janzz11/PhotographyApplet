package com.jmu.users.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.users.model.StoreKeeper;
import com.jmu.users.service.StoreKeeperService;

/** 
* @author janzz 
* @version 创建时间：2018年12月24日 下午3:17:03 
* 
*/
@RestController
@CrossOrigin//跨域注解
@RequestMapping("/storekeeper")
public class StoreKeeperAction {
	
	@Autowired 
	private StoreKeeperService storeKeeperService;
	
//	@CrossOrigin//跨域注解
	@RequestMapping(params ="method=login", produces = "application/json;charset=UTF-8")
	public String Login(StoreKeeper storeKeeper){
		System.out.println("Login");
		Info info = storeKeeperService.toLogin(storeKeeper);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(params ="method=register", produces ="application/json;charset=UTF-8")
	public String register(StoreKeeper storeKeeper){
		Info info = storeKeeperService.toRegister(storeKeeper);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(params = "method=logout", produces = "application/json;charset=UTF-8")
	public String logout(StoreKeeper storeKeeper){
		Info info = new Info();
		return JSON.toJSONString(info);
	}
}
