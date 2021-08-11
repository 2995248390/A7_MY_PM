package com.cmm.system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//��Դ�ļ�������--��������򵥵ķ�ʽ��ȡ��Դ�ļ�������
import java.util.ResourceBundle;

public class DBUtils 
{
	//1.����������
	private static String driver=null;
	//2.�������Ӵ�
	private static String url=null;
	private static String userName=null;
	private static String password=null;
	
	//ʵ����ThreadLocal����
	private static ThreadLocal<Connection>  threadLocal=new ThreadLocal<>();

	/**
	 * ��̬��
	 * ��̬�������,ֻ��ִ��һ��
	 */
	static
	{
		//3.��������
		try 
		{
			//��ȡ��Դ�ļ�����������
			ResourceBundle bundle=ResourceBundle.getBundle("DBOptions");
			//���ڽ�����,����Դ�ļ���ȡ����,��ʽ��  ����ȡֵ
			driver=bundle.getString("driver");
			url=bundle.getString("url");
			userName=bundle.getString("username");
			password=bundle.getString("password");
			Class.forName(driver);  //��������-- ��������������ڴ�
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	private static Connection getConnection()throws Exception
	{
		//��������
		//1.��ȡ��ǰ�̰߳󶨵����Ӷ���
		Connection conn=threadLocal.get();
		//2.�жϵ�ǰ�߳��Ƿ��Ѿ��������Ӷ���
		if(conn==null || conn.isClosed())
		{
			//�����µ����Ӷ���
			conn=DriverManager.getConnection(url, userName, password);
			//�����Ӷ����뵱ǰ�̰߳�
			threadLocal.set(conn);
		}
		System.out.println("get this Conneciton............."+conn);
		return conn;
	}
	
	
	/**
	 * SQL�����뷽��
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static PreparedStatement prepareStatement(String sql)throws Exception
	{
		return DBUtils.getConnection().prepareStatement(sql);
	}
	
	/**
	 * ����SQL���,����������
	 * �����������ɵĽ��������˫�����
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static PreparedStatement prepareStatementOfScroll(String sql)throws Exception
	{
		return DBUtils.getConnection().prepareStatement(sql,
				                             ResultSet.TYPE_SCROLL_SENSITIVE,   //rs����˫�����,������ת
				                             ResultSet.CONCUR_READ_ONLY   //rs�漰��������,��ʱֻ�� 
				                             );
	}
	
    
	/**
	 * ����SQL���,������ˮ�ź�
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static PreparedStatement prepareStatementOfKey(String sql)throws Exception
	{
		return DBUtils.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	}

	/**
	 * ��������(Transaction)
	 */
	public static void beginTransaction()throws Exception
	{
		DBUtils.getConnection().setAutoCommit(false);
	}
	/**
	 * �ύ����
	 * @throws Exception
	 */
	public static void commitTransaction()throws Exception
	{
		DBUtils.getConnection().commit();
	}
	/**
	 * �ع�����
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
	 * ��������
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
			//1.��ȡ��ǰ�̰߳󶨵����Ӷ���
			Connection conn=threadLocal.get();
			//2.�ж����Ӷ����Ƿ����,����δ�ر�
			if(conn!=null && !conn.isClosed())
			{
				System.out.println("close this Conneciton............."+conn);
				//�����ǰ�߳������Ӷ���İ�
				threadLocal.set(null);
				//�ر�����
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
