
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
		<input type="hidden" id="oltAutoId" value="0">
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
							<button type="button" class="btn btn-primary mt-2"
								onclick="newClickAction()" data-toggle="modal"
								data-target="#exampleModal">New OLT</button>
							<hr>
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12 px-2"
									style="overflow: auto;">
									<table id="oltInfoTable"
										class="table table-hover table-bordered table-sm">
										<thead>
											<tr>
												<th>OLT Name</th>
												<th>OLT Port No</th>
												<th>Connection Point</th>
												<th>Spliter ODF No</th>
												<th>Fiber ODF No</th>

											</tr>
										</thead>
										<tbody id="oltList">
											<c:forEach items="${oltInfoList}" var="olt" varStatus="counter">
												<tr style="cursor: pointer;"
													onclick="setOltData('${olt.id}')">

													<td>${olt.oltName}</td>
													<td>${olt.oltPortNo }</td>
													<td>${olt.connectionPointName }</td>
													<td>${olt.spliterOdfNo }</td>
													<td>${olt.fiberOdfNo}</td>
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
					<b>OLT Information Create</b>
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
											class='my-0' for="oltName">Olt Name</label></span>
									</div>
									<input id="oltName" type="text" class="form-control"
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
											class='my-0' for="oltPortNo">OLT Port No</label></span>
									</div>
									<input id="oltPortNo" type="text" class="form-control"
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
											class='my-0' for="connectionPointName">Connection Point Name</label></span>
									</div>
									<input id="connectionPointName" type="text" class="form-control"
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
											class='my-0' for="spliterOdfNo">Spliter ODF No</label></span>
									</div>
									<input id="spliterOdfNo" type="text" class="form-control"
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
											class='my-0' for="spliterOdfPortNo">Spliter ODF Port No</label></span>
									</div>
									<input id="spliterOdfPortNo" type="text" class="form-control"
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
											class='my-0' for="fiberOdfNo">Fiber ODF No</label></span>
									</div>
									<input id="fiberOdfNo" type="text" class="form-control"
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
											class='my-0' for="fiberOdfPortNo">Fiber ODF Port No</label></span>
									</div>
									<input id="fiberOdfPortNo" type="text" class="form-control"
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
	src="${pageContext.request.contextPath}/js/support/olt-info.js"></script>
