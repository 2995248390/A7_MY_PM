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
 * Author:        钱昱同
 * 
 * Email:         1053680842@qq.com
 *
 * Description:  添加医生，修改医生信息
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
				//第一行
				
				this.getString("maccount"),
				Tools.getMd5(this.getString("mupass")),
				this.getString("mtruename"),
				this.getString("midcard"),
				"3",
				//第二行
				this.getString("msex"),
				this.getString("mage"),
				this.getString("mnation"),
				this.getString("mcommunity"),
				this.getString("mbirthday"),
				//第三行
				this.getString("mphonenumber"),
				this.getString("maddress"),
				"1",
				this.getString("mmemo"),
				//第四行
				this.getString("mmail"),	
		};
		//this.executeUpdate(sql.toString(), params);
		this.executeUpdate(sql1.toString(), params1);
		//获取刚刚添加的用户uid
		StringBuilder sql3=new StringBuilder()
				.append("select uid from user where account=? and upass=? ");
		Object params3 [] = {
				this.getString("maccount"),
				Tools.getMd5(this.getString("mupass"))
		};
		System.out.println(this.queryForMap(sql3.toString(), params3).get("uid"));
		String uid=this.queryForMap(sql3.toString(), params3).get("uid");
		
		//添加doc表信息
		StringBuilder sql2=new StringBuilder()
				.append("insert into doc(uid,level,docstate,clinicname,clinicaddress,	")
				.append("							 description,workyear,begintime,docgrade)")
				.append("					   values(?,?,?,?,?,")
				.append("                            ?,?,current_timestamp,'60'  )")
				;

				Object params2[] = {
						//第一行
						uid,
						this.getString("mlevel"),
						"1",
						this.getString("mclinicname"),
						this.getString("mclinicaddress"),
						//第二行
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
							//第一行
							this.getString("maccount"),
							
							this.getString("mtruename"),
							this.getString("midcard"),
							//第二行
							this.getString("msex"),
							this.getString("mage"),
							this.getString("mnation"),
							this.getString("mcommunity"),
							this.getString("mbirthday"),
							//第三行
							this.getString("mphonenumber"),
							this.getString("maddress"),
							
							this.getString("mmemo"),
							this.getString("mdescription"),
							//第四行
							this.getString("mmail"),
							this.getString("mlevel"),
							this.getString("mworkyear"),
							this.getString("mclinicaddress"),
							this.getString("mclinicname"),
							//第五行
							"null",
							"null"												
					};
		    	 params[17]=Tools.getMd5(this.getString("mupass"));		    	 
		    	 params[18]=this.getString("uid");
		    	 return this.executeUpdate(sql.toString(), params) > 0;
		     }else {
		    	 Object params2[] = {
							//第一行
							this.getString("maccount"),
							
							this.getString("mtruename"),
							this.getString("midcard"),
							//第二行
							this.getString("msex"),
							this.getString("mage"),
							this.getString("mnation"),
							this.getString("mcommunity"),
							this.getString("mbirthday"),
							//第三行
							this.getString("mphonenumber"),
							this.getString("maddress"),
							
							this.getString("mmemo"),
							this.getString("mdescription"),
							//第四行
							this.getString("mmail"),
							this.getString("mlevel"),
							this.getString("mworkyear"),
							this.getString("mclinicaddress"),
							this.getString("mclinicname"),
							//第五行
							"null",
																			
					};		    	 
		    	 params2[17]=this.getString("uid");
		    	 return this.executeUpdate(sql.toString(), params2) > 0;
		     }
			
			
	}
	
	
	

}
