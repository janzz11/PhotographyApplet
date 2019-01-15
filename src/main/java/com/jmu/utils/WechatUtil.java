package com.jmu.utils;

import com.alibaba.fastjson.JSONObject;

/** 
* @author janzz 
* @version 创建时间：2019年1月8日 下午8:21:49 
* 
*/
public class WechatUtil {
	private static final String APPID = "wxaa0a5f331d2f6fb0";
	private static final String SECRET = "e421d1498f9221ee41327148fcebc3b8";
	public static String getOpenId(String jsCode){
		String api = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+jsCode+"&grant_type=authorization_code";
		String info = HttpClient3.doGet(api);
		JSONObject json = JSONObject.parseObject(info);
		return (String) json.get("openid");
	}
}
