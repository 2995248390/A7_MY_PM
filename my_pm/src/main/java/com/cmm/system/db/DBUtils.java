package com.cmm.system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//资源文件解析器--可以以最简单的方式读取资源文件的内容
import java.util.ResourceBundle;

public class DBUtils 
{
	//1.定义驱动串
	private static String driver=null;
	//2.定义连接串
	private static String url=null;
	private static String userName=null;
	private static String password=null;
	
	//实例化ThreadLocal对象
	private static ThreadLocal<Connection>  threadLocal=new ThreadLocal<>();

	/**
	 * 静态块
	 * 静态块的内容,只被执行一次
	 */
	static
	{
		//3.加载驱动
		try 
		{
			//获取资源文件解析器对象
			ResourceBundle bundle=ResourceBundle.getBundle("DBOptions");
			//基于解析器,从资源文件读取数据,方式是  按名取值
			driver=bundle.getString("driver");
			url=bundle.getString("url");
			userName=bundle.getString("username");
			password=bundle.getString("password");
			Class.forName(driver);  //加载驱动-- 将驱动类加载如内存
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	private static Connection getConnection()throws Exception
	{
		//创建连接
		//1.获取当前线程绑定的连接对象
		Connection conn=threadLocal.get();
		//2.判断当前线程是否已经绑定了连接对象
		if(conn==null || conn.isClosed())
		{
			//创建新的连接对象
			conn=DriverManager.getConnection(url, userName, password);
			//将连接对象与当前线程绑定
			threadLocal.set(conn);
		}
		System.out.println("get this Conneciton............."+conn);
		return conn;
	}
	
	
	/**
	 * SQL语句编译方法
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static PreparedStatement prepareStatement(String sql)throws Exception
	{
		return DBUtils.getConnection().prepareStatement(sql);
	}
	
	/**
	 * 编译SQL语句,生成语句对象
	 * 该语句对象生成的结果集可以双向滚动
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static PreparedStatement prepareStatementOfScroll(String sql)throws Exception
	{
		return DBUtils.getConnection().prepareStatement(sql,
				                             ResultSet.TYPE_SCROLL_SENSITIVE,   //rs可以双向滚动,任意跳转
				                             ResultSet.CONCUR_READ_ONLY   //rs涉及到的数据,暂时只读 
				                             );
	}
	
    
	/**
	 * 编译SQL语句,返回流水号号
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static PreparedStatement prepareStatementOfKey(String sql)throws Exception
	{
		return DBUtils.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	}

	/**
	 * 开启事务(Transaction)
	 */
	public static void beginTransaction()throws Exception
	{
		DBUtils.getConnection().setAutoCommit(false);
	}
	/**
	 * 提交事务
	 * @throws Exception
	 */
	public static void commitTransaction()throws Exception
	{
		DBUtils.getConnection().commit();
	}
	/**
	 * 回滚事务
	 */
	public static void rollbackTransaction()
	{
		try
		{
			DBUtils.getConnection().rollback();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 结束事务
	 */
	public static void endTransaction()
	{
		try
		{
			DBUtils.getConnection().setAutoCommit(true);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void close(ResultSet rs)
	{
		try
		{
			if(rs!=null)
			{
				rs.close();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstm)
	{
		try
		{
			if(pstm!=null)
			{
				pstm.close();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void close()
	{
		try
		{
			//1.获取当前线程绑定的连接对象
			Connection conn=threadLocal.get();
			//2.判断连接对象是否存在,并且未关闭
			if(conn!=null && !conn.isClosed())
			{
				System.out.println("close this Conneciton............."+conn);
				//解除当前线程与连接对象的绑定
				threadLocal.set(null);
				//关闭连接
				conn.close();
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
	public static void main(String[] args) 
	{
	    try
	    {
	    	
	    		System.out.println(DBUtils.getConnection());	
	    	
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}

}
