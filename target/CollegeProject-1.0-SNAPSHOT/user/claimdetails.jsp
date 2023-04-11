<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Claim Details</title>
</head>
<body>

<!-- Display the image -->
<img src="data:image/png;base64, ${details.image}" alt="image">

<!-- Display the student details -->
<table>
    <tr>
        <td>Name:</td>
        <td>${details.name}</td>
    </tr>
    <tr>
        <td>Phone Number:</td>
        <td>${details.phone_number}</td>
    </tr>
    <tr>
        <td>Evalue:</td>
        <td>${details.evalue}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${details.email}</td>
    </tr>
    <tr>
        <td>Info:</td>
        <td>${details.info}</td>
    </tr>
    <tr>
<%--        s--%>

    <%--        <td>Download File:${details.image}</td>--%>
        <td>Download image:${details.images}</td>
<%--        <td>Download Filepath:${details.filePath}</td>--%>
<%--        <td><a href="User?page=download&id=${details.id}">Download File</a></td>--%>
<%--        <a href="${details.images}" download="file">Download File</a>--%>
<%--        <a href="User?page=download&path=${details.images}">Download Image</a>--%>
        <a href="file:///${details.images}">Download Image</a>



    </tr>
</table>

</body>
</html>
