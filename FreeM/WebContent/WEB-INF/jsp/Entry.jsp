<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>新規登録画面</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>

    <jsp:include page="/baselayout/header.jsp" />
    <c:if test="${errMsg != null}" >
	    <div class="alert alert-danger">
		  <strong>${errMsg}</strong>
		</div>
		</c:if>
    <div class="container">
		<form action="Entry" method="post">
	      <div class="starter-template">
	        <h1>新規登録</h1>
		<table class="table table-bordered">
			<tr>
				<td>ログインID</td>
				<td><input type="text" name="loginId" value=""></td>
			</tr>
			<tr>
				<td>ユーザー名</td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td>生年月日</td>
				<td><input type="Date" name="birthDate" value=""></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="text" name="password" value=""></td>
			</tr>
			<tr>
				<td>パスワード(確認)</td>
				<td><input type="text" name="password2" value=""></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><input type="text" name="mailAddress" value=""></td>
			</tr>
			<tr>
				<td>住所</td>
				<td><input type="text" name="streetAddress" class="form-control" value=""></td>
		</table>

		        <a href="Login"><button type="submit">登録</button></a>
	      </div>
		</form>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>
