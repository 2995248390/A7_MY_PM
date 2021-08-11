/**
 * FileName:     A1040ServicesImpl
 *
 * FileType:      java
 *
 * Date:          2021年07月27日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   体检信息的删查
 *
 */

package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class A1040ServicesImpl extends JdbcServicesSupport {

	public A1040ServicesImpl(Map<String, String> dto) {
		super(dto);
		// TODO Auto-generated constructor stub
	}


	public String DelleteById()throws Exception
	{
		String sql="DELETE from bodymsg  where  bid=?";
//		Integer[] deletelist=this.getIntArray("rsnolist");
		String msg=null;
		if(this.getString("rsnolist")!=null)
		{
			this.deleteN(sql, this.getIntArray("rsnolist"));
			msg="成功删除";
		}
		else {
			msg="请选中删除项";
		}
	
		return msg;
	}
	
	
	

	
	
	public List<Map<String,String>> queryAi()throws Exception
	{
		//还原页面查询条件
		String bid=this.getString("qaino");
		String pno=this.getString("qpno");
		String sex=this.getString("qsex");
		String name=this.getString("qpname");
		String nation=this.getString("qnation");
		String startdate=this.getString("binputdate");
		String enddate=this.getString("einputdate");
		
		//2.完成SQL主体拼接
		StringBuilder sql=new StringBuilder()
				.append(" select x.bid,x.uid,a.truename,c.svalue sex,b.svalue nation,x.blood,x.height,x.weight,x.airs,x.pulse")
			 	.append(" from   bodymsg x,user a,syscode b,syscode c")
				.append(" where  x.uid = a.uid  ")
			   	.append("       and b.sname = 'nation' and b.scode = a.nation")
			 	.append("	    and c.sname = 'sex'    and  a.sex = c.scode");
				 		 
				 
				
		List<Object> paramList	=new ArrayList<>();
		//3.逐一拼接条件
		if(this.isNotNull(bid))
		{
			sql.append(" and x.bid=?");
			paramList.add(bid);
		}
		
		if(this.isNotNull(pno))
		{
			sql.append(" and x.uid=?");
			paramList.add(pno);
		}
		if(this.isNotNull(sex))
		{
			sql.append(" and a.sex=?");
			paramList.add(sex);
		}
		if(this.isNotNull(name))
		{
			sql.append(" and a.truename like ?");
			paramList.add("%"+name+"%");
			System.out.println(name);
		}
		if(this.isNotNull(nation))
		{
			sql.append(" and a.nation=?");
			paramList.add(nation);
		}
		if(this.isNotNull(startdate))
		{
			sql.append(" and x.begintime > ? ");
			paramList.add(startdate);
		}
		if(this.isNotNull(enddate))
		{
			sql.append(" and x.begintime < ? ");
			paramList.add(enddate);
		}
		return this.queryForPage(sql.toString(),10, paramList.toArray());
			
	}

}
