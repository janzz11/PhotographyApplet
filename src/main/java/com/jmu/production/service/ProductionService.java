package com.jmu.production.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.orders.dao.ProStoDao;
import com.jmu.orders.dao.ScheduleDao;
import com.jmu.orders.model.ProSto;
import com.jmu.production.dao.ProductionDao;
import com.jmu.production.model.Production;

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
	@Autowired
	private ScheduleDao scheduleDao;
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
	
	public Info getProList(String stokId){
		Info info = new Info();
		if(stokId == null || "".equals(stokId)){
			info.setOk(false);
			info.setMsg("店家id不能为空");
			return info;
		}
		List<Map> proSto = productionDao.getProStoInfo(stokId);
		info.setDetail("prosto", proSto);
		return info;
	}
	
	public Info add(Production production, String stoId){
		Info info = new Info();
		if(stoId == null || "".equals(stoId)){
			info.setOk(false);
			info.setMsg("门店id不能为空");
			return info;
		}
		if(production.getProName() == null || "".equals(production.getProName())){
			info.setOk(false);
			info.setMsg("产品名称不能为空！");
			return info;
		}
		if(production.getProUse() == null || "".equals(production.getProUse())){
			info.setOk(false);
			info.setMsg("产品用途不能为空！");
			return info;
		}
		if(Integer.valueOf(production.getProPrice()) == null || 0 == Integer.valueOf(production.getProPrice())){
			info.setOk(false);
			info.setMsg("价格不能为空！");
			return info;
		}
		if(Integer.valueOf(production.getProSubscription()) == null || 0 == Integer.valueOf(production.getProSubscription())){
			info.setOk(false);
			info.setMsg("定金不能为空！");
			return info;
		}
		Boolean isAdd = productionDao.addPro(production);
		if(isAdd){
			ProSto ps = new ProSto();
			ps.setProId(production.getProId());
			ps.setStoId(Integer.valueOf(stoId));
			Boolean isOk =  proStoDao.addProSto(ps);
			if(!isOk){
				info.setOk(false);
				info.setMsg("产品门店表操作失败，请通过修改产品信息表进行操作！");
			}
			return info;
		}
		else{
			info.setOk(false);
			info.setMsg("添加产品失败，请重新操作！");
			return info;
		}
	}
	
	public Info edit(Production production, ProSto proSto){
		Info info = new Info();
		if(Integer.valueOf(proSto.getProStoId()) == null || 0 == Integer.valueOf(proSto.getProStoId())){
			info.setOk(false);
			info.setMsg("门店id不能为空");
			return info;
		}
		if(production.getProName() == null || "".equals(production.getProName())){
			info.setOk(false);
			info.setMsg("产品名称不能为空！");
			return info;
		}
		if(production.getProUse() == null || "".equals(production.getProUse())){
			info.setOk(false);
			info.setMsg("产品用途不能为空！");
			return info;
		}
		if(Integer.valueOf(production.getProPrice()) == null || 0 == Integer.valueOf(production.getProPrice())){
			info.setOk(false);
			info.setMsg("价格不能为空！");
			return info;
		}
		if(Integer.valueOf(production.getProSubscription()) == null || 0 == Integer.valueOf(production.getProSubscription())){
			info.setOk(false);
			info.setMsg("定金不能为空！");
			return info;
		}
		Boolean isPro = productionDao.editPro(production);
		Boolean isPs = proStoDao.editProSto(proSto);
		if(!isPro || !isPs){
			info.setOk(false);
			info.setMsg("部分修改失败，请重新操作！");
		}
		return info;
	}
	
	public Info delPro(ProSto proSto){
		Info info = new Info();
		Boolean isSch = scheduleDao.delSch(proSto.getProStoId());
		Boolean isPs = proStoDao.delPs(proSto.getProStoId());
		Boolean isPro = productionDao.delPro(proSto.getProId());
		if(!isPro){
			info.setOk(false);
			info.setMsg("产品表删除--失败！");
		}
		return info;
	}
}
