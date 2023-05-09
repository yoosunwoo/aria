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
</style>
<body>
<div id="wrap" class="">
    <div id="contWrap">
        <div id="left_menu">
    <span class="btnMenu_mClose"><img src="/theme/6/img/main/btnMenu_mClose.png" alt="닫기"></span>
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
	<dl>
		<a href="../mypage/course_list1.jsp">
			<dd>
				<img alt="" src="${contextPath}/resources/image/mypageimage2.png">
				<span><h3><b class="pointColor">2</b>건</h3></span>
				<p>진행중인 예약내역</p>
			</dd>
		</a>
	</dl>
	
	<dl>
		<a href="../mypage/course_list1.jsp?s_end=1">
			<dd>
				<img alt="" src="${contextPath}/resources/image/mypageimage3.png">
				<h3><b class="pointColor">5</b>건</h3>
				<p>	구매내역</p>
			</dd>
		</a>
	</dl>
	
	<dl>
		<a href="../mypage/certificate_list.jsp?s_complete=1&amp;ord=id+desc">
			<dd>
				<img alt="" src="${contextPath}/resources/image/mypageimage1.png">
				<h3><b class="pointColor">3</b>건</h3>
				<p>리뷰 작성 내역</p>
			</dd>
		</a>
	</dl>
</div>

<div class="main_bbs">
	<div class="whiteBox notice" style="height: 275px;">
		<h4 class="adm_tit">공지사항</h4>
		<ul>
			
			
			<li class="nodata">
				공지사항이 없습니다.
			</li>
			
		</ul>
	</div>

	<div class="whiteBox qna" style="height: 275px;">
		<h4 class="adm_tit">Q&amp;A</h4>
		<ul>
			

			
			<li class="nodata">
				상담내역이 없습니다.
			</li>
			
		</ul>
	</div>
</div>




<script>
function goStudy(url1, url2) {
	
	window.open(url1, '_V01');
	window.location = url2;
	
	
}

function setLabel() {
	let labels = document.getElementsByClassName('state');
	for(let i = 0; i < labels.length; i++) {
		let el = labels[i]
		if("완료" === ($(el).text())) $(el).addClass("bgColor");
		else if("대기" === ($(el).text())) $(el).addClass("wait");
	}
}

function goRenew(cid) {
	addCommonCart("c_renew", cid, "1");
	goCommonCart("D");
}

function hide_price() {
	$("#price_pop").addClass("hidden");
}

$(document).ready(function() {
	setLabel();
})

</script>

        </div>
    </div>
    <iframe src="" name="sysfrm" id="sysfrm" width="100%" height="0" scrolling="no" frameborder="0"></iframe>
</div>
    <div class="clear">
    
    </div>
</body>
</html>
