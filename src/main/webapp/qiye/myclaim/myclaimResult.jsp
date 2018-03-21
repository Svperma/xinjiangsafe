<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/tlds/ggCodeTld" prefix="gc"%>

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
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="${basePath }/js/select2css.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${basePath }/js/jquery.js"></script>
<link rel="stylesheet" href="${basePath }/css/etpStyle.css" />
<link rel="stylesheet" href="${basePath }/css/WdatePicker.css">
<script type="text/javascript">
	var degree = [ '', '1分', '2分', '3分', '4分', '5分', '未评分' ];
	//重新点评
	function addComment2(e, inid, opt, id) {
		$.ajax({
			url : '/siteMessage/content',
			type : 'post',
			data : 'id=' + id,
			dataType : 'json',
			success : function(data) {
				if (data.status == 1) {
					var list = $('#Addnewskill_119');
					list.eq(0).html(
							data.talent + '(人才ID：' + data.talentId + ')');
					list.eq(1).html(data.job);
					list.eq(2).html(data.ms);
					var arr = [ data.total, data.expAuth, data.killAuth,
							data.followTime, data.formality, data.appReact ];
					var list2 = $('span.level', '#Addnewskill_119');
					$('input[name="InterviewCommentInfoSub[opt]"]')
							.val(opt + 1);
					list2.each(function(i, v) {
						var a = '';
						if (i > 0) {
							a = 'cjmark';
							$(v).parents('li').find('input').val(arr[i]);
						}
						var str = '';
						if (arr[i] == 6) {
							for ( var n = 0; n <= 4; n++) {
								str += '<i '+a+' class="level_hollow"></i>';
							}
							$(v).parents('li').find('input').prop('disabled',
									true)
						} else {
							$(v).parents('li').find('input').prop('checked',
									true)
							for ( var n = 0; n < arr[i]; n++) {
								str += '<i '+a+' class="level_solid"></i>';
							}
							for ( var n = 0; n < (5 - arr[i]); n++) {
								str += '<i '+a+' class="level_hollow"></i>';
							}
						}
						$(v).html(str);
						$(v).next().html(degree[arr[i]]);
					})
					create_show(119);
				} else {
					ui.error(data.msg, 2000);
				}
			}
		})
	}
	//提交点评
	function addComment3() {
		$.ajax({
			url : '/siteMessage/commentinterview',
			type : 'post',
			data : $('form[name="comment"]').serialize(),
			dataType : 'json',
			success : function(data) {
			}
		})
	}
	$(function() {
		//点星星
		$(document).on('mouseover', 'i[cjmark]', function() {
			var num = $(this).index();
			var pmark = $(this).parents('.revinp');
			var mark = pmark.prevAll('input');
			if (mark.prop('checked'))
				return false;
			var list = $(this).parent().find('i');
			for ( var i = 0; i <= num; i++) {
				list.eq(i).attr('class', 'level_solid');
			}
			for ( var i = num + 1, len = list.length - 1; i <= len; i++) {
				list.eq(i).attr('class', 'level_hollow');
			}
			$(this).parent().next().html(degree[num + 1]);
		})
		//点击星星
		$(document).on('click', 'i[cjmark]', function() {
			var num = $(this).index();
			var pmark = $(this).parents('.revinp');
			var mark = pmark.prevAll('input');
			if (mark.prop('checked')) {
				mark.val('');
				mark.prop('checked', false);
				mark.prop('disabled', true);
			} else {
				mark.val(num);
				mark.prop('checked', true);
				mark.prop('disabled', false);
			}
		})
		//选框
		$('#Addnewskill_119 input[type="checkbox"]').change(function() {
			if ($(this).not(':checked')) {
				$(this).prop('checked', false);
				var smark = $(this).nextAll('.revinp');
				smark.find('span.revgrade').html('未评分');
				smark.find('i').attr('class', 'level_hollow');
				smark.val(6);
			}
		})
	})
</script>
</head>
<body>

	<div class="maincont">
		<div class="maincont_mid_cont_right">
			<div class="maincont_mid_cont_right_main">
				<div id="ziliao"
					style="width:800px; position: absolute; background-color:white; border:1px solid #CCC;border-radius:5px;padding:10px 20px;display:none;">
					<form name="claimchuan" id="claimchuan"
						enctype="multipart/form-data" method="post">
						<table width="90%">
							<tr>
								<td>事故调查报告：</td>
								<td colspan="3"><input class="select_list_inputa"
									type="file" id="ACCIDENTPORT" name="ACCIDENTPORT"></td>
							</tr>
							<tr>
								<td>死亡证明：</td>
								<td colspan="3"><input class="select_list_inputa"
									type="file" id="DEATHPORT" name="DEATHPORT"></td>
							</tr>
							<tr>
								<td>伤残证明：</td>
								<td colspan="3"><input class="select_list_inputa"
									type="file" id="DISABLITY" name="DISABLITY"></td>
							</tr>
							<tr>
								<td colspan="4"></td>
							</tr>
							<tr>
								<td colspan="2" style="text-align:center;"><a
									href="javascript:shangchuan();"
									style="width:100px;background:#00a6e3;">报案</a> <a
									href="javascript:hide('ziliao');"
									style="width:100px;background:#00a6e3;">取消</a></td>
							</tr>
						</table>
					</form>
				</div>
				<form action="${basePath }/myclaim/myclaimPagin" name="fm" id="fm"
					method="get">
					<table cellpadding="0" cellspacing="0" width="100%" border="0">
						<tr class="table_head" style="text-align: center;">
							<td>被保险人</td>
							<td>保单号</td>
							<td>赔案号</td>
							<td>赔款金额（万元）</td>
							<td>出险时间</td>
							<td>保险公司</td>
							<td>理赔进度</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${sessionScope.pagination.resultList }"
							var="myclaim" varStatus="th">
							<c:if test="${th.index % 2 != 1}">
								<tr class="table_mid" style="text-align: center;">
							</c:if>
							<c:if test="${th.index % 2 == 1  }">
								<tr style="text-align: center;">
							</c:if>
							<td>${myclaim.INSUREDNAME }</td>
							<td>${myclaim.POLICYNO }</td>
							<td>${myclaim.PEIANNO }</td>
							<td>${myclaim.PAYAMOUNT }</td>
							<td><fmt:formatDate value="${myclaim.LOSSDATE }"
									pattern="yyyy-MM-dd" /></td>
							<td><gc:name codeCode="${myclaim.INSURERCODE }"
									codeType="CICompanycode" /></td>
							<td><c:if test="${myclaim.STATUS == 1 }">报案</c:if> <c:if
									test="${myclaim.STATUS == 2 }">勘察</c:if> <c:if
									test="${myclaim.STATUS == 3 }">定损核损</c:if> <c:if
									test="${myclaim.STATUS == 4 }">赔付</c:if> <c:if
									test="${myclaim.STATUS == 5 }">完成</c:if></td>
							<td><a class="table_buttonb"
								href="${basePath }/myclaim/claimShow?businessno=${myclaim.BAOANNO }">查看</a><a
								class="table_buttonb"
								href="javascript:showDiv('ziliao','${myclaim.BAOANNO }');">资料上传</a><a
								class="table_buttonb"
								href="${basePath }/myclaim/myclaimshowTalk?baoanno=${myclaim.BAOANNO }">评价</a></td>
							</tr>
						</c:forEach>
					</table>
					<jsp:include page="${basePath }/enterprise/etyPagination.jsp"></jsp:include>
				</form>
			</div>

			<div id="evaluateId" class="border"
				style="border-radius:5px;display:none;position:absolute;top:10px;left:15%;z-index:9999;width:70%;background-color:white;padding:20px 10px;">
				<div class=" " style="text-align:left;width:100%; opacity:1.0;">
					<div class="h25">
						<div class="w150 h25 fl border-top border-right border-left"
							align="center"
							style="background-color:#E5E5E5;font-size:18px; font-weight:bold;" id="pointcounty" name="pointcounty">累计评价&nbsp;</div>
						<div class="fl h25 " style="background-color:white;width:79%;"></div>
					</div>
					<div style="clear:both;"></div>
					<div class="h8">
						<div class="w150 h9 fl border-left border-bottom"
							style="background-color:#E5E5E5;"></div>
						<div class="fl  h8 border-top border-right border-bottom"
							style="width:79%;background-color:#E5E5E5;"></div>
					</div>
				</div>

				<div class="border"
					style="overflow-x:hidden;height:72px;margin-top:5px;padding:10px 5px;background-color:white;">
					<div class="fl"
						style="width:100px;height:72px;text-align:center;line-height:27px;">
						<h4>综合评分</h4>
						<strong  id="dou" name="dou"></strong>
						<p align="center">
							<span style="height:12px;text-align:left;"> <em></em>
							</span>
						</p>
					</div>
					<div class="fl"
						style="text-align:left;width:23px;height:72px;padding-left:20px;padding-right:5px;font-size:10px;line-height:15px;color:#CCC;background:url(images/T12eC3XklrXXXXXXXX-15-52.png) no-repeat center right;border-left:#CCC dashed 1px;">
						历史评价：</div>
					<style>
#talked td {
	width: 20%;
	word-break: break-all;
	text-align: center;
}
</style>
					<div class="fl con" style="width:64%;">
						<table id="talked" style="width:100%;">
							<tr>
								<td>评论内容</td>
								<td>服务态度</td>
								<td>理赔效率</td>
								<td>评论时间</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="content" id="other">
					<table>
						<tr>
							<td colspan="2"><h2>其他企业，需要你的建议哦！</h2></td>
						</tr>
						<tr>
							<td rowspan="2" style="font-size:12px;">为保险公司打分：</td>
							<td><input class="fl" type="checkbox"
								style="margin-top:2px;" name="InterviewCommentInfoSub[expAuth]"
								value="3" /> <span class="revtit">服务态度</span> <span
								class="level"> <i class="level_solid" cjmark=""></i> <i
									class="level_solid" cjmark=""></i> <i class="level_solid"
									cjmark=""></i> <i class="level_solid" cjmark=""></i> <i
									class="level_hollow" cjmark=""></i>
							</span> <span class="revgrade" id="serve" name="serve">4分</span></td>
						</tr>
						<tr>
							<td><input class="fl" type="checkbox"
								style="margin-top:2px;" name="InterviewCommentInfoSub[killAuth]"
								value="3" /> <span class="revtit">理赔效率</span> <span
								class="level"> <i class="level_solid" cjmark=""></i> <i
									class="level_solid" cjmark=""></i> <i class="level_solid"
									cjmark=""></i> <i class="level_solid" cjmark=""></i> <i
									class="level_hollow" cjmark=""></i>
							</span> <span class="revgrade" id="policy" name="policy">4分</span></td>
						</tr>
						<tr>
							<td style="font-size:12px;">评价内容：</td>
							<td><textarea id="textname" name="textname"
									style="margin: 0px; width: 576px; height: 152px;"></textarea></td>
						</tr>
					</table>
				</div>
				<div style="backgroun-color:white;padding:15px 0px; "
					class="border-left border-right border-bottom"><!-- javascript:upSummit(); -->
					<a href="javascript:mychecktalk();"
						style="padding:5px 15px;background-color:#F36;border-radius:5px;">提交评价</a>
					<a href="javascript:close();"
						style="padding:5px 15px;background-color:#F36;border-radius:5px;">返回</a>
				</div>
			</div>
			<div class="clearboth"></div>
		</div>
	</div>
	<script type="text/javascript">
		function upSummit() {
			var textname = document.getElementById("textname").value;
			if (textname == null ) {
				alert("评价内容为空，请输入！");
				return;
			}
// 			document.getElementById('evaluateId').style.display = 'none';
		}
	</script>
	<style>
* {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

a,img {
	border: 0;
}

.gradecon {
	border: 1px solid #E0DCDC;
	background: #fefdea;
	padding: 10px;
	width: 320px;
	margin: 40px auto 0 auto;
}

.rev_pro li {
	line-height: 20px;
	height: 20px;
}

.rev_pro li .revtit {
	text-align: right;
	display: block;
	float: left;
	margin-right: 10px;
	width: 70px;
}

.revinp {
	float: left;
	display: inline;
}

.level .level_solid,.level .level_hollow {
	float: left;
	background-image: url("images/icon2.png");
	background-repeat: no-repeat;
	display: inline-block;
	width: 15px;
	height: 15px;
}

.level .level_solid {
	background-position: 0px 0px;
}

.level .level_hollow {
	background-position: -21px 0px;
}

.revgrade {
	margin-left: 20px;
}

.h8 {
	height: 8px;
}

.h9 {
	height: 9px;
}

.h25 {
	height: 25px;
}

.w150 {
	width: 20%;
}

.w739 {
	width: 739px;
}

.fl {
	float: left;
}

tl {
	text-align: left;
}

.border {
	border: solid 1px #CBC7CF;
}

.border-top {
	border-top: solid 1px #CBC7CF;
}

.border-left {
	border-left: solid 1px #CBC7CF;
}

.border-right {
	border-right: solid 1px #CBC7CF;
}

.border-bottom {
	border-bottom: solid 1px #CBC7CF;
}

.pb3 {
	padding-bottom: 3px;
}

p span {
	background: url(images/levle_star.png) no-repeat 0px -27px;
	width: 60px;
	height: 12px;
	display: block;
}

em {
	display: block;
	height: 12px;
	background: url(images/levle_star.png) no-repeat 0px -15px;
	width: 55px;
}

strong {
	font-size: 20px;
	color: #F00;
}

.con span {
	border: #B65CA8 solid 1px;
	color: #C1558B;
	border-radius: 3px;
	margin: 2px 6px;
	padding: 2px 5px;
}

.content {
	border: #CCC 2px solid;
	background-color: #EAEAEA;
	padding: 10px 20px;
	margin-top: 5px;
}
</style>
	<script type="text/javascript" charset="gbk">
		var bananno = null;
		function close() {
			/* document.getElementById('evaluateId').style.display = 'none';
			document.getElementById("textname").value = ''; */
			window.location.reload();
		}

		function showDiv(obj, id) {
			baoanno = id;
			document.getElementById(obj).style.display = '';
			document.getElementById(obj).style.top = "30px";
// 			alert("完成操作");
		}
		function hide(obj) {
			document.getElementById(obj).style.display = "none";
		}
		function shangchuan() {
			var ACCIDENTPORT = document.getElementById("ACCIDENTPORT").value;
			var DEATHPORT = document.getElementById("DEATHPORT").value;
			var DISABLITY = document.getElementById("DISABLITY").value;
			if ((ACCIDENTPORT != null && ACCIDENTPORT != "" && ACCIDENTPORT != "未选择文件。")
			||(DEATHPORT != null && DEATHPORT != "" && DEATHPORT != "未选择文件。")
			||(DISABLITY != null && DISABLITY != "" && DISABLITY != "未选择文件。"))
			 {
				var forms = document.forms["claimchuan"];
				forms.action = "/myclaim/claimchuan?id=" + baoanno;
				forms.submit();
			}else {
				alert("上传文件为空，请选择文件后提交！");
				return;
			}
		}
		function evaluate(id) {
			bananno = id;
			var table = document.getElementById("talked");
			var chile = table.getElementsByTagName("tr");
			for ( var i = chile.length - 1; i > 0; i--) {
				if (i > 0) {
					table.deleteRow(i);
					continue;
				}
			}
			$.ajax({
				type : "post",
				contentType : "application/json;charset=UTF-8",
				data : {},
				dataType : "json",
				url : "${basePath }/myclaim/myclaimshowTalk?bananno="+ bananno,
					success : function(data) {
						if(data.length==0){
							$("#talked").append();
						}else{
							for ( var i = 0 ;i < data.length-1 ; i++) {
								$("#talked").append(
									"<tr><td>" + data[i].CONTENT + "</td>"
									+ "<td>" + data[i].serce
									+ "分</td>" + "<td>"
									+ data[i].policy + "分</td>"
									+ "<td>"
									+ getTime(data[i].EVALUATETIME)
									+ "</td></tr>");
							}
							$("#dou").append(data[data.length-1].dou);
							$("#pointcounty").append(data[data.length-1].pointcounty);
							document.getElementById("evaluateId").style.display = "";
						}
				},
				/* function(XMLHttpRequest, textStatus,
								errorThrown) {
							alert(XMLHttpRequest.status);
							alert(XMLHttpRequest.readyState);
							alert(textStatus); */
				error : function(){
					alert("error");
				}
			});
		}
		function mychecktalk() {
			var serce = document.getElementById("serve").innerHTML;
			var policy = document.getElementById("policy").innerHTML;
			var textname = document.getElementById("textname").value;
			$.ajax({
				type : "post",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"serce" : serce,
					"policy" : policy,
					"textname" : textname,
					"bananno" : bananno,
				}),
				datatype : "json",
				url : "${basepath }/myclaim/myclaimtalk",
				success : function(data) {
					var jsString = JSON.parse(data);
					if (jsString == "isHavePingJia") {
						document.getElementById("evaluateId").style.display = "none";
						alert("您已评价过");
						return;
					}else if (jsString == "textnameIsNull") {
						alert("评价内容为空，请输入内容！");
						return;
					}else if(jsString == "chenggong"){
						alert("评价成功！");
// 						document.getElementById("textname").value = "";
// 						$("#evaluateId").html(jsString);
						window.location.reload();
						document.getElementById("evaluateId").style.display = "none";
					}
				},
				/* error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
				} */
				error : function() {
					alert("失败，请稍后再试");
				}
			});
		}

		function getTime(hello) {
			var now = new Date(hello);

			//now =  now.getTime();

			//获取当前时间的小时
			//var hours = now.getHours();//10
			//分钟
			//var min = now.getMinutes();//36
			//秒
			//var sec = now.getSeconds();//25
			//年
			var year = now.getFullYear();//2015
			//月    月份的范围是从0~11,所以获得的月份要加1才是当前月
			var mon = now.getMonth() + 1;//9
			//日
			var day = now.getDate();//21
			return year + "-" + mon + "-" + day;
		}
	</script>
</body>
</html>
