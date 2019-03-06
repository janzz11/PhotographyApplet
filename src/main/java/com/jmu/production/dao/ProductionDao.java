package com.jmu.production.dao;

import java.util.List;
import java.util.Map;

import com.jmu.production.model.Production;

/** 
* @author janzz 
* @version 创建时间：2018年12月19日 下午9:41:20 
* 
*/
public interface ProductionDao {
	public List<Production> getProInfo();
	public List<Production> getProInfo(Production production);
	public List<Map> getProStoInfo(String stokId); 
	public Boolean addPro(Production production);
	public Boolean editPro(Production production);
	public Boolean delPro(int proId);
}
