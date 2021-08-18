package com.cmm.system.tools;
//一些工具为了更好的让我们写代码好维护
public class LuoTools {
	private LuoTools() {}
	//数据改写,有些数据不能直接显示,只显示首位,中间由*代替
	public static String encryptString(String str) {
		if(str==null || "".equals(str)) {
			return "";
		}
		int len = str.length();
		String start = str.substring(0,1);
		String end = str.substring(len-1);
		StringBuilder result = new StringBuilder().append(start);
		for(int i=0 ; i<len-2;i++) {
			result.append("*");
		}
		result.append(end);
		return result.toString();
	}
}