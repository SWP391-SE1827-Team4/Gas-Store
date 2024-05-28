<%-- 
    Document   : profile
    Created on : May 28, 2024, 12:01:51 AM
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
            <form action="Profile" method="post" enctype="multipart/form-data">
                <div class="card overflow-hidden">
                    <div class="row no-gutters row-bordered row-border-light">
                        <div class="col-md-3 pt-0">
                            <div class="list-group list-group-flush account-settings-links">
                                <a class="list-group-item list-group-item-action active" 
                                   href="#account-general">General</a>
                                <a class="list-group-item list-group-item-action"  
                                   href="changePassword">Change password</a>
                                <!--                        <a class="list-group-item list-group-item-action" data-toggle="list"
                                                            href="#account-info">Info</a>-->
                                <!--                        <a class="list-group-item list-group-item-action" data-toggle="list"
                                                            href="#account-social-links">Social links</a>
                                                        <a class="list-group-item list-group-item-action" data-toggle="list"
                                                            href="#account-connections">Connections</a>
                                                        <a class="list-group-item list-group-item-action" data-toggle="list"
                                                            href="#account-notifications">Notifications</a>-->
                            </div>
                        </div>
                        <div class="col-md-9">
                            <div class="tab-content">
                                <div class="tab-pane fade active show" id="account-general">
                                    <div class="card-body media align-items-center">
                                        <img id="preview" src="data:image/jpeg;base64,${sessionScope.user.image}" alt
                                             class="d-block ui-w-80">
                                        <div class="media-body ml-4">
                                            <label class="btn btn-outline-primary">
                                                Upload new photo
                                                <input id="fileInputImage" type="file" accept="image/*" name="imageUser" class="account-settings-fileinput" ">
                                            </label> &nbsp;
                                            <!--<button type="button" class="btn btn-default md-btn-flat">Reset</button>-->
                                            <div class="text-light small mt-1">Allowed JPG, GIF or PNG. Max size of 800K</div>
                                        </div>
                                        <script>
                                            const fileInput = document.getElementById('fileInputImage');
                                            const previewImg = document.getElementById('preview');

                                            fileInput.addEventListener('change', function () {
                                                const file = this.files[0];
                                                if (file) {
                                                    const fileType = file.type;
                                                    const validImageTypes = ['image/jpeg', 'image/png', 'image/gif'];
                                                    if (!validImageTypes.includes(fileType)) {
                                                        alert('Please select an image file (JPEG, PNG, or GIF).');
                                                        fileInputImage.value = ''
                                                        return;
                                                    }
                                                    
                                                    const reader = new FileReader();
                                                    reader.addEventListener('load', function () {
                                                        previewImg.src = reader.result;
                                                    });
                                                    reader.readAsDataURL(file);
                                                }
                                            });
                                        </script>
                                    </div>
                                    <hr class="border-light m-0">
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label class="form-label">E-mail</label>
                                            <input type="text" class="form-control mb-1" readonly value="${sessionScope.user.email}">
                                            <!--                                    <div class="alert alert-warning mt-3">
                                                                                    Your email is not confirmed. Please check your inbox.<br>
                                                                                    <a href="javascript:void(0)">Resend confirmation</a>
                                                                                </div>-->
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Username</label>
                                            <input type="text" readonly class="form-control mb-1" value="${sessionScope.user.username}">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Name</label>
                                            <input type="text" name="fullname" class="form-control" required value="${sessionScope.user.fullname}">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Phone</label>
                                            <input type="text" name="phone" class="form-control" required value="${sessionScope.user.phone}">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Address</label>
                                            <input type="text" class="form-control" name="address" required value="${sessionScope.user.address}">
                                        </div>
                                        <!--                                <div class="form-group">
                                                                            <label class="form-label">Company</label>
                                                                            <input type="text" class="form-control" value="Company Ltd.">
                                                                        </div>-->
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="account-change-password">
                                    <div class="card-body pb-2">
                                        <div class="form-group">
                                            <label class="form-label">Current password</label>
                                            <input type="password" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">New password</label>
                                            <input type="password" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Repeat new password</label>
                                            <input type="password" class="form-control">
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
