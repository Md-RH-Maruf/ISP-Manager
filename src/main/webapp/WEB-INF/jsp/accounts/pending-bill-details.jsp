<%@page import="com.manager.accounts.entity.Bill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<!-- Begin Page Content -->

<%
	Bill bill = (Bill)session.getAttribute("billInfo");
	String createdBy = session.getAttribute("createdBy").toString();
%>
<div class="container-fluid">
	
	<div class="card o-hidden border-0 shadow-lg my-5">
		<div class="card-body p-0 d-flex justify-content-center">
			<!-- Nested Row within Card Body -->
			<div class="row w-75">

				<div class="col-md-12 ">
					<div class="p-5">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">Pending Bill</h1>
						</div>
						
						<div class="row my-1">
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="billNo">Bill No</label></span>
									</div>
									<input id="billNo" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" value="<%=bill.getBillNo() %>" readonly="readonly">
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
										aria-describedby="inputGroup-sizing-sm" value="<%=bill.getTicketId()%>" readonly="readonly">
								</div>
							</div>
						</div>
						<div class="row my-1">						
							
										<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="createdBy">Created By</label></span>
									</div>
									<input id="createdBy" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" value="<%=createdBy%>" readonly="readonly">
								</div>
							</div>
										<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="billDate">Bill Date</label></span>
									</div>
									<input id="billDate" type="date" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" value=<%=bill.getBillDate() %>>
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
						
						<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12"
									style="overflow: auto; max-height: 400px;">
									<table class="table table-hover table-bordered table-sm">
										<thead>
											<tr>
												<th>SL</th>
												<th>Ledger Name</th>
												<th>Amount</th>
												<th>Description</th>
											</tr>
										</thead>
										<tbody id="ledgerList">
											<c:forEach items="${billDetails}" var="ledger"
												varStatus="counter">
												<tr>
													<td>${counter.count}</td>
													<td>${ledger.debitLedger}</td>
													<td>${ledger.amount }</td>
													<td>${ledger.description }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							
							<div class="row my-1">						
							
										<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="totalAmount">Total Amount</label></span>
									</div>
									<input id="totalAmount" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" value=<%=bill.getTotalAmount()%> readonly="readonly">
								</div>
							</div>
										<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="approveAmount">Approve Amount</label></span>
									</div>
									<input id="approveAmount" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" value=<%=bill.getTotalAmount()%> >
								</div>
							</div>
										
						</div>
						
						<div class="row my-1">
						
							<div class="col-md-6">
							<button type="button" onclick="approveBill()"
							class="btn btn-primary btn-user btn-block">Approve
							Bill</button>
							</div>
							<div class="col-md-6">
							<button type="button" 
							class="btn btn-danger btn-user btn-block" data-toggle="modal" data-target="#exampleModal">Reject
							Bill</button>
							</div>
							
							
							
						</div>
						

					</div>
				</div>
			</div>
		</div>
	</div>

</div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Rejected Cause</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <textarea id="rejectedCause" class='form-control w-100' placeholder="Enter Cause of reject"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn  btn-sm btn-danger" onclick="rejectBill()">Reject</button>
      </div>
    </div>
  </div>
</div>
<!-- /.container-fluid -->
<jsp:include page="../include/footer.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/accounts/pending-bill-details.js"></script>
