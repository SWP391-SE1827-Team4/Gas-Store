<%-- 
    Document   : Menu
    Created on : Jun 23, 2023, 2:10:57 AM
    Author     : Van Minh Tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Menu</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="Free HTML Templates" name="keywords" />
        <meta content="Free HTML Templates" name="description" />

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon" />

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com" />
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
            rel="stylesheet"
            />

        <!-- Font Awesome -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
            rel="stylesheet"
            />

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet" />
        <style>
    .form-group {
        margin-bottom: 10px;
    }
</style>
    </head>

    <body>

        <div class="col-lg-3 col-md-12">
            <!-- Price Start -->
            <div class="border-bottom mb-4 pb-4">
                <h5 class="font-weight-semi-bold mb-4">Filter by price</h5>
                <form action="home" method="post">
                    

<form action="your_action_url" method="post">
   
    <div class="form-group">
       Tìm :  <input type="text" name="key2" id="price-all" placeholder="Nhập từ khóa"/>
    </div>
    <div class="form-group">
        Từ giá:
        <input type="number" name="fromprice"/><br/> 
    </div>
    <div class="form-group">
        Đến giá:
        <input type="number" name="toprice"/><br/> 
    </div>
    <div class="form-group">
        <input type="submit" value="SEARCH"/><br/> 
    </div>
</form>

               <form >
                    
                </form>
            </div>
            <!-- Brand End -->
        </div>
        <!-- Shop Sidebar End -->

       


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>
</html>
