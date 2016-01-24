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
        .vertical-center {
            min-height: 70%;  /* Fallback for browsers do NOT support vh unit */
            min-height: 70vh; /* These two lines are counted as one :-)       */

            display: flex;
            align-items: center;
        }
    </style>
    <title>Shop Homepage</title>
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
            <li><a href="/catalog">Catalog</a></li>
            <%--<li><a href="/delivery/">Delivery</a></li>--%>
            <li><a href="/contacts">Contact us</a></li>
            <%--<li><a href="/about/">About</a></li>--%>
        </ul>
        <ul class="nav navbar-right">
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            </li>
        </ul>

    </nav><!--MENU OF SITE(TOP)-->

<div class="jumbotron  vertical-center " >
    <h1>Hello, dear customer!</h1>
    <%--<p>Your are welcome in my shop/</p>--%>
    <p><a class="btn btn-default btn-lg" href="/catalog" role="button">Visit the catalog</a></p>
</div>


    <!-- /.container -->
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
