package com.cmm.services.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;

/**
 * FileName:      A1021ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          
 *
 * Author:        钱昱同
 * 
 * Email:         1053680842@qq.com
 *
 * Description:   查询医生信息
 *
 */
public class A1021ServicesImpl extends JdbcServicesSupport {

	public A1021ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
public List<Map<String, String>> querydoc() throws Exception {
		
		String did=this.getString("qdid");
		
		String truename=this.getString("qtruename");
		String sex=this.getString("qsex");
		String docstate=this.getString("qdocstate");
		String clinicaddress=this.getString("qclinicaddress");
		String clinicname=this.getString("qclinicname");
		String level=this.getString("qlevel");
		String community=this.getString("qcommunity");
		StringBuilder sql=new StringBuilder()
			    .append("select x.uid,x.did,y.truename,b.svalue cnsex,x.clinicaddress,")
				  .append("			      x.clinicname,e.svalue cncommunity,d.svalue cndocstate")
					.append("		  from syscode a,syscode b, syscode c,syscode d,syscode e,doc x,`user` y")
					.append("		 where y.uid=x.uid")
					.append("	    and a.sname='nation' and a.scode=y.nation")
					.append("		and b.sname='sex'      and b.scode=y.sex")
					.append("	  and c.sname='level'    and c.scode=x.`level`")
					.append("	  and d.sname='docstate' and d.scode=x.docstate")
					.append("	  and e.sname='community' and e.scode=y.community")
                   ;
		List<Object> paramList=new ArrayList<>();
		
		if(this.isNotNull(did))
		{
			sql.append(" and x.did=?");
			paramList.add(did);
		}
		if(this.isNotNull(truename))
		{
			sql.append(" and y.truename like ?");
			paramList.add("%"+truename+"%");
		}
		if(this.isNotNull(sex))
		{
			sql.append(" and y.sex=?");
			paramList.add(sex);
		}
		if(this.isNotNull(docstate))
		{
			sql.append(" and x.docstate=?");
			paramList.add(docstate);
		}		
		if(this.isNotNull(level))
		{
			sql.append(" and x.`level`=?");
			paramList.add(level);
		}
		if(this.isNotNull(community))
		{
			sql.append(" and y.community=?");
			paramList.add(community);
		}
		
		return this.queryForPage(sql.toString(),10, paramList.toArray());
	}

	
	
}
