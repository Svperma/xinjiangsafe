<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'mypolicymain.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="qiyecss/stylesheet.css">
<script type="text/javascript" src="js/select2css.js"></script>

</head>

<body>
	<div class="maincont">
		<div class="neicont_main_left_cont">
			<div class="neicont_main_left_cont_main">
				<form action="${basePath }/policyUser/mypolicyqueryPolicy" name="mypolicy"
					method="post" target="resultFrame">
					<input id="insuredcode" name="insuredcode"
						class="select_list_inputa" type="text" maxlength="20"
						value="请输入被保险人"
						onfocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onblur="if(!value){value=defaultValue;this.style.color='#999'}"
						style=" height: 28px; color: rgb(153, 153, 153);">
						<div class="select_list" style="width: 200px;">
							<div id="uboxstyle">
								<select name="languagec" id="languagec">
									<option value="">请选择出单状态</option>
									<option value="1">已出单</option>
									<option value="2">审核不通过</option>
								</select>
							</div>
						</div>
					<div class="select_list" style="margin-left:10px;">
						<a href="javascript:submitmypolicy();">查询</a>
					</div>
				</form>
				<iframe name="resultFrame" src="/policyUser/mypolicyqueryPolicy"
					frameborder="0" style="width:100%;height:80%;"></iframe>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function submitmypolicy() {
		document.forms["mypolicy"].submit();
	}
</script>
</html>
