$(function(){
	$("button[id=edit-add]").each(function(){
		$(this).on("click",function(){
			carOwner = $("#carOwner_add").val() ;
			if (carOwner == "") { 
				operateAlert(false,"","颜色不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/carOwner/add.action",{"owner":carOwner},function(data){
					 operateAlert(data.trim() == "true","增加成功！","增加失败！") ;
					 window.setTimeout("window.location='pages/back/admin/carOwner/list.action'",2000); 
				},"text") ;
			}
		}) ;
	}) ;
}) ;