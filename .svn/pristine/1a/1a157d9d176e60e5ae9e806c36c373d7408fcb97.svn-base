<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



<jsp:useBean id="now" class="java.util.Date" />
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="${basePath }/js/common.js"></script>
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>
<title>My JSP 'details.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
#div_back .a_back {
	margin: 0 auto;
	padding: 7px 20px;
	background: #00a6e3;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	color: #fff;
}
</style>
<style>
#img1:hover {
	position: absolute;
	z-index: 9999;
	left: 30%;
	top: 30%;
	width: 600px;
	height: 450px;
}

#img2:hover {
	position: absolute;
	z-index: 9999;
	left: 30%;
	top: 30%;
	width: 600px;
	height: 450px;
}

#img3:hover {
	position: absolute;
	z-index: 9999;
	left: 30%;
	top: 30%;
	width: 600px;
	height: 450px;
}
</style>

</head>
<script type="text/javascript">
	var $j = jQuery.noConflict();
	function act(obj) {
		$j
				.ajax({
					type : "get",
					url : "${basePath}/usercorp/getContent?userCode=" + obj,
					data : {},
					dataType : "json",
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						var contents = "<table cellpadding='0' cellspacing='0'  width='100%' border='0'>"
						for ( var i = 0; i < data.length; i++) {
							var map = data[i];
							var organ = "";
							if (map.USERIND == '1') {
								organ = "政府评估";
							} else if (map.USERIND == '3') {
								organ = "保险公司";
							} else if (map.USERIND == '4') {
								organ = "第三方机构";
							}

							contents = contents
									+ "<tr class='table_lista'>"
									+ "<td colspan='4' style='border-bottom:#9CF 1px solid;'>"
									+ organ
									+ "</td></tr>"
									+ "<tr><td style='border-bottom:#9CF 1px solid;width:100px;'>评估内容：</td>"
									+ "<td colspan='3' style='border-bottom:#9CF 1px solid;border-left:#9CF 1px solid;'>"
									+ map.CONTENT
									+ "</td></tr>"

									+ "<tr><td style='border-bottom:#9CF 1px solid;'>评估资料：</td>"
									+ "<td colspan='3' style='border-bottom:#9CF 1px solid;border-left:#9CF 1px solid;'>"
									+ "<a href='"
									+ ((map.DOCADDRESS == null || map.DOCADDRESS == '') ? '#'
											: map.DOCADDRESS)
									+ "' class='table_buttonc' target='_blank'>查看</a></td></tr>"
									+ "<tr><td style='border-bottom:#9CF 1px solid;'>风险状况：</td>"
									+ "<td style='border-bottom:#9CF 1px solid;border-left:#9CF 1px solid;'>"
									+ map.RISKLEVEL
									+ "</td><td style='border-bottom:#9CF 1px solid;border-left:#9CF 1px solid;'>评估时间：</td>"
									+ "<td style='border-bottom:#9CF 1px solid;border-left:#9CF 1px solid;'>"
									+ map.EVALUATDATE
									+ "</td></tr>"
									+ "<tr><td style='border-bottom:#9CF 1px solid;'>机构名称：</td>"
									+ "<td style='border-bottom:#9CF 1px solid;border-left:#9CF 1px solid;'>"
									+ map.ORGNAME
									+ "</td><td style='border-bottom:#9CF 1px solid;border-left:#9CF 1px solid;'>机构等级：</td>"
									+ "<td style='border-bottom:#9CF 1px solid;border-left:#9CF 1px solid;'>"
									+ map.GRADE
									+ "</td> </tr><tr><td colspan='4' style='height:10px;'></td></tr>"
						}
						contents += "<tr><td colspan='4'><a href='javascript:closeDiv();' class='table_buttona'>关闭</a></td></tr></table>"
						document.getElementById("pinggu").innerHTML = contents;
						document.getElementById("pinggu").style.display = "";

					},
					error : function() {
						alert("错误")
					}
				});
	}
	function showDiv1(obj, a) {
		var width = getObjWidth(a);
		var height = getObjHeight(a);
		var top = getTop(a);
		var left = getLeft(a);
		$j.ajax({
			type : "get",
			/* url:pathUrl, */
			url : "${basePath}/usercorp/getSource?userCode=" + obj,
			dataType : "json",
			data : {},
			contentType : "text/html;charset=UTF-8",
			success : function(data) {
				var div = document.createElement("div");
				$j(div).attr("id", "textList");
				$j(div).css({
					"display" : "block",
					"position" : "absolute",
					"top" : (top - 300),
					"left" : (left - 310),
					"width" : 300,
					"height" : 300,
					"border-radius" : "5px",
					"background-color" : "white",
					"border" : "1px solid #ECECEC",
					"z-index" : "1000"
				});
				var topDiv = document.createElement("div");
				$j(topDiv).css({
					"height" : "30px"
				});
				var a = document.createElement("a");
				$j(a).attr("id", "btn1");
				$j(a).attr("href", "javascript:close();");
				$j(a).css({
					"display" : "block",
					"width" : 50,
					"float" : "right",
					"border-radius" : "5px",
					"background-color" : "red",
					"border" : "1px solid #ECECEC"
				});
				a.innerHTML = "关闭";
				var contentDiv = document.createElement("div");
				for ( var i = 0; i < data.length; i++) {
					var map = data[i];
					var dItem = document.createElement("div");
					var userType = "";
					if (map.USERIND == '1') {
						userType = "政府评估：";
					} else if (map.USERIND == '3') {
						userType = "保险公司评估：";
					} else if (map.USERIND == '4') {
						userType = "第三方机构评估：";
					}
					dItem.innerHTML = userType + map.SOURCE;
					contentDiv.appendChild(dItem);
				}
				document.body.appendChild(div);
				div.appendChild(topDiv);
				topDiv.appendChild(a);
				div.appendChild(contentDiv);

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.responseText);
				alert(textStatus);
				alert("查询错误！");
			}
		});
	}
	function close() {
		document.body.removeChild(document.getElementById("textList"));
	}
	function showDiv(id) {
		document.getElementById(id).style.display = "";
	}
	function closeDiv() {
		document.getElementById("pinggu").style.display = "none";
	}
</script>

<body>
	<form action="${basePath }usercorp/details" name="fm" method="get"
		target="mainFrame">

		<div class="neicont_main_left_cont">
			<div class="neicont_imga">
				<img src="images/icotit2.jpg">
				<div class="neicont_img_font">企业详情</div>
			</div>
			<div class="neicont_main_left_cont_main">
				<div style="width:49.5%;float:left;">
					<table cellpadding="0" cellspacing="0" width="100%" border="0"
						style="margin-top: 10px;">
						<tr class="table_lista">
							<td colspan="2"
								style="border-top-left-radius: 5px;border-top-right-radius: 5px;">企业信息</td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">企业名称：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
									value="${userCorp.COMPANYNAME }"></c:out></td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">企业地址：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
									value="${userCorp.COMPANYADDRESS }"></c:out></td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">行业类型：</td>

							<td style="border-bottom:#9CF 1px solid;text-align:left;">
								${userCorp.CLASSCODE }</td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">企业规模：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;">
								${userCorp.CLASSSIZE }</td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">联系人：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
									value="${userCorp.LINKNAME }"></c:out></td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">联系方式：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
									value="${userCorp.TELEPHONE }"></c:out></td>
						</tr>
						<%-- <tr>
							<td style="border-bottom:#9CF 1px solid;">企业人数：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
									value="${userCorp.EMCOUNT }"></c:out></td>
						</tr> --%>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">统一社会信用代码：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
									value="${userCorp.BUSINESSLICENSENO }"></c:out></td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">营业执照有效期至：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><fmt:formatDate
									value="${userCorp.BUSINESSLICENSEDATE }" pattern="yyyy-MM-dd"
									var="busDate" /> <!-- </td> --> <fmt:formatDate value="${now}"
									pattern="yyyy-MM-dd" var="nowDate" /> <!-- 当前时间 --> <c:if
									test="${busDate > nowDate }">
									<fmt:formatDate value="${userCorp.BUSINESSLICENSEDATE }"
										pattern="yyyy-MM-dd" />
								</c:if> <c:if test="${busDate < nowDate }">
									<font color="#FF0000"><fmt:formatDate
											value="${userCorp.BUSINESSLICENSEDATE}" pattern="yyyy-MM-dd" />
										(营业执照已过期)</font>
								</c:if></td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">营业执照：</td>
							<td
								style="border-bottom:#9CF 1px solid;text-align:left;height:100px;">
								<img src="${userCorp.BUSINESSLICENSEIMAGE }" height="100px"
								width="150px" id="img1">
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">安全生产许可证号：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
									value="${userCorp.SAFETYLICENSENO }"></c:out></td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">安全许可证有效期至：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><fmt:formatDate
									value="${userCorp.SAFETYLICESEDATE}" pattern="yyyy-MM-dd" var="dDate" />
								<!-- 安全许可证有效期至 --> <fmt:formatDate value="${now}"
									pattern="yyyy-MM-dd" var="wDate" /> <!-- 当前时间 --> <c:if
									test="${ dDate gt wDate}" var="rs">
									<!-- 当前时间大于安全许可证有效期 -->
									<fmt:formatDate value="${userCorp.SAFETYLICESEDATE}"
										pattern="yyyy-MM-dd" />
								</c:if> <c:if test="${!rs}">
									<!-- 当前时间不大于安全许可证有效期 -->
									<font color="#FF0000"><fmt:formatDate
											value="${userCorp.SAFETYLICESEDATE}" pattern="yyyy-MM-dd" />
										(安全生产许可证已过期)</font>
								</c:if></td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">安全许可证：</td>
							<td
								style="border-bottom:#9CF 1px solid;text-align:left;height:100px;">
								<img src="${userCorp.SAFETYLICENSEIMAGE }" height="100px"
								width="150px" id="img2">
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">安全标准化等级证书：</td>
							<td
								style="border-bottom:#9CF 1px solid;text-align:left;height:100px;">
								<img src="${userCorp.STANDARDLEVELIMAGE}" height="100px"
								width="150px" id="img3">
						</tr>
					</table>
				</div>
				<div
					style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
					<a href="javascript:history.go(-1);" class="table_buttonb"
						style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
				</div>
				<!--  点击“详情”，弹出评估内容 -->
				<div id="pinggu"
					style="border:#CCD0CC 1px solid;border-radius:5px;width:600px;display:none;position:absolute;top:500px;right:300px;background-color:white;">
				</div>
			</div>
		</div>
		</div>
		</div>
	</form>
</body>
</html>