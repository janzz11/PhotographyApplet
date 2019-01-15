package com.jmu.orders.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.orders.model.Order;
import com.jmu.orders.service.OrderService;
import com.jmu.users.model.User;

/** 
* @author zyjeaous 
* @version 创建时间：2018年12月26日 下午
* 
*/
@Controller
@RequestMapping("/wechat/order")
public class OrderAction {

	@Autowired 
	private OrderService orderService;
	//获得订单信息
	@RequestMapping(params = "method=createOrder", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String createOrder(Order order){
		Info info = orderService.tocreateOrder(order);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(params = "method=orderlistData", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getOrderListData(Order order){
		Info info = orderService.getOrders(order);
		return JSON.toJSONString(info);
	}
	@RequestMapping(params = "method=schedulelistData", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String schedulelistData(Order order){
		Info info = orderService.getScheduleList(order);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(params = "method=moreorderData", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getMoreorderData(Order order){
		Info info = orderService.getMoreorderList(order);
		return JSON.toJSONString(info);
	}
	
	@Transactional(rollbackFor=Exception.class)
	@RequestMapping(params = "method=cancleOrder", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String cancel(Order order){
		Info info = orderService.cancelOrder(order);
		return JSON.toJSONString(info);
	}
	
}
