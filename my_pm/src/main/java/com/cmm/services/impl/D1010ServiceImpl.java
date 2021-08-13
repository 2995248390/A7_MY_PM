package com.cmm.services.impl;

import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;
/**
 * FileName:      D1010ServiceImpl
 *
 * FileType:      Action
 *
 * Date:          2021年8月13日
 *
 * Author:        罗航
 *
 * Description:   登录/注册
 *
 */
public class D1010ServiceImpl extends JdbcServicesSupport {

	public D1010ServiceImpl(Map<String, String> dto) {
		super(dto);
	}
	// 用户登录的检验
		public Map<String,String> loginCheckByMd5() throws Exception{
			 String upass =this.getString("upass");
			 if(upass==null||"".equals(upass))
			 {
				 return null;
			 }
			return loginCheck(this.getString("account"), Tools.getMd5(upass));
		}
		public Map<String,String> loginCheck() throws Exception{
			return loginCheck(this.getString("account"), this.getString("upass"));
		}
		public Map<String, String> loginCheck(String account,String upass) throws Exception {
			StringBuilder sql = new StringBuilder()
							.append("select x.uid,x.account,x.upass,x.truename,x.idcard,")
							.append("		a.svalue cnsystype,b.svalue cnsex,x.age,c.svalue cnnation,d.svalue cncommunity,")
							.append("        x.birthday,x.phonenumber,x.begintime,x.address,e.svalue cnuserstate,")
							.append("        x.memo,x.mail,x.systype,x.sex,x.nation,x.community,x.userstate")
							.append("	from user x,syscode a,syscode b,syscode c,syscode d,syscode e")
							.append("  where a.sname = 'systype' and x.systype = a.scode ")
							.append("		 and b.sname = 'sex' and x.sex = b.scode")
							.append("		 and c.sname = 'nation' and x.nation = c.scode")
							.append("		 and d.sname = 'community' and x.community = d.scode")
							.append("		 and e.sname = 'userstate' and x.userstate = e.scode")
							.append("		 and x.account=? and x.upass=? and userstate='1'")
							;
			return this.queryForMap(sql.toString(),account,upass);
		}
		//获得医生信息
		public Map<String, String> getDocMsg(String uid ) throws Exception{
			StringBuilder sql = new StringBuilder()
					.append("select x.*,a.svalue cnlevel,b.svalue cndocstate")
					.append("	from doc x,syscode a,syscode b")
					.append("    where a.sname='level' and  x.level = a.scode")
					.append("			and b.sname='docstate' and x.docstate = b.scode")
					.append("			and uid=?")
					;
			return this.queryForMap(sql.toString(),uid);
		}
		/*
		 * 辅助方法,使得查询出来的菜单,形成树结构字符串
		 */
		public String getMenuTree(String systype) throws Exception {
			StringBuilder sysmenu = new StringBuilder();
			// 得到这个用户类别的根菜单
			StringBuilder sql = new StringBuilder()
					.append("select x.fid, x.fname,x.url,x.fpid ")
					.append("		from functionlist x  ")
					.append("		where systype = ? and fpid = 0;")
					;
			List<Map<String, String>> menuBase = this.queryForList(sql.toString(), systype);
			sysmenu.append("<ul id=\"menu\">");
			for (Map<String, String> t : menuBase) {
				sysmenu.append("<li class=\"childUlLi\">")
						.append("<a href=\"#\"><i class=\"glyph-icon icon-reorder\"></i>" + t.get("fname") + "</a>")
						.append(iterateMenus(t.get("fid"), systype));
				sysmenu.append("</li>");
			}
			sysmenu.append("</ul>");

			return sysmenu.toString();
		}

		/*
		 * 辅助方法,递归tree
		 */
		public String iterateMenus(String fid, String systype) throws Exception {
			StringBuilder menuString = new StringBuilder();
			StringBuilder sql = new StringBuilder().append("select x.fid,x.fname,x.url,x.fpid")
					.append("  from functionlist x").append(" where x.systype=? and x.fpid = ?");
			List<Map<String, String>> menuList = this.queryForList(sql.toString(), systype, fid);
			if (menuList.size() != 0) {
				menuString.append("<ul>");
				for (Map<String, String> t : menuList) {
					String id = t.get("fid");
					menuString.append("<li><a href=\"" + this.getString("classpath") + "/" + t.get("url")
							+ "\" target=\"menuFrame\"><i class=\"glyph-icon icon-chevron-right\"></i>" + t.get("fname")
							+ "</a></li>");
					menuString.append(iterateMenus(id, systype));
				}
				menuString.append("</ul>");
			}
			return menuString.toString();
		}
		public int register()throws Exception
		 {
			 String account= this.getString("account");
			if(this.checkOne(account)){
				return 0;
			}
			 StringBuilder sql=new StringBuilder()
						.append("insert into user(account,upass,truename,idcard,systype,")	
						.append("				  sex,age,nation,community,birthday, ")	          
						.append("				  phonenumber,begintime,address,userstate,memo,")	             
						.append("				  mail)")	
						.append("		   values(?,?, ?, ?, ?,")	 
						.append("				  ?, ?, ?, ?, str_to_date(?, '%Y-%m-%d'),")	
						.append("				  ?, current_timestamp, ?, ?, ?,")	 
						.append("				  ?)")	
						;
				Object params[] = {
						//第一行
						this.getString("account"),
						Tools.getMd5(this.getString("upass")),
						this.getString("truename"),
						this.getString("idcard"),
						"2",
						//第二行
						this.getString("sex"),
						this.getString("age"),
						this.getString("nation"),
						this.getString("community"),
						this.getString("birthday"),
						//第三行
						this.getString("phonenumber"),
						this.getString("address"),
						"1",
						this.getString("memo"),
						//第四行
						this.getString("mail"),	
				};
				return this.executeUpdate(sql.toString(), params);
			}
		 //查询账号是否存在.属性唯一标识是idcar
		 private boolean checkOne(String account)throws Exception {
			 String sql = "select uid from user where idcard=? ";
			 Map<String,String> map = this.queryForMap(sql, account);
			 if(map!=null) {
			 return true;
			 }
			 return false;
		 }

}
