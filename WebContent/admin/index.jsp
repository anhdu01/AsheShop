<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/admin/inc/header.jsp"%>
<%
	int sodon = (Integer) request.getAttribute("sodon");
	Float sotien = (Float) request.getAttribute("sotien");
	int lienhe = (Integer) request.getAttribute("lienhe");
%>
<div class="container" style="margin-top: 80px;">
	<div class="row review-index">
		<div class="col-md-12">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><div class="animated flash animation-delay-11">
							HỆ THỐNG ADMIN WEBSITE VẬN CHUYỂN HÀNG TỪ NƯỚC NGOÀI VỀ VIỆT NAM</div></strong>
				</div>
				<div class="panel-body">
					<div id="left" style="float: left;">
						<p>
							<strong><i class="fa fa-ambulance" style="font-size:25px"></i>
								Số Đơn Hàng Đã Đặt: <%=sodon%> đơn</strong></br> <strong> </br>
								<i class="fa fa-question-circle" style="font-size: 25px"></i> Số
								Lượng Liên Hệ : <%=lienhe%> liên hệ</strong>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>