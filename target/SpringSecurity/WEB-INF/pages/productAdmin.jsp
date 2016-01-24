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
  <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" type="text/css" href="../../resources/css/screen.css" media="screen"/>

  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>
<%--<div class="status-upload">--%>
    <%--<form role="form" id="commentFrom" enctype="multipart/form-data" class="form-horizontal" action="/catalog/product/${product.id}/add" method="post">--%>
        <%--<div class="form-group"><h3>You can add new comment</h3></div>--%>
        <%--<div class="form-group"><input type="text" class="form-control" name="name" id="commentName" placeholder="Write your name, please."></div>--%>
        <%--<div class="form-group"><textarea rows="5" type="text" name="text" id="commentText" placeholder="And your comment."></textarea></div>--%>
        <%--<div class="form-group"><input type="submit" class="btn btn-primary" value="Add" id="commentSubmit"></div>--%>
    <%--</form>--%>
<%--</div>--%>
<script>
    $(document).ready(function(){
        $("#commentSubmit").click(function() {
            var comment = {
                name : $("#commentName").val(),
                text : $("#commentText").val()
             };
        $.ajax({
            url: "add.as",
            contentType: 'application/json',
            data: JSON.stringify(comment),
                type: 'POST',
            success: function(data) {
                location.reload();
            },
            error: function(xhr,status,errorThrown) {
                alert('adding comment failed with status: ' + status + ". " + errorThrown);
            }
        });
    });
    });
</script>
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
      <div class="panel-body" style="max-height: 20; height: 20`">
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
                <p>
                  <a href="/admin/catalog/comment/delete/${comment.id}" class="btn btn-danger" role="button">Delete</a>
                </p>
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
        <div class="row">
          <h3>Status Upload Snipp</h3>
        </div>

        <div class="row">

          <div class="col-md-6">
            <div class="widget-area no-padding blank">
                <div class="status-upload">
                    <form role="form" id="commentFrom" enctype="multipart/form-data" class="form-horizontal" action="/catalog/product/${product.id}/add" method="post">
                        <div class="form-group"><h3>You can add new comment</h3></div>
                        <div class="form-group"><input type="text" class="form-control" name="name" id="commentName" placeholder="Write your name, please."></div>
                        <div class="form-group"><textarea rows="5" type="text" name="text" id="commentText" placeholder="And your comment."></textarea></div>
                        <div class="form-group"><input type="submit" class="btn btn-primary" value="Add" id="commentSubmit"></div>
                    </form>
                </div>
              <!-- Status Upload  -->
            </div>
            <!-- Widget Area -->





      <%--<div id="setup-wrapper">--%>

      <%--<h3>Setting Up Your Image Gallery<h3>--%>

      <%--<p>This image gallery plugin was designed for maximum compatibility with a wide array of layouts. As such, adherence to naming conventions is essential for making sure each component of the gallery works properly. This allows for more freedom in placing the various components of the gallery on the page, but also means that if naming conventions are not followed portions of the interface may not work properly. This may require a bit more work up front to get the gallery up and running, but will also impart a great deal of versatility when integrating the plugin to a new page or design.</p>--%>

      <%--<p>To name each component, choose an Id for your image gallery. Inside this div should be each of the thumbnails for the images in your gallery. For this example, we'll simply call the div 'gallery'.</p>--%>

      <%--<pre><code>&lt;div id="gallery"&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image1.jpg" alt="First thumbnail" /&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image2.jpg" alt="Second thumbnail" /&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image3.jpg" alt="Third thumbnail" /&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image4.jpg" alt="Fourth thumbnail" /&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image5.jpg" alt="Fifth thumbnail" /&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image6.jpg" alt="Sixth thumbnail" /&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image7.jpg" alt="Seventh thumbnail" /&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--</code></pre>--%>

      <%--<p>There are a few things to notice here. Firstly, the thumbnails images are located within the <em>thumbs</em> folder, which is located within the <em>gallery</em> folder on the server. The full size images in this example would be located within the <em>gallery</em> folder. The two most important takeaways here are thus: the thumbnails should be in a folder named <em>thumbs</em>, and the <em>thumbs</em> folder should be located in the same folder as the full size images. Lastly, each thumbnail image should have the same name and file extension as it's full size counterpart, so image1.jpg in the <em>thumbs</em> folder would have a matching full size image1.jpg in the <em>gallery</em> directory.</p>--%>

      <%--<p>Sometimes you might not want to use a static size for your thumbnails, if you want your thumbnails to maintain the aspect ratio of the image, for instance. The plugin requires a fixed size for the thumbnails in order to properly set the height and width of the thumbnail portion of the gallery, but you can get around this by nesting each image in a div and styling the thumbnail divs to be a particular size.</p>--%>

      <%--<pre><code>.thumbnail {--%>
      <%--height: 100px;--%>
      <%--width: 100px;--%>
      <%--}--%>

      <%--&lt;div id="gallery"&gt;--%>
      <%--&lt;div class=".thumbnail"&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image1.jpg" alt="First thumbnail" /&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--&lt;div class=".thumbnail"&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image2.jpg" alt="Second thumbnail" /&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--&lt;div class=".thumbnail"&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image3.jpg" alt="Third thumbnail" /&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--&lt;div class=".thumbnail"&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image4.jpg" alt="Fourth thumbnail" /&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--&lt;div class=".thumbnail"&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image5.jpg" alt="Fifth thumbnail" /&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--&lt;div class=".thumbnail"&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image6.jpg" alt="Sixth thumbnail" /&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--&lt;div class=".thumbnail"&gt;--%>
      <%--&lt;img src="images/gallery/thumbs/image7.jpg" alt="Seventh thumbnail" /&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--</code></pre>--%>

      <%--<p>This is quite handy, as this structure will allow the plugin to automagically center the image within the boundaries of the thumbnail divs.</p>--%>

      <%--<p>Now that we have our gallery in place, we can set up the other components of the image gallery. There are six other components to the image gallery: the gallery position indicator, gallery next button, gallery previous button, image viewer, image viewer next button, and image viewer previous button. To derive the proper ID name each component should have to work with the plugin, add the following suffix to the ID of each respective gallery component: -pos, -next, -prev, -viewer, -viewer-next, -viewer-prev. So with our example ID of <em>gallery</em>, we would derive the following IDs...</p>--%>

      <%--<p class="gallery-labels">gallery-pos<br/>--%>
      <%--gallery-next<br/>--%>
      <%--gallery-prev<br/>--%>
      <%--gallery-viewer<br/>--%>
      <%--gallery-viewer-next<br/>--%>
      <%--gallery-viewer-prev</p>--%>

      <%--<p>Once you've labeled the IDs of each component, you're free to place them anywhere on the page. Anywhere, that is, but within the <em>gallery</em> div, whose only child elements should be a list of thumbnails. Here is an example set up for the other components:</p>--%>

      <%--<pre><code>&lt;div id="viewer-wrapper"&gt;--%>
      <%--&lt;div id="gallery-viewer"&gt;--%>
      <%--&lt;img alt="Placeholder" src="images/placeholder.png"&gt;--%>
      <%--&lt;/div&gt;&lt;!-- #gallery-viewer --&gt;--%>
      <%--&lt;div id="viewer-nav"&gt;--%>
      <%--&lt;a id="gallery-viewer-next" href="#"&gt;next&lt;/a&gt;--%>
      <%--&lt;a id="gallery-viewer-prev" href="#"&gt;previous&lt;/a&gt;--%>
      <%--&lt;/div&gt;&lt;!-- #viewer-nav --&gt;--%>
      <%--&lt;/div&gt;&lt;!-- #viewer-wrapper" --&gt;--%>

      <%--&lt;div id="thumbs-nav"&gt;--%>
      <%--&lt;a id="gallery-next" href="#"&gt;next&lt;/a&gt;--%>
      <%--&lt;a id="gallery-prev" href="#"&gt;previous&lt;/a&gt;--%>
      <%--&lt;p id="gallery-pos"&gt;page 1 of 2&lt;/p&gt;--%>
      <%--&lt;/div&gt;--%>
      <%--</code></pre>--%>

      <%--<p>You may notice that I've placed a placeholder image in the viewer for initial loading. This is completely optional, but a nice red flag that something's gone wrong with the plugin. If everything is set up properly, the plugin will automatically place the first thumbnail in the viewer on load. So as long as everything is set up properly, you'll likely never see any image that is hard coded into the DOM.</p>--%>

      <%--<p>Now that we have each component labeled properly, it's just a matter of calling the .gallery() method on the base <em>gallery</em> div.</p>--%>

      <%--<pre><code>$('#gallery').gallery();--%>
      <%--</code></pre>--%>

      <%--<p>There are multiple options available for perusal at the bottom of this page, but the most notable of them is the ability to customize the number of thumbnails visible in the gallery.</p>--%>

      <%--<pre><code>$('#gallery').gallery({--%>
      <%--'rows':3,--%>
      <%--'cols':5--%>
      <%--});--%>
      <%--</code></pre>--%>

      <%--<p>This sets up a 3x5 grid of thumbnails in the gallery. The plugin will then read your page styling and image sizes to determine the size the thumbnail area will need to be to show the proper number of thumbnails and avoid clipping. The default size of the gallery is 1x5.</p>--%>

      <%--<h3>Dependencies</h3>--%>

      <%--<p>Image Gallery is a <a href="http://jquery.com/">jQuery</a> plugin, and uses the <a href="https://github.com/desandro/imagesloaded">ImagesLoaded</a> plugin to accurately determine when an image is loaded across all browsers and situations.</p>--%>

      <%--<h3>Further Customization</h3>--%>

      <%--<p>The gallery() function will take an options object for further customization.</p>--%>

      <%--<dl>--%>
      <%--<dt>duration</dt>--%>
      <%--<dd><em>default: 400</em><br/>The animation durations.</dd>--%>

      <%--<dt>easing</dt>--%>
      <%--<dd><em>default: 'swing'</em><br/>The type of easing to use for animations.</dd>--%>

      <%--<dt>rows</dt>--%>
      <%--<dd><em>default: 1</em><br/>The number of thumbnail rows to display.</dd>--%>

      <%--<dt>cols</dt>--%>
      <%--<dd><em>default: 5</em><br/>The number of thumbnail columns to display.</dd>--%>
      <%--</dl>--%>

      <%--</div><!-- #setup-wrapper -->--%>

      <%--</div><!-- #content -->--%>

      <%--&lt;%&ndash;</div><!-- #wrapper -->&ndash;%&gt;//////////////////////////////////////////////////////////////////////////////////////////////////--%>

      <!-- javascript -->
      <%--<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>--%>
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

