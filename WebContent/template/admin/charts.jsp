<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/taglist/taglist.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Bảng danh sách tài khoản người dùng</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/admin/css/styles.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/admin/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/all.js"></script>
</head>

<body class="sb-nav-fixed">
	<!-- header -->
	<%@include file="/include/admin/header.jsp"%>
	<!-- header -->

	<!-- big main -->
	<div id="layoutSidenav">
		<%@include file="/include/admin/menu.jsp"%>
		<!-- main -->
		<div id="layoutSidenav_content">
			<!-- main -->
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Bảng danh sách tài khoản người dùng</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="/PRJ321x_Assignment3/template/admin/admin.jsp">Dashboard</a></li>
						<li class="breadcrumb-item active">Bảng danh sách tài khoản người dùng</li>
					</ol>
					<div class="card mb-4">
						<table style="text-align: center;">
							<tr>
								<th style="border-width: 1px; text-align: center;">Username</th>
								<th style="border-width: 1px; text-align: center;">Password</th>
								<th style="border-width: 1px; text-align: center;">Email</th>
								<th style="border-width: 1px; text-align: center;">Telephone</th>
								<th style="border-width: 1px; text-align: center;">Birthday</th>
							</tr>
							<c:forEach items="${account}" var="i">
							<tr>
								<td style="border-width: 1px; text-align: center;">${i.username}</td>
								<td style="border-width: 1px; text-align: center;">${i.password}</td>
								<td style="border-width: 1px; text-align: center;">${i.email}</td>
								<td style="border-width: 1px; text-align: center;">${i.phone}</td>
								<td style="border-width: 1px; text-align: center;"><fmt:formatDate value="${i.birthday}" pattern="dd/MM/yyy"/></td>
							</tr>
							</c:forEach>
						</table>
						<p/>
						<div style="text-align: center; ">
						<c:forEach begin="1" end="${endPage}" var="i">
							<a style="text-decoration: none; border: 1px solid; padding: 0.2% 0.7% 0.2% 0.7%; border-radius: 50%; font-weight: bold; margin: 0.2%;"
							href="/PRJ321x_Assignment3/LoadUsername?index=${i}" >${i}</a>
						</c:forEach>
						</div>
						<p/>	
					</div>
				</div>
			</main>
			<!-- main -->
			<%@include file="/include/admin/footer.jsp"%>
		</div>
		<!-- main -->
	</div>
	<!-- big main -->



	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/bundle.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/scripts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/Chart.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/demo/chart-bar-demo.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/demo/chart-area-demo.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/demo/chart-pie-demo.js"></script>
</body>
</html>