<%-- 
    Document   : insertProduct
    Created on : Apr 16, 2024, 3:06:00 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.User_Account" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employees</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
            <c:set var="c" value="${requestScope.customer}" />
            <form action="updateC" method="post">
                <div class="form-group">
                    <label for="UserID">UserID</label>
                    <input type="text" class="form-control" id="UserID" name="UserID" readonly value="${c.getUser_ID()}">
                </div>
                <div class="form-group">
                    <label for="UserName">UserName</label>
                    <input type="text" class="form-control" id="UserName" name="UserName" value="${c.getUser_Name()}">
                </div>
                <div class="form-group">
                    <label for="UserPassword">UserPassword</label>
                    <input type="password" class="form-control" id="UserPassword" name="UserPassword" value="${c.getUser_Password()}">
                </div>
                <div class="form-group">
                    <label for="UserEmail">UserEmail</label>
                    <input type="email" class="form-control" id="UserEmail" name="UserEmail" value="${c.getUser_Email()}">
                </div>
                <div class="form-group">
                    <label for="UserPhoneNum">UserPhoneNum</label>
                    <input type="tel" class="form-control" id="UserPhoneNum" name="UserPhoneNum" value="${c.getUser_PhoneNum()}">
                </div>
                <div class="form-group">
                    <label for="UserAddress">UserAddress</label>
                    <input type="text" class="form-control" id="UserAddress" name="UserAddress" value="${c.getUser_Address()}">
                </div>
                <div class="form-group">
                    <label for="UserGender">UserGender</label>
                    <input type="text" class="form-control" id="UserGender" name="UserGender" value="${c.getUser_Gender()}">
                </div>

                <div class="form-group">
                    <label for="UpdatedAt">Updated At</label>
                    <input type="datetime-local" class="form-control" id="UpdatedAt" name="UpdatedAt" value="${c.getUpdated_At()}">
                </div>
                <div class="form-group">
                    <label for="IsCustomer">IsCustomer</label>
                    <select class="form-control" id="IsCustomer" name="IsCustomer">
                        <option value="1" ${c.isIsCustomer() ? 'selected' : ''}>Yes</option>
                        <option value="0" ${!c.isIsCustomer() ? 'selected' : ''}>No</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="IsCustomer">IsGuest</label>
                    <select class="form-control" id="isGuest" name="IsGuest">
                        <option value="1" ${c.isIsGuest() ? 'selected' : ''}>Yes</option>
                        <option value="0" ${!c.isIsGuest() ? 'selected' : ''}>No</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary btn-block" name="Submit">Update Customer</button>
                <button type="reset" class="btn btn-secondary btn-block">Reset</button>
                <input type="hidden" name="service" value="updateUser">

            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
