<%@page import="bean.Policy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp"%>
<!-- body -->
<div class="main-content">
	<div class="container">
		<div class="row main-section">
			<%@include file="/templates/public/inc/rightbar.jsp"%>
			<%
				Policy objPol = (Policy) request.getAttribute("objPol");
			%>
			<div class="col-md-9">
				<!-- section1 -->
				<div class="section">
					<div class="title-section">
						<div class="col-md-12">
							<nav class="navbar navbar-inverse">
							<p>
								<span class="animated flash animation-delay-11"><%=objPol.getNamePolicy()%></span>
							</p>
							</nav>

						</div>
					</div>
					<div class="row main-section" style="margin-right: 5px;">
						<div class="col-md-12">
							<div class="row detail">
								<div class="col-md-6">
									<p><%=objPol.getDetailPolicy()%></p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- end section 1 -->

			</div>
		</div>
	</div>
</div>
<%@include file="/templates/public/inc/footer.jsp"%>