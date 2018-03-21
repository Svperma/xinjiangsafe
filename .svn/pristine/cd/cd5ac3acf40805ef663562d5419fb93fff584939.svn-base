function go(pageNo){
	$("#pageNo").val(pageNo);
	$("#fm").submit();
}
function goFirst(){
	var curNo = $("#pageNo").val();
	if(curNo == 1){
		alert("已经是第一页");
		return;
	}
	$("#pageNo").val("1");
	$("#fm").submit();
}
function goBack(){
	var curNo = $("#pageNo").val();
	if(curNo == 1){
		alert("已经是第一页");
		return;
	}
	$("#pageNo").val(curNo-1);
	$("#fm").submit();
}
function goForword(){
	var curNo = $("#pageNo").val();
	if(curNo == $("#pageCount").val()){
		alert("已经是最后一页");
		return;
	}
	curNo = parseInt(curNo)+1;
	$("#pageNo").val(curNo);
	$("#fm").submit();
}
function goEnd(){
	var curNo = $("#pageNo").val();
	if(curNo == $("#pageCount").val()){
		alert("已经是最后一页");
		return;
	}
	$("#pageNo").val($("#pageCount").val());
	$("#fm").submit();
}