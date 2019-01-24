package com.jmu.store.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.store.service.StoreService;

/** 
* @author janzz 
* @version 创建时间：2018年12月21日 下午9:43:11 
* 
*/
@RestController
@CrossOrigin
public class StoreAction {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value= "/wechat/store" , params = "method=getStore", produces="application/json;charset=UTF-8")
	public String getStoreInfo(){
		Info info = storeService.getStoreInfo();
		return JSON.toJSONString(info);
	}
	
	//后台管理
	@RequestMapping(value = "/manage/store", params ="method=getStore", produces="application/json;charset=UTF-8")
	public String getStoreInfos(){
		Info info = new Info();
		return JSON.toJSONString(info);
	}
}
