$(function(){
	$("button[id=edit-add]").each(function(){
		$(this).on("click",function(){
			fuel = $("#fuelType_add").val() ;
			if (fuel == "") { 
				operateAlert(false,"","不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/fuelType/add.action",{"fuel":fuel},function(data){
					 operateAlert(data.trim() == "true","增加成功！","增加失败！") ;
				},"text") ;
			}
		}) ;
	}) ;
}) ;