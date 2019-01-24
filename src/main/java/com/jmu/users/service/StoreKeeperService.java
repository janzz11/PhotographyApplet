package com.jmu.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.users.dao.StoreKeeperDao;
import com.jmu.users.model.StoreKeeper;
import com.jmu.utils.CipherUtil;

/** 
* @author janzz 
* @version 创建时间：2018年12月24日 下午3:18:38 
* 
*/
@Service
public class StoreKeeperService {
	
	@Autowired
	private StoreKeeperDao storeKeeperDao;
	public Info toLogin(StoreKeeper storeKeeper){
		Info infos = new Info();
		if(storeKeeper.getStokName() == null || "".equals(storeKeeper.getStokName()) || storeKeeper.getStokPwd() == null || "".equals(storeKeeper.getStokPwd())){
			infos.setOk(false);
			infos.setMsg("用户或密码不能为空！");
			return infos;
		}
		storeKeeper.setStokPwd(CipherUtil.encodeByMD5(storeKeeper.getStokPwd()));
		System.out.println(storeKeeper.getStokPwd());
		StoreKeeper stok = storeKeeperDao.getStoreKeeper(storeKeeper);
		if(stok == null){
			infos.setOk(false);
			infos.setMsg("用户不存在或密码错误！");
		}
		return infos;
	}
	
	public Info toRegister(StoreKeeper storeKeeper){
		Info info = new Info();
		if(storeKeeper.getStokName() == null || "".equals(storeKeeper.getStokName()) || storeKeeper.getStokPwd() == null || "".equals(storeKeeper.getStokPwd())){
			info.setOk(false);
			info.setMsg("用户或密码不能为空！");
			return info;
		}
		StoreKeeper stok = new StoreKeeper();
		stok.setStokName(storeKeeper.getStokName());
		StoreKeeper isName = storeKeeperDao.getStoreKeeper(stok);
		if(isName != null){
			info.setOk(false);
			info.setMsg("用户名不能重复！");
			return info;
		}
		storeKeeper.setStokPwd(CipherUtil.encodeByMD5(storeKeeper.getStokPwd()));
		Boolean isOk = storeKeeperDao.register(storeKeeper);
		if(!isOk){
			info.setOk(false);
			info.setMsg("注册失败！");
		}
		else{
			info.setOk(true);
			info.setMsg("注册成功！");
		}
		return info;
	}
}
