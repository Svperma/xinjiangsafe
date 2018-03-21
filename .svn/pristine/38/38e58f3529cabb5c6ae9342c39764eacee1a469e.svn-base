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

<script type="text/javascript">
	
	//初始化
	window.onload  = function(){
		var oImg1 = document.getElementById('img1');
		var oImg2 = document.getElementById('img2');
		var oImg3 = document.getElementById('img3');
		oImg1.onmouseover = function(){
			this.style.position = 'absolute';
			this.style.zIndex = '9999';
			this.style.right = '10%';
			this.style.top = '30%';
			this.style.width = '600px';
			this.style.height = '450px';
			
		}
		oImg2.onmouseover = function(){
			this.style.position = 'absolute';
			this.style.zIndex = '9999';
			this.style.right = '10%';
			this.style.top = '30%';
			this.style.width = '600px';
			this.style.height = '450px';
			
		}
		oImg3.onmouseover = function(){
			this.style.position = 'absolute';
			this.style.zIndex = '9999';
			this.style.right = '10%';
			this.style.top = '30%';
			this.style.width = '600px';
			this.style.height = '450px';
			
		}
		oImg1.onmouseout = function(){
			this.style.position = '';
			this.style.zIndex = '';
			
			this.style.top = '';
			this.style.width = '';
			this.style.height = '';
		}
		oImg2.onmouseout = function(){
			this.style.position = '';
			this.style.zIndex = '';
			
			this.style.top = '';
			this.style.width = '';
			this.style.height = '';
		}
		oImg3.onmouseout = function(){
			this.style.position = '';
			this.style.zIndex = '';
			
			this.style.top = '';
			this.style.width = '';
			this.style.height = '';
		}
	}
	
	
</script>
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
					<c:if test="${ empty sessionScope.userCorp.BUSINESSNO }">
						<table cellpadding="0" cellspacing="0" width="100%" border="0"
							style="margin-top: 10px;">
							<tr class="table_lista">
								<td
									style="border-top-left-radius: 5px;text-align:left;padding-left:20px;">
									保单信息
								</td>
								<td
									style="border-top-right-radius: 5px;text-align:right;padding-right:20px;">
									<fmt:formatDate value="${sessionScope.userCorp.ENDDATE }" pattern="yyyy-MM-dd" var="ENDDate" /> 
									<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="nowDate" />
										<c:if test="${ENDDate < nowDate }">
											<font color="#FF0000" style="border-top-right-radius: 5px;text-align:left;padding-right:10px;">
												(保单已过期)
											</font>
										</c:if>
										保单号：${userCorp.POLICYNO }</td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;">被保险人：</td>
								<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
										value="${userCorp.INSUREDNAME }"></c:out></td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;">被保险人地址：</td>
								<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
										value="${userCorp.INSUREDADDRESS}"></c:out></td>
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
							<tr>
								<td style="border-bottom:#9CF 1px solid;">统一社会信用代码：</td>
								<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
										value="${userCorp.BUSINESSLICENSENO}"></c:out></td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;">安全生产许可证号：</td>
								<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
										value="${userCorp.SAFETYLICENSENO }"></c:out></td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;">保险期间：</td>
								<td style="border-bottom:#9CF 1px solid;text-align:left;">
									<fmt:formatDate value="${userCorp.STARTDATE}"
										pattern="yyyy-MM-dd" />至 <fmt:formatDate
										value="${userCorp.ENDDATE}" pattern="yyyy-MM-dd" />
								</td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;" rowspan="5">安全生产责任保险：</td>
								<td style="border-bottom:#9CF 1px solid;text-align:left;">每人每次责任限额<c:out
										value="${userCorp.UNITAMOUNT }"></c:out>万元
								</td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;text-align:left;">每次事故及累计责任限额<c:out
										value="${userCorp.SUMAMOUNT }"></c:out>万元
								</td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;text-align:left;">每次事故救援费用责任限额为主险每次事故责任限额的30%，在主险限额内计算。</td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;text-align:left;">每次法律费用责任限额为主险每次事故责任限额的5%，在主险限额内计算。</td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;text-align:left;">保险费<c:out
										value="${userCorp.GISSP }"></c:out>元，（大写）： <script
										type="text/javascript">
											document
													.write(convertCurrency('${userCorp.GISSP}'))
										</script></td>
								<c:forEach items="${sessionScope.list_code }" var="kind"
									varStatus="listSize">
									<c:if test="${kind.kindcode eq '0901002'}">
										<tr>
											<td style="border-bottom:#9CF 1px solid;" rowspan="2">附加医疗费用责任保险：</td>
											<td style="border-bottom:#9CF 1px solid;text-align:left;">每人伤亡责任限额的30%，在基本险责任限额内计算。
											</td>
										</tr>
										<tr>
											<td style="border-bottom:#9CF 1px solid;text-align:left;">保险费：<c:out
													value="${kind.spreadsheetpremium }"></c:out>元，（大写）： <script
													type="text/javascript">
														document
																.write(convertCurrency('${kind.spreadsheetpremium}'))
													</script>
											</td>
										</tr>
									</c:if>
									<c:if test="${kind.kindcode eq '0901003'}">
										<tr>
											<td style="border-bottom:#9CF 1px solid;" rowspan="2">附加补充雇主责任保险：</td>
											<td style="border-bottom:#9CF 1px solid;text-align:left;">适用主险各项责任限额，在基本险责任限额内计算。
											</td>
										</tr>
										<tr>
											<td style="border-bottom:#9CF 1px solid;text-align:left;">保险费：<c:out
													value="${kind.spreadsheetpremium }"></c:out>元，（大写）： <script
													type="text/javascript">
														document
																.write(convertCurrency('${kind.spreadsheetpremium }'))
													</script>
											</td>
										</tr>
									</c:if>
									<c:if test="${kind.kindcode eq '0901004'}">
										<tr>
											<td style="border-bottom:#9CF 1px solid;" rowspan="2">附加第三者财产损失责任保险：</td>
											<td style="border-bottom:#9CF 1px solid;text-align:left;">赔偿限额<c:out
													value="${kind.amount/10000 }"></c:out>万元，在基本险责任限额外计算。
											</td>
										</tr>
										<tr>
											<td style="border-bottom:#9CF 1px solid;text-align:left;">保险费：<c:out
													value="${kind.spreadsheetpremium }"></c:out>元，（大写）： <script
													type="text/javascript">
														document
																.write(convertCurrency('${kind.spreadsheetpremium }'))
													</script>
											</td>
										</tr>
									</c:if>
								</c:forEach>
							<tr>
								<td style="border-bottom:#9CF 1px solid;">总保费：</td>
								<td style="border-bottom:#9CF 1px solid;text-align:left;"><c:out
										value="${userCorp.SSP }"></c:out>（大写）： <script
										type="text/javascript">
											document
													.write(convertCurrency('${userCorp.SSP}'))
										</script></td>
							</tr>
							<tr>
								<td style="border-bottom:#9CF 1px solid;">保险合同争议解决方式：</td>
								<td style="border-bottom:#9CF 1px solid;text-align:left;">
									<c:choose>
										<c:when test="${userCorp.ARGUESOLUTION eq '1'}">
											<font>诉讼</font>
										</c:when>
										<c:otherwise>
											<font>仲裁</font>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</table>
					</c:if>
					<c:if test="${not empty sessionScope.userCorp.BUSINESSNO }">
						<table cellpadding="0" cellspacing="0" width="100%" border="0"
							style="margin-top: 10px;">
							<tr class="table_lista">
								<td style="border-top-left-radius: 5px;text-align:left;padding-left:20px;">保单信息</td>
							</tr>
							<tr>
								<td style="border-top-left-radius: 5px;text-align:center;padding-left:20px;">
									<font style="font-size:100px;color:#999">未<br>投<br>保</font>
								</td>
							</tr>
						</table>
					</c:if>
				</div>

				<div style="width:49.5%;float:right;">
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
						<tr>
							<td style="border-bottom:#9CF 1px solid;">重大危险源：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><span
								style="display:inline-block;width:120px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">${userCorp.SOU
									}</span> <a class="table_buttona"
								style="width:80px; border-radius:5px;padding:5px 10px;color:white;"
								name="source" id="source"
								href="javascript:showDiv1('${userCorp.USERCODE }','source');">
									详情</a></td>
						</tr>
						<tr>
							<td style="border-bottom:#9CF 1px solid;">评估内容：</td>
							<td style="border-bottom:#9CF 1px solid;text-align:left;"><span
								style="display:inline-block;width:120px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">${userCorp.CONTENT
									}</span> <a class="table_buttona"
								style="width:80px; border-radius:5px;padding:5px 10px;color:white;"
								name="content" id="content"
								href="javascript:act('${userCorp.USERCODE }');"> 详情</a></td>
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