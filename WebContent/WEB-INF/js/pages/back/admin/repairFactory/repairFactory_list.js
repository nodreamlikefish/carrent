$(function(){
	$("button[id^=edit-update-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[2] ;
			console.log("编号：" +  cid) ;
			repairFactory = $("#repairFactory-" + cid).val() ;
			if (repairFactory == "") { 
				operateAlert(false,"","不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/repairFactory/edit.action",{"id":cid,"repairFactory":repairFactory},function(data){
					 operateAlert(data.trim() == "true","更新成功！","更新失败！") ;
				},"text") ;
			}
		}) ;
	}) ;
	$("button[id^=edit-delete-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[2] ;
			$.post("pages/back/admin/repairFactory/delete.action",{"id":cid},function(data){
					 operateAlert(data.trim() == "true","删除成功！","删除失败！") ;
					 window.setTimeout("window.location='pages/back/admin/repairFactory/list.action'",2000); 
					/* if(data.trim() == "true"){
						 window.location.reload() ;
					 }*/
			},"text") ;
		});
	}) ;
}) ;