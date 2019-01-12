package sdut.blog.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encrypt {
	 
	//数据解密
	public static String decrypt(String key) throws Exception {  
        return new String ( (new BASE64Decoder()).decodeBuffer(key) );  
    }  
       
    //数据加密
    public static String encrypt(String key) throws Exception {
    	byte[] str = key.substring(0, key.length()).getBytes();
        return (new BASE64Encoder()).encodeBuffer(str);  
    }
    
    /*public  static void main (String argv[]) throws Exception {
    	String str = "asdfghj";
    	String s1 = Encrypt.encrypt(str);
    	System.out.println(s1);
    	String s2=Encrypt.decrypt(s1).toString();
    	System.out.println(s2);
    	if(s2.equals(str)) {
    		System.out.println("周旋是居");
    	}
    }*/
}
