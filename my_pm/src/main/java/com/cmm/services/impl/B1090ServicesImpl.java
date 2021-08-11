/**
 * FileName:     B1090ServicesImpl
 *
 * FileType:      java
 *
 * Date:          2021年07月31日
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

public class B1090ServicesImpl extends JdbcServicesSupport {

	public B1090ServicesImpl(Map<String, String> dto) {
		super(dto);
		// TODO Auto-generated constructor stub
	}
	
	public String addBodymsg()throws Exception
	{
		//返回数据和参数容器准备
		String msg=null;
		List<Object> paramlist=new ArrayList<Object>();
		//定义SQL语句
		String sql="INSERT into bodymsg(uid,blood,height,weight,airs,pulse,begintime,bodymsgstate)  VALUES (?,?,?,?,?,?,CURRENT_TIMESTAMP,'1') ";
		//参数还原
		String uid=this.getString("adduid");
		String blood=this.getString("addblood");
		String height=this.getString("addheight");
		String weight=this.getString("addweight");
		String airs=this.getString("addairs");
		String pulse=this.getString("addpulse");
		if(this.isNotNull(uid) && this.isNotNull(blood) && this.isNotNull(height) 
				&& this.isNotNull(weight) && this.isNotNull(airs) && this.isNotNull(pulse))
		{
			paramlist.add(uid);
			paramlist.add(blood);
			paramlist.add(height);
			paramlist.add(weight);
			paramlist.add(airs);
			paramlist.add(pulse);
			//执行语句
			msg=this.execute(sql, paramlist.toArray())>0?"添加成功":"网络故障";
		}
		else 
		{
			 msg="请输入完整数据";
		}
		
		return msg;
		
	}

}
