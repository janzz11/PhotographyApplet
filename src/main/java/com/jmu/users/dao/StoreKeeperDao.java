package com.jmu.users.dao;

import com.jmu.users.model.StoreKeeper;

/** 
* @author janzz 
* @version 创建时间：2018年12月24日 下午3:19:58 
* 
*/
public interface StoreKeeperDao {
	public StoreKeeper getStoreKeeper(StoreKeeper storeKeeper);
	public Boolean register(StoreKeeper storeKeeper);
}
