<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>ISP Center Register</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
							</div>
							<form class="user">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="memberId" placeholder="Customer or Employee Id"
											required="required">
									</div>
									<div class="col-sm-6">
										<select class="form-control" id="memberType"
											required="required">
											<option value="1">Customer</option>
											<option value="2">Employee</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="userName" placeholder="User Name" required="required">
									</div>
								</div>
								
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user"
											id="password" placeholder="Password" required="required">
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user"
											id="repeatPassword" placeholder="Repeat Password"
											required="required">
									</div>
								</div>
								<div class="alert alert-success alert-dismissible fade show"
									style="display: none;">
									<p id="successAlert" class="mb-0">
										<strong>Success!</strong> Unit Name Save Successfully..
									</p>
								</div>
								<div class="alert alert-warning alert-dismissible fade show"
									style="display: none;">
									<p id="warningAlert" class="mb-0">
										<strong>Warning!</strong> Unit Name Empty.Please Enter Unit
										Name...
									</p>
								</div>
								<div class="alert alert-danger alert-dismissible fade show"
									style="display: none;">
									<p id="dangerAlert" class="mb-0">
										<strong>Wrong!</strong> Something Wrong...
									</p>
								</div>
								<button type="button" onclick="register()"
									class="btn btn-primary btn-user btn-block"> Register
									Account </button>
								<!-- <hr>
								<a href="dashboard" class="btn btn-google btn-user btn-block">
									<i class="fab fa-google fa-fw"></i> Register with Google
								</a> <a href="dashboard" class="btn btn-facebook btn-user btn-block">
									<i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
								</a> -->
							</form>
							<hr>
							<div class="text-center">
								<a class="small" href="${pageContext.request.contextPath}/forgot-password">Forgot Password?</a>
							</div>
							<div class="text-center">
								<a class="small" href="${pageContext.request.contextPath}/login">Already have an account?
									Login!</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>
	<script src="js/common/alert.js"></script>
	<script src="js/profile/register.js"></script>

</body>

</html>