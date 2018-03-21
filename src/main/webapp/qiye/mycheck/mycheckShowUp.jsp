<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="gc"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'mycheckResult.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="/css/etpStyle.css">
<link rel="stylesheet" href="/css/WdatePicker.css">
<script type="text/javascript" src="/js/select2css.js"></script>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
</head>

<body>
	<div class="maincont">
		<div class="maincont_mid_cont_right">
<style>
* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

a,img {
	border: 0;
}

.gradecon {
	border: 1px solid #E0DCDC;
	background: #fefdea;
	padding: 10px;
	width: 320px;
	margin: 40px auto 0 auto;
}

.rev_pro li {
	line-height: 20px;
	height: 20px;
}

.rev_pro li .revtit {
	text-align: right;
	display: block;
	float: left;
	margin-right: 10px;
	width: 70px;
}

.revinp {
	float: left;
	display: inline;
}

.level .level_solid,.level .level_hollow {
	float: left;
	background-image: url("images/icon2.png");
	background-repeat: no-repeat;
	display: inline-block;
	width: 15px;
	height: 15px;
}

.level .level_solid {
	background-position: 0px 0px;
}

.level .level_hollow {
	background-position: -21px 0px;
}

.revgrade {
	margin-left: 20px;
}

.h8 {
	height: 8px;
}

.h9 {
	height: 9px;
}

.h25 {
	height: 25px;
}

.w150 {
	width: 20%;
}

.w739 {
	width: 739px;
}

.fl {
	float: left;
}

tl {
	text-align: left;
}

.border {
	border: solid 1px #CBC7CF;
}

.border-top {
	border-top: solid 1px #CBC7CF;
}

.border-left {
	border-left: solid 1px #CBC7CF;
}

.border-right {
	border-right: solid 1px #CBC7CF;
}

.border-bottom {
	border-bottom: solid 1px #CBC7CF;
}

.pb3 {
	padding-bottom: 3px;
}

p span {
	background: url(images/levle_star.png) no-repeat 0px -27px;
	width: 60px;
	height: 12px;
	display: block;
}

em {
	display: block;
	height: 12px;
	background: url(images/levle_star.png) no-repeat 0px -15px;
	width: 55px;
}

strong {
	font-size: 20px;
	color: #F00;
}

.con span {
	border: #B65CA8 solid 1px;
	color: #C1558B;
	border-radius: 3px;
	margin: 2px 6px;
	padding: 2px 5px;
}

.content {
	border: #CCC 2px solid;
	background-color: #EAEAEA;
	padding: 10px 20px;
	margin-top: 5px;
}
</style>

			<div id="evaluateId" style="border-radius:5px; position:absolute;top:10px;z-index:9999;width:100%;background-color:white;">
				
				<div style="text-align:left;width:100%; opacity:1.0;">
					<div class="h25">
						<div class="w150 h25 fl border-top border-right border-left" align="center"
						style="text-align:left;background-color:#E5E5E5;font-size:18px;width:100%; font-weight:bold;" id="pointcounty" name="pointcounty">
						累计评价
						<c:if test="${not empty sumSize }">
							<span>${sumSize }条</span>
						</c:if>
						<c:if test="${empty sumSize }">
							<span>0条</span>
						</c:if>
						</div>
						<!-- <div class="fl h25 " style="background-color:white;width:79%;"></div> -->
					</div>
					<div style="clear:both;"></div>
				</div>
				<div class="border" style="overflow-x:hidden;margin-top:20px;background-color:white;">
					<div class="" style="text-align:left;">
						<span style="font-size: 16px;">综合评分：</span>
							<c:if test="${not empty sumCount }">
								<span style="color: red;font-size: 16px;">${sumCount }</span>分
							</c:if>
					</div>
					<div class="fl" colspan="2"
						style="text-align:left;width:23px;height:100px;padding-left:20px;padding-right:5px;font-size:14px;
						line-height:15px;color:#CCC;background:url(images/T12eC3XklrXXXXXXXX-15-52.png) no-repeat center right;
						border-left:#CCC dashed 1px;">
						历史评价：
					</div>
					<div class="fl con" style="width:64%;">
						<table id="talked" style="width:100%;">
							<tr style="text-align: center;">
								<td>评论内容</td>
								<td>服务态度</td>
								<td>出单效率</td>
								<td>评论时间</td>
							</tr>
								<c:forEach items="${list_ggevaluate }" var="eva" >
							<tr style="text-align: center;">
									<td>${eva.content }</td>
									<td>${eva.remark }</td>
									<td>${eva.flag }</td>
									<td><fmt:formatDate value="${eva.evaluateTime }" pattern="yyyy-MM-dd"/>
									</td>
							</tr>
								</c:forEach>
						</table>
					</div>
				</div>
				<!-- --------------------------------------------------------------------------------------------- -->
				<!-- --------------------------------------------------------------------------------------------- -->
				<!-- --------------------------------------------------------------------------------------------- -->
				<!-- --------------------------------------------------------------------------------------------- -->
				<div class="content" id="other">
					<div style="width:100%;height:360px;">
						<!-- <h3 style="width:100%;">其他企业，需要你的建议哦！</h3> -->
						<div style="width:100%;">
							<div style="float:left;width:15%;">
								<span>评价选项：</span>
							</div>
							<div style="float:left;">
								<span style="width:100px;display:block;float:left;">服务态度：</span>
								<span style="width:100px;display:block;float:right;">
									<div class="select_list">
										<div id="uboxstyle">
											<select name="remark" id="remark">
												<option value="5">5分</option>
												<option value="4">4分</option>
												<option value="3">3分</option>
												<option value="2">2分</option>
												<option value="1">1分</option>
											</select>
										</div>
									</div>
								</span>
								<div style="clear:both;margin-top: 30px;"></div>
<!-- 								<span style="width:100px;display:block;float:left;">出单效率：</span> -->
<!-- 								<span style="width:100px;display:block;float:right;"> -->
<!-- 									<div class="select_list"> -->
<!-- 										<div id="uboxstyle"> -->
<!-- 											<select name="flag" id="flag"> -->
<!-- 												<option value="5">5分</option> -->
<!-- 												<option value="4">4分</option> -->
<!-- 												<option value="3">3分</option> -->
<!-- 												<option value="2">2分</option> -->
<!-- 												<option value="1">1分</option> -->
<!-- 											</select> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</span> -->
							</div>
							<div style="clear:both;"></div>
							<div>
								<div style="float:left;width:15%;">评价内容：</div>
								<div style="float: left;">
									<textarea rows="8" cols="34" id="content" name="content"
									style="margin: 20px 0px 10px; width: 591px; height: 193px;"></textarea>
								</div>
							</div>
							<input value="${BeEvaluator }" type="hidden" style="color: red;" id="beEvaluator" name="beEvaluator">
						</div>
					</div>
				</div>
				<div style="backgroun-color:white;padding:15px 0px; "
					class="border-left border-right border-bottom">
					<a href="javascript:sumPingjia();"
						style="padding:5px 15px;background-color:#F36;border-radius:5px;">提交评价</a>
					<a href="javascript:history.go(-1);"
						style="padding:5px 15px;background-color:#F36;border-radius:5px;">返回</a>
				</div>
			
			</div>
		<div class="clearboth"></div>
	</div>
</div>
</body>
<script type="text/javascript">
	function sumPingjia(){
		var fuwu = document.getElementById("remark").value;
// 		var jisong = document.getElementById("flag").value;
		var content = document.getElementById("content").value;
		var beEvaluator = document.getElementById("beEvaluator").value;
		if (content == null || content == "") {
			alert("评价内容不可为空，请输入！");
			return;
		}
		var ggEvaluate = {
            "remark" : fuwu,
//             "flag" : jisong,
            "content" : content,
            "beEvaluator" : beEvaluator
        };
		$.ajax({
			type : "post",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify(ggEvaluate),
			url : "${basepath }/mycheck/mycheckSumbitUp",
			success : function(data) {
				if (data == "isHavePingjia") {
					alert("已经评价过该保险公司,不可再次评价！");
					return;
				}else if (data == "success") {
					alert("评价成功！");
// 					window.location.href = "${basePath}/qiye/mycheck/mycheckCondition.jsp";
					window.location.href = "/mycheck/mycheckinit";
					return;
				}
			},
			error : function(){
				alert("提交评价出错，请稍后重试！");
				return;
			}
		});
	}
</script>
</html>
