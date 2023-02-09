<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/taglist/taglist.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Bảng danh sách sản phẩm</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/common/admin/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/common/admin/css/styles.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/common/admin/js/all.js"></script>

</head>
<body class="sb-nav-fixed">
	<!-- header -->
	<%@include file="/include/admin/header.jsp"%>
	<!-- header -->

	<!--big main -->
	<div id="layoutSidenav">
		<%@include file="/include/admin/menu.jsp"%>
		<div id="layoutSidenav_content">
			<!--main-->
			<div class="container-fluid px-4">
				<h1 class="mt-4">Bảng dữ liệu</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a
						href="/PRJ321x_Assignment3/template/admin/admin.jsp">Dashboard</a></li>
					<li class="breadcrumb-item active">Bảng danh sách sản phẩm</li>
				</ol>

				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> Bảng danh sách sản phẩm
					</div>
					<br>
					<div>
						<span style="color: green; font-weight: bold; text-align: center;"><h3>${success}</h3></span>
						<span style="color: red; font-weight: bold; text-align: center;"><h3>${err}</h3></span>
					</div>
					<div class="card-body">
						<table style="width: 100%;">
							<tr>
								<th style="border-width: 1px; text-align: center;">Product ID</th>
								<th style="border-width: 1px; text-align: center;">Product Name</th>
								<th style="border-width: 1px; text-align: center;">Product Description</th>
								<th style="border-width: 1px; text-align: center;">Product Price</th>
								<th style="border-width: 1px; text-align: center;">Product Src</th>
								<th style="border-width: 1px; text-align: center;">Product Type</th>
								<th style="border-width: 1px; text-align: center;">Number</th>
								<th style="border-width: 1px; text-align: center;">Update</th>
								<th style="border-width: 1px; text-align: center;">Delete</th>
							</tr>
							<c:forEach items="${list}" var="e">
								<tr>
									<td style="border-width: 1px; text-align: center;">${e.product_id}</td>
									<td style="border-width: 1px; text-align: center;">${e.product_name}</td>
									<td style="border-width: 1px; text-align: center;">${e.product_des}</td>
									<td style="border-width: 1px; text-align: center;">${e.product_price}
										($)</td>
									<td style="border-width: 1px; text-align: center;">${e.product_src}</td>
									<td style="border-width: 1px; text-align: center;">${e.product_type}</td>
									<td style="border-width: 1px; text-align: center;">${e.number}</td>
									<td style="border-width: 1px; text-align: center;"><a
										href="/PRJ321x_Assignment3/UpdateProduct?product_name=${e.product_name}">Update</a>
									</td>
									<td style="border-width: 1px; text-align: center;"><a
										href="/PRJ321x_Assignment3/DeleteProduct?product_name=${e.product_name}"
										onclick="return confirm('Bạn có chắc muốn xoá ?')" >Delete</a>
									</td>

								</tr>
							</c:forEach>
						</table>
						<p />
						<div style="text-align: center;">
							<c:forEach begin="1" end="${endPage}" var="i">
								<a
									style="border: 1px solid; padding: 0.2% 0.5% 0.2% 0.5%; border-radius: 50%; text-decoration: none; font-weight: bold; margin: 0.5%;"
									href="LoadProductAdmin?index=${i}">${i}</a>
							</c:forEach>
						</div>
						<p />
					</div>
				</div>
			</div>
			<div class="container-fluid px-4">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i><a style="text-decoration: none;" href="${pageContext.request.contextPath}/template/admin/insertProduct.jsp" >Thêm sản phẩm mới</a>
					</div>
				</div>
			</div>
			<!--end main-->
			<%@include file="/include/admin/footer.jsp"%>
		</div>
	</div>
	<!--big main -->



	<script type="text/javascript"
		src="${pageContext.request.contextPath}/common/admin/js/bundle.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/common/admin/js/scripts.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/common/admin/js/datatables-simple-demo.js.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"></script>
</body>
</html>