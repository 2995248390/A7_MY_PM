package com.cmm.system.tools;
//һЩ����Ϊ�˸��õ�������д�����ά��
public class LuoTools {
	private LuoTools() {}
	//���ݸ�д,��Щ���ݲ���ֱ����ʾ,ֻ��ʾ��λ,�м���*����
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