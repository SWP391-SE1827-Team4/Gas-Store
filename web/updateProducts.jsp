<%-- 
    Document   : insertProduct
    Created on : Apr 16, 2024, 3:06:00 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employees</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
        <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
        <script>

            function previewImage(url) {
                var img = document.getElementById("thumbimage");
                img.onload = function () {
                    img.style.display = "inline";
                }
                img.onerror = function () {
                    alert("Invalid image URL");
                    img.style.display = "none";
                }
                img.src = url;
            }

            function readURL(input, thumbimage) {
                if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#thumbimage").attr('src', e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                } else { // Sử dụng cho IE
                    $("#thumbimage").attr('src', input.value);
                }
                $("#thumbimage").show();
                $('.filename').text($("#uploadfile").val());
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'default');
                $(".removeimg").show();
                $(".Choicefile").unbind('click');
            }
            $(document).ready(function () {
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();
                });
                $(".removeimg").click(function () {
                    $("#thumbimage").attr('src', '').hide();
                    $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                    $(".removeimg").hide();
                    $(".Choicefile").bind('click', function () {
                        $("#uploadfile").click();
                    });
                    $('.Choicefile').css('background', '#14142B');
                    $('.Choicefile').css('cursor', 'pointer');
                    $(".filename").text("");
                });
            })
        </script>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background-color: #f0f2f5;
                margin: 0;
            }
            .form-container {
                background: #fff;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 500px;
                margin: 20px;
            }
            .form-container h2 {
                text-align: center;
                margin-bottom: 20px;
                font-weight: 700;
                color: #343a40;
            }
            .form-group label {
                font-weight: 600;
                color: #495057;
            }
            .btn-primary {
                background-color: #007bff;
                border-color: #007bff;
            }
            .btn-primary:hover {
                background-color: #0056b3;
                border-color: #004085;
            }
        </style>

    </head>
    <body>
        <div class="container form-container">
            <h2>Update Customers</h2>
            <c:set var="p" value="${requestScope.product}" />
            <form action="updateP" method="post">
                <div class="form-group">
                    <label for="ProductID">ProductID</label>
                    <input type="text" class="form-control" id="ProductID" name="ProductID" readonly value="${p.getProductID()}">
                </div>
                <div class="form-group">
                    <label for="category">CategoryID</label>
                    <select class="form-control" id="category" name="category">
                        <c:forEach items="${category}" var="c">
                            <option value="${c.getCategoryID()}" ${p.getCategoryID() == c.getCategoryID() ? 'selected' : ''}">${c.getCategoryName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="ProductSerialNum">ProductSerialNum</label>
                    <input type="text" class="form-control" id="serial" name="serial" value="${p.getSerialProduct_Number()}">
                </div>
                <div class="form-group">
                    <label for="ProductName">ProductName</label>
                    <input type="text" class="form-control" id="name" name="name" value="${p.getProduct_Name()}">
                </div>
                <div class="form-group">
                    <label for="Quantity">Quantity</label>
                    <input type="number" class="form-control" id="Quantity" name="quantity" value="${p.getProduct_Quantity()}">
                </div>
                <div class="form-group">
                    <label for="Price">Price</label>
                    <input type="text" class="form-control" id="Price" name="price" value="${p.getProduct_Price()}">
                </div>
                <div class="form-group">
                    <label for="Description">Description</label>
                    <input type="text" class="form-control" id="description" name="description" value="${p.getProduct_Description()}">
                </div>
                <div class="form-group">
                    <label for="UpdatedAt">Updated At</label>
                    <input type="datetime-local" class="form-control" id="UpdatedAt" name="UpdatedAt" value="${p.getUpdated_At()}">
                </div>
                <div class="form-group">
                    <label class="control-label">Image URL</label>
                    <div id="myfileupload">
                        <input type="text" id="imageUpload" name="ImageUpload" value="${p.getImage()}" onchange="previewImage(this.value);" placeholder="Enter image URL" />
                    </div>
                    <div id="thumbbox">
                        <img height="450" width="400" alt="Thumb image" id="thumbimage" style="display: none" />
                        <a class="removeimg" href="javascript:"></a>
                    </div>
                    <div id="boxchoice">
                        <a href="javascript:" class="Choicefile"><i class="fas fa-cloud-upload-alt"></i> Preview Image</a>
                        <p style="clear:both"></p>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block" name="Submit">Update Product</button>
                <button type="reset" class="btn btn-secondary btn-block">Reset</button>
                <input type="hidden" name="service" value="updateProducts">

            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
