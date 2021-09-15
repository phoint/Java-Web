<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
	
	<main class="container">
		<div class="row">
			<div class="col-md-9">
				<h4 class="text-muted">${product.name}</h4>
				<hr>
				<div class="row my-5">
					<div class="col-md-5">
						<img class="img-fluid" src="${product.src}" alt="product">
					</div>
					<div class="col-md-7">
						<div class="ml-5 w-75">
						<h2 class="text-danger"><fmt:formatNumber type="currency">${product.price}</fmt:formatNumber></h2>
						<p>${product.description}</p>
						<form id="add-to-cart" method="post">
						<input class="btn btn-warning text-white font-weight-bold px-4" type="submit" 
						value="Add to Cart" form="add-to-cart" formaction="${pageContext.request.contextPath}/product?action=add&id=${product.id}"></form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</main>