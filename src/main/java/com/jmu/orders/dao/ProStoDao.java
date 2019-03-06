package com.jmu.orders.dao;

import java.util.List;
import java.util.Map;

import com.jmu.orders.model.ProSto;
import com.jmu.orders.model.Schedule;

/** 
* @author janzz 
* @version 创建时间：2018年12月25日 下午6:14:05 
* 
*/
public interface ProStoDao {
	public List<Map> getStoreList(int proId);
	public List<Map> getProList(ProSto proSto);
	public Boolean addProSto(ProSto proSto);
	public Boolean editProSto(ProSto proSto);
	public Boolean delPs(int proStoId);
	public List<ProSto> getProSto(ProSto proSto);
}
