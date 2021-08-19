# -*- coding: utf-8 -*-
"""
Created on Wed Aug 18 08:44:30 2021

@author: asus
"""

import sys
import requests
from requests.exceptions import ReadTimeout, ConnectTimeout

KEY='a28750caf12e3ed01f20726b9e0dfe1f'

def selectFun():
    """选择调用方法"""
    fun1='getLongitudeandLatitude'
    fun2='getAddress'
    fun3='getPath'
    a=list()
    #sys.argv[0]存着python文件名，sys.arg[1]存放有调用函数名，往后依次为参数
    
    for i in range(1, len(sys.argv)):
        a.append((sys.argv[i]))
    result="false"
    choice=a.pop(0)
    try:
        if choice == fun1:
            result=getLongitudeandLatitude(*a)
            print(result)
        elif choice == fun2:
            result=getAddress(*a)
            print(result)
        elif choice==fun3:
            result=getPath(*a)
            print(result)
        else:
            print("false")
    except Exception as e:
        print(e)
        print(result)

def getLongitudeandLatitude(address:str,batch:str='false'):
    """
        通过地址获取经纬度
    """
    # https://restapi.amap.com/v3/geocode/geo?parameters
    # https://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&output=XML&key=<用户的key>
    parameters = {'address':address,'key': KEY,'batch':batch}
    base = 'https://restapi.amap.com/v3/geocode/geo'
    locate = 0
    city="重庆"
    try:
        response = requests.get(base, parameters,timeout=2)
        if response.status_code == 200:
            answer = response.json()
            #print(answer)
            city=answer["geocodes"][0]["city"]
            locate = answer["geocodes"][0]["location"]
        else:
            print(False)
            pass
    except (ReadTimeout, ConnectTimeout):
        print(False)
        pass
    return city,locate

def getAddress(location:str):
    """
        通过坐标获取地址
    """
    #https://restapi.amap.com/v3/geocode/regeo?parameters
    #https://restapi.amap.com/v3/geocode/regeo?output=xml&location=116.310003,39.991957&key=<用户的key>&radius=1000&extensions=all
    parameters = {'location':location,'key':KEY}
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


def getPath(origin:str,destination:str,isindoor:str="1",AlternativeRout:str='1',show_fields:str='navi'):
    """
        获取行进路线 isindoor='1',origin="106.609246,29.529986",destination={'location':"106.607808,29.531873"}
    """
    key=KEY
    #https://restapi.amap.com/v5/direction/walking?parameters
    parameters={'key':key,'isindoor':isindoor,'origin':origin,'destination':destination}
    base='https://restapi.amap.com/v5/direction/walking'
    try:
        response=requests.get(base, parameters,timeout=2)
        if response.status_code==200:
            answer=response.json()
            #print(answer)
            path=answer['route']['paths'][0]['steps']
            print(path)
            
    except (ReadTimeout, ConnectTimeout):
        pass


if __name__ == '__main__':
    selectFun()
    
    # try:
    #     print(123)
    #     a=[]
    #     # for i in range(1, len(sys.argv)):
    #     #     a.append((sys.argv[i]))
    #     # print(a[0],a[1])
          # locate=getLongitudeandLatitude('重庆市南岸区重庆邮电大学27栋宿舍', KEY)
          # print(locate)
    # except Exception as e:
    #     print(e)
    #     pass

    #地址转经纬
    # locate=getLongitudeandLatitude('重庆市南岸区崇文路22号附7号泰康药房', batch='true')
    # print(locate)

    # address=getAddress(locate) 
    # print(address)
    
    #测试getPath()方法
    #getPath(isindoor='1',origin="106.609246,29.529986",destination="106.607808,29.531873")
    
    




