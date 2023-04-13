<%@ page import="Service.UserService" %>
<%@ page import="Model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${details.btitle} | Library Management System</title>
    <link rel="shortcut icon" type="image/jpg" href="..CSS/images/LM.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/styles.css">
    <script src="https://kit.fontawesome.com/6f3a65e23d.js" crossorigin="anonymous"></script>
</head>
<body>
<header>
    <div class="pagehead">
        <div class="headtitles" id="headtitlesfix">
            <div class="one">
                <ul>
                    <li><a href="user?page=home"><img src="${pageContext.request.contextPath}/CSS/images/LMB.png"
                                                      id="logo"></a></li>
                </ul>
            </div>
            <div class="two">
                <ul>
                    <li>
                        <form action="user?page=userbsearch" method="post">
                            <input type="search" name="query" id="search" placeholder="Search...">
                            <button type="submit" class="search_button"><i class="fas fa-search"></i></button>
                        </form>
                    </li>


                    <li><a href="" id="profileprofile" class="headlink">My Profile</a></li>


                </ul>
            </div>
        </div>
    </div>
</header>
<div class="parent">
    <section class="admin-nav">
        <span id="adminid">User Panel</span>
        <ul id="navlist">
            <li>
                <div class="listitem collapsible">Policy Plan</div>
                <ul class="collapseitem" style="width: 224px;">
                    <a href="User?page=policyplan">
                        <li class="listitem sublistitem">Add Policy</li>
                    </a>
                    <a href="User?page=viewpremium">
                        <li class="listitem sublistitem">Premium Policy</li>
                    </a>
                    <a href="User?page=listpolicies">
                        <li class="listitem sublistitem">Manage Policy</li>
                    </a>
                </ul>
            </li>
            <a href="User?page=claiminsurance">
                <li class="listitem">Claim</li>
            </a>
            <a href="User?page=viewResult">
                <li class="listitem">View Result</li>
            </a>
        </ul>
    </section>

    <section class="page">
        <div class="container">
            <div class="user-info-container">
                <div class="user-info-container-sub">
                    <div class="User-profile-heading">View</div>

                    <div class="book-info-form">

                        <div class="book-details">
                            <div class="label inputsection inputsection-sub">
                                <div class="compactd">
                                    <label>First Name:</label>
                                </div>
                                <div class="compactd">
                                    <label>Last Name:</label>
                                </div>
                                <br>
                            </div>
                            <div class="displayfields inputsection inputsection-sub">
                                <div class="compactd">
                                    <span>a</span>
                                </div>
                                <div class="compactd">
                                    <span>a</span>
                                    <%--        <p>${details.btitle}a</p>--%>
                                    <%--        <p>${details.bauthor}a</p>--%>
                                </div>
                            </div>
                            <div class="label inputsection inputsection-sub">
                                <div class="compactd">
                                    <label>Insurance Policy:</label>
                                </div>
                                <div class="compactd">
                                    <label>Address:</label>
                                </div>
                                <br>
                            </div>
                            <div class="displayfields inputsection inputsection-sub">
                                <div class="compactd">
                                    <span>a</span>
                                </div>
                                <div class="compactd">
                                    <span>a</span>
                                    <%--        <p>${details.btitle}a</p>--%>
                                    <%--        <p>${details.bauthor}a</p>--%>
                                </div>
                            </div>
                            <div class="label inputsection inputsection-sub">
                                <div class="compactd">
                                    <label>Email:</label>
                                </div>
                                <div class="compactd">
                                    <label>Phone:</label>
                                </div>
                                <br>
                            </div>
                            <div class="displayfields inputsection inputsection-sub">
                                <div class="compactd">
                                    <span>a</span>
                                </div>
                                <div class="compactd">
                                    <span>a</span>
                                    <%--        <p>${details.btitle}a</p>--%>
                                    <%--        <p>${details.bauthor}a</p>--%>
                                </div>
                            </div>

                            <div class="label inputsection inputsection-sub">
                                <div class="compactd">
                                    <label>Additonal information:</label>
                                </div>
                            </div>
                            <div class="displayfields inputsection inputsection-sub">
                                <div>
                                    <span>a</span>
                                    <%--        <p>${details.btitle}a</p>--%>
                                    <%--        <p>${details.bauthor}a</p>--%>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
                <div class="book-info-form">
                    <div class="book-image-reservation">
                        <div class="book-image-container">
                            <img class="book-image"
                                 src="${pageContext.request.contextPath}src/main/webapp/files/horkita.jpg">
                        </div>
                    </div>
                </div>

                <div class="bottombutton" style="margin-bottom: 50px;">
                    <button type="submit" id="accept">Accept Claim</button>
                    <button type="submit" id="reject">Reject Claim</button>
                </div>
            </div>
        </div>

    </section>
</div>


</div>
<div class="container" id="notification">
    <div class="notifcard" id="registercard">
        <br>
        <a class="signup">Book Registered!</a>
        <button class="enter" onclick="off()">OK</button>
    </div>
    <div id="shadowlayern" onclick="off()"></div>
</div>
<script>
    function on() {
        document.getElementById("notification").style.display = "block";
    }

    function off() {
        document.getElementById("notification").style.display = "none";
    }
</script>
</body>
</html>
