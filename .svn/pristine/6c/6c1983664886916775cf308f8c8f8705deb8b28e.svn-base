<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'dangerSource.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<link type="text/css" rel="stylesheet"
	href="${basePath }/jianguan/jsp/box/jquery-ui.css">
<link type="text/css" rel="stylesheet" href="${basePath }/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${basePath }/jianguan/jsp/box/jquery.multiselect.css">
<script type="text/javascript"
	src="${basePath }/jianguan/jsp/box/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="${basePath }/jianguan/jsp/box/jquery.multiselect.js"></script>
<style>
#uboxstyle div.tag_select {
	display: block;
	color: #474747;
	width: 300px;
	height: 27px;
	background-color: #f5f5f5;
	padding: 0px;
	line-height: 27px;
	background-image: url(../images/select_backa.jpg);
	background-repeat: no-repeat;
	border-radius: 5px;
	background-position: 105px 10px;
}

#uboxstyle div.tag_select_hover {
	display: block;
	color: #474747;
	width: 300px;
	height: 27px;
	background-color: #f5f5f5;
	padding: 0px;
	line-height: 27px;
	background-image: url(../images/select_backa.jpg);
	background-repeat: no-repeat;
	border-radius: 5px;
	background-position: 105px 10px;
}

#uboxstyle div.tag_select_open {
	display: block;
	color: #474747;
	width: 300px;
	height: 27px;
	background-color: #f5f5f5;
	padding: 0px;
	line-height: 27px;
	background-image: url(../images/select_backb.jpg);
	background-repeat: no-repeat;
	border-radius: 5px;
	background-position: 105px 10px;
}

#uboxstyle ul.tag_options li {
	display: block;
	width: 300px;
	height: 27px;
	text-decoration: none;
	line-height: 27px;
	color: #79A2BD;
	border-radius: 5px;
}
</style>
</head>
<body>
	<form action="${basePath }evaluateDangers/riskRatingInsert"
		method="POST" name="fm" style="position:relative;"
		enctype="multipart/form-data">
		<div style="padding-left:30px;float:left;">
			<img src="images/icotit2.jpg" width="40" height="40"> 
			<input type="hidden" value="${userCorpDangerSource.USERCODE }" name="userCode" id="userCode"> 
			<input type="hidden" value="${userCorpDangerSource.CLASSCODE }" name="CLASSCODE" id="CLASSCODE"> 
			<input type="hidden" value="${userCorpDangerSource.COMPANYNAME }" name="COMPANYNAME" id="COMPANYNAME"> 
			<span>企业名称：${userCorpDangerSource.COMPANYNAME}</span> 
			<span>企业类型： <tlds:name codeType="IndustryCategories" codeCode="${userCorpDangerSource.CLASSCODE }" />
			</span>
		</div>
		<div class="neicont_main_left_cont_main">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;">
				<tr class="table_lista">
					<td style="border-top-left-radius: 5px;" width="150px">序号</td>
					<td colspan="5">重大危险源</td>
				</tr>
				<tr id="1">
					<!-- 这里是id -->
					<td>1</td>
					<!-- 危险源 -->
					<td colspan="5"><input id="source" name="source" type="text"
						style="width:98%;"></td>
				</tr>
				<tr>
					<td>评估概述：</td>
					<td colspan="6"><textarea rows="5" style="width:100%;"
							name="content" id="content"></textarea></td>
				</tr>
				<tr>
					<td>评估资料上传：</td>
					<td colspan="6" align="left"><input type="file"
						name="evaluationData" id="evaluationData"></td>
				</tr>
				<tr>
					<td>综合评定：</td>
					<td colspan="1"><div class="select_list">
							<div id="uboxstyle">
								<select name="riskLevel" id="riskLevel">
									<option value="0">合格</option>
									<option value="1">不合格</option>
								</select>
							</div>
						</div></td>
					<td>评估时间：</td>
					<td colspan="1">
						<!-- 评估时间 -->
						<div class="select_list" style="width: 200px;">
							<input class="select_list_inputa" type="text" maxlength="20"
								value="请输入评估日期" name="EvaDate" id="evaluatDate"
								onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onblur="if(!value){value=defaultValue;this.style.color='#999'}"
								onclick="WdatePicker({maxDate: new Date(),isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
								style="color: rgb(153, 153, 153);">
						</div>
					</td>
				</tr>
				<tr>
					<td>整改意见：</td>
					<td colspan="6"><textarea rows="5" style="width:100%;"
							name="statusContent" id="statusContent"></textarea></td>
				</tr>
				<tr>
					<td>评估机构：</td>
					<td>
						<div class="select_list"
							onclick="moveGrade('orgname','grade','registration');getPersons('orgname','example');changeSelect();"
							style="width:300px;">
							<div id="uboxstyle">
								<select id="orgname" name="orgname">
									<option value="">请选择机构</option>
									<c:forEach items="${sessionScope.map_govOrgan }" var="govOrgan"
										varStatus="listSize">
										<option value="${govOrgan.ORGCODE }">
											${govOrgan.ORGNAME }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</td>
					<td>机构等级：</td>
					<td colspan="1">
						<div class="select_list">
							<div id="uboxstyle">
								<select id="grade" name="grade">
									<option value="">请选择机构等级</option>
									<c:forEach items="${sessionScope.map_govOrgan }" var="govOrgan"
										varStatus="listSize">
										<option value="${govOrgan.GRADE }">
											<c:if test="${govOrgan.GRADE eq 'A'}">甲级</c:if>
											<c:if test="${govOrgan.GRADE eq 'B'}">乙级</c:if>
											<c:if test="${govOrgan.GRADE eq 'C'}">丙级</c:if>
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>评估人员姓名：</td>
					<td colspan="1">
						<div class="select_list">
							<input type="text" id="person" name="person" value="请选择评估人"
								onclick="changeSelect()"
								style="outline: none;border:1px solid #ededed;">
							<div id="exName"
								style="border:1px solid #ededed; border-radius:2px;text-align:left;display:none;">
								<a href="javascript:void()" id="exName-a">确定</a>
							</div>
							<input type="hidden" id="hfexample" name="hfexample" />
						</div>
					</td>
					<td>注册证号：</td>
					<td><input class="select_list_inputa" type="text"
						maxlength="20" value="请输入注册证号" name="registration"
						id="registration"
						onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						style="color: rgb(153, 153, 153);"></td>
				</tr>
			</table>
			<div class="pages">
				<ul>
					<li><a href="javascript:submitFm();">提交</a></li>
					<li><a href="javascript:history.go(-1);">返回</a></li>
				</ul>
			</div>
		</div>
	</form>
</body>
<script>
	function hide(id) {
		document.getElementById(id).style.display = "none";
	}//关闭按钮
	function onAdd(o, showId, delId) {
		document.getElementById(o).style.display = "none";
		document.getElementById(showId).style.display = "";
		document.getElementById(delId).style.display = "";
	}
	function submitFm() {
		var source = document.getElementById("source").value;
		var content = document.getElementById("content").value;
		var evaluationData = document.getElementById("evaluationData").value;
		var evaluatDate = document.getElementById("evaluatDate").value;
		var statusContent = document.getElementById("statusContent").value;
		var orgname = document.getElementById("orgname").value;
		var person = document.getElementById("person").value;
// 		if (source == "") {
// 			source = window.confirm("确定无危险源？");
// 			if (source == true) {
				if (content == "") {
					alert("请添加评估概述");
					return false;
				} else if (evaluationData == "") {
					alert("请选择评估资料");
					return false;
				} else if (evaluatDate == "请输入评估日期") {
					alert("请输入评估日期");
					return false;
				}if (orgname == "") {
							alert("请选择评估机构");
							return false;
						} else if (person == "请选择评估人") {
							alert("请选择评估人");
							return false;
						} else {
							var url = "${basePath}/evaluateDangers/riskRatingInsert";
							var form = document.forms["fm"];
							form.action = url;
							form.submit();
						} 
// 						else if (statusContent == "") {
// 					statusContent = window.confirm("确定无整改意见？");
// 					if (statusContent == true) {
// 						if (orgname == "") {
// 							alert("请选择评估机构");
// 							return false;
// 						} else if (person == "请选择评估人") {
// 							alert("请选择评估人");
// 							return false;
// 						} else {
// 							var url = "${basePath}/evaluateDangers/riskRatingInsert";
// 							var form = document.forms["fm"];
// 							form.action = url;
// 							form.submit();
// 						}
// 					}
// 				} else {
// 					return false;
// 				}
// 			}
// 			return false;
// 		} else if (content == "") {
// 			alert("请添加评估概述");
// 			return false;
// 		} else if (evaluationData == "") {
// 			alert("请选择评估资料");
// 			return false;
// 		} else if (evaluatDate == "请输入评估日期") {
// 			alert("请输入评估日期");
// 			return false;
// 		} else if (statusContent == "") {
// 			statusContent = window.confirm("确定无整改意见？");
// 			if (statusContent == true) {
// 				if (orgname == "") {
// 					alert("请选择评估机构");
// 					return false;
// 				} else if (person == "请选择评估人") {
// 					alert("请选择评估人");
// 					return false;
// 				} else {
// 					var url = "${basePath}/evaluateDangers/riskRatingInsert";
// 					var form = document.forms["fm"];
// 					form.action = url;
// 					form.submit();
// 				}
// 			}
// 		} else {
// 			var url = "${basePath}/evaluateDangers/riskRatingInsert";
// 			var form = document.forms["fm"];
// 			form.action = url;
// 			form.submit();
// 		}

	}
</script>
<script type="text/javascript">
	function Tgbim() {
		var a1 = document.getElementById("div1x1");
		a1.style.display = "block";
	}
	function moveGrade(parentId, grade, registration) {
		var obj = document.getElementById(parentId).value;
		$
				.ajax({
					type : "post",
					url : "${basePath}/evaluateDangers/getGare",
					data : JSON.stringify({
						"orgname" : obj
					}),
					dataType : "json",
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						$("#" + grade).empty();
						$("#options_" + grade).empty();
						for ( var i = 0; i < data.length; i++) {
							var item = data[i];
							var li = document.createElement("li");
							var op = document.createElement("option");
							op.value = item.GRADE;
							op.value = item.REGISTRATION;
							var display = "";
							if (item.REGISTRATION != null) {
								$("#" + registration).val(item.REGISTRATION)
							}
							if (item.GRADE == "1") {
								op.text = "甲级";
								li.innerHTML = "甲级";
								display = "甲级";
							} else if (item.GRADE == "2") {
								op.text = "乙级";
								li.innerHTML = "乙级";
								display = "乙级";
							} else if (item.GRADE == "3") {
								op.text = "丙级";
								li.innerHTML = "丙级";
								display = "丙级";
							}else if (item.GRADE == "4") {
								op.text = "丁级";
								li.innerHTML = "丁级";
								display = "丁级";
							}
							$("#options_" + grade).append(li);
							$("#" + grade).append(op);
							if (i == 0) {
								document.getElementById("select_info_" + grade).innerHTML = display;
								document.getElementById(registration).innerHTML = display;
							}
						}
					},
					error : function() {
						alert("系统异常请重试!");
					}
				});
	}
	function getPersons(parentId, example) {
		var obj = document.getElementById(parentId).value;
		$
				.ajax({
					type : "post",
					url : "${basePath}/evaluateDangers/getPersons",
					data : JSON.stringify({
						"orgname" : obj
					}),
					dataType : "json",
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						$(".ui-multiselect-checkboxes li").remove();
						var ckb;
						var p;
						var span;
						var div = document.getElementById("exName");
						for ( var i = 0; i < data.length; i++) {
							var item = data[i];
							ckb = document.createElement("input");
							ckb.type = "checkbox";
							p = document.createElement("p");
							span = document.createElement("span");
							span.id = item.expcode;
							ckb.value = item.expcode;
							ckb.onclick = function() {
								var val = this.value;
								var hiddenInp = document
										.getElementById("hfexample");
								var hiddenVal = hiddenInp.value.replace(
										"请选择评估人", "");
								var spanText = document
										.getElementById(this.value).innerHTML;
								var person = document.getElementById("person");
								var personValue = person.value;
								if (this.checked) {
									if (hiddenVal.length == 0) {
										hiddenInp.value = this.value;
										person.value = spanText;
									} else {
										hiddenInp.value = hiddenVal + ";"
												+ this.value;
										person.value = personValue + ";"
												+ spanText;
									}
								} else {
									var strs = hiddenVal.split(";");
									var result = "";
									for ( var i = 0; i < strs.length; i++) {
										var str = strs[i];
										if (str != this.value) {
											result += str + ";";
										}
									}
									var persons = personValue.split(";");
									var result1 = "";
									for ( var i = 0; i < persons.length; i++) {
										var per = persons[i];
										if (per != spanText) {
											result1 += per + ";";
										}
									}
									hiddenInp.value = result.substring(0,
											result.length - 1);
									person.value = result1.substring(0,
											result1.length - 1);
								}
							}
							span.innerHTML = item.exName;
							p.appendChild(ckb);
							p.appendChild(span);
							div.appendChild(p);
						}
					},
					error : function() {
						alert("系统异常请重试!");
					}
				});
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#person").click(function() {
			$("#exName").css("display", "block")
		})
	})
	$(document).ready(function() {
		$("#exName-a").click(function() {
			$("#exName").css("display", "none")
		})
	})
</script>
<script type="text/javascript">
	function changeSelect() {
		$("#example").multiselect({
			header : false,
			height : 100,
			minWidth : 100,
			selectedList : 10,//预设值最多显示10被选中项
			hide : [ "explode", 500 ],
			noneSelectedText : '请选择评估人',
			close : function() {
				var values = $("#example").val();
				$("#hfexample").val(values);
			}
		});
	}
</script>
</html>
