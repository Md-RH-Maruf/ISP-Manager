<%@page import="com.manager.example.shareModel.Gender"%>
<%@page import="com.manager.example.shareModel.Nationalities"%>
<%@page import="com.manager.example.shareModel.Designations"%>
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
		<input type="hidden" id="employeeAutoId" value="0">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="card-box">
					<div class="row">
						<div class="col-sm-6 col-md-6 col-lg-6">

							<div class="row ">
								<h2>
									<b>Employee Create</b>
								</h2>
							</div>
							<hr>

							<div class="row my-1">
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="employeeId">Employee ID</label></span>
										</div>
										<input id="employeeId" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" value="${maxId }" readonly>
									</div>
								</div>
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="activeStatus">Active Status</label></span>
										</div>
										<select class="form-control" id="activeStatus">
											<option value="1">Active</option>
											<option value="2">Inactive</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="firstName">First Name</label></span>
										</div>
										<input id="firstName" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" >
									</div>
								</div>
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="lastName">Last Name</label></span>
										</div>
										<input id="lastName" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" >
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="nickName">Nick Name</label></span>
										</div>
										<input id="nickName" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" >
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="fatherName">Father Name</label></span>
										</div>
										<input id="fatherName" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" >
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="motherName">Mother Name</label></span>
										</div>
										<input id="motherName" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" >
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="dateOfBirth">DateOfBirth</label></span>
										</div>
										<input id="dateOfBirth" type="date" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm">
									</div>
								</div>
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="gender">Gender</label></span>
										</div>
										<select class="form-control" id="gender">
											<%
												for (Gender gender : Gender.values()) {
											%>

											<option value="<%=gender.getType()%>"><%=gender.toString()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
							</div>
							<div class="row my-1">
							<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="nationality">Nationality</label></span>
										</div>
										<select class="form-control" id="nationality">
											<%
												for (Nationalities nation : Nationalities.values()) {
											%>

											<option value="<%=nation.getType()%>"><%=nation.toString()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="nationalId">NID</label></span>
										</div>
										<input id="nationalId" type="text" class="form-control"
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
												class='my-0' for="presentAddress">Present Address</label></span>
										</div>
										<textarea id="presentAddress" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm"></textarea>
									</div>
								</div>
							</div>
							
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="permanentAddress">Permanent Address</label></span>
										</div>
										<textarea id="permanentAddress" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm"></textarea>
									</div>
								</div>
							</div>

							
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="email">Email</label></span>
										</div>
										<input id="email" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" >
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-12 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="contactNo">Contact No</label></span>
										</div>
										<input id="contactNo" type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" >
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="designation">Designation</label></span>
										</div>
										<select class="form-control" id="designation">
											<%
												for (Designations designation : Designations.values()) {
											%>

											<option value="<%=designation.getType()%>"><%=designation.toString()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="meritalStatus">Marital Status</label></span>
										</div>
										<select class="form-control" id="designation">
											
											<option value="1">Single</option>
											<option value="2">Married</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row my-1">
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="joiningDate">Joining Date</label></span>
										</div>
										<input type="date" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" id="joiningDate" />
									</div>
								</div>
								<div class='col-md-6 px-1'>
									<div class="input-group input-group-sm mb-1">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-sm"><label
												class='my-0' for="leaveDate">Leave Date</label></span>
										</div>
										<input type="date" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" id="leaveDate" />
									</div>
								</div>
								
							</div>
							<div class="row">
								<div class="col-md-12">
									<button type="button" id="btnSave"
										class="btn btn-primary btn-sm" onclick="saveAction()">Save</button>

									<button type="button" id="btnEdit"
										class="btn btn-success btn-sm" onclick="editAction()"
										style="display: none;">Edit</button>
									<button type="button" id="btnRefresh"
										class="btn btn-secondary btn-sm" onclick="refreshAction()">Refresh</button>

								</div>
							</div>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6 shadow ">
							<div class="input-group my-2">
								<input type="text" class="form-control"
									placeholder="Search User" aria-describedby="findButton"
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
												<th>Employee Id</th>
												<th>Employee Name</th>
												<th>Employee Type</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody id="employeeList">
											<c:forEach items="${employeeList}" var="employee" varStatus="counter">
												<tr style="cursor: pointer;"
													onclick="setEmployeeData('${employee.id}')">
													<td>${employee.employeeId}</td>
													<td>${employee.firstName}</td>
													<td>${employee.designation }</td>
													<td>${employee.status }</td>
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
	src="${pageContext.request.contextPath}/js/inventory/employee.js"></script>
