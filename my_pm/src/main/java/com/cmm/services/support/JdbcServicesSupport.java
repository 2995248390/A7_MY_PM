/**
 * 1.һ�������ڲ�,�����ж�����SQL���---�����Ĳ�ȷ����
 * 2.ÿ��SQL��䵽����ôִ��----ִ�з�ʽ�Ĳ�ȷ����
 * 
 * �ܹ���Ƶĺ���˼��:
 *   ���������ܺ�ͨ��֮��Ѱ��ƽ��
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
	private int defaultPageSize=12;   //Ĭ�ϵ�ÿҳ����
	private int countPage=0;       //��ҳ���ܵ�ҳ��
	private int currentPage=0;     //��ѯ�󷵻صĵ�ǰҳ����
    private Map<String,String>  dto=null;	
    
	public JdbcServicesSupport(Map<String,String> dto)
	{
		this.dto=dto;
	}/****************************************************************
	 *           �³���
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
	 *           ���Ľ�����
	 ****************************************************************/
	
	//���ڽ�Map�ڵļ�ֵ��ȫ���������һ��Map
	protected final void putMap(Map<String,String> map)
	{
		dto.putAll(map);
	}
	
	/**
	 * �����ж�Map(dto)���Ƿ�����Ҫ��Ԫ��
	 * @param param
	 * @return true--�и�Ԫ�أ�false--û�и�Ԫ��
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
	 *           ��������
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
		//1.��dto��ȡvalue
		String val[]=this.dto.get(key).split("\\,");
		//2.�����ȳ���int����
		Integer array[]=new Integer[val.length];
		//3.�������������±�
		int  index=0;
		//4.�����ַ�������
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
	 *           ���ݷ�ҳ��ѯ��װ  
	 ****************************************************************/
	/**
	 * ��ҳ������
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
			   .append("  ��[ "+ i +" ]ҳ")
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
     * ���ݷ�ҳ��ѯ
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
			
			//rs���������һ��
			rs.last();
			//��ȡ���һ�е��к�--������������������
			int rowcount=rs.getRow();
			//������������ҳ�� (������+ÿҳ����-1)/ÿҳ����==ȡ��
			this.countPage=(rowcount+pageSize-1)/pageSize;
			
			//3.����ɻ�ȡ��ǰҳ��
			//3.1.Ĭ�ϻ�ȡ���ϲ�ѯ�����ĵ�һҳ����
		    int onPageNo=1;                      
		    //3.2��ȡ��ҳ��ָ����ҳ��
		    String currentPage=this.getString("query");   //�û������ҳ��
		    //3.2�жϷ�ҳ���Ƿ����
		    if(currentPage!=null && !currentPage.equals(""))
		    {
		       //3.3�Է�ҳ��ָ����ҳ���滻Ĭ��ҳ��1
		       onPageNo=Integer.parseInt(currentPage.toString());
		    }
		       
	        //3.4�������ĵ�ǰҳ����ܵ�ҳ����,��ô��ȡ���ҳ
	        if(onPageNo>this.countPage)
	        {
	           onPageNo = this.countPage;
	        }
		    //3.5��ǰ���Ի�ȡҳ��
		    this.currentPage= onPageNo;  
		    
		   //��λ��ǰҳ��4
		    //���㵱ǰҳ�����ʼ����[�㷨:(��ǰҳ��-1)*ÿҳ����)]
			int startRow=(this.currentPage-1)*pageSize;
			if(startRow<1)   //����ȡ��һҳʱ��
			{
				rs.beforeFirst();     //ResultSet ��λ����--��ResultSet��ָ��ص��ʼ��λ��
			}
			else
			{
				 rs.absolute(startRow);   //ResultSet���Զ�λ
			} 	 
			
		   //5.��ȡ��ǰ������
		   //5.1.��ȡ�������������
		   ResultSetMetaData rsmd=rs.getMetaData();
		   //5.2������ϲ�ѯ����������
		   int count=rsmd.getColumnCount();
		   //5.3���㰲ȫ�ĳ�ʼ����
		   int initSize=((int)(count/0.75))+1;
		   
		   //5.4����Listװ�ص�ǰҳ����
		   List<Map<String,String>> rows=new ArrayList<>(pageSize);
		   //5.5����Map,װ�ص�ǰ������
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
	 *           ����������ѯ��װ  
	 ****************************************************************/
	
	/**
	 * ����ѯ�����װ���ַ���
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
     * ����������ѯ	
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
	 *            ��һʵ����ѯ��װ 
	 ****************************************************************/
	
	protected final Map<String,String> queryForMap(final String sql,Object...params)throws Exception
	{
		PreparedStatement pstm=null;  //����������
		ResultSet rs=null;
		try
		{
			pstm=DBUtils.prepareStatement(sql);
			//������ֵ
			int index=1;
			for(Object e:params)
			{
				pstm.setObject(index++, e);
			}
			//ִ��SQL���
			rs=pstm.executeQuery();
			//����װ�ز�ѯ���Map����
			Map<String,String> ins=null;
			//�ж��Ƿ���ڲ�ѯ���
			if(rs.next())
			{
				//��ȡrs��������
				ResultSetMetaData rsmd=rs.getMetaData();
				//��������
				int count=rsmd.getColumnCount();
				//��ȫ�ĳ�ʼ����
				int initSize=((int)(count/0.75))+1;
				//ʵ����HashMap װ�ز�ѯ���
				ins=new HashMap<>(initSize);
				//������ǰ�м�¼
				for(int i=1;i<=count;i++)
				{
					//����м�ӳ��
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
	 *            �����������---�������
	 ****************************************************************/
	
	private List<StatementBean> statementList=new ArrayList<>();
	
	/**
	 * Ϊ����ע��SQL���
	 * <
	 *   ע���������SQL���
	 * >
	 * @throws Exception
	 */
	protected void regSqlToTransaction(String sql,Object...params)throws Exception
	{
		//1.����SQL���
		PreparedStatement pstm=DBUtils.prepareStatement(sql);
		int index=1;
		for(Object e:params)
		{
			pstm.setObject(index++, e);
		}
		//�������Bean����,������SQL����ִ�з�ʽ
		StatementBean stmt=new StatementBean(pstm, false);
		//Ϊ����ע��SQL���
		this.statementList.add(stmt);
	}
	
	/**
	 * Ϊ����ע��SQL���
	 * <
	 *   ע��������SQL���
	 *   delete from table where id=?  
	 *   update table set col1=? where id=?
	 *   update table set col1=?,col2=?,col3=?.... where id=?
	 * >
	 * @throws Exception
	 */
	protected void regBatchSqlToTransaction(String sql,Object setList[],Object...idlist)throws Exception
	{
		PreparedStatement pstm=DBUtils.prepareStatement(sql);
		//��������
		int index=1;
		//�ж��Ƿ����״̬�б�
		if(setList!=null && setList.length>0)
		{
			//���״̬�б�ĸ�ֵ
			for(Object e:setList)
			{
				pstm.setObject(index++, e);
			}
		}
		
		//�滻����ֵ,����׼���õ�SQL�����ӵ�������
		for(Object id:idlist)
		{
			pstm.setObject(index, id);
			pstm.addBatch();
		}
		//ָ����������������ʽִ��
		StatementBean stmtBean=new StatementBean(pstm, true);
		//���������ע��������������
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
	 * ִ�������SQL���
	 * @return
	 * @throws Exception
	 */
	protected boolean executeTrasaction()throws Exception
	{
		//�������񷵻�ֵ
		boolean tag=false;
		//��������
		DBUtils.beginTransaction();
		try
		{
			//ѭ����ǰ���������б�
			for(StatementBean  stmtBean:this.statementList)
			{
				stmtBean.executePstm();
			}
			
			//�ύ����
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
			//�ر�������
			for(StatementBean  stmtBean:this.statementList)
			{
				stmtBean.closePstm();
			}
			//��յ�ǰ���������б�
			this.statementList.clear();
			
		}
		return tag;
	}
	
	/****************************************************************
	 *            ��һ���������
	 ****************************************************************/
	
	/**
	 * ��һ���״̬���������
	 * <
	 *    update table
	 *       set col1=?,col2=?,col3=?,....,colN=?
	 *     where id=?  
	 * >
	 * @param sql        ----- SQL���
	 * @param setList    ----- set�־� Ŀ��ֵ�б�
	 * @param idlist     ----- ��������
	 * @return
	 * @throws Exception
	 */
	protected boolean batchUpdate(String sql,Object setList[],Object...idlist)throws Exception
	{
		PreparedStatement pstm=null;
		try
		{
			pstm=DBUtils.prepareStatement(sql);
			//Ϊset�־�ĸ���������ֵ
			int index=1;
			
			if(setList!=null && setList.length>0)
			{
				for(Object sparam:setList)
				{
					pstm.setObject(index++, sparam);
				}
			} 
			
			//Ϊ�������鸳ֵ
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
	 * ��һ��һ״̬��������
	 * <
	 *    update table 
	 *       set col=?
	 *     where id=?
	 *  ===>
	 *    update emp
	 *       set sal=sal+100   -->100 newState
	 *     where eid={1,2,3,4} -->{1,2,3,4}  -- idlist      
	 * >
	 * @param sql    --- Ŀ��SQL���
	 * @param newState  ---set�б���,ָ���ĵ�һ��Ŀ��״̬
	 * @param idlist    --- ��������
	 * @return
	 * @throws Exception
	 */
	protected boolean batchUpdate(String sql,Object newState,Object...idlist)throws Exception
	{
		return this.batchUpdate(sql, new Object[]{newState}, idlist);
	}
	
	/**
	 * ��һ����������ɾ������
	 * <
	 *   delete from table where id=?
	 * >
	 * @param sql   -- sql���
	 * @param idlist  --- ��������
	 * @return
	 * @throws Exception
	 */
	protected boolean batchUpdate(String sql,Object...idlist)throws Exception
	{
		return this.batchUpdate(sql, null, idlist);
	}
	/**
	 * ��һ�������������ִ�й���--��װ
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
	 *            ��һ���������
	 *          ����һ�ű�����,�޸�,ɾ��
	 * ��ӵ��﷨����
	 *    insert into tableName(col1,col2,col3...coln)
	 *                   values( ?,   ?,    ?,....?)
	 * �޸ĵ��﷨����          
	 *    update tableName
	 *       set state=?
	 *     where id=?   --- ��һ״̬����,���������¼�¼��һ��������״̬
	 *     
	 *    update tableName
	 *       set state1=?,state2=?,state3=?,...stateN=?
	 *     where id=?   --- ��״̬����,����������һ����¼�Ķ���������״̬
	 *     
	 *    update tableName
	 *       set state1=?,state2=?,state3=?,...stateN=?
	 *     where w1=? and w2=? and w3=?   --- ��������״̬����,�������������һ����¼�Ķ���������״̬
	 *     
	 * ɾ�����﷨����   
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
