<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
	
		<title>Split Cash</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta charset="UTF-8" />
		
		<!-- Bootstrap -->
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" media="screen" />
		
		<!-- Fonts -->
		<link href="http://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet" type="text/css" />
		<link href="assets/css/entypo.css" rel="stylesheet" type="text/css" />
		
		<!-- Template CSS -->
		<link href="assets/css/686tees.css" rel="stylesheet" type="text/css" />
		
	</head>
<body>

<div class="container">
	
	<!-- Site Top -->
	
	<div class="row">
	
		<div class="span12">
		
			<ul class="top-nav">
				<li><a href="login.html">Login</a></li>
				<li><a href="register.html">Registration</a></li>
				<li><a href="forgot.html">Lost your password?</a></li>
			</ul>
		
		</div>
	
	</div>
	
	<!-- Header -->
	
	<!-- Menu -->
	
	<div class="row">
		
		<div class="span12">
		
			<ul class="main-nav clearfix">
			
				<li><a href="index.html">Products</a></li>
			
			</ul>
		
		</div>
		
	</div>

	<!-- Login -->
	
	<div class="row">
	
		<div class="span6 offset3">
			
			<div class="member-box">
			
				<h2>Login</h2>
				
				<form action="login.htm" method="post">
				
					<p>
						<label for="field-email">Mobile <span class="mand">*</span></label>
						<input type="text" id="field-email" name="uname" />
					</p>
				
					<p>
						<label for="field-password">Password <span class="mand">*</span></label>
						<input type="password" id="field-password" name="pwd" />
					</p>
				
					<p class="buttons">
						<button class="btn btn-primary" type="submit">Continue</button>
					</p>
				
				</form>
				
			</div>
			
		</div>
	
	</div>
	
	<div class="row footer">
	
		<div class="span6">
		
			<ul class="footer-nav">
				<li><a href="content.html">Terms &amp; Conditions</a></li>
				<li><a href="content.html">Delivery Information</a></li>
				<li><a href="contact.html">Contact</a></li>
			</ul>
		
		</div>
	
		<div class="span6 footer-right">
		
			<p>
				&copy; splitcash
			</p>
		
		</div>
	
	</div>
	
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>