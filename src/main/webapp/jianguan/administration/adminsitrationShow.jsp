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
		<form action="${basePath }/admin/adminupdate" method="post"
			name="AdminerShow">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				style="margin-top: 10px;" align="center">
				<tr class="table_lista">
					<td
						style="border-top-left-radius: 5px;text-align:left;padding-left:20px;"
						colspan="7">用户信息修改</td>
					<td style="border-top-right-radius: 5px;"></td>
				</tr>
				<tr class="table_listb">
					<td colspan="8"></td>
				</tr>
				<tr>
					<td colspan="2" width="25%" style="border:1px solid #CADEDF;"
						align="center">用户帐号：</td>
					<td colspan="6"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="USERCODE" name="USERCODE"
						value="${sessionScope.gguser.userCode }" maxlength="29" style="width: 308px; "
						readonly="redaonly">
					</td>
				</tr>
				<tr>
					<td colspan="5"></td>
				</tr>
				<tr>
					<td colspan="2" width="25%" style="border:1px solid #CADEDF;"
						align="center">用户姓名：</td>
					<td colspan="6"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="USERNAME" name="USERNAME" onblur="checkUserName(this);"
						value="${sessionScope.gguser.userName }" maxlength="29"/>
					</td>
				</tr>
				<tr>
					<td colspan="5"></td>
				</tr>
				<tr>
					<!-- readonly -->
					<td colspan="1" width="15%"
						style="border:1px solid #CADEDF;height: 50px;" align="center">省</td>
					<td colspan="1"
						style="border:1px solid #CADEDF;height: 50px;text-align:left;padding-left:20px; width: 81px">
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
						style="border:1px solid #CADEDF;height: 50px; width: 65px; margin-top: 200px;"
						align="center">市</td>
					<td colspan="1"
						style="border:1px solid #CADEDF; height: 50px; text-align:left;padding-left:20px; width: 301px">
						<div class="select_list" id="c_city1"
							onclick="findArea('province1','city',2,'city1','county1')">
							<div id="uboxstyle" style="margin-top:30px;">
								<select name="city1" id="city1">
									<option value="${gguser.city }">
										<gc:name codeType="City" codeCode="${gguser.city}" />
									</option>
								</select>
							</div>
						</div>
						<div class="select_list" style="margin:20px 0  20px; "></div>
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
									<c:if test="${gguser.comLevel=='0'}">全国用户</c:if>
									<c:if test="${gguser.comLevel=='1'}">省级用户</c:if>
									<c:if test="${gguser.comLevel=='2'}">市级用户</c:if>
									<c:if test="${gguser.comLevel=='3'}">县级用户</c:if>
								</option>
								<c:if test="${levele.level==0 }">
								<option value="0">全国用户</option>
								<option value="1">省级用户</option>
								<option value="2">市级用户</option>
								<option value="3">县级用户</option>
								</c:if>
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
								<%-- <c:forEach items="${comLevellist }" var="user" varStatus="th">
									<option value="${user.codeCode }">${user.codeCName }</option>
								</c:forEach> --%>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="5"></td>
				</tr>
				<tr>
					<!-- readonly -->
					<td colspan="2" width="25%" style="border:1px solid #CADEDF;"
						align="center">联系方式：</td>
					<td colspan="2"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="TELEPHONE" name="TELEPHONE"
						value="${gguser.telePhone }" maxlength="11">
					</td>
					<td colspan="2" width="25%" style="border:1px solid #CADEDF;"
						align="center">联系人：</td>
					<td colspan="2"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="LINKNAME" name="LINKNAME"
						value="${gguser.linkName }" maxlength="20">
					</td>
				</tr>
				<tr>
					<td colspan="5"></td>
				</tr>
				<tr>
					<td colspan="2" width="25%" style="border:1px solid #CADEDF;"
						align="center">联系地址：</td>
					<td colspan="4"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" style="width: 700px;" id="ADDRESS"
						name="ADDRESS" value="${gguser.address }" maxlength="100">
					</td>
				</tr>
				<tr>
					<td colspan="5"></td>
				</tr>
				<tr>
					<td colspan="2" style="border:1px solid #CADEDF;" align="center">手机号码</td>
					<td colspan="2"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="MOBILE" name="MOBILE"
						value="${gguser.mobile }" maxlength="11">
					</td>
					<%-- <td colspan="2" style="border:1px solid #CADEDF;" align="center">管理员姓名</td>
					<td colspan="2"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px;">
						<input type="text" id="UPDATOR" name="UPDATOR"
						value="${gguser.updator }">
					</td> --%>
				</tr>
				<tr>
					<td colspan="5"></td>
				</tr>
				<tr>
					<td colspan="2" style="border:1px solid #CADEDF;" align="center">用户权限</td>
					<td colspan="1"
						style="border:1px solid #CADEDF;text-align:left;padding-left:20px; width: 162px">
						<div id="uboxstyle">
							<select name="FLAG" id="FLAG" style="display: none;">
								<option value="${sessionScope.gguser.fl }" selected="selected">${sessionScope.gguser.flag}</option>
								<c:forEach items="${sessionScope.opption }" var="usere"
									varStatus="th">
									<c:if test="${usere.CODETYPE == 'Perssion' }">
										<c:if test="${sessionScope.gguser.flag != usere.CODECNAME }">
											<option value="${usere.CODECODE }">${usere.CODECNAME}</option>
										</c:if>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</td>
					<td colspan="2" style="border:1px solid #CADEDF;" align="center">所属部门</td>
					<td colspan="1"
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
			var url = "${basePath }/admin/adminupdate";
			var form = document.forms["AdminerShow"];
			form.action = url;
			form.submit();
		}
		
function checkUserName(s) {
		var uName = s.value;
		var userCode = document.getElementById("USERCODE").value;
		$j.ajax({
			type : "get",
			url : "/admin/checkUserNameForUpdate?userName=" + uName + "&userCode=" + userCode,
			data : {},
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data == "yes") {
					alert("用户名称已存在，请重新输入");
					s.value = "";
					s.focus();
					return;
				}
				if(data == "no") {
				}
				
			},
			error : function() {
				alert("分配账号失败，请稍后再试");
			}
		});
	}
	</script>
</body>
</html>
