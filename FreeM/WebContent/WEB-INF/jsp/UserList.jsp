<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ユーザー一覧</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>

    <jsp:include page="/baselayout/header.jsp" />

    		<form action="UserList" method="post">
    <div class="container">

      <div class="starter-template">
        <h1>ユーザー一覧</h1>

    		<div class="mx-auto" style="width: 200px;">
				<div  class="form-inline my-2 my-lg-0">
		            <div class = "navbar-brand">
		                ユーザー検索
		            </div>
		          <div>
		          <input class="form-control mr-sm-2" name="name" type="text" placeholder="Search" aria-label="Search">
		          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">検索</button>
		          </div>
				</div>
			</div>
        <table class="table table-bordered">
    		<tr>
    			<th>ユーザー名</th>
    			<th>出品数</th>
    			<th></th>
    		</tr>
    			<c:forEach var="user" items="${userList}">
    			<input type="hidden" name ="userId" value="${user.userId}">
		    		<tr>
		    			<td>${user.name}</td>
		    			<td>${user.count}件</td>
		    			<td><a href="UserReference?userId=${user.userId}"><button type="button">詳細</button></a></td>
		    		</tr>
    			</c:forEach>


    	</table>
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

