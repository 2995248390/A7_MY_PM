package com.cmm.services.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
/**
 * FileName:      C1080ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021��07��30��
 *
 * Author:        Ǯ��ͬ
 *
 * Description:  ��ѯ��Ѷ
 *
 */
public class C1080ServiceImpl extends JdbcServicesSupport {
	public C1080ServiceImpl(Map<String, String> dto) {
		super(dto);
	}
	public List<Map<String,String>> getInfomation() throws Exception{
		StringBuilder sql = new StringBuilder()
				.append(" SELECT iid,url,memo,text ")
				.append(" from information ")
				.append("  where state='1'  ")
				;
		return this.queryForList(sql.toString());
	}
}
