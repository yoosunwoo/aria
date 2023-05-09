<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  


<html>
<head>
</head>
<body>
<%-- 메인 로그인/슬라이더 --%>
 <div class="row">
      <div class="left">
        <div class="loginct" style="border:2px solid #008000; border-radius: 12px; margin:40 0 0 20">
           <ul style="text-align: center; ">
           <c:choose>
           <c:when test="${isLogOn==true and not empty memberInfo }">
           <br><br>
           
              <li style="font-size: 1.8em;"> ${memberInfo.me_name} 님 
              
              <button type="button" style="margin-left:5%; width:20%; height: 8%; border-radius: 12px; " onclick="location.href='${contextPath}/member/logout.do'">로그아웃</button></li>
               <br><br><br><br>
               <c:choose>
               <c:when test='${not empty memberInfo.me_cardNo}'>
               <li>국민행복카드 : ${memberInfo.me_cardNo} </li>
               </c:when>
               <c:otherwise>
               <li>국민행복카드 : ${memberInfo.me_cardNo} 등록된 카드가 없습니다. </li>
               </c:otherwise>
               </c:choose>
              <li>서비스 신청: 3건</li>
              <li>예치금 잔액 : ${memberInfo.me_balance}원</li>
              <br>
              <li><button type="button" style="margin-left:5%; width:20%; height: 8%; border-radius: 12px; " onclick="location.href='${contextPath}/mypage/modmember.do'">정보수정</button></li>
              <br>
         </c:when>
         		<c:when test="${isLogOn==true and not empty businessInfo }">
           <br><br>
           
              <li style="font-size: 1.8em;"> ${businessInfo.bu_name} 님 
              
              <button type="button" style="margin-left:5%; width:20%; height: 8%; border-radius: 12px; " onclick="location.href='${contextPath}/business/logout.do'">로그아웃</button></li>
               <br><br><br><br>
               <c:choose>
               <c:when test='${not empty businessInfo.bu_bn}'>
               <li>사업자 번호 : ${businessInfo.bu_bn} </li>
               </c:when>
               <c:otherwise>
               <li>사업자 번호 : ${businessInfo.bu_bn} 등록된 사업자번호가 없습니다. </li>
               </c:otherwise>
               </c:choose>
              <li>문의 내역: 3건</li>
              <li>서비스 신청: 3건</li>
              <br>
              <li><button type="button" style="margin-left:5%; width:20%; height: 8%; border-radius: 12px; " onclick="location.href='${contextPath}/mypage/modmember.do'">정보수정</button></li>
              <br>
         </c:when>
			 <c:otherwise>
			 	<br>
        		<li><img width="120" height="120" src="${contextPath}/resources/image/loginkey.png"></li>
        		<br>
        		<li>필요한 정보를 확인하기 위해 로그인하세요</li><br>
        		<li><button type="button" onclick="location.href='${contextPath}/member/login.do'" style="width: 80%; height: 15%;">로그인</button>
        	</ul>
        	<ul class="rc" style="text-align: center;">
       			<br>
        		<li><a href="${contextPath}/member/findid.do">아이디찾기</a></li>
        		<li><a href="${contextPath}/member/pw_find.do">비밀번호찾기</a></li>
        		<li><a href="${contextPath}/member/memberFormSelect.do">회원가입</a></li>
      		</ul>
      		</c:otherwise>
			 </c:choose>
        </div>
			 
      </div>
      <div class="right">
        <div class="slider2">
    <div class="slide"><img src="${contextPath}/resources/image/main_s_01.jpg""></div>
    <div class="slide"><img src="${contextPath}/resources/image/main_s_02.jpg"></div>
    <div class="slide"><img src="${contextPath}/resources/image/main_s_03.jpg"></div>
    <div class="slide"><img src="${contextPath}/resources/image/main_s_04.jpg"></div>
    <div class="slide"><img src="${contextPath}/resources/image/main_s_05.jpg"></div>
  </div>
        <%-- <div id="slider2">
 <ul class="bjqs">	 	
	  <li><img src="${contextPath}/resources/image/main_s_01.jpg"></li> 
	  <li><img src="${contextPath}/resources/image/main_s_02.jpg"></li> 
	  <li><img src="${contextPath}/resources/image/main_s_03.jpg"></li> 
	  <li><img src="${contextPath}/resources/image/main_s_04.jpg"></li> 
	  <li><img src="${contextPath}/resources/image/main_s_05.jpg"></li> 
	</ul>
		</div> --%>
      </div>
    </div>
    
   <hr class="hr-1">   
    
<div class="hover13 column">
  <div>
    <figure><img src="${contextPath}/resources/image/quick1.png" /></figure>
  </div>
  <div>
    <figure><img src="${contextPath}/resources/image/quick2.png" /></figure>
  </div>
  <div>
    <figure><img src="${contextPath}/resources/image/quick3.png" /></figure>
  </div>
  <div>
    <figure><img src="${contextPath}/resources/image/quick4.png" /></figure>
  </div>
  <div>
    <figure><img src="${contextPath}/resources/image/quick5.png" /></figure>
  </div>
</div>
	
	<hr class="hr-1">  
	
	<div class="mid">
		<div class="popup">
		<div class="slider1">
      <div class="slide"><img src="${contextPath}/resources/image/popupzone1.gif"></div>
      <div class="slide"><img src="${contextPath}/resources/image/popupzone2.gif"></div>
    		</div> 
    		</div>
	<div class="noticetab">
		<div class="tabset">
  <!-- Tab 1 -->
  <input type="radio" name="tabset" id="tab1" aria-controls="marzen" checked>
  <label for="tab1">공지사항</label>
  <!-- Tab 2 -->
  <input type="radio" name="tabset" id="tab2" aria-controls="rauchbier">
  <label for="tab2">Q&A</label>
  <!-- Tab 3 -->
  <input type="radio" name="tabset" id="tab3" aria-controls="dunkles">
  <label for="tab3">FAQ</label>
  
  <div class="tab-panels">
    <section id="marzen" class="tab-panel">
      <h2><a href="#">[품질평가] 2024년도 사회서비스 품질평가 편람(발달재활서비스‧언어발달)</a> </h2>
      <h2><a href="#">[품질평가] 2023년도 사회서비스 품질평가 편람(지역사회서비스투자사업 전 유형)</a></h2>
  </section>
    <section id="rauchbier" class="tab-panel">
      <h2>Q&A</h2>
    </section>
    <section id="dunkles" class="tab-panel">
      <h2>FAQ</h2>
    </section>
  </div>
		</div>
</div>
</div> <!--  mid 끝 -->




<div class="review">
  <div class="reviewcolumn">
	<ul>결식베스트</ul>
	<li><img src="${contextPath}/resources/image/la-1.jpg"></li>
	<li><span>ㅅ지역아동센터 아동</span><br>저는 식사 시간이 제일 좋아요. 집에서 혼자 먹는 것보다 맛있는 음식을 먹을 수 있어요. 과일도 자주 먹을 수 있고요! 센터에 새로운 친구가 있는데 어떤 반찬이 맛잇는지 알려주기도하고, 저는 이미 먹어본 음식이라 자랑하기도 했어요!!</li>
  </div>
  <div class="reviewcolumn"><ul>결식베스트</ul>
	<li><img src="${contextPath}/resources/image/la-1.jpg"></li>
	<li><span>ㅅ지역아동센터 아동</span><br>저는 식사 시간이 제일 좋아요. 집에서 혼자 먹는 것보다 맛있는 음식을 먹을 수 있어요. 과일도 자주 먹을 수 있고요! 센터에 새로운 친구가 있는데 어떤 반찬이 맛잇는지 알려주기도하고, 저는 이미 먹어본 음식이라 자랑하기도 했어요!!</li></div>
  <div class="reviewcolumn"><ul>결식베스트</ul>
	<li><img src="${contextPath}/resources/image/la-1.jpg"></li>
	<li><span>ㅅ지역아동센터 아동</span><br>저는 식사 시간이 제일 좋아요. 집에서 혼자 먹는 것보다 맛있는 음식을 먹을 수 있어요. 과일도 자주 먹을 수 있고요! 센터에 새로운 친구가 있는데 어떤 반찬이 맛잇는지 알려주기도하고, 저는 이미 먹어본 음식이라 자랑하기도 했어요!!</li></div>
</div>
</div>

</body>
</html>