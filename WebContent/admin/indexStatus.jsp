<%@page import="bean.Status"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="library.TimeConvert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="container" style="margin-top: 80px;">
		<div class="row">
			<!-- main -->
			<div class="title-section" style="margin-top: 10px;">
					<div class="col-md-12">
						<nav class="navbar navbar-inverse">
						<p>
							<span class="animated flash animation-delay-11" style="color: white; font-size: 20px; margin-left: 20px;">TÌNH TRẠNG ĐƠN HÀNG</span>
						</p>
						</nav>

					</div>
				</div>
			<div class="col-md-12 main">
				<!-- end search form -->
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Mã vận đơn</th>
							<th>Ngày</th> 
							<th>View Tracking</th>
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
						</tr>
					</thead>
					<%
						ArrayList<Status> alStatus = (ArrayList<Status>)request.getAttribute("alStatus");
						for(Status objStatus:alStatus){
							TimeConvert cv = new TimeConvert();
							Date date1 = cv.getNormalDate(objStatus.getDate());
							String date2 = cv.getStringDatetime(date1);
					%>
					<tbody>
						<tr>
							<td><%=objStatus.getIdorder()%></td>
							<td><%=date2%></td>
							<td><%=objStatus.getStatus()%></td>
							<td><a href="<%=request.getContextPath()%>/admin/editStatus?sid=<%=objStatus.getIdstatus()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('Bạn chắc chắn xóa chứ?')" href="<%=request.getContextPath()%>/admin/delStatus?sid=<%=objStatus.getIdstatus()%>"><i class="fa fa-times"></i></a></td>
						</tr>
					</tbody>
					<%} %>
				</table>
				</div>
			</div>
			<div class="col-md-12 main">
				<div class="col-md-4">
					<p>
						<a href="<%=request.getContextPath()%>/admin/addStatus?id=<%=request.getParameter("pid")%>"
							class="btn btn-success create-button"><i class="fa fa-plus" style="font-size:12px"></i> Thêm mới</a>
					</p>
				</div>
			</div>
			</div>
			<!-- end main -->	
		</div>
	
</body>
</html>