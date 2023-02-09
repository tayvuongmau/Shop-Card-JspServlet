<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/taglist/taglist.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign in</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/web/login/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/web/login/font-awesome.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/web/login/login.css" />

</head>
<body>

	<div class="container-fluid">
		<div class="row no-gutter">
			<!-- The image half -->
			<div class="col-md-6 d-none d-md-flex bg-image"></div>


			<!-- The content half -->
			<div class="col-md-6 bg-light">
				<div class="login d-flex align-items-center py-5">

					<!-- Demo content-->
					<div class="container">
						<div class="row">
							<div class="col-lg-10 col-xl-7 mx-auto">
								<h3 class="display-4">
									<b>Đăng ký tài khoản</b>
								</h3>
								<br />
								<form action="/PRJ321x_Assignment3/SignIn" method="post">
									<table>
									<tr class="form-group mb-3" >
										<td><input style="width: 200%" id="inputUser" type="text" placeholder="Tên đăng nhập" name="newname" value="${newname}" class="form-control rounded-pill border-0 shadow-sm px-4"><p/></td>
									</tr>
									<tr class="form-group mb-3">
										<td><input style="width: 200%" id="inputPassword" type="password" placeholder="Mật khẩu" name="newpassword" value="${newpassword}" class="form-control rounded-pill border-0 shadow-sm px-4 text-primary"><p/></td>
									</tr>
									<tr class="form-group mb-3">
										<td><input style="width: 200%" id="inputEmail" type="email" placeholder="E-mail" name="newmail" value="${newmail}" class="form-control rounded-pill border-0 shadow-sm px-4"><p/></td>
									</tr>
									<tr class="form-group mb-3">
										<td><input style="width: 200%" id="inputBirthday" type="date" placeholder="Ngày sinh" name="newbirthday" value='<fmt:formatDate value="${newbirthday}" pattern="yyyy-MM-dd"/>' class="form-control rounded-pill border-0 shadow-sm px-4"><p/></td>
									</tr>
									<tr class="form-group mb-3">
										<td><input style="width: 200%" id="inputTelephone" type="tel" placeholder="Số điện thoại" name="newtel" value="${newtel}" class="form-control rounded-pill border-0 shadow-sm px-4"><p/>
										<p style="color: red;">${validateErr}</p></td>
									</tr>
									<tr>
										<td><button type="submit" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Đăng ký</button></td>
										<td><button style="width: 400%" type="reset" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Xoá</button></td>
									</tr>
									</table>
									<div class="text-center d-flex justify-content-between mt-4"> <a href="index.jsp" class="font-italic text-muted">					
												<i>Trở lại trang chủ</i>						
										</a>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- End -->

				</div>
			</div>
			</div>
			</div>
			<!-- End -->
			

			<script type="text/javascript" src="${pageContext.request.contextPath}/common/web/login/bootstrap.bundle.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/common/web/login/jquery-3.3.1.slim.min.js"></script>
</body>
</html>