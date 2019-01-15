package com.jmu.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmu.test.dao.DemoDao;
import com.jmu.test.model.Demo;

/** 
* @author janzz 
* @version 创建时间：2018年12月19日 上午10:12:53 
* 
*/
@Service
public class DemoService {
	@Autowired 
	private DemoDao demoDao;
	public List<Demo> getDetail(){
		List<Demo> result = demoDao.getDetail();
		return result;
	}
}
