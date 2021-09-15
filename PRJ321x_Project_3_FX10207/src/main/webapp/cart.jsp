<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<div class="container">
		<div class="row">
			<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col" class="border-0 bg-light">
									<div class="p-2 px-3 text-uppercase">Product</div>
								</th>
								<th scope="col" class="border-0 bg-light">
									<div class="py-2 text-uppercase">Price</div>
								</th>
								<th scope="col" class="border-0 bg-light">
									<div class="py-2 text-uppercase">Quantity</div>
								</th>
								<th scope="col" class="border-0 bg-light">
									<div class="py-2 text-uppercase">Amount</div>
								</th>
								<th scope="col" class="border-0 bg-light">
									<div class="py-2 text-uppercase">Remove</div>
								</th>
							</tr>
						</thead>
						<c:set scope="session" var="cart" value="${sessionScope.cart}"></c:set>
						<tbody>
							<c:forEach var="product" items="${cart.items}">
								<tr>
									<th scope="row" class="border-0">
										<div class="p-2">
											<img
												src="https://cdn.tgdd.vn/Products/Images/42/114110/iphone-8-plus-hh-600x600.jpg"
												alt="" width="70" class="img-fluid rounded shadow-sm">
											<div class="ml-3 d-inline-block align-middle">
												<h5 class="mb-0">
													<a href="#" class="text-dark d-inline-block align-middle">${product.name}</a>
												</h5>
												<span
													class="text-muted font-weight-normal font-italic d-block">${product.type}</span>
											</div>
										</div>
									</th>
									<td class="border-0 align-middle"><strong>${product.price}</strong></td>
									<td class="border-0 align-middle"><strong>${product.number}</strong></td>
									<td class="border-0 align-middle"><strong>${product.price * product.number}</strong></td>
									<td class="border-0 align-middle"><a
										href="${pageContext.request.contextPath}/cart?action=delete&id=${product.id}"
										class="text-dark"><i class="fa fa-trash"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row justify-content-end">
			<h5>Total: ${cart.amount}</h5>
		</div>
		<div class="row">
			<div class="offset-sm-2 col-sm-8">
				<c:if test="${not empty error}">
				<p class="alert alert-danger">${error}</p>
				</c:if>
				<c:if test="${not empty message}">
				<p class="alert alert-success">${message}</p>
				</c:if>
				<form action="${pageContext.request.contextPath}/cart" method="post">
					<input type="hidden" name="action" value="checkout"/>
					<div class="form-group row">
						<label for="" class="col-sm-5 col-form-label">Customer
							Name</label>
						<div class="col-sm-7">
							<input type="text" name="customer" class="form-control" value="${sessionScope.user.name }">
						</div>
					</div>
					<div class="form-group row">
						<label for="" class="col-sm-5 col-form-label">Email</label>
						<div class="col-sm-7">
							<input type="text" name="email" class="form-control" value="${sessionScope.user.usr}">
						</div>
					</div>
					<div class="form-group row">
						<label for="" class="col-sm-5 col-form-label">Phone</label>
						<div class="col-sm-7">
							<input type="text" name="phone" class="form-control" value="${sessionScope.user.phone }">
						</div>
					</div>
					<div class="form-group row">
						<label for="" class="col-sm-5 col-form-label">Customer
							Address</label>
						<div class="col-sm-7">
							<input type="text" name ="address" class="form-control" value="${sessionScope.user.address }">
						</div>
					</div>
					<div class="form-group row">
						<label for="" class="col-sm-5 col-form-label">Discount
							code (if any)</label>
						<div class="col-sm-7">
							<input type="text" name ="discount" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>