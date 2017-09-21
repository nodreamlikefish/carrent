$(function(){
	$("button[id=edit-add]").each(function(){
		$(this).on("click",function(){
			repairFactory = $("#repairFactory_add").val() ;
			console.log(repairFactory) ;
			if (repairFactory == "") { 
				operateAlert(false,"","不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/repairFactory/add.action",{"repairFactory":repairFactory},function(data){
					 operateAlert(data.trim() == "true","增加成功！","增加失败！") ;
					 window.setTimeout("window.location='pages/back/admin/repairFactory/list.action'",2000); 
				},"text") ;
			}
		}) ;
	}) ;
}) ;