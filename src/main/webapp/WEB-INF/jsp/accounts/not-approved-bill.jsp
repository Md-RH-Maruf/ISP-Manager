<%@page import="com.manager.example.shareModel.Priority"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<!-- Begin Page Content -->

<div class="container-fluid">

	<div class="card-body">
		<div class="row">
		<h5>Not Approved Bill</h5>
			<!-- <button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#exampleModal">New Ticket</button> -->
		</div>
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Bill NO</th>
						<th>Create By</th>
						<th>Bill Date</th>
						<th>Ticket Id</th>
						<th>Bill Head</th>
						<th>Total Amount</th>
						<th>Rejected Cause</th>
						<th>Reject By</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody id="dataBody">
<c:forEach items="${billList}" var="bill" varStatus="counter">
												<tr>

													<td>${bill.billNo}</td>
													<td>${bill.createdBy}</td>
													<td>${bill.billDate}</td>
													<td>${bill.ticketId}</td>
													<td>${bill.billHead}</td>
													<td>${bill.totalAmount}</td>
													<td>${bill.rejectedCause}</td>
													<td>${bill.rejectedBy}</td>
													<th><a href="" onclick="viewBillDetails('${bill.billNo}',event)">Action</a></th>
												</tr>
											</c:forEach>
				</tbody>
			</table>
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
					aria-label="Close" >
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="new-connection-tab" data-toggle="tab"
						href="#newConnection" role="tab" aria-controls="new connection"
						aria-selected="true">New Connection</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="complain-tab" data-toggle="tab" href="#complain" role="tab"
						aria-controls="complain" aria-selected="false">Complain</a></li>

				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="newConnection"
						role="tabpanel" aria-labelledby="new-connection-tab">
						<div class="row">

							<div class="col-md-12 ">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Activation TMS</h1>
									</div>

									<div class="row my-1">
										<div class='col-md-6'>
											<div class="input-group input-group-sm mb-1">
												<div class="input-group-prepend">
													<span class="input-group-text" id="inputGroup-sizing-sm"><label
														class='my-0' for="newCustomerName">Customer Name</label></span>
												</div>
												<input id="newCustomerName" type="text" class="form-control"
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
												<select id="area" class="form-control selectpicker"
													aria-label="Sizing example input"
													aria-describedby="inputGroup-sizing-sm"
													data-live-search="true"
													data-style="btn-light btn-sm border-secondary form-control-sm">
													<option value="0">Select Area</option>
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
														class='my-0' for="contactPerson">Contact Person</label></span>
												</div>
												<input id="contactPerson" type="text" class="form-control"
													aria-label="Sizing example input"
													aria-describedby="inputGroup-sizing-sm">
											</div>
										</div>
										<div class='col-md-6'>
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
										<div class='col-md-6'>
											<div class="input-group input-group-sm mb-1">
												<div class="input-group-prepend">
													<span class="input-group-text" id="inputGroup-sizing-sm"><label
														class='my-0' for="package">Package</label></span>
												</div>
												<select class="form-control" id="package">

												</select>
											</div>
										</div>
										<div class='col-md-6'>
											<div class="input-group input-group-sm mb-1">
												<div class="input-group-prepend">
													<span class="input-group-text" id="inputGroup-sizing-sm"><label
														class='my-0' for="otc">OTC</label></span>
												</div>
												<input id="otc" type="text" class="form-control"
													aria-label="Sizing example input"
													aria-describedby="inputGroup-sizing-sm">
											</div>
										</div>
									</div>
									<div class="row my-1">
										<div class='col-md-6'>
											<div class="input-group input-group-sm mb-1">
												<div class="input-group-prepend">
													<span class="input-group-text" id="inputGroup-sizing-sm"><label
														class='my-0' for="mrc">MRC</label></span>
												</div>
												<input id="mrc" type="text" class="form-control"
													aria-label="Sizing example input"
													aria-describedby="inputGroup-sizing-sm">
											</div>
										</div>
										<div class='col-md-6'>
											<div class="input-group input-group-sm mb-1">
												<div class="input-group-prepend">
													<span class="input-group-text" id="inputGroup-sizing-sm"><label
														class='my-0' for="promiseDate">Promise Date</label></span>
												</div>
												<input id="promiseDate" type="date" class="form-control"
													aria-label="Sizing example input"
													aria-describedby="inputGroup-sizing-sm">
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
									<button type="button" onclick="submitRequest()"
										class="btn btn-primary btn-user btn-block">Submit TMS</button>

								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="complain" role="tabpanel"
						aria-labelledby="complain-tab">
						<div class="row">

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
													aria-describedby="inputGroup-sizing-sm">
												<div class="input-group-append">
													<button class="btn btn-primary" type="button">
														<i class="fas fa-search fa-sm"></i>
													</button>
												</div>
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
														class='my-0' for="area">Area</label></span>
												</div>
												<input id="area" type="text" class="form-control"
													aria-label="Sizing example input"
													aria-describedby="inputGroup-sizing-sm">

											</div>
										</div>
									</div>
									<div class="row my-1">
										<div class='col-md-6'>
											<div class="input-group input-group-sm mb-1">
												<div class="input-group-prepend">
													<span class="input-group-text" id="inputGroup-sizing-sm"><label
														class='my-0' for="complainDetails">Complain
															Details</label></span>
												</div>
												<textarea id="complainDetails" type="text"
													class="form-control" aria-label="Sizing example input"
													aria-describedby="inputGroup-sizing-sm"></textarea>
											</div>
										</div>
										<div class='col-md-6'>
											<div class="input-group input-group-sm mb-1">
												<div class="input-group-prepend">
													<span class="input-group-text" id="inputGroup-sizing-sm"><label
														class='my-0' for="priority">Priority</label></span>
												</div>
												<select class="form-control" id="package">
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

		</div>
	</div>
</div>
<!-- /.container-fluid -->
<jsp:include page="../include/footer.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/support/tms-report-list.js"></script>
