<%@page import="com.manager.example.shareModel.Priority"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<!-- Begin Page Content -->

<div class="container-fluid">

	<div class="card-body">
		<div class="row my-1">
			<h5>Product Requisition List</h5>
		</div>
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link active" id="pending-tab" data-toggle="tab" href="#pending"
				role="tab" aria-controls="pending" aria-selected="true">Pending</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="approved-tab" data-toggle="tab" href="#approved" role="tab"
				aria-controls="approved" aria-selected="false">Approved</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="not-approved-tab" data-toggle="tab" href="#not-approved" role="tab"
				aria-controls="not-approved" aria-selected="false">Not Approved</a></li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="pending" role="tabpanel"
				aria-labelledby="pending-tab">
				<div class="table-responsive">
					<table class="table table-bordered" id="pendingDataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Requisition No</th>
								<th>Requisition Date</th>
								<th>Ticket ID</th>
								<th>Product Quantity</th>
								<th>Create By</th>
								<th>View</th>
							</tr>
						</thead>
						<tbody id="pendingDataBody">
						<c:forEach items="${pendingRequisitionList}" var="requisition">
							<tr>
								<th>${requisition.requisitionNo}</th>
								<th>${requisition.requisitionDate}</th>
								<th><a href="" onclick='viewTicket("${requisition.ticketId}",event)'>${requisition.ticketId}</a></th>
								<th>${requisition.productQuantity}</th>
								<th>${requisition.createdBy}</th>
								<th><a href=""  onclick='viewRequisition("${requisition.requisitionNo}",event)'><i class='fa fa-eye'></i>View</a></th>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="tab-pane fade" id="approved" role="tabpanel"
				aria-labelledby="approved-tab">
				<div class="table-responsive">
					<table class="table table-bordered" id="approvedDataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Requisition No</th>
								<th>Requisition Date</th>
								<th>Ticket ID</th>
								<th>Product Quantity</th>
								<th>Create By</th>
								<th>Approved By</th>
								<th>View</th>
							</tr>
						</thead>
						<tbody id="approvedDataBody">
							<c:forEach items="${approvedRequisitionList}" var="requisition">
							<tr>
								<th>${requisition.requisitionNo}</th>
								<th>${requisition.requisitionDate}</th>
								<th><a href="" onclick='viewTicket("${requisition.ticketId}",event)'>${requisition.ticketId}</a></th>
								<th>${requisition.productQuantity}</th>
								<th>${requisition.createdBy}</th>
								<th>${requisition.approvedBy}</th>
								<th><a href=""  onclick='viewApprovedRequisition("${requisition.requisitionNo}",event)'><i class='fa fa-eye'></i>View</a></th>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="tab-pane fade" id="not-approved" role="tabpanel"
				aria-labelledby="not-approved-tab">
				<div class="table-responsive">
					<table class="table table-bordered" id="notApprovedDataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Requisition No</th>
								<th>Requisition Date</th>
								<th>Ticket ID</th>
								<th>Product Quantity</th>
								<th>Create By</th>
								<th>Rejected By</th>
								<th>View</th>
							</tr>
						</thead>
						<tbody id="notApprovedDataBody">
							<c:forEach items="${notApprovedRequisitionList}" var="requisition">
							<tr>
								<th>${requisition.requisitionNo}</th>
								<th>${requisition.requisitionDate}</th>
								<th><a href="" onclick='viewTicket("${requisition.ticketId}",event)'>${requisition.ticketId}</a></th>
								<th>${requisition.productQuantity}</th>
								<th>${requisition.createdBy}</th>
								<th>${requisition.approvedBy}</th>
								<th><a href=""  onclick='viewRequisition("${requisition.requisitionNo}",event)'><i class='fa fa-eye'></i>View</a></th>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>

</div>

<!-- /.container-fluid -->
<jsp:include page="../include/footer.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/store/requisition-product-list.js"></script>
