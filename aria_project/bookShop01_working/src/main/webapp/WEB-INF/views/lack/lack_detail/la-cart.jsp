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
         .Ok input[type="button"]{width:290px; height:40px; background: #66cc00; border: #66cc00; font-family: 'S-CoreDream-3Light'; color: #ffffff}
         .Ok button{width:290px; height:40px; background: #66cc00; border: #66cc00; font-family: 'S-CoreDream-3Light'; color: #ffffff}
         
         /* 총결제 */
         #totalval1{font-size: 1.6em;  display: inline-block; }
         #totalval2{font-size: 1.6em;  display: inline-block; margin-left: 340px;}
         
         /* 텅 */
         .empty {}
         .empty p{text-align: center; font-size: 1.5em; margin: 20px 0 20px 0;}
         .empty input[type="button"]{margin-left:25%; width:290px; height:40px; background: #66cc00; border: #66cc00; font-family: 'S-CoreDream-3Light'; color: #ffffff}
   
   </style> 
    
</head>
<body>
    <div class="orderlist">
       <h2>주문목록</h2>
       
       <%-- <form action="${contextPath}/main/main.do" method="post"  > lackorder로 가야함 --%>
       <form action="${contextPath}/lackorder/addOrder.do" method="post">
       <!-- 주문 목록 item  -->
       		<input type="hidden" value="${login_id}">
          <div class="laitemlist">
          
             <!-- 총 금액 계산 -->
             <c:set var="totalPrice" value="0" />
             <c:choose>
             <c:when test="${empty cartlist}">
             <div class="empty">
              <p>장바구니에 텅 비어있어요!</p>
              <input type="button" value="장바구니 담으러가기!" onClick="history.go(-1)">
             </div>
             </c:when>
             <c:otherwise>
               <c:forEach items="${cartlist}" var="list" varStatus="index">
               <c:set var="menuPrice" value="${list.lm_price * list.lc_qty}" />
               <c:set var="totalPrice" value="${totalPrice + menuPrice}" />
               
               <!-- 상품목록  -->
               
               <div class="itemarray">
                  <p id="img"><img width="121" height="154" src="${contextPath}/lackmenu/thumbnails.do?lm_id=${list.lm_id}&lm_fileName=${list.lm_fileName}"></p>
                  <p id="itme">${list.lm_menu} (총<fmt:formatNumber value="${menuPrice}" type="number" />) <br>
                  <fmt:formatNumber value="${list.lm_price}" type="number" />원<br><br>
                   <input id="countform" value="${list.lc_qty}" name="LaOrderVOList[${index.count-1 }].lo_qty">개</p> 
                   <input type="hidden" value="${login_id}" name="LaOrderVOList[${index.count-1 }].lo_me_id">
                   <input type="hidden" value="${lm_ls_storeName}" name="LaOrderVOList[${index.count-1 }].lo_ls_storeName">
                   <input type="hidden" value="${list.lm_id}" name="LaOrderVOList[${index.count-1 }].lo_lm_id"> 
                   <input type="hidden" value="${list.lm_price}" name="LaOrderVOList[${index.count-1 }].lo_lm_price">
                   <input type="hidden" value="${list.lm_menu}" name="LaOrderVOList[${index.count-1 }].lo_lm_menu">
                   <input type="hidden" id='note' value="${list.lo_note}" name="LaOrderVOList[${index.count-1 }].lo_note">
                   <input type="hidden" id='package' value="${list.lo_state}" name="LaOrderVOList[${index.count-1 }].lo_state">
                   <input type="hidden" id='date' value="${list.lo_date}" name="LaOrderVOList[${index.count-1 }].lo_date">
                   <input type="hidden" id='time' value="${list.lo_time}" name="LaOrderVOList[${index.count-1 }].lo_time">
                   <a href="${contextPath}/lackcart/removeCartGoods.do?lm_id=${list.lm_id}"> X </a>
                   <br>
               </div>
                </c:forEach>
                
                <!-- 총 금액 출력 -->
               
               <p id="totalval1">총 결제 금액</p>
               <p id="totalval2"><fmt:formatNumber value="${totalPrice}" type="number" />원</p>
             
                
                <!-- 포장 여부 -->
                
                <div class="package">
                   <h3>포장여부</h3>
                   <input type='radio' name="package" value="visit" onChange="document.getElementById('package').value=this.value"/>방문해서 먹고갈게요!
                   <input type='radio' name="package" value="package" onChange="document.getElementById('package').value=this.value"/>포장해서 들고갈게요!
                </div>
                
                <!-- 메모  -->
                
                <div class="request">
                  <h3>요청사항</h3>
                  <textarea id="memo" maxlength="60" name="" onChange="document.getElementById('note').value=this.value"></textarea>
              </div>
                
                <!-- 방문시간 -->
                
                <div class="gettime">
                     <h3>방문시간</h3>
                    <input id="" type="date" name="" required="required" onChange="document.getElementById('date').value=this.value" >
                    <input id="" type="time" name="" required="required" onChange="document.getElementById('time').value=this.value" >
               </div>
                
                <!-- 예약 submit -->
                
                <div class="Ok">
                  <input type="button" value="이전으로" onClick="history.go(-1)">
                  <button type="submit" ><fmt:formatNumber value="${totalPrice}" type="number" />원 결제하기</button>
               </div>
                </c:otherwise>
             </c:choose>
          </div>
          
       </form>
    </div>
    
</body>
</html>
