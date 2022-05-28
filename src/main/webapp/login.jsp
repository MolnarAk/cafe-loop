<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css">

    <title>Bejelentkezés</title>
</head>
<body>

<%@include file="fragments/navbar.jsp" %>

<div class="container container-fluid centered-form-container">

    <form class="form-horizontal centered-form" action="login" method="post">
        <h1 class="text-center text-uppercase">Bejelentkezés</h1>
        <div class="panel panel-default">
            <div class="panel-body" style="padding: 32px;">

                <c:if test="${param.loginFailed}">
                    <div class="alert alert-danger alert-dismissible fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Sikertelen bejelentkezés</strong> Nem megfelelő email cím és jelszó páros
                    </div>
                </c:if>

                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" class="form-control input-lg" name="email" placeholder="Email cím"
                           value="${param.email == null ? '' : param.email}"
                           required>
                </div>
                <br>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><i class="fa fa-key"></i></span>
                    <input type="password" name="password" class="form-control" placeholder="Jelszó">
                </div>
                <br>
                <button type="submit" class="btn btn-lg btn-block bg-1" title="">Bejelentkezek!</button>
            </div>
        </div>

    </form>

</div>

</body>
</html>