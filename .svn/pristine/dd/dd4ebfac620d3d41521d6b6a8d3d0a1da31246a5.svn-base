<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="gc"%>
<jsp:include page="${basePath }/common/include.jsp" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'adminsitrationShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="${basePath }/js/common.js"></script>

</head>

<body>
	<input type="hidden" id="province"
		value="${sessionScope.ggUser.province }">
	<input type="hidden" id="city" value="${sessionScope.ggUser.city }">
	<input type="hidden" id="county" value="${sessionScope.ggUser.county }">
	<input type="hidden" id="comLevel"
		value="${sessionScope.ggUser.comLevel }">
	<div class="neicont_imga">
		<img src="${basePath }/images/icotit2.jpg">用户详细信息
	</div>
	<div class="neicont_main_left_cont_main">
		<form action="${basePath }/policyUser/adminupdate" method="post"
			name="AdminerShow">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;" align="center">
				<tr class="table_lista">
					<td
						style="border-top-left-radius: 5px;text-align:left;padding-left:20px;"
						colspan="7">用户信息修改</td>
					<td style="border-top-right-radius: 5px;"></td>
				</tr>
				<tr>
					<td colspan="2" width="25%" style="border:1px solid #CADEDF;"
						align="center">用户帐号：</td>
					<td colspan="6"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						${sessionScope.gguser.userCode }
						<input type="hidden" id="USERCODE" name="USERCODE" value="${sessionScope.gguser.userCode }"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" width="25%" style="border:1px solid #CADEDF;"
						align="center">用户姓名：</td>
					<td colspan="6"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="USERNAME" name="USERNAME"
						value="${sessionScope.gguser.userName }">
					</td>
				</tr>
				<style>
					.tr-css td{
						height:0px;
					}
				</style>
				<tr class="tr-css">
					<!-- readonly -->
					<td colspan="1" width="15%"
						style="border:1px solid #CADEDF;" align="center">省</td>
					<td colspan="1"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px; width: 81px">
						<div class="select_list" id="c_province1"
							onclick="findArea('province','province',1,'province1','city1')">
							<div id="uboxstyle">
								<select name="province1" id="province1">
									
										<option value="${gguser.province }">
											<gc:name codeType="Province" codeCode="${gguser.province}" />
										</option>
									
								</select>
							</div>
						</div>
					</td>
					<td colspan="1" width="15%"
						style="border:1px solid #CADEDF; width: 65px;"
						align="center">市</td>
					<td colspan="1"
						style="border:1px solid #CADEDF; text-align:left;padding-left:20px; width: 301px">
						<div class="select_list" id="c_city1"
							onclick="findArea('province1','city',2,'city1','county1')">
							<div id="uboxstyle">
								<select name="city1" id="city1">
									<option value="${gguser.city }">
										<gc:name codeType="City" codeCode="${gguser.city}" />
									</option>
								</select>
							</div>
						</div>
					</td>
					<td colspan="1" width="15%" style="border:1px solid #CADEDF;"
						align="center">区县</td>
					<td colspan="1"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px; width: 301px">
						<div class="select_list" id="c_county1"
							onclick="findArea('city1','county1',3,'county1',null)">
							<div id="uboxstyle">
								<select name="county1" id="county1">
									<option value="${gguser.county}">
										<gc:name codeType="County" codeCode="${gguser.county}" />
									</option>
								</select>
							</div>
						</div>
					</td>
					<td colspan="1" width="15%" style="border:1px solid #CADEDF;"
						align="center">等级</td>
					<td colspan="1"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px; width: 301px">
						<div id="uboxstyle">
							<select name="discopy" id="discopy"
								style="display: inline-block;">
								<option value="${gguser.comLevel}" selected="selected">
									<c:if test="${gguser.comLevel=='1'}">省级用户</c:if>
									<c:if test="${gguser.comLevel=='2'}">市级用户</c:if>
									<c:if test="${gguser.comLevel=='3'}">县级用户</c:if>
								</option>
								<c:if test="${levele.level==1 }">
								<option value="1">省级用户</option>
								<option value="2">市级用户</option>
								<option value="3">县级用户</option>
								</c:if>
								<c:if test="${levele.level==2 }">
								<option value="2">市级用户</option>
								<option value="3">县级用户</option>
								</c:if>
								<c:if test="${levele.level==3 }">
								<option value="3">县级用户</option>
								</c:if>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" width="25%" style="border:1px solid #CADEDF;"
						align="center">联系电话：</td>
					<td colspan="2"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="TELEPHONE" name="TELEPHONE"
						value="${gguser.telePhone }">
					</td>
					<td colspan="2" width="25%" style="border:1px solid #CADEDF;"
						align="center">联系人：</td>
					<td colspan="2"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="LINKNAME" name="LINKNAME"
						value="${gguser.linkName }">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="border:1px solid #CADEDF;" align="center">所属部门：</td>
					<td colspan="2"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px; width: 162px">
						<div id="uboxstyle">
							<select name="division" id="division" style="display: none;">
								<option value="${sessionScope.gguser.dl }" selected="selected">${sessionScope.gguser.division}</option>
								<c:forEach items="${sessionScope.perResult }" var="usere"
									varStatus="th">
									<c:if test="${usere.CODETYPE != 'Department' }">
										<c:if
											test="${sessionScope.gguser.division == usere.CODECNAME }">
											<option value="${usere.CODECODE }">${usere.CODECNAME
												}</option>
										</c:if>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</td>
					<td colspan="2" style="border:1px solid #CADEDF;" align="center">所属机构：</td>
					<td colspan="2"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="UPDATOR" name="UPDATOR"
						value="${gguser.updator }">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="border:1px solid #CADEDF;" align="center">用户权限：</td>
					<td colspan="1"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px; width: 162px">
						<div id="uboxstyle">
						<select name="FLAG" id="FLAG" style="display: none;">
							<option <c:if test="${gguser.flag == '0' }">selected="selected"</c:if> value="0">分支机构</option>
							<option <c:if test="${gguser.flag == '1' }">selected="selected"</c:if> value="1">业务员</option>
						</select>
						</div>
					</td>
				</tr>
				<tr>
					</form>
					<td colspan="4"><a class="table_buttonb"
						href="javascript:submitAdminer();">确认修改</a>
					</div></td>
					<td colspan="4"><a class="table_buttonb"
						href="javascript:history.go(-1);">返回</a>
					</div></td>
				</tr>
			</table>
	</div>
	<script type="text/javascript">
		function submitAdminer() {
			document.forms["AdminerShow"].submit();
		}
	</script>
</body>
</html>
