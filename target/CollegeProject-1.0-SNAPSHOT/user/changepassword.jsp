<%--
  Created by IntelliJ IDEA.
  User: Jiwan
  Date: 4/6/2023
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            width: 50%;
            margin: auto;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.3);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-input {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: none;
            box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.3);
        }

        .form-button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-button:hover {
            background-color: #3e8e41;
        }

    </style>
</head>
<body>
<h1>Change Password</h1>
<form action="User?page=changingpassword" method="post">

    <label for="oldpassword">Old Password:</label>
    <input type="password" id="oldpassword" name="oldpassword"><br><br>
    <label for="newpassword">New Password:</label>
    <input type="password" id="newpassword" name="newpassword"><br><br>
    <input type="submit" value="Change Password">
</form>
</body>
</html>

