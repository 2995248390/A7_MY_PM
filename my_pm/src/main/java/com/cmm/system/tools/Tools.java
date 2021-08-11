package com.cmm.system.tools;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cmm.system.db.DBUtils;

import org.apache.commons.mail.HtmlEmail;
import org.mywq.util.LabelValueBean;


/**
 * 低并发,高共享的功能性方法
 * @author wangxg
 *
 */
public final class Tools 
{
	private Tools() {}
	//*************************************************************************
		//************************** 张文江 工具
		//*************************************************************************
		
		/**
		 * 发送自定义消息
		 * @param emailaddress--目标邮箱地址
		 * @param msg--自定义文本
		 * @return 返回发送结果（String）--"true" or "false"
		 */
		public static String sendEmail(String emailaddress,String msg)throws Exception
		{
			try 
			{
				HtmlEmail email = new HtmlEmail();//不用更改
				email.setHostName("smtp.qq.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
				email.setCharset("UTF-8");
				email.addTo(emailaddress);// 收件地址
	 
				email.setFrom("3552342478@qq.com", "aa");//此处填邮箱地址和用户名,用户名可以任意填写
	 
				email.setAuthentication("3552342478@qq.com", "onaoeqfxrsnqdafa");//此处填写邮箱地址和客户端授权码
				
				email.setSubject("邮箱验证");//此处填写邮件名，邮件名可任意填写
				if(msg!=null)
				{
					email.setMsg(msg);//此处填写邮件内容
					email.send();		
					return "true";
				}
				else
				{
				      //  获取6为随机验证码
				      String[] letters = new String[] {
				              "q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m",
				              "Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M",
				              "0","1","2","3","4","5","6","7","8","9"};
				      String code ="";
				      for (int i = 0; i < 6; i++) {
				          code = code + letters[(int)Math.floor(Math.random()*letters.length)];
				      } 
				      email.setMsg("你好啊，此邮件仅用于验证，验证码为 "+code+" ,请勿回复该邮件");//此处填写邮件内容
				      email.send();
				      return code;
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "false";
			}
		}
		/**
		 * 用于发送验证码
		 * @param emailaddress--目标邮箱地址
		 * @return code--返回生成的验证码
		 * @throws Exception
		 */
		public static  String sendEmail(String emailaddress)throws Exception
		{
			return Tools.sendEmail(emailaddress,null);
		}

	public static List<LabelValueBean> getOptions(String fname)throws Exception
	{
		return Tools.getOptions(fname, "0");
	}
	public static List<LabelValueBean> getOptions(String fname,String sfcode)throws Exception
	{
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try
		{
			//1.定义SQL语句
			StringBuilder sql=new StringBuilder()
			.append("select x.svalue,x.scode")
			.append("  from syscode x")
			.append(" where x.isv=?")
			.append("   and x.sfcode=?")
			.append("   and x.sname=?")
			;
		    pstm=DBUtils.prepareStatement(sql.toString());
		    pstm.setObject(1, "1");
		    pstm.setObject(2, sfcode);
		    pstm.setObject(3, fname);
			rs=pstm.executeQuery();
		    
		    List<LabelValueBean> opts=new ArrayList<>();
		    LabelValueBean bean=null;  
		    while(rs.next())
		    {
		    	//封装当前行数据
		    	bean=new  LabelValueBean(rs.getString(1), rs.getString(2));
		    	opts.add(bean);
		    }
		    return opts;
		}
		finally
		{
			DBUtils.close(rs);
			DBUtils.close(pstm);
		}
	}

	//******************Begin  MD5******************	
	public final static String initPwd="d3c70526aff576899584e95babfb4085";
	
	public static String getMd5(String pwd) throws Exception
	{
		//对明文进行第一次加密
		String md5pwd1=Tools.MD5Encode(pwd);
		//生成混淆密文
		String pwd2=md5pwd1+"趙客ъф縵しゎと胡纓,吳鉤霜ùǎóê雪明,事了ㄜㄞㄏㄈㄥㄗ拂衣もフヱヴスニ去,深藏功与名,"+md5pwd1;
		//生成混淆密文
		String md5pwd2=Tools.MD5Encode(pwd2);
		return md5pwd2;
		

	}
	
	/**
	 * MD5的两个特性
	 * 1.单向加密:可以从明文通过加密,生成密文,但是不可以从密文还原成明文--不可逆性
	 * 2.统一个字符串,无论加密多少次,得到的密文始终是相同
	 */
	 private final static String[] hexDigits = {
	        "0", "1", "2", "3", "4", "5", "6", "7",
	        "8", "9", "a", "b", "c", "d", "e", "f"
	     };

	  /**
	   * 转换字节数组为16进制字串
	   * @param b 字节数组
	   * @return 16进制字串
	   */
	  private static String byteArrayToHexString(byte[] b)
	  {
	      StringBuffer resultSb = new StringBuffer();
	      for (int i = 0; i < b.length; i++)
	      {
	         resultSb.append(byteToHexString(b[i]));
	      }
	      return resultSb.toString();
	  }
	  /**
	   * 转换字节为16进制字符串
	   * @param b byte
	   * @return String
	   */
	  private static String byteToHexString(byte b)
	  {
	      int n = b;
	      if (n < 0)
	         n = 256 + n;
	      int d1 = n / 16;
	      int d2 = n % 16;
	      return hexDigits[d1] + hexDigits[d2];
	  }
	  /**
	   * 得到MD5的秘文密码
	   * @param origin String
	   * @throws Exception
	   * @return String
	   */
	  private static String MD5Encode(Object origin) throws Exception
	  {
	       String resultString = null;
	       try
	       {
	           resultString=new String(origin.toString());
	           MessageDigest md = MessageDigest.getInstance("MD5");
	           resultString=byteArrayToHexString(md.digest(resultString.getBytes()));
	           return resultString;
	       }
	       catch (Exception ex)
	       {
	          throw ex;
	       }
	  }	
	//******************END  MD5******************	  



	private final static int MATCH_SCALE=2;         //四舍五入默认小数位数
	/**
	 * 以下四个方法为精度转换方法
	 * @param dol double
	 * @param scale int
	 * @return String
	 */
	public static double ObjToDouble(Object dol, int scale)
	{
		  return Tools.ObjectToBigDecimal(dol, scale).doubleValue();
	}
	public static double ObjToDouble(Object dol)
	{
	   return Tools.ObjToDouble(dol, MATCH_SCALE);	
	}
	
	public static String DoubleToStr(double dol, int scale)
	{
	    return Tools.ObjectToBigDecimal(dol, scale).toString();
	}
	public static String DoubleToStr(double dol)
	{
	    return Tools.DoubleToStr(dol, MATCH_SCALE);
	}

	public static double DoubleToDouble(double dol, int scale)
	{
	    return Tools.ObjectToBigDecimal(dol, scale).doubleValue();
	}
	public static double DoubleToDouble(double dol)
	{
	    return Tools.DoubleToDouble(dol,  MATCH_SCALE);
	}

	public static double StrToDouble(String dol, int scale)
	{
	    return Tools.ObjectToBigDecimal(dol, scale).doubleValue();
	}
	public static double StrToDouble(String dol)
	{
	    return Tools.StrToDouble(dol, MATCH_SCALE);
	}
	public static String StrToStr(String dol, int scale)
	{
	   return Tools.ObjectToBigDecimal(dol, scale).toString();
	}
	public static String StrToStr(String dol)
	{
	   return Tools.StrToStr(dol,MATCH_SCALE);
	}

	private static BigDecimal ObjectToBigDecimal(Object dol,int scale)
	{
		if(dol==null || dol.equals(""))
		{
			return new BigDecimal(0);
		}
		
		BigDecimal decimal = new BigDecimal(dol.toString());
		decimal = decimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
		return decimal;
	}

	
	/**
	 * 将字符串翻译成java.sql.Date类型
	 * <
	 *   SQL语句类型的精准匹配
	 * >
	 * @param obj_date
	 * @return
	 */
	public static java.sql.Date toSqlDate(Object obj_date)
	{
		java.sql.Date sql_date=java.sql.Date.valueOf(obj_date.toString());
		return sql_date;
	}
	
	public static java.sql.Timestamp getSqlDateTime(Object localDateTime)
	{
		String dateTime=localDateTime.toString().replace("T", " ")+":00";
		java.sql.Timestamp jst = java.sql.Timestamp.valueOf(dateTime);
	    return jst;
	}
	
	
	/**
	 * 获取短格式的日期
	 * @return
	 */
	public static String getShortDate()
	{
		return Tools.getFormatDate("yyyyMMdd");
	}
	
	public static String getIOSDate()
	{
		return Tools.getFormatDate("yyyy-MM-dd");
	}
	
	public static String getFormatDate(String pattern)
	{
		LocalDateTime ldt=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern(pattern);
		return ldt.format(dtf);
	}
	
	
	public static int getSequence(String fname)throws Exception
	{
		//1.定义JDBC接口变量
		PreparedStatement  pstm1=null;  //执行序列当前值的查询
		PreparedStatement  pstm2=null;  //要么更新当前序列的值,要么增加当前序列
		ResultSet rs=null;              //装载序列的当前值
		try
		{
			//定义SQL语句1,查询序列当前值
			String sql1="select x.currval  from sequence x where x.fname=?";
            pstm1=DBUtils.prepareStatement(sql1);
            pstm1.setObject(1, fname);
            rs=pstm1.executeQuery();  //查询序列的当前值
            
            //定义变量表示序列的当前值
            int currentVal=0;
            //定义更新序列的SQL语句变量
            StringBuilder sql2=new StringBuilder();
            //判断sequence表中,当前序列是否存在
            if(rs.next())   //存在当前序列
            {
            	//读取序列当前值
            	currentVal=rs.getInt(1);
            	//更新当前序列
            	sql2.append("update sequence x")
            		.append("   set x.currval=?")
            		.append(" where x.fname=?")
            		;
            }
            else            //当前序列不存在
            {
            	//插入当前序列
            	sql2.append("insert into sequence(currval,fname,seqloop)")
            		.append("              values(?,?,current_date)")
            		;
            }
        	pstm2=DBUtils.prepareStatement(sql2.toString());
        	pstm2.setObject(1, ++currentVal);
        	pstm2.setObject(2, fname);
        	pstm2.executeUpdate();
        	
            return currentVal;
		}
		finally
		{
			DBUtils.close(rs);
			DBUtils.close(pstm1);
			DBUtils.close(pstm2);
		}
		
	}
	
	

	


}
