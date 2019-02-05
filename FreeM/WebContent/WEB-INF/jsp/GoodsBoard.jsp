<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>商談画面</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>

	<jsp:include page="/baselayout/header.jsp" />

    <form action="GoodsBoard" method="post">
    <div class="text-center">


    <h1>商談掲示板</h1>
    </div>
        <div class="mx-auto" >
        <input type="hidden" name="goodsId" value="${gdb.id}">
    <table class="table table-bordered">
        <tr>
            <th></th>
            <th>商品名</th>
            <th>ユーザー名</th>
            <th>配送方法</th>
            <th>小計</th>
        </tr>
        <tr>
        <td><img src="img/${gdb.fileName}" alt="" width="110" height="150"></td>
        <td>${gdb.name}</td>
        <td>${gdb.exibitUserName}</td>
        <td>${gdb.deliveryMethodName}</td>
        <td>${tp}円</td>
        </tr>
    </table>
    <div class="text-center">
    <button type="submit">成立</button>
    </div>
    </div>

    <div class="text-center">
        <h3>掲示板</h3>
        <a href="BoardInput?goodsId=${gdb.id}"><button type="button">掲示板に記入</button></a>
    </div>
    <table class="table table-bordered">
    	<c:forEach var="bdb" items="${bdbList}">
	        <tr>
	            <td>${bdb.userName}</td>
	            <td>${bdb.boadComment}</td>
	            <td>${bdb.createDate}</td>
	        </tr>
    	</c:forEach>
    </table>

    </form>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>
