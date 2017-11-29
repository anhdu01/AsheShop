<%@page import="bean.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	
<%
Order objPro = (Order)request.getAttribute("objPro");
%>
	<div class="container" style="margin-top: 80px;">
		<div class="row body-form">
			<div class="col-md-12">
				<form class="form-horizontal form_editProduct" enctype="multipart/form-data" role="form" method="post" action="<%=request.getContextPath() %>/admin/editOrder?pid=<%=objPro.getIdorder()%>">
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Name</label>
   						<div class="col-sm-10">
      						<input type="text" value= "<%=objPro.getFullName() %>" name="name" style="width:587px;" class="form-control required" id="username" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">CMT</label>
   						<div class="col-sm-10">
      						<input type="text" value= "<%=objPro.getCmt() %>" name="cmt" style="width:587px;" class="form-control required" id="username" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
   						<div class="col-sm-10">
      						<input type="text" value= "<%=objPro.getEmail() %>" name="email" style="width:587px;" class="form-control required" id="username" placeholder="">
    					</div>
 					 </div>
 					 <div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Address</label>
   						<div class="col-sm-10">
      						<input type="text" value= "<%=objPro.getAddress() %>" name="address" style="width:587px;" class="form-control required" id="username" placeholder="">
    					</div>
 					 </div>
 					 <div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Phone</label>
   						<div class="col-sm-10">
      						<input type="text" value= "<%=objPro.getPhoneNumber() %>" name="phone" style="width:587px;" class="form-control required" id="username" placeholder="">
    					</div>
 					 </div>
 					 <div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Price</label>
   						<div class="col-sm-10">
      						<input type="text" value= "<%=objPro.getPrice() %>" name="price" style="width:587px;" class="form-control required" id="username" placeholder="">
    					</div>
 					 </div>
 					 <div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Link</label>
   						<div class="col-sm-10">
      						<textarea name="link"  rows="4" cols="90" class="input-medium"><%=objPro.getLink() %></textarea>
    					</div>
 					 </div>
 					 <div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Notes</label>
   						<div class="col-sm-10">
      						<textarea name="notes"  rows="7" cols="90" class="input-medium"><%=objPro.getNotes() %></textarea>
    					</div>
 					 </div>
 					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
     						<p>
								<input class="button-add btn btn-success create-button" name="submit" type="submit" value="Sửa" /> 
		        			</p>
    					</div>
  					</div>
  					
				</form>
				<script type="text/javascript">
				CKEDITOR.replace( 'detail' );
$( document ).ready(function() {
	$(".form_editProduct").validate({
		rules: {
			name: {
				required: true,
			},
			cmt: {
				required: true,
			},
			email: {
				required: true,
			},
			address: {
				required: true,
			},
			phone: {
				required: true,
			},
			price: {
				required: true,
				number: true
			},
			link: {
				required: true,
			}

		},
		messages: {
			name: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập họ và tên !</span>"
			},
			cmt: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập chứng minh thư!</span>"
			},
			email: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập email!</span>"	
			},
			address: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập địa chỉ!</span>"	
			},
			phone: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập số điện thoại!</span>"	
			},
			price: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập giá!</span>",	
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!</span>"	
			},
			link: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập link!</span>"	
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