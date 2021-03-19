<%@page import="com.manager.store.entity.ProductRequisition"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<!-- Begin Page Content -->

<%
	ProductRequisition productRequisition = (ProductRequisition) session.getAttribute("requisitionInfo");
%>
<div class="container-fluid">

	<div class="card o-hidden border-0 shadow-lg my-5">
		<div class="card-body p-0 d-flex justify-content-center">
			<!-- Nested Row within Card Body -->
			<div class="row w-75">

				<div class="col-md-12 ">
					<div class="p-5">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">Product Requisition</h1>
						</div>

						<div class="row my-1">
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="requistionNo">Requisition No</label></span>
									</div>
									<input id="requistionNo" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm"
										value="<%=productRequisition.getRequisitionNo()%>"
										readonly="readonly">

								</div>
							</div>

							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="ticketId">Ticket Id</label></span>
									</div>
									<input id="ticketId" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm"
										value="<%=productRequisition.getTicketId()%>"
										readonly="readonly">
								</div>
							</div>
						</div>
						<div class="row my-1">
							<%-- <div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="productName">Product Name</label></span>
									</div>
									<select id="productName" class="form-control selectpicker"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm"
										data-live-search="true"
										data-style="btn-light btn-sm border-secondary form-control-sm">
										<option value="0">Select Resource</option>
										<c:forEach items="${productList}" var="product">
											<option value="${product.id}">${product.productName}</option>
										</c:forEach>
									</select>
								</div>
							</div> --%>

							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="requistionDate">Requisition Date</label></span>
									</div>
									<input id="requistionDate" type="date" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm"
										value="<%=productRequisition.getRequisitionDate()%>">
								</div>
							</div>

						</div>
						<%-- <div class="row my-1">
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="quantity">Quantity</label></span>
									</div>
									<input id="quantity" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm">
								</div>
							</div>
						</div> --%>

						<!-- <div class="row my-1">
							<div class="col-md-12 ">
								<button type="button" id="btnAdd" class="btn btn-primary btn-sm"
									onclick="addAction()">Add</button>

								<button type="button" id="btnEdit"
									class="btn btn-success btn-sm" onclick="editAction()"
									style="display: none;">Edit</button>
								<button type="button" id="btnRefresh"
									class="btn btn-secondary btn-sm" onclick="refreshAction()">Refresh</button>

							</div>

						</div> -->

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

						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12"
								style="overflow: auto; max-height: 400px;">
								<table class="table table-hover table-bordered table-sm">
									<thead>
										<tr>
											<th>SL</th>
											<th>Product Name</th>
											<th>Quantity</th>
											<th>Description</th>
										</tr>
									</thead>
									<tbody id="prductList">
										<c:forEach items="${productList}" var="product"
											varStatus="counter">
											<tr style="cursor: pointer;"
												onclick="setCustomerData('${product.id}')">
												<td>${counter.count}</td>
												<td>${product.productName}</td>
												<td>${product.quantity}</td>
												<td>${product.description }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class='col-md-6'>
								<button type="button" onclick="approvedRequisition()"
									class="btn btn-primary btn-user btn-block">Approved</button>
							</div>
							<div class='col-md-6'>
								<button type="button" onclick="notApprovedRequisition()"
									class="btn btn-primary btn-user btn-block">Not
									Approved</button>
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
	src="${pageContext.request.contextPath}/js/store/product-requisition-info.js"></script>
