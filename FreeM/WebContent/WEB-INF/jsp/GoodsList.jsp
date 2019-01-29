<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>購入画面</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>

    <jsp:include page="/baselayout/index_header.jsp" />

    <div class="container">
	<form action="Index" method="post">
      <div class="starter-template">
        <h1>商品検索一覧</h1>
	<table class="table table-bordered">
		<tr>
		    <th></th>
			<th>商品名</th>
			<th>出品ユーザー</th>
			<th>カテゴリー</th>
			<th>配送方法</th>
			<th>小計</th>
			<th></th>
		</tr>
		<c:forEach var="gList" items="${gList}">
		<input type="hidden" name="goodsId" value="${gList.id}">
		<tr>
		    <td> <img src="img/${gList.fileName}" alt="" width="110" height="150"></td>
			<td>${gList.name}</td>
			<td>${gList.exibitUserName}</td>
			<td>${gList.categoryName}</td>
			<td>${gList.deliveryMethodName}</td>
			<td>${gList.price}円</td>
			<td>
			    <a href="GoodsReference?goodsId=${gList.id}"><button type="button">詳細</button></a>
		    </td>
		</tr>
		</c:forEach>
	</table>

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
