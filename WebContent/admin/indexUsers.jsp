<%@page import="library.TimeConvert"%>
<%@page import="bean.Users"%>
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
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchUsers" method="post">
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
							<th>Id</th>
							<th>Username</th>
							<th>Họ tên</th>
							<th>Ngày sinh</th>
							<th>Địa chỉ</th>
							<th>Số điện thoại</th>
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
							
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Users> alUsers = (ArrayList<Users>)request.getAttribute("alUsers");
					for(Users objUsers1:alUsers){
					%>
						<tr>
							<td><%=objUsers1.getIdUser() %></td>
							<td><%=objUsers1.getUserName() %></td>
							<td><%=objUsers1.getFullName() %></td>
							<td><%=TimeConvert.getStringDatetime(objUsers1.getBirthDay()) %></td>
							<td><%=objUsers1.getAddDress() %></td>
							<td><%=objUsers1.getPhoneNumber() %></td>
							<td><a href="<%=request.getContextPath()%>/admin/editUsers?uid=<%=objUsers1.getIdUser()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('Bạn chắc chắn xóa chứ?')" href="<%=request.getContextPath()%>/admin/deleteUsers?uid=<%=objUsers1.getIdUser()%>"><i class="fa fa-times"></i></a></td>
						</tr>
					<%} %>

					</tbody>
				</table>
				</div>
				<div class="pagi">
					<div class="col-md-1" style="left:-350px;">
						<p>
							<a href="<%=request.getContextPath()%>/admin/addUsers" class="btn btn-success create-button"><i class="fa fa-plus" style="font-size:12px"></i> Thêm mới</a>
		        		</p>
		    		</div>
					<ul class="pagination">
					<%
					String active="";
					int curentPage = (Integer)request.getAttribute("page");
					int soTrang = (Integer)request.getAttribute("soTrang");
					for(int i=1;i<=soTrang;i++){
						if(curentPage==i){
							active = "class=\"disabled\"";
						}else{
							active ="";
						}
					%>
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/indexUsers?page=<%=i%>"><%=i %></a></li>
  					<%} %>
					</ul>
				</div>	
			</div>
			<!-- end main -->
			
		</div>
		
	</div>
	<!-- end body -->
</body>
</html>
