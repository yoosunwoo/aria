<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<style>

#txtSban {
    width: 100%;
    height: 42px;
    text-align: center;
    border-top: 2px solid #008000;
	margin: 0;
    padding: 0;
    clear: both;
 	
}
</style>

<div id="txtSban">
<ul>
	<li><a href="#">이용약관</a></li>
	<li><a href="#">개인정보취급방침</a></li>
	<li><a href="#">고객센터</a></li>
	<li><a href="#">저작권 정책</a></li>
	<li><a href="#">사이트 맵</a></li>
	<li class="no_line"><a href="#">찾아오시는길</a></li>
</ul>
</div>

<div class="clear"></div>
<a href="#"><img style="margin:-60 0 0 30;" width="180"  height="200" alt="Aria" src="${contextPath}/resources/image/Logo_small.png" /></a>
<div style="padding-left:200px; font-size:1.2em;">
	<br>
	 ㈜아리아 <br>
	 (35234) 대전광역시 서구 대덕대로 182 오라클빌딩 10층   <br>
	 아리아 콜센터 &nbsp <a href="tel:1544-1544">1544-1544</a> (09:00 ~ 18:00 평일) &nbsp &nbsp Fax.042.476.2111 <br>  
	 사업자등록번호 &nbsp 102-81-11111 <br>
	 COPYRIGHT(C) 아리아 ALL RIGHTS RESERVED.
</div>

