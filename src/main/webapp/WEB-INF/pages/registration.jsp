<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shop Catalog</title>
  <link href="/resources/css/bootstrap.css" rel="stylesheet">


  <script
          src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script
          src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>

<body>

<nav class="navbar navbar-default  ">
  <ul class="nav navbar-nav"/>
</nav>

<nav class="navbar navbar-default  navbar-fixed-top">
  <ul class="nav navbar-nav">
    <li><a href="/home/">Home</a></li>
    <li><a href="/catalog/">Catalog</a></li>
    <li><a href="/delivery/">Delivery</a></li>
    <li><a href="/contacts">Contact us</a></li>
    <li><a href="/about/">About</a></li>
  </ul>
  <ul class="nav navbar-right">

    <form class="navbar-form navbar-left" role="role" action="/catalog/search" method="post">
      <div class="form-group">
        <input type="text" class="form-control" name="pattern" placeholder="Search"/>
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
    </li>
  </ul>

</nav>
<!--MENU OF SITE(TOP)-->
<div class="col-lg-4">
  <form  role="role" action="/registration" method="post">
    <div class="form-group">
      <label for="username">Username</label>
      <input type="text" class="form-control" id="username" name="username" placeholder="username" >
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="text" class="form-control" id="password" name="password" placeholder="password" >
    </div>
    <div class="form-group">
      <label for="firstName">First name</label>
      <input type="text" class="form-control" id="firstName" name="firstName" placeholder="first name" >
    </div>
    <div class="form-group">
      <label for="lastName">Last name</label>
      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="last name" >
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="text" class="form-control" id="email" name="email" placeholder="  @  " >
    </div>
    <div class="form-group">
      <label for="country">Country</label>
      <input type="text" class="form-control" id="country" name="country" placeholder="country" >
    </div>
    <div class="form-group">
      <label for="city">City</label>
      <input type="text" class="form-control" id="city" name="city" placeholder= "city" >
    </div>
    <div class="form-group">
      <label for="street">Street</label>
      <input type="text" class="form-control" id="street" name="street" placeholder= "street" >
    </div>
    <div class="form-group">
      <label for="house">House (and flat) number</label>
      <input type="text" class="form-control" id="house" name="house" placeholder= "your house" >
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Done</button>
      </div>
    </div>
  </form>
</div>


</body>
</html>
