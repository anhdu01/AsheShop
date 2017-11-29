<%@page import="bean.Product"%>
<%@page import="java.util.Date"%>
<%@page import="library.TimeConvert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	<%
		Product objPro = (Product)request.getAttribute("objPro");
		int check = (Integer)request.getAttribute("check");
	%>
	<div class="container" style="margin-top: 80px;">
		<div class="row body-form">
			<div class="col-md-12">
				<form class="form-horizontal form_editUsers" role="form" method="post" action="<%=request.getContextPath() %>/admin/editProduct?pid=<%=objPro.getIdproduct()%>">
					
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Khối Lượng</label>
   						<div class="col-sm-10">
      						<input type="text" name="weight" value = "<%=objPro.getWeight() %>" class="form-control" id="weight" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Phí Vận Chuyển</label>
   						<div class="col-sm-10">
      						<input type="text" name="cost" value = "<%=objPro.getCost()%>" class="form-control" id="cost" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Phí Nội Địa</label>
   						<div class="col-sm-10">
      						<input type="text" name="costLocal"  value = "<%=objPro.getCostLocal()%>" class="form-control" id="costLocal" placeholder="">
      						
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Đã Thanh Toán</label>
   						<div class="col-sm-10">
      						<input type="text" name="paid"  value = "<%=objPro.getPaid()%>" class="form-control" id="paid" placeholder="">
      						
    					</div>
 					</div>
 					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
     						<p>
								<input class="button-add btn btn-success create-button" name="sua" type="submit" value="Sửa" /> 
		        			</p>
    					</div>
  					</div>
  					
				</form>
				<div>
					<%
						String pic = "";
						if (check == 1) {
							%>
							<img style="margin-left: 190px;" alt="" src="<%=request.getContextPath()%>/templates/admin/images/bp2.png">
							<%
						} else {
							%>
							<img alt="" src="<%=request.getContextPath()%>/templates/admin/images/bang.png">
						<%
						}
					%>
				</div>
		<script type="text/javascript">
$( document ).ready(function() {
	$(".form_editUsers").validate({
		rules: {
			weight: {
				required: true,
				number: true,
			},
			cost: {
				required: true,
				number: true,
			},
			costLocal:{
				required: true,
				number: true,
			}
		},
		messages: {
			weight: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập khối lượng!!!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!!!</span>",
			},
			cost: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập phí vận chuyển!!!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!!!</span>",
			},
			costLocal: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập phí nội địa!!!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!!!</span>",
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