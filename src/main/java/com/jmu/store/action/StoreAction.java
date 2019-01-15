package com.jmu.store.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.store.service.StoreService;

/** 
* @author janzz 
* @version 创建时间：2018年12月21日 下午9:43:11 
* 
*/
@Controller
@RequestMapping("/wechat/store")
public class StoreAction {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(params = "method=getStore", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getStoreInfo(){
		Info info = storeService.getStoreInfo();
		return JSON.toJSONString(info);
	}
	
}
