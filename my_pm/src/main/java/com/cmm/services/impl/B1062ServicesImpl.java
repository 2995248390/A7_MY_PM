package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
/**
 * FileName:      B1062ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          
 *
 * Author:        Ǯ��ͬ
 * 
 * Email:         1053680842@qq.com
 *
 * Description:   ɾ��ҽ�Ƽ�¼��δʹ�ã�
 *
 */
public class B1062ServicesImpl extends JdbcServicesSupport {

	public B1062ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean deleteRecord() throws Exception{
		StringBuilder sql = new StringBuilder()
				.append("update record")
				.append("	set state = '2'")
				.append("   where rid = ?; ")
				;
		System.out.println(this.getString("rid"));
	    return this.executeUpdate(sql.toString(), this.getString("rid")) > 0;
		
	}

}
