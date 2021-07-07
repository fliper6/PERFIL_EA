<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jfc
  Date: 2019-04-22
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: jfc
  Date: 2019-04-22
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <title>Template</title>
</head>
<body>
<div class="container" id="gamesApp">
    <div class="row">
        <div class="col">
            <h1>{{appName}}</h1>
        </div>
    </div> <!-- row -->
    <div class="row bg-light">
        <div class="col-md-4 d-flex align-items-center">
            <h3>${username}</h3>
        </div>
        <div class="col-md-8">
            <nav class="navbar nav-pills justify-content-end">
                <a class="nav-link active" href="allG">All Games</a>
                <a class="nav-link" href="myG">My Games</a>
                <a class="nav-link" href="addG">Add Games</a>
            </nav>
        </div> <!-- col -->
    </div> <!-- row -->
    <div class="row">
        <div class="col-sm-8">
            <table class="table table-striped table-bordered table-sm">
                <thead>
                <tr><th>Games</th><th class="extras">Year</th><th>Price</th></tr>
                </thead>
                <tbody>

                <c:choose>
                    <c:when test="${requestScope.page=='pageGames'}">
                        <jsp:include page="ListGames.jsp" />
                    </c:when>
                </c:choose>

                </tbody>
            </table>
            <nav class="d-flex justify-content-end">
                <div class="pagination">
                    <c:if test="${nrP gt 0}">
                        <button>
                            <a href="ListGames?page=${nrP - 1}"><<</a>
                        </button>
                    </c:if>
                    <button>${nrP}</button>
                    <c:if test="${nrP lt maxP - 1}">
                        <button>
                            <a href="ListGames?page=${nrP + 1}">>></a>
                        </button>
                    </c:if>
                </div>
            </nav>
        </div> <!-- col -->
        <div class="col-sm-4">
            <form>
                <fieldset>
                    <legend>Filter</legend>
                    <select class="form-control">
                        <option>year</option>
                        <option>{{g}}</option>
                    </select>
                    <select class="form-control">
                        <option>platform</option>
                        <option >{{g}}</option>
                    </select>
                </fieldset>
            </form>
        </div> <!-- col -->
    </div> <!-- row -->
    <div class="row">
        <div class="col" >
            <p class="text-center"><sub>Footer information &copy;</sub></p>
        </div>
    </div> <!-- row -->
    <game-show></game-show>
</div><!-- /.container -->

<!-- Bootstrap core JavaScript -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="scripts/gamesApp.js"></script>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
