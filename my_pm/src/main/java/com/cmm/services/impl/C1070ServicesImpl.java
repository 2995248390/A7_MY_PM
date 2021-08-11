/**
 * FileName:      C1070ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021��08��3��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   �û���ѯ��ʷ�Һŵ���ͨ����鿴����ҽ�Ƽ�¼���������
 *
 */
package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class C1070ServicesImpl extends JdbcServicesSupport
{
	
	public C1070ServicesImpl(Map<String, String> dto)
	{
		super(dto);
	}
	
	public Map<String,String> findById()throws Exception
	{		
		Integer oid=Integer.parseInt(this.getString("oid"));
		
		StringBuilder sql=new StringBuilder()
				.append("select a.onum,a.oid,a.did docid")
				.append("  from orderlist a")
				.append(" where a.oid=?")
				;
		return this.queryForMap(sql.toString(), oid);
	}
	
	/**
	 * �鿴��ϸҽ�Ƽ�¼
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> queryRecord()throws Exception
	{
		Integer oid=Integer.parseInt(this.getString("oid"));
		System.out.println("oid:"+oid);
		
		StringBuilder sql=new StringBuilder()
				.append("select a.onum,a.appointment,b.drugmsg,b.docsuggestion,c.truename username,d.truename docname")
				.append("  from orderlist a,record b,user c,user d,doc e")
				.append(" where c.uid=a.uid and d.uid=e.uid")
				.append("   and e.did=a.did and a.oid=b.oid")
				.append("	 and a.oid=?")
					 ;
					 		
		return this.queryForMap(sql.toString(), oid);
	}
	
	/**
	 * ��������
	 * @return
	 * @throws Exception
	 */
	public int insertAppraise()throws Exception
	{
		//��ȡ����
			//1
		Integer oid=Integer.parseInt(this.getString("oid"));
		String text=this.getString("qtext");
		Integer grade=Integer.parseInt(this.getString("qgrade"));
			//3
		Integer docgrade=0;
		if(grade>7)
			docgrade+=1;
		else if(grade<4)
			docgrade-=1;
		else
			docgrade+=0;
		Integer did=Integer.parseInt(this.getString("docid"));

		//����SQL���
			//1.�������
		StringBuilder sql1=new StringBuilder()
				.append(" insert into appraise(oid,text,appraisestate,grade) ")
				.append("      values(?,?,'1',?);");
		List<Object> paramsList1=new ArrayList<>();
		paramsList1.add(oid);
		paramsList1.add(text);
		paramsList1.add(grade);		
		this.executeUpdate(sql1.toString(), paramsList1.toArray());
			//2.�޸ĹҺŵ�����״̬
		StringBuilder sql2=new StringBuilder()		
				.append(" update orderlist a")
				.append("    set a.orderliststate='3'")
				.append("  where a.oid=?;");
		List<Object> paramsList2=new ArrayList<>();
		paramsList2.add(oid);
		this.batchUpdate(sql2.toString(), paramsList2.toArray());
			//3.����ҽ������
		StringBuilder sql3=new StringBuilder()		
				.append(" update doc a")
				.append("    set a.docgrade=a.docgrade+?")
				.append("  where a.did=?;");
		List<Object> paramsList3=new ArrayList<>();
		paramsList3.add(docgrade);
		paramsList3.add(did);
		return this.executeUpdate(sql3.toString(), paramsList3.toArray());
	}
	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> queryAppraise()throws Exception
	{
		Integer oid=Integer.parseInt(this.getString("oid"));
		
		StringBuilder sql=new StringBuilder()
				.append("select a.onum,b.grade,b.text")
				.append("  from orderlist a,appraise b")
				.append(" where a.oid=b.oid and a.oid=?")
				;
		return this.queryForMap(sql.toString(), oid);
	}
	
	/**
	 * ��ҳ��ѯ�Һŵ��б�
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> findOrder(String param)throws Exception
	{
		//��ԭ����
		Integer uid=Integer.parseInt(param);
		String bappointment=this.getString("bappointment");
		String eappointment=this.getString("eappointment");
		String orderliststate=this.getString("qorderliststate");
		String onum=this.getString("qonum");
		String bovertime=this.getString("bovertime");
		String eovertime=this.getString("eovertime");
		
		
		//����SQL���
		StringBuilder sql=new StringBuilder()
				.append("select x.uid,x.did docid,x.onum,x.appointment,x.overtime,x.oid,x.orderliststate,a.svalue")
				.append("  from syscode a,orderlist x")
				.append(" where x.uid=? ")
				.append("	and a.sname='finishappraise' and a.scode=x.orderliststate")
				;
		//ƴ�Ӳ�ѯ����
		List<Object> paramList=new ArrayList<>();
		paramList.add(uid);
		if(this.isNotNull(orderliststate))
		{
			sql.append("   and x.orderliststate=?");
			paramList.add(orderliststate);
		}		
		if(this.isNotNull(bappointment))
		{
			sql.append("   and x.appointment>=?");
			paramList.add(bappointment);
		}
		if(this.isNotNull(eappointment))
		{
			sql.append("   and x.eppointment<=?");
			paramList.add(eappointment);
		}
		if(this.isNotNull(onum))
		{
			sql.append("   and x.onum=?");
			paramList.add(Integer.parseInt(onum));
		}
		if(this.isNotNull(eovertime))
		{
			sql.append("   and x.overtime>=?");
			paramList.add(eovertime);
		}
		if(this.isNotNull(bovertime))
		{
			sql.append("   and x.overtime<=?");
			paramList.add(bovertime);
		}
		sql.append("   order by onum asc");
					 
		return this.queryForPage(sql.toString(), paramList.toArray());
	}
}
