<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<style>

*{margin: 0; padding: 0; box-sizing: border-box;
}


ul>li{list-style: none;
}

a{text-decoration: none;
}

.clearfix::after{content: ""; display: block; clear: both;
}

#joinForm{width: 460px; margin: 0 auto;
}

ul.join_box{border: 1px solid #ddd; background-color: #fff;
}

.checkBox, .checkBox>ul{position: relative;
}

.checkBox>ul>li{float: left;
}

.checkBox>ul>li:first-child{width: 85%; padding: 15px; font-weight: 600; color: #888;
}

.checkBox>ul>li:nth-child(2){position: absolute; top: 50%; right: 30px; margin-top: -12px;
}

.checkBox textarea{width: 96%; height: 90px; margin: 0 2%; background-color: #f7f7f7; color: #888; border: none;
}

#mem3 {
padding: 40px 0 60px;
    text-align: center;
}

a.fpmgBt1{background-color: #8c8c8c; color: #fff;
}

a.fpmgBt2{background-color: #66cc00; color: #fff;
}


.footBtwrap{margin-top: 15px;
}

.footBtwrap>li{float: left; width: 50%; height: 60px;
}

.footBtwrap>li>a{display: block; width: 100%; height: 100%; font-size: 20px; text-align: center; line-height: 60px;
}

#hd {text-align: center; font-size: 20px;}
</style>




<script>
	function joinform_check(){
	var agree = document.getElementById("agree");
	if(!agree.checked) {
		alert("이용약관 모두 동의를 체크하세요.");
		agree.focus();
		return false;
	}
	document.join_form.submit();
	}
	</script>

</head>
<body>
	<form action="" id="joinForm">
	<h1 id="hd">사업자회원 이용약관</h1>
	
            <ul class="join_box">
               
                <li class="checkBox check02">
                    <ul class="clearfix">
                        <li>이용약관 동의</li>
                       
                    </ul>
                    <textarea name="" id="">여러분을 환영합니다.
아리아 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 아리아 서비스의 이용과 관련하여 아리아 서비스를 제공하는 아리아 주식회사(이하 ‘아리아’)와 이를 이용하는 아리아 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 아리아 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       </textarea>
                </li>
                <li class="checkBox check03">
                    <ul class="clearfix">
                        <li>개인정보 수집 및 이용에 대한 안내</li>
                        
                    </ul>
 
                    <textarea name="" id="">여러분을 환영합니다.
아리아 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 아리아 서비스의 이용과 관련하여 아리아 서비스를 제공하는 아리아 주식회사(이하 ‘아리아’)와 이를 이용하는 아리아 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 아리아 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       </textarea>
                </li>
                <li class="checkBox check03">
                    <ul class="clearfix">
                        <li>위치정보 이용약관 동의</li>
                        
                    </ul>
 
                    <textarea name="" id="">여러분을 환영합니다.
아리아 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 아리아 서비스의 이용과 관련하여 아리아 서비스를 제공하는 아리아 주식회사(이하 ‘아리아’)와 이를 이용하는 아리아 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 아리아 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       </textarea>
                </li>
                
            </ul>
            
            <br>
            
             <tr>
            <td> <input type='checkbox' id='agree'
								onclick='agree()'/> 모두 동의합니다.
						</td>
           	</tr>
           
        </form>

  <div id="mem3">
		   		<form name="join_form" action="${contextPath}/business/businessForm.do" method="post">
		   		<ul class="footBtwrap clearfix">
			   		<li><a href="${contextPath}/member/memberFormSelect.do" class="fpmgBt1" >비동의</a></li>
			   		<li><a href="#" onclick="joinform_check()" class="fpmgBt2" >동의</a></li>
			   	</ul>
			   		</form>
	</div>

</body>
</html>