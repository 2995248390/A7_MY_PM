package com.cmm.services.support;

import java.sql.*;

public interface ParseResultSet
{
	 /**
	  * �ѽ��յ���rs,��ָ����ʽ,ƴ�ӳɴ�
	  * @param rs
	  * @return
	  * @throws Exception
	  */
	 String formatData(ResultSet rs)throws Exception;
	 
	 
	 default void show(){}
}
