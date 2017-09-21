<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp" />
<%!
	public static final String CARINFO_ADD_URL="pages/back/admin/carManage/carInfo/addPre.action" ;
	public static final String CARINFO_EDIT_URL="pages/back/admin/carManage/carInfo/editPre.action" ;
%>
<script type="text/javascript"
	src="js/pages/back/admin/carBelong/carBelong_list.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1" />
			<jsp:param name="msi" value="11" />
		</jsp:include>
		<div class="content-wrapper text-left">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;车辆参数-车辆信息</strong>
					
				</div>
				<div class="panel-body " style=" overflow:scroll;width:1100px;height:540px; ">
					<a href="<%=CARINFO_ADD_URL %>">
						<button id="edit-add" class="btn btn-warning">
							<span class="glyphicon glyphicon-edit"></span>&nbsp;增加
						</button>
					</a>
					<table class="table table-condensed table-hover table-striped " style="width:3500px;height:510px;" >
						<thead>
							<tr>
								<th class="text-center" style="width:60px">编号</th>
								<th class="text-center" style="width:120px">车牌号</th>
								<th class="text-center" style="width:150px">车型</th>
								<th class="text-center" style="width:200px">车主</th>
								<th class="text-center" style="width:200px">产权归属</th>
								<th class="text-center" style="width:120px">发动机号</th>
								<th class="text-center" style="width:120px">车架号</th>
								<th class="text-center" style="width:100px">全车款</th>
								<th class="text-center" style="width:200px">购置日期</th>
								<th class="text-center" style="width:60px">颜色</th>
								<th class="text-center" style="width:120px">燃油类型</th>
								<th class="text-center" style="width:120px">经销商</th>
								<th class="text-center" style="width:60px">车款</th>
								<th class="text-center" style="width:150px">购置税</th>
								<th class="text-center" style="width:120px">折旧期</th>
								<th class="text-center" style="width:100px">折旧率</th>
								<th class="text-center" style="width:120px">月折旧额</th>
								<th class="text-center" style="width:200px">下次验车日期</th>
								<th class="text-center" style="width:300px">备注</th>
								<th class="text-center" style="width:120px">状态</th>
								<th class="text-center" style="width:120px">是否处理</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${carInfos}" var="carInfo">
								<tr>
									<td class="text-center"><span id="carId"
										style="cursor: pointer;">${carInfo.carId}</span></td>
									<td class="text-center"><a href="<%=CARINFO_EDIT_URL  %>?carId=${carInfo.carId}"><span style="cursor: pointer;">${carInfo.plateNo}</span></a></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.carType}</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.carOwner}</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.carBelong}</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.engineNo}</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.carJiaNo}</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.allMoney  }</span></td>
									<td class="text-center"><span style="cursor: pointer;"><fmt:formatDate value="${carInfo.buyDate}" pattern="yyyy-MM-dd" /></span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.color}</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.fuelType}</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.seller }</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.carMoney }</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.buyTax  }</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.zheJiuMonth  }</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.zheJiuPercent  }</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.zheJiuFeePerMon  }</span></td>
									<td class="text-center"><span style="cursor: pointer;"><fmt:formatDate value="${carInfo.nextYancheDate}" pattern="yyyy-MM-dd" /></span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.memo   }</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.status  }</span></td>
									<td class="text-center"><span style="cursor: pointer;">${carInfo.isDeal  }</span></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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
	<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp" />