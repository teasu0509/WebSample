<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="zh-tw">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Access Denied</title>
</head>
<body class="text-white py-5" style="background-color: #007d7d;">
	<div class="container py-5">
		<div class="row justify-content-center">
			<div class="m-3 text-center ">
				<p>
				<div
					class="d-flex align-items-center justify-content-center rounded text-black"
					style="font-size: 5em">
					<svg width="1.0625em" height="1em" viewBox="0 0 17 16"
						class="bi bi-exclamation-triangle-fill" fill="currentColor"
						xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5a.905.905 0 0 0-.9.995l.35 3.507a.552.552 0 0 0 1.1 0l.35-3.507A.905.905 0 0 0 8 5zm.002 6a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"></path>
						</svg>
				</div>
				<br />Status Code: 403
				</p>
			</div>
			<div class="m-3">
				<h2>哇!!!! 抱歉...</h2>
				<p>
					抱歉，您目前沒有訪問的頁面權限<br />請回到上一個頁面繼續瀏覽或重新登入
				</p>
				<a class="btn btn-danger" href="javascript:history.back()">回上一頁</a>
				<a class="btn btn-danger" href="<c:url value="/logout"/>">重新登入</a>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>