package com.jmu.orders.model;
/** 
* @author zyjeaous
* @version 创建时间：2018年12月26日 
* 
*/
public class Order {
	private  int          ordId      ;  //主键id      
	private  String       ordName    ;  //预约人      
	private  String       ordSex     ;  //预约人性别  
	private  String       ordPhone   ;  //预约电话    
	private  int          ordState   ;  //订单状态    
	private  String       ordRemarks ;  //预约备注    
	private  String       ordTime    ;  //订单创建时间
	private  int          schId      ;  //档期表主键  
	private  String       userWechat      ;  //用户表主键  
	public int getOrdId() {
		return ordId;
	}
	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}
	public String getOrdName() {
		return ordName;
	}
	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}
	public String getOrdSex() {
		return ordSex;
	}
	public void setOrdSex(String ordSex) {
		this.ordSex = ordSex;
	}
	public String getOrdPhone() {
		return ordPhone;
	}
	public void setOrdPhone(String ordPhone) {
		this.ordPhone = ordPhone;
	}
	public int getOrdState() {
		return ordState;
	}
	public void setOrdState(int ordState) {
		this.ordState = ordState;
	}
	public String getOrdRemarks() {
		return ordRemarks;
	}
	public void setOrdRemarks(String ordRemarks) {
		this.ordRemarks = ordRemarks;
	}
	public String getOrdTime() {
		return ordTime;
	}
	public void setOrdTime(String ordTime) {
		this.ordTime = ordTime;
	}
	public int getSchId() {
		return schId;
	}
	public void setSchId(int schId) {
		this.schId = schId;
	}
	public String getUserWechat() {
		return userWechat;
	}
	public void setUserWechat(String userWechat) {
		this.userWechat = userWechat;
	}

}
