<%-- 
    Document   : insertEmployees
    Created on : Apr 25, 2024, 2:08:13 PM
    Author     : xuank
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Insert New Employees</h2>

        <div class="row">
            <div class="col-md">
                <form action="updateProduct" method="post">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="imageUrl">Image URL:</label>
                        <input type="text" class="form-control" id="imageUrl" name="imageUrl" required>
                    </div>
                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="number" class="form-control" id="price" name="price" min="0" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="title">Title:</label>
                        <input type="text" class="form-control" id="title" name="title" required>
                    </div>
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="sellId">Sell ID:</label>
                        <input type="number" class="form-control" id="sellId" name="sellId" min="0" required>
                    </div>
                    <div class="form-group">
                        <label for="categoryId">Category ID:</label>
                        <input type="number" class="form-control" id="categoryId" name="categoryId" min="0" required>
                    </div>
                    <div class="form-group">
                        <label for="status">Status:</label>
                        <select class="form-control" id="status" name="status" required>
                            <option value="1">Active</option>
                            <option value="0">Inactive</option>
                        </select>
                    </div>
                    <button type="submit" name="Submit" class="btn btn-primary">Insert Product</button>
                    <input type="hidden" name="service" value="insertProduct">
                </form>
            </div>
        </div>
    </body>
</html>

