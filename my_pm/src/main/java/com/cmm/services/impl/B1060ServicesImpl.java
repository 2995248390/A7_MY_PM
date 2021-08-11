package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;
/**
 * FileName:      B1060ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          
 *
 * Author:        钱昱同
 * 
 * Email:         1053680842@qq.com
 *
 * Description:   查找病人
 *
 */
public class B1060ServicesImpl extends JdbcServicesSupport {
	public B1060ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
public List<Map<String, String>> querypatient(String did) throws Exception {
		
		String oid=this.getString("qoid");		
		String truename=this.getString("qtruename");
		String sex=this.getString("qsex");	
		String nation=this.getString("qnation");
		String community=this.getString("qcommunity");
		String btime=this.getString("btime");
		String etime=this.getString("etime");
		StringBuilder sql=new StringBuilder()
				.append("select distinct x.oid, y.truename, a.svalue cnsex, b.svalue cnnation,")
				.append("       c.svalue cncommunity, z.rid,y.uid,z.state,z.begintime ")
				.append("from syscode a,syscode b, syscode c, orderlist x, `user` y,")
				.append("	       record z,doc r  			")
				.append("				 where  y.uid=x.uid  and x.oid=z.oid and r.did=x.did ")
				.append("			  and a.sname='sex' and a.scode=y.sex ")
				.append("			  and b.sname='nation' and b.scode=y.nation ")
				.append("	      and c.sname='community' and c.scode=y.community ")
                   ;
		List<Object> paramList=new ArrayList<>();
		
		if(this.isNotNull(oid))
		{
			sql.append(" and x.oid=?");
			paramList.add(oid);
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
		if(this.isNotNull(nation))
		{
			sql.append(" and y.nation=?");
			paramList.add(nation);
		}		
		
		if(this.isNotNull(community))
		{
			sql.append(" and y.community=?");
			paramList.add(community);
		}
		if(this.isNotNull(btime))
		{
			sql.append(" and x.begintime >= ?");
			paramList.add(btime);
		}
		if(this.isNotNull(etime))
		{
			sql.append(" and x.begintime<=?");
			paramList.add(etime);
		}
		sql.append(" and r.did=?  ");
		paramList.add(did);
		
		
		//查体检记录id
		List<Object> paramList2=new ArrayList<>();
		StringBuilder sql2=new StringBuilder();
		sql2.append(" SELECT x.bid");
		sql2.append(" from bodymsg x, `user` y, orderlist z");
		sql2.append(" where x.uid=y.uid and z.uid=y.uid");
		sql2.append(" and z.oid=?;");
		
		paramList2.add(oid);
		
		
		
		
		return this.queryForPage(sql.toString(),10, paramList.toArray());
	}
	
	
	
}
