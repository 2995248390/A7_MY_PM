package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

/**
 * FileName: B1020ServicesImpl
 * 
 * Date: 2021年07月30号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 查看诊所信息
 *
 */


public class B1020ServicesImpl extends JdbcServicesSupport {

	public B1020ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public Map<String,String> querClin() throws Exception{
		StringBuilder sql = new StringBuilder()
				.append("select x.truename, y.clinicname, a.scode cndocstate, x.age, b.scode cnsex,")
				.append("		c.scode cnlevel, x.phonenumber, x.mail, y.clinicname, y.begintime,") 
				.append("		y.clinicaddress, y.workyear, y.description,  y.open1, y.close1,")
				.append("		y.open2, y.close2, y.getday, y.getnum1, y.getnum2,")
				.append("		y.clinicdes")
				.append("  from user x, doc y, syscode a, syscode b, syscode c")
				.append(" where x.uid = y.uid and a.sname = 'docstate' and")
				.append("       a.scode = y.docstate and b.sname = 'sex' and ")
				.append("		b.scode = x.sex and c.sname = 'level' and ")
				.append("		c.scode = y.level and x.uid = ?")
				;	
		return this.queryForMap(sql.toString(), this.getString("uid"));
		
	}
	
	
}
