<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">


    <title>ログイン画面</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.0/examples/sign-in/signin.css" rel="stylesheet">
</head>

<body class="text-center">
	<jsp:include page="/baselayout/header.jsp" />

	<form class="form-signin">
	    <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
	    <h1 class="h3 mb-3 font-weight-normal">ログイン</h1>
	    <label for="inputEmail" class="sr-only">ログインID</label>
	    <input type="text" id="inputEmail" class="form-control" placeholder="LoginId" required autofocus>
	    <label for="inputPassword" class="sr-only">Password</label>
	    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
	    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
	</form>
</body>
</html>
