<%-- Created by IntelliJ IDEA. User: Jiwan Date: 4/11/2023 Time: 2:17 PM To change this template use File | Settings |
    File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="Service.UserService" %>
<%@ page import="Model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Premium</title>
    <link rel="shortcut icon" type="image/jpg" href="CSS/images/LM.ico" />
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'
          type='text/css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/styles.css">
    <script src="https://kit.fontawesome.com/6f3a65e23d.js"
            crossorigin="anonymous"></script>
</head>

<body>
<!--welcome face-->
<header>
    <div class="pagehead">
        <div class="headtitles" id="headtitlesfix">
            <div class="one">
                <ul>
                    <li><a href="homepage.html"><img src="CSS/images/LMB.png"
                                                     id="logo"></a></li>
                </ul>
            </div>
            <div class="two">
                <ul>
                    <li>
                        <form action="user?page=userbsearch" method="post">
                            <input type="search" name="query" id="search"
                                   placeholder="Search...">
                            <button type="submit" class="search_button"><i
                                    class="fas fa-search"></i></button>
                        </form>
                    </li>


                    <li><a href="" id="profileprofile" class="headlink">My Profile</a>
                    </li>


                </ul>
            </div>
        </div>
    </div>
</header>

<div class="parent">
    <section class="admin-nav">
        <span id="adminid">Admin Panel</span>
        <ul id="navlist">
            <li>
                <div class="listitem collapsible">User</div>
                <ul class="collapseitem" style="width: 224px;">
                    <a href="admin?action=listUser">
                        <li class="listitem sublistitem">User List</li>
                    </a>
                    <a href="admin?action=sorting">
                        <li class="listitem sublistitem">Sort User</li>
                    </a>
                    <a href="User?page=listpolicies">
                        <li class="listitem sublistitem">View Policy</li>
                    </a>
                </ul>
            </li>
            <a href="User?page=claiminsurance">
                <li class="listitem">See Claim</li>
            </a>
<%--            <a href="User?page=viewResult">--%>
<%--                <li class="listitem">View Result</li>--%>
<%--            </a>--%>
        </ul>
    </section>


</div>
<script src="CSS/paginationscript.js"></script>
<script>
    var coll = document.getElementsByClassName("collapsible");
    var i;

    for (i = 0; i < coll.length; i++) {
        coll[i].addEventListener("click", function () {
            this.classList.toggle("active");
            var collapseitem = this.nextElementSibling;
            if (collapseitem.style.display === "block") {
                collapseitem.style.display = "none";
            } else {
                collapseitem.style.display = "block";
            }
        });
    }
</script>
</body>

</html>