package com.jmu.orders.dao;

import java.util.List;

import com.jmu.orders.model.Schedule;

/** 
* @author janzz 
* @version 创建时间：2018年12月25日 下午6:14:05 
* 
*/
public interface ScheduleDao {
	public List<Schedule> getScheDate(Schedule schedule);
	public List<Schedule> getScheInfo();
	public List<Schedule> getScheInfo(Schedule schedule);
	public Boolean setFlag(Schedule schedule);
}
