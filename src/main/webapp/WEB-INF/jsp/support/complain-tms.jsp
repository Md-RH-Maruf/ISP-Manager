<%@page import="com.manager.example.shareModel.ComplainType"%>
<%@page import="com.manager.example.shareModel.Priority"%>
<%@page import="com.manager.example.shareModel.Packages"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<!-- Begin Page Content -->

<div class="container">

	<div class="card o-hidden border-0 shadow-lg my-5">
		<div class="card-body p-0 d-flex justify-content-center">
			<!-- Nested Row within Card Body -->
			<div class="row w-75">

				<div class="col-md-12 ">
					<div class="p-5">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">Complain TMS</h1>
						</div>

						<div class="row my-1">
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="customerId">Customer Id</label></span>
									</div>
									<input id="customerId" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" value="CM-2021034">
									<div class="input-group-append">
										<button class="btn btn-primary" type="button" onclick="searchAction()">
											<i class="fas fa-search fa-sm"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<hr class="mt-1">
						<div class="row my-1">
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="customerName">Customer Name</label></span>
									</div>
									<input id="customerName" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm">

								</div>
							</div>

							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="contactNumber">Contact Number</label></span>
									</div>
									<input id="contactNumber" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm">

								</div>
							</div>
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="area">Area</label></span>
									</div>
									<input id="area" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm">

								</div>
							</div>

							<div class='col-md-6'>
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
							<div class="col-xl-3 col-md-3 ">
								<div class="card border-left-primary shadow py-0">
									<div class="card-body p-1">
										<div
											class="text-xs font-weight-bold text-primary text-uppercase mb-1">
											Present Ticket</div>
										<div class="mb-0 font-weight-bold">
											<strong><span id="presentTicket">0</span></strong>
										</div>
									</div>

								</div>
							</div>

							<div class="col-xl-3 col-md-3 ">
								<div class="card border-left-primary shadow py-0">
									<div class="card-body p-1">
										<div
											class="text-xs font-weight-bold text-primary text-uppercase mb-1">
											Total Complain</div>
										<div class="mb-0 font-weight-bold">
											<strong><span id="presentTicket">0</span></strong>
										</div>
									</div>

								</div>
							</div>

							<div class="col-xl-3 col-md-3 ">
								<div class="card border-left-primary shadow py-0">
									<div class="card-body p-1">
										<div
											class="text-xs font-weight-bold text-primary text-uppercase mb-1">
											Fiber Ticket</div>
										<div class="mb-0 font-weight-bold">
											<strong><span id="presentTicket">0</span></strong>
										</div>
									</div>

								</div>
							</div>

							<div class="col-xl-3 col-md-3 ">
								<div class="card border-left-primary shadow py-0">
									<div class="card-body p-1">
										<div
											class="text-xs font-weight-bold text-primary text-uppercase mb-1">
											internet Ticket</div>
										<div class="mb-0 font-weight-bold">
											<strong><span id="presentTicket">0</span></strong>
										</div>
									</div>

								</div>
							</div>

							<div class="col-xl-3 col-md-3 ">
								<div class="card border-left-primary shadow py-0">
									<div class="card-body p-1">
										<div
											class="text-xs font-weight-bold text-primary text-uppercase mb-1">
											Slow Ticket</div>
										<div class="mb-0 font-weight-bold">
											<strong><span id="presentTicket">0</span></strong>
										</div>
									</div>

								</div>
							</div>

							<div class="col-xl-3 col-md-3 ">
								<div class="card border-left-primary shadow py-0">
									<div class="card-body p-1">
										<div
											class="text-xs font-weight-bold text-primary text-uppercase mb-1">
											Last Month Ticket</div>
										<div class="mb-0 font-weight-bold">
											<strong><span id="presentTicket">0</span></strong>
										</div>
									</div>

								</div>
							</div>
						</div>


						<div class="row my-1">
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="accountStatus">Account Status</label></span>
									</div>
									<input id="accountStatus" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" readonly>

								</div>
							</div>
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="connectionStatus">Connection Status</label></span>
									</div>
									<input id="connectionStatus" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" readonly>

								</div>
							</div>
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="problemType">problem Type</label></span>
									</div>
									<select class="form-control" id="problemType">
										<%
											for (ComplainType complain : ComplainType.values()) {
										%>

										<option value="<%=complain.getType()%>"><%=complain.name()%></option>
										<%
											}
										%>
									</select>

								</div>
							</div>
							
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="priority">Priority</label></span>
									</div>
									<select class="form-control" id="priority">
										<%
											for (Priority priority : Priority.values()) {
										%>

										<option value="<%=priority.getType()%>"><%=priority.name()%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							
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
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div
		class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Resources</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" onclick="resourceModalCloseAction()">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">

				<div class="row">
					<div class="col-md-12">

						<div class="input-group">
							<input id="resourceName" type="text" aria-label="First name"
								class="form-control" placeholder="*Resource Name"> <input
								id="resourceLink" type="text" aria-label="Last name"
								class="form-control" placeholder="*Resource Link">
						</div>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-12">
						<table class="table table-hover table-bordered table-sm">
							<thead>
								<tr>
									<th>Resource Name</th>
									<th>Resource Link</th>
									<th><i class="fa fa-edit"> </i></th>
								</tr>
							</thead>
							<tbody id="resourceTableList">
								<c:forEach items="${resourceList}" var="resource"
									varStatus="counter">
									<tr>
										<td id='resourceName${resource.id}'>${resource.resourceName}</td>
										<td id='resourceLink${resource.id}'>${resource.resourceLink}</td>
										<td><i class="fa fa-edit"
											onclick="setResourceData(${resource.id})"> </i></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary btn-sm"
					data-dismiss="modal" onclick="resourceModalCloseAction()">
					<i class="fa fa-close"></i> Close
				</button>
				<button type="button" id="btnResourceSave"
					class="btn btn-primary btn-sm" onclick="resourceSaveAction()">
					<i class="fas fa-save"></i> Save as Resource
				</button>
				<button type="button" id="btnResourceEdit"
					class="btn btn-success btn-sm" onclick="resourceEditAction()"
					style="display: none;">
					<i class="fa fa-pencil-square"></i> Edit Resource Name
				</button>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->
<jsp:include page="../include/footer.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/support/complain-tms.js"></script>
