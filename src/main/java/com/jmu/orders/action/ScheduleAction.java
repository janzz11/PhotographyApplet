package com.jmu.orders.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.orders.model.Schedule;
import com.jmu.orders.service.ScheduleService;

/** 
* @author janzz 
* @version 创建时间：2018年12月25日 下午6:13:40 
* 
*/
@RestController
@CrossOrigin
public class ScheduleAction {

	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(value = "/wechat/schedule", params = "method=getDate", produces = "application/json;charset=UTF-8")
	public String getScheDate(Schedule schedule){
		Info info = scheduleService.getScheDate(schedule);
		return JSON.toJSONString(info);
		
	}
	
	@RequestMapping(value = "/wechat/schedule", params = "method=getTime", produces = "application/json;charset=UTF-8")
	public String getScheTime(Schedule schedule){
		Info info = scheduleService.getScheTime(schedule);
		return JSON.toJSONString(info);
		
	}
	
	@RequestMapping(value = "/wechat/schedule", params = "method=scheData", produces="application/json;charset=UTF-8")
	public String getScheData(){
		Info info = scheduleService.getScheInfo();
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/schedule", params = "method=schList", produces = "application/json;charset=UTF-8")
	public String schList(Schedule schedule){
		Info info = scheduleService.getScheTime(schedule);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/schedule", params = "method=delSch", produces = "application/json;charset=UTF-8")
	public String delSch(Schedule schedule){
		Info info = scheduleService.delSch(schedule);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/schedule", params = "method=addSch", produces = "application/json;charset=UTF-8")
	public String addSch(Schedule schedule){
		Info info = scheduleService.addSch(schedule);
		return JSON.toJSONString(info);
	}
}
