/**
 * FileName:      B1040ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021年08月1日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   医生完成就诊，填写医疗记录
 *
 */
package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class B1040ServicesImpl extends JdbcServicesSupport
{
	
	public B1040ServicesImpl(Map<String, String> dto)
	{
		super(dto);
	}

	
	public int insertRecord()throws Exception
	{	
		//获取oid，将其传到dto中
		String sql1="select x.oid from orderlist x where x.onum=?";
		List<Object> paramList1=new ArrayList<>();
		paramList1.add(this.getString("onum"));
		Map<String,String> theoid=this.queryForMap(sql1,paramList1.toArray());
		this.putMap(theoid);
		
		//修改挂号单完成状态
		StringBuilder sql2=new StringBuilder()
				.append("	update orderlist x")
				.append("		 set x.orderliststate='1', x.overtime=CURRENT_TIMESTAMP")
				.append("	 where x.onum=? ");
		this.executeUpdate(sql2.toString(), this.getString("onum"));
				
		//插入医疗记录		
		StringBuilder sql3=new StringBuilder()
				.append("	insert into record(oid,docsuggestion,begintime,drugmsg,state) ")
				.append("			 values(?,?,current_date,?,'1');");

		List<Object> paramList3=new ArrayList<>();
		paramList3.add(this.getString("oid"));
		paramList3.add(this.getString("docsuggestion"));
		paramList3.add(this.getString("dramsg"));
		return this.executeUpdate(sql3.toString(), paramList3.toArray());
	}
}
