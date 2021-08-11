package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class A1013ServicesImpl extends JdbcServicesSupport {

	public A1013ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean deleteUser() throws Exception{
		StringBuilder sql = new StringBuilder()
				.append("update user")
				.append("   set userstate = '2'")
				.append(" where uid = ?")
				;
		return this.batchUpdate(sql.toString(), this.getIntArray("uid"));
		
	}

}
