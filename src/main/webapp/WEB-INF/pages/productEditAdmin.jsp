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
    <form  role="role" action="/admin/catalog/edit/${product.id}" method="post">
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${product.name}">
      </div>
      <div class="form-group">
        <label for="code">Code</label>
        <input type="text" class="form-control" id="code" name="code" placeholder="Code" value="${product.code}">
      </div>
      <div class="form-group">
        <label for="price">Price</label>
        <div class="col-lg-5">
          <input type="text" class="form-control" id="price" name="price" placeholder="Price" value="${product.price}">
        </div>
      </div>
      <div class="form-group">
        <label for="short_description">Short description</label>
        <textarea class="form-control" rows="3" id="short_description" name="short_description" >${product.short_description}</textarea>
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <textarea class="form-control" rows="7" id="description" name="description">${product.description}</textarea>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-warning">Edit</button>
        </div>
      </div>
    </form>
</div>


</body>
</html>
