<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sort Names</title>
</head>
<body>
<h1>Sort Names</h1>
<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="name" items="${names}">
        <tr>
            <td>${name.userName}</td>
            <td>${name.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
