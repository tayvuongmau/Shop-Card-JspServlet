<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="position: fixed; z-index: 1; width: 100%;">
    <div class="container px-4 px-lg-5">
        <a style="margin: 0%; padding: 0%; text-transform: uppercase; text-align: center;" class="navbar-brand" href="/PRJ321x_Assignment3/LoadProduct"><img src="${pageContext.request.contextPath}/logo/logo1.png" width="15%"/><h4>Defense of the Ancients</h4></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" style="margin-top: 2%;">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="text-transform: uppercase; font-weight: bold;">Danh mục</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/PRJ321x_Assignment3/Streng">Card Hero Streng</a></li>
                        <li><a class="dropdown-item" href="/PRJ321x_Assignment3/Intelligent">Card Hero Intelligent</a></li>
                        <li><a class="dropdown-item" href="/PRJ321x_Assignment3/Agility">Card Hero Agility</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                	<form action="SearchProductByName" class="d-flex" >
                		<input type="text" name="productName"/><input style="" type="submit" value="Tìm kiếm"/>
                	</form>
                </li>
            </ul>
            <form class="d-flex">
                <button class="btn btn-outline-dark" type="submit" style="padding: 3px 6px 3px 6px;">
                    <a href="${pageContext.request.contextPath}/template/web/mycart.jsp" style="text-decoration: none;"><i class="fa fa-shopping-cart"></i>Cart</a>  
                    <span class="badge bg-dark text-white ms-1 rounded-pill">${size}</span>
                </button>
            </form>
            
            <c:if test="${empty account}">
	            <form class="d-flex">
	                <a class="btn btn-outline-dark" href="/PRJ321x_Assignment3/Login?action=login" style="border: none;">
	                    <i>Đăng nhập</i>
	                </a>
	            </form>
	            <form class="d-flex">
	                <a class="btn btn-outline-dark" href="/PRJ321x_Assignment3/SignIn?action=signin" style="border: none;">
	                    <i>Đăng ký</i>
	                </a>
	            </form>
            </c:if>
            <c:if test="${not empty account}">
	            <form class="d-flex">
	                <a class="btn btn-outline-dark" href="#" style="border: none;">
	                	<i class="fas fa-user fa-fw"></i><br/>${account.username}
	                    
	                </a>
	            </form>
	            <form class="d-flex">
	                <a class="btn btn-outline-dark" href="/PRJ321x_Assignment3/Logout" style="border: none;">
	                    <i>Đăng xuất</i>
	                </a>
	            </form>
            </c:if>
        </div>
    </div>
</nav>