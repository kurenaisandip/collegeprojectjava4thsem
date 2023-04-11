<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Dashboard:::: User</title>
    <link rel="shortcut icon" type="image/jpg" href="CSS/images/LM.ico" />
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/6f3a65e23d.js" crossorigin="anonymous"></script>
</head>

<body>
<!--welcome face-->
<header>
    <div class="pagehead">
        <div class="headtitles" id="headtitlesfix">
            <div class="one">
                <ul>
                    <li><a href="homepage.html"><img src="CSS/images/LMB.png" id="logo"></a></li>
                </ul>
            </div>
<%--            <div class="two">--%>
<%--                --%>
<%--            </div>--%>
        </div>
    </div>
</header>

<form action="User?page=claim" method="post" enctype="multipart/form-data">
    <!-- 2 column grid layout with text inputs for the first and last names -->
    <div class="row mb-4">
        <input type="hidden" id="policy-start-date" name="buydate">
        <input type="hidden" id="policy-end-date" name="lastdate">
        <div class="col">
            <div class="form-outline">
                <label class="form-label" for="form6Example1">First name</label>
                <input type="text" id="form6Example1" class="form-control" name="name" />

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
        <input type="text" id="form6Example3" class="form-control" name="Insurance_policy" />

    </div>

    <!-- Text input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="form6Example4">Address</label>
        <input type="text" id="form6Example4" class="form-control" name="address" />

    </div>

    <!-- Email input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="form6Example5">Email</label>
        <input type="email" id="form6Example5" class="form-control" name="email" />

    </div>

    <!-- Number input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="form6Example6">Phone</label>
        <input type="number" id="form6Example6" class="form-control" name="phone_number" />

    </div>

    <!-- Message input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="form6Example7">Additional information</label>
        <textarea class="form-control" id="form6Example7" rows="4" name="info"></textarea>

    </div>

    <div >
        <label for="myFile" class>File Upload</label>

        <input type="file" id="myFile" name="files">

    </div>


    <!-- Submit button -->
    <button type="submit" class="btn btn-primary btn-block mb-4">Request Claim</button>
</form>


<script>
    function setPolicyDates() {
        var startDate = new Date();
        var endDate = new Date(startDate);

        // Set the end date to 6 months from the start date
        endDate.setMonth(endDate.getMonth() + 6);

        // Set the start date and end date in the hidden form fields
        document.getElementById("policy-start-date").value = startDate.toISOString().substr(0, 10); // Format: YYYY-MM-DD
        document.getElementById("policy-end-date").value = endDate.toISOString().substr(0, 10); // Format: YYYY-MM-DD
    }

</script>
</body>

</html>