<%@page import="com.manager.example.shareModel.ResellerType"%>
<%@page import="com.manager.example.shareModel.CustomerType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<!-- Begin Page Content -->

<div class="container-fluid">

	<div class="content container-fluid">
		<div class="alert alert-success alert-dismissible fade show"
			style="display: none;">
			<p id="successAlert" class="mb-0">
				<strong>Success!</strong> Brand Name Save Successfully..
			</p>
		</div>
		<div class="alert alert-warning alert-dismissible fade show"
			style="display: none;">
			<p id="warningAlert" class="mb-0">
				<strong>Warning!</strong> Brand Name Empty.Please Enter Brand
				Name...
			</p>
		</div>
		<div class="alert alert-danger alert-dismissible fade show"
			style="display: none;">
			<p id="dangerAlert" class="mb-0">
				<strong>Wrong!</strong> Something Wrong...
			</p>
		</div>
		<input type="hidden" id="resellerAutoId" value="0">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12  px-0">
				<div class="card-box">
					<div class="row">
						
						<div class="col-sm-12 col-md-12 col-lg-12 shadow ">
							<!-- <div class="input-group my-2">
								<input type="text" class="form-control"
									placeholder="Search User" aria-describedby="findButton"
									id="search" name="search">
								<div class="input-group-append">
									<button class="btn btn-primary" type="button" id="findButton">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div> -->
							<button type="button" class="btn btn-primary mt-2" onclick="newClickAction()" data-toggle="modal" data-target="#exampleModal">New Reseller</button>
							<hr>
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12 px-2"
									style="overflow: auto;">
									<table id="resellerInfoTable" class="table table-hover table-bordered table-sm">
										<thead>
											<tr>
												<th>Reseller Id</th>
												<th>Reseller Name</th>
												<th>Reseller Address</th>
												<th>Public IP</th>
												<th>SCR No</th>
												<th>Mikrotik Username</th>
												<th>Internet Bandwidth</th>
												<th>Monthly Payment</th>
											</tr>
										</thead>
										<tbody id="resellerList">
											<c:forEach items="${resellerList}" var="reseller"
												varStatus="counter">
												<tr style="cursor: pointer;"
													onclick="setResellerData('${reseller.id}')">
													<td>${reseller.resellerId}</td>
													<td>${reseller.name}</td>
													<td>${reseller.address }</td>
													<td>${reseller.publicIp }</td>
													<td>${reseller.scrNo }</td>
													<td>${reseller.mikrotikUserName}</td>
													<td>${reseller.internetBandwidth }</td>
													<td>${reseller.monthlyPayment }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>

							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div
		class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title"><b>Reseller Create</b></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" onclick="resourceModalCloseAction()">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="resellerId">Reseller ID</label></span>
										</div>
										<input id="resellerId" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" value="${maxId }"
											readonly>
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="resellerName">Reseller Name</label></span>
										</div>
										<input id="resellerName" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>

							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="address">Address</label></span>
										</div>
										<textarea id="address" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm"></textarea>
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="publicIp">Public IP</label></span>
										</div>
										<input id="publicIp" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="scrNo">SCR No</label></span>
										</div>
										<input id="scrNo" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>



							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="email">Email</label></span>
										</div>
										<input id="email" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="contactNo">Contact No</label></span>
										</div>
										<input id="contactNo" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>

							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="mikrotikUserName">Mikrotik User
													Name</label></span>
										</div>
										<input id="mikrotikUserName" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>

							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="mikrotikPassword">Mikrotik
													Password</label></span>
										</div>
										<input id="mikrotikPassword" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>

							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="internetBandwidth">Internet
													Bandwidth</label></span>
										</div>
										<input id="internetBandwidth" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>

							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="facebookBandwidth">Facebook
													Bandwidth</label></span>
										</div>
										<input id="facebookBandwidth" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>

							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="youtubeBandwidth">Youtube
													Bandwidth</label></span>
										</div>
										<input id="youtubeBandwidth" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>

							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="bdixBandwidth">BDIX Bandwidth</label></span>
										</div>
										<input id="bdixBandwidth" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>

							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="monthlyPayment">Monthly Payment</label></span>
										</div>
										<input id="monthlyPayment" type="number" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
							</div>

							<div class="row my-1">
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="activeStatus">Active Status</label></span>
										</div>
										<select class="form-control" id="activeStatus">
											<option value="1">Active</option>
											<option value="0">Inactive</option>
										</select>
									</div>
								</div>
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="serviceStartDate">Ser. S.Date</label></span>
										</div>
										<input type="date" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" id="serviceStartDate" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									
								</div>
							</div>
						</div>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary btn-sm"
					data-dismiss="modal" onclick="">
					<i class="fa fa-close"></i> Close
				</button>
				
				<button type="button" id="btnSave"
										class="btn btn-primary btn-sm" onclick="saveAction()"><i class="fas fa-save"></i> Save</button>

									<button type="button" id="btnEdit"
										class="btn btn-success btn-sm" onclick="editAction()"
										style="display: none;"><i class="fa fa-pencil-square"></i> Edit</button>
									<button type="button" id="btnRefresh"
										class="btn btn-secondary btn-sm" onclick="refreshAction()">Refresh</button>
				
			</div>
		</div>
	</div>
</div>

<!-- /.container-fluid -->
<jsp:include page="../include/footer.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/inventory/reseller-info.js"></script>
