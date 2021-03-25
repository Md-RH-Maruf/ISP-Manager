<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<!-- Begin Page Content -->

<div class="container-fluid">

	<div class="card o-hidden border-0 shadow-lg my-5">
		<div class="card-body p-0 d-flex justify-content-center">
			<!-- Nested Row within Card Body -->
			<div class="row w-75">
				<input type="hidden" id="rowId" value="0">
				<input type="hidden" id="transactionType" value="0">
				
				<div class="col-md-12 ">
					<div class="p-5">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">Cash Transaction</h1>
						</div>
						<div class="row my-1">
							<div class="col-md-6">
								<button id="paymentBtn" class="btn btn-sm btn-info" onclick="paymentBtnClickAction()">Payment</button>
							</div>
							<div class="col-md-6">
								<button id="receiveBtn" class="btn btn-sm btn-info" onclick="receiveBtnClickAction()">Receive</button>
							</div>
						</div>
						<div class="row my-1">
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="transactionId">Transaction Id</label></span>
									</div>
									<input id="billNo" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" value="${maxId}" readonly="readonly">
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
										aria-describedby="inputGroup-sizing-sm" disabled="disabled">
								</div>
							</div>
						</div>
						<div class="row my-1">
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="billLedger">Bill Ledger</label></span>
									</div>
									<select id="billLedger" class="form-control selectpicker"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm"
										data-live-search="true"
										data-style="btn-light btn-sm border-secondary form-control-sm" disabled="disabled">
										<option value="0">Select Ledger</option>
										<c:forEach items="${ledgerList}" var="ledger">
														<option value="${ledger.id}">${ledger.ledgerName}</option>
													</c:forEach>
									</select>
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
										aria-describedby="inputGroup-sizing-sm" disabled="disabled">
								</div>
							</div>

						</div>

						<div class="row my-1">

							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="billAmount">Bill Amount</label></span>
									</div>
									<input id="billAmount" type="number" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" disabled="disabled">
								</div>
							</div>
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="receiverTakenFrom">Receiver/Taken
												From</label></span>
									</div>
									<input id="receiverTakenFrom" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" disabled="disabled">
								</div>
							</div>


						</div>
						<div class="row my-1">
							<div class='col-md-6'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="description">Description</label></span>
									</div>
									<textarea id="description" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" disabled="disabled"></textarea>
								</div>
							</div>
							<div class="col-md-6 ">
								<button type="button" id="btnAdd" class="btn btn-primary btn-sm"
									onclick="addAction()" disabled="disabled">Add</button>

								<button type="button" id="btnEdit"
									class="btn btn-success btn-sm" onclick="editAction()"
									style="display: none;">Edit</button>
								<button type="button" id="btnRefresh"
									class="btn btn-secondary btn-sm" onclick="refreshAction()">Refresh</button>

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
										<c:forEach items="${customerList}" var="ledger"
											varStatus="counter">
											<tr style="cursor: pointer;"
												onclick="setCustomerData('${ledger.id}')">
												<td>${ledger.customerId}</td>
												<td>${ledger.name}</td>
												<td>${ledger.customerType }</td>
												<td>${ledger.status }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<button type="button" onclick="completeTransaction()"
							class="btn btn-primary btn-user btn-block">Complete
							Transaction</button>

					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<!-- /.container-fluid -->
<jsp:include page="../include/footer.jsp" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/accounts/cash-transaction.js"></script>
