<%@page import="controller.common.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<main class="container-fluid">
		<div class="row login-modal my-5">
			<div class="offset-md-3 col-md-6 login-box">
				<div class="row h-100 align-items-center">
					<div class="col-md-6 text-center py-3">
						<h3>Sign in</h3>
						<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
						</c:if>
						<form action="${pageContext.request.contextPath}/Login" method="POST">
							<input type="hidden" name="action" value="dologin">	
							<input class="form-control mb-2" type="email" name="username" value="<%= CookieUtils.get("loginMail", request) %>">
							<input class="form-control mb-2" type="password" name="password">
							<div class="form-check form-check-inline justify-content-start">
								<input type="checkbox" checked class="form-check-input" name="remember">
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
