package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

/**
 * FileName: B2011ServicesImpl
 * 
 * Date: 2021年07月30号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 医生删除医疗记录
 *
 */

public class B2011ServicesImpl extends JdbcServicesSupport {

	public B2011ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean deleteRecord() throws Exception{
		StringBuilder sql = new StringBuilder()
				.append("update record")
				.append("	set state = '2'")
				.append(" where rid = ?; ")
				;
	    return this.executeUpdate(sql.toString(), this.getString("rid")) > 0;
		
	}
}
