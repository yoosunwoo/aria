<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.sendBox{
		border:border-box;
		border:1px solid black;
		width:100%;
	}
	.sendBox:hover{
		transition:all ease 1.5s;
		background:#eecccc;
	}
</style>
</head>
<body>
	<h1>관리자 테스트 페이지 입니다!!</h1>
	<br><br>
	<label for="next">------지도</label>
	<form>
	<button id="next2" type="submit" formmethod="post" formaction="${contextPath }/test/testPage2.do">지도 페이지로 가기 -></button>
	</form>
	<label for="next">------공공데이터</label>
	<form>
	<button id="next3" type="submit" formmethod="post" formaction="${contextPath }/test/testPage3.do">공공데이터 페이지로 가기 -></button>
	</form>
	<br><br>
	<form>
	<button id="next3" type="submit" formmethod="post" formaction="${contextPath }/test/testPage4.do">과일 테스트 페이지로 가기 -></button>
	</form>
	<br><br>
	<form action="${contextPath }/kakaoMsg/send.do" method="post">
		<label>테스트</label>
		<input type="text" name="alpha">
		<input type="submit" value="요청하기">
		<hr>
		
		<label>카카오톡 문자 테스트 - </label><p>로그인 한 카카오 사용자 : ${kakaoMemberInfo.me_name }</p>
		<hr>
		
		<a id="kakao-login-btn" href="javascript:loginWithKakao()">
  			<img alt="" src="${contextPath }/resources/image/kakao_login_medium_narrow.png">
		</a>
<script>
  function loginWithKakao(){
	window.location.href = 'https://kauth.kakao.com/oauth/authorize?client_id=4ddb03f3af33d59aa23b0b87552eb17f&redirect_uri=http://localhost:8080/aria.com/loginOAuth&state=confirm&response_type=code&scope=friends,talk_message'
  }
</script>
		
		<br>
		<div class="sendBox">
			<!-- <select id="sendTo" title="수신자 선택">
				<option value="#"></option>
				<option value="lsc">임상철</option>
				<option value="ysw">유선우</option>
				<option value="ysh">윤석환</option>
				<option value="pyc">박영철</option>
			</select> -->
			<div style="display:block; margin:10px;">
			<fieldset>
				<legend>카카오 메시지 보낼 친구목록 창</legend>
					<label for="callKakaoFriends">친구목록 불러오기</label>
					<button type="submit" id="callKakaoFriends" formaction="${contextPath }/kakaoMsg/callKakaoFriends.do" formmethod="post">누르기</button>
					
			
			</fieldset>
			</div>
		<hr>
			<div>
			<c:choose>
			<c:when test="${not empty viewFriendsList }">
				<select name="sendTo" title="수신자 선택">
					<c:forEach var="list" items="${viewFriendsList }">
						<option value="${list.nickname }">${list.nickname }</option>						
					</c:forEach>
				</select>
				<input type="text" name="sendMsg">
				<button type="submit" id="sendToFriends" formaction="${contextPath }/kakaoMsg/sendToFriends.do" formmethod="post">친구에게 문자 보내기</button>
				<input type="submit" value="문자 보내기">
			</c:when>
			<c:otherwise>
				<p>수신자 정보를 불러오지 못했습니다.</p>
			</c:otherwise>
			</c:choose>
			</div>
		</div>
	</form>

</body>
</html>