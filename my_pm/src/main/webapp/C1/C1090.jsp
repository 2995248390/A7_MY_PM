<%@ page language="java" pageEncoding="GBK"%>

<!DOCTYPE html>
<html>
<head>
    <title>��ͼ��ʾ</title>
    <style>
        html,
        body,
        #container {width:750px; height: 450px; }  
    </style>
</head>
<body>
<div id="container"></div>
<!-- ���ص�ͼJSAPI�ű� -->
<script src="https://webapi.amap.com/maps?v=1.4.15&key=701ea0663a8a11bddf52141b03f45691"></script>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.15&key=701ea0663a8a11bddf52141b03f45691"></script>
<script>
    var map = new AMap.Map('container',
    	{
	       zoom:15,//����
	       layers: [//ʹ�ö��ͼ��
	           //new AMap.TileLayer.Satellite(), //����ͼ��
	           new AMap.TileLayer.RoadNet()		 //·��ͼ��
	           //new AMap.Buildings()				 //¥��ͼ��
	       ],
	       resizeEnable: true, //�Ƿ��ص�ͼ�����ߴ�仯
	       center: [106.615834,29.535716],//���ĵ�����
	       viewMode:'3D'//ʹ��3D��ͼ    		
    	}
    );
    var marker = new AMap.Marker({
        position:[106.615834,29.535716]//���ͼ�и��������λ��
    })
    map.add(marker);//��ӵ���ͼ
    //map.remove(marker);//�Ƴ�����
</script>
</body>
</html>