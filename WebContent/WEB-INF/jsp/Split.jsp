<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<title>Split Cash</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="UTF-8" />

<!-- jQUERY -->
<script type='text/javascript' src='assets/js/jquery-1.10.1.js'></script>

<!-- Bootstrap -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet"
	media="screen" />

<!-- Fonts -->
<link href="http://fonts.googleapis.com/css?family=Bree+Serif"
	rel="stylesheet" type="text/css" />
<link href="assets/css/entypo.css" rel="stylesheet" type="text/css" />

<!-- Template CSS -->
<link href="assets/css/686tees.css" rel="stylesheet" type="text/css" />

<script type='text/javascript'>
	//<![CDATA[ 
	$(window)
			.load(
					function() {
						$(function() {
							var counter = 1;
							$("#addRow")
									.click(
											function() {
												
												var newTextBoxDiv = $(document.createElement('div')).attr("id", 'TextBoxDiv' + counter);

										        newTextBoxDiv.after().html('<input type="text" placeholder="phone number" name="phone' + counter + 
										          '" id="textbox' + counter + '" value="" > <input type="text" placeholder="amount" name="amount' + counter +
										          '" id="textbox' + counter + '" value="" > ');

										        newTextBoxDiv.appendTo("#textboxesgroup");


										    counter++;
												
												//var row = $('<tr><td><input type="text" id="username" placeholder="phone" name="phone" required="true" /></td><td><input type="text" id="user-amount" placeholder="amount" name="amount[]" required="true" /></td><td><button class="btn btn-primary" onclick="">Remove</button></td></tr>');
												//$("#mt tbody").append(row);
											});

						});
					});
</script>

<script>
	function validateAmount() {
		amounts = document.getElementsByName('amount');
		value = 0;
		for (i = 0; i < amounts.length; i++) {
			value += parseInt(amounts[i].value)
		}
		totalAmount = document.getElementById('totalAmount').innerHTML
		totalAmount = parseInt(totalAmount)
		if (value != totalAmount) {
			alert("Total input value is not equal to the product's amount.")
			//return false;
		}
		return true;
	}

	function formSubmit() {
		//alert("submit")
		document.usersForm.action = "splitamount.htm";
		//amount = document.getElementsByName('')
		//phone = 
		document.usersForm.submit();
	}
</script>

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

			<div class="span9 offset2">

				<div class="member-box">

					<h2>Split with friends</h2>

					<div class="span6 product-listing">

						<p class="title">${product.name}</p>
						<p class="title">
							Price: Rs <span id='totalAmount'>${product.price}</span>
						</p>


					</div>

					<form id="usersForm" name="usersForm" method="get">
					<div id='textboxesgroup'></div>
					
					</form>
						<button class="btn btn-primary" id="addRow" class="btn default">Add</button>
				</div>
				<p class="buttons">
					<button type="submit" class="btn btn-primary" onclick="formSubmit()">Continue</button>
				</p>

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

			<p>&copy; splitcash</p>

		</div>

	</div>

	</div>

	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>