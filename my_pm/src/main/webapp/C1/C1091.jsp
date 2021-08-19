<%@ page language="java"  pageEncoding="GBK"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>步行导航</title>
    <style type="text/css">
        html,
        body,
        #container {
            width: 100%;
            height: 97%;
        }
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
        #panel .amap-lib-walking {
	        border-bottom-left-radius: 4px;
   	        border-bottom-right-radius: 4px;
            overflow: hidden;
        }
    </style>
    <link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css" />
    <script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.15&key=${KEY }&plugin=AMap.Walking"></script>
    <script src="https://a.amap.com/jsapi_demos/static/demo-center/js/demoutils.js"></script>
    <script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"><button>返回</button></div>
<div id="panel"><button>返回</button></div>
<div><button>返回</button></div>
<script type="text/javascript">
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [ ${location.centerAddress }],//地图中心点,此处设为两个坐标的平均值
        zoom: 13 //地图显示的缩放级别
    });
    //步行导航
    var walking = new AMap.Walking({
        map: map,
        panel: "panel"
    }); 
    walking.search([
    	//传入地址，与所在城市  	
        {keyword: '${addressMap.uaddress }',city:'${location.ucity}'},
        {keyword: '${addressMap.daddress }',city:'${location.dcity}'}
    ], function(status, result) {
        // result即是对应的步行路线数据信息，相关数据结构文档请参考  https://lbs.amap.com/api/javascript-api/reference/route-search#m_WalkingResult
        if (status === 'complete') {
            log.success('绘制步行路线完成')
        } else {
            log.error('步行路线数据查询失败' + result)
        } 
    });
</script>
</body>
</html>