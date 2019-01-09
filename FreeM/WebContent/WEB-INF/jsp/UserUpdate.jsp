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

   <jsp:include page="/baselayout/header.jsp" />

    <div class="container">

      <div class="starter-template">
        <h1>ユーザー情報更新</h1>
      </div>

      <div class="text-center">
          <table class="table table-bordered">
    		<tr>
    			<td>ログインID</td>
    			<td>0001</td>
    		</tr>
    		<tr>
    			<td>ユーザー名</td>
    			<td><input type="text" value="" placeholder="山田太郎"></td>
    		</tr>
    		<tr>
    			<td>生年月日</td>
    			<td><input type="text" value="" placeholder="1990年01月01日"></td>
    		</tr>
    		<tr>
    			<td>登録日時</td>
    			<td><input type="text" value="" placeholder="2018年01月01日"></td>
    		</tr>
    		<tr>
    			<td>更新日時</td>
    			<td><input type="text" value="" placeholder="2018年01月01日"></td>
    		</tr>
    		<tr>
    			<td>メールアドレス</td>
    			<td><input type="text" value="" placeholder="FreeMM@gmail.com"></td>
    		</tr>
    		<tr>
    			<td>住所</td>
    			<td><input type="text" value="" placeholder="埼玉県さいたま市北区1-1-1"></td>
    		</tr>
    	</table>
    	<p><a href="UserReference.html"><button type="button">更新</button></a></p>
    	<a href="UserReference.html">戻る</a>
      </div>
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>
