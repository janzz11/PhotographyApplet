package com.jmu.test.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jmu.test.model.Demo;
import com.jmu.test.service.DemoService;


/** 
* @author janzz 
* @version 创建时间：2018年12月19日 上午10:11:40 
* 
*/
@Controller
@RequestMapping("/wechat/demo")
public class DemoAction {
	
	@Autowired 
	private DemoService demoService;
	@RequestMapping(params = "method=display2")
	@ResponseBody
	public String display(){
		List<Demo> data = demoService.getDetail();
		return JSON.toJSONString(data);
	}
}
