<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
	<main class="container">
			<section class="row">
				<div class="col">
					<div class="alert alert-success">
						<h1>Đăng ký</h1>
					</div>
				</div>
			</section>
			<section class="row">
			<div class="col-md-7">
				<div class="row m-1 m-sm-2">
					<div class="col pb-1 p-sm-3 rounded shadow">
						<form action="RegisterServlet" method="post">
							<div class="form-group">
								<label for="username">Username</label>
								<input type="text" class="form-control" id="username" name="username" required />
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<input type="password" name="password" id="password" class="form-control" required/>
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<input type="email" name="email" id="email" class="form-control" required/>
							</div>
							<div class="form-group">
								<label for="phone">Phone</label>
								<input type="text" name="phone" id="phone" class="form-control"/>
							</div>
							<div class="form-group">
								<label for="address">Địa chỉ:</label>
								<input type="text" name="address" id="address" class="form-control">
							</div>
							<hr>
							<button type="submit" class="btn btn-primary">Đăng ký</button>
						</form>
					</div>
				</div>
			</div>
		<div class="col-md-5">
			<h3>Thong tin da duoc dang ky</h3>
				<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			<ul class="list-group">
				<li class="list-group-item">username: ${param.username} </li>
				<li class="list-group-item">email: ${param.email}</li>
				<li class="list-group-item">phone: ${param.phone}</li>
				<li class="list-group-item">address: ${param.address}</li>
			</ul>
				</c:if>
				<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
				</c:if>
		</div>
		</section>
	</main>