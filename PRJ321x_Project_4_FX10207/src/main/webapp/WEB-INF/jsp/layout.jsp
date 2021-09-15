<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${page.title}</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
	integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet" href='<c:url value="/resources/css/style.css"/>'>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<script src="https://use.fontawesome.com/e5306f616a.js"></script>
</head>
<body>
	<header class="container-fluid">
		<div class="row">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-md-3">
						<h1 class="text-center">PRJ321x</h1>
						<p>Welcome to my website</p>
					</div>
					<div class="col-md-9">
						<div class="search-form">
							<form action="${pageContext.request.contextPath}/" method="post">
								<div class="input-group">
									<div class="input-group-prepend">
										<select class="custom-select btn btn-outline-secondary">
											<option selected>Categories</option>
											<option value="1">CELLPHONE</option>
											<option value="2">TABLET</option>
											<option value="3">ACCESSORIES</option>
										</select>
									</div>
									<input type="text" class="form-control"
										placeholder="what are you looking for?" name="searchKey">
									<div class="input-group-append">
										<input type="submit"
											class="fa-regular fa-magnifying-glass btn btn-warning"
											value="&#x1f50d">
									</div>
								</div>
							</form>
						</div>
					</div>
					<c:if test="${not empty sessionScope.loginUser}">
						<div class="col text-white text-right">Welcome,
							${sessionScope.loginUser.userName}</div>
					</c:if>
				</div>
			</div>
		</div>
		<div class="row bottom-navbar mt-2">
			<div class="container">
				<div class="row align-items-center">
					<div class="offset-lg-3 col-6">
						<nav class="navbar navbar-expand-lg navbar-dark px-0">
							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#navbarText"
								aria-controls="navbarText" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarText">
								<ul class="navbar-nav mr-auto">
									<li class="nav-item active"><a class="nav-link"
										href="${pageContext.request.contextPath}/index.html">Home <span
											class="sr-only">(current)</span></a></li>
									<li class="nav-item"><a class="nav-link"
										href="${pageContext.request.contextPath}/index.html">Products</a>
									</li>
									<li class="nav-item"><a class="nav-link" href="#">About
											Us</a></li>
								</ul>
							</div>
						</nav>
					</div>
					<div class="col-6 col-lg-3 text-right">
						<nav class="nav justify-content-end">
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
								role="button" aria-haspopup="true" aria-expanded="false">Account</a>
								<div class="dropdown-menu">
									<c:choose>
										<c:when test="${empty sessionScope.loginUser.userName}">
											<a class="dropdown-item"
												href="${pageContext.request.contextPath}/login.html">Login</a>
											<a class="dropdown-item"
												href="${pageContext.request.contextPath}/register.html">Sign
												Up</a>
										</c:when>
										<c:otherwise>
											<a class="dropdown-item"
												href="${pageContext.request.contextPath}/logoff.html">Logout</a>
										</c:otherwise>
									</c:choose>
									<c:if test="${sessionScope.role eq 'isAdmin'}">
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/UserServlet">Management</a>
									</c:if>
								</div>
							</li>
							<c:set scope="session" var="cart" value="${sessionScope.cart}"></c:set>
							<li class="nav-item mt-2"><a
								href="${pageContext.request.contextPath}/cart"> <i
									class="fa" style="font-size: 18px">&#xf07a;</i> <span
									class='badge badge-warning' id='lblCartCount'>${cart.totalItems}</span></a>
							</li>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</header>
	<tiles:insertAttribute name="main"/>
	<footer class="container-fluid">
		<div class="row large-block">
			<div class="col small-block mt-4 py-2">
				<p class="text-center">
					Copyright &#xa9 2019 JavaWeb 2021 TEAM <br />Contact Us: <a
						href="#">Member 1</a> | <a href="#">Menber 2</a> | <a href="#">Member
						3</a> | <a href="#">Menber 4</a>
				</p>
			</div>
		</div>
	</footer>
</body>
</html>