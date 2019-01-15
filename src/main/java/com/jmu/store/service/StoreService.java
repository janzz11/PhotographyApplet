package com.jmu.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.store.dao.StoreDao;
import com.jmu.store.model.Store;

/** 
* @author janzz 
* @version 创建时间：2018年12月21日 下午9:45:42 
* 
*/
@Service
public class StoreService {
	
	@Autowired
	private StoreDao storeDao;
	
	public Info getStoreInfo(){
		Info info = new Info();
		List<Store> store = storeDao.getStore();
		info.setDetail("store", store);
		return info;
	}
}
