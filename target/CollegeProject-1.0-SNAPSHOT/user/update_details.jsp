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
  <input type="hidden" name="id" value="${student.id}">
  <label for="name">Name:</label>
  <input type="text" id="name" name="uname" value="${student.userName}">
  <br>
  <label for="email">Email:</label>
  <input type="email" id="email" name="uemail" value="${student.email}">
  <br>
  <label for="dob">Date of Birth:</label>
  <input type="date" id="dob" name="dob" value="${student.DOB}">
  <br>
  <br>
  <label for="mobilenumber">Mobile Number:</label>
  <input type="text" id="mobilenumber" name="mobilenumber" value="${student.mobile_Number}">
  <br>
  <br>
  <label>Gender</label>
  <select name="gender"  required>
    <option>Select gender</option>
    <option>Male</option>
    <option>Female</option>
    <option>Others</option>
  </select>
  <br>
  <label for="occupation">Occupation:</label>
  <input type="text" id="occupation" name="occupation" value="${student.occupation}">
  <br>
  <label for="idtype">ID Type:</label>
  <input type="text" id="idtype" name="ID" value="${student.id_Type}">
  <br>
  <label for="idnumber">ID Number:</label>
  <input type="text" id="idnumber" name="IDno" value="${student.id_number}">
  <br>
  <label for="authority">Authority:</label>
  <input type="text" id="authority" name="Auth" value="${student.authority}">
  <br>
  <label for="state">State:</label>
  <input type="text" id="state" name="Istate" value="${student.state}">
  <br>
  <label for="date">Date:</label>
  <input type="date" id="date" name="Idate" value="${student.date}">
  <br>
  <label for="plateno">Plate No:</label>
  <input type="text" id="plateno" name="Pno" value="${student.plate_No}">
  <br>
  <label for="manufacturer">Manufacturer:</label>
  <input type="text" id="manufacturer" name="Man" value="${student.manufacturer}">
  <br>
  <label for="motordmg">Motor Damage:</label>
  <input type="text" id="motordmg" name="Mdmg" value="${student.motor_Dmg}">
  <br>
  <label for="plan">Plan:</label>
  <input type="text" id="plan" name="Plan" value="${student.plan}">
  <br>
  <label for="vperiod">Validity Period:</label>
  <input type="text" id="vperiod" name="Vperiod" value="${student.validityPeriod}">

  <label for="evalue">E-Value:</label>
  <input type="text" id="evalue" name="Evalue" value="${student.evalue}">
  <br>
  <button type="submit">Update</button>
</form>

</body>
</html>

