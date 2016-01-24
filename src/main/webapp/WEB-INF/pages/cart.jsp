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
  <style>

    #cart p {
      color: rgb(49, 151, 116); /* Цвет текста */
    }
  </style>
  <title>Shop Catalog</title>

  <link href="/resources/css/bootstrap.css" rel="stylesheet">


  <script
          src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script
          src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>

<body id="cart">

<nav class="navbar navbar-default  ">
  <ul class="nav navbar-nav"/>
</nav>

<nav class="navbar navbar-default  navbar-fixed-top">
  <ul class="nav navbar-nav">
    <li><a href="/home/">Home</a></li>
    <li><a href="/catalog/">Catalog</a></li>
    <%--<li><a href="/delivery/">Delivery</a></li>--%>
    <li><a href="/contacts">Contact us</a></li>
    <%--<li><a href="/about/">About</a></li>--%>
  </ul>
  <%--<ul class="nav navbar-right">--%>
    <%--<form class="navbar-form navbar-left" role="role" action="/catalog/search" method="post">--%>
      <%--<div class="form-group">--%>
        <%--<input type="text" class="form-control" name="pattern" placeholder="Search">--%>
      <%--</div>--%>
      <%--<button type="submit" class="btn btn-default">Submit</button>--%>
    <%--</form>--%>
    <%--</li>--%>
  <%--</ul>--%>

</nav>
<!--MENU OF SITE(TOP)-->
<table class="table ">
  <thead>
  <tr>
    <td class="text-muted"><b>Name</b></td>
    <td class="text-muted"><b>Short Description</b></td>
    <td class="text-muted"><b>Code</b></td>
    <td class="text-muted"><b>Price</b></td>
  </tr>
  </thead>
  <c:forEach items="${products}"  varStatus="loop" var="product">

  <tr>
    <c:forEach items="${product}" var="value">
    <td class="text-muted">${value}</td>
    <%--<td>${item.name}</td>--%>
    <%--<td>${adv.short_Dedcription}</td>--%>
    <%--<td>${adv.code}</td>--%>
    <%--<td>${adv.price}</td>--%>
    </c:forEach>
    <td><a class="button" href="/catalog/cart/delete/${loop.index}">Delete</a></td>
  </tr>

  </c:forEach>

</body>
</html>
