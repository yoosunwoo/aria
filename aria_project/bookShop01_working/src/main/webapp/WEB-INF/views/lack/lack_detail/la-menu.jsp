<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>
/*.top{border-bottom: }*/
.topnav{display:inline; width: 100%;  }
.topnav p{font-size:1.3em;}
.topnav img{width:45px; height: 40px;}
.topnav ul{border-bottom: 1px solid #666666; }
.topnav ul li{display: inline-block; }

.menuboard {display: grid;grid-template-columns: repeat(4, 1fr);grid-gap: 10px;   }
.menuboard img{display: block;width: 100%;height: auto;   }
.menuboard a{font-size: 1.2em; text-align: center;}
.menuboard a:hover img, .gallery a:focus img{ /* a태그에 마우스를 올렸을 때 */transform: scale(1.2);}
.menuboard button {width:100px; height:30px; border:1px solid #66cc00; border-radius:5px; background-color: #66cc00; color:#ffffff}
.menuboard button {background: rgb(6,14,131);background: linear-gradient(0deg, #66cc00 0%, #66dd00 100%);border: none;}
.menuboard button:hover {background: rgb(0,3,255);background: linear-gradient(0deg, #66aa00 0%, #66bb00 100%);}

</style>
<meta charset="UTF-8">
</head>
<body>
   <div class="topnav">
   <ul>
   <li><p>주문/예약</p></li>
   <li style="margin-left: 950px;">
   <c:choose>
   	<c:when test="${isLogOn==true and not empty memberInfo }">
    <a href="${contextPath}/lackcart/la-cart.do"><img src="${contextPath }/resources/image/cart.png"></a>
   	</c:when>
	<c:otherwise>
	<a href="${contextPath }/lackmenu/addMenu.do">+등록</a>
	</c:otherwise>   	
   </c:choose>
   </li>
   </ul>
   </div>
   <div class="clear"></div>
   <div class="menuboard">
      <c:forEach items="${goodsMap.lm_ls_storeName}" var="list">
      <a href="${contextPath}/lackmenu/la-menu-detail.do?lm_id=${list.lm_id}">
      <img width="121" height="154" src="${contextPath}/lackmenu/thumbnails.do?lm_id=${list.lm_id}&lm_fileName=${list.lm_fileName}">
      ${list.lm_menu}<br>
      <fmt:formatNumber value="${list.lm_price}" type="number" />원<br>
      <button onclick="window.location.href='${contextPath}/lackmenu/la-menu-detail.do?lm_id=${list.lm_id}';">선택</button></a>
</c:forEach>
</div>
</body>
</html>