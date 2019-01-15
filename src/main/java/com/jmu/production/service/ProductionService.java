package com.jmu.production.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.orders.dao.ProStoDao;
import com.jmu.production.dao.ProductionDao;
import com.jmu.production.model.Production;
import com.jmu.store.dao.StoreDao;
import com.jmu.store.model.Store;

/** 
* @author janzz 
* @version 创建时间：2018年12月19日 下午9:41:56 
* 
*/
@Service 
public class ProductionService {

	@Autowired
	private ProductionDao productionDao;
	@Autowired
	private ProStoDao proStoDao;
	
	public Info getProInfo(){
		Info info = new Info();
		List<Production> proInfo = productionDao.getProInfo();
		info.setDetail("proList", proInfo);
		return info;
	}
	
	public Info getProDetail(Production production){
		Info info = new Info();
		Production proDetail = productionDao.getProInfo(production);
		List<Map> store = proStoDao.getStoreList(production.getProId());
		info.setDetail("proDetail", proDetail);
		info.setDetail("store", store);
		return info;
	}
}
