/**
 * FileName:      A1050ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021年07月29日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   管理员评价管理
 *
 */
package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class A1050ServicesImpl extends JdbcServicesSupport
{

	public A1050ServicesImpl(Map<String, String> dto)
	{
		super(dto);
		// TODO Auto-generated constructor stub
	}
	
	public int batchShow()throws Exception
	{
		//定义sql语句
		StringBuilder sql=new StringBuilder()
			.append("update appraise a")
			.append("	 set a.appraisestate=1")
			.append(" where aid=? ")
			
			;
		if(this.judgeDto("aid")==false)
			return 3;
		Integer idlist[]=this.getIntArray("aid");
		return this.batchUpdate(sql.toString(), idlist)==true?1:2;
	}
	
	public int batchHide()throws Exception
	{
		//定义sql语句
		StringBuilder sql=new StringBuilder()
			.append("update appraise a")
			.append("	 set a.appraisestate=2")
			.append(" where aid=? ")
			
			;
		
		if(this.judgeDto("aid")==false)
			return 3;
		Integer idlist[]=this.getIntArray("aid");
		return this.batchUpdate(sql.toString(), idlist)==true?1:2;
	}
	
	
	public List<Map<String,String>> queryAppraise()throws Exception
	{
		//还原查询参数
		String account=this.getString("qaccount");
		String truename=this.getString("qtruename");
		String community=this.getString("qcommunity");
		String userstate=this.getString("quserstate");
		String sex=this.getString("qsex");
		String bgrade=this.getString("bgrade");
		String egrade=this.getString("egrade");
		String appraisestate=this.getString("qappraisestate");
		
		//定义查询sql语句
		StringBuilder sql=new StringBuilder()
				.append("select c.aid,a.account,a.truename,c.appraisestate,c.grade,c.text,f.svalue")
				.append("  from user a,orderlist b,appraise c,syscode d,syscode e,syscode f")
				.append(" where a.uid=b.uid and b.oid=c.oid")
				.append("	 and d.sname='sex' and d.scode=a.sex")
				.append("	 and e.sname='community' and e.scode=a.community")
				.append("	 and f.sname='state' and c.appraisestate=f.scode")
				;
		//逐一拼接查询条件
		List<Object> paramList=new ArrayList<>();
		if(this.isNotNull(account))
		{
			sql.append(" and a.account=?");
			paramList.add(account);
		}
		if(this.isNotNull(truename))
		{
			sql.append(" and a.truename like ?");
			paramList.add("%"+truename+"%");
		}
		if(this.isNotNull(community))
		{
			sql.append(" and a.community=?");
			paramList.add(community);
		}
		if(this.isNotNull(userstate))
		{
			sql.append(" and a.userstate=?");
			paramList.add(userstate);
		}
		if(this.isNotNull(sex))
		{
			sql.append(" and a.sex=?");
			paramList.add(sex);
		}
		if(this.isNotNull(bgrade))
		{
			sql.append(" and c.grade >= ?");
			paramList.add(bgrade);
		}
		if(this.isNotNull(egrade))
		{
			sql.append(" and c.grade <= ?");
			paramList.add(egrade);
		}
		if(this.isNotNull(appraisestate))
		{
			sql.append(" and c.appraisestate=?");
			paramList.add(appraisestate);
		}
		
		return this.queryForPage(sql.toString(), 10, paramList.toArray());
	}
}
