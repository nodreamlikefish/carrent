$(function(){
	$("button[id^=edit-update-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[2] ;
			console.log("编号：" +  cid) ;
			belonger = $("#belonger-" + cid).val() ;
			belongType = $("#belongType-"+ cid).val() ;
			if(belongType == ""){
				operateAlert(false,"","请选择类型") ;
				return ;
			}
			if (belonger == "") { 
				operateAlert(false,"","权属人不允许为空，请输入") ;
			} else {
				$.post("pages/back/admin/carBelong/edit.action",{"id":cid,"belonger":belonger,"belongType":belongType},function(data){
					 operateAlert(data.trim() == "true","更新成功！","更新失败！") ;
				},"text") ;
			}
		}) ;
	}) ;
	$("button[id^=edit-delete-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[2] ;
			$.post("pages/back/admin/carBelong/delete.action",{"id":cid},function(data){
					 operateAlert(data.trim() == "true","删除成功！","删除失败！") ;
					 window.setTimeout("window.location='pages/back/admin/carBelong/list.action'",2000); 
					/* if(data.trim() == "true"){
						 window.location.reload() ;
					 }*/
			},"text") ;
		});
	}) ;
}) ;