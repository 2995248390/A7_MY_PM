package com.cmm.services.support;

import java.sql.*;

public interface ParseResultSet
{
	 /**
	  * 把接收到的rs,按指定格式,拼接成串
	  * @param rs
	  * @return
	  * @throws Exception
	  */
	 String formatData(ResultSet rs)throws Exception;
	 
	 
	 default void show(){}
}
