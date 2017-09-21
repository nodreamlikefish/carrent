$(function(){
	$("button[id^=edit-update-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[2] ;
			console.log("编号：" +  cid) ;
			carType = $("#color-" + cid).val() ;
			if (carType == "") { 
				operateAlert(false,"","汽车类型不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/carType/edit.action",{"id":cid,"carType":carType},function(data){
					 operateAlert(data.trim() == "true","汽车类型更新成功！","汽车类型更新失败！") ;
				},"text") ;
			}
		}) ;
	}) ;
	$("button[id^=edit-delete-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[2] ;
			$.post("pages/back/admin/carType/delete.action",{"id":cid},function(data){
					 operateAlert(data.trim() == "true","汽车类型删除成功！","汽车类型删除失败！") ;
					 window.setTimeout("window.location='pages/back/admin/carType/list.action'",2000); 
					/* if(data.trim() == "true"){
						 window.location.reload() ;
					 }*/
			},"text") ;
		});
	}) ;
}) ;