<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!-- 모바일에서 화면배율을 디바이스 크기 기준으로 설정 -->
<!-- 이게 안되면 pc에서의 100px과 모바일에서의 100px이 디바이스 성능에 따라 달라집니다. -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!DOCTYPE html>
<html>
<head>
<style>
	caption {
    width: 0;
    height: 0;
    font-size: 0;
    line-height: 0;
    overflow: hidden;
    background: none;
    border: 0;
	}

	.care h2{
		font-size:2.6em;
		font:bold;
		text-align: center;
	}
	.ca-summary strong {
    margin-bottom: 15px;
    font-size: 18px;
    color: #703e07;
    font-weight: bold;
    padding-bottom: 15px;
    border-bottom: 1px dashed #f4f0e0;
    display: block;
}
	
	.ca-summary {
	margin: 0 0 20px;
    min-height: 120px;
    color: #fffef8;
    font-size: 16px;
    color: #111;
    background: #fffef8 url('../resources/image/ca-About.png') no-repeat left top;
    line-height: 160%;
    padding: 25px 30px 25px 220px;
    border: 1px solid #f4f0e0;
	}
	
	.subTitle1 {
    padding-top: 20px;
    padding-left: 18px;
    color: #444;
    font-size: 24px;
    font-weight: bold;
    background: url(../resources/image/icon_buHalf.gif) no-repeat left 23px;
	}
	
	.infoTextBlk {
    font-size: 16px;
    color: #000;
    line-height: 150%;
    margin-top: 10px;
	}
	
	.infoTextBlk2{
    font-size: 23px;
    color: #444;
    line-height: 150%;
    margin: 10px 0;
    text-align: center;
}
/* ca-area 아이돌봄 지원사업 목적 부분 */
.ca-area{background:#f0f2fa;padding:30px 0;margin-top:20px;}
.ca-area ul{overflow:hidden;}
.ca-area ul li{display:inline-block;text-align:center;width:33%;float:left;padding:5px 0;}
.ca-area ul li em{font-size:20px;color:#566ab6;font-style:normal;display:block;text-align:center;font-weight:bold;}
.ca-area ul li strong{margin-top:124px;font-size:18px;color:#444;display:block;text-align:center;font-weight:bold;}
.ca-area ul li p{margin-top:15px;font-size:16px;color:#444;display:block;text-align:center;line-height:150%;}
.ca-area ul li:nth-child(1){background:url(../resources/image/icon_care01.png) no-repeat 50% 45px;}
.ca-area ul li:nth-child(2){border-left:1px dashed #c0c4d4;background:url(../resources/image/icon_care02.png) no-repeat 50% 45px;}
.ca-area ul li:nth-child(3){border-left:1px dashed #c0c4d4;background:url(../resources/image/icon_care03.png) no-repeat 50% 45px;}

/* 아이돌봄 법령 부분 */
.aTypeListTbl{position:relative;margin-top:10px;margin-bottom:0px;width:100%;border-top:2px solid #666;}
.aTypeListTbl table{width:100%;table-layout:fixed;}
.aTypeListTbl table thead th{padding:15px 0;background:#fafafa;vertical-align:middle;color:#111;font-weight:bold;border-bottom:1px solid #e2e2e2;border-left:1px solid #e2e2e2;}
.aTypeListTbl table tbody td{padding:15px 10px;background:#fff;vertical-align:middle;color:#111;font-weight:bold;border-bottom:1px solid #e2e2e2;border-left:1px solid #e2e2e2;line-height:100%;text-align:center;letter-spacing:-1px;word-break:break-word;-ms-word-break:break-all;white-space:normal;}
.aTypeListTbl table tfoot td{padding:25px 10px;background:#fff url(../resources/image/bg_tfoot.gif) repeat left top;vertical-align:middle;color:#111;font-weight:bold;border-bottom:1px solid #e2e2e2;border-left:1px solid #e2e2e2;line-height:100%;text-align:center;letter-spacing:-1px;}
.aTypeListTbl table tfoot th{padding:25px 10px;background:#fff url(../resources/image/bg_tfoot.gif) repeat left top;vertical-align:middle;color:#111;font-weight:bold;border-bottom:1px solid #e2e2e2;line-height:100%;text-align:center;letter-spacing:-1px;} 
.aTypeListTbl table thead th:first-child{border-left:0;text-align:center;}
.aTypeListTbl table tbody td:first-child{border-left:0;text-align:center;}
.aTypeListTbl table tbody td.subject{font-weight:normal;text-align:left;line-height:130%;}
.aTypeListTbl table tbody .depositLine td{background:#fff6f6;}
.aTypeListTbl table tbody .reFundLine td{background:#f0faee;}
.aTypeListTbl table tbody td a{text-decoration:underline;font-weight:bold;}
/* 법령부분 버튼  */
.btnsAdd{background:#f7f7f7 url(../resources/image/icon_add.png) no-repeat 15px 50%;color:#111;font-size:15px;height:34px;line-height:34px;border:1px solid #999;padding:0 15px 0 32px;font-weight:bold;}/* 아동추가 */
.btnPrint2{background:#f7f7f7 url(../resources/image/icon_print2.png) no-repeat 14px 50%;color:#111;font-size:15px;height:30px;line-height:30px;border:1px solid #999;padding:0 14px 0 39px;font-weight:bold;}/* 인쇄작은버튼 */
.linkBlankGrey{display:inline-block;box-shadow: 0px 2px 0px #cdcdcd;border-radius:5px;background:#f7f7f7 url(../resources/image/icon_blank.png) no-repeat 94% 50%;color:#111;font-size:16px;height:32px;line-height:32px;border:1px solid #bababa;padding:0 35px 0 15px;font-weight:bold;letter-spacing:-1px;}
.linkBlankGreyIcon01{background-color:#f7f7f7; background-image:url(../resources/image/icon_blank.png), url(../resources/image/icon_law.png);background-repeat:no-repeat;background-position:92% 50%, 23px 50%;display:inline-block;box-shadow: 0px 2px 0px #cdcdcd;border-radius:5px;color:#111;font-size:16px;border:1px solid #bababa;line-height:130%;vertical-align:middle;padding:25px 45px 25px 67px;width:190px;font-weight:bold;letter-spacing:-1px;text-align:left;}
.linkBlankGreyIcon02{background-color:#f7f7f7; background-image:url(../resources/image/icon_blank.png), url(../resources/image/icon_rule.png);background-repeat:no-repeat;background-position:92% 50%, 24px 50%;display:inline-block;box-shadow: 0px 2px 0px #cdcdcd;border-radius:5px;color:#111;font-size:16px;border:1px solid #bababa;line-height:130%;vertical-align:middle;padding:12px 45px 12px 67px;width:190px;font-weight:bold;letter-spacing:-1px;text-align:left;}
.linkBlankGreyIcon03{background-color:#f7f7f7; background-image:url(../resources/image/icon_blank.png), url(../resources/image/icon_guide.png);background-repeat:no-repeat;background-position:92% 50%, 25px 50%;display:inline-block;box-shadow: 0px 2px 0px #cdcdcd;border-radius:5px;color:#111;font-size:16px;border:1px solid #bababa;line-height:130%;vertical-align:middle;padding:25px 45px 25px 67px;width:190px;font-weight:bold;letter-spacing:-1px;text-align:left;}
/* 관계 사이트  */
.svcOrgan{margin-top:10px; overflow:hidden;}
.svcOrgan li{display:inline-block;width:364px;border:1px solid #e2e2e2;float:left;text-align:center;}
.svcOrgan li a{display:block;text-align:center;}
.svcOrgan li a img{display:inline;}

	
</style>
<meta charset="UTF-8">
<title>아이돌봄 사업소개</title>
</head>
<body>
 <section class="care">
	<div>
		<h2>아이돌봄 사업소개</h2>
	</div>
	<div class="ca-summary">
		<ul>
				<strong>아이돌봄 서비스란?</strong>
			<li>부모의 맞벌이 등으로 양육공백이 발생한 가정의 만 12세 이하 아동을 대상으로 아이돌보미가 찾아가는 돌봄 서비스를 제공하여 부모의 양육부담을 경감하고 시설보육의 사각지대를 보완하고자 만들어졌습니다.</li>
		</ul>
	</div>
	<h4 class="subTitle1">아이돌봄 지원사업 목적</h4>
	<p class="infoTextBlk default_cursor_cs">아이돌봄 지원사업은 가정의 아이돌봄을 지원하여 아이의 복지증진과 보호자의 일·가정 양립을 통한 가족구성원의 삶의 질 향상과 양육친화적인 사회 환경을 조성하는데 목적이 있습니다.</p>
	<h5 class="infoTextBlk2">가족구성원의 삶의 질 향상</h5>
	<div class="ca-area">

<ul>

	<li><em>아동의 안전한 보호</em> <strong>영아 및 방과 후 아동 돌봄</strong>


	<p>개별 가정 특성 및 아동발달을<br>

	고려하여 아동의 집에서<br>

	돌봄 서비스 제공</p>

	</li>

	<li><em>부모의 일·가정 양립</em> <strong>취업 부모</strong>

	<p>야간·주말 등 틈새시간<br>

	‘일시 돌봄’ 및 ‘영아종일돌봄’ 등<br>

	수요자가 원하는 서비스 확충</p>

	</li>

	<li><em>돌봄 자원 창출</em> <strong>아이돌보미</strong>

	<p>육아·돌봄 의사가 있는 자에게<br>

	교육지원과 능력개발을 제공하여<br>

	사회서비스 수요와 연계 활성화</p>

	</li>

</ul>

</div>
<h4 class="subTitle1">법령 및 지침</h4>
<div class="aTypeListTbl">

<table>

	<caption><strong>법령 및 지침</strong>


	<p>법령, 행정규칙, 지침</p>

	</caption>

	<colgroup>

		<col class="w330">

		<col class="w340">

		<col class="w330">

	</colgroup>

	<thead>

		<tr>

			<th scope="col">법령</th>

			<th class="bd_l0" scope="col">행정규칙</th>

			<th class="bd_l0" scope="col">지침</th>

		</tr>

	</thead>

	<tbody>

		<tr>

			<td><a class="linkBlankGreyIcon01" href="http://www.law.go.kr/lsInfoP.do?lsiSeq=218023" target="_blank" title="새 창 열림">아이돌봄지원법</a></td>

			<td><a class="linkBlankGreyIcon02" href="http://www.mogef.go.kr/nw/ntc/nw_ntc_s001d.do?mid=news400&amp;bbtSn=709026" target="_blank" title="새 창 열림">아이돌봄 서비스 비용 및<br>

			지원가구 소득 기준</a></td>

			<td><a class="linkBlankGreyIcon03" href="javascript:gfn_downFile(1439440, 1, '2023년_아이돌봄지원사업_안내(230221버전).pdf');" title="2023년도 아이돌봄 지원사업 안내 다운로드">아이돌봄 지원사업 사업지침</a></td>

		</tr>

		<tr>

			<td><a class="linkBlankGreyIcon01" href="http://www.law.go.kr/lsInfoP.do?lsiSeq=238665" target="_blank" title="새 창 열림">아이돌봄지원법시행령</a></td>

			<td><a class="linkBlankGreyIcon02" href="http://www.law.go.kr/admRulLsInfoP.do?admRulSeq=2100000099809" target="_blank" title="새 창 열림">사회보장급여 관련<br>

			공통서식에 관한 고시</a></td>

			<td>&nbsp;</td>

		</tr>

		<tr>

			<td><a class="linkBlankGreyIcon01" href="http://www.law.go.kr/lsInfoP.do?lsiSeq=239077" target="_blank" title="새 창 열림">아이돌봄지원법시행규칙</a></td>

			<td><a class="linkBlankGreyIcon02" href="http://www.mogef.go.kr/nw/ntc/nw_ntc_s001d.do;jsessionid=tWD9-7vCkX2k1hmTVL8T6+-p.mogef10?mid=news400&amp;bbtSn=708335" target="_blank" title="새 창 열림">아이돌보미 양성 및<br>

			보수 교육과정</a></td>

			<td>&nbsp;</td>

		</tr>

	</tbody>

</table>

</div>

	<h4 class="subTitle1">관계기관 사이트</h4>
	<ul class="svcOrgan">

	<li><a href="http://www.mogef.go.kr/index.jsp" target="_blank" title="새창"><img alt="여성가족부" src="../resources/image/logo_mogef.png"></a></li>

	<li><a href="http://www.kihf.or.kr/" target="_blank" title="새창"><img alt="한국건강가정진흥원" src="../resources/image/logo_kihf.png"></a></li>

	<li><a href="http://online.bokjiro.go.kr/" target="_blank" title="새창"><img alt="복지ro 함께 만드는 복지" src="../resources/image/logo_bokjiro.png"></a></li>

	<li><a href="http://familynet.or.kr/" target="_blank" title="새창"><img alt="건강가정지원센터" src="../resources/image/logo_familynet.png"></a></li>

	<li><a href="http://www.liveinkorea.kr/" target="_blank" title="새창"><img alt="다문화가족지원포털 다누리" src="../resources/image/logo_liveinkorea.png"></a></li>

	<li><a href="http://www.voucher.go.kr/common/main.do" target="_blank" title="새창"><img alt="국가바우처 통합카드국민행복카드" src="../resources/image/logo_kukminHappy.png"></a></li>

	<!-- <li><a href="http://www.youth.go.kr/" target="_blank" title="새창"><img src="../resources/image/logo_youth.png" alt="청소년활동정보서비스 e청소년"></a></li>

							<li><a href="http://www.mogef.go.kr/withmom/index.do" target="_blank" title="새창"><img src="../resources/image/logo_withmom.png" alt="한부모가족"></a></li>

							<li><a href="http://www.ffsb.kr" target="_blank" title="새창"><img src="../resources/image/logo_ffsb.png" alt="가족친화지원사업"></a></li>

							<li><a href="http://www.mohw.go.kr/" target="_blank" title="새창"><img src="../resources/image/logo_mohw.png" alt="맞춤형 기초생활보장"></a></li>

							<li><a href="http://www.childinfo.go.kr/" target="_blank" title="새창"><img src="../resources/image/logo_childinfo.png" alt="어린이집 유치원 통합정보공시"></a></li>

							<li><a href="https://central.childcare.go.kr/" target="_blank" title="새창"><img src="../resources/image/logo_childcare.png" alt="중앙 육아종합지원센터 한국보육진흥원 위탁운영"></a></li>

							<li><a href="https://www.clean.go.kr/index.do" target="_blank" title="새창"><img src="../resources/image/logo_clean.png" alt="청렴포털 Clean Portal"></a></li> -->

</ul>
	<
 </section>
</body>
</html>