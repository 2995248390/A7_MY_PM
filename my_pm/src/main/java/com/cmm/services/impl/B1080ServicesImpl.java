package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
/**
 * FileName:      B1080ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          
 *
 * Author:        钱昱同
 * 
 * Email:         1053680842@qq.com
 *
 * Description:   查询医疗记录，体检记录
 *
 */
public class B1080ServicesImpl extends JdbcServicesSupport {

	public B1080ServicesImpl(Map<String, String> dto) {
		super(dto);
	}

	public Map<String, String> findByRid() throws Exception {
		
			StringBuilder sql=new StringBuilder()
					.append("select d.rid, x.truename, x.idcard, a.svalue cnsex, x.age, b.svalue cnnation,")
					.append("	    c.onum, x.phonenumber, d.docsuggestion, d.drugmsg,d.begintime")
					.append("  from user x, syscode a, syscode b, orderlist c, record d")
					.append(" where d.rid = ? and d.oid = c.oid and")
					.append("	    c.uid = x.uid and a.sname = 'sex' and")
					.append("	    a.scode = x.sex and b.sname = 'nation' and")
					.append("	    b.scode = x.nation")
					
					;
			return this.queryForMap(sql.toString(), this.getInteger("rid"));
		
	}
	
	public Map<String, String> findByUid() throws Exception {
		StringBuilder sql=new StringBuilder()
				.append(" select x.bid,x.blood,x.height,x.airs,")
				.append("				x.weight,x.airs,x.begintime,")
				.append("				y.truename,y.age,y.phonenumber,")
				.append("				a.svalue cnsex")
				.append(" from bodymsg x, `user` y, syscode a")
				.append(" where x.uid=y.uid ")
				.append("		and a.sname='sex' and a.scode=y.sex")
				.append("       and x.uid=?")
				;
				return this.queryForMap(sql.toString(), this.getInteger("uid"));
	
			}
}
