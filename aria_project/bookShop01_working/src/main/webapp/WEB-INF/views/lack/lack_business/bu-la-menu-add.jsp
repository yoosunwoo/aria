<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
         var reader = new FileReader();
         reader.onload = function (e) {
           $('#preview').attr('src', e.target.result);
        }
       reader.readAsDataURL(input.files[0]);
    }
}  
</script>
<style>

*{
    box-sizing: border-box; /*전체에 박스사이징*/
    outline: none; /*focus 했을때 테두리 나오게 */
}

body{
    font-size:14px;
    line-height: 1.5em;
    color : #222;
    margin: 0;
}

a{
    text-decoration: none;
    color: #222;
}

/*member sign in*/
.member{
    width: 400px;
    /* border: 1px solid #000; */
    margin: auto; /*중앙 정렬*/
    padding: 0 20px;
    margin-bottom: 20px;
}

.member .logo{
    /*로고는 이미지라 인라인 블록이니까 마진 오토 안됨 블록요소만 됨 */
    display: block;
    margin :50px auto;
}

.member .field{
    margin :5px 0; /*상하로 좀 띄워주기*/
}

.member b{
    /* border: 1px solid #000; */
    display: block; /*수직 정렬하기 */
    margin-bottom: 5px;
}

/*input 중 radio 는 width 가 100%면 안되니까 */
.mem input:not(input[type=radio]), .mem select{
    border: 1px solid #dadada;
    padding: 15px;
    width: 100%;
    margin-bottom: 5px;
}

.member input[type=button],
.member input[type=submit]{
background-color: #66cc00;
color:#fff
}

.member input:focus, .member select:focus{
    border: 1px solid #2db400;
}

.field.birth div{ /*field 이면서 birth*/
    display: flex;
    gap:10px; /*간격 벌려줄때 공식처럼 사용핟나 */
}

/* .field.birth div > * {  gap 사용한거랑 같은 효과를 줌 
    flex:1;
} */

.field.tel-number div {
    display: flex;
}

.field.tel-number div input:nth-child(1){
    flex:2;
}

.field.tel-number div input:nth-child(2){
    flex:1;
}

.field.gender div{
    border: 1px solid #dadada;
    padding: 15px 5px;
    background-color: #fff;
}

.placehold-text{
    display: block; /*span 으로 감싸서 크기영역을 블록요소로 만들어ㅜ저야한다*/
    position:relative;
    /* border: 1px solid #000; */
}

.placehold-text:before{ 
    content : "@naver.com";
    position:absolute; /*before은 inline 요소이기 때문에 span으로 감싸줌 */
    right : 20px;
    top:13px;
    pointer-events: none; /*자체가 가지고 있는 pointer event 를 없애준다 */
}

.userpw{
    background:url(./images/images2/icon-01.png) no-repeat center right 15px;
    background-size: 20px;
    background-color: #fff;
}

.userpw-confirm{
    background:url(./images/images2/icon-02.png) no-repeat center right 15px;
    background-size: 20px;
    background-color: #fff;
}



@media (max-width:768px) {
    .member{
        width: 100%;
    }
}

#hd {text-align: center; font-size: 20px;}


    </style>
</head>
<body>
<form action="${contextPath}/lackmenu/addMenu.do" method="post" enctype="multipart/form-data" >
    <div class="member">
    
       <div class="mem">
        
        <h1 id="hd">상품등록</h1>
		<!-- 사업자구분 -->
		<input type="hidden" name="lm_ls_storeName" value="${storename}">
        <!-- 1. 상품명 -->
      <div class="field tel-number">
            <b>상품명</b>
            <div>
            <input type="text"  name="lm_menu" id="_member_id"  />
          </div>   
          </div>
       <!-- 2. 상품가격 -->
        <div class="field">
            <b>가격(개당)</b>
            <input type="text" name="lm_price" id="member_pw" />
        </div>
       
        <!-- 3. 상품설명 -->
          <div class="field">
         <b>상품설명</b>
          <textarea style="width: 360px; height: 150px; resize: none; border: 1px solid #dadada;" maxlength="200"  id="nam" name="lm_menu_info"></textarea>
      </div>
        
        <div class="field">
           <b>이미지파일 첨부</b>
           <input type="file" name="lm_fileName"  onchange="readURL(this);" />
           <img  id="preview" src="#"   width=200 height=200/>
         </div>
        
        <input type="submit" value="등록">
          </div>
    </div>
    </form>
</body>
</html>