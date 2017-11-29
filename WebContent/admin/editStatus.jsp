<%@page import="bean.Status"%>
<%@page import="java.util.Date"%>
<%@page import="library.TimeConvert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	
	<%
	String output = "";
	if(request.getParameter("msg") != null){
						String msg = request.getParameter("msg");
						if("edit0".equals(msg)){
							output ="Trùng Trạng Thái!";
						}
	}
	Status objStatus = (Status)request.getAttribute("objStatus");
	TimeConvert cv = new TimeConvert();
	Date date1 = cv.getNormalDate(objStatus.getDate());
	String date2 = cv.getStringDatetime(date1);
	%>
	<div class="container" style="margin-top: 80px;">
		<div class="row body-form">
			<div class="col-md-12">
				<form class="form-horizontal form_editStatus" role="form" method="post" action="<%=request.getContextPath() %>/admin/editStatus?sid=<%=objStatus.getIdstatus()%>">
					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Mã
							Vận Đơn</label>
						<div class="col-sm-10">
							<input type="text" name="idorder" class="form-control"
								id="idorder" placeholder="" value="<%=objStatus.getIdorder()%>"/>
						</div>
					</div>
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Trạng Thái</label>
   						<div class="col-sm-10">
   							<div class="form-control required" style="width: 200px; margin-bottom: 10px;"><%=objStatus.getStatus()%></div>
      						<%-- <input type="text" name="status" value = "<%=objStatus.getStatus()%>" class="form-control required" id="status" placeholder=""> --%>
      						<SELECT name="status" size="1" id="status" class="form-control" multipl>
     							<OPTION value="Đã Tiếp Nhận">Đã Tiếp Nhận</OPTION>
     							<OPTION value="Đã Mua Hàng">Đã Mua Hàng</OPTION>
     							<OPTION value="Đã Nhận Hàng">Đã Nhận Hàng</OPTION>
     							<OPTION value="Kho Mỹ">Kho Mỹ</OPTION>
     							<OPTION value="Kho Trung Quốc">Kho Trung Quốc</OPTION>
     							<OPTION value="Kho Việt Nam">Kho Việt Nam</OPTION>
     							<OPTION value="Giao Đến Khách">Giao Đến Khách</OPTION>
     							<OPTION value="Thành Công">Thành Công</OPTION>
							</SELECT>
      						<% if(!output.equals("")){%>
      						<p style="color:red;" >
								<i class="fa fa-user"></i>
								<%=output %>
								</p>
      						<%} %>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Ngày Cập Nhật</label>
   						<div class="col-sm-10">
      						<input type="text" name="date" value = "<%=date2%>" class="form-control myDateFormat " id="date" placeholder="dd/MM/yyyy">
      					
    					</div>
 					</div>
 					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
     						<p>
								<input class="button-add btn btn-success create-button" name="sua" type="submit" value="Sửa" /> 
		        			</p>
    					</div>
  					</div>
  					
				</form>
		<script type="text/javascript">
		$.validator.addMethod(
			    "myDateFormat",
			    function(value, element) {
			        // yyyy-mm-dd
			        var re = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;

			        // valid if optional and empty OR if it passes the regex test
			        return (this.optional(element) && value=="") || re.test(value);
			    }
			);

$( document ).ready(function() {
	$(".form_editStatus").validate({
		rules: {
			idorder: {
				required: true,
				number: true,
			},
			status: {
				required: true,
			},
			date:{
				required: true,
				date: true
			}
		},
		messages: {
			idorder: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập username!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!</span>",
			},
			status: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập password!</span>",
			},
			date: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập ngày tháng năm!</span>",
				myDateFormat: "<span style='color:red;font-weight:bold;font-size:13px;'>Sai định dạng ngày tháng năm(dd/MM/YYYY)</span>",
			}
		}
	});
});
</script>
			</div>
		</div>
	</div>
	
</body>
</html>