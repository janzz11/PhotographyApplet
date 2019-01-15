package com.jmu.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.orders.dao.ScheduleDao;
import com.jmu.orders.model.Schedule;

/** 
* @author janzz 
* @version 创建时间：2018年12月25日 下午5:25:56 
* 
*/
@Service
public class ScheduleService {

	@Autowired 
	private ScheduleDao scheduleDao;
	
	public Info getScheDate(Schedule schedule){
 		Info info = new Info();
		List<Schedule> scheDate = scheduleDao.getScheDate(schedule);
		info.setDetail("schedule", scheDate);
		return info;
	}
	
	public Info getScheTime(Schedule schedule){
 		Info info = new Info();
		List<Schedule> scheTime = scheduleDao.getScheInfo(schedule);
		info.setDetail("schedule", scheTime);
		return info;
	}
	
	public Info getScheInfo(){
		Info info = new Info();
		List<Schedule> schInfo = scheduleDao.getScheInfo();
		info.setDetail("scheduleList", schInfo);
		return info;
	}

}
