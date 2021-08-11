/**
 * FileName:     A1060ServicesImpl
 *
 * FileType:      java
 *
 * Date:          2021年07月28日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   资讯信息的增删改查
 *
 */
package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class A1060ServicesImpl extends JdbcServicesSupport {

	public A1060ServicesImpl(Map<String, String> dto) {
		super(dto);
		// TODO Auto-generated constructor stub
	}
	public List<Map<String,String>> queryForInf()throws Exception
	{
		//还原页面查询条件
		String iid=this.getString("qinno");
		String text=this.getString("qinsyn");
		String url=this.getString("qinurl");
		String state=this.getString("qinstate");
		
		
		//2.完成SQL主体拼接
		StringBuilder sql=new StringBuilder()
				.append("select  x.iid,x.begintime,x.text,x.memo,x.url,x.state ")
				.append(" from   information x ")
				.append(" where    x.memo like '%%'");
				 		 
				 
				
		List<Object> paramList	=new ArrayList<>();
		//3.逐一拼接条件
		if(this.isNotNull(iid))
		{
			sql.append(" and x.iid=?");
			paramList.add(iid);
		}
		
		if(this.isNotNull(text))
		{
			sql.append(" and x.text like   ? ");
			paramList.add("%"+text+"%");
		}
		if(this.isNotNull(url))
		{
			sql.append(" and x.url=?");
			paramList.add(url);
		}
		if(this.isNotNull(state))
		{
			sql.append(" and x.state=?");
			paramList.add(state);	
		}
		
		return this.queryForPage(sql.toString(),10, paramList.toArray());
			
	}
	
	public int update()throws Exception
	{
		
	
		
		//定义SQL语句
		String sql= "update information set text=?,memo=?,url=?,state=? where  iid=?";
		//还原参数
		List<Object> paramlist=new ArrayList<>();	
		paramlist.add(this.getString("uptext"));
		paramlist.add(this.getString("upmemo"));
		paramlist.add(this.getString("upurl"));
		paramlist.add(this.getString("upstate"));
		paramlist.add(this.getString("upiid"));
		
		return this.executeUpdate(sql, paramlist.toArray());
		
		
	}
	
	
	/**
	 * 根据id把需要更改的数据查出，返回查询结果
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> queryForUpdate()throws Exception
	{
		//还原页面查询条件
		Object[] iid=this.getIntArray("rsnolist");
		
		
		//2.完成SQL主体拼接
		StringBuilder sql=new StringBuilder()
				.append("select  x.iid,x.text,x.memo,x.url,x.state ")
				.append(" from   information x ")
				.append(" where    x.iid = ?");
		
		return this.queryForMap(sql.toString(), iid);
	}
				 		 
	
	
	
	
	
	public int  addinf() throws Exception
	{
		String sql="insert into information(begintime,text,url,memo,state)  VALUES      ( CURRENT_TIMESTAMP,?,?,?,'1')";
		List<Object> paramList	=new ArrayList<>();
		String text=this.getString("addsyn");
		String url=this.getString("addurl");
		String memo=this.getString("addmemo");
		if(text==""  ||  url==null || memo==null)
		{
			return 3;
			
		}
		else {
			paramList.add(text);
			paramList.add(url);
			paramList.add(memo);
			if(this.execute(sql, paramList.toArray())>0)
			{
				return 1;
			}
			return 2;
		}
		
		
	}
	
	public String DelleteById()throws Exception
	{
		String sql="DELETE from information  where  iid=?";
	
		String msg=null;
		if(this.getString("rsnolist")!=null)
		{
			Object[] deletelist=this.getIntArray("rsnolist");
			this.deleteN(sql, deletelist);
			msg="成功删除";
		}
		else {
			msg="请选中删除项";
		}
	
		return msg;
	}
	

}
