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
 * Author:        钱昱同
 * 
 * Email:         1053680842@qq.com
 *
 * Description:   删除医疗记录（未使用）
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
