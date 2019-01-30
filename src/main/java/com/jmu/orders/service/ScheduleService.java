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
	
	public Info delSch(Schedule schedule){
		Info info = new Info();
		Boolean isSch = scheduleDao.delete(schedule);
		if(!isSch){
			info.setOk(false);
			info.setMsg("删除失败，请重新操作！");
		}
		return info;
	}
	
	public Info addSch(Schedule schedule){
		Info info = new Info();
		if(schedule.getSchDate() == null || schedule.getSchDate().equals("")){
			info.setMsg("date不能为空！");
			info.setOk(false);
			return info;
		}
		if(schedule.getSchTime() == null || schedule.getSchTime().equals("")){
			info.setMsg("time不能为空！");
			info.setOk(false);
			return info;
		}
		if(Integer.valueOf(schedule.getProStoId()) == null || Integer.valueOf(schedule.getProStoId()) == 0){
			info.setMsg("产品门店id不能为空！");
			info.setOk(false);
			return info;
		}
		List<Schedule> sch = scheduleDao.getScheInfo(schedule);
		if(sch != null && sch.size() != 0){
			info.setMsg("已经存在同一时间的档期了，请修改后再试！");
			info.setOk(false);
			return info;
		}
		else{
			schedule.setSchFlag(0);
			Boolean isIst = scheduleDao.insert(schedule);
			if(!isIst){
				info.setMsg("添加失败，请重新操作！");
				info.setOk(false);
			}
			return info;
		}
	}
}
