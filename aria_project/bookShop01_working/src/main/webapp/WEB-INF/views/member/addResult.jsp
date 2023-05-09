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
    <title>회원가입 완료</title>
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
        margin-top: 40px;
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
	 #links{
	 	margin-top: 25px;
        margin-bottom: 10px;
        background-color: #8c8c8c; 
        color: #fff;
        border: none;
       box-sizing : border-box;
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
    
    #hd {
    	text-align: center; 
    	font-size: 20px;
    }
    
    #p1 {
    	text-align: center;
    	font-size: 18px;
    }
    
    #p2 {
    	text-align: center;
    	font-size: 14px;
    }
    </style>
  </head>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:25rem;">
		<div class="card-title1" style="margin-top:30px;">
           <h1 id="hd">회원가입 완료</h1>
			
		</div>
        
		<div class="card-body">
      <form action="${contextPath}/member/login.do" class="form-signin" method="POST">
  		<p id="p1">회원 가입이 완료되었습니다!</p><br>
  		<h2 id="p2">아리아 회원 가입이 정상적으로 처리되었습니다.<br><br>로그인 후 다양한 서비스를 이용하실 수 있습니다.</h2><br>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">로그인하기</button>
      
      </form>
        
		
       
            <a href="${contextPath}/main/main.do" id="links" class="btn btn-lg btn-primary btn-block">메인페이지로 가기</a>
		
        </div>
	</div>
   
  </body>
  
</html>