<%--
  Created by IntelliJ IDEA.
  User: Jiwan
  Date: 4/5/2023
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Claim Your Insurance </title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<form action="User?page=claim" method="post" enctype="multipart/form-data">
    <!-- 2 column grid layout with text inputs for the first and last names -->
    <div class="row mb-4">
        <div class="col">
            <div class="form-outline">
                <label class="form-label" for="form6Example1">First name</label>
                <input type="text" id="form6Example1" class="form-control" name="name"/>

            </div>
        </div>
        <div class="col">
            <div class="form-outline">
                <label class="form-label" for="form6Example2">Last name</label>
                <input type="text" id="form6Example2" class="form-control" />

            </div>
        </div>
    </div>

    <!-- Text input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="form6Example3">Insurance policy</label>
        <input type="text" id="form6Example3" class="form-control" name="Insurance_policy"/>

    </div>

    <!-- Text input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="form6Example4">Address</label>
        <input type="text" id="form6Example4" class="form-control" name="address" />

    </div>

    <!-- Email input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="form6Example5">Email</label>
        <input type="email" id="form6Example5" class="form-control" name="email"/>

    </div>

    <!-- Number input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="form6Example6">Phone</label>
        <input type="number" id="form6Example6" class="form-control" name="phone_number"/>

    </div>

    <!-- Message input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="form6Example7">Additional information</label>
        <textarea class="form-control" id="form6Example7" rows="4" name="info"></textarea>

    </div>

    <div>
        <label for="myFile">File Upload</label>
        <input type="file" id="myFile" name="files">

    </div>


    <!-- Submit button -->
    <button type="submit" class="btn btn-primary btn-block mb-4">Request Claim</button>
</form>

</body>
</html>