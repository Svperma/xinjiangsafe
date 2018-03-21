<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<!--[if lt IE 7]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE7.js">IE7_PNG_SUFFIX=".png";</script>
<![endif]-->
<!--[if lt IE 8]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE8.js">IE7_PNG_SUFFIX=".png";</script>
<![endif]-->
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js">IE7_PNG_SUFFIX=".png";</script>
<![endif]-->
<title>安全生产责任保险服务信息平台</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<script type="text/javascript" language="JavaScript"></script>
<script type="text/javascript" src="${basePath }/js/jquery.min.js"></script>
<%-- <script type="text/javascript" src="${basePath }/js/index.js"></script> --%>
<link rel="stylesheet" href="${basePath }/css/xm1.css">
<link rel="stylesheet" href="${basePath }/css/style_index.css">
</head>
<body>
	<header>
	<div class="img_1">
        <jsp:include page="${basePath }/news/biaoti.jsp"></jsp:include>
	</div>
	</header>
	<nav>
	<div class="nav_1">
		<div class="nav_1_img">
			<center>
				<div class="demo">
					<!-- <a  class="control prev" id="aLeft"></a>
					<a class="control next abs" id="aRight"></a> -->
					<div class="slider">
						<ul>
							<c:forEach items="${sessionScope.newPhotoList }" var="newsphoto">
								<c:if test="${newsphoto.DOCTYPE == '5' }">
									<li>
										<a href="${basePath }/newsDetail?id=${newsphoto.DOCID}&docType=${newsphoto.DOCTYPE}&docDate=${newsphoto.PUBLISHDATE}">
											<img src="${newsphoto.IMAGEPATH }" alt="${newsphoto.TITLE }" />
										</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
				<script src="js/jquery.min.js"></script>
				<script src="js/YuxiSlider.jQuery.min.js"></script>
				<script>
				$(".slider").YuxiSlider({
					width:585, //容器宽度
					height:360, //容器高度
					control:$('.control'), //绑定控制按钮
					during:3000, //间隔1.5秒自动滑动
					speed:800, //移动速度0.8秒
					mousewheel:true, //是否开启鼠标滚轮控制
					direkey:true //是否开启左右箭头方向控制
				});
				</script>
			</center>
			
		</div>
		<div class="nav_1_new" style="height: 360px;">
			<div class="nav_1_new_bt">
				<span style="display:block;float:left;margin-top:0px;">新闻动态 </span>
				<a href="${basePath }/newsLookUp?docType=1" id="article_more" style="margin-top:5px;">查看更多>></a>
			</div>
			<div style="clear:both;"></div>
			<ul style="height: 320px;">
				<c:forEach items="${sessionScope.newsList }" var="news">
					<c:if test="${news.DOCTYPE == '1' }">
						<li style="text-overflow : ellipsis;white-space:nowrap;">
							<a style="overflow:hidden;white-space:nowrap;
								display:block;width:70%;float:left;margin-top: 1px;"
								href="${basePath }/newsDetail?id=${news.DOCID}&docType=${news.DOCTYPE}&docDate=${news.PUBLISHDATE}"
								target="_blank">${news.TITLE } 
							</a>
							<span style="display:block;float:right;">
								<fmt:formatDate value="${news.PUBLISHDATE }" pattern="yyyy-MM-dd" />
							</span>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>

	</div>
	<div class="login" style="height: 160px;">
		<a href="login.jsp" target="_blank"><div class="login_left">
				<br>安全生产责任保险监管平台
				<p>（监管用户登录）</p>
			</div></a> <a href="login2.jsp" target="_blank"><div
				class="login_right">
				<br>安全生产责任保险服务平台
				<p>（企业、保险公司登录）</p>
			</div></a> <%-- <a href="${basePath }/news/gongzhongfuwu.jsp" target="_blank"><div
				class="login_left">
				<br>公众服务
				<p>（社会查询、安全导航）</p>
			</div></a> <a href="login.jsp?type=3" target="_blank"><div
				class="login_right">
				<br>金融服务
				<p>（基金、贷款等）</p>
			</div></a> --%>
	</div>
	<form action="" enctype="multipart/form-data" method="post" name="fom">
	<div style="width:1170px;margin:0 auto;height:50px;border:1px solid #ccc;">
		<div style="width:20%;height:100%;float:left;color:#fff;font-size:20px;line-height:50px;text-align:center;background:#00a6e3;">公共查询</div>
		<div style="width:70%;height:100%;float:left;">
			<input placeholder="请输入身份证号码" type="text" id="widedaima" name="widedaima" style="width:100%;height:100%;outline:none;border:0px;"/>
		</div>
		<div style="width:10%;height:100%;float:right;background:#289626;">
			<a onclick="goLook()" type="buttun" style="cursor:pointer;display:block;width:90%;height:100%;color:#fff;font-size:20px;line-height:50px;text-align:center;">搜索</a>
		</div>
		<div style="clear:both;"></div>
	</div>
	</form>
	<div class="content_1">
		<div class="regulations" style="height: 350px;">
			<div id="regulations_title">
				&nbsp;政策法规 <a href="${basePath }/newsLookUp?docType=2" id="more">查看更多>></a>
			</div>
			<!--政策法规政策法规政策法规政策法规政策法规政策法规政策法规-->
			<ul style="height: 320px;">
			<c:forEach items="${sessionScope.newsList }" var="news">
				<c:if test="${news.DOCTYPE == '2' }">
				<li style="text-overflow : ellipsis;white-space:nowrap;overflow: hidden;padding-left: 20px;padding-top: 5px;">
					<a style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 1px;"
						href="${basePath }/newsDetail?id=${news.DOCID}&docType=${news.DOCTYPE}&docDate=${news.PUBLISHDATE}"
						class="title">${news.TITLE }
						<span style="float:right;padding-top: 5px;">
								<fmt:formatDate value="${news.PUBLISHDATE }" pattern="yyyy-MM-dd" />
							</span>
						</a>
				</li>
				</c:if>
			</c:forEach>
			</ul>
		</div>
		<div class="specialReport" style="height: 350px;">
			<!--专题报道专题报道专题报道专题报道专题报道专题报道专题报道专题报道-->

			<div id="specialReport_report">
				&nbsp;专题报道<a href="${basePath }/newsLookUp?docType=3"
					id="specialReport_report_more">查看更多>></a>
			</div>
			<c:set var="zindex" value="0"></c:set>
			<c:forEach items="${sessionScope.newsList }" var="news"
				varStatus="st">
				<c:if test="${news.DOCTYPE == '3' }">
					<img id="report_img${zindex +1 }" src="${news.IMAGEPATH }">
					<div id="report${zindex +1 }">
						<a style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 2px;"
							href="${basePath }/newsDetail?id=${news.DOCID}&docType=${news.DOCTYPE}&docDate=${news.PUBLISHDATE}"
							target="_blank" class="report_report">${news.TITLE }</a>
							<br>
							${news.DOCCONTENT }... 
							<br>
							<a style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 2px;"
							href="${basePath }/newsDetail?id=${news.DOCID}&docType=${news.DOCTYPE}&docDate=${news.PUBLISHDATE}"
							target="_blank" class="input">了解更多>></a>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<div class="content_2">
		<div class="publicEngagement" style="height: 350px;">
			<div id="publicTitle">
				&nbsp;常见问题<a href="${basePath }/news/inPublicLookUp.html" id="publicTalk_more">查看更多>></a>
			</div>
				<span>
					<a href="${basePath }/news/inPublicLookUp.html" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 20px;">
						<span class="letter" style="font-size: 16px;">&nbsp;问：</span>保单什么时候给我送过来啊？
					</a>
				</span>
				<span>
				<a href="${basePath }/news/inPublicLookUp.html" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
					display:block;width:100%;float:left;margin-top: 20px;">
					<span class="letter1" style="font-size: 16px;">&nbsp;答：</span>
					过两天就给您送过去了，请耐心等待
				</a>
				</span>
				<span>
					<a href="${basePath }/news/inPublicLookUp.html" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 20px;">
						<span class="letter" style="font-size: 16px;">&nbsp;问：</span>投保后保单我什么时候才能收到？
					</a>
				</span>
				<span>
				<a href="${basePath }/news/inPublicLookUp.html" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
					display:block;width:100%;float:left;margin-top: 20px;">
					<span class="letter1" style="font-size: 16px;">&nbsp;答：</span>
					您在成功支付保费后，会由您当地保险公司在1个工作日内出具保单，快递到您所登记的地址，具体到达时间视快递公司的物流速度。
				</a>
				</span>
				<span>
					<a href="${basePath }/news/inPublicLookUp.html" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 20px;">
						<span class="letter" style="font-size: 16px;">&nbsp;问：</span>在你们网上支付安全吗？
					</a>
				</span>
				<span>
				<a href="${basePath }/news/inPublicLookUp.html" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
					display:block;width:100%;float:left;margin-top: 20px;">
					<span class="letter1" style="font-size: 16px;">&nbsp;答：</span>
					网上支付是通过国内各大银行的支付网关进行操作的，安全性完全有保证。
				</a>
				</span>
				<span>
					<a href="${basePath }/news/inPublicLookUp.html" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 20px;">
						<span class="letter" style="font-size: 16px;">&nbsp;问：</span>通过网上支付以后你们怎么知道是我支付的呢？会不会搞错？
					</a>
				</span>
				<span>
				<a href="${basePath }/news/inPublicLookUp.html" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
					display:block;width:100%;float:left;margin-top: 20px;">
					<span class="letter1" style="font-size: 16px;">&nbsp;答：</span>
					通过线上支付您首先是在缴费查询中查询到投保单勾选要缴费订单之后再链接到银行支付系统的，系统会自动生成一个唯一的支付订单号，用于识别支付对象，
				所以是不会弄错的，请您放心。
				</a>
				</span>
		</div>
		<%-- <div class="publicEngagement" style="height: 350px;">
			<div id="publicTitle">
				&nbsp;公众参与<a href="${basePath }/publicLookUp" id="publicTalk_more">查看更多>></a>
			</div>
			<c:forEach items="${sessionScope.pagination.resultList }"
				var="ggEvalute" begin="0" end="3">
				<span><a href="${basePath }/publicLookUp" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 2px;"><span
						class="letter">&nbsp;问：</span>${ggEvalute.content }</a></span>
				<br>
				<c:forEach items="${ggEvalute.list }" var="del">
					<span><a href="${basePath }/publicLookUp" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 2px;"><span
							class="letter1">&nbsp;答：</span>${fn:substring(del.content,0,50)
							}...</a></span>
					<br>
				</c:forEach>
			</c:forEach>
		</div> --%>
		<div class="example_case" style="height: 350px;">
			<!--案例分析-->
			<div id="example_case">
				&nbsp;案例分析<a href="${basePath }/newsLookUp?docType=4" id="case_more">查看更多>></a>
			</div>
			<c:set value="0" var="aindex"></c:set>
			<c:forEach items="${sessionScope.newsList }" var="news"
				varStatus="st">
				<c:if test="${news.DOCTYPE == '4' }">
					<img id="case_img${aindex+1 }" src="${news.IMAGEPATH }">
					<div id="case${aindex+1 }">
						<a style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 2px;"
							href="${basePath }/newsDetail?id=${news.DOCID}&docType=${news.DOCTYPE}&docDate=${news.PUBLISHDATE}"
							target="_blank" class="case_report"> ${news.TITLE } </a><br>${news.DOCCONTENT
						}... <br> <a style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;
								display:block;width:100%;float:left;margin-top: 2px;"
							href="${basePath }/newsDetail?id=${news.DOCID}&docType=${news.DOCTYPE}&docDate=${news.PUBLISHDATE}"
							target="_blank" class="input">了解更多>></a>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	</nav>
	<style>
#tab-css a {
	display: inline-block;
	width: 113px;
	text-align: center;
}
</style>
<jsp:include page="${basePath }/news/footer.jsp"></jsp:include>
<script type="text/javascript">
	function goLook(){
		fom.action = "${basePath}/wtmtmtba";
		fom.submit();
	}
</script>
</body>
</html>
