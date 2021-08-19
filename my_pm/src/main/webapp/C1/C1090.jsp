<%@ page language="java" pageEncoding="GBK"%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>�ص�ؼ��� + ����·�߹滮</title>
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
        city: '������',
        panel: 'panel',                           
        policy: AMap.TransferPolicy.LEAST_TIME //�˳�����
    };
    //���칫��������
    var transfer = new AMap.Transfer(transOptions);
    //�������յ����Ʋ�ѯ��������·��
    transfer.search([
        {keyword: '�����',city:'����'},
        //��һ��Ԫ��cityȱʡʱȡtransOptions��city����
        {keyword: '������԰4��',city:'����'}
        //�ڶ���Ԫ��cityȱʡʱȡtransOptions��cityd����
    ], function(status, result) {
        // result���Ƕ�Ӧ�Ĺ���·��������Ϣ��������ݽṹ�ĵ���ο�  https://lbs.amap.com/api/javascript-api/reference/route-search#m_TransferResult
        if (status === 'complete') {
            log.success('���ƹ���·�����')
        } else {
            log.error('����·�����ݲ�ѯʧ��' + result)
        }
    });
</script>
</body>
</html>