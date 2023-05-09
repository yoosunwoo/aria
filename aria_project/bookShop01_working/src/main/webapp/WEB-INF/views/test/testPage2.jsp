<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">

</style>
</head>
<body>
	<h1>관리자 테스트 페이지2 입니다!!</h1>
	<br><br>
	<div id="map" style="width:100%;height:350px;"></div>
<!-- <script type="text/javascript">
// YSH - common_api_data - create markers
window.onload = function(){
			var jsonList = new Array();
			var json = JSON.stringify(${common_api_list_json});
//			json = JSON.parse(json);
			$.each(JSON.parse(json), function(index,item){
				var data = new Object();
				data.title = "\'"+item.mrhstNm+"\'";
				data.latlng = "new kakao.maps.LatLng("+item.latitude+", "+item.longitude+")";
				jsonList.push(data);
			});
//			alert(JSON.stringify(jsonList));
}
</script> -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=09c32d85a4d00570abf6d57eeacd89b3"></script>
<script>
//YSH - common_api_data - create markers
var jsonList = [];
//var jsonString;
window.onload = function(){
	var json = JSON.stringify(${common_api_list_json});
//	json = JSON.parse(json);
	$.each(JSON.parse(json), function(index,item){
		var data = new Object();
		data.title = item.mrhstNm;
		data.latitude = item.latitude;
		data.longitude = item.longitude;
		jsonList.push(data);
	});
	//alert(jsonList.length);
	//alert(JSON.stringify(jsonList));
	//jsonString = JSON.stringify(jsonList).replace(/"([^"]+)":/g, '$1:');
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	mapOption = { 
	    center: new kakao.maps.LatLng(36.3294001, 127.4435056), // 지도의 중심좌표
	    level: 5 // 지도의 확대 레벨
	};

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
    var positions =[];
    	for(var i=0;i<jsonList.length;i++){
			var data = new Object();
				data.title = jsonList[i].title;
			    data.latlng = new kakao.maps.LatLng(jsonList[i].latitude,jsonList[i].longitude);
			    positions.push(data);
			    }
		for (var i = 0; i < positions.length; i ++) {
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			map: map, // 마커를 표시할 지도
			position: positions[i].latlng,// 마커를 표시할 위치
			title : positions[i].title // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			});
	    }
		//데이터를 가져오기 위해 jQuery를 사용합니다
		// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
		/* $.get("/download/web/data/chicken.json", function(data) {
		// 데이터에서 좌표 값을 가지고 마커를 표시합니다
		// 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
		var markers = $(data.positions).map(function(i, position) {
			return new kakao.maps.Marker({
				position : new kakao.maps.LatLng(position.lat, position.lng)
			    });
		}); */
}
</script>

	<br><br><br>
	<%-- <p id="common_api_list_json">${common_api_list_json }</p> --%>
	<!-- <script>
		window.onload = function(){
			//console.log(JSON.parse($.("${common_api_list_json}")));
			var json = [[${common_api_list_json}]];
			alert(JSON.stringify(json));
			//alert($("#common_api_list_json").val());
		}
	</script> -->
</body>
</html>