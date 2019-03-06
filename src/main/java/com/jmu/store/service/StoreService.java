package com.jmu.store.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.orders.dao.ProStoDao;
import com.jmu.orders.dao.ScheduleDao;
import com.jmu.orders.model.ProSto;
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
	private ProStoDao proStoDao;
	@Autowired 
	private ScheduleDao scheduleDao;
	
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
			return info;
		}
		List<Map> store = storeDao.getStoreManage(stokId);
		info.setDetail("store", store);
		return info;
	}
	
	public Info delete(Store store){
		Info info = new Info();
		ProSto proSto  = new ProSto();
		proSto.setStoId(store.getStoId());
		List<ProSto> proStoList = proStoDao.getProSto(proSto);
		if(proStoList !=null && proStoList.size() != 0) {
			for(int i = 0 ; i < proStoList.size(); i++) {
				proStoDao.delPs(proStoList.get(i).getProStoId());
				scheduleDao.delSch(proStoList.get(i).getProStoId());
			}
		}
		Boolean del = storeDao.delete(store);
		if(!del){
			info.setMsg("删除失败，请重新操作！");
			info.setOk(false);
		}
		return info;
	}
	
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
		if(Integer.valueOf(store.getStokId()) == null || 0 == Integer.valueOf(store.getStokId())){
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
		Store sto = new Store();
		sto.setStoName(store.getStoName());
		List<Store> stoList = storeDao.getStore(sto);
		if(stoList != null && stoList.size() != 0) {
			info.setOk(false);
			info.setMsg("门店名称已经存在，请换个名字！");
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
		if(Integer.valueOf(store.getStoId()) == null || 0 == Integer.valueOf(store.getStoId())){
			info.setOk(false);
			info.setMsg("stoId不能为空！");
			return info;
		}
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
		Store sto = new Store();
		sto.setStoName(store.getStoName());
		List<Store> stoList = storeDao.getStore(sto);
		if(stoList != null && stoList.size() != 0 && !(stoList.get(0).getStoId() == store.getStoId())) {
			info.setOk(false);
			info.setMsg("门店名称已经存在，请换个名字！");
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
