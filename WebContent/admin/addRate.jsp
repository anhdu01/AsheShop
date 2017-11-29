<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp"%>


<div class="container" style="margin-top: 80px;">
	<div class="row body-form">
		<div class="col-md-12">
			<form class="form-horizontal form_addRate" role="form" method="post"
				action="<%=request.getContextPath()%>/admin/addRate">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Tên Đồng Ngoại Tệ</label>
					<div class="col-sm-10">
						<input type="text" name="money" class="form-control"
							id="money" placeholder="" value=""/>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Tỷ Giá</label>
					<div class="col-sm-10">
						<input type="text" name="rate" class="form-control"
							id="rate" placeholder="Ví dụ: 3.495..." />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<p>
							<input class="button-add btn btn-success create-button"
								name="submit" type="submit" value="Thêm" />
						</p>
					</div>
				</div>

			</form>
			<script type="text/javascript">
				/* $.validator.addMethod(
					    "myDateFormat",
					    function(value, element) {
					        // yyyy-mm-dd
					        var re = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;

					        // valid if optional and empty OR if it passes the regex test
					        return (this.optional(element) && value=="") || re.test(value);
					    }
					); */
$( document ).ready(function() {
	$(".form_addRate").validate({
		rules: {
			money: {
				required: true,
			},
			rate:{
				required: true,
				number: true,
			}
		},
		messages: {
			money: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập tên đồng ngoại tệ!</span>",
			},
			rate: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập tỷ giá!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!</span>",
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