
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Panner</title>
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
            .badge {
                padding-left: 9px;
                padding-right: 9px;
                -webkit-border-radius: 9px;
                -moz-border-radius: 9px;
                border-radius: 9px;
            }

            .label-warning[href],
            .badge-warning[href] {
                background-color: #c67605;
            }
            #lblCartCount {
                font-size: 12px;
                background: #ff0000;
                color: #fff;
                padding: 0 5px;
                vertical-align: top;
                margin-left: -10px;
            }
            .bg-primary {
  background-color:orange !important;
}
body {
    margin: 0;
    font-family: "Poppins", sans-serif;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #6f6f6f;
    text-align: left;
    background-color: #fff;
}
.btn-primary {
    color: #212529;
    background-color: #FDBA55;
    border-color: #FDBA55;
}

        /* CSS để làm cho hình ảnh full kích thước */
        img {
            width: 100%;
            height: auto; /* Đảm bảo tỷ lệ khung hình bảo toàn */
            display: block; /* Loại bỏ khoảng trắng dư thừa */
        }
    </style>
       
    </head>

    <body>
        <!-- Topbar Start -->
        <div class="container-fluid">
            <div class="row bg-secondary py-2 px-xl-5">
                <div class="col-lg-6 d-none d-lg-block">
                    <div class="d-inline-flex align-items-center">
                        <span class="text-muted px-2"></span>
                        <a class="text-dark" href="#"></a>
                        <span class="text-muted px-2"></span>
                        <a class="text-dark" href="#"></a>
                        <span class="text-muted px-2"></span>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right">

                    <c:if test="${sessionScope.customer != null}">
                       
                        
                         

                        <span class="text-muted px-2">|</span>
                        <a class="text-dark" href="profile"></a>
                        <a class="text-dark btn btn-primary" href="profile">My Profile</a>
                        <a class="text-dark btn btn-primary" href="logout">Logout</a>
                        <span class="text-muted px-2">|</span>
                    </c:if>

                </div>
            </div>
            <div class="row align-items-center py-3 px-xl-5">
                <div class="col-lg-3 d-none d-lg-block">
                    <a href="customer" class="text-decoration-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold">
                            <span class="text-primary font-weight-bold border px-3 mr-1"
                                  >GasStore</span
                            >
                        </h1>
                    </a>
                </div>

                <div class="col-lg-6 col-6 text-left">
                    <%--<c:if test="${user.role_id != 0}">--%>

                    <form action="home" method="post">
                        <input type="hidden" name="service" value="searchByKeywords"/>
                        <div class="input-group">
                            <input
                                type="text"
                                class="form-control"
                                placeholder="Search for products"
                                name="keywords"
                                
                                />
                            <div class="input-group-append">
                                <button class="search-button btn btn-primary" type="submit">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                                
                    </form>
                    <%--  </c:if>--%>
                </div>
                <!--                
                                
                                    <div class="col-lg-3 col-6 text-right">
                                        <a href="cart?service=showCart" class="btn border">
                                            <i class="fas fa-shopping-cart text-primary"></i>
                                            
                                                int numberProductsInCart = 0;
                                                java.util.Enumeration ens = session.getAttributeNames();
                
                                                            while (ens.hasMoreElements()) {
                
                                                                String id = ens.nextElement().toString();
                
                                                                if (!id.equals("user") && !id.equals("fullname") && !id.equals("numberProductsInCart")) {
                                                                    //numberProductsInCart++;
                                                                    
                                                                    CartItem cartItem = (CartItem) session.getAttribute(id); 
                                                                    Product product = cartItem.getProduct();
                                                                    int quantity = cartItem.getQuantity();
                                                                    numberProductsInCart += quantity;
                                                    }
                                                }
                                                session.setAttribute("numberProductsInCart", numberProductsInCart);
                                           
                                            <span class='badge badge-warning' id='lblCartCount'> ${numberProductsInCart} </span>
                                            <span class="badge">Show Cart</span>
                                        </a>
                                    </div>
                                
                -->
            </div>
        </div>   
        <!-- Topbar End -->

        <!-- Navbar Start -->  <img src="  https://png.pngtree.com/background/20231101/original/pngtree-flame-and-intricate-details-of-a-gas-stove-depicted-in-3d-picture-image_5829418.jpg"
                      alt="Gas Stove Image" 
     >
        <div class="container-fluid">
            <div class="row border-top px-xl-5">
                <div class="col-lg-3 d-none d-lg-block">
                    <a 
                        class="  btn shadow-none d-flex align-items-center justify-content-center bg-primary text-white w-100"
                        data-toggle="collapse"
                        href="#navbar-vertical"
                        style="color:orange;height: 65px; margin-top: -1px; padding: 0 30px"
                        >
                        <h6 class="m-0">Gas World</h6>
                    </a>
                </div>
               
                <div class="col-lg-9">
                    <nav
                        class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0"
                        >
                        <a href="" class="text-decoration-none d-block d-lg-none">
                            <h1 class="m-0 display-5 font-weight-semi-bold">
                                <span class="text-primary font-weight-bold border px-3 mr-1"
                                      >GasShop</span
                                >
                            </h1>
                        </a>
                        <button
                            type="button"
                            class="navbar-toggler"
                            data-toggle="collapse"
                            data-target="#navbarCollapse"
                            >
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div
                            class="collapse navbar-collapse justify-content-between"
                            id="navbarCollapse"
                            >
                            <div class="navbar-nav mr-auto py-0">
                                <a href="customer" class="nav-item nav-link active">Shop</a>
                                <a href="#product" class="nav-item nav-link">Products</a>
                                <a href="#footer" class="nav-item nav-link">Contact</a>
                                <a href="admin" class="nav-item nav-link">Shop Manager</a>
                            </div>
                            <div class="navbar-nav ml-auto py-0">
                                

                            </div>
                        </div>
                    </nav>
                </div>
               
            </div>
        </div>
        <!-- Navbar End -->

        <!-- Page Header Start -->
        <div class="container-fluid bg-secondary mb-5">
            <div
                class="d-flex flex-column align-items-center justify-content-center"
                style="min-height: 300px"
                >
                <h1 class="font-weight-semi-bold text-uppercase mb-3" style="color:blue">
                    Welcome to <a class="m-0" href=""style="color: red">Gas Store </a>
                </h1><br/><br/>
                <div class="d-inline-flex">
                    <p class="m-0"><a href=""style="color: red">Gas Store </a></p>
                    <p class="m-0 px-2">-</p>
                    <p class="m-0">   <p>
                       "Dẫn đầu trong việc cung cấp năng lượng sáng tạo và an toàn cho mọi gia đình, <br/>
                       tạo nên không gian ấm áp và tiện nghi cho cuộc sống hàng ngày."
                    </p><br/></p>
                </div>
            </div>
        </div>
        <!-- Page Header End -->

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
