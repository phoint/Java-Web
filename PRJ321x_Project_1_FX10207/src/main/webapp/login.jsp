<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<jsp:include page="meta.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="row align-items-center">
			<div class="offset-3 col-6 border border-dark">
				<div class="row bg-white">
					<div class="col">
						<div class="text-center">
							<img class="img-fluid rounded-circle"
								src="http://placehold.jp/200x200.png" alt="">
						</div>
						<em><%=request.getAttribute("invalidMessage")%></em>
						<form action="/PRJ321x_Project_1_FX10207/LoginServlet" method="post">
							<input type="hidden" name="action" value="dologin">
							<div class="form-group">
								<label>Username</label> 
								<input type="text" value="<%= request.getAttribute("username") %>"
									name="username" class="form-control" placeholder="username">
							</div>
							<div class="form-group">
								<label>password</label> 
								<input type="password" name="password" class="form-control">
							</div>
							<div class="form-group">
								<input type="submit" value="Login"
									class="form-control btn-success">
							</div>
							<div class="form-check">
								<input type="checkbox" name="remembered" checked
									class="form-check-input"> <label
									class="form-check-label">Remember me</label>
							</div>
						</form>
					</div>

				</div>
				<div class="row bg-light pt-3">
					<div class="col-6">
						<a href="/PRJ321x_Project_1_FX10207/" class="btn btn-sm btn-danger"
							>Cancel</a>
					</div>
					<div class="col-6 text-right">
						<p>
							<a href="">Forgot password?</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>