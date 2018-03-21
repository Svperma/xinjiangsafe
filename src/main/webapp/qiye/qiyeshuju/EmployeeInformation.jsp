<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>首页</title>
<link rel="stylesheet" href="/css/etpStyle.css">
<link rel="stylesheet" href="/css/WdatePicker.css">
<style type="text/css">
#tab_employ td {
	font-size: 16px;
}

#tab_employ a {
	font-size: 14px;
	line-height: 15px;
	color: #fff;
	display: block;
	width: 100%;
	height: 15px;
	border-bottom: 1px solid #fff;
	background: #f26422;
}

.span1 {
	cursor: pointer;
	padding: 30px 8px;
	color: #fff;
	background: #00a6e3;
	margin: 0px;
}

.span1:hover {
	background: #23921E;
}

.span2 {
	cursor: pointer;
	padding: 3px 8px;
	background: #f26422;
	color: #fff;
	margin: 0px;
}

.span2:hover {
	background: #9C3F13;
}
</style>
</head>
<body>
	<div class="maincont">
		<form action="${basePath }/employee/personsContinue" id="fm" name="fm"
			method="post">
			<table cellpadding="0" cellspacing="0" width="100%" border="0"
				id="tab_employ">
				<tr class="table_head">
					<td style="width:10%">员工姓名</td>
					<td style="width:10%">身份证号</td>
					<!-- <td style="width:5%">性别</td>
					<td style="width:5%">年龄</td>
					<td style="width:10%">联系方式</td>
					<td style="width:10%">工种</td>
					<td style="width:40%">家庭住址</td> -->
					<td style="width:10%">操作</td>
				</tr>
				<c:forEach items="${sessionScope.pagination.resultList }"
					var="employee" varStatus="listSize">
					<c:if test="${listSize.index %2 ==0 }">
						<tr class="table_mid" style="height:35px;">
					</c:if>
					<c:if test="${listSize.index %2 != 0 }">
						<tr class="" style="height:35px;">
					</c:if>
					<td>${employee.EMNAME }</td>
					<td><span id="idNo${listSize.index }">${employee.IDENTITYNO
							}</span></td>
					<%-- <td><c:if test="${employee.SEX  eq '1'}">
						男
						</c:if> <c:if test="${employee.SEX eq '2'}">女</c:if></td>
					<td>${employee.AGE }</td>
					<td>${employee.TELEPHONE }</td>
					<td><tlds:name codeType="EnterpriseSector"
							codeCode="${employee.DEPARTMENTCODE }" /></td>
					<td>${employee.ADDRESS }</td> --%>
					<td style="text-align: center;" ><span
						onclick="javascript:queryPersons(${listSize.index });"
						style="width:40px;height:20px;padding:3px 8px; margin:0px;line-height:20px;
						cursor: pointer; color: #fff; background: #00a6e3; margin: 0px;">修改</span>
						<!-- class="span1"
						 -->
						<span onclick="javascript:deletePersons(${listSize.index });"
						style="width:40px;height:20px;padding:3px 8px; margin:0px;line-height:20px;
						cursor: pointer;padding: 3px 8px;background: #f26422;color: #fff;margin: 0px;">删除</span>
						<!-- class="span2"
						 -->
					</td>
					</tr>
				</c:forEach>
			</table>
			<div class="maincont_mid_cont_right_bot">
				<a href="${basePath}/employee/addButton">添加</a>
			</div>
			<jsp:include page="${basePath }/enterprise/etyPagination.jsp" />
		</form>
	</div>
</body>
<script type="text/javascript">
  function deletePersons(obj){
	  var conf=window.confirm("确定删除？");
	  if(conf == true){
	  var identityNo = document.getElementById("idNo"+obj).innerHTML;
	  	window.location.href = "${basePath}/employee/deletePersons?identityNo="+identityNo;
	  };
  }
</script>
<script type="text/javascript">
  function queryPersons(obj){
	  var identityNo = document.getElementById("idNo"+obj).innerHTML;
	  	window.location.href = "${basePath}/employee/updatePersons?identityNo="+identityNo;
  }
</script>
<script type="text/javascript">
  function addPersons(obj){
	 window.location.href = "${basePath}/employee/addButton";
  }
</script>

</html>