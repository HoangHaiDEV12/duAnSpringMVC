<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chu</title>
</head>
<body>

	<div class="col-lg-3"></div>
	
	<img alt="" src="data:image/png;base64,${base64Image}">

	<div class="col-lg-9">

		<div id="header-carousel" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active" style="height: 410px;">
					<img class="img-fluid" src="https://png.pngtree.com/background/20210709/original/pngtree-tanabata-full-screen-banner-background-flowers-pink-picture-image_918737.jpg" alt="Image">
					<div
						class="carousel-caption d-flex flex-column align-items-center justify-content-center">
						<div class="p-3" style="max-width: 700px;">
							<h4 class="text-light text-uppercase font-weight-medium mb-3">10%
								Off Your First Order</h4>
							<h3 class="display-4 text-white font-weight-semi-bold mb-4">Fashionable
								Dress</h3>
							<a href="" class="btn btn-light py-2 px-3">Shop Now</a>
						</div>
					</div>
				</div>
				<div class="carousel-item" style="height: 410px;">
					<img class="img-fluid" src="https://png.pngtree.com/background/20210709/original/pngtree-swimming-pool-summer-summer-full-screen-poster-background-picture-image_914893.jpg" alt="Image">
					<div
						class="carousel-caption d-flex flex-column align-items-center justify-content-center">
						<div class="p-3" style="max-width: 700px;">
							<h4 class="text-light text-uppercase font-weight-medium mb-3">10%
								Off Your First Order</h4>
							<h3 class="display-4 text-white font-weight-semi-bold mb-4">Reasonable
								Price</h3>
							<a href="" class="btn btn-light py-2 px-3">Shop Now</a>
						</div>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#header-carousel"
				data-slide="prev">
				<div class="btn btn-dark" style="width: 45px; height: 45px;">
					<span class="carousel-control-prev-icon mb-n2"></span>
				</div>
			</a> <a class="carousel-control-next" href="#header-carousel"
				data-slide="next">
				<div class="btn btn-dark" style="width: 45px; height: 45px;">
					<span class="carousel-control-next-icon mb-n2"></span>
				</div>
			</a>
		</div>
	</div>

	<!-- Featured Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5 pb-3">
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-check text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">Quality Product</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
					<h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="d-flex align-items-center border mb-4"
					style="padding: 30px;">
					<h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
					<h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
				</div>
			</div>
		</div>
	</div>
	<!-- Featured End -->

	<!-- Categories Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5 pb-3">
			<c:forEach var="category" items="${categories}">
				<div class="col-lg-4 col-md-6 pb-1">
					<div class="cat-item d-flex flex-column border mb-4"
						style="padding: 30px;">
						<input type="hidden" value="${category.categoryID }"> <a
							href="/com.tulamweb/homelist?categoryId=${category.categoryID }" class="cat-img position-relative overflow-hidden mb-3">
							<c:if test="${ not empty category.image}">
							<img class="d-block w-50" alt="category"
							src="data:image/png;base64,${category.image}">
							</c:if>
						</a>
						<h5 class="font-weight-semi-bold m-0">${category.categoryName}</h5>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	<!-- Categories End -->

	<!-- Products Start -->
	<div class="container-fluid pt-5">
		<div class="text-center mb-4">
			<h2 class="section-title px-5">
				<span class="px-2">Trandy Products</span>
			</h2>
		</div>
		<div class="row px-xl-5 pb-3">
			<c:forEach var="pTetails" items="${poductdates}">
				<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
					<div class="card product-item border-0 mb-4">
						<div
							class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">

							<c:if test="${ not empty pTetails.imageList[0].image}">
								<img class="img-fluid w-75"
									src="data:image/png;base64,${pTetails.imageList[0].image}"
									alt="Second slide" />
							</c:if>
						</div>
						<div
							class="card-body border-left border-right text-center p-0 pt-4 pb-3">
							<h6 class="text-truncate mb-3">${pTetails.nameProduct}</h6>
							<div class="d-flex justify-content-center">
								  <h6>${pTetails.price - pTetails.price* 10/100} VND</h6><h6 class="text-muted ml-2"><del>${pTetails.price} VND</del></h6>

							</div>
						</div>
						<div
							class="card-footer d-flex justify-content-between bg-light border">
							<a href="/com.tulamweb/homepdetile?productId=${pTetails.productId}" class="btn btn-sm text-dark p-0"><i
								class="fas fa-eye text-primary mr-1"></i>View Detail</a> <a href=""
								class="btn btn-sm text-dark p-0"><i
								class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
						</div>
					</div>
				</div>
			</c:forEach>




		</div>
	</div>
	<!-- Products End -->

	<!-- Vendor Start -->
	<div class="container-fluid py-5">
		<div class="row px-xl-5">
			<div class="col">
				<div class="owl-carousel vendor-carousel">
					<div class="vendor-item border p-4">
						<img src="img/vendor-1.jpg" alt="">
					</div>
					<div class="vendor-item border p-4">
						<img src="img/vendor-2.jpg" alt="">
					</div>
					<div class="vendor-item border p-4">
						<img src="img/vendor-3.jpg" alt="">
					</div>
					<div class="vendor-item border p-4">
						<img src="img/vendor-4.jpg" alt="">
					</div>
					<div class="vendor-item border p-4">
						<img src="img/vendor-5.jpg" alt="">
					</div>
					<div class="vendor-item border p-4">
						<img src="img/vendor-6.jpg" alt="">
					</div>
					<div class="vendor-item border p-4">
						<img src="img/vendor-7.jpg" alt="">
					</div>
					<div class="vendor-item border p-4">
						<img src="img/vendor-8.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</div> 
	
	
</body>
</html>
<!-- Vendor End -->