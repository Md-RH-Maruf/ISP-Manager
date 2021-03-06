
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
		<input type="hidden" id="mcAutoId" value="0">
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
									<table id="mcInfoTable"
										class="table table-hover table-bordered table-sm">
										<thead>
											<tr>
												<th>SL</th>
												<th>Customer Id</th>
												<th>Customer Name</th>
												<th>PPPoE Id</th>
												<th>PPPoE Password</th>
												<th>Edit</th>
											</tr>
										</thead>
										<tbody id="mcList">
											<c:forEach items="${pppoeList}" var="mc" varStatus="counter">
												<tr style="cursor: pointer;"
													onclick="setMcData('${mc.id}')">

													<td>${mc.popName}</td>
													<td>${mc.rackNo }</td>
													<td>${mc.chassiNo }</td>
													<td>${mc.clientName }</td>
													<td>${mc.switchPortNo}</td>
													<td>${mc.switchNo}</td>
												</tr>
											</c:forEach>
											<tr >
													<td>1</td>
													<td>CN-20210210</td>
													<td>Md Kawser</td>
													<td>CN-20210210_MD_KAWSER</td>
													<td>1254575</td>
													<td><i class="fa fa-edit" style="cursor: pointer;"
													onclick="setPPPoEData('${mc.id}')"></i></td>
												</tr>
												<tr >
													<td>2</td>
													<td>CN-20210211</td>
													<td>Md Omar Faruf</td>
													<td>CN-20210211_MD_OMAR_FARUQ</td>
													<td>44568265</td>
													<td><i class="fa fa-edit" style="cursor: pointer;"
													onclick="setPPPoEData('${mc.id}')"></i></td>
												</tr>
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
					<b>PPPoE ID & Password</b>
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
							<div class='col-md-12 px-1'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="customerName">Customer Name</label></span>
									</div>
									<input id="customerName" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm" readonly>
								</div>
							</div>
						</div>
						<div class="row my-1">
							<div class='col-md-12 px-1'>
								<div class="input-group input-group-sm mb-1">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm"><label
											class='my-0' for="pppoeId">PPPoE ID</label></span>
									</div>
									<input id="pppoeId" type="text" class="form-control"
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
											class='my-0' for="pppoePassword">PPPoE Password</label></span>
									</div>
									<input id="pppoePassword" type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-sm">
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
	src="${pageContext.request.contextPath}/js/support/pppoe-password.js"></script>
