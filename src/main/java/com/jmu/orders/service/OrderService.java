package com.jmu.orders.service;

import java.util.List;
import java.util.Map;

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
	
	public Info toCreateOrder(Order order){
		Info info = new Info();
		Schedule schedule = orderDao.getSchflag(order.getSchId());
		if(schedule.getSchFlag() == 1){
			info.setMsg("该档期已经被选！");
			info.setOk(false);
			return info;
		}
		List<Map> temp = orderDao.tempList(order.getSchId());
		order.setStokId(Integer.parseInt(temp.get(0).get("stokId").toString()));
		order.setTempProName(temp.get(0).get("tempProName").toString());
		order.setTempSchDate(temp.get(0).get("tempSchDate").toString());
		order.setTempSchTime(temp.get(0).get("tempSchTime").toString());
		order.setTempStoName(temp.get(0).get("tempStoName").toString());
		order.setProPrice(Integer.parseInt(temp.get(0).get("proPrice").toString()));
		order.setProSubscription(Integer.parseInt(temp.get(0).get("proSubscription").toString()));
		order.setProSample(temp.get(0).get("proSample").toString());
		order.setProStoId(Integer.parseInt(temp.get(0).get("proStoId").toString()));
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
		List<Order> ordInfo =  orderDao.getOrdInfo(order);
		info.setDetail("orderlistDetail", ordInfo);
		return info;
	}
	
	public Info getMoreorderList(Order order){
		Info info = new Info();
		List<Order> ordInfo =  orderDao.getOrdInfo(order);
		info.setDetail("moreorderDetail", ordInfo);
		return info;
	}
	public Info getScheduleList(Order order){
		Info info = new Info();
		List<Map> ordInfo =  orderDao.getScheduleList(order);
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
	
	public Info editOrd(Order order) {
		Info info = new Info();
		String phoneRegex = "((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
		if(Integer.valueOf(order.getOrdId()) == null || Integer.valueOf(order.getOrdId()) == 0) {
			info.setMsg("订单id不为空！");
			info.setOk(false);
			return info;
		}
		if(order.getOrdPhone() ==null || order.getOrdPhone().equals("")) {
			info.setMsg("预约电话不能为空！");
			info.setOk(false);
			return info;
		}
		if(!order.getOrdPhone().matches(phoneRegex)) {
			info.setMsg("预约电话格式不正确！");
			info.setOk(false);
			return info;
		}
		if(Integer.valueOf(order.getSchId()) == null || Integer.valueOf(order.getSchId()) == 0) {
			info.setMsg("档期id不为空！");
			info.setOk(false);
			return info;
		}
		Order before = new Order();
		before.setOrdId(order.getOrdId());
		List<Order> beforeOrd = orderDao.getOrdInfo(before);
		Schedule schedule = orderDao.getSchflag(order.getSchId());
		if(beforeOrd.get(0).getSchId() != order.getSchId() && schedule.getSchFlag() == 1){
			info.setMsg("该档期已经被选！");
			info.setOk(false);
			return info;
		}
		List<Map> temp = orderDao.tempList(order.getSchId());
		order.setStokId(Integer.parseInt(temp.get(0).get("stokId").toString()));
		order.setTempProName(temp.get(0).get("tempProName").toString());
		order.setTempSchDate(temp.get(0).get("tempSchDate").toString());
		order.setTempSchTime(temp.get(0).get("tempSchTime").toString());
		order.setTempStoName(temp.get(0).get("tempStoName").toString());
		order.setProPrice(Integer.parseInt(temp.get(0).get("proPrice").toString()));
		order.setProSubscription(Integer.parseInt(temp.get(0).get("proSubscription").toString()));
		order.setProSample(temp.get(0).get("proSample").toString());
		order.setProStoId(Integer.parseInt(temp.get(0).get("proStoId").toString()));
		
		Boolean isEdit = orderDao.edit(order);
		Schedule sch = new Schedule();
		sch.setSchFlag(0);
		sch.setSchId(beforeOrd.get(0).getSchId());
		Boolean isUpdateflagb =  scheduleDao.setFlag(sch);
		sch.setSchFlag(1);
		sch.setSchId(order.getSchId());
		Boolean isUpdateflag = scheduleDao.setFlag(sch);
		info.setOk(isEdit&&isUpdateflag&&isUpdateflagb);
		if(isEdit){
			info.setMsg("修改信息成功！");
		}
		else{
			info.setMsg("修改信息失败");
		}
		return info;
	}
	
	public Info delOrd(Order order) {
		Info info = new Info();
		Boolean idDel = orderDao.delete(order);
		Schedule sch = new Schedule();
		sch.setSchFlag(0);
		sch.setSchId(order.getSchId());
		Boolean isUpdateflag = scheduleDao.setFlag(sch);
		if(!idDel) {
			info.setMsg("删除失败，请重新操作！");
			info.setOk(false);
		}
		return info;
	}
	
	public Info uploadImg(Order order) {
		Info info = new Info();
		Boolean isUpload = orderDao.updateImg(order);
		if(!isUpload) {
			info.setMsg("上传图片失败，请重新操作！");
			info.setOk(false);
		}
		order.setOrdState(1);
		orderDao.setState(order);
		
		return info;
	}
}
