package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

/**
 * FileName: B1011ServicesImpl
 * 
 * Date: 2021年07月29号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 医生修改个人信息	
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
				//第一行
				this.getString("mtruename"),
				//第二行
				this.getString("mmemo"),
				//第三行
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
