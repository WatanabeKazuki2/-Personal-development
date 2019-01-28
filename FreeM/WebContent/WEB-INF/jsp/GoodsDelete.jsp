<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>商品削除</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>

	<jsp:include page="/baselayout/header.jsp" />

    <div class="container">

      <div class="starter-template">
          <div class="alert alert-danger" role="alert">
                <h1>本当に削除しますか？</h1>
            </div>
<table class="table table-bordered">
		<tr>
			<th>商品名</th>
			<th>単価</th>
			<th>配送方法</th>
			<th>配送金額</th>
			<th>小計</th>
		</tr>
		<tr>
			<td>ただのドア</td>
			<td>1500円</td>
			<td>ゆうパック</td>
			<td>1000円</td>
			<td>2500円</td>
		</tr>
	</table>
        <a href="error.html"><button type="button">はい</button></a>
        <a href="UserReference.html"><button type="button">キャンセル</button></a>
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