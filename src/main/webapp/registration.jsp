<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    @@ -8,68 +8,67 @@
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css">

    <meta charset="UTF-8">
    <title>Regisztráció</title>
</head>
<body>

<%@include file="fragments/navbar.jsp" %>

<script>
    function validateForm() {
        // TODO 8 karakter legalább és kis- és nagybetű + szám
        const password = document.getElementById('password').value;
        const passwordConfirm = document.getElementById('password-confirm').value;
        if (password !== passwordConfirm) {
            alert('A jelszó megerősítés nem sikerült!');
            return false;
        }
        return true;
    }
</script>

<div class="container container-fluid centered-form-container">
    <form class="form-horizontal centered-form" action="registration" onsubmit="return validateForm()" method="post">
        <h1 class="text-center text-uppercase">Regisztráció</h1>
        <div class="panel panel-default">
            <div class="panel-body" style="padding: 32px;">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><i class="fa fa-envelope-o"></i></span>
                    <input type="text" class="form-control input-lg" name="email" placeholder="Email cím"
                           required>
                </div>
                <br>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" class="form-control input-lg" name="name" placeholder="Teljes név" required>
                </div>
                <br>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><i class="fa fa-key"></i></span>
                    <input type="password" name="password" class="form-control" placeholder="Jelszó">
                </div>
                <br>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><i class="fa fa-key"></i></span>
                    <input type="password" name="password-confirm" class="form-control"
                           placeholder="Jelszó megerősítése">
                </div>
                <br>
                <button type="submit" class="btn btn-lg btn-block bg-1" title="">Regisztrálok!</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>