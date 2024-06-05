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
                                                <div class="card mb-3">
                                                    <div class="row g-0 p-2">
                                                        <div class="col-md-2">
                                                            <img
                                                                class="img-fluid rounded-start imageSize" alt="White Rope"
                                                                src="https://scontent.fhan2-5.fna.fbcdn.net/v/t39.30808-6/358030857_1325462848390539_5680874619739816900_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHC6NhIySUq7WqJL9Q1HASEezKSm5jX9Sx7MpKbmNf1LM3Kfz8DIKkNpnWrXUtFH6n14WKqpfqoJhhS2kt-2ptu&_nc_ohc=pR9_64G7w88Q7kNvgGnMYsV&_nc_ht=scontent.fhan2-5.fna&oh=00_AYCQ91mx3V0T9f_xs_SqcXYlylM5uLvlbmbq-dwk3a54Nw&oe=66664F0B" >
                                                        </div>
                                                        <div class="col-md-10">
                                                            <div class="card-body">
                                                                <h5 class="card-title">Dây Giày Dù Nhiều Màu Sặc 80cm / 100cm / 120cm</h5>
                                                                <p class="card-text">Classification of goods: White 100cm</p>
                                                                <p class="card-text">x1</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row p-lg-1"> 
                                                        <div class="col-md-8 offset-md-3"> 
                                                            <div class="d-flex justify-content-between align-items-center">
                                                                <div></div>
                                                                <div class="text-right">
                                                                    <div class="text-danger font-weight-bold price-label">&#9829; Payment: $14.157</div>
                                                                    <div class="btn-group">
                                                                        <button class="btn btn-danger">Buy Again</button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
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
