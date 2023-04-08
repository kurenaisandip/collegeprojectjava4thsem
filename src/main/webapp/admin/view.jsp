<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
</head>
<body>
<h1>List of Students</h1>

<form method="post" action="admin?action=sorting">
    Sort by:
    <select name="sort">
        <option value="id">ID</option>
        <option value="userName">Full Name</option>
        <option value="email">Email</option>

    </select>
    <button type="submit">Sort</button>
</form>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>User Name</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.userName}</td>
            <td>${student.email}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
