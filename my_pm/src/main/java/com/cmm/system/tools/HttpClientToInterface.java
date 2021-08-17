
package com.cmm.system.tools;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Yang JianQiu
 * @Date: 2019/4/28 11:07
 *
 * HttpClientģ��get��post���󲢷������������json�ȣ�
 * ���ο����ϡ�
 * https://javasam.iteye.com/blog/2117845
 * https://blog.csdn.net/qq_28379809/article/details/82898792
 */
public class HttpClientToInterface {

    /**
     * httpClient��get����ʽ
     * ʹ��GetMethod������һ��URL��Ӧ����ҳʵ�ֲ��裺
     * 1.����һ��HttpClient����������Ӧ�Ĳ�����
     * 2.����һ��GetMethod����������Ӧ�Ĳ�����
     * 3.��HttpClient���ɵĶ�����ִ��GetMethod���ɵ�Get������
     * 4.������Ӧ״̬�룻
     * 5.����Ӧ����������HTTP��Ӧ���ݣ�
     * 6.�ͷ����ӡ�
     * @param url
     * @param charset
     * @return
     */
    public static String doGet(String url, String charset){
        /**
         * 1.����HttpClient�������ò���
         */
        HttpClient httpClient = new HttpClient();
        //����Http���ӳ�ʱΪ5��
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);

        /**
         * 2.����GetMethod�������ò���
         */
        GetMethod getMethod = new GetMethod(url);
        //����get����ʱΪ5��
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        //�����������Դ����õ���Ĭ�ϵ����Դ�����������
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

        String response = "";

        /**
         * 3.ִ��HTTP GET ����
         */
        try {
            int statusCode = httpClient.executeMethod(getMethod);

            /**
             * 4.�жϷ��ʵ�״̬��
             */
            if (statusCode != HttpStatus.SC_OK){
                System.err.println("�������" + getMethod.getStatusLine());
            }

            /**
             * 5.����HTTP��Ӧ����
             */
            //HTTP��Ӧͷ����Ϣ������򵥴�ӡ
            Header[] headers = getMethod.getResponseHeaders();
            for (Header h: headers){
                System.out.println(h.getName() + "---------------" + h.getValue());
            }
            //��ȡHTTP��Ӧ���ݣ�����򵥴�ӡ��ҳ����
            //��ȡΪ�ֽ�����
            byte[] responseBody = getMethod.getResponseBody();
            response = new String(responseBody, charset);
            System.out.println("-----------response:" + response);
            //��ȡΪInputStream������ҳ������������ʱ���Ƽ�ʹ��
            //InputStream response = getMethod.getResponseBodyAsStream();

        } catch (HttpException e) {
            //�����������쳣��������Э�鲻�Ի��߷��ص�����������
            System.out.println("���������URL!");
            e.printStackTrace();
        } catch (IOException e){
            //���������쳣
            System.out.println("���������쳣!");
        }finally {
            /**
             * 6.�ͷ�����
             */
            getMethod.releaseConnection();
        }
        return response;
    }

    /**
     * post����
     * @param url
     * @param json
     * @return
     */
    public static String doPost(String url, JSONObject json){
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);

        postMethod.addRequestHeader("accept", "*/*");
        postMethod.addRequestHeader("connection", "Keep-Alive");
        //����json��ʽ����
        postMethod.addRequestHeader("Content-Type", "application/json;charset=utf-8");
        //���������������Header
        postMethod.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        //����������
        postMethod.addParameter("commentId", json.getString("commentId"));

        String res = "";
        try {
            int code = httpClient.executeMethod(postMethod);
            if (code == 200){
                res = postMethod.getResponseBodyAsString();
                System.out.println(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        doGet("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=13026194071", "UTF-8");
        System.out.println("-----------�ָ���------------");
        System.out.println("-----------�ָ���------------");
        System.out.println("-----------�ָ���------------");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("commentId", "13026194071");
        doPost("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=13026194071", jsonObject);
    }
}
