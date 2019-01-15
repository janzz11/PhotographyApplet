package com.jmu.production.dao;

import java.util.List;

import com.jmu.production.model.Production;

/** 
* @author janzz 
* @version 创建时间：2018年12月19日 下午9:41:20 
* 
*/
public interface ProductionDao {
	public List<Production> getProInfo();
	public Production getProInfo(Production production);
}
