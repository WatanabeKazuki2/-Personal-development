<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="Index">MM</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

	      <div class="collapse navbar-collapse" id="navbarsExampleDefault">

	          <ul class="navbar-nav mr-auto">
			  <c:choose>
	          	<c:when test="${userInfo.userId>=1}">
			          <li class="nav-item active">
			            <a class="nav-link" href="Logout">ログアウト<span class="sr-only">(current)</span></a>
			          </li>
	          	</c:when>
	          	<c:otherwise>
			          <li class="nav-item active">
			            <a class="nav-link" href="Login">ログイン<span class="sr-only">(current)</span></a>
			          </li>
			          <li class="nav-item active">
			            <a class="nav-link" href="Entry">新規登録<span class="sr-only">(current)</span></a>
			          </li>
	          	</c:otherwise>
	          </c:choose>
	          <li class="nav-item active">
	            <a class="nav-link" href="UserReference">ユーザー情報<span class="sr-only">(current)</span></a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="UserList.html">ユーザー一覧</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="Exhibit.html">商品登録</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="cart.html">カート</a>
	          </li>
				<c:if test="${userInfo.userId>=1}">
			          <li class="nav-item">
			            <a class="nav-link" href="cart.html">出品待機一覧</a>
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" href="cart.html">購入待機一覧</a>
			          </li>
				</c:if>

	          <li class="nav-item dropdown">
	          </li>
	        </ul>
	</div>
</nav>