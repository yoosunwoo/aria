<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결식아동 사업소개</title>

<style>
#contents {
    position: relative;
    min-height: 600px;
    margin-top: 50px;
    margin-bottom: 50px;
}

.img_box2 {
    position: relative;
    background: url(../resources/image/img_box2_bg.gif) no-repeat right bottom;
    height: 224px;
    width: 100%;
    max-width: 915px;
    margin: 0 auto;
    display: inline-block;
}

.img_box2 {
    display: inline-block;
    padding: 0 3px 3px 0;
    background-color: #ebebeb;
}

#contents .img_box2 .img {
    position: absolute;
    left: 0;
    top: 0;
    width: calc(100% - 425px);
    height: 218px;
}

.img_box2 .img.cnt_1862 {
    background: url(../resources/image/cnt_1862_img.jpg) no-repeat center top;
}

.img_box2 .text {
    padding: 40px 20px 40px 0;
    width: 380px;
    float: right;
}

#contents .img_box2 .text h3.h0 {
    font-size: 22px;
    display: inline-block;
    padding: 0 40px 0 0;
    margin: 0 0 20px 0;
    color: #fff;
    background: url(../resources/image/color_box_title.png) no-repeat right center;
}

#contents .h0 {
    clear: left;
    margin: 0;
    padding: 0;
    background: transparent;
    color: #636363;
    font-size: 1em;
    font-weight: 600;
    letter-spacing: 0;
}

#contents h3, #contents .h3 {
    margin: 30px 0 15px;
    padding-left: 23px;
    font-size: 24px;
    color: #26348b;
    letter-spacing: -0.035em;
    line-height: 26px;
}

#contents h3, #contents .h3, #contents h4, #contents .h4, #contents h5, #contents .h5, #contents h6, .h6 {
    position: relative;
    clear: both;
    font-weight: 600;
    text-align: left;
}

#contents .img_box2 .text p {
    color: #fff;
    line-height: 1.4em;
}

@media (max-width: 640px)
#contents h4, #contents .h4 {
    margin: 12px 0 0 3px;
    padding: 0 0 0 25px;
    font-size: 20px;
}


#contents h4, #contents .h4 {
    margin: 20px 0 10px;
    padding-left: 23px;
    font-size: 22px;
    color: #0194DB;
    letter-spacing: -0.035em;
    line-height: 24px;
}


#contents h3, #contents .h3, #contents h4, #contents .h4, #contents h5, #contents .h5, #contents h6, .h6 {
    position: relative;
    clear: both;
    font-weight: 600;
    text-align: left;
}

.bu, .num {
    margin: 15px 0 15px 30px;
}

ul, ul>li {
    list-style: none;
}

@media (max-width: 640px)
.blt, .bu > li, .blt.type2, .bu > li > ul > li, .num li {
    font-size: 14px;
    line-height: 20px;
}

.blt, .bu > li {
    margin-bottom: 2px;
    padding-left: 13px;
    font-size: 16px;
    color: #555;
    line-height: 24px;
}

.blt, .bu li, .num li {
    position: relative;
    letter-spacing: -0.035em;
    text-align: left;
}

ul, ul>li {
    list-style: none;
}

#btn-Yes {
    box-sizing: border-box;
	background-color: #66cc00;
    border: none;
	
}

.btn:not(:disabled):not(.disabled) {
    cursor: pointer;
}

.btn-block {
    display: block;
    width: 50%;
	margin: auto;
	margin-bottom: 55px;
}

.btn-group-lg>.btn, .btn-lg {
    padding: 0.5rem 1rem;
    font-size: 1.25rem;
    line-height: 1.5;
    border-radius: 0.3rem;
}

.btn-primary {
    color: #fff;
}

#contents .btn {
    display: inline-block;
    position: relative;
    margin: 1px 0;
    padding: 0 25px;
    background-color: #4d5360;
    font-weight: 400;
    text-align: center;
    height: 32px;
    line-height: 32px;
}

#contents .btn, #container .btn:link, #container .btn:visited {
    color: #fff;
    font-size: 14px;
    text-decoration: none;
    vertical-align: top;
    cursor: pointer;
    margin: 0 0 2px 0;
}

#contents .btn.type3 {
    overflow: hidden;
    border: 1px solid transparent;
    padding: 0 56px 0 10px;
}

#contents .btn.line_color1 {
    border-color: #4d5360;
    color: #fff;
    background: #4d5360;
}

</style>

<script>


</script>

</head>
<body>


<div id="contents">
					
                        <div class="img_box2">
	<div class="img cnt_1862">
	</div>
	<div class="text">
		<h3 class="h0">결식아동급식지원</h3>
		<p>저소득 가정의 아동들이 건강하게 자랄 수 있도록 급식지원 등을 통해 결식예방 및 영양개선을 위한 지원사업을 시행하고 있습니다.
		</p>
	</div>
</div>

<h4>지원대상</h4>
<ul class="bu">
    <li> 다음 각 호의 사유에 해당하여 보호자의 식사제공이 어려워 결식우려가 있는 아동
       <ul>
          <li>「국민기초생활보장법」제2조제2호에 따른 수급자 가구의 아동, 차상위계층아동</li>
          <li>「한부모가족지원법」제5조에 따른 지원대상자가 양육하는 아동</li>
          <li>「긴급복지지원법」제5조에 따른 긴급복지 지원대상 가구의 아동</li>
          <li>보호자가 사망, 가출, 행방불명, 구금시설에 수용되는 등의 사유로 보호가 필요한 아동</li>
          <li>보호자의 사고, 급성질환, 만성질환 등의 사유로 보호자의 양육능력이 미약한 가구의 아동</li>
          <li>기준중위소득 52%이하인 가구의 아동</li>
          <li>위 각호에는 해당되지 않으나 담임교사, 사회복지사, 이·통·반장, 시·군·구 담당공무원들이 추천하는 자로서 아동급식위원회에서 급식지원이 필요하다고 결정한 아동</li>
        </ul>
    </li>
    </ul>

<h4>급식지원 방식</h4>
<ul class="bu">
    <li>결식이 우려되는 아동에게 1식 6,000원(최대한도 12,000원)까지 사용 할 수 있는 복지 카드를 지급하여 가맹점에서 1식을 해결<br>   ※ 결식우려의 정의 : 보호자가 충분한 주식과 부식을 준비하기 어렵거나, 주ㆍ부식을 준비할 수 있다 하더라도 아동 스스로   식사를 차려 먹기 어려운 경우(외국국적 아동인 경우에도 지원기준에 따라 결식우려가 있을 경우 급식지원) </li>
</ul>

<h4>신청방법</h4>
<ul class="bu">
    <li>동 행정복지센터 방문 신청</li>
    <li>복지로 온라인 신청(online.bokjiro.go.kr)  <a title="홈페이지 새창으로 열기" target="_blank" rel="noopener" class="btn type3 line_color1" href="http://online.bokjiro.go.kr">홈페이지 바로가기<i class="blank"></i></a></li>
</ul>

<h4>지원방법</h4>
<ul class="bu">
    <li>가맹점(일반음식점)에서 식사 제공</li>
    <li>아이누리 카드 홈페이지 <a title="홈페이지 새창으로 열기" target="_blank" rel="noopener" class="btn type3 line_color1" href="http://dj.nhdream.co.kr/#">홈페이지 바로가기<i class="blank"></i></a> 및 NH앱 캐시에서 급식카드 사용 가맹점 확인 가능 </li>
</ul>

<h4>행정복지센터 아동급식담당 연락처</h4>
<ul class="bu">
	<li>둔산동 042-631-3017</li>
	<li>대흥동 042-631-3042</li>
	<li>은행동 042-631-3058</li>
	<li>가오동 042-632-3074</li>
	<li>비래동 042-632-3105</li>
	<li>가양동 042-634-3147</li>
	<li>자양동 042-634-3159</li>
	<li>읍내동 042-634-3174</li>
</ul>

</div>
<form>
<button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit" formaction="${contextPath }/lack/la-store.do" formmethod="get">음식점 조회</button>
</form>
</body>
</html>