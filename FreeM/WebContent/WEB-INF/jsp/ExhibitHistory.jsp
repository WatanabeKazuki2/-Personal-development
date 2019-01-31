<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>出品履歴リスト画面</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>

	<jsp:include page="/baselayout/header.jsp" />

	<form action="ExhibitHistory" method="post">

    <div class="text-center">
    <h1>出品履歴一覧</h1>
    </div>
        <div class="mx-auto" >
    <table class="table table-bordered">
        <tr>
        	<th></th>
            <th>商品名</th>
            <th>カテゴリー</th>
            <th>配送方法</th>
            <th>小計</th>
            <th></th>
        </tr>

        <c:forEach var="gh" items="${ghList}">

        <tr>
        <td><img src="img/${gh.fileName}" alt="" width="110" height="150"></td>
        <td>${gh.name}</td>
        <td>${gh.categoryName}</td>
        <td>${gh.deliveryMethodName}</td>
        <td>${gh.price}円</td>
        <td>
            <a href="GoodsReference"><button type="button">詳細</button></a>
        </td>
        </tr>

        </c:forEach>

    </table>
    <a href="UserReference">戻る</a>
        </div>

	</form>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>
