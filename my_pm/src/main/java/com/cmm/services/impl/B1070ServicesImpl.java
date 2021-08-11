package com.cmm.services.impl;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
/**
 * FileName:      B1070ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          
 *
 * Author:        钱昱同
 * 
 * Email:         1053680842@qq.com
 *
 * Description:   查询医疗记录信息
 *
 */
public class B1070ServicesImpl extends JdbcServicesSupport {
	public B1070ServicesImpl(Map<String, String> dto) {
		super(dto);
	}

	public Map<String, String> findByOid() throws Exception {
		
			StringBuilder sql=new StringBuilder()
					.append("select x.truename, x.idcard, a.svalue cnsex, x.age, b.svalue cnnation,")
					.append("	   c.onum, x.phonenumber, d.docsuggestion, d.drugmsg,c.begintime,c.overtime")
					.append("  from user x, syscode a, syscode b, orderlist c, record d")
					.append(" where d.oid = ? and d.oid = c.oid and")
					.append("	   c.uid = x.uid and a.sname = 'sex' and")
					.append("	   a.scode = x.sex and b.sname = 'nation' and")
					.append("	   b.scode = x.nation")
					
					;
			return this.queryForMap(sql.toString(), this.getInteger("oid"));		
	}
	public Map<String, String> getDocname() throws Exception {
		StringBuilder sql2=new StringBuilder()
				.append("select x.truename")
				.append("  from user x, doc y, orderlist z")
				.append(" where z.oid = ? and z.did = y.did and")
				.append("	   y.uid = x.uid")
			
				;
				return this.queryForMap(sql2.toString(), this.getInteger("oid"));	
}
}
