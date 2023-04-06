<%--
  Created by IntelliJ IDEA.
  User: Jiwan
  Date: 4/6/2023
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Policy_details</title>
  <style>
    form {
      max-width: 600px;
      margin: 0 auto;
      padding: 20px;
      background-color: #f2f2f2;
      border-radius: 5px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }

    label {
      display: block;
      margin-bottom: 10px;
      font-weight: bold;
      color: #555;
    }

    input[type="text"],
    input[type="email"],
    input[type="date"],
    input[type="tel"] {
      display: block;
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-sizing: border-box;
      margin-bottom: 20px;
      font-size: 16px;
      color: #333;
    }

    button[type="submit"] {
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
    }

    button[type="submit"]:hover {
      background-color: #3e8e41;
    }

    button[type="submit"]:focus {
      outline: none;
    }

  </style>
</head>

<body>
<form method="post" action="User?page=finaledit">
  <input type="hidden" name="policyId" value="${student.id}">
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" value="${student.email}">
  <br>
  <label for="dob">Date of Birth:</label>
  <input type="date" id="dob" name="dob" value="${student.DOB}">
  <br>
  <label for="idtype">ID Type:</label>
  <input type="text" id="idtype" name="idtype" value="${student.id_Type}">
  <br>
  <label for="idnumber">ID Number:</label>
  <input type="text" id="idnumber" name="idnumber" value="${student.id_number}">
  <br>
  <label for="authority">Authority:</label>
  <input type="text" id="authority" name="authority" value="${student.authority}">
  <br>
  <label for="state">State:</label>
  <input type="text" id="state" name="state" value="${student.state}">
  <br>
  <label for="date">Date:</label>
  <input type="date" id="date" name="date" value="${student.date}">
  <br>
  <label for="plateno">Plate No:</label>
  <input type="text" id="plateno" name="plateno" value="${student.plate_No}">
  <br>
  <label for="manufacturer">Manufacturer:</label>
  <input type="text" id="manufacturer" name="manufacturer" value="${student.manufacturer}">
  <br>
  <label for="motordmg">Motor Damage:</label>
  <input type="text" id="motordmg" name="motordmg" value="${student.motor_Dmg}">
  <br>
  <label for="plan">Plan:</label>
  <input type="text" id="plan" name="plan" value="${student.plan}">
  <br>
  <label for="vperiod">Validity Period:</label>
  <input type="text" id="vperiod" name="vperiod" value="${student.validityPeriod}">
  <br>
  <label for="mobilenumber">Mobile Number:</label>
  <input type="tel" id="mobilenumber" name="mobilenumber" value="${student.mobile_Number}">
  <br>
  <label for="evalue">E-Value:</label>
  <input type="text" id="evalue" name="evalue" value="${student.evalue}">
  <br>
  <button type="submit" name="action" value="update">Update</button>
</form>

</body>
</html>

