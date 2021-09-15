<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
							<form action="">
								<div class="input-group">
									<div class="input-group-prepend">
										<select class="custom-select btn btn-outline-secondary">
											<option selected>Categories</option>
											<option value="1">CELLPHONE</option>
											<option value="2">TABLET</option>
											<option value="3">ACCESSORIES</option>
										</select>
									</div>
									<input type="text" class="form-control" placeholder="what are you looking for?">
									<div class="input-group-append">
										<input type="submit" class="fa-regular fa-magnifying-glass btn btn-warning" value="&#x1f50d">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row bottom-navbar mt-2">
			<div class="container">
				<div class="row align-items-center">
					<div class="offset-lg-3 col-6">
						<nav class="navbar navbar-expand-lg navbar-dark px-0">
							<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarText">
								<ul class="navbar-nav mr-auto">
			  						<li class="nav-item active">
			    						<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
			  						</li>
			  						<li class="nav-item">
			    					<a class="nav-link" href="#">Products</a>
			  						</li>
			  						<li class="nav-item">
			    						<a class="nav-link" href="#">About Us</a>
			  						</li>
								</ul>
							</div>
						</nav>
					</div>
					<div class="col-6 col-lg-3 text-right">
						<% if (session.getAttribute("login") == null || session.getAttribute("login") == "false" ) { %>
						<a class="nav-link text-white" href="/PRJ321x_Project_2_FX10207/LoginServlet?action=login">Login</a> 
						<%} else {%>
						<em class="text-white">Welcome, <%= session.getAttribute("user") %></em>
						<a class="nav-link text-white" href="/PRJ321x_Project_2_FX10207/LoginServlet?action=logout">Logout</a> 
						<%} %>
					</div>
				</div>
			</div>
		</div>
	</header>

</body>
</html>