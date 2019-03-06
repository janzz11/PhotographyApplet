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
		List<Production> pro = productionDao.getProInfo(production);
		Production proDetail = null;
		if(pro != null && pro.size() != 0) {
			proDetail = pro.get(0);
		}
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
	
	public Info add(Production production){
		Info info = new Info();
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
		Production cur = new Production();
		cur.setProName(production.getProName());
		List<Production> curPro = productionDao.getProInfo(cur);
		if(curPro != null && curPro.size()!=0) {
			info.setMsg("产品名称已经存在，请换一个名称？");
			info.setOk(false);
			return info;
		}
		Boolean isAdd = productionDao.addPro(production);
		if(!isAdd){
			info.setOk(false);
			info.setMsg("产品门店表操作失败，请通过修改产品信息表进行操作！");
		}
		return info;
	}
	
	public Info edit(Production production){
		Info info = new Info();
		if(Integer.valueOf(production.getProId()) == null || 0 == Integer.valueOf(production.getProId())){
			info.setOk(false);
			info.setMsg("产品Id不能为空！");
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
		Production cur = new Production();
		cur.setProName(production.getProName());
		List<Production> curPro = productionDao.getProInfo(cur);
		if(curPro != null && curPro.size()!=0 && !(curPro.get(0).getProId() == production.getProId())) {
			info.setMsg("产品名称已经存在，请换一个名称？");
			info.setOk(false);
			return info;
		}
		Boolean isPro = productionDao.editPro(production);
		if(!isPro){
			info.setOk(false);
			info.setMsg("修改失败，请重新操作！");
		}
		return info;
	}
	
	public Info delPro(Production production){
		Info info = new Info();
//		Boolean isSch = scheduleDao.delSch(proSto.getProStoId());
//		Boolean isPs = proStoDao.delPs(proSto.getProStoId());
		ProSto proSto  = new ProSto();
		proSto.setProId(production.getProId());
		List<ProSto> proStoList = proStoDao.getProSto(proSto);
		if(proStoList !=null && proStoList.size() != 0) {
			for(int i = 0 ; i < proStoList.size(); i++) {
				proStoDao.delPs(proStoList.get(i).getProStoId());
				scheduleDao.delSch(proStoList.get(i).getProStoId());
			}
		}
		Boolean isPro = productionDao.delPro(production.getProId());
		if(!isPro){
			info.setOk(false);
			info.setMsg("产品表删除--失败！");
		}
		return info;
	}
}
