<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css">

    <title>Fiók adatok</title>
</head>
<body>

<%@include file="../fragments/navbar.jsp" %>

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

<div class="container-fluid bg-1 text-center">
    <img src="${pageContext.request.contextPath}/images/logo-big.png" class="img-responsive img-circle" style="display:inline;" width="150" height="150">
    <h2>Felhasználó fiók</h2>
</div>

<div class="container container-fluid">

    <div class="row">

        <div class="col-lg-6">

            <form class="form-horizontal"
                  action="${pageContext.request.contextPath}/customer-center/update"
                  method="post">

                <div class="panel panel-default">
                    <div class="panel-heading clearfix">
                        <i class="icon-calendar"></i>
                        <h3 class="panel-title">Felhasználó adatainak módosítása</h3>
                    </div>
                    <div class="panel-body" style="padding: 32px;">

                        <div class="input-group input-group-lg">
                            <span class="input-group-addon"><i class="fa fa-envelope-o"></i></span>
                            <input type="text" class="form-control input-lg" name="email" placeholder="Email cím"
                                   value="${fn:escapeXml(sessionScope.loggedInCustomer.email)}" required>
                        </div>
                        <br>
                        <div class="input-group input-group-lg">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" class="form-control input-lg" id="name" name="name"
                                   value="${fn:escapeXml(sessionScope.loggedInCustomer.name)}">
                        </div>
                        <br>
                        <button type="submit" class="btn btn-lg btn-block bg-1" title="">Változtatások mentése</button>

                    </div>
                </div>

            </form>

        </div>

        <div class="col-lg-6">

            <form class="form-horizontal"
                  action="${pageContext.request.contextPath}/customer-center/update-password" method="post"
                  onsubmit="return validateForm()">

                <div class="panel panel-default">
    	                <div class="panel-heading clearfix">
		                        <i class="icon-calendar"></i>
		                        <h3 class="panel-title">Jelszó megváltoztatása</h3>
                    </div>
                    <div class="panel-body" style="padding: 32px;">

                        <c:if test="${param.invalidPassword}">
                            <div style="color: red;">
                                Nem sikerült a jelszó frissítése, mivel a régi jelszó megadása invalid.
                            </div>
                        </c:if>
                        <c:if test="${param.passwordUpdated}">
                            <div style="color: green;">
                                Sikeresen megváltoztatta a jelszót!
                            </div>
                        </c:if>

                        <div class="input-group input-group-lg">
                            <span class="input-group-addon"><i class="fa fa-key"></i></span>
                            <input type="password" name="password" class="form-control" placeholder="Új jelszó">
                        </div>
                        <br>
                        <div class="input-group input-group-lg">
                            <span class="input-group-addon"><i class="fa fa-key"></i></span>
                            <input type="password" name="password-confirm" class="form-control"
                                   placeholder="Új jelszó mégegyszer">
                        </div>
                        <br>
                        <div class="input-group input-group-lg">
                            <span class="input-group-addon"><i class="fa fa-key"></i></span>
                            <input type="password" name="password-old" class="form-control"
                                   placeholder="Régi jelszó">
                        </div>
                        <br>
                        <button type="submit" class="btn btn-lg btn-block bg-1" title="">Jelszó módosítása</button>

                    </div>
                </div>
            </form>
        </div>

    </div>

</div>


</body>
</html>