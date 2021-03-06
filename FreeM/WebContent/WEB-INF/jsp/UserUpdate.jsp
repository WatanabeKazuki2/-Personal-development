<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ユーザー情報更新画面</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>

   <jsp:include page="/baselayout/header.jsp"/>

	<form action="UserUpdate" method="POST">
    <div class="container">

      <div class="starter-template">
        <h1>ユーザー情報更新</h1>
      </div>
      <div class="text-center">
          <table class="table table-bordered">
    		<tr>
    			<td>ログインID</td>
    			<td>${user.loginId}</td>
    		</tr>
    		<tr>
    			<td>ユーザー名</td>
    			<td><input type="text" name="name" placeholder="${user.name}"></td>
    		</tr>
    		<tr>
    			<td>生年月日</td>
    			<td><input type="date" name="birthDate" placeholder="${user.birthDate}"></td>
    		</tr>
    		<tr>
    			<td>パスワード</td>
    			<td><input type="text" name="password"></td>
    		</tr>
    		<tr>
    			<td>パスワード（確認）</td>
    			<td><input type="text" name="password2"></td>
    		</tr>
    		<tr>
    			<td>メールアドレス</td>
    			<td><input type="text" name="mailAddress"  placeholder="${user.mailAddress}"></td>
    		</tr>
    		<tr>
    			<td>住所</td>
    			<td><input type="text" name="streetAddress" placeholder="${user.streetAddress}"></td>
    		</tr>
    	</table>
    	<p><button type="submit">更新</button></p>
    	<a href="UserReference">戻る</a>
      </div>
    </div><!-- /.container -->
	</form>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>
