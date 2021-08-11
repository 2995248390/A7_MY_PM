package com.cmm.services.support;

import java.io.Serializable;
import java.sql.PreparedStatement;

import com.cmm.system.db.DBUtils;


/**
 * 描述每个PreparedStatement 对象的执行方式
 * @author wangxg
 *
 */
class StatementBean implements Serializable
{
	private PreparedStatement pstm=null;   //语句对象
	private boolean isBatsh=false;         //是否是批处理
	public StatementBean(PreparedStatement pstm,boolean isBatsh)
	{
		this.pstm=pstm;
		this.isBatsh=isBatsh;
	}
	
	/**
	 * 通过语句对象,执行SQL语句
	 * @throws Exception
	 */
	public void executePstm()throws Exception
	{
		if(this.isBatsh)
		{
			this.pstm.executeBatch();
		}
		else
		{
			this.pstm.executeUpdate();
		}
	}
	
	public void closePstm()
	{
		DBUtils.close(this.pstm);
	}
	
}
