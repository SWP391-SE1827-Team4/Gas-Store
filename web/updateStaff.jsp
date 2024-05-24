<%-- 
    Document   : insertProduct
    Created on : Apr 16, 2024, 3:06:00 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet,java.util.Vector,model.Staff,java.util.List"%>
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
            <h2>Update Employees</h2>
            <c:set var="staff" value="${requestScope.staff}" />
            <form action="updateS" method="post">

                <div class="form-group">
                    <label for="updateS">Staff ID</label>
                    <input type="text" class="form-control" id="StaffID" name="StaffID" readonly value="${staff.getManager_ID()}">
                </div>
                <div class="form-group">
                    <label for="StaffEmail">Staff Email</label>
                    <input type="email" class="form-control" id="StaffEmail" name="StaffEmail" value="${staff.getManager_Email()}">
                </div>
                <div class="form-group">
                    <label for="StaffPassword">Staff Password</label>
                    <input type="password" class="form-control" id="StaffPassword" name="StaffPassword" value="${staff.getManager_Password()}">
                </div>
                <div class="form-group">
                    <label for="StaffAddress">Staff Address</label>
                    <input type="text" class="form-control" id="StaffAddress" name="StaffAddress" value="${staff.getManager_Address()}">
                </div>
                <div class="form-group">
                    <label for="StaffPhoneNum">Staff Phone Number</label>
                    <input type="tel" class="form-control" id="StaffPhoneNum" name="StaffPhoneNum" value="${staff.getManager_PhoneNum()}">
                </div>
                <div class="form-group">
                    <label for="gender">Staff Gender</label>
                    <input type="text" class="form-control" id="gender" name="gender" value="${staff.getManager_Gender()}">
                </div>
                <div class="form-group">
                    <label for="isAdmin">Is Admin</label>
                    <select class="form-control" id="isAdmin" name="isAdmin">
                        <option value="1" ${staff.isIsAdmin() ? 'selected' : ''}>Yes</option>
                        <option value="0" ${!staff.isIsAdmin() ? 'selected' : ''}>No</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="isStaff">Is Staff</label>
                    <select class="form-control" id="isStaff" name="isStaff">
                        <option value="1" ${staff.isIsStaff() ? 'selected' : ''}>Yes</option>
                        <option value="0" ${!staff.isIsStaff() ? 'selected' : ''}>No</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="UpdatedAt">Updated At</label>
                    <input type="datetime-local" class="form-control" id="UpdatedAt" name="UpdatedAt" value="${staff.getUpdated_At()}">
                </div>
                <button type="submit" class="btn btn-primary btn-block" name="Submit">Update Employees</button>
                <button type="reset" class="btn btn-secondary btn-block">Reset</button>
                <input type="hidden" name="service" value="updateStaff">
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
