<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/taglist/taglist.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Page Admin</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/common/admin/css/styles.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/common/admin/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/all.js"></script>
</head>
<body class="sb-nav-fixed">
	<!-- header -->
	<%@include file="/include/admin/header.jsp" %>
	<!-- header -->
	
	<!--big main -->
	<div id="layoutSidenav">
	<%@include file="/include/admin/menu.jsp" %>
		<div id="layoutSidenav_content">
			<!--main-->
                <main>
                    <div class="container-fluid px-4">
                    <br/>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fa-brands fa-steam"></i>
                                Dota 2 Gamescom Trailer
                            </div>
                            <div class="card-body">
                                
                                <video controls autoplay="autoplay" loop="loop" width="100%" height="100%">
  									<source src='<c:url value="/image/dota2.mp4"/>'>
								</video>
                                
                            </div>
                        </div>
                    </div>
                </main>
            <!--end main-->
            <%@include file="/include/admin/footer.jsp" %>
		</div>
	</div>
	<!--big main -->
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/bundle.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/scripts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/Chart.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/datatables-simple-demo.js.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/demo/chart-area-demo.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/admin/js/demo/chart-bar-demo.js"></script>
</body>
</html>