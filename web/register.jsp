
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .container-login100 {
  width: 100%;  
  min-height: 100vh;
  display: -webkit-box;
  display: -webkit-flex;
  display: -moz-box;
  display: -ms-flexbox;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  padding: 15px;
  background: #9053c7;
  background: -webkit-linear-gradient(-135deg, #c850c0, #4158d0);
  background: -o-linear-gradient(-135deg, #c850c0, #4158d0);
  background: -moz-linear-gradient(-135deg, #c850c0, #4158d0);
  background: linear-gradient(-135deg, #c850c0, #4158d0);
}
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
    <title>Đăng ký tài khoản</title>
</head>
<body class="container-login100">
    <form action="register" method="post">

  <label>Tên của bạn:</label>
    <input type="text" name="customerName" required><br>
    Giới Tính:
    <select name="Gender">
         <option value="nam">Male</option>
         <option value="nữ">Female </option>
    </select>
       <br/>
        <br/>
    <label >Email:</label>
    <input type="text" name="email" required><br>
    <label >Phone:</label>
    <input type="text" name="phone" required><br>
      <label >Address:</label>
    <input type="text" name="address" required><br>
     <label >Password:</label>
    <input type="text" name="pass" required><br>
      
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    <input type="submit" value="" name="submit" />
   
</form>
</body>
</body>
</html>
