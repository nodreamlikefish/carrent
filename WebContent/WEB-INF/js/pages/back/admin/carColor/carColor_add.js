$(function(){
	$("button[id=edit-add]").each(function(){
		$(this).on("click",function(){
			color = $("#color_add").val() ;
			if (color == "") { 
				operateAlert(false,"","颜色不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/carColor/add.action",{"color":color},function(data){
					 operateAlert(data.trim() == "true","车辆颜色增加成功！","车辆颜色增加失败！") ;
				},"text") ;
			}
		}) ;
	}) ;
}) ;