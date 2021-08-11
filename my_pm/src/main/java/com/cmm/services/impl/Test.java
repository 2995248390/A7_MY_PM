package com.cmm.services.impl;

import java.util.HashMap;
import java.util.Map;

public class Test {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Map<String, String> dto= new HashMap<>();
        dto.put("upsyn", "ÐÂ¹Ú");
        dto.put("upmemo","²âÊÔ");
        dto.put("upurl","baidu.com");
        dto.put("upstate","1");
        dto.put("upiid","2");
        //dto.put("qinno", "2");
        A1060ServicesImpl  services=new A1060ServicesImpl(dto);
        try {
        	
			int rows=services.update();
			System.out.println(rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
