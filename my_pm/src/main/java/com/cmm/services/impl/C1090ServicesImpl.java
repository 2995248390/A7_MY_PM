package com.cmm.services.impl;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.cmm.services.support.JdbcServicesSupport;

public class C1090ServicesImpl extends JdbcServicesSupport
{

	public C1090ServicesImpl(Map<String, String> dto)
	{
		super(dto);
	}
	private static String BASE_PATH="https://restapi.amap.com/v3/direction/driving?";
	private static String KEY="a28750caf12e3ed01f20726b9e0dfe1f";


    /**
     * 高德地图WebAPI : 驾车路径规划 计算两地之间行驶的距离(米)
     * String origins:起始坐标
     * String destination:终点坐标
     *输入：原坐标:{116.45925,39.910031}，目标坐标:{116.587922,40.081577}
     *输出：25424
     */
    /**
     * @param origins -- 起始点的坐标
     * @param destination -- 目的地坐标
     * @return 返回两地的距离
     */
    public static String distance(String origins, String destination) {
        String distanceString = null;
        try {
            String url = BASE_PATH 
            		+ "origin=" + origins 
            		+ "&destination=" + destination
                    + "&output=xml"
            		+ "&key="+ KEY;
            String aa =HttpClientUtil.doGet(url);
            JSONObject jsonobject=JSONObject.fromObject(aa);
            JSONArray pathArray = jsonobject.getJSONObject("route").getJSONArray("paths");
            distanceString = pathArray.getJSONObject(0).getString("distance");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return distanceString;
    }
}

