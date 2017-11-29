<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	
	<%
	String output = "";
	if(request.getParameter("msg") != null){
						String msg = request.getParameter("msg");
						if("add0".equals(msg)){
							output ="Trùng Username!";
						}
	}					
	%>
	<div class="container" style="margin-top: 80px;">
		<div class="row body-form">
			<div class="col-md-12">
				<form class="form-horizontal form_addUsers" role="form" method="post" action="<%=request.getContextPath() %>/admin/addUsers">
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
   						<div class="col-sm-10">
      						<input type="text" name="userName" class="form-control required" id="username" placeholder="">
      						<% if(!output.equals("")){%>
      						<p style="color:red;" >
								<i class="fa fa-user"></i>
								<%=output %>
								</p>
      						<%} %>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Password</label>
   						<div class="col-sm-10">
      						<input type="password" name="passWord" class="form-control" id="password" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Họ tên</label>
   						<div class="col-sm-10">
      						<input type="text" name="fullName" class="form-control" id="fullname" placeholder="">
    					</div>
 					 </div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Ngày sinh</label>
   						<div class="col-sm-10">
      						<input type="text" name="birthDay" class="form-control myDateFormat" id="birthday" placeholder="dd/MM/yyyy">
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Địa chỉ</label>
   						<div class="col-sm-10">
      						<input type="text" name="address" class="form-control" id="address" placeholder="">
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Số điện thoại</label>
   						<div class="col-sm-10">
      						<input type="text" name="phoneNumber" class="form-control" id="phone" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
     						<p>
								<input class="button-add btn btn-success create-button" name="submit" type="submit" value="Thêm" /> 
		        			</p>
    					</div>
  					</div>
  					
				</form>
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
	$(".form_addUsers").validate({
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
				number: true
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
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập họ tên!</span>"	
			},
			birthDay: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập ngày tháng năm sinh!</span>",
				myDateFormat: "<span style='color:red;font-weight:bold;font-size:13px;'>Sai định dạng ngày tháng năm(dd/MM/YYYY)</span>"
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
			</div>
		</div>
	</div>
	
</body>
</html>