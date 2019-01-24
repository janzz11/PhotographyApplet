package com.jmu.production.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.production.model.Production;
import com.jmu.production.service.ProductionService;

/** 
* @author janzz 
* @version 创建时间：2018年12月19日 下午9:40:51 
* 
*/
@RestController
@CrossOrigin
public class ProductAction {
	
	@Autowired 
	private ProductionService productionService;
	//获得产品信息
	@RequestMapping(value= "/wechat/product", params = "method=proData", produces="application/json;charset=UTF-8")
	public String getProData(){
		Info info = productionService.getProInfo();
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value= "/wechat/product", params = "method=getProDetail", produces="application/json;charset=UTF-8")
	public String getProDetail(Production production){
		Info info = productionService.getProDetail(production);
		return JSON.toJSONString(info);
	}
}
