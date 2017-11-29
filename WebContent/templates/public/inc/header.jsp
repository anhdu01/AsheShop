<%@page import="model.ModelRate"%>
<%@page import="library.TimeConvert"%>
<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>ASHE SHOP</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/css/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/css/animate.css">
  	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
  	<link rel="stylesheet" type="text/css" href="https://chipo.vn/static/web/css/owl.carousel.min.css">
	<link rel="stylesheet" type="text/css" href="https://chipo.vn/static/web/css/responsive.css">
	<link rel="stylesheet" type="text/css" href="https://chipo.vn/static/skins/lib/loading-bar/loading-bar.min.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/jquery.validate.js"></script>
  	<script src="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.css">
</head>
<body>
	<button onclick="topFunction()" id="myBtn" title="Lên TOP"><i class="fa fa-sort-asc" style="font-size:18px"></i></button>
	<script>
		window.onscroll = function() {
			scrollFunction()
		};
		function scrollFunction() {
			if (document.body.scrollTop > 100
					|| document.documentElement.scrollTop > 100) {
				document.getElementById("myBtn").style.display = "block";
			} else {
				document.getElementById("myBtn").style.display = "none";
			}
		}
		function topFunction() {
			document.body.scrollTop = 0;
			document.documentElement.scrollTop = 0;
		}
	</script>
	<!-- header -->
	<header id="header">
		<nav class="navbar st-navbar navbar-expand-lg navbar-dark">
			<div class="container container-modify" >
				<div class="navbar-header col-sm-4" >
				<a href="<%=request.getContextPath()%>/index">
					<img class="logo" style=" width:250px; height: 80px; margin-top: 10px" src="<%=request.getContextPath() %>/templates/public/images/logo2.png">
				</a>
				</div>
				<div class="nav col-sm-8">
					
					<div class="header-login dropdown animated fadeInDown animation-delay-11">	
						<%
						Users objUsers = (Users)session.getAttribute("objUser");
						if(objUsers!=null){
						%>
						<a href="" data-toggle="modal" data-target="#editUsers" ><i class="fa fa-user"></i> <%=objUsers.getFullName() %></a>
						<a href="<%=request.getContextPath()%>/logout"> <span style="font-weight:bold">Logout</span></a>
						<%}else{ %>
						<a href="#" ><i class="fa fa-user"></i> Khách</a>
						<a <%-- href="<%=request.getContextPath()%>/login" --%> href="" data-toggle="modal" data-target="#login"> <span style="font-weight:bold">Login</span></a>
						<%} %>
					</div>
			 		 <ul class="nav menu ">
				 		 <li><a href="<%=request.getContextPath()%>/index">TRANG CHỦ</a></li>
			  			 <li><a href="<%=request.getContextPath()%>/indexIntroduce">DỊCH VỤ</a></li>
			  			 <li><a href="<%=request.getContextPath()%>/indexNews">TIN TỨC</a></li>
			  			 <li><a href="<%=request.getContextPath()%>/indexPolicy">CHÍNH SÁCH</a></li>
			  			 <li><a href="<%=request.getContextPath()%>/indexOrder">ĐẶT HÀNG</a></li>
			  			 <li><a href="" data-toggle="modal" data-target="#signup">THÀNH VIÊN</a></li>
			  			 <li><a href="<%=request.getContextPath()%>/indexContact">LIÊN HỆ</a></li>
			  			 <li><a href="<%=request.getContextPath()%>/indexFAQ">FAQ</a></li>
			  		
			  		  </ul>
			  		  
				  
				</div>
				
			</div>
		</nav>
	</header>
	<!-- slider -->
	<section id="slider">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
  			<!-- Indicators -->
 			<ol class="carousel-indicators">
    			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
   			 	<li data-target="#myCarousel" data-slide-to="1"></li>
    			<li data-target="#myCarousel" data-slide-to="2"></li>
    			<li data-target="#myCarousel" data-slide-to="3"></li>
 			</ol>
 			<div class="carousel-inner" role="listbox">
    			<div class="item active">
     				<img style="width:100%; height:430px;" src="<%=request.getContextPath() %>/templates/public/images/a4.png" alt="">
    			</div>

    			<div class="item">
      				<img style="width:100%; height:430px;" src="<%=request.getContextPath() %>/templates/public/images/a3.png" alt="">
    			</div>

    			<div class="item">
     				<img style="width:100%;height:430px;" src="<%=request.getContextPath() %>/templates/public/images/a2.png" alt="">
    			</div>
    			<div class="item">
     				<img style="width:100%;height:430px;" src="<%=request.getContextPath() %>/templates/public/images/a1.jpg" alt="">
    			</div>
  			</div>

  			<!-- Left and right controls -->
 			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    			<span class="sr-only">Previous</span>
 			</a>
  			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
   				 <span class="sr-only">Next</span>
  			</a>
		</div>
	</section>
	<!-- End Left and right controls --> 
	<!-- end slider -->
	<!-- end-header -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="loginLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginlLabel" style = "margin-left: 186px; color: #3C763D;"><strong>ASHE SHOP ĐĂNG NHẬP</strong></h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal form-login" id="send_content" role="form" method="post" action="<%=request.getContextPath() %>/login">
         	<div class="form-group">
    			<label for="inputEmail3" class="col-sm-3 control-label">Username:</label>
   				<div class="col-sm-9">
      				<input type="text" name="userName" class="form-control required" id="username" placeholder="" style="width:300px;">
    			</div>
 			</div>
 			<div class="form-group">
    			<label for="inputEmail3" class="col-sm-3 control-label">Password:</label>
   				<div class="col-sm-9">
      				<input type="password" name="passWord" class="form-control required" id="password" placeholder="" style="width:300px;">
    			</div>
 			</div>
 			<div class="modal-footer">
        		<button href="javascript:;" type="button" class="btn btn-danger" onclick="javascript:$('#send_content input').val('');" >Xóa</button>
       			<button class="button-add btn btn-success create-button" name="submit" type="submit" value="Đăng nhập">Đăng nhập</button> 
     		 </div>
        </form>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="signup" tabindex="-1" role="dialog" aria-labelledby="loginLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginlLabel" style = "margin-left: 120px; color: #3C763D;"><strong>ĐĂNG KÝ THÀNH VIÊN CỦA ASHE SHOP</strong></h4>
      </div>
      <div class="modal-body">
       	<form class="form-horizontal form_register" id="send_content1" role="form" method="post" action="<%=request.getContextPath() %>/register">
         			<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Username:</label>
   						<div class="col-sm-9">
      						<input  style = "width:300px;"type="text" name="userName" class="form-control required" id="username" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Password:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="password" name="passWord" class="form-control" id="password" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Họ tên:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="text" name="fullName" class="form-control" id="fullname" placeholder="">
    					</div>
 					 </div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Ngày sinh:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="text" name="birthDay" class="form-control myDateFormat" id="birthday" placeholder="dd/MM/yyyy">
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Địa chỉ:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="text" name="address" class="form-control" id="address" placeholder="">
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Điện thoại:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;"  type="text" name="phoneNumber" class="form-control" id="phone" placeholder="">
    					</div>
 					</div>
 					<div class="modal-footer">
        				<button href="javascript:;" type="button" class="btn btn-danger" onclick="javascript:$('#send_content1 input').val('');">Xóa</button>
       					<button class="button-add btn btn-success create-button" name="submit" type="submit" value="Đăng ký" >Đăng ký</button> 
     				 </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%
  String msg = "";
	String msg1 = "";
    if(request.getParameter("msg")!=null){
    	msg = request.getParameter("msg");
    }else if(request.getParameter("login")!=null){
    	msg = request.getParameter("login");
    }else if(request.getParameter("buy")!=null){
    	msg = request.getParameter("buy");
    }else if(request.getParameter("training")!=null){
    	msg = request.getParameter("training");
    }else if(request.getParameter("id")!=null){
    	msg1 = request.getParameter("id");
    }else if(request.getParameter("contact")!=null){
    	msg = request.getParameter("contact");
    }
 	if(msg.equals("register")){
%>
	<script type="text/javascript">
	swal({   title: "Chúc mừng bạn đã đăng ký là hội viên thành công!",   text: "Xin hãy <a href = '' data-toggle ='modal' data-target='#login' style='color:#F8BB86'>đăng nhập</a> lại để xem thông tin đăng ký.",   html: true });
	</script>
	<%}else if(msg.equals("login0")){ %>
	<script type="text/javascript">
	swal("Lỗi rồi!", "Tên đăng nhập hoặc mật khẩu không đúng.")
	</script>
	<%}else if(msg.equals("login1")){ %>
	<script type="text/javascript">
	swal("Tìm Kiếm", "Không tìm thấy mã đặt hàng của bạn!!! Vui Lòng Kiểm Tra Lại Mã Đặt Hàng!")
	</script>
	<%}else if(msg.equals("contact0")){ %>
	<script type="text/javascript">
	swal("Lỗi rồi!", "Gửi Thông Tin Không Thành Công!!!")
	</script>
	<%}else if(msg.equals("contact1")){ %>
	<script type="text/javascript">
	swal("Thành Công!", "Bạn Đã Gửi Thành Công Thông Tin. Chúng Tôi Sẽ Phản Hồi Sớm Nhất Có Thế!!!")
	</script>
	<%}else if(!msg1.equals("")){ %>
	<script type="text/javascript">
	swal("Chúc mừng", "Chúc mừng bạn đã đặt hàng thành công!!! Mã vận đơn của bạn là: <%=request.getParameter("id")%>. Vui Lòng Đợi Admin xét duyệt đơn hàng!!!")
	<%}else if (msg.equals("fail")){%>
	<script type="text/javascript">
	swal("Lỗi rồi!", "Tên đăng nhập đã được đăng ký. Vui lòng nhập tên khác!!!")
	</script>
	<%} %>
	
<script>
$('#login').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('.modal-body input').val(recipient)
	})
</script>
<script>
$('#signup').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('.modal-body input').val(recipient)
	})
</script>
<script>
$('#editUsers').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('.modal-body input').val(recipient)
	})
</script>
<script type="text/javascript">
				$.validator.addMethod(
					    "myDateFormat",
					    function(value, element) {
					        // yyyy-mm-dd
					        var re = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;

					        // valid if optional and empty OR if it passes the regex test
					        return (this.optional(element) && value=="") || re.test(value);
					    }
					);
$( document ).ready(function() {
	$(".form_register").validate({
		rules: {
			userName: {
				required: true,
			},
			passWord: {
				required: true,
			},
			fullName: {
				required: true,
			},
			birthDay: {
				required: true,
				date: true,
			},
			address: {
				required: true,
			},
			phoneNumber:{
				required: true,
				number: true,
			}
		},
		messages: {
			userName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập username!</span>",
			},
			passWord: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập password!</span>",
			},
			fullName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập họ tên!</span>",	
			},
			birthDay: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập ngày tháng năm sinh!</span>",
				myDateFormat: "<span style='color:red;font-weight:bold;font-size:13px;'>Sai định dạng ngày tháng năm(dd/MM/YYYY)</span>",
			},
			address: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập địa chỉ!</span>",
			},
			phoneNumber: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập số điện thoại!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!</span>",
			}
		}
	});
});
</script>
<script type="text/javascript">
$( document ).ready(function() {
	$(".form-login").validate({
		rules: {
			userName: {
				required: true,
			},
			passWord: {
				required: true,
			}
			
		},
		messages: {
			userName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập username</span>",
			},
			passWord: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập password</span>",
			},
			
		}
	});
});
</script>