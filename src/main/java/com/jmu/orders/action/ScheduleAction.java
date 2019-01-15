package com.jmu.orders.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.orders.model.Schedule;
import com.jmu.orders.service.ScheduleService;

/** 
* @author janzz 
* @version 创建时间：2018年12月25日 下午6:13:40 
* 
*/
@Controller
@RequestMapping("/wechat/schedule")
public class ScheduleAction {

	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(params = "method=getDate", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getScheDate(Schedule schedule){
		Info info = scheduleService.getScheDate(schedule);
		return JSON.toJSONString(info);
		
	}
	
	@RequestMapping(params = "method=getTime", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getScheTime(Schedule schedule){
		Info info = scheduleService.getScheTime(schedule);
		return JSON.toJSONString(info);
		
	}
	
	@RequestMapping(params = "method=scheData", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getScheData(){
		Info info = scheduleService.getScheInfo();
		return JSON.toJSONString(info);
	}
}
