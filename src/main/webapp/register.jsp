<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	href="${pageContext.request.contextPath}/static/css/login.css">
<!-- --- -->

<title>ShopOnline</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/layout/header.jsp"%>
	<!-- ------ -->

	<div id="main">
		<div class="container">
			<div class="container-form">
				<h1 class="mt-5" style="text-align: center;">Đăng kí</h1>
				<form action="register" method="POST">
					<div class="form-group">
						<c:choose>
							<c:when test="${status=='register_failed'}">
								<div class="alert alert-danger">
									<strong>Failed!</strong> Tên tài khoản đã được sử dụng!
								</div>
							</c:when>
						</c:choose>
						<label>Tên tài khoản:</label> <input type="text"
							class="form-control" placeholder="Enter user name"
							name="username" />
					</div>
					<div class="form-group">
						<label>Mật khẩu:</label> <input type="password"
							class="form-control" placeholder="Enter password" name="password" />
					</div>
					<div class="form-group">
						<label>Email</label> <input type="email"
							class="form-control" placeholder="Enter email" name="email" />
					</div>
					<div class="form-group">
						<label>Họ đệm:</label> <input type="text" class="form-control"
							placeholder="Enter firstname" name="firstname" />
					</div>
					<div class="form-group">
						<label>Tên:</label> <input type="text" class="form-control"
							placeholder="Enter lastname" name="lastname" />
					</div>
					<div class="form-group">
						<label>Số điện thoại:</label> <input type="text"
							class="form-control" placeholder="Enter mobile" name="tel" />
					</div>
					<div class="form-group">
						<label>Thành phố:</label> <input type="text" class="form-control"
							placeholder="Enter city" name="city" />
					</div>
					<div class="form-group">
						<label>Đường:</label> <input type="text" class="form-control"
							placeholder="Enter street" name="street" />
					</div>
					<div class="form-group">
						<label>Quận/Huyện:</label> <input type="text" class="form-control"
							placeholder="Enter district" name="district" />
					</div>
					<div class="form-group">
						<label>Số Nhà:</label> <input type="text" class="form-control"
							placeholder="Enter noHome" name="noHome" />
					</div>
					<div style="text-align: center; margin-top: 20px;">
						<button type="submit" class="btn btn-success">
							<i class="fas fa-upload"></i> Register
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- FOOTER -->
	<%@ include file="/layout/footer.jsp"%>
	<!-- ------ -->

</body>

</html>