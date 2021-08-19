package com.cmm.services.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
/**
 * FileName:      A2012Action
 *
 * FileType:      Action
 *
 * Date:          2021年07月29日
 *
 * Author:        罗航
 *
 * Description:   个人信息管理
 *
 */
public class A1070ServiceImpl extends JdbcServicesSupport {

	public A1070ServiceImpl(Map<String, String> dto) {
		super(dto);
	}
	//更新用户数据
	public boolean updatePerson(String uid) throws Exception 
	{
		String truename = this.getString("truename");
		String age = this.getString("age");
		String nation = this.getString("nation");
		String sex = this.getString("sex");
		String birthday = this.getString("birthday");
		String phonenumber = this.getString("phonenumber");
		String address = this.getString("address");
		String community = this.getString("community");
		String memo = this.getString("memo");
		StringBuilder sql = new StringBuilder()
				.append("update user set  ");	
		List<Object> paramList = new ArrayList<>();
		if(this.isNotNull(truename)) {
			sql.append("truename=?,");
			paramList.add(truename);
		}
		if(this.isNotNull(age)) {
			sql.append("age=?,");
			paramList.add(age);
		}
		if(this.isNotNull(nation)) {
			sql.append("nation=?,");
			paramList.add(nation);
		}
		if(this.isNotNull(sex)) {
			sql.append("sex=?,");
			paramList.add(sex);
		}
		if(this.isNotNull(birthday)) {
			sql.append("birthday=?,");
			paramList.add(birthday);
		}
		if(this.isNotNull(phonenumber)) {
			sql.append("phonenumber=?,");
			paramList.add(phonenumber);
		}
		if(this.isNotNull(community)) {
			sql.append("community=?,");
			paramList.add(community);
		}
		if(this.isNotNull(memo)) {
			sql.append("memo=?,");
			paramList.add(memo);
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append("where  uid =?");
		paramList.add(uid);
		return this.executeUpdate(sql.toString(), paramList.toArray())>0;
	}
}
