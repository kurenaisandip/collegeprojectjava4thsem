<%--
  Created by IntelliJ IDEA.
  User: Jiwan
  Date: 4/7/2023
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <title>Forgot Password</title>
  <style>
    body {
      background-color: #f2f2f2;
    }

    .container {
      margin: 50px auto;
      max-width: 500px;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0px 0px 10px #ccc;
    }

    h2 {
      text-align: center;
      color: #333;
      margin-top: 0;
    }

    .form-group {
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin-bottom: 5px;
      color: #666;
      font-weight: bold;
    }

    .form-control {
      width: 100%;
      height: 40px;
      padding: 5px 10px;
      border-radius: 5px;
      border: none;
      background-color: #f2f2f2;
      font-size: 16px;
      color: #333;
    }

    .btn {
      background-color: #333;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      font-size: 16px;
      cursor: pointer;
    }

    .btn:hover {
      background-color: #666;
    }

  </style>
</head>
<body>
<div class="container">
  <h2>Forgot Password</h2>
  <form action="#" method="post">
    <div class="form-group">
      <label>Email Address</label>
      <input type="email" name="email" class="form-control" placeholder="Enter Email Address">
    </div>
    <div class="form-group">
      <input type="submit" name="submit" value="Submit" class="btn">
    </div>
  </form>
</div>
</body>
</html>

