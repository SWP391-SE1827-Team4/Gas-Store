<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/profile.css">
        <link rel="stylesheet" href="css/history.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container light-style flex-grow-1 container-p-y">
            <h4 class="font-weight-bold py-3 mb-4">
                Account settings
            </h4>   
            <form action="Profile" method="post" enctype="multipart/form-data">
                <div class="card overflow-hidden">
                    <div class="row no-gutters row-bordered row-border-light">
                        <%@include file="_subMenu.jsp" %>
                        <div class="col-md-9">
                            <div class="tab-content">
                                <div class="tab-pane fade active show" id="account-general">
                                    <!--${sessionScope.user.image}-->
                                    <hr class="border-light m-0">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <c:forEach var="item" items="${requestScope.orders}">
                                                    <div class="card mb-3" onclick="window.location.href = './HistoryOrderDetail?orderId=${item.getId()}'"  >
                                                        <div class="row p-lg-1"> 
                                                            <div class="col-md-8 offset-md-3"> 
                                                                <div class="d-flex justify-content-between align-items-center">
                                                                    <div></div>
                                                                    <div class="text-right">
                                                                        <div class="text-right font-weight-bold price-label"> Status: ${item.getStatus()}</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:forEach var="itemSub" items="${item.orderDetails}">
                                                            <div class="row g-0 p-2">
                                                                <div class="col-md-2">
                                                                    <img
                                                                        class="img-fluid rounded-start imageSize" alt="Img not found"
                                                                        src="${itemSub.getProduct().getImage_url()}"
                                                                        >
                                                                </div>
                                                                <div class="col-md-10">
                                                                    <div class="card-body">
                                                                        <h5 class="card-title">
                                                                            <a><a href="#">${itemSub.getProduct().getName()}</a>
                                                                        </h5>
                                                                        <p class="card-text">${itemSub.getProduct().getDescription()}</p>

                                                                        <p class="card-text">Price: <fmt:formatNumber value="${itemSub.getProduct().getPrice()}" type="currency" currencySymbol="&#8363;" /></p>

                                                                        <p class="card-text">x${itemSub.getProduct_quantity()}</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:forEach>

                                                        <div class="row p-lg-1"> 
                                                            <div class="col-md-8 offset-md-3"> 
                                                                <div class="d-flex justify-content-between align-items-center">
                                                                    <div></div>
                                                                    <div class="text-right">
                                                                        <div class="text-danger font-weight-bold price-label">&#9829; Payment: <fmt:formatNumber value="${item.getTotalPrice()}" type="currency" currencySymbol="&#8363;" /> </div>
                                                                        <div class="btn-group">
                                                                            <button class="btn btn-danger">Buy Again</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-right mt-3">
                    <button type="submit" class="btn btn-primary">Save changes</button>&nbsp;
                </div>
            </form>

        </div>
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>
