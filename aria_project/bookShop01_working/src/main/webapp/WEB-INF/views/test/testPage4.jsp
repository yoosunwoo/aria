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
	form input{
		border:0px;
		width:50px;
		height:20px;
		text-align:center;
	}
</style>
</head>
<body>
	<h1>기타 테스트 페이지 입니다!!</h1>
	<br><br>
	
	<form action="${contextPath }/test/testPage5.do" method="post">
		<fieldset>
			<table border="1">
				<tr bgcolor="lightgray">
					<td>번호</td>
					<td>이름</td>
					<td>색깔</td>
					<td>비고</td>
				</tr>
				<c:forEach var="list" items="${fruitList }" varStatus="index">
					<tr>
						<td><input type="text" name="fruitsVOList[${index.count-1 }].fruitNo" value="${list.fruitNo }" readonly></td>
						<td><input type="text" name="fruitsVOList[${index.count-1 }].fruitName" value="${list.fruitName }" readonly></td>
						<td><input type="text" name="fruitsVOList[${index.count-1 }].fruitColor" value="${list.fruitColor }" readonly></td>
						<td><input id="fruitChecked[${index.count-1}]" type="checkbox" checked="checked"></td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit">
	</form>
</body>
</html>