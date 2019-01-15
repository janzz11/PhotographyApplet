package com.jmu.users.model;
/** 
* @author janzz 
* @version 创建时间：2018年12月24日 下午3:17:55 
* 
*/
public class StoreKeeper {
	private int stokId;//id
	private String stokPwd;//登陆密码
	private String stokName;//用户名
	public int getStokId() {
		return stokId;
	}
	public void setStokId(int stokId) {
		this.stokId = stokId;
	}
	public String getStokPwd() {
		return stokPwd;
	}
	public void setStokPwd(String stokPwd) {
		this.stokPwd = stokPwd;
	}
	public String getStokName() {
		return stokName;
	}
	public void setStokName(String stokName) {
		this.stokName = stokName;
	}
	
}
