<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
<head>

<title>My JSP 'MyJsp.jsp' starting page</title>

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
	<div id="bscharts" class="charts"></div>
	<script type="text/javascript">
		FusionCharts.ready(function() {
			var charts = new FusionCharts({
				type : "column3d",
				renderAt : "bscharts",
				width : "300",
				height : "300",
				dataFormat : "json",
				dataSource : {
					"chart" : {
						"caption" : "保费/事故预防费",
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
						"value" : "4200"
					}, {
						"label" : "事故预防费",
						"value" : "81"
					} ]
				}
			});
			charts.render();
		});
	</script>
</body>
</html>
