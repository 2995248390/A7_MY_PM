package com.cmm.services.support;

import java.io.Serializable;
import java.sql.PreparedStatement;

import com.cmm.system.db.DBUtils;


/**
 * ����ÿ��PreparedStatement �����ִ�з�ʽ
 * @author wangxg
 *
 */
class StatementBean implements Serializable
{
	private PreparedStatement pstm=null;   //������
	private boolean isBatsh=false;         //�Ƿ���������
	public StatementBean(PreparedStatement pstm,boolean isBatsh)
	{
		this.pstm=pstm;
		this.isBatsh=isBatsh;
	}
	
	/**
	 * ͨ��������,ִ��SQL���
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
