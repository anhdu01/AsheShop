<%@page import="bean.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp"%>
<!-- body -->

<div class="main-content">
	<div class="container">
		<div class="row main-section">
			<%@include file="/templates/public/inc/rightbar.jsp"%>
			<%
			String style = "";
			String style1 = "";	
			%>
			<div class="col-sm-9">
				<!-- section1 -->
				<div class="section">
					<div class="title-section">
						<div class="col-sm-12">
							<nav class="navbar navbar-inverse">
							<p>
								<span class="animated flash animation-delay-11">THÔNG TIN
									ĐẶT HÀNG</span>
							</p>
							</nav>

						</div>
					</div>
					<div class="row main-section" style="margin-right: 5px;">
						<section class="home-sl2"> 
						<nav class="">
						<div class="modal-body">
							<form class="form-horizontal"
								action="<%=request.getContextPath()%>/indexOrder" method="post"
								id="send_content" role="form">
								<div class="col-md-12">
								<form class=""
								action="<%=request.getContextPath()%>/indexOrder" method="post"
								id="send_link" role="form">
									<%
										Product objPro = (Product)request.getAttribute("objPro");
										if (objPro != null) {
									%>
								<div class="row main-section">
								<div class="col-md-12 col-md-12" style="margin-top: 10px;">
									<label for="" class="col-md-2" style="margin-bottom: 10px;">Tên SP:</label>
									<a target="_blank" href="<%=objPro.getUrl()%>" class="col-md-10" id=""><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=objPro.getName()%></h4></a>
								</div>
								<div class="col-md-12 col-md-12">
									<div class="col-md-4 col-md-4">
										<img class="img-rounded"
											style="margin-bottom: 10px;" src="<%=objPro.getImage()%>"
											width="200px" height="100px">
									</div>
									<div class="col-md-6 col-md-6">
										<label for="" class="col-md-4">Giá SP:</label>
										<div target="_blank" href="" class="col-md-8"><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=objPro.getPrice()%></h4></div>
									</div>
								</div>
								</div>
								<%
							if (objPro != null) {
									style = "block";
									style1 =  "none";
								} else {
									style = "none";
									style1 =  "block";
								}
								%>
								<div class="form-group" style="display:<%=style%>; margin-top:10px;">
										<label for="" class="col-sm-2 control-label">Link SP:</label>
										<div class="col-sm-5">
											<input style="width: 300px;" type="text" name="link"
												class="form-control" id="link"
												placeholder="Nhập link sản phẩm bạn muốn đặt" value="<%=objPro.getUrl()%>">
										</div>
									<div class="col-sm-1">
									<button type="submit" name="submit1" value="GỬI"
										class="btn button-add btn-success create-button"
										style="margin-bottom: 10px;">Lấy Thông Tin Sản Phẩm</button>
									</div>
									</div>
								
					<%} %>
									<div class="form-group" style="display:<%=style1%>; margin-top: 10px;">
										<label for="" class="col-sm-2 control-label">Link SP:</label>
										<div class="col-sm-5">
											<input style="width: 300px;" type="text" name="link"
												class="form-control" id="link"
												placeholder="Nhập link sản phẩm bạn muốn đặt">
										</div>
									<div class="col-sm-1">
									<button type="submit" name="submit1" value="GỬI"
										class="btn button-add btn-success create-button"
										style="margin-bottom: 10px;" onclick="CD();">Lấy Thông Tin Sản Phẩm</button>
									</div>
									</div>
									</form>
									<div class="form-group">
										<label for="" class="col-sm-2 control-label">Giá SP:</label>
									</div>
									<div class="sl2-search">
										<input type="text" placeholder="Giá sản phẩm bằng USD"
											class="form-control form-myinput" id="price11"> <span
											class="uppercase normal-blod buy_item" onclick="getValue();">Tính
											Phí</span>
									</div>

									<div class="sl2-search">
										<input type="text" placeholder="Giá sản phẩm bằng NDT"
											class="form-control form-myinput" id="price12"> <span
											class="uppercase normal-blod buy_item" onclick="getValue2();">Tính
											Phí</span>
									</div>

									<div class="form-group">
										<label for="" class="col-sm-2 control-label">Giá VNĐ <a
											style="color: red"><big>*</big></a>:
										</label>
										<div class="col-sm-10">
											<input style="width: 300px;" type="text" name="pricevn"
												class="form-control" id="pricevn" placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label for="" class="col-sm-2 control-label">Họ và Tên
											<a style="color: red"><big>*</big></a>:
										</label>
										<div class="col-sm-10">
											<input style="width: 300px;" type="text" name="name"
												autocomplete="off" class="form-control" id="name"
												placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label for="" class="col-sm-2 control-label">Chứng
											Minh Thư <a style="color: red"><big>*</big></a>:
										</label>
										<div class="col-sm-10">
											<input style="width: 300px;" type="text" name="cmt"
												autocomplete="off" class="form-control" id="cmt"
												placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label for="" class="col-sm-2 control-label">Email <a
											style="color: red"><big>*</big></a>:
										</label>
										<div class="col-sm-10">
											<input style="width: 300px;" type="text" name="email"
												autocomplete="off" class="form-control" id="email"
												placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label for="" class="col-sm-2 control-label">Địa Chỉ <a
											style="color: red"><big>*</big></a>:
										</label>
										<div class="col-sm-10">
											<input style="width: 300px;" type="text" name="address"
												autocomplete="off" class="form-control" id="address"
												placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label for="" class="col-sm-2 control-label">Điện
											Thoại <a style="color: red"><big>*</big></a>:
										</label>
										<div class="col-sm-10">
											<input style="width: 300px;" type="text" name="phone"
												autocomplete="off" class="form-control" id="phone"
												placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label for="" class="col-sm-2 control-label">Ghi Chú:</label>
										<div class="col-sm-10">
											<textarea style="width: 300px;" type="text" name="notes"
												autocomplete="off" class="form-control" id="notes"
												placeholder=""></textarea>
										</div>
									</div>
									<div class="col-md-7" style="text-align: center;">
									<button href="javascript:;"
										onclick="javascript:$('#send_content input').val('');$('#send_content textarea').val('');"
										class="btn btn-danger" style="margin-bottom: 10px;">XÓA</button>
									<button type="submit" name="submit" value="GỬI"
										class="btn button-add btn-success create-button"
										style="margin-bottom: 10px;">GỬI</button>
									</div>
								</div>
								<div class="clr"></div>
							</form>
						</div>
						</nav> </section>
					</div>
				</div>
				<!-- end section 1 -->
				<script type="text/javascript">
					function getValue() {
						var price = parseFloat($('#price11').val());
						var value = price*<%=(Float) request.getAttribute("USD")%>;
						$('#pricevn').val(parseFloat(value).toFixed(3));
					}
					function getValue2() {
						var price = parseFloat($('#price12').val());
						var value = price*<%=(Float) request.getAttribute("NDT")%>;
						$('#pricevn').val(parseFloat(value).toFixed(3));
					}
					$(document)
							.ready(
									function() {
										$("#send_content")
												.validate(
														{
															rules : {
																pricevn : {
																	required : true,
																},
																name : {
																	required : true,
																},
																cmt : {
																	required : true,
																},
																email : {
																	required : true,
																},
																address : {
																	required : true,
																},
																phone : {
																	required : true,
																},
															},
															messages : {
																pricevn : {
																	required : "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập Giá sản phẩm!</span>",
																},
																name : {
																	required : "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập Họ và Tên!</span>",
																},
																cmt : {
																	required : "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập Chứng Minh Thư!</span>",
																},
																email : {
																	required : "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập Email!</span>",
																},
																address : {
																	required : "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập Địa Chỉ!</span>",
																},
																phone : {
																	required : "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập Số Điện Thoại!</span>",
																},
															}
														});
									});
				</script>
			</div>
		</div>
	</div>
</div>
<%@include file="/templates/public/inc/footer.jsp"%>