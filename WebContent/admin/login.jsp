<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>

	<meta charset="utf-8">

	<title>Login</title>

	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Varela+Round">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/admin/css/style.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/ckeditor/ckeditor.js"></script><style>.cke{visibility:hidden;}</style>
    <script src="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.css">
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

</head>

<body>

	<div id="login">

		<h2 style="margin-left: 2px;margin-right:-6px; margin-bottom: -0px;"><span>Nhân Viên Đăng Nhập</span></h2>

		<form action="<%=request.getContextPath()%>/admin/login" method="POST" class="form-login">

			<fieldset>

				<p><label for="username">Username</label></p>
				<p><input type="username" name ="username" class="username" value=""></p>

				<p><label for="password">Password</label></p>
				<p><input type="password" name = "password" class="password" value="" ></p>

				<input class="submit-green" name="submit" type="submit" value="Đăng Nhập" /> 

			</fieldset>

		</form>

	</div> <!-- end login -->
		<script type="text/javascript">
$( document ).ready(function() {
	$(".form-login").validate({
		rules: {
			username: {
				required: true,
			},
			password: {
				required: true,
			}
			
		},
		messages: {
			username: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập username</span>",
			},
			password: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập password</span>",
			},
			
		}
	});
});
</script>
	<%
  	String msg1 = "";
    if(request.getParameter("msg")!=null){
    	msg1 = request.getParameter("msg");
    }
 	if(msg1.equals("login0")){
%>
	<script type="text/javascript">
	swal("Lỗi rồi!", "Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng kiểm tra lại!!!")
	</script>
	<%} %>
</body>	
</html>