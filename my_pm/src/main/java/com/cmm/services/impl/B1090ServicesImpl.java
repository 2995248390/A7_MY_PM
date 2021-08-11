/**
 * FileName:     B1090ServicesImpl
 *
 * FileType:      java
 *
 * Date:          2021��07��31��
 *
 * Author:        �³���
 * 
 * Email:         814461932@qq.com
 *
 * Description:   �����Ϣ��ɾ��
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
		//�������ݺͲ�������׼��
		String msg=null;
		List<Object> paramlist=new ArrayList<Object>();
		//����SQL���
		String sql="INSERT into bodymsg(uid,blood,height,weight,airs,pulse,begintime,bodymsgstate)  VALUES (?,?,?,?,?,?,CURRENT_TIMESTAMP,'1') ";
		//������ԭ
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
			//ִ�����
			msg=this.execute(sql, paramlist.toArray())>0?"��ӳɹ�":"�������";
		}
		else 
		{
			 msg="��������������";
		}
		
		return msg;
		
	}

}
