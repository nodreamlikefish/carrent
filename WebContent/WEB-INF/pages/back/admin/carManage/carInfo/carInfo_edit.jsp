<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%!public static final String CARCOLOR_LIST_URL = "pages/back/admin/carColor/list.action";%>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp" />
<script type="text/javascript" src="js/pages/back/admin/carManage/carInfo/carInfo_edit.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1" />
			<jsp:param name="msi" value="11" />
		</jsp:include>
		<input type="hidden" id=carId value="${carInfo.carId}"> 
		<div class="content-wrapper text-left">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;车辆参数-车辆信息</strong>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline">车牌号：<input type="text" class="form-control" style="width: 180px;" id="plateNo" value="${carInfo.plateNo }"  />
						</label>  
						<label class="form-inline" style="margin-left: 100px;">车主：
						<select class="form-control inline" id=carOwner>
							<c:forEach items="${allCarOwners}" var="carOwner">
								<option    ${carInfo.carOwner == carOwner.owner ? "selected" : "" }>${carOwner.owner}</option>
							</c:forEach>
						</select>
						</label>
						<label class="form-inline" style="margin-left: 250px;">
							<button id="edit-delete" class="btn btn-danger" onclick="deleteInfo()">
								<span class="glyphicon glyphicon-edit"></span>&nbsp;删除
							</button>
						</label>
					</div>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline">产权归属：
							<select class="form-control inline" id=carBelong>
								<c:forEach items="${allCarBelongs}" var="carBelong">
									<option  ${carInfo.carBelong == carBelong.belonger ? "selected" : "" } >${carBelong.belonger}</option>
								</c:forEach>
							</select>
						</label>  
						<label class="form-inline" style="margin-left: 45px;">车型：
							<select class="form-control inline" id=carType>
								<c:forEach items="${allCarTypes}" var="carTypes">
									<option  ${carInfo.carType == carTypes.carType ? "selected" : "" }>${carTypes.carType}</option>
								</c:forEach>
							</select>
						</label>
					</div>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline">发动机号：
							<input type="text" class="form-control" style="width: 180px;" id="engineNo" value="${carInfo.engineNo}" />
						</label>  
						<label class="form-inline"  style="margin-left: 70px;">车架号：
							<input type="text" class="form-control" style="width: 180px;" id="carJiaNo"  value="${carInfo.carJiaNo}"/>
						</label>
					</div>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline">颜色：
							<select class="form-control inline" id=color>
								<c:forEach items="${allCarColor}" var="carColor">
									<option ${carInfo.color == carColor.color ? "selected" : "" }>${carColor.color}</option>
								</c:forEach>
							</select>
						</label>  
						<label class="form-inline" style="margin-left: 175px;">燃油类型：
						<select class="form-control inline" id=fuelType>
							<c:forEach items="${allFuelTypes}" var="fuelType">
								<option ${carInfo.fuelType == fuelType.fuel ? "selected" : "" }>${fuelType.fuel}</option>
							</c:forEach>
						</select>
						</label>
					</div>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline">购置日期：
							<input placeholder="请选择购车日期" class="form-control laydate-icon" style="width: 180px;" 
							id="buyDate" onclick="laydate()" readonly="readonly" 
							value="<fmt:formatDate value="${carInfo.buyDate }" type="date" dateStyle="medium"/>"> 
						</label>  
						<label class="form-inline" style="margin-left: 70px;">经销商：
							<input type="text" class="form-control" style="width: 180px;" id="seller" value="${carInfo.seller }" />
						</label>
					</div>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline">车款：
							<input type="number" class="form-control" onchange="calculate()" 
							style="width: 180px;" id="carMoney" value="${carInfo.carMoney }" />
						</label>  
						<label class="form-inline">购置税：
							<input type="number" class="form-control" onchange="calculate()" 
							style="width: 180px;" id="buyTax" value="${carInfo.buyTax }" />
						</label>
						<label class="form-inline">全车款：
							<input type="number" class="form-control" style="width: 180px;" id="allMoney" readonly="readonly" value="${carInfo.allMoney }" />
						</label>
					</div>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline">折旧期：
							<input type="number" class="form-control" onchange="calculate()"  
							style="width: 180px;" id="zheJiuMonth" value="${carInfo.zheJiuMonth }"/>
						</label>  
						<label class="form-inline">折旧率：
							<input type="number" class="form-control" onchange="calculate()" 
							style="width: 180px;" id="zheJiuPercent" value="${carInfo.zheJiuPercent }" />
						</label>
						<label class="form-inline">月折旧额：
							<input type="number" class="form-control" onchange="calculate()" 
							style="width: 180px;" id="zheJiuFeePerMon" readonly="readonly" value="${carInfo.zheJiuFeePerMon }" />
						</label>
					</div>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline">下次验车时间：
							<input placeholder="请选择下次验车日期" class="form-control laydate-icon" style="width: 180px;" 
							id="nextYancheDate"onclick="laydate()" readonly="readonly" 
							value="<fmt:formatDate value="${carInfo.nextYancheDate }" type="date" dateStyle="medium"/>"> 
						</label>  
					</div>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline">备注：
							<input type="text" class="form-control" style="width: 800px;" id="memo" value="${carInfo.memo }"/>
						</label>  
					</div>
				</div>
				<div class="panel-body">
					<div class="inline relative">
						<label class="form-inline" style="margin-left: 500px;">
							<button id="edit-add" class="btn btn-warning">
								<span class="glyphicon glyphicon-edit"></span>&nbsp;保存
							</button>
						</label>  
					</div>
				</div>
				<div class="panel-footer">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp" />
				</div>
			</div>
		</div>


		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include
			page="/WEB-INF/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp" />
	<jsp:include
		page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
