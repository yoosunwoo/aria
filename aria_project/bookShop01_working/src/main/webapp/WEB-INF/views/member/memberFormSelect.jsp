<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">

<style>
#mem {
padding: 40px 0 60px;
    text-align: center;
}

.subTitArea {
    position: relative;
    margin-bottom: 40px;
    padding: 0 0 28px 0;
    background: 
}

.subTitArea_stepArea2 {
/*     position: absolute; */
    right: 0;
    top: 0;
}

#hd3 {
	text-align: center;
	font-size: 25px;
	color: #66cc00;
}

#hd {text-align: center; font-size: 23px;}

#imgs {
	margin-right: 160px;
}
</style>

</head>
<body>
	


	<h1 id="hd">회원가입</h1>
	<br>
	<h3 id="hd3">가입하실 회원 유형을 선택해 주세요.</h3>
	 <br><br><br>
	 <div id="mem">
		   		
			   		<a href="${contextPath}/member/memberAgree.do"><img id="imgs" alt="" src="${contextPath}/resources/image/person.png"></a>
			   		<a href="${contextPath}/business/businessAgree.do"><img alt="" src="${contextPath}/resources/image/licensee.png"></a>
			   		
	</div>
</body>
</html>