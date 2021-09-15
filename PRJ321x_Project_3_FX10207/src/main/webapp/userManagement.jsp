<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="container">
	<div class="row">
		<div class="col">
			<c:if test="${not empty requestScope.message }">
				<div class="alert alert-success">${requestScope.message}</div>
			</c:if>
			<c:if test="${not empty requestScope.error }">
				<div class="alert alert-danger">${requestScope.error }</div>
			</c:if>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<form action="UserServlet" method="post">
				<div class="form-group">
					<label for="userName">Username</label> <input type="text"
						class="form-control" name="userName" id="userName" value="${user.name}">
				</div>
				<div class="form-group">
					<label for="email">Email Address</label> <input type="text"
						class="form-control" name="email" id="email" value="${user.usr}">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" id="password">
				</div>
				<div class="form-group">
					<label for="address">Address</label> <input type="text"
						class="form-control" name="address" id="address" value="${user.address}">
				</div>
				<div class="form-group">
					<label for="phone">Phone</label> <input type="text"
						class="form-control" name="phone" id="phone" value="${user.phone}">
				</div>
				<div class="form-check form-check-inline">
					<label>Role: </label> <label class="ml-2"> <input
						type="radio" class="form-check-input" id="admin" name="admin"
						value="1" ${user.role == 1 ? 'checked':''}>Admin
					</label> <label class="ml-2"> <input type="radio"
						class="form-check-input" id="user" name="admin" value="2" ${user.role == 2 ? 'checked':''}>User
					</label>
				</div>
				<div class="form-group">
					<button class="btn btn-primary" formaction="${pageContext.request.contextPath}/UserServlet/create">Create</button>
					<button class="btn btn-warning" formaction="${pageContext.request.contextPath}/UserServlet/update">Update</button>
					<button class="btn btn-danger" formaction="${pageContext.request.contextPath}/UserServlet/delete">Delete</button>
					<button class="btn btn-info" formaction="${pageContext.request.contextPath}/UserServlet/reset">Reset</button>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-stripe">
				<tr>
					<td>Id</td>
					<td>Username</td>
					<td>Email</td>
					<td>Password</td>
					<td>Address</td>
					<td>Phone</td>
					<td>Role</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${list }" varStatus="loop">
					<tr>
						<td>${loop.count}</td>
						<td>${item.name }</td>
						<td>${item.usr }</td>
						<td>${item.pwd }</td>
						<td>${item.address }</td>
						<td>${item.phone }</td>
						<td>${item.role == 1 ? 'admin':'user' }</td>
						<td><a href="${pageContext.request.contextPath}/UserServlet/edit?email=${item.usr}">Edit</a> 
						<a href="${pageContext.request.contextPath}/UserServlet/delete?email=${item.usr}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</main>