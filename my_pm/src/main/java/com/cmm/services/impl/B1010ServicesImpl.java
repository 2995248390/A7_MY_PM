package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

/**
 * FileName: A1010ServicesImpl
 * 
 * Date: 2021年07月29号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 医生个人信息查询
 *
 */

public class B1010ServicesImpl extends JdbcServicesSupport{

	public B1010ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public Map<String,String> querDoc() throws Exception{
		StringBuilder sql = new StringBuilder()	
		.append("select x.account, x.upass, x.truename, x.idcard, a.scode cnsex,")
		.append("			 x.age, b.svalue cnnation, c.svalue community, x.birthday, x.phonenumber,")
		.append("			 x.address, x.mail, d.scode cnlevel, y.clinicname, y.clinicaddress,")
		.append("			 y.workyear, e.scode cndocstate, y.begintime, y.description, x.memo,")
		.append("			 y.specialty, y.docdes, y.learndes")
		.append(" from  user x, syscode a, syscode b, syscode c, doc y, syscode d, syscode e")
		.append(" where a.sname = 'sex' and x.sex = a.scode and")
		.append("			 b.sname = 'nation' and x.nation = b.scode and")
		.append("			 c.sname = 'community' and x.community = c.scode and")
		.append("			 d.sname = 'level' and y.level = d.scode and")
		.append("			 e.sname = 'docstate' and y.docstate = e.scode and")
		.append("			 x.uid = y.uid and x.uid = ?;")
		;
		
		return this.queryForMap(sql.toString(), this.getString("uid"));
		
	}

}
