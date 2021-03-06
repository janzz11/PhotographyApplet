package com.jmu.utils;
 import java.security.MessageDigest;
   
/**
 * 对密码进行加密和验证的类
 * 模仿主流php系统的登录验证
 * 
 * @author chen
 *
 */
 public class CipherUtil{  
       
     private final static String[] hexDigits = {"0", "1", "2", "3", "4",  
         "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};  
       
     /** * 把inputString加密     */  
     public static String generatePassword(String inputString){  
         return encodeByMD5(inputString);  
     }  
       
      
     public static boolean validatePassword(String password, String inputString){  
         if(password.equals(encodeByMD5(inputString))){  
             return true;  
         } else{  
             return false;  
         }  
     }  
     public static String returnEncodeByMde(String originString){
    	 return encodeByMD5(originString);
     }
     /**  对字符串进行MD5加密     */  
     public static String encodeByMD5(String originString){  
         if (originString != null){  
             try{  
                 MessageDigest md = MessageDigest.getInstance("MD5");  
                 //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算  
                 byte[] results = md.digest(originString.getBytes());  
                 //将得到的字节数组变成字符串返回  
                 String resultString = byteArrayToHexString(results);  
                 String pass =  resultString.toUpperCase();  
                 return pass;
             } catch(Exception ex){  
                 ex.printStackTrace();  
             }  
         }  
         return null;  
     }  
       
   
     private static String byteArrayToHexString(byte[] b){  
         StringBuffer resultSb = new StringBuffer();  
         for (int i = 0; i < b.length; i++){  
             resultSb.append(byteToHexString(b[i]));  
         }  
         return resultSb.toString();  
     }  
       
     /** 将一个字节转化成十六进制形式的字符串     */  
     private static String byteToHexString(byte b){  
         int n = b;  
         if (n < 0)  
             n = 256 + n;  
         int d1 = n / 16;  
         int d2 = n % 16;  
         return hexDigits[d1] + hexDigits[d2];  
     }  
     
     
     public static String encode(String pwd,String encrypt){
    	 pwd=encodeByMD5(pwd).toLowerCase()+encrypt;
    	 pwd=encodeByMD5(pwd).toLowerCase();
    	 return pwd;
     }
     
     
     public static void main(String[] args){    	 
    	 String pwd1="123456";
    	 String encrypt="CVGGHA";
    	 System.out.println(encode(pwd1, encrypt));
     }
 }  