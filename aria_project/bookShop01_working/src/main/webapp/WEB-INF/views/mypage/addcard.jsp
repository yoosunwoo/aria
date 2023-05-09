<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="${contextPath}/resources/css/mypage_main.css" rel="stylesheet" type="text/css" media="screen">
<link href="${contextPath}/resources/css/mypage_common.css" rel="stylesheet" type="text/css" media="screen">
</head>
<style>
	dl a dd {
		display : inline-block;
		float : left;
	}
	
	dl a dd h3 {
		float : left;
	}
	dl a dd p {
		clear: both;
	}
	.addcard {text-align: center;}
	.addcard p{text-align: center; font-size: 1.6em;}
	.addcard input[type="text"] {margin-left:33px; width:300px; height: 40px; font-size:29px; display: inline-block;}
	.addcard input[type="button"]{width:50px; height:40px; background: #66cc00; border: #66cc00; font-family: 'S-CoreDream-3Light'; color: #ffffff}
	
	
</style>
<body>
<div id="wrap" class="">
    <div id="contWrap">
        <div id="left_menu">
    <div class="left_menu">
        <div class="login_cont">
            <h2 class="name"><img src="/theme/6/img/main/m_name.png">임상철 님이 로그인하셨습니다.</h2>
            <ul class="mem_list">
                <li class="logout"><a href="../member/logout.jsp">로그아웃</a></li>
                
                <li class="cart"><a href="../mypage/cart_list.jsp">장바구니</a></li>
                
                
            </ul>
        </div>
        <ul class="list">
        
            <li id="course" class="icon01">
                <a href="#" class="dropdown-toggle">문의내역조회</a>
            </li>
            
            <li id="certificate" class="icon02 none_sMenu">
                <a href="${contextPath}/mypage/addcard.do" class="dropdown-toggle">카드등록</a>
            </li>
            
            <li id="order" class="icon03">
                <a href="#" class="dropdown-toggle">이용내역조회</a>
            </li>
            
            <li id="coupon" class="icon04 none_sMenu">
                <a href="${contextPath}/mypage/modmember.do" class="dropdown-toggle">회원정보 수정</a>
            </li>
            
            <li id="wish" class="icon05">
                <a href="javascript:deletemember('${login_id}')">회원탈퇴</a>
            </li>
        </ul>
        <script>
            $(document).ready(function() {
                const currMenu = $("#" + "");
                currMenu.addClass("bgColor");
                if(!currMenu.hasClass("none_sMenu")) {
                    currMenu.find(".sMenu").show();
                }
            });
        </script>
        <script type="text/javascript">
  		 function deletemember(_login_id){
    		  if(confirm("회원탈퇴하시겠습니까")){
        		 var formObj=document.createElement("form");
         		 var i_login_id = document.createElement("input");
         		 i_login_id.name="login_id";
         		 i_login_id.value=_login_id;
         
		         formObj.appendChild(i_login_id);
		         document.body.appendChild(formObj); 
		         formObj.method="post";
		         formObj.action="${contextPath}/mypage/deletemember.do";
		         formObj.submit();
		      }else{
		         alert("탈퇴취소")
		  }
      
  		 }

		</script>
    </div>
</div>
        <div class="mask_popup"></div>
        <div id="contents">
            <div class="whiteBox state_cont">
				<div class="addcard">
				<p>카드등록</p>
				<input type="text" name="me_cardNo" id="me_cardNo">
				<input type="button" value="등록" onClick="fn_overlapped()">
				<input id="before_card" type="hidden" value="${memberInfo.me_cardNo}">
				</div>
</div>

<script>
function fn_overlapped() {
	var before_card=$("#before_card").val();
	var new_card = $("#me_cardNo").val();
	if (before_card == new_card) {
		alert("이미등록된 카드입니다.");
		return;
	}
	$.ajax({
		type : "post",
		async : false,
		url : "${contextPath}/mypage/updatecard.do",
		dataType : "text",
		data : {
			me_cardNo : new_card
		},
		success : function(data, textStatus) {	
			if(data!=new_card && new_card!='') {
				alert("카드가 등록되었습니다.");
				$("#before_card").val(new_card);
			} else {
				alert("사용할 수 없는 카드 입니다.");
			}
		},
		error : function(data, textStatus) {
			//alert("에러가 발생했습니다.");ㅣ
		},
		complete : function(data, textStatus) {
			//alert("작업을완료 했습니다");
		}
	}); //end ajax	 
}
</script>

        </div>
    </div>
</div>
    <div class="clear">
    
    </div>
</body>
</html>
