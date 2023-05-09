<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html >
<html>

<style>
	#kakao-login-btn img{
		width: 220px;
		height: 50px;
	}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
</head>
<body>
   <div class="loginbox">
   		<ul style="text-align:center;">
   			<li style="border:none;"><h2>사용자 로그인</a></h2></li>
   			<li><h2><a href="${contextPath}/business/login.do">사업자 로그인</a></h2></li>
   		</ul>
        <form id="form" action="${contextPath}/member/login.do" method="post">
            <label for="loginid">아이디(E-mail)</label>
            <input  name="me_id" type="text" id="loginid" placeholder="아이디(E-mail)을 입력해 주세요">
            <label for="loginpw">비밀번호</label>
            <input name="me_pw" type="password" id="loginpw" placeholder="비밀번호를 입력해 주세요">
      <ul>
        <li><a href="${contextPath}/member/findid.do">아이디찾기</a></li>
        <li><a href="${contextPath}/member/pw_find.do">비밀번호찾기</a></li>
        <li><a href="${contextPath}/member/memberFormSelect.do">회원가입</a></li>
      </ul>
      <button type="button" onClick="submit_check()">로그인</button>
		<a id="kakao-login-btn" href="javascript:loginWithKakao()">
  			<img alt="" src="${contextPath }/resources/image/kakao_login_medium_narrow.png">
		</a>
<script>
  function loginWithKakao(){
	window.location.href = 'https://kauth.kakao.com/oauth/authorize?client_id=4ddb03f3af33d59aa23b0b87552eb17f&redirect_uri=http://localhost:8080/aria.com/loginOAuth&state=confirm&response_type=code'
  }
</script>
	</form>

      <script>


function submit_check(){
   var id = document.getElementById("loginid");
    var pw = document.getElementById("loginpw");
    var formObj=document.getElementById("form");
    if (id.value == "" || id.value == null){
      alert("아이디를 입력하세요.");
      id.focus();
    } else if (pw.value == ""||pw.value == null) {
      alert("비밀번호를 입력하세요.");
      pw.focus();
      return true;
    } else {
      formObj.submit();
    } 

  };

</script>
</div>
</body>
</html>