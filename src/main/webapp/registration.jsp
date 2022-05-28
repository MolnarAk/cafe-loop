<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">

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

<div class="container bg-3">
  <h2>Regisztráció</h2>
<form class="form-horizontal" action="registration" onsubmit="return validateForm()" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email:</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" name="email" id="email" placeholder="Email cím">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Teljes név:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" id="name" placeholder="Teljes név">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Jelszó:</label>
    <div class="col-sm-10">
    	<input id="password" class="form-control" id="pwd"  name="password" type="password" placeholder="Jelszó">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd-confirm">Jelszó megerősítése:</label>
    <div class="col-sm-10">
    	<input id="password-confirm" class="form-control" id="pwd-confirm"  name="password-confirm" type="password" placeholder="Jelszó megerősítése">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Regisztráció</button>
    </div>
  </div>
</form>
</div>

</body>
</html>