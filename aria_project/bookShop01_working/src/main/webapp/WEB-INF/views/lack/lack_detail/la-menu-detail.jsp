<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.storeitem{margin:auto;text-align:center;}
.storeitem span{font-size: 1.6em; font-weight: bold; color: black;}
.storeitem a{font-size: 1.4em;}
.storeitem .money{font-size: 1.6em; color: black; font-weight: bold;}   

/* 주문담기 버튼 CSS  */
.storeitem button {width:150px; height:30px; border:1px solid #66cc00; border-radius:5px; background-color: #66cc00; color:#ffffff; font-weight: bold; }
.storeitem button {background: rgb(6,14,131);background: linear-gradient(0deg, #66cc00 0%, #66dd00 100%);border: none;}
.storeitem button:hover {background: rgb(0,3,255);background: linear-gradient(0deg, #66aa00 0%, #66bb00 100%);}


/* 수량 css */
input[type="number"] {width: 100px; height: 30px; border: none; text-align: center; font-size: 20px;outline: none;}
.storeitem #plus-qty{background: #ffffff; color: #000000; font-size: 25px;}
.storeitem #plus-qty img{width:35px;height: auto;}
.storeitem #minus-qty{background: #ffffff; color:#000000; font-size:25px;}
.storeitem #minus-qty img{width:35px;height: auto;}
   
</style>
<meta charset="UTF-8">
</head>
<body>
   <div class="storeitem">
   <form style="display:inline-block;" action="${contextPath}/lackcart/addCart.do" method="post">
   <div>
   <img src="${contextPath}/lackmenu/thumbnails.do?lm_id=${goodsMap.goodsVO.lm_id}&lm_fileName=${goodsMap.goodsVO.lm_fileName}"><br>
   <input type="hidden" name="lm_id" value="${goodsMap.goodsVO.lm_id}"><br>
   <span>${goodsMap.goodsVO.lm_menu}</span><br>
   <a>${goodsMap.goodsVO.lm_menu_info }</a><br><br>
   <div class="money">
   <fmt:formatNumber value="${goodsMap.goodsVO.lm_price}" type="number" />원<br><br>
   </div>
    <!-- hidden input 태그를 사용하여 변경된 수량을 전송 -->
   <input type="hidden" id="lc_qty" name="lc_qty" value="1">

    <!-- 수량 변경 버튼 -->
    <button type="button" id="minus-qty"><img src="${contextPath }/resources/image/minus.jpg"></button>
    <input type="number" id="current-qty" name="current-quantity" value="1" readonly="readonly">
    <button type="button" id="plus-qty" ><img src="${contextPath }/resources/image/plus.jpg"></button>
   </div>

   
<script type="text/javascript">
const minusBtn = document.getElementById('minus-qty');
const plusBtn = document.getElementById('plus-qty');
const currentQtyInput = document.getElementById('current-qty');
const lc_qty = document.getElementById('lc_qty');

minusBtn.addEventListener('click', () => {
  let currentQty = parseInt(currentQtyInput.value);
  if (currentQty > 1) {
    currentQty--;
    currentQtyInput.value = currentQty;
    lc_qty.value = currentQty;
  }
});

plusBtn.addEventListener('click', () => {
  let currentQty = parseInt(currentQtyInput.value);
  currentQty++;
  currentQtyInput.value = currentQty;
  lc_qty.value = currentQty;
});
</script>
     <!-- form 전송 버튼 -->
     <br><button type="submit">장바구니 담기</button>
   </form>
   </div>
</body>
</html>