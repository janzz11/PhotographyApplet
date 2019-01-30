package com.jmu.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

/** 
* @author janzz 
* @version 创建时间：2019年1月28日 下午3:10:55 
* 
*/
@RestController
@CrossOrigin
public class FileUpload {
	//图片上传的路径
	private static final String REALPATH = "E:/zdff/apache-tomcat-8.5.35/webapps/images/";
	
	@RequestMapping(value="manage/upload", params="method=img", produces = "application/json;charset=UTF-8")
	public String upload(@RequestParam("ss") MultipartFile multipartFile, HttpServletRequest request){
		Info info = new Info();
		String originFileName = multipartFile.getOriginalFilename();
		String name = originFileName.substring(0, originFileName.lastIndexOf("."));
		String type = originFileName.substring(originFileName.lastIndexOf(".") + 1);
		//TODO:是否判断文件的类型？
		//设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + name + "." + type;
        System.out.println("新文件名称：" + fileName);
        String filePath = REALPATH +fileName;
        File newFile = new File(filePath);
        try{
        	multipartFile.transferTo(newFile);
        	info.setDetail("fileName", fileName);
        }catch(IOException e){
        	e.printStackTrace();
        	info.setOk(false);
        	info.setMsg("文件上传失败！");
        }
		return JSON.toJSONString(info);
	}
}
