package com.jmu.orders.dao;

import java.util.List;
import java.util.Map;

import com.jmu.orders.model.Order;
import com.jmu.orders.model.Schedule;

/** 
* @author zyjeaous
* @version 创建时间：2018年12月26日 下午9:41:20 
* 
*/
public interface OrderDao {

	public Boolean addOrders(Order order);
	public Schedule getSchflag(int schId);
	public List<Map> getScheduleList(Order order);
	public List<Map> tempList(int schId);
	public Boolean setState(Order order);
	public List<Order> getOrdInfo(Order order);
	public Boolean edit(Order order);
	public Boolean delete(Order order);
	public Boolean updateImg(Order order);
	//difference
	public List<Order> getOrders(Order order);
	public List<Order> getMoreorderList(Order order);
	public Boolean updateflag(Order order);
	public Boolean tocreateOrder(Order order);
//	public List<Order> getScheduleList(Order order);
	
}
