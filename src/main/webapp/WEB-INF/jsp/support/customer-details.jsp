
<%@page import="com.manager.example.shareModel.ConnectionStatus"%>
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
		<input type="hidden" id="pppoeAutoId" value="0">
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
							<!-- <button type="button" class="btn btn-primary mt-2"
								onclick="newClickAction()" data-toggle="modal"
								data-target="#exampleModal">New MC</button> 
							<hr>-->
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12 px-2"
									style="overflow: auto;">
									<table id="customerDetailsTable"
										class="table table-hover table-bordered table-sm">
										<thead>
											<tr>
												<th>SL</th>
												<th>Customer Id</th>
												<th>Customer Name</th>
												<th>Connection Point</th>
												<th>IP Address</th>
												<th>ONU Mac</th>
												<th>ONU Interface</th>
												<th>Status</th>
												<th>Edit</th>
											</tr>
										</thead>
										<tbody id="customerDetailsList">
											<c:forEach items="${customerList}" var="customer"
												varStatus="counter">
												<tr>
													<td>${counter.count}</td>
													<td id="customerId-${customer.id}">${customer.customerId}</td>
													<td id="customerName-${customer.id}">${customer.name }</td>
													<td>${customer.connectionPoint }</td>
													<td>${customer.ipAddress }</td>
													<td>${customer.onuMac }</td>
													<td>${customer.onuInterface }</td>
													<td>${customer.connectionStatus }</td>
													<td><i class="fa fa-edit" style="cursor: pointer;"
														onclick="setCustomerData('${customer.customerId}')"> </i></td>
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
				<h5 class="modal-title">
					<b>Customer Connection Details</b>
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" onclick="">
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
											class='my-0' for="customerId">Customer Id</label></span>
									</div>
									<input id="customerId" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" readonly>
								</div>
							</div>
						</div>
						<div class="row my-1">
							<div class='col-md-12'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="connectionPoint">Connection Point</label></span>
									</div>
									<select id="connectionPoint" class="form-control selectpicker"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm"
										data-live-search="true"
										data-style="btn-light btn-sm border-secondary form-control-sm">
										<option value="0">Select Connection Point</option>
										<c:forEach items="${connectionPointList}" var="connection">
											<option value="${connection.id}">${connection.connectionPointName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="row my-1">
							<div class='col-md-12 px-1'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="ipAddress">IP Address</label></span>
									</div>
									<input id="ipAddress" type="text" class="form-control"
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
											class='my-0' for="onuMac">ONU/MAC</label></span>
									</div>
									<input id="onuMac" type="text" class="form-control"
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
											class='my-0' for="onuInterface">ONU Interface</label></span>
									</div>
									<input id="onuInterface" type="text" class="form-control"
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
											class='my-0' for="clientMac">Client MAC</label></span>
									</div>
									<input id="clientMac" type="text" class="form-control"
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
											class='my-0' for="latLong">Lat Long</label></span>
									</div>
									<input id="latLong" type="text" class="form-control"
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
											class='my-0' for="connectionStatus">Active Status</label></span>
									</div>
									<select class="form-control" id="connectionStatus">

										<%
												for (ConnectionStatus connection : ConnectionStatus.values()) {
											%>

										<option value="<%=connection.name()%>"><%=connection.name()%></option>
										<%
												}
											%>
									</select>
								</div>
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

				<button type="button" id="btnSave" class="btn btn-primary btn-sm"
					onclick="saveAction()">
					<i class="fas fa-save"></i> Save
				</button>

				<button type="button" id="btnEdit" class="btn btn-success btn-sm"
					onclick="editAction()" style="display: none;">
					<i class="fa fa-pencil-square"></i> Edit
				</button>
				<button type="button" id="btnRefresh"
					class="btn btn-secondary btn-sm" onclick="refreshAction()">Refresh</button>

			</div>
		</div>
	</div>
</div>

<!-- /.container-fluid -->
<jsp:include page="../include/footer.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/support/customer-details.js"></script>
