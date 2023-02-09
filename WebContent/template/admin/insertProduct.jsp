<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/taglist/taglist.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Thêm mới sản phẩm</title>
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
				<h1 class="mt-4">Thêm sản phẩm mới</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a
						href="/PRJ321x_Assignment3/template/admin/admin.jsp">Dashboard</a></li>
				</ol>

				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> Nhập thông tin sản phẩm
					</div>
					<div class="card-body">
					
						<form action="/PRJ321x_Assignment3/InsertProduct" method="post">
							<table>
								<tr>
									<td style="font-weight: bold;">Product name </td>
									<td><input type="text" name="product_name" required/></td>
								</tr>
								<tr>
									<td style="font-weight: bold;">Product description </td>
									<td>
										<select name="product_des" style="width: 100%;">
											<option value="" style="text-align: center;">--- Lựa chọn ---</option>
											<option value="Hero Streng">Hero Streng</option>
											<option value="Hero Intelligent">Hero Intelligent</option>
											<option value="Hero Agility">Hero Agility</option>
										</select>
									</td>
								
									<!-- <td style="font-weight: bold;">Product description </td>
									<td><input type="text" name="product_des" required/></td> -->
								</tr>
								<tr>
									<td style="font-weight: bold;">Product price </td>
									<td><input type="number" name="product_price" required/></td>
								</tr>
								<tr>
									<td style="font-weight: bold;">Product src </td>
									<td><input type="text" name="product_src" required/></td>
								</tr>
								<tr>
									<td style="font-weight: bold;">Product type </td>
									<td><input type="text" name="product_type" required/></td>
								</tr>
								<tr>
									<td style="font-weight: bold;">Number </td>
									<td><input type="number" name="number" required/></td>
								</tr>
								<tr>
									<td colspan="2" style="font-weight: bold; text-align: center;"><input type="submit" value="Insert"/><input type="reset" value="Clear" /></td>
								</tr>
							</table>
						</form>
						<div><p style="color: red; font-weight: bold;">${Err}</p></div>
					
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