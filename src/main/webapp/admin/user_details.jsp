<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User details</title>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div id="wrapper">

  <%@ include file="../include/nav.jsp"%>

  <div class="container">
    <div class="table-responsive">
      <table class="table">

        <tr>
          <th>id</th>
          <td>${student.id}</td>
        </tr>
        <tr>
          <th>Username</th>
          <td>${student.userName}</td>
        </tr>
        <tr>
          <th>Email</th>
          <td>${student.email}</td>
        </tr>
        <tr>
          <th>Password</th>
          <td>${student.password}</td>
        </tr>
        <tr>
          <td><a href="admin?action=userEdit&id=${student.id}">Edit</a></td>
          <td><a href="admin?action=deleteUser&id=${student.id}">Delete</a></td>
        </tr>
      </table>
    </div>
  </div>
</div>

</body>
</html>