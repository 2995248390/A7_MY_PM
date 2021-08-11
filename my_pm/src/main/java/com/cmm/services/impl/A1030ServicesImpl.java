/**
 * FileName:      A1030ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021��07��27��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ����Ա��ѯҽ�Ƽ�¼
 *
 */
package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class A1030ServicesImpl extends JdbcServicesSupport
{

	public A1030ServicesImpl(Map<String, String> dto)
	{
		super(dto);
	}
	
	//ɾ��record���ж�Ӧ�ļ�¼����������ɾ��
	public int deleteRecord()throws Exception
	{
		String sql="delete from record where rid=?";
		
		//this.batchUpdate(sql, idlist)
		
		if(this.getString("rid").isEmpty())
		{
			return 0;
		}
		return this.executeUpdate(sql, this.getInteger("rid"));
	}
	//����ɾ��
	public int batchDeleteRecord()throws Exception
	{
		String sql="delete from record where rid=?";		
		
		if(this.judgeDto("rid")==false)
			return 3;
		Integer idlist[]=this.getIntArray("rid");

		return this.batchUpdate(sql, idlist)==true?1:2;
		

	}
	
	
	public Map<String,String> findById()throws Exception
	{
		StringBuilder sql=new StringBuilder()
				.append("select a.uid,a.truename,a.sex,d.truename doc,x.rid,x.docsuggestion,x.begintime,x.drugmsg")
				.append("  from user a,orderlist b,doc c,user d,record x")
				.append(" where a.uid=b.uid and b.oid=x.oid")
				.append("   and b.did=c.did and c.uid=d.uid")
				.append("   and rid=?")
				;
		return 	this.queryForMap(sql.toString(),this.getInteger("rid"));
	}
	
	
	public List<Map<String,String>> queryRecord()throws Exception
	{
		//��ԭҳ���ѯ����
		String account =this.getString("qaccount");
		String truename =this.getString("qtruename");
		String community =this.getString("qcommunity");
		String recordstate =this.getString("qrecordstate");		
		String sex =this.getString("qsex");
		String bbegintime =this.getString("bbegintime");		
		String ebegintime =this.getString("ebegintime");
		//��ɲ�ѯ����ƴ��
		StringBuilder sql=new StringBuilder()
				.append("select c.rid,a.account,a.truename,d.svalue sex,e.svalue community,c.state,c.begintime")
				.append("  from user a,orderlist b,record c,syscode d,syscode e")
				.append(" where a.uid=b.uid and b.oid=c.oid")
				.append(" and d.sname='sex' and d.scode=a.sex")
				.append(" and e.sname='community' and e.scode=a.community")				 
				;
		List<Object> paramList=new ArrayList<>();
		//��һƴ�Ӳ�ѯ����
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
		if(this.isNotNull(recordstate))
		{
			sql.append(" and c.state=?");
			paramList.add(recordstate);
		}
		if(this.isNotNull(sex))
		{
			sql.append(" and a.sex=?");
			paramList.add(sex);
		}
		if(this.isNotNull(bbegintime))
		{
			sql.append(" and a.begintime >= ?");
			paramList.add(bbegintime);
		}
		if(this.isNotNull(ebegintime))
		{
			sql.append(" and c.begintime <= ?");
			paramList.add(ebegintime);
		}
		return this.queryForPage(sql.toString(), 10, paramList.toArray());
	}
}
