package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;

/**
 * FileName: A1012ServiceImpl
 * 
 * Date: 2021��07��29��
 * 
 * @author �����
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: ����Ա�޸��û�����	
 *
 */

public class A1012ServicesImpl extends JdbcServicesSupport {

	public A1012ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean modifyUser()throws Exception{
		StringBuilder sql = new StringBuilder()
				.append("UPDATE user")
				.append("		set account = ?, upass = ?, truename = ?, idcard = ?,")
				.append("			sex = ?, age = ?, nation = ?, community = ?, birthday = ?,")
				.append("			phonenumber = ?, address = ?, memo = ?,")
				.append("			mail = ?")
				.append("     where uid = ?")
				;
			Object params[] = {
				//��һ��
				this.getString("maccount"),
				Tools.getMd5(this.getString("mpass")),
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
				this.getString("uid"),
		};
			return this.executeUpdate(sql.toString(), params) > 0;
		
	}

}
