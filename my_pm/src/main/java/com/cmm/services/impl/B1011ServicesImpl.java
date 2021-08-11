package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

/**
 * FileName: B1011ServicesImpl
 * 
 * Date: 2021��07��29��
 * 
 * @author �����
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: ҽ���޸ĸ�����Ϣ	
 *
 */

public class B1011ServicesImpl extends JdbcServicesSupport{

	public B1011ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean modifyDoc(String uid)throws Exception{
		StringBuilder sql1 = new StringBuilder()
				.append("UPDATE user")
				.append("		set truename = ?,")
				.append("		    memo = ?")
				.append("     where uid = ?")
				;
		
		Object params1[] = {
				//��һ��
				this.getString("mtruename"),
				//�ڶ���
				this.getString("mmemo"),
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
				.append("	 workyear= ?, docstate= ?, description = ?,")
				.append("	 specialty = ?, docdes = ?, learndes = ?")
				.append("    where uid = ?;")
				;
		Object params2[] = {
				this.getString("mlevel"),
				this.getString("mclinicname"),
				this.getString("mclinicaddress"),
				this.getString("mworkyear"),
				this.getString("mdocstate"),
				this.getString("mdescription"),
				this.getString("mspecialty"),
				this.getString("mdocdes"),
				this.getString("mlearndes"),
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
