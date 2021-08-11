package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;
/**
 * FileName:      A1022ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          
 *
 * Author:        Ǯ��ͬ
 * 
 * Email:         1053680842@qq.com
 *
 * Description:  ���ҽ�����޸�ҽ����Ϣ
 *
 */
public class A1022ServicesImpl extends JdbcServicesSupport {

	public A1022ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean adddoc()throws Exception{
	
		StringBuilder sql1=new StringBuilder()
				.append("insert into user(account,upass,truename,idcard,systype,")	
				.append("				  sex,age,nation,community,birthday, ")	          
				.append("				  phonenumber,begintime,address,userstate,memo,")	             
				.append("				  mail)")	
				.append("		   values(?,?, ?, ?, ?,")	 
				.append("				  ?, ?, ?, ?, str_to_date(?, '%Y-%m-%d'),")	
				.append("				  ?, current_timestamp, ?, ?, ?,")	 
				.append("				  ?)")	
				;
		Object params1[] = {
				//��һ��
				
				this.getString("maccount"),
				Tools.getMd5(this.getString("mupass")),
				this.getString("mtruename"),
				this.getString("midcard"),
				"3",
				//�ڶ���
				this.getString("msex"),
				this.getString("mage"),
				this.getString("mnation"),
				this.getString("mcommunity"),
				this.getString("mbirthday"),
				//������
				this.getString("mphonenumber"),
				this.getString("maddress"),
				"1",
				this.getString("mmemo"),
				//������
				this.getString("mmail"),	
		};
		//this.executeUpdate(sql.toString(), params);
		this.executeUpdate(sql1.toString(), params1);
		//��ȡ�ո���ӵ��û�uid
		StringBuilder sql3=new StringBuilder()
				.append("select uid from user where account=? and upass=? ");
		Object params3 [] = {
				this.getString("maccount"),
				Tools.getMd5(this.getString("mupass"))
		};
		System.out.println(this.queryForMap(sql3.toString(), params3).get("uid"));
		String uid=this.queryForMap(sql3.toString(), params3).get("uid");
		
		//���doc����Ϣ
		StringBuilder sql2=new StringBuilder()
				.append("insert into doc(uid,level,docstate,clinicname,clinicaddress,	")
				.append("							 description,workyear,begintime,docgrade)")
				.append("					   values(?,?,?,?,?,")
				.append("                            ?,?,current_timestamp,'60'  )")
				;

				Object params2[] = {
						//��һ��
						uid,
						this.getString("mlevel"),
						"1",
						this.getString("mclinicname"),
						this.getString("mclinicaddress"),
						//�ڶ���
						this.getString("mdescription"),
						this.getString("mworkyear"),
				};
				System.out.println(params2);
				return this.executeUpdate(sql2.toString(), params2)>0;
				 
		 
	}

	public boolean modifyDoc() throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" update  `user` x,doc y ")
				.append("					set x.account = ?,  x.truename = ?, x.idcard = ?,")
				.append("					x.sex = ?, x.age = ?, x.nation = ?, x.community = ?, x.birthday = ?,")
				.append("					x.phonenumber = ?, x.address = ?, x.memo = ?,y.description = ?, ")
				.append("					x.mail = ?,y.level=?,y.workyear=?,y.clinicaddress=?,y.clinicname=?");
		
		if(this.getString("mupass")!="") {
				sql.append(" ,x.upass=? ");
			//	System.out.println(this.getString("mupass")+"p");
				     }
				
				sql.append("			    where x.uid =? ");
				sql.append("		and x.uid=y.uid ");
							
			 if(this.getString("mupass")!="") {
				 Object params[] = {
							//��һ��
							this.getString("maccount"),
							
							this.getString("mtruename"),
							this.getString("midcard"),
							//�ڶ���
							this.getString("msex"),
							this.getString("mage"),
							this.getString("mnation"),
							this.getString("mcommunity"),
							this.getString("mbirthday"),
							//������
							this.getString("mphonenumber"),
							this.getString("maddress"),
							
							this.getString("mmemo"),
							this.getString("mdescription"),
							//������
							this.getString("mmail"),
							this.getString("mlevel"),
							this.getString("mworkyear"),
							this.getString("mclinicaddress"),
							this.getString("mclinicname"),
							//������
							"null",
							"null"												
					};
		    	 params[17]=Tools.getMd5(this.getString("mupass"));		    	 
		    	 params[18]=this.getString("uid");
		    	 return this.executeUpdate(sql.toString(), params) > 0;
		     }else {
		    	 Object params2[] = {
							//��һ��
							this.getString("maccount"),
							
							this.getString("mtruename"),
							this.getString("midcard"),
							//�ڶ���
							this.getString("msex"),
							this.getString("mage"),
							this.getString("mnation"),
							this.getString("mcommunity"),
							this.getString("mbirthday"),
							//������
							this.getString("mphonenumber"),
							this.getString("maddress"),
							
							this.getString("mmemo"),
							this.getString("mdescription"),
							//������
							this.getString("mmail"),
							this.getString("mlevel"),
							this.getString("mworkyear"),
							this.getString("mclinicaddress"),
							this.getString("mclinicname"),
							//������
							"null",
																			
					};		    	 
		    	 params2[17]=this.getString("uid");
		    	 return this.executeUpdate(sql.toString(), params2) > 0;
		     }
			
			
	}
	
	
	

}
