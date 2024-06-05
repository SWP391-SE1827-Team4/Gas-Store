<%-- 
    Document   : _subMenu
    Created on : Jun 3, 2024, 8:56:34 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-3 pt-0">
            <div class="list-group list-group-flush account-settings-links">
                <a class="list-group-item list-group-item-action ${requestScope.menu == 'general'? 'active': ''}" 
                   href="Profile">General</a>
                <a class="list-group-item list-group-item-action ${requestScope.menu == 'pass'? 'active': ''}"  
                   href="changePassword">Change password</a>
                <a class="list-group-item list-group-item-action ${requestScope.menu == 'HistoryOrders'? 'active': ''}"  
                   href="HistoryOrders">History Orders</a>
            </div>
        </div>
    </body>
</html>
