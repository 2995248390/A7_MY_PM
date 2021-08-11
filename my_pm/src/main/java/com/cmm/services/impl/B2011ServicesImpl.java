package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

/**
 * FileName: B2011ServicesImpl
 * 
 * Date: 2021��07��30��
 * 
 * @author �����
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: ҽ��ɾ��ҽ�Ƽ�¼
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
