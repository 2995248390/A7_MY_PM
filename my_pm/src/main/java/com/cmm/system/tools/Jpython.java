package com.cmm.system.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public  class Jpython
{

    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
    	int a=23,b=34;
        try {
//            InputStream in1 = Jpython.class.getResourceAsStream("test.py");  
//            Properties porp = new Properties();  
//            porp.load(in1);  
//            System.out.println(porp.getProperty("url"));
        	
	        	// D:/GIT/A7_MY_PM/my_pm/src/main/java/com/cmm/system/tools/python/test.py /A7_MY_PM/my_pm/src/main/java/com/cmm/system/tools/test.py
	        	String[] args1 = new String[] { "C:/ProgramData/Anaconda3/python.exe", "D:/GIT/A7_MY_PM/my_pm/src/main/java/com/cmm/system/tools/python/test.py", String.valueOf(a), String.valueOf(b) };
	            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
	            //用输入输出流来截取结果
	            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
	            String line = null;
	            while ((line = in.readLine()) != null) {
	                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

    }
	
}
