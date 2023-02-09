<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/taglist/taglist.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>

<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/common/web/homepage/favicon.ico" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/web/homepage/styles.css" />
<link rel="stylesheet" href='<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>' />
<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/all.js"></script>
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

	<div class="container-fluid px-4" style="margin: 0.2% auto 0.2% auto; width: 50%;">
		<div class="card mb-4">
			<div class="card-header" style="text-align: center;">
				<h3 class="fas fa-table me-1">Thông tin về sản phẩm</h3>
			</div>
			<div style="width: 100%;">
				<div style="width: 40%; float: left;">
					<c:set scope="page" var="img" value="${e.product_src}.${e.product_type}"></c:set>
					<img class="card-img-top" src="${pageContext.request.contextPath}/image/${img}"/>
				</div>
				<div style="width: 60%; float: right; padding-top: 8%; padding-left: 5%;">
					<table>
						<tr>
							<td><b><h4>Tên thẻ Card :</h4></b></td>
							<td><h4>${e.product_name}</h4></td>
						</tr>
						<tr>
							<td><b><h4>Thuộc tính Card hero :</h4></b></td>
							<td><h4>${e.product_des}</h4></td>
						</tr>
						<tr>
							<td><b><h4>Giá thẻ Card :</h4></b></td>
							<td><h4>${e.product_price} ($)</h4></td>
						</tr>
					</table>
					<div style="margin-top: 3%;" class="text-center">
						<a class="btn btn-outline-dark mt-auto" href="/PRJ321x_Assignment3/BuyProduct?product_id=${e.product_id}"><i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng</a>
					</div>
				</div>
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

