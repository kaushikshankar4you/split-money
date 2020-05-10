<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
  
  	<style>
 .modalDialog {
   position: fixed;
   font-family: Arial, Helvetica, sans-serif;
   top: 0;
   right: 0;
   bottom: 0;
   left: 0;
   background: rgba(0,0,0,0.8);
   z-index: 99999;
   opacity:0;
   -webkit-transition: opacity 400ms ease-in;
   -moz-transition: opacity 400ms ease-in;
   transition: opacity 400ms ease-in;
   pointer-events: none;
 }

 .modalDialog:target {
   opacity:1;
   pointer-events: auto;
 }

 .modalDialog > div {
   width: 400px;
   position: relative;
   margin: 10% auto;
   padding: 5px 20px 13px 20px;
   border-radius: 10px;
   background: #fff;
   background: -moz-linear-gradient(#fff, #999);
   background: -webkit-linear-gradient(#fff, #999);
   background: -o-linear-gradient(#fff, #999);
 }

 .close {
   background: #606061 ;
   color: #FFFFFF ;
   line-height: 25px;
   position: absolute;
   right: -12px;
   text-align: center;
   top: -10px;
   width: 24px;
   text-decoration: none;
   font-weight: bold;
   -webkit-border-radius: 12px;
   -moz-border-radius: 12px;
   border-radius: 12px;
   -moz-box-shadow: 1px 1px 3px #000;
   -webkit-box-shadow: 1px 1px 3px #000;
   box-shadow: 1px 1px 3px #000;
 }

 .allow {
   background-color: #4CAF50 ;
   border: none;
   color: white;
   padding: 15px 20px;
   text-align: center;
   text-decoration: none;
   display: inline-block;
   font-size: 16px;
 }

 .deny {
   background-color: #ff884c ;
   border: none;
   color: white;
   padding: 15px 20px;
   text-align: center;
   text-decoration: none;
   display: inline-block;
   font-size: 16px;
 }

 .close:hover { background: #00d9ff ; }
 </style>
    <title>SnapSplit</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta charset="UTF-8" />
    
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
    
    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet" type="text/css" />
    <link href="css/entypo.css" rel="stylesheet" type="text/css" />
    
    <!-- Template CSS -->
    <link href="css/686tees.css" rel="stylesheet" type="text/css" />
    
    <script>
    
    function gothere()
    {
    	document.someForm.action = "consent.htm";
    	document.someForm.submit();
    }
    
    </script>
  </head>
<body>

<c:if test="${notify=='true'}">
	
   <c:set value="#openModal" var="notifier"></c:set>
   </c:if>
   
   <c:if test="${notify=='false'}">
   <c:set value="#" var="notifier"></c:set>
   </c:if>
   
   <a href=${notifier}>Notification</a>

   <div id="openModal" class="modalDialog">
 <div>
   <a href="#close" title="Close" class="close">X</a>
   <table classstyle="border-color: black; border-width: 2px;">
     <tr><td colspan="2" align="center" ><h2>Pending Split Share</h2></td></tr>
     <tr>
     <td>
       
   
     
     
     
     </td>
     <td style="text-align: center; ">
       <p class="title">${product.name}</a></p>
     
       <p><label>Ordered By: </label><span>${initiator}</span></p>
       <p><label>Total Amount: </label><span>&#x20B9; ${product.price}</span></p>
       <p><label>My Share: </label><span>&#x20B9; ${topay}</span></p>
       <!-- Buttons Here -->
       <form action="consent.htm" method="get">
       <button type="submit" "deny" name="consent" value="deny">Deny</button>&nbsp;&nbsp;
       <button type="submit" "allow" name="consent" value="allow">Allow</button>
       </form>
     </td>
     </tr>
   </table>
 </div>
</div>
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
  
  <div class="row">
    <div class="span4">
      <p class="logo">
        <span class="entypo heart"></span>SplitDeal
      </p>
    </div>
  
    <div class="span4">
      <p class="strapline">
        Dil Ki Deal<br/>
        <span>Mil Baant Ke</span>
      </p>
    </div>
  </div>
  <!-- Menu -->
  
  <div class="row">
    <div class="span12">
      <ul class="main-nav clearfix">
        <li class="active"><a href="index.html">Products</a></li>
      </ul>
    </div>
  </div>

  <!-- Body -->
  
  <div class="row">
    <div class="span12">
      <h1></h1>
    </div>
  </div>
  
  <div class="row">
    <div class="span4 product-listing">
      <p class="title"><a href="product.html">Samsung 40J3000 Curved LEDTV</a></p>
      <a href="#"><img class="image" src="img/prod1.jpg" alt="Samsung Curved LEDTV" /></a>
      <p class="price">
        &#8377; 50,330
        <form action="split.htm" method="get">
           <input type="hidden" name="productId" value="1"/>
           <input class="btn btn-primary pull-right" type="submit" value="Buy Now"/>
	</form>
      </p> 
    </div>
    
    <div class="span4 product-listing">
      <p class="title"><a href="product.html">Philips DSP2800 5.1 Speaker System</a></p>
      <a href="#"><img class="image" src="img/prod2.jpg" alt="Philips DSP2800" /></a>
      <p class="price">
         &#8377; 3,500
         <form action="split.htm" method="get">
           <input type="hidden" name="productId" value="2"/>
           <input class="btn btn-primary pull-right" type="submit" value="Buy Now"/>
	 </form>
      </p>
      
    </div>
    
    <div class="span4 product-listing">
      <p class="title"><a href="product.html">Sony PlayStation4</a></p>
      <a href="#"><img class="image" src="img/prod3.jpg" alt="Sony PlayStation4" /></a>
      <p class="price">
        &#8377; 33,889
        <form action="split.htm" method="get">
           <input type="hidden" name="productId" value="3"/>
           <input class="btn btn-primary pull-right" type="submit" value="Buy Now"/>
	</form>
      </p>
    </div>
  </div>

  
  <div class="row footer">
    <div class="span6">
      <ul class="footer-nav">
        <li><a href="#">Terms &amp; Conditions</a></li>
        <li><a href="#">Delivery Information</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
    </div>
  
    <div class="span6 footer-right">
      <p>
        &copy; SplitDeal
      </p>
    </div>
  
  </div>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>
