package com.cmm.services.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cmm.services.support.JdbcServicesSupport;
/**
 * FileName:      A2012Action
 *
 * FileType:      Action
 *
 * Date:          2021��07��30��
 *
 * Author:        �޺�
 *
 * Description:  ���ҽ��
 *
 */
public class C1020ServiceImpl extends JdbcServicesSupport {
    // ���ɹҺŵ��� ȫ��������
    private static int count = 0;
    // ÿСʱ������ɶ��� 9999��
    private static final int total = 9999;
    // ��¼��һ�ε����ڣ������ж��Ƿ���Ҫ����ȫ����
    private static String now = null;
	public C1020ServiceImpl(Map<String, String> dto) {
		super(dto);
	}
	//���ȫ��ҽ����Ϣ
	public List<Map<String,String>> getDocsMsg() throws Exception{
		StringBuilder sql = new StringBuilder()
				.append("select x.*,a.svalue cnsex,b.svalue cnnation,c.svalue cndocstate ,d.svalue cnuserstate,e.svalue cnlevel,f.svalue cncommunity")
				.append("	from (select user.*,doc.did,doc.level,doc.docstate,doc.description,")
				.append("	doc.clinicname,doc.clinicaddress,doc.workyear,doc.begintime docbegintime,")
				.append("	doc.docgrade,doc.specialty,doc.docdes,doc.learndes,doc.clinicdes,")
				.append("	doc.open1,doc.open2,doc.close1,doc.close2,doc.getday,")
				.append("	doc.getnum1,doc.getnum2")
				.append("    from user inner join doc on user.uid = doc.uid) x,")
				.append("    syscode a , syscode b, syscode c, syscode d, syscode e,syscode f")
				.append("    where a.sname='sex' and x.sex = a.scode ")
				.append("		and b.sname='nation' and x.nation = b.scode ")
			 	.append("       and c.sname='docstate' and x.docstate = c.scode ")
				.append("        and d.sname='userstate' and x.userstate = d.scode ")
				.append("        and e.sname='level' and x.level = e.scode")
				.append("        and f.sname='community' and x.community = f.scode")
				.append("        and docstate = '1' ")
				;
		 
		return this.queryForList(sql.toString(), null);
	}
	//����ҽ��������ʾΪ������**
	public List<Map<String,String>> dealName(List<Map<String,String>> appraiseList){
		for(Map<String,String>appraise :appraiseList)
		{
			String truename = appraise.get("truename");
			int size = truename.length();
			if(size==2) {
				truename = truename.substring(0,1);
				truename = truename+"*";
			}else {
			    String startname = truename.substring(0,1);
				String endname = truename.substring(size-1);
				StringBuilder temp = new StringBuilder();
				temp.append(startname);
				for(int i =0; i<size-2;i++) {
					temp.append("*");
				}
				truename = temp.toString()+endname;
			}
			appraise.put("truename", truename);
		}
		return appraiseList;
		
	}
	//��ø���ҽ����Ϣ
	public Map<String,String> getDocById() throws Exception{
		StringBuilder sql = new StringBuilder()
				  .append("		select x.*,a.svalue cnsex,b.svalue cnnation,c.svalue cndocstate ,d.svalue cnuserstate,e.svalue cnlevel,f.svalue cncommunity")
				  .append("			from (select user.truename,user.sex,user.age,user.nation,user.community,")
				  .append("					user.birthday,user.phonenumber,user.address,user.memo,user.mail,user.userstate,doc.*")
				  .append("					from user inner join doc USING(uid) ) x,")
				  .append("				syscode a , syscode b, syscode c, syscode d, syscode e,syscode f")
				  .append("			where a.sname='sex' and x.sex = a.scode ")
				  .append("				and b.sname='nation' and x.nation = b.scode ")
				  .append("				and c.sname='docstate' and x.docstate = c.scode ")
				  .append("				and d.sname='userstate' and x.userstate = d.scode ")
				  .append("				and e.sname='level' and x.level = e.scode")
				  .append("				and f.sname='community' and x.community = f.scode")
				  .append("				and x.did=?")        
				;
		return this.queryForMap(sql.toString(), this.getInteger("did"));
		
	}
	//��õ���ҽ������
	public List<Map<String,String>> getDocAppraise() throws Exception{
		StringBuilder sql = new StringBuilder()
				.append("	   select a.overtime,a.begintime,b.* ,c.*")
				.append("				from (select oid ,x.begintime,x.overtime ,x.uid")
				.append("				from orderlist x inner join doc y on x.did=y.did")  
				.append("				where x.did = ?) a , appraise b ,user c")
				.append("				where a.oid=b.oid and c.uid = a.uid")
				                
			     ;
		return this.queryForList(sql.toString(), this.getInteger("did"));
	}
	//��ʼ���Һ�ҳ��ԤԼʱ������
	public List<Map<String,String>> getTimeList() throws Exception {
		//�鵽��ҽ��������Ϣ,Ϊ��ʹ��
		String beforesql="select x.* from doc x  where x.did=?";
		Map<String,String> doc = this.queryForMap(beforesql, this.getInteger("did"));
		//��õ�ǰʱ��,Ϊ�˲������ҽ���Ŀ�ԤԼ�������
		Date date= new Date(System.currentTimeMillis());
		//�����Ż����������洢����ԤԼ��ʱ����ַ���
		List<Map<String,String>> result = new ArrayList<>();
		//����������
		String did = this.getString("did");
		String open1 = doc.get("open1");
		String open2 = doc.get("open2");
		String close1 = doc.get("close1");
		String close2 = doc.get("close2");
		Integer getday = Integer.parseInt(doc.get("getday"));
		Integer getnum1 = Integer.parseInt(doc.get("getnum1"));
		Integer getnum2 = Integer.parseInt(doc.get("getnum2"));
		//Ϊ��ѭ��ʱ�������õ� ʱ������
		String startTime1;
		String overTime1;
		String startTime2;
		String overTime2;
		//�������ݿ������ҽ��,ԤԼ�����ڵ�ÿ��ʱ��ιҺŵ������Ƿ�����,û���ͷ�������ʱ�䵽�������
		for(int i =0;i<getday;i++) {
			//ʹ��ǰʱ�����ѭ����i��
			startTime1 = this.addDay(date, i) +" " + open1;
			overTime1 = this.addDay(date, i) +" " + close1;
			startTime2 = this.addDay(date, i) +" " + open1;
			overTime2 = this.addDay(date, i) +" " + close2;
			StringBuilder sql = new StringBuilder()
					.append("select count(*) getnum")
					.append("	from orderlist ")
					.append("	where did = ? and  appointment ")
					.append("	between ? and ?")
					;
			Object[] param1 = new Object[] {
					did,
					startTime1,
					overTime1
			};
			Object[] param2 = new Object[] {
					did,
					startTime2,
					overTime2
			};
			//��ѯĳ��,��һ��ʱ��ε��Ƿ�����
		    Map<String,String> map1 = this.queryForMap(sql.toString(),param1 );
		    if(Integer.parseInt(map1.get("getnum"))<=getnum1) {
		    	Map<String,String> time = new HashMap<String, String>();
		    	time.put("appiontment", startTime1);
		    	time.put("getTime", startTime1+"~~"+overTime1);
		    	result.add(time);
		 
		    }
		    //��ѯĳ��,�ڶ���ʱ��ε��Ƿ�����	
		    Map<String,String> map2 = this.queryForMap(sql.toString(), param2);
		    if(Integer.parseInt(map2.get("getnum"))<=getnum2) {
		    	Map<String,String> time = new HashMap<String, String>();
		    	time.put("appiontment", startTime2);
		    	time.put("getTime", startTime2+"~~"+overTime2);
		    	result.add(time);
		    }
		}
		return result;
		
	}
	//��������:ʹ��ʱ���һ��,�����ַ���
	private String addDay(Date date,int i) {
		//ʹʱ�������
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date); 
		calendar.add(calendar.DATE,i);
		date=(Date) calendar.getTime(); 
		//ʹʱ��ת�����ַ���
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		String time = formatter.format(date);
		return time;
	}
	
	//���ɶ����� 
	public String getOnum()throws Exception
	{
		String onum=null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHH");  
		System.out.println(formatter.format(calendar.getTime()));
		onum=formatter.format(calendar.getTime());
        if (onum.equals(now)) {
            count++;// ����
        } else {
            count = 1;
            now = onum;
        }
		//����ĸ�������ӵ����ں�
		int countInteger = String.valueOf(total).length() - String.valueOf(count).length();// �㲹λ
		String bu = "";// ���ַ���
		for (int i = 0; i < countInteger; i++)
            bu += "0";
		bu += String.valueOf(count);
		if (count >= total) {
            count = 0;
        }
		return onum+bu;
	}
	//�����Һŵ�
	public List<Map<String,String>> insertOrder() throws Exception {
		//�������ص�����
		List<Map<String,String>> orderList = null;
		//Ϊ�˻�ȡ��ǰʱ���,����ת���ɱ�׼��ʽ
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = formatter.format(new Date(System.currentTimeMillis()));
		String appiontment = this.getString("appiontment");
		String uid = this.getString("userid");
		Integer did = this.getInteger("did");
		if(appiontment== null || "".equals(appiontment)) {
			return null;
		}
		//����ҺŹҺŵ���Ϣ
		StringBuilder sql = new StringBuilder()
				.append("insert into orderlist(did,uid,begintime,orderliststate,appointment,onum) ")
				.append("	values(?,?,current_timestamp,'2',?,?)")
				;
		//����
		Object[] params = new Object[] {
			did,
			uid,
			appiontment,
			this.getOnum()
		};
		//�������ɹ����в�ѯ
		if(executeUpdate(sql.toString(), params)>0) {
			//��ѯ��������ص��û���Ϣ��ҽ����Ϣ
			orderList = this.getOrderList();
		}
		return orderList;
	}
	//��ѯ�Һŵ���Ϣ
	public List<Map<String,String>> getOrderList() throws Exception {
		List<Map<String,String>> orderList = null;
		//��ѯ��������ص��û���Ϣ��ҽ����Ϣ
		StringBuilder sql2 = new StringBuilder()
				.append("select a.* ,c.*,b.*,d.svalue cnnation,")
				.append("		e.svalue cnsex,f.svalue cncommunity,")
				.append("		g.svalue cnlevel,h.svalue cnorderliststate")
				.append("		from doc a , ")
				.append("	(select x.* from orderlist x where uid = ? and  orderliststate = '2' ) b ,")
				.append("      user c ,syscode d ,syscode e,syscode f,syscode g,")
				.append("       syscode h")
				.append("		where	b.did = a.did and b.uid = c.uid")
				.append("				and d.sname = 'nation' and d.scode = c.nation ")
				.append("				and e.sname = 'sex' and e.scode = c.sex")
				.append("				and f.sname = 'community' and f.scode = c.community")
				.append("				and g.sname = 'level' and g.scode = a.level")
				.append("				and h.sname = 'orderliststate' and h.scode = b.orderliststate")
				;
		orderList = this.queryForList(sql2.toString(), this.getString("userid"));
		//����ѯ������Ϣ��ҽ���������û���Ϣ�ϲ�
		for(Map<String,String> order:orderList) {
			StringBuilder sql = new StringBuilder()
					.append("select  x.truename docname,x.phonenumber docphone")
					.append("	from user x ,doc y")
					.append("   where  x.uid = y.uid  and  y.did = ? ")
					;
			order.putAll(this.queryForMap(sql.toString(), order.get("did")));
		}
		return orderList;
	}
}
