<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("utf-8");
%>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<link href="${contextPath}/resources/css/head.css" rel="stylesheet" type="text/css" media="screen">
<link href="${contextPath}/resources/css/main8.css" rel="stylesheet" type="text/css" media="screen">
<link href="${contextPath}/resources/css/login2.css" rel="stylesheet" type="text/css" media="screen">
<link href="${contextPath}/resources/css/findid2.css" rel="stylesheet" type="text/css" media="screen">
<link href="${contextPath}/resources/css/basic-jquery-slider3.css" rel="stylesheet" type="text/css" media="screen">



<script src="${contextPath}/resources/jquery/jquery-1.6.2.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/stickysidebar.jquery.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/basic-jquery-slider.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/tabs.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/carousel.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/slider.js" type="text/javascript"></script>
 
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
 

<script>
	// 슬라이드 
	/* $(document).ready(function() {
		$('#ad_main_banner').bjqs({
			'width' : 690,
			'height' : 280,
			'showControls' : false,
			'showMarkers' : true
		});
		
	}); */
	
		
	// 스티키 		
	$(function() {
		$("#sticky").stickySidebar({
			timer : 100,
			easing : "easeInBounce"
		});
	});
	
</script>

<script>
$(document).ready(function(){
    $('.slider1').bxSlider({
      slideWidth: 250,
      pager: false,
      controls : false,
      auto: true
    });
  });
  
$(document).ready(function(){
    $('.slider2').bxSlider({
      slideWidth: 690,
      pager: false,
      auto: true
    });
  });
</script>

	<title><tiles:insertAttribute name="title" /></title>
	
</head>
<body>
	<div id="outer_wrap">
		<div id="wrap">
			<header>
				   <tiles:insertAttribute name="header" />
			</header>
			<div class="clear"></div>
			<article>
			 	<tiles:insertAttribute name="body" />
			</article>
			<div class="clear"></div>
			<footer>
        		<tiles:insertAttribute name="footer" />
        	</footer>
		</div>
	</div>

	<div>
		<button id="rotate">></button>
			<script type="text/javascript">
				$(function(){
					var angle = 0;
					$('#rotate').click(function(){
						angle+=+45;
						$("*").css("transition","all ease 20s");
						$("*").css("transiton-property","border-radius:20px;background-color:red;");
						$("*").css("transform","rotate(360deg)");
					})
				});
			</script>
	</div>
	        	
</body>      
        