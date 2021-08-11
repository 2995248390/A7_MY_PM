/**
 * 1.一个方法内部,到底有多少条SQL语句---数量的不确定性
 * 2.每条SQL语句到底怎么执行----执行方式的不确定性
 * 
 * 架构设计的核心思想:
 *   就是在性能和通用之间寻找平衡
 */
package com.cmm.services.support;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cmm.system.db.DBUtils;
import com.cmm.system.tools.Tools;


public abstract class JdbcServicesSupport
{
	private int defaultPageSize=12;   //默认的每页行数
	private int countPage=0;       //分页后总的页数
	private int currentPage=0;     //查询后返回的当前页码编号
    private Map<String,String>  dto=null;	
    
	public JdbcServicesSupport(Map<String,String> dto)
	{
		this.dto=dto;
	}/****************************************************************
	 *           温晨宏
	 ****************************************************************/
	protected int execute(String sql,Object...params)throws Exception
	{
	    PreparedStatement pstm=null;
	   
	    try
	    {
	    	pstm=DBUtils.prepareStatement(sql);
	    	int index=1;
	    	for(Object e:params)
	    	{
	    		pstm.setObject(index++, e);
	    	}
	    	
	    	return pstm.executeUpdate();
	    	 
	    }
	    finally
	    {
	    	
	    	DBUtils.close(pstm);
	    }
	}
	protected final int deleteN(String sql,Object...params)throws Exception
	{
		PreparedStatement pstm=null;
		try
		{
			int msg=0;
			int index=1;
			for(Object e:params)
			{
				pstm=DBUtils.prepareStatement(sql);
				pstm.setObject(index,e);
				msg=pstm.executeUpdate();
			}
			return msg;
		}
		finally
		{
			DBUtils.close(pstm);
		}
	}
	/****************************************************************
	 *           张文江方法
	 ****************************************************************/
	
	//用于将Map内的键值对全部赋予给另一个Map
	protected final void putMap(Map<String,String> map)
	{
		dto.putAll(map);
	}
	
	/**
	 * 用于判断Map(dto)中是否有想要的元素
	 * @param param
	 * @return true--有该元素，false--没有该元素
	 */
	protected final boolean judgeDto(String param)
	{
		if(this.dto.get(param)==null)
			return false;
		else
			return true;
	}
	
	protected final Map<String,String> getDto()
	{
		return this.dto;
	}
	/****************************************************************
	 *           辅助方法
	 ****************************************************************/
	protected final Integer getInteger(String key)
	{
		return Integer.parseInt(this.dto.get(key));
	}
	protected final String getString(String key)
	{
	   return this.dto.get(key);	
	}
	
	protected final Double getDouble(String key)
	{
		return Tools.StrToDouble(this.dto.get(key));
	}
	
	protected final Integer[] getIntArray(String key)
	{
		//1.从dto获取value
		String val[]=this.dto.get(key).split("\\,");
		//2.创建等长的int数组
		Integer array[]=new Integer[val.length];
		//3.定义整数数组下标
		int  index=0;
		//4.遍历字符串数组
		for(String e:val)
		{
			array[index++]=Integer.parseInt(e);
		}
		return array;
	}
	
	protected boolean  isNotNull(Object value)
	{
		return value!=null && !value.equals("");
	}
	
	/****************************************************************
	 *           数据分页查询封装  
	 ****************************************************************/
	/**
	 * 分页控制器
	 * @return
	 */
	public final String getPageController(String url)
	{
		StringBuilder con=new StringBuilder()
				.append("<select  name=\"query\"  id=\"pageController\" >")
				;
		for(int i=1;i<=this.countPage;i++)
		{
			String tag=(i==this.currentPage)?"selected":"";
			con.append("   <option value=\""+i+"\" "+ tag +"  >  ")
			   .append("  第[ "+ i +" ]页")
			   .append("</option>");
		}
		con.append("</select>");
		con.append("")
		.append("<script>")
		.append("document.getElementById(\"pageController\").onchange=function(){")
		.append("   this.form.action=\""+this.getString("classpath")+url+"\";")
		.append("   this.form.submit();")
		.append("}")
        .append("</script>")
		;
		return con.toString();
	}
	
	protected final List<Map<String,String>> queryForPage(String sql,Object...params)throws Exception
	{
		return this.queryForPage(sql,this.defaultPageSize , params);
	}
    /**
     * 数据分页查询
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
	protected final List<Map<String,String>> queryForPage(String sql,int pageSize,Object...params)throws Exception
	{
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try
		{
			pstm=DBUtils.prepareStatementOfScroll(sql);
			int index=1;
			for(Object e:params)
			{
				pstm.setObject(index++, e);
			}
			rs=pstm.executeQuery();
			
			//rs滚动到最后一行
			rs.last();
			//获取最后一行的行号--计算满足条件的行数
			int rowcount=rs.getRow();
			//基于行数计算页数 (总行数+每页行数-1)/每页行数==取整
			this.countPage=(rowcount+pageSize-1)/pageSize;
			
			//3.计算可获取当前页码
			//3.1.默认获取符合查询条件的第一页数据
		    int onPageNo=1;                      
		    //3.2获取分页器指定的页数
		    String currentPage=this.getString("query");   //用户请求的页码
		    //3.2判断分页器是否存在
		    if(currentPage!=null && !currentPage.equals(""))
		    {
		       //3.3以分页器指定的页数替换默认页数1
		       onPageNo=Integer.parseInt(currentPage.toString());
		    }
		       
	        //3.4如果传入的当前页码比总的页数大,那么获取最后页
	        if(onPageNo>this.countPage)
	        {
	           onPageNo = this.countPage;
	        }
		    //3.5当前可以获取页码
		    this.currentPage= onPageNo;  
		    
		   //定位当前页码4
		    //计算当前页码的起始行数[算法:(当前页码-1)*每页行数)]
			int startRow=(this.currentPage-1)*pageSize;
			if(startRow<1)   //当获取第一页时候
			{
				rs.beforeFirst();     //ResultSet 归位方法--让ResultSet的指针回到最开始的位置
			}
			else
			{
				 rs.absolute(startRow);   //ResultSet绝对定位
			} 	 
			
		   //5.读取当前行数据
		   //5.1.获取结果集描述对象
		   ResultSetMetaData rsmd=rs.getMetaData();
		   //5.2计算符合查询条件的列数
		   int count=rsmd.getColumnCount();
		   //5.3计算安全的初始容量
		   int initSize=((int)(count/0.75))+1;
		   
		   //5.4定义List装载当前页数据
		   List<Map<String,String>> rows=new ArrayList<>(pageSize);
		   //5.5定义Map,装载当前行数据
		   Map<String,String> ins=null;
		   
		   
		   for(int r=1;r<=pageSize;r++)
		   {
			   if(rs.next())
			   {
				   ins=new HashMap<>(initSize);
				   for(int i=1;i<=count;i++)
				   {
					   ins.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));
				   }
				   rows.add(ins);
			   }
			   else
			   {
				   break;
			   }
		   }
		   return rows;
		}
		finally
		{
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}
	
	
	/****************************************************************
	 *           数据批量查询封装  
	 ****************************************************************/
	
	/**
	 * 将查询结果封装成字符串
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	protected String queryForString(String sql,ParseResultSet prs,Object...params)throws Exception
	{
	    PreparedStatement pstm=null;
	    ResultSet rs=null;
	    try
	    {
	    	pstm=DBUtils.prepareStatement(sql);
	    	int index=1;
	    	for(Object e:params)
	    	{
	    		pstm.setObject(index++, e);
	    	}
	    	rs=pstm.executeQuery();
	    	return prs.formatData(rs);
	    }
	    finally
	    {
	    	DBUtils.close(rs);
	    	DBUtils.close(pstm);
	    }
	}
	
	
	
	
    /**
     * 数据批量查询	
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
	protected List<Map<String,String>> queryForList(String sql,Object...params)throws Exception
	{
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try
		{
			pstm=DBUtils.prepareStatement(sql);
			int index=1;
			if(params!=null){
				for(Object e:params)
				{
					pstm.setObject(index++, e);
				}
			}
			rs=pstm.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int count=rsmd.getColumnCount();
			int initSize=((int)(count/0.75))+1;
			List<Map<String,String>> rows=new ArrayList<>();
			Map<String,String> ins=null;
			while(rs.next())
			{
				ins=new HashMap<>(initSize);
				for(int i=1;i<=count;i++)
				{
					ins.put(rsmd.getColumnLabel(i).toLowerCase(),rs.getString(i));
				}
				rows.add(ins);
			}
			return rows;
		}
		finally
		{
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}
	
	
	
	/****************************************************************
	 *            单一实例查询封装 
	 ****************************************************************/
	
	protected final Map<String,String> queryForMap(final String sql,Object...params)throws Exception
	{
		PreparedStatement pstm=null;  //定义语句对象
		ResultSet rs=null;
		try
		{
			pstm=DBUtils.prepareStatement(sql);
			//参数赋值
			int index=1;
			for(Object e:params)
			{
				pstm.setObject(index++, e);
			}
			//执行SQL语句
			rs=pstm.executeQuery();
			//定义装载查询结果Map变量
			Map<String,String> ins=null;
			//判断是否存在查询结果
			if(rs.next())
			{
				//获取rs描述对象
				ResultSetMetaData rsmd=rs.getMetaData();
				//计算列数
				int count=rsmd.getColumnCount();
				//安全的初始容量
				int initSize=((int)(count/0.75))+1;
				//实例化HashMap 装载查询结果
				ins=new HashMap<>(initSize);
				//遍历当前行记录
				for(int i=1;i<=count;i++)
				{
					//完成列级映射
					ins.put(rsmd.getColumnLabel(i).toLowerCase(),rs.getString(i));
				}
			}
            return ins;			
		}
		finally
		{
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}
	
	/****************************************************************
	 *            多表级联事务处理---混合事务
	 ****************************************************************/
	
	private List<StatementBean> statementList=new ArrayList<>();
	
	/**
	 * 为事务注册SQL语句
	 * <
	 *   注册非批处理SQL语句
	 * >
	 * @throws Exception
	 */
	protected void regSqlToTransaction(String sql,Object...params)throws Exception
	{
		//1.编译SQL语句
		PreparedStatement pstm=DBUtils.prepareStatement(sql);
		int index=1;
		for(Object e:params)
		{
			pstm.setObject(index++, e);
		}
		//创建语句Bean对象,描述该SQL语句的执行方式
		StatementBean stmt=new StatementBean(pstm, false);
		//为事务注册SQL语句
		this.statementList.add(stmt);
	}
	
	/**
	 * 为事务注册SQL语句
	 * <
	 *   注册批处理SQL语句
	 *   delete from table where id=?  
	 *   update table set col1=? where id=?
	 *   update table set col1=?,col2=?,col3=?.... where id=?
	 * >
	 * @throws Exception
	 */
	protected void regBatchSqlToTransaction(String sql,Object setList[],Object...idlist)throws Exception
	{
		PreparedStatement pstm=DBUtils.prepareStatement(sql);
		//参数索引
		int index=1;
		//判断是否存在状态列表
		if(setList!=null && setList.length>0)
		{
			//完成状态列表的赋值
			for(Object e:setList)
			{
				pstm.setObject(index++, e);
			}
		}
		
		//替换主键值,并将准备好的SQL语句添加到缓冲区
		for(Object id:idlist)
		{
			pstm.setObject(index, id);
			pstm.addBatch();
		}
		//指定语句对象以批处理方式执行
		StatementBean stmtBean=new StatementBean(pstm, true);
		//完成向事务注册批处理语句对象
		this.statementList.add(stmtBean);
	}
	
	protected void regBatchSqlToTransaction(String sql,Object newState,Object...idlist)throws Exception
	{
		this.regBatchSqlToTransaction(sql, new Object[]{newState}, idlist);
	}
	
	protected void regBatchSqlToTransaction(String sql,Object...idlist)throws Exception
	{
		this.regBatchSqlToTransaction(sql, null, idlist);
	}
	
	/**
	 * 执行事务的SQL语句
	 * @return
	 * @throws Exception
	 */
	protected boolean executeTrasaction()throws Exception
	{
		//定义事务返回值
		boolean tag=false;
		//开启事务
		DBUtils.beginTransaction();
		try
		{
			//循环当前事务的语句列表
			for(StatementBean  stmtBean:this.statementList)
			{
				stmtBean.executePstm();
			}
			
			//提交事务
			DBUtils.commitTransaction();
			tag=true;
		}
		catch(Exception ex)
		{
			DBUtils.rollbackTransaction();
			ex.printStackTrace();
		}
		finally
		{
			DBUtils.endTransaction();
			//关闭语句对象
			for(StatementBean  stmtBean:this.statementList)
			{
				stmtBean.closePstm();
			}
			//清空当前事务的语句列表
			this.statementList.clear();
			
		}
		return tag;
	}
	
	/****************************************************************
	 *            单一表的事务处理
	 ****************************************************************/
	
	/**
	 * 单一表多状态批处理更新
	 * <
	 *    update table
	 *       set col1=?,col2=?,col3=?,....,colN=?
	 *     where id=?  
	 * >
	 * @param sql        ----- SQL语句
	 * @param setList    ----- set字句 目标值列表
	 * @param idlist     ----- 主键数组
	 * @return
	 * @throws Exception
	 */
	protected boolean batchUpdate(String sql,Object setList[],Object...idlist)throws Exception
	{
		PreparedStatement pstm=null;
		try
		{
			pstm=DBUtils.prepareStatement(sql);
			//为set字句的各个参数赋值
			int index=1;
			
			if(setList!=null && setList.length>0)
			{
				for(Object sparam:setList)
				{
					pstm.setObject(index++, sparam);
				}
			} 
			
			//为主键数组赋值
			for(Object id:idlist)
			{
				pstm.setObject(index, id);
				pstm.addBatch();
			}
			return this.executeBatch(pstm);
		}
		finally
		{
			DBUtils.close(pstm);
		}
	}
	/**
	 * 单一表单一状态批量更新
	 * <
	 *    update table 
	 *       set col=?
	 *     where id=?
	 *  ===>
	 *    update emp
	 *       set sal=sal+100   -->100 newState
	 *     where eid={1,2,3,4} -->{1,2,3,4}  -- idlist      
	 * >
	 * @param sql    --- 目标SQL语句
	 * @param newState  ---set列表中,指定的单一列目标状态
	 * @param idlist    --- 主键数组
	 * @return
	 * @throws Exception
	 */
	protected boolean batchUpdate(String sql,Object newState,Object...idlist)throws Exception
	{
		return this.batchUpdate(sql, new Object[]{newState}, idlist);
	}
	
	/**
	 * 单一表数据批量删除方法
	 * <
	 *   delete from table where id=?
	 * >
	 * @param sql   -- sql语句
	 * @param idlist  --- 主机数组
	 * @return
	 * @throws Exception
	 */
	protected boolean batchUpdate(String sql,Object...idlist)throws Exception
	{
		return this.batchUpdate(sql, null, idlist);
	}
	/**
	 * 单一表批处理事务的执行过程--封装
	 * @param pstm
	 * @return
	 * @throws Exception
	 */
	private boolean executeBatch(PreparedStatement pstm)throws Exception
	{
    	boolean tag=false;
    	DBUtils.beginTransaction();
    	try
    	{
    		pstm.executeBatch();
    		DBUtils.commitTransaction();
    		tag=true;
    	}
    	catch(Exception ex)
    	{
    		DBUtils.rollbackTransaction();
    		ex.printStackTrace();
    	}
    	finally
    	{
    		DBUtils.endTransaction();
    	}
        return tag;
	}
	
	/****************************************************************
	 *            单一表非事务处理
	 *          基于一张表达添加,修改,删除
	 * 添加的语法规律
	 *    insert into tableName(col1,col2,col3...coln)
	 *                   values( ?,   ?,    ?,....?)
	 * 修改的语法规律          
	 *    update tableName
	 *       set state=?
	 *     where id=?   --- 单一状态更新,按主键更新记录的一个数据项状态
	 *     
	 *    update tableName
	 *       set state1=?,state2=?,state3=?,...stateN=?
	 *     where id=?   --- 多状态更新,按主键更新一个记录的多个数据项的状态
	 *     
	 *    update tableName
	 *       set state1=?,state2=?,state3=?,...stateN=?
	 *     where w1=? and w2=? and w3=?   --- 多条件多状态更新,按多个条件更新一个记录的多个数据项的状态
	 *     
	 * 删除的语法规律   
	 *   delete from tableName where id=?      
	 ****************************************************************/
	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	protected final int executeUpdate(String sql,Object...params)throws Exception
	{
		PreparedStatement pstm=null;
		try
		{
			pstm=DBUtils.prepareStatement(sql);
			int index=1;
			for(Object e:params)
			{
				pstm.setObject(index++,e);
			}
			return pstm.executeUpdate();
		}
		finally
		{
			DBUtils.close(pstm);
		}
	}
	
}
