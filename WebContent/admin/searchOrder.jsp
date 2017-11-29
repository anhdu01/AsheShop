<%@page import="bean.Order"%>
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
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchOrder" method="post">
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
							<th>Họ và Tên</th>
							<th>CMT</th>
							<th>Email</th>
							<th>Địa Chỉ</th>
							<th>Số ĐT</th>
							<th>Link</th>
 							<th>Giá(VND)</th>
							<th>Ghi Chú</th>
							<th>Type</th> 
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Order> alOr = (ArrayList<Order>)request.getAttribute("alOr");
					for(Order objOr:alOr){
						String imgActive = "";
						String isActive = "";
						int type;
						if(objOr.isType()==true){
							isActive = "Kích hoạt";
							imgActive = request.getContextPath() + "/templates/admin/images/icon-success.png";
							type = 1;
						}else{
							isActive = "Ngừng kích hoạt";
							imgActive = request.getContextPath() + "/templates/admin/images/icon-fail.png";
							type = 0;
						}
					%>
						<tr>
							<td><%=objOr.getIdorder() %></td>
							<td><%=objOr.getFullName() %></td>
							<td><%=objOr.getCmt() %></td>
							<td><%=objOr.getEmail() %></td>
							<td><%=objOr.getAddress() %></td>
							<td><%=objOr.getPhoneNumber() %></td>
							<td><a href="<%=objOr.getLink() %>"><i class="fa fa-spinner fa-spin" style="font-size:15px"></i></td>
							<td><%=objOr.getPrice() %></td>
							<td><%=objOr.getNotes() %></td>
							<td class="align-center" id="setactive-<%=objOr.getIdorder() %>">
							<a href="javascript:void(0)" onclick="return setActive(<%=objOr.getIdorder() %>, <%=type %>)" title="<%=isActive %>"><img style="width:30px; height:30px;" src="<%=imgActive %>" alt=""></a>
							</td>
							<td><a href="<%=request.getContextPath()%>/admin/editOrder?pid=<%=objOr.getIdorder()%>&type=load"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteOrder?pid=<%=objOr.getIdorder()%>"><i class="fa fa-times"></i></a></td>
						</tr>
					<%} %>

					</tbody>
				</table>
				</div>
			</div>
			<!-- end main -->
			<div class="col-md-4" style ="margin-left: 15px;">
					<p>
						<a href="<%=request.getContextPath()%>/admin/indexOrder"
							class="btn btn-success create-button"><i class="fa fa-mail-reply" style="font-size:12px"></i> Quay Lại</a>
					</p>
				</div>
		<script type="text/javascript">
	function setActive(id, active){
		$.ajax({
			url: '<%=request.getContextPath() %>/admin/ajaxOrder',
			type: 'POST',
			cache: false,
			data: {
				aid: id,
				aactive: active,
				},
			success: function(data){
				$('#setactive-' + id).html(data);
			},
			error: function (){
				alert('Có lỗi xảy ra');
			}
		});
		return false;
	}
	</script>
		</div>
		
	</div>
	<!-- end body -->
</body>
</html>
