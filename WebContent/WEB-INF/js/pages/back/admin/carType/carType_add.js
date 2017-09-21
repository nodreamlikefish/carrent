$(function(){
	$("button[id=edit-add]").each(function(){
		$(this).on("click",function(){
			carType = $("#carType_add").val() ;
			if (carType == "") { 
				operateAlert(false,"","颜色不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/carType/add.action",{"carType":carType},function(data){
					 operateAlert(data.trim() == "true","车辆颜色增加成功！","车辆颜色增加失败！") ;
				},"text") ;
			}
		}) ;
	}) ;
}) ;