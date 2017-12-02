<%@page import="java.util.ArrayList"%>
<%@page import="bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp"%>
<!-- body -->
<div class="main-content">
	<div class="container">
		<div class="row main-section">
			<%@include file="/templates/public/inc/rightbar.jsp"%>
			<div class="col-sm-9">
				<!-- section1 -->
				<div class="section">
					<div class="title-section">
						<div class="col-sm-12">
							<nav class="navbar navbar-inverse">
							<p>
								<span class="animated flash animation-delay-11">TIN TỨC</span>
							</p>
							</nav>

						</div>
					</div>
					<div class="row main-section" style="margin-right: 5px;">
						<%
							ArrayList<News> alNews = (ArrayList<News>) request.getAttribute("alNews");
							for (News objNews : alNews) {
						%>
						<div class="col-sm-12">
							<div class="row detail-section-index">
								<div class="col-md-12">
									<a href="<%=request.getContextPath()%>/detailNews?nid=<%=objNews.getIdNews()%>" class=""><h4><%=objNews.getNameNews()%></h4></a>
								</div>
								<div class="review">

									<div class="col-sm-6">
										<div class="col-sm-12">
											<img class="img-rounded"
												src="<%=request.getContextPath()%>/files/<%=objNews.getPicture()%>"
												width="300px" height="200px">
										</div>
									</div>
									<div class="col-sm-6">
										<p><%=objNews.getPreviewNews()%></p>
									</div>
								</div>
							</div>
						</div>
						<%
							}
						%>
						<div class="pagi">
							<ul class="pagination">
								<%
									String active = "";
									int curentPage = (Integer) request.getAttribute("page");
									int soTrang = (Integer) request.getAttribute("soTrang");
									for (int i = 1; i <= soTrang; i++) {
										if (curentPage == i) {
											active = "class=\"disabled\"";
										} else {
											active = "";
										}
								%>
								<li <%=active%>><a
									href="<%=request.getContextPath()%>/indexNews?page=<%=i%>"><%=i%></a></li>
								<%
									}
								%>
							</ul>
						</div>
					</div>
				</div>
				<!-- end section 1 -->

			</div>
		</div>
	</div>
</div>

<%@include file="/templates/public/inc/footer.jsp"%>