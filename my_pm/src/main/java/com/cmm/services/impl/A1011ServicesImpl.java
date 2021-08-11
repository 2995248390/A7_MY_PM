package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;

/**
 * FileName: A1011ServicesImpl
 * 
 * Date: 2021��07��28��
 * 
 * @author �����
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: ����Ա����û�	
 *
 */

public class A1011ServicesImpl extends JdbcServicesSupport {

	public A1011ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean addUser()throws Exception{
		StringBuilder sql=new StringBuilder()
				.append("insert into user(account,upass,truename,idcard,systype,")	
				.append("				  sex,age,nation,community,birthday, ")	          
				.append("				  phonenumber,begintime,address,userstate,memo,")	             
				.append("				  mail)")	
				.append("		   values(?,?, ?, ?, ?,")	 
				.append("				  ?, ?, ?, ?, str_to_date(?, '%Y-%m-%d'),")	
				.append("				  ?, current_timestamp, ?, ?, ?,")	 
				.append("				  ?)")	
				;
		Object params[] = {
				//��һ��
				this.getString("maccount"),
				Tools.getMd5(this.getString("mpass")),
				this.getString("mtruename"),
				this.getString("midcard"),
				"2",
				//�ڶ���
				this.getString("msex"),
				this.getString("mage"),
				this.getString("mnation"),
				this.getString("mcommunity"),
				this.getString("mbirthday"),
				//������
				this.getString("mphonenumber"),
				this.getString("maddress"),
				"1",
				this.getString("mmemo"),
				//������
				this.getString("mmail"),	
		};
		
		return this.executeUpdate(sql.toString(), params) > 0;
	}
	

}
