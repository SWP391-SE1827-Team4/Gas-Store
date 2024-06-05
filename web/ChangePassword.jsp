<%-- 
    Document   : ChangePassword
    Created on : May 28, 2024, 8:47:56 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/profile.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <div class="container light-style flex-grow-1 container-p-y">
            <h4 class="font-weight-bold py-3 mb-4">
                Account settings
            </h4>   
            <form action="changePassword" method="post">
                <div class="card overflow-hidden">
                    <div class="row no-gutters row-bordered row-border-light">
                        <%@include file="_subMenu.jsp" %>
                        <div class="col-md-9">
                            <div class="tab-content">
                                <div class="tab-pane fade active show" id="account-change-password">
                                    <div class="card-body pb-2">
                                        <h3>${mess}</h3>
                                        <div class="form-group">
                                            <label class="form-label">Current password</label>
                                            <input type="password" name="currentPassword" required class="form-control" 
                                                  pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{8,}$"
                                                   title="Password must have at least 8 characters, including upper and lower case letters and numbers" />
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">New password</label>
                                            <input type="password" name="newPassword" id="newPassword" 
                                                   pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{8,}$"
                                                   title="Password must have at least 8 characters, including upper and lower case letters and numbers"
                                                   required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Repeat new password</label>
                                            <input type="password" required name="repeatPassword"
                                                   pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{8,}$"
                                                   title="Password must have at least 8 characters, including upper and lower case letters and numbers"
                                                   id="repeatPassword" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <script type="text/javascript">
                                    var form = document.querySelector('form');
                                    var newPasswordInput = document.getElementById('newPassword');
                                    var repeatPasswordInput = document.getElementById('repeatPassword');

                                    form.addEventListener('submit', function (event) {
                                        if (newPasswordInput.value !== repeatPasswordInput.value) {
                                            alert('New password and repeat password do not match!');
                                            event.preventDefault(); // Ngăn chặn form submit
                                        }
                                    });
                                </script>
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
