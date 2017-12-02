<%@page import="bean.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp"%>
<div class="container" style="margin-top: 80px;">
	<div class="row">
		<!-- main -->
		<div class="col-md-12 main">
			<!-- end search form -->
			<%
				Product objPro = (Product) request.getAttribute("objPro");
			%>
			<div class="row main-section">
				<div class="col-md-12 col-md-12" style="margin-top: 10px;">
					<label for="" class="col-md-2" style="margin-bottom: 10px;">Tên
						SP:</label> <a target="_blank" href="<%=objPro.getUrl()%>"
						class="col-md-10" id=""><h4 style="color: #3C763D; margin-bottom: 10px;"><%=objPro.getName()%></h4></a>
				</div>
				<div class="col-md-12 col-md-12">
					<div class="col-md-4">
						<img style="width: 380px" src="<%=objPro.getImage()%>">
					</div>
					<div class="col-md-6">
						<label for="" class="col-md-4">Giá SP:</label>
						<div class="col-md-8">
							<div style="color: #3C763D; margin-bottom: 5px;"><%=objPro.getPrice()%></div>
						</div>
						<label for="" class="col-md-4">Khối Lượng:</label>
						<div target="_blank" href="" class="col-md-8">
							<div style="color: #3C763D; margin-bottom: 5px;"><%=objPro.getWeight()%>
								kg
							</div>
						</div>
						<label for="" class="col-md-4">Phí Vận Chuyển:</label>
						<div target="_blank" href="" class="col-md-8">
							<div style="color: #3C763D; margin-bottom: 5px;"><%=objPro.getCost()%>
								VNĐ
							</div>
						</div>
						<label for="" class="col-md-4">Phí Nội Địa:</label>
						<div target="_blank" href="" class="col-md-8">
							<div style="color: #3C763D; margin-bottom: 5px;"><%=objPro.getCostLocal()%>
								VNĐ
							</div>
						</div>
						<label for="" class="col-md-4">Tổng:</label>
						<div target="_blank" href="" class="col-md-8">
							<div style="color: #3C763D; margin-bottom: 5px;"><%=request.getAttribute("sum")%>
								VNĐ
							</div>
						</div>
						<label for="" class="col-md-4">Đã Thanh Toán:</label>
						<div target="_blank" href="" class="col-md-8">
							<div style="color: #3C763D; margin-bottom: 5px;"><%=objPro.getPaid()%>
								VNĐ
							</div>
						</div>
						<label for="" class="col-md-4">Còn Lại:</label>
						<div target="_blank" href="" class="col-md-8">
							<div style="color: #3C763D; margin-bottom: 5px;"><%=request.getAttribute("sum1")%>
								VNĐ
							</div>
						</div>
					</div>
					</div>
				</div>
				<div class="col-md-1" style="left:420px;">
						<p>
							<a href="<%=request.getContextPath()%>/admin/editProduct?pid=<%=objPro.getIdproduct()%>" class="btn btn-success create-button"><i class="fa fa-plus" style="font-size:12px"></i> Sửa Chi Phí</a>
		        		</p>
		    		</div>
			</div>
		</div>
	</div>
</div>
<!-- end main -->
</div>

</body>
</html>