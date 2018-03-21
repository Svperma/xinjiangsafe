<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="gc"%>
<jsp:include page="${basePath }/common/include.jsp" />
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

<title>My JSP 'claimInfoResult.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.td_bottom {
	border-bottom: 1px solid #D5EDEE;
}

.td_right {
	border-bottom: 1px solid #D5EDEE;
	border-right: 1px solid #D5EDEE;
}
</style>

</head>

<body>
	<div class="neicont_main_left_cont">
		<div class="neicont_imga">
			<img src="images/icotit2.jpg">赔案清单
		</div>
		<div class="neicont_main_left_cont_main" align="center">
			<table cellpadding="0" cellspacing="0" width="80%" border="0"
				style="margin-top: 10px;">
				<tr class="">
					<td
						style="border-top-left-radius: 5px;border-top-right-radius: 5px;text-align:center;"
						colspan="4"><c:if
							test="${sessionScope.detailMap.STATUS == '1' }">
							<img src="images/baoan.png" />
							<img src="images/jiantou_b.jpg" />
							<img src="images/dingsun_b.jpg" />
							<img src="images/jiantou_b.jpg" />
							<img src="images/lipei_b.jpg" />
							<img src="images/jiantou_b.jpg" />
							<img src="images/jiean_b.jpg" />
						</c:if> <c:if test="${sessionScope.detailMap.STATUS == '3' }">
							<img src="images/baoan.png" />
							<img src="images/jiantou.png" />
							<img src="images/dingsun.png" />
							<img src="images/jiantou_b.jpg" />
							<img src="images/lipei_b.jpg" />
							<img src="images/jiantou_b.jpg" />
							<img src="images/jiean_b.jpg" />
						</c:if> <c:if test="${sessionScope.detailMap.STATUS == '4' }">
							<img src="images/baoan.png" />
							<img src="images/jiantou.png" />
							<img src="images/dingsun.png" />
							<img src="images/jiantou.png" />
							<img src="images/lipei.png" />
							<img src="images/jiantou_b.jpg" />
							<img src="images/jiean_b.jpg" />
						</c:if> <c:if test="${sessionScope.detailMap.STATUS == '6' }">
							<img src="images/baoan.png" />
							<img src="images/jiantou.png" />
							<img src="images/dingsun.png" />
							<img src="images/jiantou.png" />
							<img src="images/lipei.png" />
							<img src="images/jiantou.png" />
							<img src="images/jiean.png" />
						</c:if></td>
				</tr>
				<tr class="table_lista">
					<td colspan="4" align="center">详情</td>
				</tr>
				<tr>
					<td align="center" class="td_bottom" style="width:15%;">企业名称：</td>
					<td style="width:35%;" class="td_right">${sessionScope.detailMap.COMPANYNAME
						}</td>
					<td align="center" class="td_bottom" style="width:15%;">报案时间：</td>
					<td class="td_bottom"><fm:formatDate
							value="${sessionScope.detailMap.BAOANDATE }" pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<td align="center" class="td_bottom">联系人：</td>
					<td class="td_right">${sessionScope.detailMap.COMPANYNAME }</td>
					<td align="center" class="td_bottom">联系方式：</td>
					<td class="td_bottom">${sessionScope.detailMap.TELEPHONE }</td>
				</tr>
				<tr>
					<td align="center" class="td_bottom">企业地址：</td>
					<td colspan="3" class="td_bottom">${sessionScope.detailMap.COMPANYADDRESS
						}</td>
				</tr>
				<tr>
					<td align="center" class="td_bottom">承保公司：</td>
					<td class="td_right"><gc:name
							codeCode="${sessionScope.detailMap.INSURERCODE }"
							codeType="CICompanycode"></gc:name></td>
					<td align="center" class="td_bottom">援助金(万元)：</td>
					<td class="td_bottom">${sessionScope.detailMap.ASSISTANCE/10000
						}</td>
				</tr>
				<tr>
					<td align="center" class="td_bottom">事故原因：</td>
					<td colspan="3" class="td_bottom">${sessionScope.detailMap.LOSSCAUSE
						}</td>
				</tr>
				<tr>
					<td align="center" class="td_bottom">损失情况：</td>
					<td class="td_bottom" colspan="3">${sessionScope.detailMap.LOSSDETAIL
						}</td>
				</tr>
				<tr>
					<td align="center" class="td_bottom">损失金额(万元)：</td>
					<td class="td_right">${sessionScope.detailMap.LOSSAMOUNT }</td>
					<td align="center" class="td_bottom">已决赔款(万元)：</td>
					<td class="td_bottom">${sessionScope.detailMap.PAYAMOUNT }</td>
				</tr>
				<tr>
					<td align="center" class="td_bottom">未决赔款(万元)：</td>
					<td class="td_bottom">${sessionScope.detailMap.LOSSAMOUNT -
						sessionScope.detailMap.PAYAMOUNT }</td>
					<td class="td_bottom"></td>
					<td class="td_bottom"></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td align="center">
						<div class="select_list" style="margin:0px auto;">
							<a href="javascript:window.history.go(-1);">返回</a>
						</div>
					</td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
