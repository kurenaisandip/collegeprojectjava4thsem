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
        <span id="adminid">Admin Panel</span>
        <ul id="navlist">
            <li>
                <div class="listitem collapsible">User</div>
                <ul class="collapseitem" style="width: 224px;">
                    <a href="admin?action=listUser">
                        <li class="listitem sublistitem">User List</li>
                    </a>
                </ul>
            </li>
            <a href="admin?action=claimlist">
                <li class="listitem">See Claim</li>
            </a>

        </ul>
    </section>

    <section class="page">
        <div class="container">
            <div class="user-info-container">
                <div class="user-info-container-sub">
                    <div class="User-profile-heading">View</div>

                    <div class="book-info-form">

<%--                        <div class="book-details">--%>
<%--                            <div class="label inputsection inputsection-sub">--%>
<%--                                <div class="compacth">--%>
<%--                                    <label>First Name:</label>--%>
<%--                                </div>--%>
<%--                                <div class="compacth">--%>
<%--                                    <label></label>--%>
<%--                                </div>--%>
<%--                                <br>--%>
<%--                            </div>--%>
<%--                            <div class="displayfields inputsection inputsection-sub">--%>
<%--                                <div class="compacth">--%>
<%--                                    <span>${details.name}</span>--%>
<%--                                </div>--%>
<%--                                <div class="compacth">--%>
<%--                                    <span>a</span>--%>
<%--                                    &lt;%&ndash;        <p>${details.btitle}a</p>&ndash;%&gt;--%>
<%--                                    &lt;%&ndash;        <p>${details.bauthor}a</p>&ndash;%&gt;--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="label inputsection inputsection-sub">--%>
<%--                                <div class="compacth">--%>
<%--                                    <label>Insurance Policy:</label>--%>
<%--                                </div>--%>
<%--                                <div class="compacth">--%>
<%--                                    <label>Address:</label>--%>
<%--                                </div>--%>
<%--                                <br>--%>
<%--                            </div>--%>
<%--                            <div class="displayfields inputsection inputsection-sub">--%>
<%--                                <div class="compacth">--%>
<%--                                    <span>${details.policy}</span>--%>
<%--                                </div>--%>
<%--                                <div class="compacth">--%>
<%--                                    <span>${details.address}</span>--%>

<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="label inputsection inputsection-sub">--%>
<%--                                <div class="compacth">--%>
<%--                                    <label>Email:</label>--%>
<%--                                </div>--%>
<%--                                <div class="compacth">--%>
<%--                                    <label>Phone:</label>--%>
<%--                                </div>--%>
<%--                                <br>--%>
<%--                            </div>--%>
<%--                            <div class="displayfields inputsection inputsection-sub">--%>
<%--                                <div class="compacth">--%>
<%--                                    <span>${details.email}</span>--%>
<%--                                </div>--%>
<%--                                <div class="compacth">--%>
<%--                                    <span>${details.phone_number}</span>--%>

<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class="label inputsection inputsection-sub">--%>
<%--                                <div class="compacth">--%>
<%--                                    <label>Additonal information:</label>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="displayfields inputsection inputsection-sub">--%>
<%--                                <div>--%>
<%--                                    <span>${details.info}</span>--%>

<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="book-details">
                            <table class="seeclaim">
                                <colgroup>
                                    <col span="1" style="width: 25%;">
                                    <col span="1" style="width: 70%;">

                                </colgroup>
                                <tr>
                                    <th>
                                        <div class="compacth">
                                            <label>First Name:</label>
                                        </div>
                                    </th>
                                    <td>
                                        <div class="compacth">
                                            <span>${details.name}</span>
                                        </div>
                                    </td>
                                </tr>
                                <br>
                                <tr>
                                    <th>
                                        <div class="compacth">
                                            <label>Insurance Policy:</label>
                                        </div>
                                    </th>
                                    <td>
                                        <div class="compacth">
                                            <span>${details.policy}</span>
                                        </div>
                                    </td>
                                </tr>
                                <br>
                                <tr>
                                    <th>
                                        <div class="compacth">
                                            <label>Address:</label>
                                        </div>
                                    </th>
                                    <td>
                                        <div class="compacth">
                                            <span>${details.address}</span>

                                        </div>
                                    </td>
                                </tr>
                                <br>
                                <tr>
                                    <th>
                                        <div class="compacth">
                                            <label>Email:</label>
                                        </div>

                                    </th>
                                    <td>
                                        <div class="compacth">
                                            <span>${details.email}</span>
                                        </div>

                                    </td>
                                </tr>
                                <br>
                                <tr>
                                    <th>
                                        <div class="compacth">
                                            <label>Phone:</label>
                                        </div>
                                    </th>
                                    <td>
                                        <div class="compacth">
                                            <span>${details.phone_number}</span>

                                        </div>
                                    </td>
                                </tr>
                                <br>
                                <tr>
                                    <th>
                                        <div class="compacth">
                                            <label>Additional information:</label>
                                        </div>
                                    </th>
                                </tr>
                                <tr>
                                    <td>
                                        <div>
                                            <span>${details.info}</span>

                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="book-info-form">
                        <div class="book-image-reservation">
                            <div class="book-image-container">
                                <img class="book-image"
                                     src="data:image/png;base64,${details.image}">
                            </div>

                        </div>
                    </div>

                    <div class="bottombutton" style="margin-bottom: 50px;">
                        <div class="bottombutton" style="margin-bottom: 50px;">
                            <form action="admin?action=accept&id=${details.id}" method="post">
                                <button type="submit" id="accept" name="accept" value="accepted">Accept Claim</button>
                            </form>
                            <form action="admin?action=reject&id=${details.id}" method="post">
                                <button type="submit" id="reject" name="reject" value="rejected">Reject Claim</button>
                            </form>
                        </div>
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
