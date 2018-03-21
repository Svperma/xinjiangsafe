<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>安全生产责任保险服务信息平台</title>
<style type="text/css">
frame {
	margin: 0px 20px;
	padding: 0px 0px;
}
</style>
</head>
<frameset frameborder="no" framespacing="0" id="frameMain"
	rows="96,*,100">
	<frame name="topFrom" id="topFrom"
		src="${basePath }/policyUser/top.jsp" scrolling="no"></frame>
	<frameset frameborder="no" framespacing="1" id="" cols="185,*"
		scrolling="no">
		<frame src="${basePath }/policyUser/menu.jsp" marginheight="10px"
			scrolling="no"
			style="background-image:url(/images/main_back_y.jpg);background-repeat:repeat-x;background-color:#F1F1F1;padding-top:10px;"></frame>
		<frame src="${basePath }/policyUser/mypolicyCondition.jsp" name="mainFrame"
			scrolling="auto"
			style="background-image:url(/images/main_back_y.jpg);background-repeat:repeat-x;background-color:#F1F1F1;padding-top:10px;"></frame>
	</frameset>
	<frame src="${basePath }/enterprise/footer.jsp" scrolling="no"></frame>
</frameset>
</html>
