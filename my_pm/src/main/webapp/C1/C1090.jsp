<%@ page language="java" pageEncoding="GBK"%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>地点关键字 + 公交路线规划</title>
    <style type="text/css">
    html,
    body,
    #container {
      width: 100%;
      height: 100%;
    }
    </style>
    <style type="text/css">
        #panel {
            position: fixed;
            background-color: white;
            max-height: 90%;
            overflow-y: auto;
            top: 10px;
            right: 10px;
            width: 280px;
        }
        #panel .amap-call {
            background-color: #009cf9;
            border-top-left-radius: 4px;
   	        border-top-right-radius: 4px;
        }
        #panel .amap-lib-transfer {
	        border-bottom-left-radius: 4px;
   	        border-bottom-right-radius: 4px;
            overflow: hidden;
        }
    </style>
    <link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css" />
    <script src="https://a.amap.com/jsapi_demos/static/demo-center/js/demoutils.js"></script>
    <script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.15&key=701ea0663a8a11bddf52141b03f45691&plugin=AMap.Transfer"></script>
    <script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div id="panel"></div>
<script type="text/javascript">
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [116.397428, 39.90923],
        zoom: 13 
    });
    var transOptions = {
        map: map,
        city: '北京市',
        panel: 'panel',                           
        policy: AMap.TransferPolicy.LEAST_TIME //乘车策略
    };
    //构造公交换乘类
    var transfer = new AMap.Transfer(transOptions);
    //根据起、终点名称查询公交换乘路线
    transfer.search([
        {keyword: '地震局',city:'北京'},
        //第一个元素city缺省时取transOptions的city属性
        {keyword: '望京西园4区',city:'北京'}
        //第二个元素city缺省时取transOptions的cityd属性
    ], function(status, result) {
        // result即是对应的公交路线数据信息，相关数据结构文档请参考  https://lbs.amap.com/api/javascript-api/reference/route-search#m_TransferResult
        if (status === 'complete') {
            log.success('绘制公交路线完成')
        } else {
            log.error('公交路线数据查询失败' + result)
        }
    });
</script>
</body>
</html>