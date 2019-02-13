package com.jmu.orders.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jmu.common.Info;
import com.jmu.orders.model.Order;
import com.jmu.orders.service.OrderService;

/** 
* @author zyjeaous 
* @version 创建时间：2018年12月26日 下午
* 
*/
@RestController
@CrossOrigin//跨域注解
public class OrderAction {

	@Autowired 
	private OrderService orderService;
	//获得订单信息
	@RequestMapping(value = "/wechat/order", params = "method=createOrder", produces="application/json;charset=UTF-8")
	public String createOrder(Order order){
		Info info = orderService.toCreateOrder(order);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/wechat/order", params = "method=orderlistData", produces="application/json;charset=UTF-8")
	public String getOrderListData(Order order){
		Info info = orderService.getOrders(order);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/wechat/order", params = "method=schedulelistData", produces="application/json;charset=UTF-8")
	public String schedulelistData(Order order){
		Info info = orderService.getScheduleList(order);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/wechat/order", params = "method=moreorderData", produces="application/json;charset=UTF-8")
	public String getMoreorderData(Order order){
		Info info = orderService.getMoreorderList(order);
		return JSON.toJSONString(info);
	}

	@Transactional(rollbackFor=Exception.class)
	@RequestMapping(value = "/wechat/order", params = "method=cancleOrder", produces="application/json;charset=UTF-8")
	public String cancel(Order order){
		Info info = orderService.cancelOrder(order);
		return JSON.toJSONString(info);
	}
	
	//后台管理
	@RequestMapping(value = "/manage/order", params = "method=ordList", produces = "application/json;charset=UTF-8")
	public String listOrd(Order order) {
		Info info = orderService.getOrders(order);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/order", params = "method=editOrd", produces = "application/json;charset=UTF-8")
	public String editOrd(Order order) {
		Info info = orderService.editOrd(order);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/order", params = "method=delOrd", produces = "application/json;charset=UTF-8")
	public String delOrd(Order order) {
		Info info = orderService.delOrd(order);
		return JSON.toJSONString(info);
	}
	
	@RequestMapping(value = "/manage/order", params = "method=uploadImg", produces = "application/json;charset=UTF-8")
	public String uploadImg(Order order) {
		Info info = orderService.uploadImg(order);
		return JSON.toJSONString(info);
	}
}
