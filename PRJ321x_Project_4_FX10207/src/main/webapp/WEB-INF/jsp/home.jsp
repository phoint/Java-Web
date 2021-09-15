<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<c:choose>
					<c:when test="${empty products}">
						<h3>Nothing found</h3>
					</c:when>
					<c:otherwise>
						<div class="row row-cols-1 row-cols-md-2 row-cols-lg-3">
							<c:forEach var="product" items="${products}">
								<div class="col bg-light p-3">
									<a href='<c:url value="/product?id=${product.productId}"></c:url>'>
										<div class="card hoverable">
											<img class="w-75 mx-auto mt-3" src="${product.productImg}" alt="">
											<div class="card-body">
												<h6 class="card-title text-uppercase text-muted">${product.productType}</h6>
												<h6 class="card-subtitle text-info">${product.productName}</h6>
												<p class="card-text text-danger font-weight-bold">${product.productPrice}</p>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>