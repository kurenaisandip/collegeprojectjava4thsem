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
<%--          <li>--%>
<%--            <form action="user?page=userbsearch" method="post">--%>
<%--              <input type="search" name="query" id="search" placeholder="Search...">--%>
<%--              <button type="submit" class="search_button"><i class="fas fa-search"></i></button>--%>
<%--            </form>--%>
<%--          </li>--%>

<%--          <li class="headlink"><a href="user?page=profile" id="profileprofile">My Profile</a></li>--%>
        </ul>
      </div>
    </div>
  </div>
</header>
<div class="book-info-box">

  <div class="book-info-form">

    <div class="book-details">
      <div>
        <h2>Title</h2>
        <p>${details.btitle}a</p>
      </div>
      <div>
        <h2>Author</h2>
        <p>${details.bauthor}a</p>
      </div>
      <div>
        <h2>ISBN</h2>
        <p>${details.bisbn}a</p>
      </div>
      <div>
        <h2>Publisher</h2>
        <p>${details.bpublisher}a</p>
      </div>
      <div>
        <h2>Publication Year</h2>
        <p>${details.bpubyear}a</p>
      </div>
      <div>
        <h2>Genre</h2>
        <p>${details.bgenre}a</p>
      </div>
      <div>
        <h2>Language</h2>
        <p>${details.blanguage}a</p>
      </div>
      <div>
        <h2>Location</h2>
        <p>${details.blocation}a</p>
      </div>
      <div>
        <h2>Synopsis</h2>
        <p>${details.bsynopsis}a</p>
      </div>
    </div>

    <div class="book-image-reservation">
      <div class="book-image-container">
        <img class="book-image" src="<c:choose>
                                <c:when test="${not empty details.bimage}">
                                    data:image/png;base64,${details.bimage}
                                </c:when>
                                <c:otherwise>
                                    ${pageContext.request.contextPath}src/main/webapp/files/horkita.jpg
                                </c:otherwise>
                            </c:choose>">

      </div>
    </div>

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
