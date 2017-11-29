<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ADMIN ASHE</title>
<link
	href="<%=request.getContextPath()%>/templates/admin/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link
	href="<%=request.getContextPath()%>/templates/admin/css/bootstrap-switch.min.css"
	rel="stylesheet" media="screen">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/templates/admin/css/style.css">
<link
	href="<%=request.getContextPath()%>/templates/admin/css/animate.min.css"
	rel="stylesheet" media="screen">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1"
	crossorigin="anonymous">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/js/ckeditor/ckeditor.js"></script>
<script
	src="<%=request.getContextPath()%>/templates/public/sweetalert-master/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/templates/public/sweetalert-master/dist/sweetalert.css">
<style>
.cke {
	visibility: hidden;
}
</style>
</head>
<body>
	<!-- header -->

	<header>
	<div class="header-banner navbar-fixed-top">
		<div class="navbar navbar-static-top bs-docs-nav">
			<div class="container">
				<nav class="collapse navbar-collapse bs-navbar-collapse">
				<ul class="nav navbar-nav header-menu">
					<li><a href="<%=request.getContextPath()%>/admin/index"><img
							src="<%=request.getContextPath()%>/templates/admin/images/logo2.png"
							alt="" class="img-rounded corners"
							style="width: 100px; height: 30px;"></a></li>
					<%
						HttpSession ss = request.getSession();
						Users objUsers = (Users) ss.getAttribute("objAdmin");
						String style = "";
						if (objUsers != null) {
							if (objUsers.isAdmin() == true) {
								style = "block";
							} else {
								style = "none";
							}
						}
					%>
					<li><a href="<%=request.getContextPath()%>/admin/indexUsers"
						style="display:<%=style%>;">Nhân Viên</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexOrder">Giao
							Dịch</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexNews"
						style="display:<%=style%>;">Tin Tức</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexPolicy"
						style="display:<%=style%>;">Chính Sách</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexContact">Liên
							Hệ</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexRate"
						style="display:<%=style%>;">Tỷ Giá</a></li>
				</ul>
				<div class="nav navbar-nav navbar-right ">
					<div
						class="header-login dropdown animated fadeInDown animation-delay-11">
						<%-- <a href="<%=request.getContextPath()%>/admin/login"><i
						class="fa fa-user"></i> Login</a> --%>

						<%
							if (objUsers != null) {
						%>
						<a href="" data-toggle="modal" data-target="#editUsers"><i
							class="fa fa-user"></i> <%=objUsers.getFullName()%></a> <a
							href="<%=request.getContextPath()%>/admin/logout"> <span
							style="font-weight: bold">Log out</span></a>
						<%
							} else {
						%>
						<a href="#"><i class="fa fa-user"></i> Nhân Viên</a> <a
							<%-- href="<%=request.getContextPath()%>/login" --%> href="<%=request.getContextPath()%>/admin/login"
							data-toggle="modal" data-target="#login"> <span
							style="font-weight: bold">Login</span></a>
						<%
							}
						%>
					</div>
				</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- end header --> 
<%
 	String msg1 = "";
 	if (request.getParameter("msg") != null) {
 		msg1 = request.getParameter("msg");
 	} else if (request.getParameter("login") != null) {
 		msg1 = request.getParameter("login");
 	} else if (request.getParameter("del") != null) {
 		msg1 = request.getParameter("del");
 	} else if (request.getParameter("edit") != null) {
 		msg1 = request.getParameter("edit");
 	}
 	if (msg1.equals("login1")) {
 %> <script type="text/javascript">
		swal({
			title : "Chúc mừng bạn đã đăng nhâp thành công!",
			html : true
		});
	</script> <%
 	} else if (msg1.equals("success")) {
 %> <script type="text/javascript">
		swal("Tạm Biệt", "Đăng xuất thành công. Hẹn gặp lại!!!")
	</script> <%
 	} else if (msg1.equals("add0")) {
 %> <script type="text/javascript">
		swal("Thất Bại", "Trạng Thái Của Đơn Hàng Đã Bị Trùng!!!")
	</script> <%
 	} else if (msg1.equals("add2")) {
 %> <script type="text/javascript">
		swal("Thất Bại", "Đồng Ngoại Tệ Đã Tồn Tại!!!")
	</script> <%
 	} else if (msg1.equals("del1")) {
 %> <script type="text/javascript">
		swal("Thành Công", "Xóa Thành Công!!!")
	</script> <%
 	} else if (msg1.equals("edit3")) {
 %> <script type="text/javascript">
		swal("Thất Bại", "Sửa Thất Bại!!!")
	</script> <%
 	} else if (msg1.equals("del0")) {
 %> <script type="text/javascript">
		swal("Thất Bại", "Xóa Thất Bại!!!")
	</script> <%
 	} else if (msg1.equals("edit0")) {
 %> <script type="text/javascript">
		swal("Thất Bại", "Trạng Thái Đã Tồn Tại!!!")
	</script> <%
 	} else if (msg1.equals("edit2")) {
 %> <script type="text/javascript">
		swal("Thất Bại", "Đồng Ngoại Tệ Đã Tồn Tại!!!")
	</script> <%
 	} else if (msg1.equals("fail")) {
 %> <script type="text/javascript">
		swal("Thất Bại", "Bạn Không Phải Admin, Không Thể Đăng Nhập")
	</script> <%
 	}
 %> </header>