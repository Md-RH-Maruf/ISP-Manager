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
		<input type="hidden" id="roleId" value="0">
		<input type="hidden" id="resourceId" value="0">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="card-box">
					<div class="row">
						<div class="col-sm-6 col-md-6 col-lg-6">

							<div class="row ">
								<h2>
									<b>Role Create</b>
								</h2>
							</div>
							<hr>

							<div class="form-group">
								<label for="roleName">Role Name:</label> <input type="text"
									class="form-control" id="roleName" name="text">
							</div>

							<button type="button" id="btnSave" class="btn btn-primary btn-sm"
								onclick="saveAction()">Save</button>

							<button type="button" id="btnEdit" class="btn btn-success btn-sm"
								onclick="editAction()" style="display: none;">Edit</button>
							<button type="button" id="btnRefresh"
								class="btn btn-secondary btn-sm" onclick="refreshAction()">Refresh</button>
							<hr>
							<div class="row">
								<div class="col-sm-12 col-md-12">
									<div class="input-group my-2">
										<select id="resourceNameSelect" class="form-control selectpicker"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm"
											data-live-search="true"
											data-style="btn-light btn-sm border-secondary form-control-sm">
											<option value="0">Select Resource</option>
											<c:forEach items="${resourceList}" var="resource">
												<option value="${resource.id}">${resource.resourceName}</option>
											</c:forEach>
										</select>
										<div class="input-group-append">
											<button class="btn btn-sm btn-primary" type="button">
												<i class="fa fa-plus-square" onclick="resourceAddAction()"></i>
											</button>
											<button class="btn btn-sm btn-primary" type="button"
												data-toggle="modal" data-target="#exampleModal">
												<i class="fa fa-cog"></i>
											</button>
										</div>
									</div>

									<div class="row">
										<div class="col-sm-12 col-md-12 col-lg-12"
											style="overflow: auto; max-height: 400px;">
											<table class="table table-hover table-bordered table-sm">
												<thead>
													<tr>
														<th>#</th>
														<th>Resource Name</th>
														<th title="Add"><i class="fa fa-plus"> </i></th>
														<th title="Edit"><i class="fa fa-edit"> </i></th>
														<th title="View"><i class="fa fa-eye"> </i></th>
														<th title="Delete"><i class="fa fa-trash"> </i></th>
														<th><i class="fa fa-edit"> </i></th>
													</tr>
												</thead>
												<tbody id="resourceRoleList">
													<c:forEach items="${resourceRoleList}" var="resourceRole"
														varStatus="counter">
														<tr>
															<td>${counter.count}</td>
															<td>${resource.resourceName}</td>
															<td><i class="fa fa-edit" style="cursor: pointer;"
																onclick="setData(${resource.id})"> </i></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>

									</div>
								</div>


							</div>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6 shadow ">
							<div class="input-group my-2">
								<input type="text" class="form-control"
									placeholder="Search Role" aria-describedby="findButton"
									id="search" name="search">
								<div class="input-group-append">
									<button class="btn btn-primary" type="button" id="findButton">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12"
									style="overflow: auto; max-height: 400px;">
									<table class="table table-hover table-bordered table-sm">
										<thead>
											<tr>
												<th scope="col">#</th>
												<th scope="col">Role Name</th>
												<th scope="col"><i class="fa fa-edit"> </i></th>
											</tr>
										</thead>
										<tbody id="roleList">
											<c:forEach items="${roleList}" var="role" varStatus="counter">
												<tr>
													<td>${counter.count}</td>
													<td id='roleName${role.id}'>${role.roleName}</td>
													<td><i class="fa fa-edit" style="cursor: pointer;"
														onclick="setData(${role.id})"> </i></td>
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
	<div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
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
							<input id="resourceName" type="text" aria-label="First name" class="form-control"
								placeholder="*Resource Name"> 
								<input id="resourceLink" type="text"
								aria-label="Last name" class="form-control"
								placeholder="*Resource Link">
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
<script src="js/setting/role-management.js"></script>
