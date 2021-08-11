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
 * �Ͳ���,�߹���Ĺ����Է���
 * @author wangxg
 *
 */
public final class Tools 
{
	private Tools() {}
	//*************************************************************************
		//************************** ���Ľ� ����
		//*************************************************************************
		
		/**
		 * �����Զ�����Ϣ
		 * @param emailaddress--Ŀ�������ַ
		 * @param msg--�Զ����ı�
		 * @return ���ط��ͽ����String��--"true" or "false"
		 */
		public static String sendEmail(String emailaddress,String msg)throws Exception
		{
			try 
			{
				HtmlEmail email = new HtmlEmail();//���ø���
				email.setHostName("smtp.qq.com");//��Ҫ�޸ģ�126����Ϊsmtp.126.com,163����Ϊ163.smtp.com��QQΪsmtp.qq.com
				email.setCharset("UTF-8");
				email.addTo(emailaddress);// �ռ���ַ
	 
				email.setFrom("3552342478@qq.com", "aa");//�˴��������ַ���û���,�û�������������д
	 
				email.setAuthentication("3552342478@qq.com", "onaoeqfxrsnqdafa");//�˴���д�����ַ�Ϳͻ�����Ȩ��
				
				email.setSubject("������֤");//�˴���д�ʼ������ʼ�����������д
				if(msg!=null)
				{
					email.setMsg(msg);//�˴���д�ʼ�����
					email.send();		
					return "true";
				}
				else
				{
				      //  ��ȡ6Ϊ�����֤��
				      String[] letters = new String[] {
				              "q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m",
				              "Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M",
				              "0","1","2","3","4","5","6","7","8","9"};
				      String code ="";
				      for (int i = 0; i < 6; i++) {
				          code = code + letters[(int)Math.floor(Math.random()*letters.length)];
				      } 
				      email.setMsg("��ð������ʼ���������֤����֤��Ϊ "+code+" ,����ظ����ʼ�");//�˴���д�ʼ�����
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
		 * ���ڷ�����֤��
		 * @param emailaddress--Ŀ�������ַ
		 * @return code--�������ɵ���֤��
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
			//1.����SQL���
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
		    	//��װ��ǰ������
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
		//�����Ľ��е�һ�μ���
		String md5pwd1=Tools.MD5Encode(pwd);
		//���ɻ�������
		String pwd2=md5pwd1+"�w�ͧ��z����Ⱥ��t,���^˪��������ѩ��,���˨ܨިϨȨ�׷��¤�ե������ȥ,��ع�����,"+md5pwd1;
		//���ɻ�������
		String md5pwd2=Tools.MD5Encode(pwd2);
		return md5pwd2;
		

	}
	
	/**
	 * MD5����������
	 * 1.�������:���Դ�����ͨ������,��������,���ǲ����Դ����Ļ�ԭ������--��������
	 * 2.ͳһ���ַ���,���ۼ��ܶ��ٴ�,�õ�������ʼ������ͬ
	 */
	 private final static String[] hexDigits = {
	        "0", "1", "2", "3", "4", "5", "6", "7",
	        "8", "9", "a", "b", "c", "d", "e", "f"
	     };

	  /**
	   * ת���ֽ�����Ϊ16�����ִ�
	   * @param b �ֽ�����
	   * @return 16�����ִ�
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
	   * ת���ֽ�Ϊ16�����ַ���
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
	   * �õ�MD5����������
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



	private final static int MATCH_SCALE=2;         //��������Ĭ��С��λ��
	/**
	 * �����ĸ�����Ϊ����ת������
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
	 * ���ַ��������java.sql.Date����
	 * <
	 *   SQL������͵ľ�׼ƥ��
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
	 * ��ȡ�̸�ʽ������
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
		//1.����JDBC�ӿڱ���
		PreparedStatement  pstm1=null;  //ִ�����е�ǰֵ�Ĳ�ѯ
		PreparedStatement  pstm2=null;  //Ҫô���µ�ǰ���е�ֵ,Ҫô���ӵ�ǰ����
		ResultSet rs=null;              //װ�����еĵ�ǰֵ
		try
		{
			//����SQL���1,��ѯ���е�ǰֵ
			String sql1="select x.currval  from sequence x where x.fname=?";
            pstm1=DBUtils.prepareStatement(sql1);
            pstm1.setObject(1, fname);
            rs=pstm1.executeQuery();  //��ѯ���еĵ�ǰֵ
            
            //���������ʾ���еĵ�ǰֵ
            int currentVal=0;
            //����������е�SQL������
            StringBuilder sql2=new StringBuilder();
            //�ж�sequence����,��ǰ�����Ƿ����
            if(rs.next())   //���ڵ�ǰ����
            {
            	//��ȡ���е�ǰֵ
            	currentVal=rs.getInt(1);
            	//���µ�ǰ����
            	sql2.append("update sequence x")
            		.append("   set x.currval=?")
            		.append(" where x.fname=?")
            		;
            }
            else            //��ǰ���в�����
            {
            	//���뵱ǰ����
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
