<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.carousel img.jpg {
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 350px;
}
.carousel img3.jpg {
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 350px;
}
.carousel img2.jpg {
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 300px;
}
</style>
<c:url value="/resources/images" var="img"/>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BuyBig</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main.html">HOME</a></li>
      <li><a href="#">ABOUT</a></li>
      <li><a href="#">CONTACT</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">ADMIN <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/Category"/>">ADD CATEGORY</a></li>
          <li><a href="<c:url value="/supplier"/>">ADD SUPPLIER</a></li>
          <li><a href="<c:url value="/product"/>">ADD PRODUCT</a></li>
        </ul>
      </li></ul>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="login form.html"><span class="glyphicon glyphicon-user"></span>LOGIN</a></li>
      <li><a href="signup.html"><span class="glyphicon glyphicon-log-in"></span>SIGNUP</a></li>
    </ul>
       <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button class="btn btn-default" type="submit">
        <i class="glyphicon glyphicon-search"></i>
      </button>
    </form>
  </div>
</nav>
  
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="${img}/img14.jpg" alt="BUYBIG" width="2000px", height="494px">
      <div class="carousel-caption">
        <h3 style="color:orange">WELCOME TO BUYBIG</h3>
        <p>BIGGEST FASHION HUB!!! SHOP NOW TO GAIN 50% OFF </p>
      </div>
    </div>

    <div class="item">
      <img src="${img}/img13.jpg" alt="BUYBIG" width="2000px", height="394px" >
      <div class="carousel-caption">
        <h3 style="color:orange">WELCOME TO BUYBIG</h3>
        <p>BIGGEST FASHION HUB!!! SHOP NOW TO GAIN 50% OFF</p>
      </div>
    </div>

    <div class="item">
      <img src="${img}/img11.jpg" alt="BUYBIG" width="2000px", height="494px">
      <div class="carousel-caption">
        <h3 style="color:orange">WELCOME TO BUYBIG</h3>
        <p>BIGGEST FASHION HUB!!! SHOP NOW TO GAIN 50% OFF</p>
      </div>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

</body>
</html>