$(function(){
	$("button[id=edit-add]").each(function(){
		$(this).on("click",function(){
			belonger = $("#carBelong_add").val() ;
			belongType = $("#belongType").val() ;
			if(belongType == ""){
				operateAlert(false,"","请选择类型") ;
				return ;
			}
			if (belonger == "") { 
				operateAlert(false,"","请输入权属人") ;
			} else {
				$.post("pages/back/admin/carBelong/add.action",{"belonger":belonger,"belongType":belongType},function(data){
					 operateAlert(data.trim() == "true","增加成功！","增加失败！") ;
					 window.setTimeout("window.location='pages/back/admin/carBelong/list.action'",2000);
				},"text") ;
			}
		}) ;
	}) ;
}) ;