<!DOCTYPE html>
<!-- <html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"> -->
	<html>
	<!--add dependence   -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta charset="utf-8" />
	<title>Product List</title>
	
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css" type="text/css">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	<script src="./resources/js/jquery.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./resources/css/jquery.dataTables.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- 
	<link rel="stylesheet" href="./resources/css/shoe.css"> -->
 <!--    <link rel="stylesheet" href="./resources/css/caroualresponsive.css">
 -->
 
</head>
<body>
 
<br/>
<br/>
<br/>
<br/>
<div class="container-fluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
			
			<div class="container-fluid">		
			<div class="col-md-12 product-info">
					<ul id="myTab" class="nav nav-tabs nav_tabs">
						
						<li class="active"><a href="#service-one" data-toggle="tab">DESCRIPTION</a></li>
						
						
					</ul>
				<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in active" id="service-one">
						 
							<section class="container product-info">
																
							</section>
										 
						</div>
					<div class="tab-pane fade" id="service-two">
						
						<section class="container">
								
						</section>
						
					</div>
					<div class="tab-pane fade" id="service-three">
												
					</div>
				</div>
			<br/>
			<br/><img id="item-display" src="./resources/product/${productdt.image}" alt="" width="400" height="400"></img>
						
					
				
				<div class="col-md-7">
					<div class="product-title">${productdt.prodName}</div>
					<div class="product-desc">${productdt.prodDescription}</div>
					<div class="product-rating"><i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star-o"></i> </div>
					<hr>
					<div class="product-price">${productdt.prodPrice}</div>
					<hr>
					<form action="addCart" method="post">
					Enter Quantity : <input type="number" name="q"/><input type="hidden" name="id" value="${productdt.prodId}"/>
					<div class="btn-group cart">
						<button type="submit" class="btn btn-success">
							Add to cart 
						</button>
						
					</div>
					</form>
				</div>
			</div> 
		</div>
		
				<hr>
			</div>
		</div>
	</div>
</div>
  <br/>

</body>
</html>