function go(pageNo){
	$("#pageNo").val(pageNo);
	$("#fm").submit();
}
function goBySelect() {
	var num = $("#go").val();
	if(null == num || "" == num) {
		return;
	}
	var lastPage = $("#pageCount").val()
	var lastPageNum = parseFloat(lastPage);
	var numNum = parseFloat(num);
	if(numNum > lastPageNum) {
		num = lastPage;
	}
	if(num == "0") {
		num = 1;
	}
	go(num);
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