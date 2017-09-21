$(function(){
	$("button[id^=edit-update-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[2] ;
			console.log("编号：" +  cid) ;
			color = $("#color-" + cid).val() ;
			//console.log("车辆颜色" + color)
			if (color == "") { 
				operateAlert(false,"","汽车颜色不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/carColor/edit.action",{"id":cid,"color":color},function(data){
					 operateAlert(data.trim() == "true","汽车颜色更新成功！","汽车颜色更新失败！") ;
				},"text") ;
			}
		}) ;
	}) ;
	$("button[id^=edit-delete-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[2] ;
			$.post("pages/back/admin/carColor/delete.action",{"id":cid},function(data){
					 operateAlert(data.trim() == "true","汽车颜色删除成功！","汽车颜色删除失败！") ;
					/* if(data.trim() == "true"){
						 window.location.reload() ;
					 }*/
			},"text") ;
		});
	}) ;
}) ;