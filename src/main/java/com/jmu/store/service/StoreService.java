package com.jmu.store.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.store.dao.StoreDao;
import com.jmu.store.model.Store;
import com.jmu.users.dao.StoreKeeperDao;
import com.jmu.users.model.StoreKeeper;

/** 
* @author janzz 
* @version 创建时间：2018年12月21日 下午9:45:42 
* 
*/
@Service
public class StoreService {
	
	@Autowired
	private StoreDao storeDao;
	
	@Autowired
	private StoreKeeperDao storeKeeperDao;
	public Info getStoreInfo(){
		Info info = new Info();
		List<Store> store = storeDao.getStore();
		info.setDetail("store", store);
		return info;
	}
	
	public Info getStoreManageInfo(String stokId){
		Info info = new Info();
		if(stokId == null || "".equals(stokId)){
			info.setOk(false);
			info.setMsg("店家Id不为空！");
		}
		List<Map> store = storeDao.getStoreManage(stokId);
		info.setDetail("store", store);
		return info;
	}
	
	public Info delete(Store store){
		Info info = new Info();
		System.out.println("fdsa"+store.getStoId());
		Boolean del = storeDao.delete(store);
		if(!del){
			info.setMsg("删除失败，请重新操作！");
			info.setOk(false);
		}
		return info;
	}
	
	//TODO:是否需要查重？
	public Info add(Store store){
		Info info = new Info();
		if(store.getStoName() == null || "".equals(store.getStoName())){
			info.setOk(false);
			info.setMsg("门店名称不能为空！");
			return info;
		}
		if(store.getStoAdd() == null || "".equals(store.getStoAdd())){
			info.setOk(false);
			info.setMsg("门店地址不能为空！");
			return info;
		}
		if(store.getStoPhone() == null || "".equals(store.getStoPhone())){
			info.setOk(false);
			info.setMsg("门店电话不能为空！");
			return info;
		}
		if(Integer.valueOf(store.getStokId()) == null || "".equals(Integer.valueOf(store.getStokId()))){
			info.setOk(false);
			info.setMsg("店家id不能为空！");
			return info;
		}
		StoreKeeper storeKeep = new StoreKeeper();
		storeKeep.setStokId(store.getStokId());
		if(storeKeeperDao.getStoreKeeper(storeKeep) == null){
			info.setOk(false);
			info.setMsg("店家id不存在，请检查！");
			return info;
		}
		Boolean addStore = storeDao.add(store);
		if(!addStore){
			info.setOk(false);
			info.setMsg("添加操作失败，请重新操作！");
		}
		return info;
	}
	
	public Info editStore(Store store){
		Info info = new Info();
		if(store.getStoName() == null || "".equals(store.getStoName())){
			info.setOk(false);
			info.setMsg("门店名称不能为空！");
			return info;
		}
		if(store.getStoAdd() == null || "".equals(store.getStoAdd())){
			info.setOk(false);
			info.setMsg("门店地址不能为空！");
			return info;
		}
		if(store.getStoPhone() == null || "".equals(store.getStoPhone())){
			info.setOk(false);
			info.setMsg("门店电话不能为空！");
			return info;
		}
		Boolean editStore = storeDao.edit(store);
		if(!editStore){
			info.setOk(false);
			info.setMsg("修改失败，请重新再试！");
		}
		return info;
	}
}
