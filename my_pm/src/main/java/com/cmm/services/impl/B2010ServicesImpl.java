package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

/**
 * FileName: B2010ServicesImpl
 * 
 * Date: 2021年07月30号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 医生查看医疗记录
 *
 */

public class B2010ServicesImpl extends JdbcServicesSupport{

	public B2010ServicesImpl(Map<String, String> dto) {
		super(dto);
		// TODO Auto-generated constructor stub
	}
	
	public Map<String,String> findByRid()throws Exception
	{
		StringBuilder sql=new StringBuilder()
				.append("select x.truename, x.idcard, a.scode cnsex, x.age, b.svalue cnnation,")
				.append("	    c.onum, x.phonenumber, d.docsuggestion, d.drugmsg, d.begintime")
				.append("  from user x, syscode a, syscode b, orderlist c, record d")
				.append(" where d.rid = ? and d.oid = c.oid and")
				.append("	   c.uid = x.uid and a.sname = 'sex' and")
				.append("	   a.scode = x.sex and b.sname = 'nation' and")
				.append("	   b.scode = x.nation")
				
				;
		return this.queryForMap(sql.toString(), this.getInteger("rid"));
	}
	
	public List<Map<String,String>> queryDoc()throws Exception{
		String did=this.getString("did");
		String name=this.getString("qtruename");
		String idcard=this.getString("qidcard");
		String sex=this.getString("qsex");
		String nation=this.getString("qnation");
		String age=this.getString("qage");
		String qcommunity=this.getString("qcommunity");
		String begintime=this.getString("qbegintime");
		StringBuilder sql=new StringBuilder()
				.append("select d.rid, a.idcard, a.account, a.truename, e.svalue cnsex, ")
				.append("	   d.docsuggestion, d.drugmsg")
				.append("  from doc b, orderlist c, record d, syscode e,`user` a, ")
				.append("	   syscode f, syscode g")
				.append(" where b.did = ? and b.did = c.did and")
				.append("       c.uid = a.uid and c.oid = d.oid and")
				.append("	   a.sex = e.scode and e.sname = 'sex' and ")
				.append("	   a.nation = f.scode and f.sname = 'nation' and")
				.append("	   a.community = g.scode and g.sname = 'community'and")
				.append("	   d.state = '1'")
				;
		List<Object> paramList=new ArrayList<>();
		paramList.add(did);
		
		if(this.isNotNull(name))
		{
			sql.append(" and a.truename like ?");
			paramList.add(name);
		}
		if(this.isNotNull(idcard))
		{
			sql.append(" and a.idcard = ?");
			paramList.add("%"+idcard+"%");
		}
		if(this.isNotNull(sex))
		{
			sql.append(" and a.sex=?");
			paramList.add(sex);
		}
		if(this.isNotNull(nation))
		{
			sql.append(" and a.nation=?");
			paramList.add(nation);
		}
		if(this.isNotNull(age))
		{
			sql.append(" and a.age=?");
			paramList.add(age);
		}
		if(this.isNotNull(qcommunity))
		{
			sql.append(" and a.community=?");
			paramList.add(qcommunity);
		}
		if(this.isNotNull(begintime))
		{
			sql.append(" and d.begintime = str_to_date(?, '%Y-%m-%d')");
			paramList.add(begintime);
		}
		
		return this.queryForPage(sql.toString(),10, paramList.toArray());
		
	}

}
