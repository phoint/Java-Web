<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<header class="container-fluid">
		<div class="row">
			<div class="col text-right bg-secondary">
			<% if(request.getParameter("username") == null) {  %>
				<a class="px-2 text-white" href="/PRJ321x_Project_1_FX10207/LoginServlet?action=login">Login</a> 
				<a class="px-2 text-white" href="">Sign Up</a>
			<%} else {%>
				<em>Hello, <%= request.getParameter("username") %></em>
				<%} %>
			</div>
		</div>
		<div class="row p-2 bg-dark">
			<div class="col text-center bg-light rounded">
				<h1>My Website</h1>
				<img src="http://placehold.jp/50x50.png" alt="logo">
			</div>
		</div>
		<div class="row">
			<div class="col bg-dark">
				<nav class="navbar navbar-expand-lg m-0 navbar-dark">
					<a class="navbar-brand" href="#">My Website</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link" href="#">Home<span
									class="sr-only">(current)</span></a></li>
							<li class="nav-item"><a class="nav-link" href="#">Product</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">About
									Us</a></li>
						</ul>
						<form class="form-inline my-2 my-lg-0">
							<input class="form-control mr-sm-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="submit">Search</button>
						</form>
					</div>
				</nav>
			</div>
		</div>
	</header>
</body>
</html>