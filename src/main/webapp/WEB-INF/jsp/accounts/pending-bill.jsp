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
			<!-- <button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#exampleModal">New Ticket</button> -->
				<h5>Pending Bill</h5>
		</div>
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Bill NO</th>
						<th>Bill Date</th>
						<th>Created By</th>
						<th>Ticked Id</th>
						<th>Bill Head</th>
						<th>Description</th>
						<th>Total Amount</th>
						<th>Bill Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody id="dataBody">
					<c:forEach items="${billList}" var="bill" varStatus="counter">
												<tr>

													<td>${bill.billNo}</td>
													<td>${bill.billDate}</td>
													<td>${bill.createdBy}</td>
													<td>${bill.ticketId}</td>
													<td>${bill.billHead}</td>
													<td>${bill.description}</td>
													<td>${bill.totalAmount}</td>
													<td>Pending</td>
													<th><a href="" onclick="viewBillDetails('${bill.billNo}',event)">Action</a></th>
												</tr>
											</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>

</div>

<!-- /.container-fluid -->
<jsp:include page="../include/footer.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/accounts/pending-bill.js"></script>
