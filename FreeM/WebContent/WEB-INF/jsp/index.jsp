<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ホーム画面</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>
		<jsp:include page="/baselayout/index_header.jsp" />

	<form action="Index" method="post">
    <div class="container">

      <div class="starter-template">
        <h1>フリーMM</h1>
      </div>
      <div class="center-block">
      <div class="text-center">
      <div class="row center">
      <h3>おすすめ出品</h3>
      </div>

      <div class="row">
	  <c:forEach var="goods" items="${goodsList}">
	  <input type="hidden" name="goodsId" goodsId="${goods.id}">
      <div class="card">
          <div class="cart-image">
              <a href="GoodsReference?goodsId=${goods.id}"><img src="img/${goods.fileName}" alt="" width="200" height="300"></a>
                  <div class="card-content">
                      <span class="card-title">${goods.name}</span>
                      <p>カテゴリー：${goods.categoryName}</p>
                      <p>小計：${goods.price}円</p>
                      <p>出品者：${goods.exibitUserName}</p>
                  </div>
          </div>
       </div>
	  </c:forEach>
      </div>


       </div>
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
