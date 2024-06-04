<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <link rel="stylesheet" type="text/css" href="css/utilLogin.css">
        <link rel="stylesheet" type="text/css" href="css/mainLogin.css">
        <title>Forgot Password</title>
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-pic js-tilt" data-tilt>
                        <img src="images/img-01.png" alt="IMG">
                    </div>

                    <form class="login100-form validate-form" action="forgot" method="post">
                        <span class="login100-form-title">
                            Forgot Password
                        </span>
                        <c:if test="${not empty sessionScope.mess}">
                            <div style="color:red">${sessionScope.mess}</div>
                        </c:if>
                        <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
                            <input class="input100" type="email" name="email" placeholder="Email" required="">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                            </span>
                        </div>

                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn" type="submit">
                                Reset Password
                            </button>
                        </div>

                        <div class="text-center p-t-12">
                            <a class="txt2" href="login.jsp">
                                <i class="fa fa-long-arrow-left m-l-5" aria-hidden="true"></i>
                                Back to Login
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/tilt/tilt.jquery.min.js"></script>
        <script>
            $('.js-tilt').tilt({
                scale: 1.1
            });
        </script>
        <script src="js/mainLogin.js"></script>
    </body>
</html>
