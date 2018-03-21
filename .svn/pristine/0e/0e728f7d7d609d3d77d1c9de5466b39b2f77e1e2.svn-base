<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="${basePath }/common/include.jsp"></jsp:include>
<html>
<head>

<title>My JSP 'publishResult.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="${basePath }/js/fusioncharts.js"></script>
<script src="${basePath }/js/fusioncharts.charts.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div class="neicont_main_left_cont_main">
		<div style="margin:50px auto;height:400px;">
			<span id="bscharts"></span>
			<script type="text/javascript">
				FusionCharts.ready(function() {
					var charts = new FusionCharts({
						type : "column3d",
						renderAt : "bscharts",
						width : "500",
						height : "400",
						dataFormat : "json",
						dataSource : {
							"chart" : {
								"caption" : "保费、事故预防费、赔款",
								"subCaption" : "",
								"xAxisName" : "类型",
								"yAxisName" : "万元",
								"paletteColors" : "#0075c2",
								"valueFontColor" : "#ffffff",
								"baseFont" : "Helvetica Neue,Arial",
								"captionFontSize" : "14",
								"subcaptionFontSize" : "14",
								"subcaptionFontBold" : "0",
								"placeValuesInside" : "1",
								"rotateValues" : "1",
								"showShadow" : "0",
								"divlineColor" : "#999999",
								"divLineIsDashed" : "5",
								"divlineThickness" : "1",
								"divLineDashLen" : "1",
								"divLineGapLen" : "1",
								"canvasBgColor" : "#999999"
							},
							"data" : [ {
								"label" : "保费",
								"value" : "${chartMap.PREMIUM}"
							}, {
								"label" : "事故预防费",
								"value" : "${chartMap.PREVENTFEE}"
							}, {
								"label" : "赔款",
								"value" : "${chartMap.LOSSAMOUNT}"
							} ]
						}
					});
					charts.render();
				});
			</script>
			<span id="ywcharts"> <script type="text/javascript">
				FusionCharts
						.ready(function() {
							var chart = new FusionCharts(
									{
										type : 'pie3d',
										renderAt : 'ywcharts',
										width : '500',
										height : '400',
										dataFormat : 'json',
										dataSource : {
											"chart" : {
												"caption" : "已投保/未投保企业",
												"subCaption" : "",
												"paletteColors" : "#0075c2,#1aaf5d",
												"bgColor" : "#ffffff",
												"showBorder" : "0",
												"use3DLighting" : "0",
												"showShadow" : "0",
												"enableSmartLabels" : "0",
												"startingAngle" : "0",
												"showPercentValues" : "1",
												"showPercentInTooltip" : "0",
												"decimals" : "1",
												"captionFontSize" : "14",
												"subcaptionFontSize" : "14",
												"subcaptionFontBold" : "0",
												"toolTipColor" : "#ffffff",
												"toolTipBorderThickness" : "0",
												"toolTipBgColor" : "#000000",
												"toolTipBgAlpha" : "80",
												"toolTipBorderRadius" : "2",
												"toolTipPadding" : "5",
												"showHoverEffect" : "1",
												"showLegend" : "1",
												"legendBgColor" : "#ffffff",
												"legendBorderAlpha" : '0',
												"legendShadow" : '0',
												"legendItemFontSize" : '7',
												"legendItemFontColor" : '#666666'
											},
											"data" : [
													{
														"label" : "已投保",
														"value" : "${chartMap.APPLICOUNT}"
													},
													{
														"label" : "未投保",
														"value" : "${chartMap.TOTALCOUNT - chartMap.APPLICOUNT}"
													} ]
										}
									}).render();
						});
			</script>
			</span>
		</div>
	</div>
</body>
</html>
