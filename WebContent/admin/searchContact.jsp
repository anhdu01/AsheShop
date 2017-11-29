<%@page import="bean.Contact"%>
<%@page import="library.TimeConvert"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	<!-- body -->
	<div class="container" style="margin-top: 80px;">
		<div class="row">
			<!-- main -->
			<div class="col-md-12 main">
				<div class="search-form">
		    		<!--search form  -->
		    		<div class="col-md-10">
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchContact" method="post">
  							<div class="form-group">
    							<input name="input" type="text" class="form-control" id="exampleInputPassword2" placeholder="Nhập một từ khóa...">
  							</div>
  							<button class="button-add btn btn-primary create-button" name="submit" type="submit">Tìm Kiếm</button> 
						</form>
		    		</div>
				</div>
				<!-- end search form -->
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Họ Tên</th>
							<th>Email</th>
							<th>Địa Chỉ</th>
							<th>Điện Thoại</th>
							<th>Nghề Nghiệp</th>
							<th>Nội Dung</th>
							<th style="width:10px;">Xóa</th>
							
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Contact> alContact = (ArrayList<Contact>)request.getAttribute("alContact");
					for(Contact objContact:alContact){
					%>
						<tr>
							<td><%=objContact.getIdContact()%></td>
							<td><%=objContact.getFullname()%></td>
							<td><%=objContact.getEmail()%></td>
							<td><%=objContact.getAddress()%></td>
							<td><%=objContact.getPhone()%></td>
							<td><%=objContact.getJob()%></td>
							<td><%=objContact.getNotes()%></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteContact?pid=<%=objContact.getIdContact()%>"><i class="fa fa-times"></i></a></td>
						</tr>
					<%} %>

					</tbody>
				</table>
				</div>
			</div>
			<!-- end main -->
			<div class="col-md-4" style ="margin-left: 15px;">
					<p>
						<a href="<%=request.getContextPath()%>/admin/indexContact"
							class="btn btn-success create-button"><i class="fa fa-mail-reply" style="font-size:12px"></i> Quay Lại</a>
					</p>
				</div>
		</div>
		
	</div>
	<!-- end body -->
</body>
</html>
