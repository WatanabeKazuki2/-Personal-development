<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ユーザー情報</title>
      <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/4.0/examples/starter-template/starter-template.css" rel="stylesheet">
  </head>

  <body>

    <jsp:include page="/baselayout/header.jsp" />

    <div class="container">

      <div class="starter-template">
        <h1>ユーザー情報</h1>
      </div>

      <div class="text-center">
      <input type="hidden" name="userId" value="${userInfo.userId}">
          <table class="table table-bordered">
    		<c:if test="${userInfo.userId == userDate.userId}">
    		<tr>
    			<td>ログインID(本人のみ)</td>
    			<td>${userDate.loginId}</td>
    		</tr>
    		</c:if>
    		<tr>
    			<td>ユーザー名</td>
    			<td>${userDate.name}</td>
    		</tr>
			<c:if test="${userInfo.userId == userDate.userId}">
    		<tr>
    			<td>生年月日(本人のみ)</td>
    			<td>${userDate.birthDate}</td>
    		</tr>
    		</c:if>
    		<tr>
    			<td>登録日時</td>
    			<td>${userDate.createDate}</td>
    		</tr>
    		<tr>
    			<td>更新日時</td>
    			<td>${userDate.updateDate}</td>
    		</tr>
    		<c:if test="${userInfo.userId == userDate.userId}">
    		<tr>
    			<td>メールアドレス（本人のみ）</td>
    			<td>${userDate.mailAddress}</td>
    		</tr>
    		</c:if>
    		<c:if test="${userInfo.userId == userDate.userId}">
    		<tr>
    			<td>住所(本人のみ)</td>
    			<td>${userDate.streetAddress}</td>
    		</tr>
    		</c:if>
    	</table>
    	<c:if test="${userInfo.userId == userDate.userId}">
    	<p><a href="UserUpdate"><button type="button">更新画面へ</button></a>(本人のみ)</p>
      </div>
    	</c:if>
    </div><!-- /.container -->

    <div class="text-center">
    <p><a href="ExhibitList.html"><button type="button">出品物一覧</button></a></p>
	<c:if test="${userInfo.userId == userDate.userId}">
    	<p><a href="ExhibitStandBy.html"><button type="button">出品待機一覧</button></a>(本人のみ)</p>
    </c:if>
   	 <p><a href="ExhibitHistory.html"><button type="button">出品履歴一覧</button></a></p>
	<c:if test="${userInfo.userId == userDate.userId}">
    	<p><a href="BuyStandBy.html"><button type="button">購入待機一覧</button></a>(本人のみ)</p>
    </c:if>
    <c:if test="${userInfo.userId == userDate.userId}">
    	<p><a href="BuyHistory.html"><button type="button">購入履歴一覧</button></a>(本人のみ)</p>
    </c:if>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>
