<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사업자회원 기본정보</title>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    
    <script>
    
    function execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 도로명 조합형 주소 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}
						// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
						if (fullRoadAddr !== '') {
							fullRoadAddr += extraRoadAddr;
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('roadAddress').value = fullRoadAddr;
						/* document.getElementById('jibunAddress').value = data.jibunAddress; */
						
						document.querySelector("input[name=bu_address2]").focus();  
						// document.getElementById('detailAdddress').focus(); 
				
					}
				}).open();
	}
	var Checked = 0;

	function fn_overlapped() {
		var _id = $("#_business_id").val();
		if (_id == '') {
			alert("아이디를 입력하세요.");
			return;
		}
		$.ajax({
			type : "post",
			async : false,
			url : "${contextPath}/business/overlapped.do",
			dataType : "text",
			data : {
				bu_id : _id
			},
			success : function(data, textStatus) {
				if(data!=_id) {
					alert("사용할 수 있는 아이디입니다.");
					/*	$('#btnOverlapped').prop("disabled", false);
					$('#_member_id').prop("disabled", false); */
					$('#business_id').val(_id);
					 Checked=1;
				} else {
					alert("사용할 수 없는 아이디입니다.");
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

<script>
var Checked = 0;

function fn_overlapped2() {
	var _em = $("#_bu_email1").val();
	if (_em == '') {
		alert("이메일을 입력하세요.");
		return;
	}
	$.ajax({
		type : "post",
		async : false,
		url : "${contextPath}/business/overlapped2.do",
		dataType : "text",
		data : {
			bu_email1 : _em
		},
		success : function(data, textStatus) {
			if(data!=_em) {
				alert("사용할 수 있는 이메일 입니다.");
			/*	$('#btnOverlapped2').prop("disabled", false);
				$('#_me_email').prop("disabled", false); */
				$('#bu_email1').val(_em);
				 Checked=1;
			} else {
				alert("사용할 수 없는 이메일 입니다.");
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

<script>
	function rt() {

var id = document.getElementById('business_id').value;
var pw = document.getElementById('business_pw').value;
var hp = document.getElementById('hp').value;
var nam = document.getElementById('nam').value;
var ema = document.getElementById('_bu_email1').value;
var tl = document.getElementById('tl').value;
var road = document.getElementById('roadAddress').value;
var ser = document.getElementById('ser').value;
		
		if(id == ""){
		    alert("아이디 중복 확인해 주세요.")
		    return false;
		  }
		
		else if(pw == ""){
		    alert("비밀번호를 입력해 주세요.")
		    return false;
		  }
		
		
		else if(hp == ""){
		    alert("주민번호를 입력해 주세요.")
		    return false;
		  }
		
		
		else if(nam == ""){
		    alert("이름을 입력해 주세요.")
		    return false;
		  }
		
				
		
		else if(ema == ""){
		    alert("이메일을 입력해 주세요.")
		    return false;
		  }
		
		
		else if(tl == ""){
		    alert("휴대폰 번호를 입력해 주세요.")
		    return false;
		  }
		
		
		else if(road == ""){
		    alert("주소를 입력해 주세요.")
		    return false;
		  }
		
		
		else if(ser == false){
		    alert("서비스를 선택해 주세요.")
		    return false;
		  }
	
	}
	
</script>

<script>
	function test() {
		var p1 = document.getElementById('business_pw').value;
		var p2 = document.getElementById('business_pw1').value;

		if (p1.length < 8 ) {
			alert('문자, 숫자를 조합하여 8자 이상을 사용하세요.');
			return false;
		}

		if (p1 != p2) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		} else {
			alert("비밀번호가 일치합니다.");
			return true;
		}
	}
</script>


    <style>
    /* Google web font CDN*/

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

#hp {width: 45%; }

#mb {width: auto; }

#el {width: 45%; }

#tl {width: 30%; }   

#_bu_email1  {width: 30%; }

#bu_email2 {width: 30%; }

#bu_email3 {width: 30%; }

#btnOverlapped {width: 35%; }

    </style>
    
</head>
<body>
    
        <form action="${contextPath}/bupage/updateMember.do" method="post" onsubmit="return rt()">
    <div class="member">
    
    <div class="mem">
    
        <h1 id="hd">사업자 정보 수정</h1>

        <!-- 1. 아이디 -->
       <div class="field tel-number">
            <b>아이디</b>
            <div>
            <input type="text"  name="bu_id" id="_business_id" value="${businessInfo.bu_id}" readonly="readonly"   />
 			</div>   
 			</div>
        <div class="field">
            <b>비밀번호</b>
            <input name="bu_pw" id="business_pw" type="text" value="${businessInfo.bu_pw}" />
        </div>
        <div class="field tel-number">
            <b>비밀번호 확인</b>
            <div>
             <input id="business_pw1" type="text" value="${businessInfo.bu_pw}"/> <input type="button" onclick="test()" value="확인" />       
        </div>
        </div>
        
         <div class="field">
						<b>주민번호</b>
						<input id="hp" type="text" name="bu_ssn1" value="${businessInfo.bu_ssn1}"> - <input id="hp" type="text" name="bu_ssn2" value="${businessInfo.bu_ssn2}">
		</div>
        

        

<div class="field">
            <b>이메일</b>
            
				<input id="_bu_email1" type="text"  name="_bu_email1" value="${businessInfo.bu_email1}"> @  
                <input id="bu_email2" type="text"  name="bu_email2" value="${businessInfo.bu_email2}">
                <select id="bu_email3" name="bu_email3" onChange="document.getElementById('bu_email2').value=this.value" title="직접입력">
                           <option value="non">직접입력</option>
                           <option value="hanmail.net">hanmail.net</option>
                           <option value="naver.com">naver.com</option>
                           <option value="yahoo.co.kr">yahoo.co.kr</option>
                           <option value="hotmail.com">hotmail.com</option>
                           <option value="paran.com">paran.com</option>
                           <option value="nate.com">nate.com</option>
                           <option value="google.com">google.com</option>
                           <option value="gmail.com">gmail.com</option>
                           <option value="empal.com">empal.com</option>
                           <option value="korea.com">korea.com</option>
                           <option value="freechal.com">freechal.com</option>
                     </select>
             <input type="hidden" name="bu_email1" id="bu_email1" value="${businessInfo.bu_email1}"/>
 			<input type="button" id="btnOverlapped2" value="이메일 중복확인" onClick="fn_overlapped2()" />  
						
 			
 			</div> 
 		</div>
 			<label><input type="checkbox" name="bu_email_yes" value="Y" checked="checked" /> 아리아에서 발송하는 e-mail을 수신합니다.</label>
        
        <div class="mem">
        <!-- 5. 전화번호 -->
        <div class="field">
            <b>휴대폰 번호</b>
						<select id="tl" name="bu_phone1">
								
								<option selected value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="018">018</option>
								<option value="019">019</option>
						</select> - <input
							id="tl" type="tel" name="bu_phone2" value="${businessInfo.bu_phone2}"> - 
							<input
							id="tl" type="tel" name="bu_phone3" value="${businessInfo.bu_phone3}">
        </div>
      </div>
      		<label><input type="checkbox" name="bu_sms_yes" value="Y" checked="checked"/> 아리아에서 발송하는 SMS 소식을 수신합니다.</label>
        <div class="mem">
        <div class="field tel-number">
            <b>주소</b>
            <div>
            <input type="text" id="zipcode" name="bu_zipcode" value="${businessInfo.bu_zipcode}" >
            <input type="button" onclick="javascript:execDaumPostcode()" value="우편번호 검색">
 			</div> 
            
                <input type="text" id="roadAddress" name="bu_address1" placeholder="도로명 주소" value="${businessInfo.bu_address1}"> 
           <!--  <input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번 주소"> -->
              <input type="text" name="bu_address2" placeholder="상세 주소" value="${businessInfo.bu_address2}">
            
        </div>
         <div class="field">
            <b>상호명</b>
            <input type="text" name="bu_name" value="${businessInfo.bu_name}">
        </div>
        
         <div class="field">
            <b>사업자 번호</b>
            <input type="text" name="bu_bn" value="${businessInfo.bu_bn}">
        </div>
        
        </div>
        <div style="margin-bottom:15px;">
            <b>서비스 선택</b>
            <div id="ser">
            	<input type="hidden" id="h_me_lack_yes" value="${businessInfo.bu_lack_yes }">
            	<input type="hidden" id="h_me_care_yes" value="${businessInfo.bu_care_yes }">
            	<input type="hidden" id="h_me_female_yes" value="${businessInfo.bu_female_yes }">
            <!-- <label><input type="checkbox" id="me_lack_yes" name="me_lack_yes" value="Y" checked="checked">결식 서비스<span style="padding-left: 30px"></span></label> -->
            <label><input type="checkbox" id="me_lack_yes" name="bu_lack_yes" value="Y">결식 서비스<span style="padding-left: 30px"></span></label>
			<label><input type="checkbox" id="me_care_yes" name="bu_care_yes" value="Y">돌봄 서비스<span style="padding-left: 30px"></span></label> 
			<label><input type="checkbox" id="me_female_yes" name="bu_female_yes" value="Y">보건위생 서비스</label>			
			</div>				
        </div>
        <script type="text/javascript">
        	window.onload = function fn_update_checked(){
        		var me_lack_yes = document.getElementById('me_lack_yes');
        		var me_care_yes = document.getElementById('me_care_yes');
        		var me_female_yes = document.getElementById('me_female_yes');
        		var h_me_lack_yes = document.getElementById('h_me_lack_yes').value;
        		var h_me_care_yes = document.getElementById('h_me_care_yes').value;
        		var h_me_female_yes = document.getElementById('h_me_female_yes').value;
        		if(h_me_lack_yes !== null && (h_me_lack_yes == 'Y'||h_me_lack_yes == 'yes')){
        			me_lack_yes.checked = true;}
        		if(h_me_care_yes !== null && (h_me_care_yes == 'Y'||h_me_care_yes == 'yes')){
        			me_care_yes.checked = true;}
        		if(h_me_female_yes !== null && (h_me_female_yes == 'Y'||h_me_female_yes == 'yes')){
        			me_female_yes.checked = true;}
        	}
        </script>
        
        <div class="mem">
         <!-- 11. 가입하기 버튼 -->
        
        <input type="submit" value="수정완료">
       	</div>
    </div>

</body>
</html>