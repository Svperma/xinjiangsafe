<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="menu">
	<ul style="margin-top: -10px;">
		<li><a href="${basePath }/">首页</a></li>
		<li><a href="${basePath }/newsLookUp?docType=1">新闻动态</a></li>
		<li class="bg_li"><a href="${basePath }/newsLookUp?docType=2">政策法规</a></li>
		<li><a href="${basePath }/newsLookUp?docType=3">专题报道</a></li>
		<%-- <li><a href="${basePath }/publicLookUp">公众参与</a></li> --%>
		<li><a href="${basePath }/news/inPublicLookUp.html">常见问题</a></li>
		<li class="bg_li"><a href="${basePath }/newsLookUp?docType=4">案例分析</a></li>
	</ul>
</div>