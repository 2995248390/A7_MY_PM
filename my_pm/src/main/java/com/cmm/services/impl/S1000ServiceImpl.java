package com.cmm.services.impl;

import java.io.InputStream;
import java.util.Map;
/**
 * FileName:      S1000ServiceImpl
 *
 * FileType:      ServiceImpl
 *
 * Date:          2021年8月18日
 *
 * Author:        罗航
 *
 * Description:   复用较多的工具
 *
 */
import com.cmm.services.support.JdbcServicesSupport;

public class S1000ServiceImpl extends JdbcServicesSupport {

	public S1000ServiceImpl(Map<String, String> dto) {
		super(dto);
		// TODO Auto-generated constructor stub
	}
	//获得用户照片
	public InputStream getUserImg(String id) throws Exception {
		String sql = "select userimg from user where uid=?";
		Map<String,Object> ins =  this.queryForMapAndImg(sql, id);
		return (InputStream) ins.get("userimg");
	}
	//获得医生照片
	public InputStream getDocImg(String id) throws Exception {
		String sql = "select docimg from doc where did=?";
		Map<String,Object> ins =  this.queryForMapAndImg(sql, id);
		return (InputStream) ins.get("docimg");
	}
	//获得诊所照片
	public InputStream getClinicImg(String id) throws Exception {
		String sql = "select clinicimg from doc where did=?";
		Map<String,Object> ins =  this.queryForMapAndImg(sql, id);
		return (InputStream) ins.get("clinicimg");
	}
	
}
