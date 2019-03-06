package com.jmu.orders.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.orders.model.ProSto;
import com.jmu.orders.service.ProStoService;


/** 
* @author janzz 
* @version 创建时间：2018年12月25日 下午6:13:40 
* 
*/
@RestController
@CrossOrigin
public class ProStoAction {

	@Autowired
	private ProStoService proStoService;
	
	@RequestMapping(value = "/manage/prosto", params = "method=proStoList", produces = "application/json;charset=UTF-8")
	public String proStoList(ProSto proSto){
		Info info = proStoService.getList(proSto);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/prosto", params = "method=addProSto", produces = "application/json;charset=UTF-8")
	public String add(ProSto proSto){
		Info info = proStoService.add(proSto);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/prosto", params = "method=delProSto", produces = "application/json;charset=UTF-8")
	public String del(ProSto proSto){
		Info info = proStoService.del(proSto);
		return JSON.toJSONString(info);
	}
}
