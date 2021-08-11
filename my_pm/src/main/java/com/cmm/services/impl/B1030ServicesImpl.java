/**
 * FileName:      B1030ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021��07��30��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ҽ����ѯ�Һŵ�����ͨ���Һŵ���ѯ����ҽ�Ƽ�¼�������Ϣ
 *
 */
package com.cmm.services.impl;

import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class B1030ServicesImpl extends JdbcServicesSupport
{
	
	public B1030ServicesImpl(Map<String, String> dto)
	{
		super(dto);
	}
	
	public Map<String,String> queryBodymsg()throws Exception
	{
		//����SQL���
		StringBuilder sql=new StringBuilder()
				.append("select a.truename,b.svalue sex,x.blood,x.height,x.weight,x.airs,x.pulse,x.begintime")
				.append("  from user a,syscode b,bodymsg x")
				.append(" where a.uid=x.uid and x.bodymsgstate='1'")
				.append("   and b.sname='sex' and a.sex=b.scode")
				.append("   and x.uid=?")
				;
		Object param=this.getInteger("uid");
		return this.queryForMap(sql.toString(), param);
	}
	
	/**
	 * ����ҽ�Ƽ�¼
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> queryRecord()throws Exception
	{
		
		//����sql���
		StringBuilder sql=new StringBuilder()
				.append("select a.truename,c.svalue,x.begintime,x.drugmsg,x.docsuggestion")
				.append("  from user a,orderlist b,syscode c,record x")
				.append(" where a.uid=b.uid and b.oid=x.oid")
				.append("   and a.sex=c.scode and c.sname='sex'")
				.append("	 and a.uid=?")
				;
		Object param=this.getInteger("uid");		
		return this.queryForPage(sql.toString(), param);
	}
	
	
	/**
	 * ������ʾ��ǰ�ҺŶ���
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> queryOrderList()throws Exception
	{
		//����sql���
		StringBuilder sql=new StringBuilder()
				.append("select x.onum,a.truename,a.sex,x.appointment,a.uid,b.did")
				.append("  from user a,doc b,orderlist x")
				.append(" where a.uid=x.uid and b.did=x.did")
				.append("	 and x.orderliststate=? ")	
				.append(" order by x.appointment asc")			
				;
		Object param="2";
		return this.queryForPage(sql.toString(),param);
	}
	
	
}
