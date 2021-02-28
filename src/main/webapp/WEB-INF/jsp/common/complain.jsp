<%@page import="com.manager.example.shareModel.Packages"%>
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

<title>Complain</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.css" rel="stylesheet" type="text/css">
</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0 d-flex justify-content-center">
				<!-- Nested Row within Card Body -->
				<div class="row w-75">

					<div class="col-md-12 ">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Complain</h1>
							</div>

							<div class="row my-1">
								<div class='col-md-6'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="applicantName">Customer Id</label></span>
										</div>
										<input id="applicantName" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
								<div class='col-md-6'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="problemType">problem Type</label></span>
										</div>
										<select id="problemType" class="form-control selectpicker"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm"
											data-live-search="true"
											data-style="btn-light btn-sm border-secondary form-control-sm">
											<option value="0">Select Buyer</option>
											<c:forEach items="${buyerList}" var="buyer">
												<option value="${buyer.buyerid}">${buyer.buyername}</option>
											</c:forEach>
										</select>

									</div>
								</div>

							</div>
							

							<div class="row my-1">
								<div class='col-md-6'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="complainDetails">Complain Details</label></span>
										</div>
										<textarea id="complainDetails" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm"></textarea>
									</div>
								</div>
								<%-- <div class='col-md-6'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="package">Package</label></span>
										</div>
										<select class="form-control" id="package">
											<%
												for (Packages pkg : Packages.values()) {
											%>

											<option value="<%=pkg.getType()%>"><%=pkg.name()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div> --%>
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
							<button type="button" onclick="submitComplain()"
								class="btn btn-primary btn-user btn-block">Submit
								Complain</button>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="${pageContext.request.contextPath}/js/sb-admin-2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/common/alert.js"></script>
	<script src="${pageContext.request.contextPath}/js/common/requestForConnection.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
</body>

</html>