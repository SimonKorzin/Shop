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
        <%--<li><a href="/delivery/">Delivery</a></li>--%>
        <li><a href="/contacts">Contact us</a></li>
        <li><a href="/cart">About</a></li>
        <li><a href="/catalog/cart">Cart</a></li>
    </ul>
    <ul class="nav navbar-right">

        <form class="navbar-form navbar-left" role="role" action="/catalog/search" method="post">
            <div class="form-group">
                <input type="text" class="form-control" name="pattern" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        </li>
    </ul>

</nav>
<!--MENU OF SITE(TOP)-->

<nav>
    <div class="wrapper container">
        <header></header>
        <nav></nav>
        <div class="heading"></div>
        <div class="row">
            <aside class="col-md-7"></aside>
            <section class="col-md-17"></section>
        </div>
    </div>
    <!-- ПРОБЕЛ -->
    <footer></footer>
    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Shop Name</p>

                <div class="list-group">
                    <li><a class="list-group-item" href="/catalog/">All</a></li>
                    <c:forEach items="${groups}" var="group">
                        <li><a class="list-group-item" href="/catalog/group/${group.id}">${group.name}</a></li>
                    </c:forEach>
                    <%--<a href="/catalog/group/1" class="list-group-item">Category 1</a>--%>
                    <%--<a href="/catalog/group/2" class="list-group-item">Category 2</a>--%>
                    <%--<a href="/catalog/group/3" class="list-group-item">Category 3</a>--%>
                </div>

                <div class="panel-default">

                    <div class="col-xs-8">
                    <div class="alert alert-success" role="alert">
                        <a>Set price limits</a>
                    </div>
                    </div>
                    <div class="panel-body">
                        <form  role="role" action="/catalog/limits" method="post">
                            <div class="form-group">
                                <div class="row">
                                <div class="col-xs-7">
                                    <input type="text" class="form-control" name="upperBound" placeholder="upper bound">
                                    <input type="text" class="form-control" name="lowerBound" placeholder="lower bound">
                                </div>

                            </div>
                            </div>
                            <button type="submit" class="btn btn-success">Restrict</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- PRODUCT'S MENU-->

            <div class="col-md-9">
                <div class="row">
                    <c:forEach items="${products}" var="product">
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <img src="/resources/img/product/product_photo${product.id}-1.jpg" alt="">

                                <div class="caption">
                                    <h4 class="pull-right">${product.price}<span class="glyphicon glyphicon-usd"/></h4>
                                    <h4><a href="#">${product.name}</a>
                                    </h4>

                                    <p>${product.short_description}</p>

                                </div>
                                <div class="ratings">

                                    <p><a href="/catalog/cart/${product.id}" class="btn btn-primary" role="button"><span
                                            class="glyphicon glyphicon-plus"/><span
                                            class="glyphicon glyphicon-shopping-cart"/></a>
                                        <a href="/catalog/product/${product.id}" class="btn btn-default" role="button">Detail</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">

                        <p>Copyright &copy; Your Website 2014</p>
                    </div>

                </div>
            </footer>

        </div>
        <!-- /.container -->
        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </div>
</body>

</html>
