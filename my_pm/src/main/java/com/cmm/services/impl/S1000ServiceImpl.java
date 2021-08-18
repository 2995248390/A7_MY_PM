package com.cmm.services.impl;

import java.io.InputStream;
import java.util.Map;
/**
 * FileName:      S1000ServiceImpl
 *
 * FileType:      ServiceImpl
 *
 * Date:          2021��8��18��
 *
 * Author:        �޺�
 *
 * Description:   ���ý϶�Ĺ���
 *
 */
import com.cmm.services.support.JdbcServicesSupport;

public class S1000ServiceImpl extends JdbcServicesSupport {

	public S1000ServiceImpl(Map<String, String> dto) {
		super(dto);
		// TODO Auto-generated constructor stub
	}
	//����û���Ƭ
	public InputStream getUserImg(String id) throws Exception {
		String sql = "select userimg from user where uid=?";
		Map<String,Object> ins =  this.queryForMapAndImg(sql, id);
		return (InputStream) ins.get("userimg");
	}
	//���ҽ����Ƭ
	public InputStream getDocImg(String id) throws Exception {
		String sql = "select docimg from doc where did=?";
		Map<String,Object> ins =  this.queryForMapAndImg(sql, id);
		return (InputStream) ins.get("docimg");
	}
	//���������Ƭ
	public InputStream getClinicImg(String id) throws Exception {
		String sql = "select clinicimg from doc where did=?";
		Map<String,Object> ins =  this.queryForMapAndImg(sql, id);
		return (InputStream) ins.get("clinicimg");
	}
	
}
