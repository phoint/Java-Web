<%@page import="controller.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="login-page">
	<jsp:include page="meta.jsp"></jsp:include>
	<main class="container-fluid position-fixed login-modal h-50 ">
		<div class="row h-100">
			<div class="offset-md-3 col-md-6 login-box">
				<div class="row h-100 align-items-center">
					<div class="col-md-6 text-center py-3">
						<h3>Sign in</h3>
						<% if (request.getSession(false) != null && session.getAttribute("error") != null) { %>
						<em><%= session.getAttribute("error") %></em> <%} else { %>
						<em></em> <%} %>
						<form action="/PRJ321x_Project_2_FX10207/LoginServlet" method="POST">
							<input type="hidden" name="action" value="dologin">	
							<input class="form-control mb-2" type="email" name="username" value="<%= CookieUtils.get("username", request) %>">
							<input class="form-control mb-2" type="password" name="password">
							<div class="form-check form-check-inline justify-content-start">
								<input type="checkbox" checked class="form-check-input" name="remember" value="yes">
								<label class="form-check-label">Remember me</label>
							</div>
							<p><a href="">Forgot your password?</a></p>
							<input type="submit" class="btn btn-danger rounded-pill my-2 px-4" value="login">

						</form>
					</div>
					<div class="col-md-6 bg-dark h-100">
						<div class="row h-100 align-content-center text-white px-3">
							<h2>Welcome back</h2>
							<p>To keep connect with us, please login with your personal info</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>