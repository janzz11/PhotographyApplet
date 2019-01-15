package com.jmu.store.model;
/** 
* @author janzz 
* @version 创建时间：2018年12月21日 下午9:44:14 
* 
*/
public class Store {
	private int stoId;//id
	private String stoName;//门店名
	private String stoAdd;//门店地址
	private String stoPhone;//门店电话
	private int stokId;//店家信息id
	public int getStoId() {
		return stoId;
	}
	public void setStoId(int stoId) {
		this.stoId = stoId;
	}
	public String getStoName() {
		return stoName;
	}
	public void setStoName(String stoName) {
		this.stoName = stoName;
	}
	public String getStoAdd() {
		return stoAdd;
	}
	public void setStoAdd(String stoAdd) {
		this.stoAdd = stoAdd;
	}
	
	public String getStoPhone() {
		return stoPhone;
	}
	public void setStoPhone(String stoPhone) {
		this.stoPhone = stoPhone;
	}
	public int getStokId() {
		return stokId;
	}
	public void setStokId(int stokId) {
		this.stokId = stokId;
	}
	
}
