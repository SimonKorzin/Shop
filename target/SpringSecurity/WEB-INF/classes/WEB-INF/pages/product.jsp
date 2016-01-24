<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
    <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="../../resources/css/screen.css" media="screen"/>


    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <spring:url value="/resources/js/jquery.1.10.2.min.js"
                var="jqueryJs" />
    <script src="${jqueryJs}"></script>
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
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        </li>
    </ul>

</nav>
<!--MENU OF SITE(TOP)-->


<h3>
    <!--Proguct name form database <span class="label label-default">New</span></h3>-->
    <%--<p>#{product.name}</p>--%>
</h3>

<div class="container">
    <div class="col-sm-4">
        <div id="wrapper">

            <div id="header">
                <h1>Image-Gallery</h1>
            </div>
            <!-- #header -->


            <div id="content">

                <div id="gallery-wrapper">

                    <div id="viewer-wrapper">

                        <div id="gallery-viewer">
                            <img alt="Placeholder" src="images/placeholder.png">
                        </div>
                        <!-- #gallery-viewer -->

                    </div>
                    <!-- #viewer-wrapper" -->

                    <div id="viewer-nav">
                        <a id="gallery-viewer-next" href="#">next</a>
                        <a id="gallery-viewer-prev" href="#">previous</a>
                    </div>
                    <!-- #viewer-nav -->

                    <div id="thumbs-nav">
                        <a id="gallery-next" href="#">next</a><a id="gallery-prev" href="#">previous</a>

                        <p id="gallery-pos">page 1 of 2</p>
                    </div>

                    <div id="thumbs-wrapper">

                        <div id="gallery">
                            <c:forEach items="${photos}" var="photo">
                                <div class="thumbnail">
                                    <img alt="Wasteland" src="${photo.first_photo}">
                                </div>
                            </c:forEach>
                        </div>
                        <!-- #gallery -->

                    </div>
                    <!-- #thumbs-wrapper -->

                </div>
                <!-- #gallery-wrapper -->

            </div>
        </div>
    </div>
            <%--<div class="col-md-3">--%>
            <%--<c:forEach items="${photos}" var="photo">--%>
            <%--<img src="${photo.first_photo}" class="img-responsive" alt="Cinque Terre"/>--%>
            <%--</c:forEach>--%>
            <%--</div>--%>
            <div class="col-md-7">
                <div class="panel panel-warning">
                    <div class="panel-heading"><h2> Description</h2></div>
                    <div class="panel-body" style="max-height: 20 height: 20">
                        <p>${product.description}</p>

                        <p>Description of product from database Description of product from database Description of
                            product from
                            database</p>

                        <p>Description of product from database Description of product from database Description of
                            product from
                            database</p>

                        <p>Description of product from database Description of product from database Description of
                            product from
                            database</p>

                        <p>Description of product from database Description of product from database Description of
                            product from
                            database</p>

                        <p>Description of product from database Description of product from database Description of
                            product from
                            database</p>

                        <p>Description of product from database Description of product from database Description of
                            product from
                            database</p>

                        <p>Description of product from database Description of product from database Description of
                            product from
                            database</p>

                        <p>Description of product from database Description of product from database Description of
                            product from
                            database</p>

                        <p>Description of product from database Description of product from database Description of
                            product from
                            database</p>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-sm-7">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12">
                                <h3>User Comment Example</h3>
                            </div>
                            <!-- /col-sm-12 -->
                        </div>
                        <!-- /row -->
                        <c:forEach items="${comments}" var="comment">
                            <div class="row">
                                <div class="col-sm-1">
                                    <div class="thumbnail">
                                        <img class="img-responsive user-photo"
                                             src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
                                    </div>
                                    <!-- /thumbnail -->
                                </div>
                                <!-- /col-sm-1 -->

                                <div class="col-sm-5">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <strong>${comment.name}</strong> <span
                                                class="text-muted">${comment.comment_date}</span>
                                        </div>
                                        <div class="panel-body">
                                                ${comment.text}
                                        </div>
                                        <!-- /panel-body -->
                                    </div>
                                    <!-- /panel panel-default -->
                                </div>
                                <!-- /col-sm-5 -->


                            </div>
                            <!-- /row -->
                        </c:forEach>


                    </div>
                    <div class="container">
                        <div class="row"><h3>Status Upload Snipp</h3></div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="widget-area no-padding blank">
                                    <div class="status-upload">
                                        <%--<form role="form" id="commentFrom" enctype="multipart/form-data" class="form-horizontal" action="/catalog/product/${product.id}/add" method="post">--%>
                                        <form id="commentFrom" class="form-horizontal">
                                            <h3>You can add new comment</h3>
                                            <div class="form-group"><input type="text" class="form-control" name="name" id="commentName" placeholder="Write your name, please."></div>
                                            <div class="form-group"><textarea rows="5" type="text" name="text" id="commentText" placeholder="And your comment."></textarea></div>
                                            <div class="form-group"><input type="submit" class="btn btn-primary" value="Add" id="commentSubmit"></div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <script>
                        jQuery(document).ready(function() {
                            $("#commentFrom").submit(function(event) {

                                var comment = {}
                                comment["name"] = $("#commentName").val();
                                comment["text"] = $("#commentText").val();

                                $.ajax({
                                    url: "/catalog/product/${product.id}/add",
                                    contentType: 'application/json',
                                    data: JSON.stringify(comment),
                                    type: 'POST',
                                    timeout : 100000,
                                    success: function(data) {
//                                        console.log("SUCCESS: ", data);
//                                        display(data);
//                                        location.reload();
                                    },
                                    error: function(xhr,status,errorThrown) {
                                        alert('adding comment failed with status: ' + status + ". " + errorThrown);
                                    }
                                });
                            });
                        });
//                        function display(data) {
//                            var json = "<h4>Ajax Response1</h4><pre>"
//                                    + JSON.stringify(data, null, 4) + "</pre>";
//                            $('#feedback').html(json);
//                        }

                    </script>
                    <!-- javascript -->
                    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
                    <script type="text/javascript" src="../../resources/js/jquery.jfollow.js"></script>
                    <script type="text/javascript" src="../../resources/js/jquery.imagesloaded.min.js"></script>
                    <script type="text/javascript" src="../../resources/js/jquery.ImageGallery.js"></script>
                    <script type="text/javascript">
                        // set up the gallery
                        $('#gallery').gallery({
                            'rows': 1,
                            'cols': 5
                        });

                        // some extra interface stuff... pay no attention to the man behind the curtain
                        var gallery = $('#gallery-wrapper'), setup = $('#setup-wrapper');
                        setup.hide();
                        $('#show-setup').click(function () {
                            gallery.fadeOut(400, function () {
                                setup.fadeIn();
                            });
                            return false;
                        });
                        $('#show-gallery').click(function () {
                            setup.fadeOut(400, function () {
                                gallery.fadeIn();
                            });
                            return false;
                        });
                        $('#nav-wrapper').jfollow('#followbox', 20);
                    </script>
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

