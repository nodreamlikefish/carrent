<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%!
	public static final String INDEX_URL = "pages/back/index.jsp" ;	
	/* 车辆管理-基本设置路径信息 */
	public static final String CARCOLOR_LIST_URL = "pages/back/admin/carColor/list.action" ;
	public static final String CARTYPE_LIST_URL = "pages/back/admin/carType/list.action" ;
	public static final String FUELTYPE_LIST_URL = "pages/back/admin/fuelType/list.action" ;
	public static final String CAROWNER_LIST_URL = "pages/back/admin/carOwner/list.action" ;
	public static final String REPAIRFACTORY_LIST_URL = "pages/back/admin/repairFactory/list.action" ;
	public static final String CARBELONG_LIST_URL = "pages/back/admin/carBelong/list.action" ;
	
	/* 车辆管理-车辆信息路径信息 */
	public static final String CARINFO_LIST_URL = "pages/back/admin/carManage/carInfo/list.action" ;
	
	
/* 	public static final String EMP_ADD_URL = "pages/back/admin/emp/add_pre.action" ;
	public static final String EMP_LIST_URL = "pages/back/admin/emp/list.action" ;
	
	public static final String TRAVEL_ADD_URL = "pages/back/admin/travel/add_pre.action" ;
	public static final String TRAVEL_LIST_SELF_URL = "pages/back/admin/travel/list_self.action" ;
	public static final String TRAVEL_LIST_EMP_URL = "pages/back/admin/travel/list_emp.action" ;
	
	public static final String TRAVEL_AUDIT_URL = "pages/back/admin/travelaudit/prepare.action" ;
	public static final String TRAVEL_LIST_URL = "pages/back/admin/travelaudit/list.action" ; */
%>
<aside class="main-sidebar"> 
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="upload/member/nophoto.png" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>李强</p>
				<%-- <p>${ename}</p> --%>
			</div> 
		</div>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><i class="fa fa-university"></i> 汽车租赁管理系统</li>
				
					<li class="treeview ${param.mi==1 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-sitemap"></i> <span>车辆管理-基本设置</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
						
							<li class="${param.msi==11 ? 'active' : ''}"><a href="<%=CARCOLOR_LIST_URL%>"><i class="fa fa-object-group"></i>
								基础参数-车辆颜色</a></li>
							<li class="${param.msi==11 ? 'active' : ''}"><a href="<%=CARTYPE_LIST_URL%>"><i class="fa fa-object-group"></i>
								基础参数-车辆类型</a></li>
							<li class="${param.msi==12 ? 'active' : ''}"><a href="<%=FUELTYPE_LIST_URL%>"><i class="fa fa-user-plus"></i>
								基础参数-燃油类型</a></li>
							<li class="${param.msi==13 ? 'active' : ''}"><a href="<%=CAROWNER_LIST_URL%>"><i class="fa fa-users"></i>
								基础参数-车主</a></li>
							<li class="${param.msi==13 ? 'active' : ''}"><a href="<%=REPAIRFACTORY_LIST_URL%>"><i class="fa fa-users"></i>
								基础参数-维修厂</a></li>
							<li class="${param.msi==13 ? 'active' : ''}"><a href="<%=CARBELONG_LIST_URL%>"><i class="fa fa-users"></i>
								基础参数-车属人</a></li>
					</ul></li>
					<li class="treeview ${param.mi==1 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-sitemap"></i> <span>车辆管理-车辆信息</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==11 ? 'active' : ''}"><a href="<%=CARINFO_LIST_URL%>"><i class="fa fa-object-group"></i>
								车辆信息</a></li>
							<%-- <li class="${param.msi==13 ? 'active' : ''}"><a href="<%=EMP_LIST_URL%>"><i class="fa fa-users"></i>
								雇员列表</a></li> --%>
					</ul></li>
				<%-- <c:if test="${level == 2 || level == 1}">
					<li class="treeview ${param.mi==2 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa  fa-car"></i>
						<span>差旅安排</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==21 ? 'active' : ''}"><a href="<%=TRAVEL_ADD_URL%>"><i
								class="fa fa-train"></i> 出差申请</a></li>
							<li class="${param.msi==22 ? 'active' : ''}"><a href="<%=TRAVEL_LIST_SELF_URL%>"><i
								class="fa fa-history"></i> 我的申请</a></li>
						<li class="${param.msi==23 ? 'active' : ''}"><a href="<%=TRAVEL_LIST_EMP_URL%>"><i
								class="fa fa-train"></i> 我的出差</a></li>
					</ul></li>
				</c:if>
				<li class="treeview  ${param.mi==3 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-bitbucket-square"></i>
					<span>222</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
						<li class="${param.msi==31 ? 'active' : ''}"><a href="<%=TRAVEL_AUDIT_URL%>"><i
							class="fa fa-plane"></i> 待审核申请</a></li>
						<li class="${param.msi==32 ? 'active' : ''}"><a href="<%=TRAVEL_LIST_URL%>"><i
							class="fa fa-tasks"></i> 申请列表</a></li>
				</ul></li> --%>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>