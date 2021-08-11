package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;

/**
 * FileName: A1010ServicesImpl
 * 
 * Date: 2021年07月27号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 管理员查询用户	
 *
 */

public class A1010ServicesImpl extends JdbcServicesSupport
{
	public A1010ServicesImpl(Map<String, String> dto)
	{
		super(dto);
	}
	
	public Map<String,String> findById()throws Exception
	{
		StringBuilder sql=new StringBuilder()
				.append("select account,upass,truename,idcard,systype,")
				.append("		sex,age,nation,community,birthday,")	          
				.append("	 	phonenumber,begintime,address,userstate,memo,")             
				.append("		mail")
				.append("  from user")
				.append(" where uid = ?")
				;
		return this.queryForMap(sql.toString(), this.getInteger("uid"));
	}
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> queryEmp()throws Exception
	{
	    //1.还原页面查询条件---将页面查询条件还原成变量	
		String eno=this.getString("qeno");
		String ename=this.getString("qename");
		String sex=this.getString("qsex");
		String nation=this.getString("qnation");
		String job=this.getString("qjob");
		String bsal=this.getString("bsal");
		String esal=this.getString("esal");
		
		//2.完成SQL主体拼接
		StringBuilder sql=new StringBuilder()
				.append("select x.eid,x.eno,x.ename,b.fvalue cnsex,a.fvalue cnnation,")
				.append("       c.fvalue cnjob,d.fvalue cnstate,x.sal")
				.append("  from syscode a,syscode b, syscode c,syscode d,emp x")
				.append(" where a.fname='nation'	and a.fcode=x.nation")
				.append("   and b.fname='sex' and b.fcode=x.sex")
				.append("   and c.fname='job' and c.fcode=x.job")	
				.append(" 	and d.fname='state' and d.fcode=x.state")
				;
		List<Object> paramList=new ArrayList<>();
		//3.逐一拼接查询条件
		if(this.isNotNull(eno))
		{
			sql.append(" and x.eno=?");
			paramList.add(eno);
		}
		if(this.isNotNull(ename))
		{
			sql.append(" and x.ename like ?");
			paramList.add("%"+ename+"%");
		}
		if(this.isNotNull(sex))
		{
			sql.append(" and x.sex=?");
			paramList.add(sex);
		}
		if(this.isNotNull(nation))
		{
			sql.append(" and x.nation=?");
			paramList.add(nation);
		}
		if(this.isNotNull(job))
		{
			sql.append(" and x.job=?");
			paramList.add(job);
		}
		if(this.isNotNull(bsal))
		{
			sql.append(" and x.sal >= ?");
			paramList.add(Tools.StrToDouble(bsal));
		}
		if(this.isNotNull(esal))
		{
			sql.append(" and x.sal<=?");
			paramList.add(Tools.StrToDouble(esal));
		}
		return this.queryForPage(sql.toString(),10, paramList.toArray());
	}
	
	public List<Map<String,String>> queryUser()throws Exception{
		String name=this.getString("qname");
		String idcard=this.getString("qidcard");
		String sex=this.getString("qsex");
		String nation=this.getString("qnation");
		String age=this.getString("qage");
		String qcommunity=this.getString("qcommunity");
		String account=this.getString("qaccount");
		StringBuilder sql=new StringBuilder()
				.append("select DISTINCT user.uid, user.idcard, user.account, user.truename, b.svalue cnsex, a.svalue cnnatino, ")
				.append("			 user.age, d.svalue cnstate, c.svalue cncommunity")
				.append("	from user ,syscode a,syscode b,syscode c,syscode d")
				.append("	where a.sname='nation'	and a.scode=user.nation")
				.append(" and b.sname='sex' and b.scode=user.sex")
				.append("  and d.sname='state' and d.scode=user.userstate and userstate != '2'")
				.append("  and c.sname='community' and c.scode=user.community")
				;
		List<Object> paramList=new ArrayList<>();
		//3.逐一拼接查询条件
		if(this.isNotNull(name))
		{
			sql.append(" and user.truename like ?");
			paramList.add("%"+name+"%");
		}
		if(this.isNotNull(idcard))
		{
			sql.append(" user.idcard = ?");
			paramList.add(idcard);
		}
		if(this.isNotNull(sex))
		{
			sql.append(" and user.sex = ?");
			paramList.add(sex);
		}
		if(this.isNotNull(nation))
		{
			sql.append(" and user.nation = ?");
			paramList.add(nation);
		}
		if(this.isNotNull(age))
		{
			sql.append(" and user.age = ?");
			paramList.add(age);
		}
		if(this.isNotNull(qcommunity))
		{
			sql.append(" and user.community = ?");
			paramList.add(qcommunity);
		}
		if(this.isNotNull(account))
		{
			sql.append(" and user.account = ?");
			paramList.add(account);
		}
		return this.queryForPage(sql.toString(),10, paramList.toArray());
		
	}
}







