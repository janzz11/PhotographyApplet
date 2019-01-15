package com.jmu.common;

import java.util.HashMap;
import java.util.Map;

/** 
* @author janzz 
* @version 创建时间：2018年12月21日 下午10:09:27 
* 返回的一些数据信息
* 
*/
public class Info {
	private String msg;//返回信息
	private boolean isOk;//操作是否成功
	private Map<String, Object> detail;//数据
	public Info(){
		this.msg = "操作成功";
		this.isOk = true;
		this.detail = new HashMap<String, Object>();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	public Map<String, Object> getDetail() {
		return detail;
	}
	public void setDetail(String key, Object obj) {
		this.detail.put(key, obj);
	}
}
