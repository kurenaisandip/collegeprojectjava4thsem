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
</table>

</body>
</html>
