<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!-- 모바일에서 화면배율을 디바이스 크기 기준으로 설정 -->
<!-- 이게 안되면 pc에서의 100px과 모바일에서의 100px이 디바이스 성능에 따라 달라집니다. -->
<meta name="viewport" content="width=device-width, initial-scale=1">


<script type="text/javascript">
	var loopSearch=true;
	function keywordSearch(){
		if(loopSearch==false)
			return;
	 var value=document.frmSearch.searchWord.value;
		$.ajax({
			type : "get",
			async : true, //false인 경우 동기식으로 처리한다.
			url : "${contextPath}/goods/keywordSearch.do",
			data : {keyword:value},
			success : function(data, textStatus) {
			    var jsonInfo = JSON.parse(data);
				displayResult(jsonInfo);
			},
			/* error : function(data, textStatus) {
				alert("에러가 발생했습니다."+data); */
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
				
			}
		}); //end ajax	
	}
	
	function displayResult(jsonInfo){
		var count = jsonInfo.keyword.length;
		if(count > 0) {
		    var html = '';
		    for(var i in jsonInfo.keyword){
			   html += "<a href=\"javascript:select('"+jsonInfo.keyword[i]+"')\">"+jsonInfo.keyword[i]+"</a><br/>";
		    }
		    var listView = document.getElementById("suggestList");
		    listView.innerHTML = html;
		    show('suggest');
		}else{
		    hide('suggest');
		} 
	}
	
	function select(selectedKeyword) {
		 document.frmSearch.searchWord.value=selectedKeyword;
		 loopSearch = false;
		 hide('suggest');
	}
		
	function show(elementId) {
		 var element = document.getElementById(elementId);
		 if(element) {
		  element.style.display = 'block';
		 }
		}
	
	function hide(elementId){
	   var element = document.getElementById(elementId);
	   if(element){
		  element.style.display = 'none';
	   }
	}
	//drop
	function NotScrollTop0__init() {
	    let scrollTop = $(window).scrollTop();
	    
	    if ( scrollTop > 0 ) {
	        $('html').addClass('not-scroll-top-0');
	    }
	    else {
	        $('html').removeClass('not-scroll-top-0');
	    }
	}

	$(window).scroll(NotScrollTop0__init);
	NotScrollTop0__init();

</script>
<body>
	<div id="logo">
	<a href="${contextPath}/main/main.do">
		<img width="210" height="95" alt="Aria" src="${contextPath}/resources/image/Logotop1.png">
		</a>
	</div>
	<div id="head_link">
		<ul>
		   <c:choose>
		   	<c:when test="${isLogOn==true and not empty memberInfo and memberInfo.me_id =='admin'}">
			   <li><a href="${contextPath}/member/logout.do">로그아웃</a></li>
			   <li><a href="${contextPath}/mypage/myPageMain.do">관리자페이지</a></li>
			   <li><a href="${contextPath}/test/testPage.do">테스트페이지</a></li>
			 </c:when>
		     <c:when test="${isLogOn==true and not empty memberInfo }">
			   <li><a href="${contextPath}/member/logout.do">로그아웃</a></li>
			   <li><a href="${contextPath}/mypage/myPageMain.do">마이페이지</a></li>
			 </c:when>
			 <c:when test="${isLogOn==true and not empty businessInfo }"> 
			 	<li><a href="${contextPath}/business/logout.do">로그아웃</a></li>
			   <li><a href="${contextPath}/bupage/bupageMain.do">사업자페이지</a></li>
			 </c:when>
			 
			 <c:otherwise>
			   <li><a href="${contextPath}/member/login.do">로그인</a></li>
			   <li><a href="${contextPath}/member/memberFormSelect.do">회원가입</a></li> 
			 </c:otherwise>
			</c:choose>
			   <li><a href="${contextPath}/main/main.do">메인으로</a></li>
			  
		</ul>
	</div>
	<br>
	
	<!-- 헤더 매뉴 -->
    <div id="menu">
	<ul>
		<li><a href="${contextPath}/lack/la-main.do">결식아동</a>
			<ul>
				<li><a href="${contextPath}/lack/la-main.do">사업소개</a></li>
				<li><a href="${contextPath }/lack/la-store.do">음식점조회</a></li>
			</ul>
		</li>
		<li><a href="${contextPath}/care/ca-main.do">아이돌봄</a>
			<ul>
				<li><a href="#">사업소개</a></li>
				<li><a href="#">돌보미 조회</a></li>
			</ul>
		</li>
		<li><a href="#">보건위생</a>
			<ul>
				<li><a href="#">사업소개</a></li>
				<li><a href="#">오프라인매장조회</a></li>
				<li><a href="#">온라인몰</a></li>
			</ul>
		</li>
		<li><a href="#">회원센터</a>
			<ul>
				<li><a href="${contextPath}/helpcenter/inquiry.do">공지사항</a></li>
				<li><a href="#">QnA</a></li>
				<li><a href="#">신고게시판</a></li>
			</ul>
		</li>
	</ul>
                


	
	
	<%-- <div id="search" >
		<form name="frmSearch" action="${contextPath}/goods/searchGoods2.do" >
			<input name="searchWord" class="main_input" type="text"  onKeyUp="keywordSearch()"> 
			<input type="submit" name="search" class="btn1"  value="검 색" >
		</form>
	</div>
   <div id="suggest">
        <div id="suggestList"></div>
   </div> --%>
   
   
</body>
</html>