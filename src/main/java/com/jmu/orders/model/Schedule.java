package com.jmu.orders.model;
/** 
* @author janzz 
* @version 创建时间：2018年12月25日 下午6:14:16 
* 
*/
public class Schedule {
	private int schId;//档期表id
	private String schDate;//日期
	private String schTime;//时间
	private int proStoId;//fk
	private int schFlag;//是否选择
	public int getSchId() {
		return schId;
	}
	public void setSchId(int schId) {
		this.schId = schId;
	}
	public String getSchDate() {
		return schDate;
	}
	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}
	public String getSchTime() {
		return schTime;
	}
	public void setSchTime(String schTime) {
		this.schTime = schTime;
	}
	public int getProStoId() {
		return proStoId;
	}
	public void setProStoId(int proStoId) {
		this.proStoId = proStoId;
	}
	public int getSchFlag() {
		return schFlag;
	}
	public void setSchFlag(int schFlag) {
		this.schFlag = schFlag;
	}
	
}
