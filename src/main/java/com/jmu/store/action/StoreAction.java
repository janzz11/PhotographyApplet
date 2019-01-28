package com.jmu.store.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.store.model.Store;
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
	public String getStoreManageInfo(String stokId){
		Info info = storeService.getStoreManageInfo(stokId);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/store", params = "method=delStore", produces = "application/json;charset=UTF-8")
	public String delStore(Store store){
		Info info = storeService.delete(store);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/store", params = "method=addStore", produces = "application/json;charset=UTF-8")
	public String add(Store store){
		Info info = storeService.add(store);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/store", params = "method=editStore", produces = "application/json;charset=UTF-8")
	public String edit(Store store){
		Info info = storeService.editStore(store);
		return JSON.toJSONString(info);
	}
}
