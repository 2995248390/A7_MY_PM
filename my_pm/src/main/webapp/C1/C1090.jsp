<%@ page language="java" pageEncoding="GBK"%>

<!DOCTYPE html>
<html>
<head>
    <title>地图显示</title>
    <style>
        html,
        body,
        #container {width:750px; height: 450px; }  
    </style>
</head>
<body>
<div id="container"></div>
<!-- 加载地图JSAPI脚本 -->
<script src="https://webapi.amap.com/maps?v=1.4.15&key=701ea0663a8a11bddf52141b03f45691"></script>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.15&key=701ea0663a8a11bddf52141b03f45691"></script>
<script>
    var map = new AMap.Map('container',
    	{
	       zoom:15,//级别
	       layers: [//使用多个图层
	           //new AMap.TileLayer.Satellite(), //卫星图层
	           new AMap.TileLayer.RoadNet()		 //路线图层
	           //new AMap.Buildings()				 //楼块图层
	       ],
	       resizeEnable: true, //是否监控地图容器尺寸变化
	       center: [106.615834,29.535716],//中心点坐标
	       viewMode:'3D'//使用3D视图    		
    	}
    );
    var marker = new AMap.Marker({
        position:[106.615834,29.535716]//向地图中该坐标添加位置
    })
    map.add(marker);//添加到地图
    //map.remove(marker);//移除坐标
</script>
</body>
</html>