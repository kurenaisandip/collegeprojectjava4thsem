<%@ page import="Model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Jiwan
  Date: 4/6/2023
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
<h1>Search Results</h1>

<% if(request.getAttribute("searchResults") != null) {
    List<Student> searchResults = (List<Student>) request.getAttribute("searchResults");
    if(searchResults.isEmpty()) { %>
<p>No results found for your search query.</p>
<% } else { %>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Occupation</th>
    </tr>
    <% for(Student student : searchResults) { %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getUserName() %></td>
        <td><%= student.getEmail() %></td>
        <td><%= student.getGender() %></td>
        <td><%= student.getOccupation() %></td>
    </tr>
    <% } %>
</table>
<% }
} else { %>
<p>Please enter a search query to see results.</p>
<% } %>

</body>
</html>

