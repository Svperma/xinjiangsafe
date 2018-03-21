<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>安全生产责任保险服务信息平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		frame{
			margin:0px 20px;
			padding:0px 0px;
		}
	</style>
  </head>
    <frameset name="frame"  frameborder="no" framespacing="1" id="frameMain" rows="96,*" >
    	<frame name="topFrame" id="topFrame" src="${basePath }/common/top.jsp" scrolling="no"></frame>
    	<frameset frameborder="no" framespacing="1" id="" cols="225,*" scrolling="auto">
    		<frame src="${basePath }/common/menu.jsp" scrolling="no"></frame>
    		<frame name="mainFrame" id="mainFrame" scrolling="auto" src="${basePath }/jianguan/publisher/publishCondition.jsp" marginheight="10px"/>
    	</frameset>
    </frameset>
</html>
