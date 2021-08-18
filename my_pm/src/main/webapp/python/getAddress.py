# -*- coding: utf-8 -*-
"""
Created on Wed Aug 18 08:44:30 2021

@author: asus
"""

import sys
from urllib.parse import quote, unquote
import requests
from requests.exceptions import ReadTimeout, ConnectTimeout

KEY='a28750caf12e3ed01f20726b9e0dfe1f'

def getLongitudeandLatitude(address:str,key:str):
    """
        通过地址获取经纬度
    """
    # https://restapi.amap.com/v3/geocode/geo?parameters
    # https://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&output=XML&key=<用户的key>
    parameters = {'address':address,'key': key}
    base = 'https://restapi.amap.com/v3/geocode/geo'
    locate = 0
    try:
        response = requests.get(base, parameters)
        if response.status_code == 200:
            answer = response.json()
            #print(answer)
            locate = answer["geocodes"][0]["location"]
        else:
            print(False)
            pass
    except (ReadTimeout, ConnectTimeout):
        print(False)
        pass
    return locate

def getAddress(location:str,key:str):
    """
        通过坐标获取地址
    """
    #https://restapi.amap.com/v3/geocode/regeo?parameters
    #https://restapi.amap.com/v3/geocode/regeo?output=xml&location=116.310003,39.991957&key=<用户的key>&radius=1000&extensions=all
    parameters = {'location':location,'key':key}
    base='https://restapi.amap.com/v3/geocode/regeo'
    address=str()
    try:
        response=requests.get(base, parameters,timeout=2)
        if response.status_code==200:
            answer=response.json()
            #print(answer)
            address=answer['regeocode']['formatted_address']
        else:
            pass
    except (ReadTimeout, ConnectTimeout):
        pass
    return address

def ipLocation(ip:str,key:str):
    """
        ip定位,获取所在城市
    """
    #https://restapi.amap.com/v3/ip?parameters
    #https://restapi.amap.com/v3/ip?ip=114.247.50.2&output=xml&key=<用户的key>
    parameters = {'ip':ip,'key':key}
    base='https://restapi.amap.com/v3/ip'
    address=str()
    try:
        response=requests.get(base, parameters,timeout=2)
        if response.status_code==200:
            answer=response.json()
            #print(answer)
            locate=answer['rectangle']
        else:
            pass
    except (ReadTimeout, ConnectTimeout):
        pass
    return locate


if __name__ == '__main__':
    try:
        print(123)
        a=[]
        # for i in range(1, len(sys.argv)):
        #     a.append((sys.argv[i]))
        # print(a[0],a[1])
        locate=getLongitudeandLatitude('重庆市南区重庆邮电大学27栋宿舍', KEY)
        print(locate)
    except Exception as e:
        print(e)
        pass

    # address=getAddress(locate, KEY)
    # print(address)
    
    # url='%E9%87%8D%E5%BA%86%E5%B8%82%E5%8D%97%E5%8C%BA%E9%87%8D%E5%BA%86%E9%82%AE%E7%94%B5%E5%A4%A7%E5%AD%A627%E6%A0%8B%E5%AE%BF%E8%88%8D'
    # url2='我和你'
    # str2=quote(url2)
    # str2=unquote(str2)
    # print(unquote(url))
    # print(str2)
    
    # fun1='getLongitudeandLatitude'
    # fun2='getAddress'
    # a=list()
    # #sys.argv[0]存着python文件名，sys.arg[1]存放有调用函数名，往后依次为参数
    
    # for i in range(1, len(sys.argv)):
    #     a.append((sys.argv[i]))
    # print(a[0],a[1])
    # result=0
    # print(result)
    # try:
    #     address=str(a[1])
    #     print(address)
    #     result=getLongitudeandLatitude(address, KEY)
    # except Exception as e:
    #     print(e.)
    #     print("错误处理："+e)
    #     print(result)


