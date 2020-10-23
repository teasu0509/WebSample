<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="zh-tw">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>登入</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<style>
body {
	margin: 0;
	padding: 0;
	background-color: #007d7d;
	height: 100vh;
}

#login .container #login-row #login-column #login-box {
	margin-top: 120px;
	max-width: 600px;
	/*height: 420px;*/
	border: 1px solid #9C9C9C;
	background-color: #EAEAEA;
	border: 1px solid #9C9C9C;
}

#login .container #login-row #login-column #login-box #login-form {
	padding: 20px;
}

#login .container #login-row #login-column #login-box #login-form #register-link
	{
	margin-top: -85px;
}

.text-info {
	color: #007d7d !important;
}
</style>
</head>
<body>
	<div id="login">
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" name="login" class="form" action="login"
							method="post">
							<h3 class="text-center text-info">Login</h3>
							<hr>
							<c:if test="${not empty errorMessge}">
								<div class="alert alert-danger" role="alert">
									${errorMessge}</div>
							</c:if>
							<div class="form-group">
								<label for="username" class="text-info">帳號：</label> <input
									type="text" name="username" id="username"
									placeholder="userId@tlg-insurance.com" class="form-control" autofocus>
							</div>
							<div class="form-group">
								<label for="password" class="text-info">密碼：</label> <input
									type="text" name="password" id="password" class="form-control ">
							</div>
							<hr>
							<div class="form-group row">
								<input type="submit" name="submit"
									class="btn btn-info btn-lg btn-block" value="submit">
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		(function() {
			document.form.username.focus();
		})();
	</script>
</body>
</html>