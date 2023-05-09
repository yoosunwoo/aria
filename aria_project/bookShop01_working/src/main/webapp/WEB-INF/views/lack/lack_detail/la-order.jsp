<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <style>
        
        /* Order 전체  */
         .orderlist{margin: 0 auto; width: 600px;}
         .orderlist h2{font-size: 1.4em; padding-bottom:10px; width: 100%; text-align: center; border-bottom: 1px solid #666666;}
         .orderlist h3{font-size: 1.4em; padding-bottom:10px; width: 100%; text-align: left; color:#008000;}
         /* 상품  */
         .laitemlist { box-sizing: border-box; width: 100%;}
         .laitemlist #img{width: 45%;display: inline-block; text-align: center; }
         .laitemlist img{padding-bottom: 30px;}
         .laitemlist #itme{font-size: 1.2em; width: 35%;display: inline-block;}
         .laitemlist #close{font-size: 1.2em; width: 10%;display: inline-block;text-align: right;}
         #countform {width: 15px; height: 30px; border: none; text-align: center; font-size: 20px; outline: none; }
         .itemarray{border-bottom: 1px dashed #666666; margin:10px 0 10px 0;}
         /* 주문 상태 */
         #memo{resize:none; width: 100%; font-size:20px;}
         .package {}
         .package label{font-size:1.4em; display:block;}
         input[type="radio"]{width:20px;height:20px;}
         input[type="radio"]:checked {accent-color: #008000;}
         input[type="date"] {width: 290px; height: 30px; font-size: 15px;text-align: center; }
         input[type="time"] {width: 290px; height: 30px; font-size: 15px; text-align: center;}
         .request{}
         .gettime{}
         .Ok{margin-top:20px;}
         /* 총결제 */
         #totalval1{font-size: 1.6em;  display: inline-block; }
         #totalval2{font-size: 1.6em;  display: inline-block; margin-left: 340px;}
         
         input[type="submit"]{width:290px; height:40px; background: #66cc00; border: #66cc00; font-family: 'S-CoreDream-3Light'; color: #ffffff}
         

   </style>
 
    
</head>
<body>
		
	
    <%-- <div class="orderlist">
       <h2>주문목록</h2>
       
       <form action="${contextPath}/main/main.do" method="post"  > lackorder로 가야함
       <form action="${contextPath}/lackorder/addOrder.do" method="post">
       <!-- 주문 목록 item  -->
       		<input type="hidden" value="${login_id}">
          <div class="laitemlist">
          
             <!-- 총 금액 계산 -->
             
             <c:set var="totalPrice" value="0" />
               <c:forEach items="${cartlist}" var="list">
               <c:set var="menuPrice" value="${list.lm_price * list.lc_qty}" />
               <c:set var="totalPrice" value="${totalPrice + menuPrice}" />
               
               <!-- 상품목록  -->
               
               <div class="itemarray">
                  <p id="img"><img width="121" height="154" src="${contextPath}/lackmenu/thumbnails.do?lm_id=${list.lm_id}&lm_fileName=${list.lm_fileName}"></p>
                  <p id="itme">${list.lm_menu} (총<fmt:formatNumber value="${menuPrice}" type="number" />) <br>
                  <fmt:formatNumber value="${list.lm_price}" type="number" />원<br><br>
                   <input id="countform" value="${list.lc_qty}">개</p> 
                   <a href="${contextPath}/lackcart/removeCartGoods.do?lm_id=${list.lm_id}">x </a>
                   <br>
               </div>
                </c:forEach>
                
                <!-- 총 금액 출력 -->
               
               <p id="totalval1">총 결제 금액</p>
                <p id="totalval2"><fmt:formatNumber value="${totalPrice}" type="number" />원</p>
                
                <!-- 포장 여부 -->
                
                <div class="package">
                   <h3>포장여부</h3>
                   <label><input type="radio" name="package" checked>방문해서 먹고갈게요!</label>
                   <label><input type="radio" name="package" >포장해서 들고갈게요!</label>
                </div>
                
                <!-- 메모  -->
                
                <div class="request">
                  <h3>요청사항</h3>
                  <textarea id="memo" maxlength="60" name=""></textarea>
              </div>
                
                <!-- 방문시간 -->
                
                <div class="gettime">
                     <h3>방문시간</h3>
                    <input id="" type="date" name="">
                     <input id="" type="time" name="">
               </div>
                
                <!-- 예약 submit -->
                
                <div class="Ok">
                  <input type="submit" onclick="${contextPath}/main/main.do" value="돌아가기">
                  <input type="submit" value="<fmt:formatNumber value="${totalPrice}" type="number" />원 결제하기">
               </div>
                
          </div>
       </form>
    </div> --%>
    
</body>
</html>
