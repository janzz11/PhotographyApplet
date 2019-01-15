package com.jmu.orders.dao;

import java.util.List;

import com.jmu.orders.model.Order;
import com.jmu.orders.model.Schedule;

/** 
* @author zyjeaous
* @version 创建时间：2018年12月26日 下午9:41:20 
* 
*/
public interface OrderDao {

	public Boolean tocreateOrder(Order order);
	public Schedule getSchflag(int schId);
	public List<Order> getOrders(Order order);
	public List<Order> getMoreorderList(Order order);
	public Boolean addOrders(Order order);
	public Boolean setState(Order order);
	public Boolean updateflag(Order order);
	public List<Order> getScheduleList(Order order);
	
}
