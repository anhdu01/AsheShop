<%@page import="bean.Product"%>
<%@page import="java.util.Date"%>
<%@page import="bean.Status"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/templates/public/inc/header.jsp" %>
	<!-- body -->
	<div class="main-content">
			<div class="container">
				<div class="row main-section">
				<%@include file="/templates/public/inc/rightbar.jsp" %>
					<div class="col-sm-9">
					<!-- section1 -->
						<div class="section">
						 	<div class="title-section">
						 		<div class="col-sm-12">	
						 			<nav class="navbar navbar-inverse">
  										<p><span class="animated flash animation-delay-11">HÀNH TRÌNH ĐƠN HÀNG CÓ MÃ VẬN ĐƠN: <%=request.getAttribute("num")%></span></p>
									</nav>
							
								</div>
							</div>
							
							<div class="row main-section" style="margin-right: 5px;">
									<div class="col-md-1" style="margin-left: -65px;">
										<img class="logo" style="" src="<%=request.getContextPath() %>/templates/public/images/icon1.jpg">
									</div>
									<div class="col-md-10" style="margin-top: 50px; margin-left: 20px;">
										<img class="" style="" src="<%=request.getContextPath() %>/templates/public/images/link.jpg">
									</div>
									<div class="col-md-1">
										<img class="logo" style="margin-bottom: 9px; margin-left: 23px;" src="<%=request.getContextPath() %>/templates/public/images/icon2.jpg">
									</div>
								<%
								int dem=0;
								ArrayList<Status> alStatus = (ArrayList<Status>)request.getAttribute("alCode");
								for (Status objStatus : alStatus) {
									TimeConvert cv = new TimeConvert();
									Date date1 = cv.getNormalDate(objStatus.getDate());
									String date2 = cv.getStringDatetime(date1);
									dem++;
									if (dem <=6) {
								%>
								<div class="col-md-2">
									<div style="text-align: center; margin-top: -15px; margin-left: -35px; margin-bottom: 10px;">
									<div>|</div>
									<div><strong><%=objStatus.getStatus()%></strong></div>
									<div><%=date2%></div>
									</div>
								</div>
								<%}
								}%>
							</div>
							<%
								Product objPro = (Product)request.getAttribute("objPro");
							%>
							<div class="title-section" style="margin-top: 10px;">
						 		<div class="col-sm-12">	
						 			<nav class="navbar navbar-inverse">
  										<p><span class="animated flash animation-delay-11">THÔNG TIN KIỆN HÀNG:</span></p>
									</nav>
							
								</div>
							</div>
							<div class="row main-section" style="margin-right: 5px;">
								<div class="col-md-12 col-md-12" style="margin-top: 10px;">
									<label for="" class="col-md-2" style="margin-bottom: 10px;">Tên SP:</label>
									<a target="_blank" href="<%=objPro.getUrl()%>" class="col-md-10" id=""><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=objPro.getName()%></h4></a>
								</div>
								<div class="col-md-12 col-md-12">
									<div class="col-md-4 col-md-4">
										<img class="img-rounded"
											style="margin-bottom: 10px;" src="<%=objPro.getImage()%>"
											width="200px" height="200px">
									</div>
									<div class="col-md-6 col-md-6">
										<label for="" class="col-md-4">Giá SP:</label>
										<div target="_blank" href="" class="col-md-8"><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=objPro.getPrice()%></h4></div>
										<label for="" class="col-md-4">K.Lượng:</label>
										<div target="_blank" href="" class="col-md-8"><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=objPro.getWeight()%> kg</h4></div>
										<label for="" class="col-md-4">Phí VC:</label>
										<div target="_blank" href="" class="col-md-8"><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=objPro.getCost()%> VNĐ</h4></div>
										<label for="" class="col-md-4">Phí NĐ:</label>
										<div target="_blank" href="" class="col-md-8"><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=objPro.getCostLocal()%> VNĐ</h4></div>
										<label for="" class="col-md-4">Tổng:</label>
										<div target="_blank" href="" class="col-md-8"><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=request.getAttribute("sum")%> VNĐ</h4></div>
										<label for="" class="col-md-4">Đã TT:</label>
										<div target="_blank" href="" class="col-md-8"><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=objPro.getPaid()%> VNĐ</h4></div>
										<label for="" class="col-md-4">Còn Lại:</label>
										<div target="_blank" href="" class="col-md-8"><h4
												style="color: #3C763D; margin-bottom: 10px;"><%=request.getAttribute("sum1")%> VNĐ</h4></div>
									</div>
								</div>
								<div class="col-md-12 col-md-12" style="margin-bottom: 10px;">
								<strong>Trong Đó:</strong>
								<br>
								- Tên SP: Tên Sản Phẩm
								<br>
								- Giá SP: Giá Sản Phẩm
								<br>
								- K.Lượng: Khối Lượng Kiện Hàng
								<br>
								- Phí VC: Phí Vận Chuyển
								<br>
								- Phí NĐ: Phí Vận Chuyển Nội Địa
								<br>
								- Đã TT: Số Tiền Đã Thanh Toán
							</div>
							</div>
						</div>
						<!-- end section 1 -->
						
					</div>
					</div>
					</div>
					</div>
					
		<%@include file="/templates/public/inc/footer.jsp" %>