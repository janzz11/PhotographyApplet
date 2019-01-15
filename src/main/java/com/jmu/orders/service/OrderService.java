package com.jmu.orders.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.orders.dao.OrderDao;
import com.jmu.orders.dao.ScheduleDao;
import com.jmu.orders.model.Order;
import com.jmu.orders.model.Schedule;
import com.jmu.users.model.User;

/** 
* @author zyjeaous 
* @version 创建时间：2018年12月19日 下午9:41:56 
* 
*/
@Service 
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ScheduleDao scheduleDao;
	public Info tocreateOrder(Order order){
		Info info = new Info();
		Schedule schedule = orderDao.getSchflag(order.getSchId());
		if(schedule.getSchFlag() == 1){
			info.setMsg("该档期已经被选！");
			info.setOk(false);
			return info;
		}
		Boolean isUpdate = orderDao.addOrders(order);
		Schedule sch = new Schedule();
		sch.setSchFlag(1);
		sch.setSchId(order.getSchId());
		Boolean isUpdateflag = scheduleDao.setFlag(sch);
		info.setOk(isUpdate&&isUpdateflag);
		if(isUpdate){
			info.setMsg("修改信息成功！");
		}
		else{
			info.setMsg("修改信息失败");
		}
		return info;
	
	}

public Info getOrders(Order order){
	Info info = new Info();
	List<Order> ordInfo =  orderDao.getOrders(order);
	info.setDetail("orderlistDetail", ordInfo);
	return info;
}
	
	public Info addOrders(Order order){
		Info info = new Info();
		Boolean ordInfo =  orderDao.addOrders(order);
		return info;
	}
	public Info getMoreorderList(Order order){
		Info info = new Info();
		List<Order> ordInfo =  orderDao.getMoreorderList(order);
		info.setDetail("moreorderDetail", ordInfo);
		return info;
	}
	public Info getScheduleList(Order order){
		Info info = new Info();
		List<Order> ordInfo =  orderDao.getScheduleList(order);
		info.setDetail("ScheduleListDetail", ordInfo);
		return info;
	}
	
	@SuppressWarnings("finally")
	public Info cancelOrder(Order order){
		Info info = new Info();
		try{
			order.setOrdState(3);
			orderDao.setState(order);
			Schedule sch = new Schedule();
			sch.setSchFlag(0);
			sch.setSchId(order.getSchId());
			Boolean isUpdate = scheduleDao.setFlag(sch);
			if(isUpdate){
				info.setOk(true);
				info.setMsg("取消成功");
			}
		}catch(Exception e){
			info.setOk(false);
			info.setMsg(e.getMessage());
		}
		finally{
			return info;
		}
		
	}
	
}
