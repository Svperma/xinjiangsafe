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
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="${basePath }/js/select2css.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<link rel="stylesheet" href="${basePath }/css/etpStyle.css" />
<link rel="stylesheet" href="${basePath }/css/WdatePicker.css">

</head>
<body>

	<div class="maincont">
		<div class="maincont_mid_cont_right">
			<div class="maincont_mid_cont_right_main">
				<form action="${basePath }/myclaim/myclaimPagin" name="fm" id="fm" method="post">
					<table cellpadding="0" cellspacing="0" width="100%" border="0" style="border: 1px solid #008ABD">
						<tr>
							<td style="border:1px solid #008ABD ; text-align:center ; background: #008ABD ; width:20%; color: #FFF">保单号</td>
							<td style="border:1px solid #008ABD ; width:80%;"></td>						
						</tr>
						<tr>
							<td colspan="2" style="border:1px solid #008ABD ; text-align:center ; background: #008ABD ; width:20%; color: #FFF">批单内容</td>
						</tr>
						<tr>
							<td rowspan="3" colspan="2" style="border-left:1px solid #008ABD; border-right:1px solid #008ABD;"></td>
						</tr>
						<tr><td style="border-left:1px solid #008ABD; border-right:1px solid #008ABD;" colspan="2"></td></tr>
						<tr><td style="border-left:1px solid #008ABD; border-right:1px solid #008ABD;" colspan="2"></td></tr>
						<tr>
							<td style="border:1px solid #008ABD ; text-align:center ; background: #008ABD ; width:20%; color: #FFF">金额</td>
							<td style="border:1px solid #008ABD "></td>
						</tr>
						<tr>
							<td style="border:1px solid #008ABD ; text-align:center ; background: #008ABD ; width:20%; color: #FFF;" colspan="2">审批建议</td>
						</tr>
						<tr>
							<td rowspan="3" colspan="2" style="border-left:1px solid #008ABD; border-right:1px solid #008ABD;"></td>
						</tr>
						<tr><td style="border-left:1px solid #008ABD; border-right:1px solid #008ABD;" colspan="2"></td></tr>
						<tr><td style="border-left:1px solid #008ABD; border-right:1px solid #008ABD;" colspan="2"></td></tr>
					</table>
					
				</form>
			</div>


			<div class="clearboth"></div>
		</div>
	</div>
	<script type="text/javascript">
		function upSummit() {
			var textname = document.getElementById("textname").value;
			if (textname == null ) {
				alert("评价内容为空，请输入！");
				return;
			}
// 			document.getElementById('evaluateId').style.display = 'none';
		}
	</script>
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
	<script type="text/javascript" charset="gbk">
		var bananno = null;
		function close() {
			/* document.getElementById('evaluateId').style.display = 'none';
			document.getElementById("textname").value = ''; */
			window.location.reload();
		}

		function showDiv(obj, id) {
			baoanno = id;
			document.getElementById(obj).style.display = '';
			document.getElementById(obj).style.top = "30px";
// 			alert("完成操作");
		}
		function hide(obj) {
			document.getElementById(obj).style.display = "none";
		}
		function shangchuan() {
			var ACCIDENTPORT = document.getElementById("ACCIDENTPORT").value;
			var DEATHPORT = document.getElementById("DEATHPORT").value;
			var DISABLITY = document.getElementById("DISABLITY").value;
			if ((ACCIDENTPORT != null && ACCIDENTPORT != "" && ACCIDENTPORT != "未选择文件。")
			||(DEATHPORT != null && DEATHPORT != "" && DEATHPORT != "未选择文件。")
			||(DISABLITY != null && DISABLITY != "" && DISABLITY != "未选择文件。"))
			 {
				var forms = document.forms["claimchuan"];
				forms.action = "/myclaim/claimchuan?id=" + baoanno;
				forms.submit();
			}else {
				alert("上传文件为空，请选择文件后提交！");
				return;
			}
		}
		function evaluate(id) {
			bananno = id;
			var table = document.getElementById("talked");
			var chile = table.getElementsByTagName("tr");
			for ( var i = chile.length - 1; i > 0; i--) {
				if (i > 0) {
					table.deleteRow(i);
					continue;
				}
			}
			$.ajax({
				type : "post",
				contentType : "application/json;charset=UTF-8",
				data : {},
				dataType : "json",
				url : "${basePath }/myclaim/myclaimshowTalk?bananno="+ bananno,
					success : function(data) {
						if(data.length==0){
							$("#talked").append();
						}else{
							for ( var i = 0 ;i < data.length-1 ; i++) {
								$("#talked").append(
									"<tr><td>" + data[i].CONTENT + "</td>"
									+ "<td>" + data[i].serce
									+ "分</td>" + "<td>"
									+ data[i].policy + "分</td>"
									+ "<td>"
									+ getTime(data[i].EVALUATETIME)
									+ "</td></tr>");
							}
							$("#dou").append(data[data.length-1].dou);
							$("#pointcounty").append(data[data.length-1].pointcounty);
							document.getElementById("evaluateId").style.display = "";
						}
				},
				/* function(XMLHttpRequest, textStatus,
								errorThrown) {
							alert(XMLHttpRequest.status);
							alert(XMLHttpRequest.readyState);
							alert(textStatus); */
				error : function(){
					alert("error");
				}
			});
		}
		function mychecktalk() {
			var serce = document.getElementById("serve").innerHTML;
			var policy = document.getElementById("policy").innerHTML;
			var textname = document.getElementById("textname").value;
			$.ajax({
				type : "post",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"serce" : serce,
					"policy" : policy,
					"textname" : textname,
					"bananno" : bananno,
				}),
				datatype : "json",
				url : "${basepath }/myclaim/myclaimtalk",
				success : function(data) {
					var jsString = JSON.parse(data);
					if (jsString == "isHavePingJia") {
						document.getElementById("evaluateId").style.display = "none";
						alert("您已评价过");
						return;
					}else if (jsString == "textnameIsNull") {
						alert("评价内容为空，请输入内容！");
						return;
					}else if(jsString == "chenggong"){
						alert("评价成功！");
// 						document.getElementById("textname").value = "";
// 						$("#evaluateId").html(jsString);
						window.location.reload();
						document.getElementById("evaluateId").style.display = "none";
					}
				},
				/* error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
				} */
				error : function() {
					alert("失败，请稍后再试");
				}
			});
		}

		function getTime(hello) {
			var now = new Date(hello);

			//now =  now.getTime();

			//获取当前时间的小时
			//var hours = now.getHours();//10
			//分钟
			//var min = now.getMinutes();//36
			//秒
			//var sec = now.getSeconds();//25
			//年
			var year = now.getFullYear();//2015
			//月    月份的范围是从0~11,所以获得的月份要加1才是当前月
			var mon = now.getMonth() + 1;//9
			//日
			var day = now.getDate();//21
			return year + "-" + mon + "-" + day;
		}
	</script>
</body>
</html>
