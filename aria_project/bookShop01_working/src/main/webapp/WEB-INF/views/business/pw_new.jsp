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
    .checkbox{
        margin-right: 20px;
        text-align: right;
    }
    .card-title{
       margin: 0 10;
        text-align: center;
    }
    .links{
        text-align: center;
        margin-bottom: 10px;
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
		<div class="card-title" style="margin-top:30px;">
            
			<h1>비밀번호 변경</h1>
		</div>
        
		<div class="card-body">
      <form action="${contextPath}/business/pw_new.do" class="form-signin" method="POST">
      <input type="hidden" name="bu_email" value="${email}"> 
      <p class="check" id="check"></p><br/>
        <input type="password" name="bu_pw" id="pw" class="form-control" placeholder="비밀번호" required ><BR>
        <input type="password" id="pw2" class="form-control" placeholder="비밀번호 재확인" required><br>
        <p class="check" id="check2">${resetpw_check}</p><br/>
        <button type="button"  id="btn-Yes" onclick="regist()" class="btn btn-lg btn-primary btn-block">비밀번호 재설정</button>
      </form>
        
		</div>
       
	</div>
  
   		
  </body>
  
  <script >
	
  	var check2 = "${findpw_checkt}";
	if(check2 != ""){
	 	alert(check2);
	}
	
	// 비밀번호 정규식
	var pwJ = /^[a-z0-9]{8,20}$/; 
	var pwc = false;
	var pwc2 = false;
	
	$("#pw").focusout(function(){
	     if($('#pw').val() == ""){
	   		$('#check').text('비밀번호를 입력해주세요.');
	   	  	$('#check').css('color', 'red');
	   	  	
	     }else if(!pwJ.test($(this).val())){
			$('#check').text('8~20자의 문자, 숫자만 사용가능합니다.');
			$('#check').css('color', 'red');
	     }else{
	    	 pwc2 = true;
	    	 $('#check').hide();
	     }
	  });
	
	$("#pw2").focusout(function(){
	     if($('#pw2').val() == ""){
	   		$('#check').text('필수 정보입니다.')
	   	  	$('#check').css('color', 'red')
	 	}else
   	 	$('#check').hide()
	  });
	
	$("#pw2").keyup(function(){
		   
	    if($(this).val()!=$("#pw").val()){
	        $("#check2").html("비밀번호가 다릅니다.");
	        $("#check2").css("color",'red');
	        pwc = false;
	
	    }else{
	        $("#check2").html("비밀번호가 일치합니다.");
	        $("#check2").css("color",'blue');
	        pwc = true;
	    }
	});
	
	$("#pw").keyup(function(){
		     
	    if($(this).val()!=$("#pw2").val()){
	        $("#check2").html("비밀번호가 다릅니다.");
	        $("#check2").css("color",'red');
	        pwc = false;
	
	    }else{
	        $("#check2").html("비밀번호가 일치합니다.");
	        $("#check2").css("color",'blue');
	        pwc = true;
	    }
	});

	function regist(){
		if(pwc2 == false){
		      alert('비밀번호는 8~20자의 문자, 숫자만 사용가능합니다.')
		 }else if(pwc == false ){
			  	alert('비밀번호를 다시 확인해주세요.')
		}else{
			alert('비밀번호 변경이 완료되었습니다.')
			$('form').submit();
		}
		<%session.invalidate();%>
		};
  </script>
</html>