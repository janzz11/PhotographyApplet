package com.jmu.production.model;
/** 
* @author janzz 
* @version 创建时间：2018年12月19日 下午9:41:44 
* 
*/
//产品表
public class Production {
	private int proId;//id
	private String proName;//产品名称
	private int proPrice;//产品价格
	private int proSubscription;//定金
	private String proSample;//优秀样片
	private String proUse;//用途
	private String proAttention;//注意事项
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
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
	public String getProUse() {
		return proUse;
	}
	public void setProUse(String proUse) {
		this.proUse = proUse;
	}
	public String getProAttention() {
		return proAttention;
	}
	public void setProAttention(String proAttention) {
		this.proAttention = proAttention;
	}
	
	
}
