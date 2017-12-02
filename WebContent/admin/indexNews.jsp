<%@page import="bean.News"%>
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
		    		<div class="col-md-5">
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchNews" method="post">
  							<div class="form-group">
    							<input name="input" type="text" class="form-control" id="input" placeholder="Nhập một từ khóa...">
  							</div>
  							<button class="button-add btn btn-primary create-button" name="submit" type="submit"><i class="fa fa-search"></i> Tìm Kiếm</button> 
						</form>
		    		</div>
				</div>
				<!-- end search form -->
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Tên tin tức</th>
							<th>Mô tả</th>
							<th>Hình ảnh</th>
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
							
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<News> alNews = (ArrayList<News>)request.getAttribute("alNews");
					for(News objNews:alNews){
					%>
						<tr>
							<td><%=objNews.getIdNews() %></td>
							<td><%=objNews.getNameNews() %></td>
							<td><%=objNews.getPreviewNews() %></td>
							<td><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objNews.getPicture()%>" width="100px" height ="80px"></td>
							
							<td><a href="<%=request.getContextPath()%>/admin/editNews?nid=<%=objNews.getIdNews()%>&type=load"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteNews?nid=<%=objNews.getIdNews()%>"><i class="fa fa-times"></i></a></td>
						</tr>
					<%} %>

					</tbody>
				</table>
				</div>
				<div class="pagi">
					<div class="col-md-1" style="left:-350px;">
						<p>
							<a href="<%=request.getContextPath()%>/admin/addNews?type=load"
							class="btn btn-success create-button"><i class="fa fa-plus" style="font-size:12px"></i> Thêm mới</a>
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
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/indexNews?page=<%=i%>"><%=i %></a></li>
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
