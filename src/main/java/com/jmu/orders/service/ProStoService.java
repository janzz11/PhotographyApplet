package com.jmu.orders.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.common.Info;
import com.jmu.orders.dao.ProStoDao;
import com.jmu.orders.dao.ScheduleDao;
import com.jmu.orders.model.ProSto;

/** 
* @author janzz 
* @version 创建时间：2018年12月25日 下午5:25:56 
* 
*/
@Service
public class ProStoService {
	
	@Autowired
	private ProStoDao proStoDao; 
	@Autowired 
	private ScheduleDao scheduleDao;
	
	public Info getList(ProSto proSto) {
		Info info = new Info();
		List<Map> pro = proStoDao.getProList(proSto);
		info.setDetail("proInfo", pro);
		return info;
	}
	
	public Info add(ProSto proSto) {
		Info info = new Info();
		if(Integer.valueOf(proSto.getProId()) == null || Integer.valueOf(proSto.getProId()) == 0) {
			info.setMsg("proId不能为空！");
			info.setOk(false);
			return info;
		}
		if(Integer.valueOf(proSto.getStoId()) == null || Integer.valueOf(proSto.getStoId()) == 0) {
			info.setMsg("stoId不能为空！");
			info.setOk(false);
			return info;
		}
		List<ProSto> ps = proStoDao.getProSto(proSto);
		if(ps != null && ps.size() != 0) {
			info.setMsg("该门店已经有添加过此类产品了！");
			info.setOk(false);
			return info;
		}
		Boolean isAdd = proStoDao.addProSto(proSto);
		if(!isAdd) {
			info.setMsg("添加失败，请重新操作！");
			info.setOk(false);
		}
		return info;
	}
	
	public Info del(ProSto proSto) {
		Info info = new Info();
		if(Integer.valueOf(proSto.getProStoId()) == null || Integer.valueOf(proSto.getProStoId()) == 0) {
			info.setMsg("proStoId不能为空！");
			info.setOk(false);
			return info;
		}
		scheduleDao.delSch(proSto.getProStoId());
		Boolean isDel = proStoDao.delPs(proSto.getProStoId());
		if(!isDel) {
			info.setMsg("删除失败，请重新操作！");
			info.setOk(false);
		}
		return info;
	}
}
