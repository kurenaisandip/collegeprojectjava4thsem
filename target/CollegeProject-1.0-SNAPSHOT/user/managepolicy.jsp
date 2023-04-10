<%--
  Created by IntelliJ IDEA.
  User: Jiwan
  Date: 4/6/2023
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manage Policy</title>

    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #6699cc;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a.button {
            background-color: #6699cc;
            color: white;
            padding: 6px 12px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 4px;
            border: none;
        }

        a:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>

<div class="table">
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Plan Period</th>
            <th>Value</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach items="${policyList}" var="student" varStatus="status">
            <tr>
<%--                <td>${status.count}</td>--%>
                <td>${student.id}</td>
                <td>${student.userName}</td>
                <td>${student.email}</td>
                <td>${student.mobile_Number}</td>
                <td>${student.validityPeriod}</td>
                <td>${student.evalue}</td>

                <td><a href="User?page=policyDetails&id=${student.id}">View Details</a></td>
                <td><a href="User?page=showimage&id=${student.id}">Show Image</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>

</body>
</html>



















<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Jiwan--%>
<%--  Date: 4/6/2023--%>
<%--  Time: 12:50 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Manage Policy</title>--%>

<%--  <style>--%>
<%--    table {--%>
<%--      border-collapse: collapse;--%>
<%--      width: 100%;--%>
<%--    }--%>

<%--    th, td {--%>
<%--      text-align: left;--%>
<%--      padding: 8px;--%>
<%--    }--%>

<%--    th {--%>
<%--      background-color: #6699cc;--%>
<%--      color: white;--%>
<%--    }--%>

<%--    tr:nth-child(even) {--%>
<%--      background-color: #f2f2f2;--%>
<%--    }--%>

<%--    a.button {--%>
<%--      background-color: #6699cc;--%>
<%--      color: white;--%>
<%--      padding: 6px 12px;--%>
<%--      text-align: center;--%>
<%--      text-decoration: none;--%>
<%--      display: inline-block;--%>
<%--      border-radius: 4px;--%>
<%--      border: none;--%>
<%--    }--%>

<%--    a:hover {--%>
<%--      text-decoration: underline;--%>
<%--    }--%>

<%--  </style>--%>
<%--</head>--%>
<%--<body>--%>



<%--<div class="table">--%>
<%--  <table>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--      <th>id</th>--%>
<%--      <th>Username</th>--%>
<%--      <th>Email</th>--%>
<%--      <th>Phone Number</th>--%>
<%--      <th>Plan Period</th>--%>
<%--      <th>Value</th>--%>
<%--      <th>Action</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--&lt;%&ndash;    ${email}&ndash;%&gt;--%>
<%--    <tbody>--%>

<%--    <c:forEach items="${policyList}" var="student">--%>
<%--      <tr>--%>

<%--        <td>${student.id}</td>--%>
<%--        <td>${student.userName}</td>--%>
<%--        <td><${student.email}</td>--%>
<%--        <td>${student.mobile_Number}<td>--%>
<%--        <td>${student.validityPeriod}<td>--%>
<%--        <td>${student.evalue}"</td>--%>

<%--        <td><a href="User?page=policyDetails&id=${student.id}">View Details</a></td>--%>
<%--      </tr>--%>
<%--    </c:forEach>--%>

<%--    </tr>--%>
<%--    </tbody>--%>
<%--  </table>--%>

<%--</div>--%>


<%--</body>--%>
<%--</html>--%>
