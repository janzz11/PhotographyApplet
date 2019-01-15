package com.jmu.users.model;
/** 
* @author janzz 
* @version 创建时间：2018年12月24日 下午3:17:40 
* 
*/
public class User {
	private int userId;//id
	private String userName;//姓名
	private String userWechat;//微信id
	private String userSex;//用户性别
	private String userPhone;//用户电话
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserWechat() {
		return userWechat;
	}
	public void setUserWechat(String userWechat) {
		this.userWechat = userWechat;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	
}
