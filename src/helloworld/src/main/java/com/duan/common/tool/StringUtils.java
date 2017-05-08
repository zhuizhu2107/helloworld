package com.duan.common.tool;

public class StringUtils {
	
	/**
	 * 验证非空非null
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null&&!"".equals(str)){
			return true;
		}
		return false;
	}
	
	/**
	 * 首字母大写
	 * 
	 * @param name
	 * @return
	 */
	public static String captureName(String str) {
		char[] cs = str.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);
	}
	
	/**
	 * 首字母小写
	 * 
	 * @param name
	 * @return
	 */
	public static String lowerName(String str) {
		char[] cs = str.toCharArray();
		cs[0] += 32;
		return String.valueOf(cs);
	}
	
}
