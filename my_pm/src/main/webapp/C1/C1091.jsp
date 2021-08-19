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
            height: 100%;
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
    <script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.15&key=701ea0663a8a11bddf52141b03f45691&plugin=AMap.Walking"></script>
    <script src="https://a.amap.com/jsapi_demos/static/demo-center/js/demoutils.js"></script>
    <script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body>
<div id="container"></div>
<div id="panel"></div>
<script type="text/javascript">
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [106.619246,29.531000],//��ͼ���ĵ�,�˴���Ϊ���������ƽ��ֵ
        zoom: 13 //��ͼ��ʾ�����ż���
    });
    //���е���
    var walking = new AMap.Walking({
        map: map,
        panel: "panel"
    }); 
    walking.search([
    	//�����ַ�������ڳ���
        {keyword: '�������ϰ��������ʵ��ѧ27��ѧ����Ԣ',city:'����'},
        {keyword: '�������ϰ�������·22�Ÿ�7��',city:'����'}
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