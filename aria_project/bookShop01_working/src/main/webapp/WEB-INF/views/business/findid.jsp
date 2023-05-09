<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored="false" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
  <head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/css/main8.css" rel="stylesheet" type="text/css" media="screen">
    <title>아이디 찾기</title>
    <style>
        @import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
	
	
	
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
	}

    #btn-Yes{
        background-color: #66cc00;
        border: none;
    }
	
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
    .card-title1{
        margin: 0 10;
        text-align: center;
    }
	 .links{
        text-align: center;
        margin-bottom: 10px;
    }

   
    .text2{
    	color : blue;
    }
    
    *, ::after, ::before {
		box-sizing: inherit;
	}
	
	#menu ul::after, ::before {
		box-sizing: inherit !important ;
	}
	 dl, ol, ul {
   	 margin-top: 0; 
   	 margin-bottom: 0;
    }
    #btn-Yes{
    	box-sizing : border-box;
    }
    </style>
  </head>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:25rem;">
		<div class="card-title1" style="margin-top:30px;">
           <h1>아이디 찾기</h1>
			
		</div>
        
		<div class="card-body">
      <form action="${contextPath}/business/findid.do" class="form-signin" method="POST">
  		 <p class="text2"> ${findid2}</p>
        <input type="text" name="bu_name" id="name" class="form-control" placeholder="이름" required autofocus><BR>
        <input type="email" name="bu_email" id="email" class="form-control" placeholder="이메일" required><br>
        	<p class="check" id="check">${check}</p><br/>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">다 음</button>
      
      </form>
        
		</div>
        <div class="links">
       
            <a href="${contextPath}/business/pw_find.do">비밀번호 찾기</a> | <a href="${contextPath}/member/login.do">로그인</a> | <a href="${contextPath}/member/memberFormSelect.do">회원가입</a>
		
        </div>
	</div>
   
  </body>
  
</html>