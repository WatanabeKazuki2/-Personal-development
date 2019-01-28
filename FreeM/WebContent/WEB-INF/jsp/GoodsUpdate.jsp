<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>出品画面</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>

	<jsp:include page="/baselayout/header.jsp" />

	<form action="GoodsUpdate" method="post" enctype="multipart/form-data">
    <div class="container">

      <div class="starter-template">
        <h1>編集内容を入力してください</h1>
        <input type="hidden" name="goodsId" value="${gdb.id}">
	<table class="table table-bordered">
		<tr>
			<td>商品名</td>
			<td><input type="text" name="goodsName" value="${gdb.name}"></td>
		</tr>
		<tr>
		    <td>商品画像</td>
		    <td>
				  <div class="form-group">
				    <label for="exampleFormControlFile1"></label>
					    <input type="file" class="form-control-file" name="fileName" id="exampleFormControlFile1">
				  </div>
			</td>
		</tr>
		<tr>
		<tr>
			<td>カテゴリー</td>
			<td>
			        <select class="selectpicker" name="categoryId" >
				        <c:forEach var="category" items="${categoryList}">
					        <option value="${categiry.id}">${category.name}</option>
				       </c:forEach>
				    </select>
			</td>
		</tr>
		<tr>
			<td>運送方法</td>
		        <td>
		        	<select class="selectpicker" name="deliveryId">
	        		<c:forEach var="delivery" items="${dmdList}">
	 					<option value="${delivery.deliveryId}">${delivery.deliveryName}</option>
	       			</c:forEach>
	       			</select>
		        </td>
		</tr>
		<tr>
			<td>金額</td>
			<td><input type="text" name="price" value="${gdb.price}"></td>
		</tr>
		<tr>
			<td>コメント</td>
			<td><textarea name="detail" value="${gdb.detail}" ></textarea></td>
	</table>

	        <button type="submit">更新</button>
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

