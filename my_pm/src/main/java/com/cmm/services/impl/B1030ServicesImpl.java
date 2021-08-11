/**
 * FileName:      B1030ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021年07月30日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   医生查询挂号单，并通过挂号单查询过往医疗记录与体检信息
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
		//定义SQL语句
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
	 * 返回医疗记录
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> queryRecord()throws Exception
	{
		
		//定义sql语句
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
	 * 用于显示当前挂号队列
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> queryOrderList()throws Exception
	{
		//定义sql语句
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
