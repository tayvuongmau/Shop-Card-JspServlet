<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/taglist/taglist.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>

<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/common/web/homepage/favicon.ico" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/common/web/homepage/styles.css" />

</head>
<body>
	<!-- Header -->
	<%@include file="/include/web/header.jsp"%>
	<!-- End Header -->

	<header style="width: 70%; margin: auto;">
		<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="${pageContext.request.contextPath}/logo/anhbia1.JPG" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="${pageContext.request.contextPath}/logo/anhbia2.JPG" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="${pageContext.request.contextPath}/logo/anhbia3.JPG" class="d-block w-100" alt="...">
				</div>
			</div>
		</div>
	</header>

	<!-- Main -->

	<div class="container-fluid px-4" style="margin: 0.2%;">
		<div class="card mb-4">
			<div class="card-header" style="text-align: center;">
				<h3 class="fas fa-table me-1">Danh sách chi tiết sản phẩm trong giỏ hàng</h3>
			</div>
			<div>
				<table style="border: 1px solid; margin: auto; width: 60%;">
					<tr style="border: 1px solid; text-align: center;">
						<th style="border: 1px solid;">Số thứ tự</th>
						<th style="border: 1px solid;">Tên thẻ Card</th>
						<th style="border: 1px solid;">Số lượng</th>
						<th style="border: 1px solid;">Giá bán</th>
						<th style="border: 1px solid;">Thành tiền</th>
						<th style="border: 1px solid;">Xoá sản phẩm</th>
					</tr>
					<c:set var="stt" value="0" />
					<!-- gọi ra session cart để lấy list sản phẩm -->
					<c:set var="o" value="${sessionScope.cart}" />
					<c:forEach items="${o.items}" var="i">
						<c:set var="stt" value="${stt+1}" />
						<tr style="border: 1px solid; text-align: center;">
							<td style="border: 1px solid;">${stt}</td>
							<td style="border: 1px solid;">${i.products.product_name}</td>
							<td style="border: 1px solid;">
								<button><a style="text-decoration: none;" href="/PRJ321x_Assignment3/Process?quantity=-1&product_id=${i.products.product_id}">-</a></button> 
								${i.quantity}
								<button><a style="text-decoration: none;" href="/PRJ321x_Assignment3/Process?quantity=+1&product_id=${i.products.product_id}">+</a></button>
							</td>
							<td style="border: 1px solid;">${i.products.product_price}($)</td>
							<td style="border: 1px solid;">${i.quantity*i.products.product_price}($)</td>
							<td style="border: 1px solid;">
							<form action="/PRJ321x_Assignment3/Process" method="post">
								<input type="hidden" name="product_id"value="${i.products.product_id}" />
								<input type="submit" value="Xoá sản phẩm">
							</form>
							</td>
						</tr>
					</c:forEach>
						<tr style="text-align: center;">
							<td style="border: 1px solid;" colspan="5"><b>Tổng tiền :</b></td>
							<td style="border: 1px solid;"><b>${money}($)</b></td>
						</tr>
				</table>
				<form style="text-align: center; margin: 0.5%;" action="/PRJ321x_Assignment3/FinalOrder" method="post">
					<input type="submit" value="Thanh toán" >
				</form>
			</div>
		</div>
	</div>
	<!-- End Main -->

	<!-- Footer -->
	<%@include file="/include/web/footer.jsp"%>
	<!-- End Footer -->

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/common/web/homepage/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/common/web/homepage/scripts.js"></script>
</body>
</html>

