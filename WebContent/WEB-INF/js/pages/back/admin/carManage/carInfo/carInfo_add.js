$(function(){
	$("button[id=edit-add]").each(function(){
		$(this).on("click",function(){
			plateNo = $("#plateNo").val() ;
			carOwner = $("#carOwner").val() ;
			carBelong = $("#carBelong").val() ;
			carType = $("#carType").val() ;
			engineNo = $("#engineNo").val() ;
			carJiaNo = $("#carJiaNo").val() ;
			color = $("#color").val() ;
			fuelType = $("#fuelType").val() ;
			buyDateStr = $("#buyDate").val() ;
			seller = $("#seller").val() ;
			carMoney = $("#carMoney").val() ;
			buyTax = $("#buyTax").val() ;
			allMoney = $("#allMoney").val() ;
			zheJiuMonth = $("#zheJiuMonth").val() ;
			zheJiuPercent = $("#zheJiuPercent").val() ;
			zheJiuFeePerMon = $("#zheJiuFeePerMon").val() ;
			nextYancheDateStr = $("#nextYancheDate").val() ;
			memo = $("#memo").val() ;
			if (plateNo == "" || carOwner == "" || carBelong == "" || carType == "" 
				|| color == "" || fuelType == "" || seller == "" || carMoney == "") { 
				operateAlert(false,"","请检查信息是否填写完整") ;
			} else {
				$.post("pages/back/admin/carManage/carInfo/add.action",{"plateNo":plateNo,"carOwner":carOwner,
					"carBelong":carBelong,"carType":carType,"engineNo":engineNo,"carJiaNo":carJiaNo,"color":color,
					"fuelType":fuelType,"buyDateStr":buyDateStr,"seller":seller,"carMoney":carMoney,"buyTax":buyTax,"allMoney":allMoney,
					"zheJiuMonth":zheJiuMonth,"zheJiuPercent":zheJiuPercent,"zheJiuFeePerMon":zheJiuFeePerMon,"nextYancheDateStr":nextYancheDateStr,
					"memo":memo},function(data){
					 operateAlert(data.trim() == "true","增加成功！","增加失败！") ;
					 window.setTimeout("window.location='pages/back/admin/carManage/carInfo/list.action'",2000);
				},"text") ;
			}
		}) ;
	}) ;
}) ;

function calculate(){
	var carMoney =parseFloat($("#carMoney").val()) ;
	var buyTax = parseFloat($("#buyTax").val()) ;
	var zheJiuMonth = parseFloat($("#zheJiuMonth").val()) ;
	var zheJiuPercent = parseFloat($("#zheJiuPercent").val()) ;
	var allMoney = carMoney+buyTax ;
	$("#allMoney").val(allMoney) ;
	if(zheJiuMonth<=0){
		$("#zheJiuMonth").val('') ;
		operateAlert(false,"","请输入正确的折旧期") ;
	}else if(zheJiuPercent<0 || zheJiuPercent>1){
		$("#zheJiuPercent").val('') ;
		operateAlert(false,"","请输入正确的折旧率") ;
	}else{
		var zheJiuFeePerMon = (allMoney/zheJiuMonth)*zheJiuPercent ;
		$("#zheJiuFeePerMon").val(zheJiuFeePerMon.toFixed(2)) ;
	}
}