<%@ page language="java"  pageEncoding="GBK"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>���е���</title>
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
<div id="container"><button>����</button></div>
<div id="panel"><button>����</button></div>
<div><button>����</button></div>
<script type="text/javascript">
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [ ${location.centerAddress }],//��ͼ���ĵ�,�˴���Ϊ���������ƽ��ֵ
        zoom: 13 //��ͼ��ʾ�����ż���
    });
    //���е���
    var walking = new AMap.Walking({
        map: map,
        panel: "panel"
    }); 
    walking.search([
    	//�����ַ�������ڳ���  	
        {keyword: '${addressMap.uaddress }',city:'${location.ucity}'},
        {keyword: '${addressMap.daddress }',city:'${location.dcity}'}
    ], function(status, result) {
        // result���Ƕ�Ӧ�Ĳ���·��������Ϣ��������ݽṹ�ĵ���ο�  https://lbs.amap.com/api/javascript-api/reference/route-search#m_WalkingResult
        if (status === 'complete') {
            log.success('���Ʋ���·�����')
        } else {
            log.error('����·�����ݲ�ѯʧ��' + result)
        } 
    });
</script>
</body>
</html>