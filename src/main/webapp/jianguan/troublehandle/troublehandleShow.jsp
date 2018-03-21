<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>

<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>事故处理中心</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/select2css.js"></script>
</head>
<body>
	<div class="neicont_main">
		<div class="neicont_main_left_cont">
			<div class="neicont_imga">
				<img src="${basePath }/images/icotit2.jpg">事故查询
			</div>
			<div class="neicont_main_left_cont_main">
				<table cellpadding="0" cellspacing="0" width="100%" border="0"
					style="margin-top: 10px;">
					<tr class="table_lista">
						<td
							style="border-top-left-radius: 5px;text-align:left;padding-left:20px;"
							colspan="7">处理结果</td>
						<td style="border-top-right-radius: 5px;"></td>
					</tr>
					<tr class="table_listb">
						<td colspan="8"></td>
					</tr>
					<tr>
						<td colspan="2" width="25%" style="border:1px solid #CADEDF;">企业名称：</td>
						<td colspan="6"
							style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
							${gtaccident.USERCODE }</td>
					</tr>
					<tr>
						<td colspan="8"></td>
					</tr>
					<tr>
						<td colspan="2" rowspan="4" style="border:1px solid #CADEDF;">事故原因：</td>
						<td colspan="6" rowspan="4"
							style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
							${gtaccident.CAUSE }</td>
					</tr>
					<tr>
						<td colspan="8"></td>
					</tr>
					<tr>
						<td colspan="8"></td>
					</tr>
					<tr>
						<td colspan="8"></td>
					</tr>
					<tr>
						<td colspan="8"></td>
					</tr>
					<tr>
						<td colspan="2" rowspan="4" style="border:1px solid #CADEDF;">损失状况：</td>
						<td colspan="6" rowspan="4"
							style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
							${gtaccident.LOSS }</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2" style="border:1px solid #CADEDF;">案件负责人：</td>
						<td colspan="6"
							style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
							${gtaccident.DEALER }</td>
					</tr>
					<tr>
						<td colspan="2" style="border:1px solid #CADEDF;">案件发生时间：</td>
						<td colspan="6"
							style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
							<fmt:formatDate value="${gtaccident.HAPPENDATE }"
								pattern="yyyy-MM-dd hh:mm:ss" />
						</td>
					</tr>
					<tr>
						<td colspan="2" rowspan="4" style="border:1px solid #CADEDF;">最终意见：</td>
						<td colspan="6" rowspan="4"
							style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
							${gtaccident.ADVICE }</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="8"><a class="table_buttonb"
							href="javascript:history.go(-1);">返回</a>
							</div></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>