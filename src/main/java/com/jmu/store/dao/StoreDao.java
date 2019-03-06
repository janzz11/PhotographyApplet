package com.jmu.store.dao;

import java.util.List;
import java.util.Map;

import com.jmu.store.model.Store;

/** 
* @author janzz 
* @version 创建时间：2018年12月21日 下午9:44:38 
* 
*/
public interface StoreDao {
	public List<Store> getStore();
	public List<Store> getStore(Store store);
	public List<Map> getStoreManage(String stokId);
	public Boolean delete(Store store);
	public Boolean add(Store store);
	public Boolean edit(Store store);
}
