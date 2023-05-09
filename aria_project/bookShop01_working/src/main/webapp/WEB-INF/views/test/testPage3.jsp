<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
	#resultTbl{
		border:1px solid gray;
		overflow: hidden;
    	text-overflow: ellipsis;
    	/* white-space: nowrap; */
    }
</style>
</head>
<body>
	<h1>공공데이터 조회 페이지 입니다!!</h1>
	<br><br>
	
	<form>
		<button id="callCommon_api_btn" type="button" onClick="fn_callCommon_api()" style="margin:0 30px;">공공데이터 press</button>
		
		<label><input type="number" value="1" id="pageNum" style="width:40px; height:25px; margin-left:15px;" min="1">페이지</label>
		<label><input type="number" value="1" id="numOfRows" style="width:40px; height:25px; margin-left:15px" min="1" max="100"> : 페이지 당 결과 수</label>
		<label><select id="searchCtprvnNm" style="margin-left:15px">
				<option selected>대전광역시</option>
				<option>인천광역시</option>
				<option>광주광역시</option>
				<option>부산광역시</option>
				<option>대구광역시</option>
				<option>서울특별시</option>
				<option>울산광역시</option>
				
			</select> : 검색할 도시</label>
			
			<label id="searchAllStore" style="margin-left:15px">
				<button type="button" onClick="fn_searchAllStore()">해당 도시 100개 검색하고 저장</button>
			</label>
			<script>
				function fn_searchAllStore(){
					var searchCtprvnNm = $("#searchCtprvnNm").val();
					$.ajax({
						type:"post",
						async:false,
						url:"${contextPath}/searchAllStore.do",
						data:{searchCtprvnNm:searchCtprvnNm},
						success:function(data,textStatus){
							alert("성공 data : "+data);
							location.href="${contextPath}/main/main.do";
						},
						error:function(data,textStatus){
							alert("에러");
						},
						complete:function(data,textStatus){
							//alert("완료");
						}
					});
				}
			</script>
	
		
			<script type="text/javascript">
				function fn_callCommon_api(){
					var control = $("#control").val();
					var pageNum = $("#pageNum").val();
					var numOfRows = $("#numOfRows").val();
					var searchCtprvnNm = $("#searchCtprvnNm").val();
					$.ajax({
						type:"post",
						async:false,
						url:"${contextPath}/callCommon_api.do",
						data:{pageNum:pageNum,
							searchCtprvnNm:searchCtprvnNm,
							numOfRows:numOfRows
							},
						////if dataType:"json" (X) -> you must use $.each(JSON.parse(data))... 
						dataType:"json",
						success:function(data,textStatus){
							//alert("성공");
							if(data!==null){
								if(control !== 0){
									$("#resultTbl > tbody").html("");
								}
								$.each(data, function(index, item){
									$("#resultTbl > tbody:last").append("<tr>");
									$("#resultTbl > tbody:last").append("<td id=\'mrhstNm["+index+"]\''>"+item.mrhstNm+"</td>");
									$("#resultTbl > tbody:last").append("<td id=\'rdnmadr["+index+"]\''>"+item.rdnmadr+"</td>");
									$("#resultTbl > tbody:last").append("<td id=\'lnmadr["+index+"]\''>"+item.lnmadr+"</td>");
									$("#resultTbl > tbody:last").append("<td id=\'latitude["+index+"]\''>"+item.latitude+"</td>");
									$("#resultTbl > tbody:last").append("<td id=\'longitude["+index+"]\''>"+item.longitude+"</td>");
									$("#resultTbl > tbody:last").append("<td id=\'phoneNumber["+index+"]\''>"+item.phoneNumber+"</td>");
									$("#resultTbl > tbody:last").append("<td id=\'referenceDate["+index+"]\''>"+item.referenceDate+"</td>");
									$("#resultTbl > tbody:last").append("</tr>");
								});
								$("#control").val($(data).length);
							}//end if
						},
						error:function(data,textStatus){
							alert("에러");
						},
						complete:function(data,textStatus){
							//alert("완료");
						}
					});//end ajax
				}
			</script>
		<fieldset style="margin:30px;">
			<legend>데이터 목록</legend>
		
			<input type="text" id="control" value="0">
			
			<table id="resultTbl">
				<thead bgcolor="#afa">
				<style>
					.tabStyle{
						width:13%;
						height:15px;
						text-align:center;
					}
				</style>
					<tr>
					<td class="tabStyle">가맹정명</td>
					<td class="tabStyle">도로명주소</td>
					<td class="tabStyle">지번주소</td>
					<td class="tabStyle">위도</td>
					<td class="tabStyle">경도</td>
					<td class="tabStyle">전화번호</td>
					<td class="tabStyle">업데이트날짜</td>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
				
			</table>
		</fieldset>
	</form>
</body>
</html>