<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${contextPath}/member/addMember.do" method="post" onsubmit="return rt()" >
    <div class="member">
    
    	<div class="mem">
        
        <h1 id="hd">개인 회원가입</h1>

        <!-- 1. 아이디 -->
      <div class="field tel-number">
            <b>아이디</b>
            <div>
            <input type="text"  name="_member_id" id="_member_id"  />
            <input type="hidden" name="me_id" id="member_id" />
            <input type="button" id="btnOverlapped" value="중복확인" onClick="fn_overlapped()" />
 			</div>   
 			</div>
 			 <!-- 2. 비밀번호 -->
        <div class="field">
            <b>비밀번호</b>
            <input name="me_pw" id="member_pw" type="password"/>
        </div>
        <div class="field tel-number">
            <b>비밀번호 확인</b>
            <div>
             <input id="member_pw1" type="password"/> <input type="button" onclick="test()" value="확인" />       
        </div>
        </div>
        
        <!-- 3. 주민번호 -->
          <div class="field">
						<b>주민번호</b>
						<input id="hp" type="text" name="me_ssn1"> - <input id="hp" type="text" name="me_ssn2">
		</div>
        
         <!-- 4. 이름 -->
         <div class="field">
            <b>이름</b>
            <input id="nam" type="text" name="me_name">
        </div>
         
        <!-- 5. 성별 -->
          <div class="field gender">
            <b>성별</b>
            <div >
               <label><input type="radio" name="me_gender" value="male" checked="checked">남자<span style="padding-left: 100px"></span></label>
                <label><input type="radio" name="me_gender" value="female">여자</label>
                
            </div>
        </div>
        
 
	 <!-- 7. 이메일 -->
<div class="field">
            <b>이메일</b>
            
                <input id="_me_email1" type="text"  name="_me_email1"> @  
                <input id="me_email2" type="text"  name="me_email2">
                <select id="me_email3" name="me_email3" onChange="document.getElementById('me_email2').value=this.value" title="직접입력">
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
             <input type="hidden" name="me_email1" id="me_email1" />
 			<input type="button" id="btnOverlapped2" value="이메일 중복확인" onClick="fn_overlapped2()" />  
						
 			
 			</div>     
        </div>
       		<label><input type="checkbox" name="me_email_yes" value="Y" checked="checked" /> 아리아에서 발송하는 e-mail을 수신합니다.</label>
	
	<div class="mem">
        <!-- 8. 휴대폰 번호 -->
        <div class="field">
            <b>휴대폰 번호</b>
						<select id="tl" name="me_phone1">
								
								<option selected value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="018">018</option>
								<option value="019">019</option>
						</select> - <input
							id="tl" type="tel" name="me_phone2"> - 
							<input
							id="tl" type="tel" name="me_phone3">
        </div>
     </div>
        <label><input type="checkbox"   name="me_sms_yes" value="Y" checked="checked" /> 아리아에서 발송하는 SMS 소식을 수신합니다.</label>
     
     <div class="mem">
         <!-- 9. 주소 -->
         <div class="field tel-number">
            <b>주소</b>
            <div>
            <input type="text" id="zipcode" name="me_zipcode" >
            <input type="button" onclick="javascript:execDaumPostcode()" value="우편번호 검색">
 			</div> 
            
                <input type="text" id="roadAddress"
									name="me_address1" placeholder="도로명 주소"> 
              <!--  <input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번 주소"> -->
              <input type="text" id="detailAdddress"  name="me_address2" placeholder="상세 주소">
            
        </div> 
          
        </div>
         
        <!-- 10. 서비스 선택 --> 
        <div style="margin-bottom:15px;">
            <b>서비스 선택</b>
            <div id="ser">
            <label><input type="checkbox" name="me_lack_yes" value="Y" checked="checked">결식 서비스<span style="padding-left: 30px"></span></label>
			<label><input type="checkbox" name="me_care_yes" value="Y">돌봄 서비스<span style="padding-left: 30px"></span></label> 
			<label><input type="checkbox" name="me_female_yes" value="Y">보건위생 서비스</label>			
			</div>				
        </div>
        
        <div class="mem">
         <!-- 11. 가입하기 버튼 -->
        
        <input type="submit" value="가입하기">
       	</div>
    </div>
    </form>
</body>
</html>