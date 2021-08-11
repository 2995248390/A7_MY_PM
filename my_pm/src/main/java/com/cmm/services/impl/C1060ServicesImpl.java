/**
 * FileName:     A1040ServicesImpl
 *
 * FileType:      java
 *
 * Date:          2021年8月2日
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

public class C1060ServicesImpl extends JdbcServicesSupport {

	public C1060ServicesImpl(Map<String, String> dto) {
		super(dto);
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Map<String,String>> queryBodymsg()throws Exception
	{
		//还原页面查询条件
		String uid=this.getString("uid");
		
		
		//2.完成SQL主体拼接
		StringBuilder sql=new StringBuilder()
				.append(" select x.bid,x.uid,a.truename,c.svalue sex,b.svalue nation,x.blood,x.height,x.weight,x.airs,x.pulse")
			 	.append(" from   bodymsg x,user a,syscode b,syscode c")
				.append(" where  x.uid = a.uid  ")
			   	.append("       and b.sname = 'nation' and b.scode = a.nation")
			 	.append("	    and c.sname = 'sex'    and  a.sex = c.scode")
		        .append("       and x.uid=?");	 
			
			return this.queryForPage(sql.toString(),uid);
			
	}

}
