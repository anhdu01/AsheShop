<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp"%>
<!-- body -->

<div class="main-content">
	<div class="container">
		<div class="row main-section">
			<%@include file="/templates/public/inc/rightbar.jsp"%>
			<div class="col-sm-9">
				<!-- section1 -->
				<div class="section">
					<div class="title-section">
						<div class="col-md-12">
							<nav class="navbar navbar-inverse">
							<p>
								<span class="animated flash animation-delay-11">LIÊN HỆ</span>
							</p>
							</nav>

						</div>
					</div>
					<div class="row main-section" style="margin-right: 5px;">
						<div id="contact">
								<!--end map-->
							<div class="modal-body">
								<p style="text-align: center;">
									<span
										style="font-size: large; color: #3C763D; background-color: #ffffff;"><strong>HỆ
											THỐNG DỊCH VỤ VẬN CHUYỂN HÀNG TỪ NƯỚC NGOÀI VỀ VIỆT NAM</strong></span>
								</p>
								<div class="card-body">
									<p class="card-text">
									<li><strong>Văn Phòng Đại Diện Tại Việt Nam</strong></li>
									</p>
									<p class="card-text">
										<big>&#9755;</big> 768 Nguyễn Lương Bằng - Hòa Khánh Nam -
										Liên Chiểu - Đà Nẵng
									</p>
									<p class="card-text">
										<i class="fa fa-phone" style="font-size: 15px"></i> +84 906-400-956
									</p>
								</div>
								<div>
									<p class="card-text">
									<li><strong>Văn Phòng Đại Diện Tại Mỹ</strong></li>
									</p>
									<p class="card-text">
										<big>&#9755;</big> 2381 Rosecrans Ave, Suite 200 El Segundo,
										CA 90245. USA
									</p>
									<p class="card-text">
										<i class="fa fa-phone" style="font-size: 15px"></i> +1 914-495-8232 
									</p>
								</div>
								<div>
									<p class="card-text">
									<li><strong>Văn Phòng Đại Diện Tại Trung Quốc</strong></li>
									</p>
									<p class="card-text">
										<big>&#9755;</big> 17 đường Zhanxi, quận Yuexiu, Quảng Châu
									</p>
									<p class="card-text">
										<i class="fa fa-phone" style="font-size: 15px"></i> +86 189 2872478
									</p>
								</div>
							</div>
							<!--end contactBox-->
									<div class="title-section">
										<div class="col-md-12">
											<nav class="navbar navbar-inverse">
											<p>
												<span class="animated flash animation-delay-11">Để
													Lại Thông Tin Cho Chúng Tôi</span>
											</p>
											</nav>

										</div>
									</div>
									<div class="modal-body">
										<form class="form-horizontal"
											action="<%=request.getContextPath()%>/indexContact"
											method="post" id="send_content" role="form">
											<div class="col-md-12">
												<div class="form-group">
													<label for="" class="col-sm-3 control-label">Họ
														và Tên:</label>
													<div class="col-sm-9">
														<input style="width: 300px;" type="text" name="name"
															class="form-control" id="name" placeholder="">
													</div>
												</div>
												<div class="form-group">
													<label for="" class="col-sm-3 control-label">Email
														<big style="color: red;">*</big>:
													</label>
													<div class="col-sm-9">
														<input style="width: 300px;" type="text" name="email"
															class="form-control required" id="email" placeholder="">
													</div>
												</div>
												<div class="form-group">
													<label for="" class="col-sm-3 control-label">Địa
														Chỉ:</label>
													<div class="col-sm-9">
														<input style="width: 300px;" type="text" name="address"
															class="form-control" id="address" placeholder="">
													</div>
												</div>
												<div class="form-group">
													<label for="" class="col-sm-3 control-label">Số
														Điện Thoại <big style="color: red;">*</big>:</label>
													<div class="col-sm-9">
														<input style="width: 300px;" type="text" name="phone"
															class="form-control" id="phone" placeholder="">
													</div>
												</div>
												<div class="form-group">
													<label for="" class="col-sm-3 control-label">Nghề
														Nghiệp:</label>
													<div class="col-sm-9">
														<input style="width: 300px;" type="text" name="job"
															class="form-control" id="job" placeholder="">
													</div>
												</div>
												<div class="form-group">
													<label for="" class="col-sm-3 control-label">Câu
														Hỏi:</label>
													<div class="col-sm-9">
														<textarea style="width: 300px;" type="text" name="notes"
															class="form-control" id="notes" placeholder=""></textarea>
													</div>
												</div>
											</div>
											<div class="col-md-12" style="text-align: center;">
												<button href="javascript:;"
													onclick="javascript:$('#send_content input').val('');$('#send_content textarea').val('');"
													class="btn btn-danger">LÀM LẠI</button>
												<button type="submit" name="submit" value="GỬI"
													class="btn button-add btn-success create-button">GỬI</button>
											</div>
										</form>
									</div>
									<div class="clr" style="clear: both; margin-bottom: 20px"></div>
									<div class="title-section">
										<div class="col-md-12">
											<nav class="navbar navbar-inverse">
											<p>
												<span class="animated flash animation-delay-11">Tìm
													Đến Chỗ Chúng Tôi</span>
											</p>
											</nav>

										</div>
									</div>
									<div style="height: 750px;">
										<div>
											<li style="margin-left: 15px"><strong>Văn Phòng
													Chính Tại Việt Nam:</strong></li>
											<iframe
												src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3833.96926005809!2d108.1506772148585!3d16.067084888882313!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31421928f675bf27%3A0x72cf7f7f56db57e7!2sASHE+SHOP!5e0!3m2!1svi!2s!4v1510136660632"
												width="700" height="300" frameborder="0"
												style="border: 0; margin-left: 15px; padding-bottom: 15px;"
												allowfullscreen></iframe>
										</div>
										<div class="col-md-12">
											<div class="col-md-6">
												<li><strong>VP Đại Diện Tại Mỹ:</strong></li>
												<iframe
													src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3311.506901264508!2d-118.38218698516947!3d33.90235118064695!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80c2b41ac3b5ff3d%3A0x3375b09e6c796922!2s2381+Rosecrans+Ave+%23200%2C+El+Segundo%2C+CA+90245!5e0!3m2!1svi!2sus!4v1510139159186"
													width="320" height="300" frameborder="0" style="border: 0"
													allowfullscreen></iframe>
											</div>
											<div class="col-md-6">
												<li><strong>VP Đại Diện Tại Trung Quốc:</strong></li>
												<iframe
													src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3668.598061834982!2d113.2459506645485!3d23.14836253488955!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3402f9021dfda377%3A0x2b565a1915d48ccf!2sQuanfeng+Leather!5e0!3m2!1svi!2sus!4v1510139385951"
													width="320" height="300" frameborder="0" style="border: 0"
													allowfullscreen></iframe>
											</div>
										</div>
									</div>
									<div class="clr" style="clear: both"></div>
						</div>
					</div>
					<!-- end section 1 -->
					<script type="text/javascript">
						$(document)
								.ready(
										function() {
											$("#send_content")
													.validate(
															{
																rules : {
																	email : {
																		required : true,
																	},
																	phone : {
																		required : true,
																		number: true,
																	},
																},
																messages : {
																	email : {
																		required : "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập Email!</span>",
																	},
																	phone : {
																		required : "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập số điện thoại!</span>",
																		number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!</span>",
																	},
																}
															});
										});
					</script>

				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="/templates/public/inc/footer.jsp"%>