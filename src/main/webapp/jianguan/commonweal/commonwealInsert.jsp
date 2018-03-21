<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
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

<title>My JSP 'commonwealInsert.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/select2css.js"></script>
<script type="text/javascript" src="js/readXml.js"></script>
<jsp:include page="${basePath }/common/include.jsp" />
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="${basePath }/js/common.js"></script>
</head>

<body>
	<div class="neicont_main_left_cont">
		<div class="neicont_imga">
			<img src="images/icotit2.jpg">事故预防费使用
		</div>
		<div class="neicont_main_left_cont_main">
			<form action="${basePath }/weal/wealinsert" name="wealisert"
				method="post" enctype="multipart/form-data">
				<table cellpadding="0" cellspacing="0" width="70%" border="0"
					style="margin: 10px auto;">
					<tr class="table_lista">
						<td style="border-top-left-radius: 5px;" colspan="2">&nbsp;</td>
						<td style="border-top-right-radius: 5px;" colspan="2">&nbsp;</td>
					</tr>
					<tr class="table_listb">
						<td>项目名称：</td>
						<td>
							<div class="select_list" style="width: 200px;">
								<input name="languageh" id="languageh"
									class="select_list_inputa" type="text" maxlength="20" value=""
									onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);">
							</div>
						</td>
						<td>使用金额(元)：</td>
						<td>
							<div class="select_list" style="width: 200px;">
								<input name="PAYAMOUNTIN" id="PAYAMOUNTIN"
									class="select_list_inputa" type="text" maxlength="20" value=""
									onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);">
							</div>
						</td>
					</tr>
					<tr>
						<td>使用时间：</td>
						<td>
							<div class="select_list" style="width: 200px;">
								<input class="select_list_inputa" type="text" maxlength="20"
									value="请输入使用日期" name="beginDate" id="beginDate"
									onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									onclick="WdatePicker({isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})"
									style="color: rgb(153, 153, 153);">
							</div>
						</td>
						<td>项目负责人：</td>
						<td>
							<div class="select_list" style="width: 200px;">
								<input name="PRINCIPALIN" id="PRINCIPALIN"
									class="select_list_inputa" type="text" maxlength="20" value=""
									onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);">
							</div>
						</td>
					</tr>
					<tr>
						<td>使用单位：</td>
						<td>
							<div class="select_list" style="width: 200px;">
								<input id=ACCEPTORIN name="ACCEPTORIN"
									class="select_list_inputa" type="text" maxlength="20" value=""
									onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);">
							</div>
						</td>
						<td>收款银行：</td>
						<td>
							<div class="select_list" style="width: 200px;">
								<input id="DUEBANKIN" name="DUEBANKIN"
									class="select_list_inputa" type="text" maxlength="50" value=""
									onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);">
							</div>
						</td>
					</tr>
					<tr>
						<td>使用证明：</td>
						<td>
							<div class="select_list" style="width: 200px;">
								<input id="USERPROVEIN" name="USERPROVEIN"
									class="select_list_inputa" type="file">
							</div>
						</td>
						<td>收款账号：</td>
						<td>
							<div class="select_list" style="width: 200px;">
								<input id="SHROFFNUMBERIN" name="SHROFFNUMBERIN"
									class="select_list_inputa" type="text" maxlength="20" value=""
									onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
									onblur="if(!value){value=defaultValue;this.style.color='#999'}"
									style="color: rgb(153, 153, 153);">
							</div>
						</td>
					</tr>
				</table>
				<div
					style="clear:both;width:100%;padding-top:20px;;margin-bottom:10px;">
					<a href="javascript:history.go(-1);" class="table_buttonb"
						style="width:120px; border-radius:5px;padding:5px 30px;color:white;">返回</a>
					<a href="javascript:submitCommonweal();" class="table_buttonb"
						style="width:120px; border-radius:5px;padding:5px 30px;color:white;">提交</a>
				</div>
			</form>
			<div style="clear:both;"></div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		function addUser() {
			var div = $("#addUser");
			var divHeight = div.height();
			var divWidth = div.width();
			var divTop = ($(window).height() - divHeight) / 2;
			var divLeft = ($(window).width() - divWidth) / 2;
			div.css({
				"top" : divTop,
				"left" : divLeft,
				"display" : "block"
			});
		}
		function close() {
			$("#addUser").css({
				"display" : "none"
			});
		}
		function submitCommonweal() {
			var languageh = document.getElementById("languageh").value; //项目名称
			var PAYAMOUNTIN = document.getElementById("PAYAMOUNTIN").value; //使用金额
			var beginDate = document.getElementById("beginDate").value; //项目时间
			var PRINCIPALIN = document.getElementById("PRINCIPALIN").value; //项目负责人
			var ACCEPTORIN = document.getElementById("ACCEPTORIN").value; //使用单位
			var DUEBANKIN = document.getElementById("DUEBANKIN").value; //收款银行
			var USERPROVEIN = document.getElementById("USERPROVEIN").value; //使用证明
			var SHROFFNUMBERIN = document.getElementById("SHROFFNUMBERIN").value; //收款账号

			if (languageh == "" || languageh == null || languageh == "选择项目名称") {
				alert("项目名称不允许为空");
				return;
			}

			if (PAYAMOUNTIN == "" || PAYAMOUNTIN == null) {
				alert("使用金额不允许为空");
				return;
			}

			if (beginDate == "" || beginDate == null || beginDate == "请输入使用日期") {
				alert("使用时间不允许为空");
				return;
			}

			if (PRINCIPALIN == "" || PRINCIPALIN == null) {
				alert("项目负责人不允许为空");
				return;
			}

			if (ACCEPTORIN == "" || ACCEPTORIN == null) {
				alert("使用单位不允许为空");
				return;
			}

			if (DUEBANKIN == "" || DUEBANKIN == null) {
				alert("收款银行不允许为空");
				return;
			}

			if (USERPROVEIN == "" || USERPROVEIN == null
					|| USERPROVEIN == "未选择文件。") {
				alert("使用证书不允许为空");
				return;
			}

			if (SHROFFNUMBERIN == "" || SHROFFNUMBERIN == null) {
				alert("收款账号不允许为空");
				return;
			}

			if (languageh != "" && languageh != null && languageh != "选择项目名称"
					&& PAYAMOUNTIN && PAYAMOUNTIN != "" && PAYAMOUNTIN != null
					&& beginDate != "" && beginDate != null
					&& beginDate != "请输入使用日期" && PRINCIPALIN != ""
					&& PRINCIPALIN != null && ACCEPTORIN != ""
					&& ACCEPTORIN != null && DUEBANKIN != ""
					&& DUEBANKIN != null && USERPROVEIN != ""
					&& USERPROVEIN != null && USERPROVEIN != "未选择文件。"
					&& SHROFFNUMBERIN != "" && SHROFFNUMBERIN != null) {
				document.forms["wealisert"].submit();
			}
		}
	</script>
</body>
</html>
