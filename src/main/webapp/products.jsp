<%@page import="dao.bookdao.BookDAOImpl"%>
<%@page import="model.book.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="description" content="app mua sách">
<meta name="keywords" content="app, mua, sách">
<meta name="author" content="CuongPham">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS & JS -->
<%@ include file="/layout/css_js.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/products.css">
<!-- --- -->

<title>ShopOnline</title>
</head>

<body>
	<%	BookDAOImpl itemBookDAOImpl = new BookDAOImpl();
	List<ItemBook>listItemBook = itemBookDAOImpl.getAllItemBook();
%>
	<!-- HEADER -->
	<%@ include file="/layout/header.jsp"%>
	<!-- --------->
	<div id="main">
		<div class="container">
			<h3 class="tieu-de" style="margin-top: 20px; text-align: center;">SẢN
				PHẨM</h3>

			<div class="row">
				<%
                	for(ItemBook item : listItemBook){
                %>
				<div class="col-md-3">
					<a href="book-detail?id=<%=item.getId() %>"> <img
						src="<%=item.getBook().getImage()%>">
						<div class="infor" style="text-align: center;">

							<a href="book-detail?id=<%=item.getId()%>">
								<h6><%=item.getBook().getTitle() %></h6>
							</a>

							<div class="price-buy">
								<p>
									<fmt:formatNumber type="number" maxFractionDigits="3"
										value="<%=item.getPrice() %>" />
									Đ
								</p>
								<a
									href="${pageContext.request.contextPath }/cart?&action=buy&id=<%=item.getId()%>"><i
									class="fas fa-shopping-cart"></i>&nbsp;+</a>
							</div>
						</div>
				</div>

				<% }%>

				<!-- 
                    	<c:forEach var="item" items="${listItemBook }">
                        <div class="col-md-3">
                            <a href="book-detail?id=${item.getId()}">
                                    <img src="${ item.getBook().getImage()}">
                            <div class="infor" style="text-align: center;">
                                 <a href="book-detail?id=${item.getId()}">
                                    <h6>${item.getBook().getTitle()}</h6>
                                </a>
                                <div class="price-buy">
                                    <p>
                                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                                          value="${item.getPrice()}" />
                                        Đ
                                    </p>
                                    <a href="${pageContext.request.contextPath }/cart?&action=buy&id=${item.getId()}"><i
                                            class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                     -->

			</div>


		</div>

	</div>
	<br>
	<!-- FOOTER -->
	<%@ include file="/layout/footer.jsp"%>
	<!-- ------ -->
</body>

</html>