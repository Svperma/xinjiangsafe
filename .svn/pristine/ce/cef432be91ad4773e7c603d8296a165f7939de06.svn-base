<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="tlds"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="/admin/css/pintuer.css">
<link rel="stylesheet" href="/admin/css/admin.css">
<script src="/admin/js/jquery.js"></script>
<script src="${basePath }/admin/js/pintuer.js"></script>
</head>
<body>

<form action="${basePath }/edit/newsContinue" id="fm" name="fm">
	<div class="panel admin-panel" style="height:1000px;">
		<table class="table table-hover text-center">
			<tr>
				<th width="80px;">序号</th>
				<!-- <th width="100px;">期数</th> -->
				<!--  -->
				<!-- <th width="80px;">显示位置</th> -->
				<th width="200px;">图片</th>
				<th width="450px;">标题</th>
<!-- 				<th width="180px;">属性</th> -->
				<th width="180px;">分类名称</th>
				<th width="120px;">更新时间</th>
				<th width="240px;">操作</th>
			</tr>
			<volist name="list" id="vo"> 
			
			<c:forEach items="${sessionScope.pagination.resultList }" var="noteList" varStatus="vs">
				<tr>
					<td style="text-align:left; padding-left:10px;width: 80px;">
						<input type="checkbox" name="id[]" value="${vs.index+1 }" />${vs.index+1 }</td>
					<%-- <td style="text-align: center;width: 80px;" id="expectNo">第${noteList.EXPECTNO }期</td> --%>
					<%-- <td style="text-align: center;width: 80px;" id="displayNo">${noteList.DISPLAYNO }</td> --%>
					<td width="180px;" style="text-align: center;" id="imagePath">
						<c:if test="${not empty noteList.IMAGEPATH }">
							<img src="${noteList.IMAGEPATH }" alt="" width="70" height="50" />
						</c:if>
						<c:if test="${empty noteList.IMAGEPATH }">
							无
						</c:if>
					</td>
					<td id="title" style="text-overflow : ellipsis;overflow:hidden;white-space:nowrap;width: 420px;">
						<div style="display:inline-block;word-break:normal;overflow-wrap: break-word;width:400px;
							font-size:20px; margin: 0 auto;text-align: center;">${noteList.TITLE }
						</div>
					</td>
					<td style="text-align: center;display: none;">
						<input id="docType" name="docType" value="${noteList.DOCTYPE }" type="hidden">
					</td>
<!-- 					<td style="text-align: center;width: 180px;" id="indexOrTopOrRecommend"> -->
<!-- 						<font color="#00CC99"> -->
							<!-- 判断：如果‘首页’为1，则显示（其他项相同） --> 
<!-- 							<c:if test="${noteList.ISINDEX == '1' }">首页</c:if>  -->
<!-- 							<c:if test="${noteList.ISRECOMMEND == '1' }">推荐</c:if>  -->
<!-- 							<c:if test="${noteList.ISTOP == '1' }">置顶</c:if>  -->
<!-- 							<c:if test="${noteList.ISTOP == '' && noteList.ISINDEX == '' && noteList.ISRECOMMEND == '' }"></c:if> -->
<!-- 						</font> -->
<!-- 					</td> -->
					<td style="text-align: center;width: 180px;">
						<tlds:name codeType="docType" codeCode="${noteList.DOCTYPE }" />
					</td>
					<td style="text-align: center;width: 120px;" id="publishDate">
						<fmt:formatDate value="${noteList.PUBLISHDATE }" pattern="yyyy-MM-dd" />
					</td>
					<td style="text-align: center;width: 240px;">
						<div class="button-group">
<!-- 							<a class="button border-main" -->
<!-- 								href="${basePath }/edit/updateExpect?docType=${noteList.DOCTYPE}&docId=${noteList.DOCID}"> -->
<!-- 								<span class="icon-edit"></span> 修改 -->
<!-- 							</a>  -->
							<a class="button border-red"
								href="javascript:del('${noteList.DOCID }','${noteList.DOCTYPE }')">
								<span class="icon-trash-o"></span> 删除
							</a>
						</div>
					</td>
				</tr>
			</c:forEach>
			<!-- <tr>
				<td style="text-align:left; padding:19px 0;padding-left:20px;">
					<input type="checkbox" id="checkall" />全选
				</td>
				<td colspan="8" style="text-align:left;padding-left:20px;">
					<a href="javascript:void(0)" class="button border-red icon-trash-o"
						style="padding:5px 15px;" onclick="DelSelect()"> 删除
					</a> 
					<a href="javascript:void(0)" style="padding:5px 15px; margin:0 10px;"
						class="button border-blue icon-edit" onclick="sorts()"> 排序
					</a> 
					操作： 
					<select name="ishome" style="padding:5px 15px; border:1px solid #ddd;"
						onchange="changeishome(this)">
						<option value="">首页</option>
						<option value="1">是</option>
						<option value="0">否</option>
					</select> 
					<select name="isvouch" style="padding:5px 15px; border:1px solid #ddd;"
						onchange="changeisvouch(this)">
						<option value="">推荐</option>
						<option value="1">是</option>
						<option value="0">否</option>
					</select> 
					<select name="istop" style="padding:5px 15px; border:1px solid #ddd;"
						onchange="changeistop(this)">
						<option value="">置顶</option>
						<option value="1">是</option>
						<option value="0">否</option>
					</select> &nbsp;&nbsp;&nbsp; 
					移动到： 
					<select name="movecid" style="padding:5px 15px; border:1px solid #ddd;"
						onchange="changecate(this)">
						<option value="">请选择分类</option>
						<option value="1">新闻动态</option>
						<option value="2">政策法规</option>
						<option value="3">专题报道</option>
						<option value="4">案例分析</option>
					</select> 
					<select name="copynum" style="padding:5px 15px; border:1px solid #ddd;"
						onchange="changecopy(this)">
						<option value="">请选择复制</option>
						<option value="5">复制5条</option>
						<option value="10">复制10条</option>
						<option value="15">复制15条</option>
						<option value="20">复制20条</option>
					</select>
				</td>
			</tr> -->
			<!-- <tr>
				<td colspan="9">
					<div class="pagelist">
						<a href="">上一页</a> 
							<span class="current">1</span>
						<a href="">2</a>
						<a href="">3</a>
						<a href="">下一页</a>
						<a href="">尾页</a>
					</div></td>
			</tr> -->
			</volist>
		</table>
			<jsp:include page="${basePath }/common/pagination.jsp"></jsp:include>
	</div>
	</form>
	<script type="text/javascript">
		//单个删除 @author：HSLT
		function del(mid, docpe) {
			var conf = window.confirm("确定删除？");
			if (conf == true) {
				window.location.href = "${basePath }/edit/deleteExpect?docId="
						+ mid + "&docType=" + docpe;
			}
		}

		//全选
		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		//批量删除
		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
				$("#listform").submit();
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}

		//批量排序
		function sorts() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {

				$("#listform").submit();
			} else {
				alert("请选择要操作的内容!");
				return false;
			}
		}

		//批量首页显示
		function changeishome(o) {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {

				$("#listform").submit();
			} else {
				alert("请选择要操作的内容!");

				return false;
			}
		}

		//批量推荐
		function changeisvouch(o) {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {

				$("#listform").submit();
			} else {
				alert("请选择要操作的内容!");

				return false;
			}
		}

		//批量置顶
		function changeistop(o) {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {

				$("#listform").submit();
			} else {
				alert("请选择要操作的内容!");

				return false;
			}
		}

		//批量移动
		function changecate(o) {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {

				$("#listform").submit();
			} else {
				alert("请选择要操作的内容!");

				return false;
			}
		}

		//批量复制
		function changecopy(o) {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var i = 0;
				$("input[name='id[]']").each(function() {
					if (this.checked == true) {
						i++;
					}
				});
				if (i > 1) {
					alert("只能选择一条信息!");
					$(o).find("option:first").prop("selected", "selected");
				} else {

					$("#listform").submit();
				}
			} else {
				alert("请选择要复制的内容!");
				$(o).find("option:first").prop("selected", "selected");
				return false;
			}
		}
	</script>
</body>
</html>