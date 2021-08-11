package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class A2011ServicesImpl extends JdbcServicesSupport{

	public A2011ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean modifyDoc(String uid)throws Exception{
		StringBuilder sql1 = new StringBuilder()
				.append("UPDATE user")
				.append("		set account = ?, upass = ?, truename = ?, idcard = ?,")
				.append("			sex = ?, age = ?, nation = ?, community = ?, birthday = ?,")
				.append("			phonenumber = ?, address = ?, memo = ?,")
				.append("			mail = ?")
				.append("     where uid = ?")
				;
		
		Object params1[] = {
				//��һ��
				this.getString("maccount"),
				this.getString("mupass"),
				this.getString("mtruename"),
				this.getString("midcard"),
				//�ڶ���
				this.getString("msex"),
				this.getString("mage"),
				this.getString("mnation"),
				this.getString("mcommunity"),
				this.getString("mbirthday"),
				//������
				this.getString("mphonenumber"),
				this.getString("maddress"),
				this.getString("mmemo"),
				//������
				this.getString("mmail"),
				//������
				Integer.parseInt(uid),	
		};
		for(Object param:params1 ) {
			System.out.print(param+" ");
		}
		
		this.regSqlToTransaction(sql1.toString(), params1);
		StringBuilder sql2 = new StringBuilder()
				.append("update doc")
				.append("  set `level` = ?, clinicname= ?, clinicaddress= ?,")
				.append("	 workyear= ?, docstate= ?, description = ?")
				.append("    where uid = ?;")
				;
		Object params2[] = {
				this.getString("mlevel"),
				this.getString("mclinicname"),
				this.getString("mclinicaddress"),
				this.getString("mworkyear"),
				this.getString("mdocstate"),
				this.getString("mdescription"),
				Integer.parseInt(uid),	
		};
		System.out.println();
		for(Object param:params2 ) {
			System.out.print(param);
		}
		
		 this.regSqlToTransaction(sql2.toString(), params2);
		 return this.executeTrasaction();
	}
}
