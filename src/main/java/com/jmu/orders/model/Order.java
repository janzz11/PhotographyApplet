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
	private  String       userWechat ;  //用户表主键  
	private  String       tempProName;  //产品名称
	private  String       tempStoName;  //门店名
	private  String       tempSchDate;  //日期
	private  String 	  tempSchTime;  //时间
	private  int          stokId;       //id
	private  String		  ordImg;		//图片地址
	private  int 		  proPrice;     //产品价格
	private  int 		  proSubscription;//定金
	private  String       proSample;    //优秀样片
	private  int 		  proStoId;		//id
	public int getProStoId() {
		return proStoId;
	}
	public void setProStoId(int proStoId) {
		this.proStoId = proStoId;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProSubscription() {
		return proSubscription;
	}
	public void setProSubscription(int proSubscription) {
		this.proSubscription = proSubscription;
	}
	public String getProSample() {
		return proSample;
	}
	public void setProSample(String proSample) {
		this.proSample = proSample;
	}
	public String getOrdImg() {
		return ordImg;
	}
	public void setOrdImg(String ordImg) {
		this.ordImg = ordImg;
	}
	public int getOrdId() {
		return ordId;
	}
	public String getTempProName() {
		return tempProName;
	}
	public void setTempProName(String tempProName) {
		this.tempProName = tempProName;
	}
	public String getTempStoName() {
		return tempStoName;
	}
	public void setTempStoName(String tempStoName) {
		this.tempStoName = tempStoName;
	}
	public String getTempSchDate() {
		return tempSchDate;
	}
	public void setTempSchDate(String tempSchDate) {
		this.tempSchDate = tempSchDate;
	}
	public String getTempSchTime() {
		return tempSchTime;
	}
	public void setTempSchTime(String tempSchTime) {
		this.tempSchTime = tempSchTime;
	}
	public int getStokId() {
		return stokId;
	}
	public void setStokId(int stokId) {
		this.stokId = stokId;
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
