<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp" />
<%!
	public static final String CARTYPE_ADD_URL="pages/back/admin/carType/addPre.action" ;
%>
<script type="text/javascript"
	src="js/pages/back/admin/carType/carType_list.js"></script>
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
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;车辆参数-车辆类型</strong>
					
				</div>
				<div class="panel-body">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center">编号</th>
								<th class="text-center">类型</th>
								<th class="text-center">操作</th>
								<th class="text-center"><a href="<%=CARTYPE_ADD_URL%>"><button id="edit-add"
										class="btn btn-warning">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;增加
									</button></a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allCarTypes}" var="xCarType">
								<tr>
									<td class="text-center"><span id="id-${xCarType.id}"
										style="cursor: pointer;">${xCarType.id}</span></td>
									<td class="text-center"><input type="text" id="color-${xCarType.id}"
										class="form-control" value="${xCarType.carType}"></td>
									<td class="text-center">
										<button id="edit-update-${xCarType.id}" class="btn btn-warning">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑
										</button>

										<button id="edit-delete-${xCarType.id}" class="btn btn-warning">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;删除
										</button>
									</td>
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