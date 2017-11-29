<%@page import="bean.rate"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="container" style="margin-top: 80px;">
		<div class="row">
			<!-- main -->
			<div class="col-md-12 main">
				<!-- end search form -->
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Mã Tỷ Giá</th>
							<th>Tên Đồng Ngoại Tệ</th> 
							<th>Tỷ Giá</th>
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
						</tr>
					</thead>
					<%
						ArrayList<rate> alRate = (ArrayList<rate>)request.getAttribute("alRate");
						for(rate objRate:alRate){
					%>
					<tbody>
						<tr>
							<td><%=objRate.getIdrate()%></td>
							<td><%=objRate.getMoney()%></td>
							<td><%=objRate.getRate()%></td>
							<td><a href="<%=request.getContextPath()%>/admin/editRate?rid=<%=objRate.getIdrate()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('Bạn chắc chắn xóa chứ?')" href="<%=request.getContextPath()%>/admin/delRate?rid=<%=objRate.getIdrate()%>"><i class="fa fa-times"></i></a></td>
						</tr>
					</tbody>
					<%} %>
				</table>
				</div>
			</div>
				<div class="col-md-4">
					<p>
						<a href="<%=request.getContextPath()%>/admin/addRate"
							class="btn btn-success create-button"><i class="fa fa-plus" style="font-size:12px"></i> Thêm mới</a>
					</p>
				</div>
			</div>
			<div class="pagi">
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
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/indexRate?page=<%=i%>"><%=i %></a></li>
  					<%} %>
					</ul>
				</div>
			</div>
			<!-- end main -->	
		</div>
	
</body>
</html>