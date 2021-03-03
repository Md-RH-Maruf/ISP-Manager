<%@page import="com.manager.example.shareModel.Status"%>
<%@page import="com.manager.example.shareModel.Priority"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<!-- Begin Page Content -->

<div class="container">

	<div class="card o-hidden border-0 shadow-lg">
		<div class="card-body px-5 py-2">
			<!-- Nested Row within Card Body -->

			<div class="row">

				<div class="col-md-6 ">
					<div class="text-center">
						<h1 class="h4 text-gray-900 mb-1">TMS Details</h1>
					</div>

					<div class="row"></div>
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="form">Form</label></span>
								</div>
								<input id="form" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="subject">Subject</label></span>
								</div>
								<input id="subject" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>


					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="date">Date</label></span>
								</div>
								<input id="date" type="date" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="status">status</label></span>
								</div>
								<select id="status" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
									<%
									for(Status status : Status.values()) {
									%>

									<option value/="<%=status.getType()%>"><%=status.name()%></option>
									<%
										}
									%>
								</select>

							</div>
						</div>
					</div>

					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="priority">Priority</label></span>
								</div>
								<select id="priority" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
									<%
									for(Priority priority : Priority.values()) {
									%>

									<option value/="<%=priority.getType()%>"><%=priority.name()%></option>
									<%
										}
									%>
								</select>
							</div>
						</div>
					</div>
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="owner">Owner</label></span>
								</div>
								<input id="owner" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-7">
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="contactName">Contact Name</label></span>
								</div>
								<input id="contactName" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="contactNumber">Contact Number</label></span>
								</div>
								<input id="contactNumber" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="contactAddress">Contact Address</label></span>
								</div>
								<input id="contactAddress" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="connectionType">Connection Type</label></span>
								</div>
								<input id="connectionType" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="bandwidthPackage">Bandwidth/Package</label></span>
								</div>
								<input id="bandwidthPackage" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
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
						<div class='col-md-12'>
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
					</div>
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="reference">Reference</label></span>
								</div>
								<input id="reference" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
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
				</div>
				<div class="col-md-5">
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="workTeam">Work Team</label></span>
								</div>
								<input id="workTeam" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
									<div class="input-group-append">
									<button class="btn btn-primary" type="button" id="workTeamAddBtn">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="supportName">Support Name</label></span>
								</div>
								<input id="supportName" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
									<div class="input-group-append">
									<button class="btn btn-primary" type="button" id="supportNameAddBtn">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="onuMac">ONU/MAC</label></span>
								</div>
								<input id="onuMac" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="latLong">Lat long</label></span>
								</div>
								<input id="latLong" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="onuInterface">ONU interface</label></span>
								</div>
								<input id="onuInterface" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="connectionPoint">Connection Point</label></span>
								</div>
								<select id="connectionPoint"
											class="form-control selectpicker"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm"
											data-live-search="true"
											data-style="btn-light btn-sm border-secondary form-control-sm">
											<option value="0">Select Resource</option>
											<c:forEach items="${connectionPointList}" var="connection">
												<option value="${connection.id}">${connection.resourceName}</option>
											</c:forEach>
										</select>
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="ipAddress">IP Address</label></span>
								</div>
								<input id="ipAddress" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="clientMac">Client MAC</label></span>
								</div>
								<input id="clientMac" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
							</div>
						</div>
					</div>
					
					<div class="row my-1">
						<div class='col-md-12'>
							<div class="input-group input-group-sm mb-1">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-sm"><label
										class='my-0' for="activationStatus">Activation Status</label></span>
								</div>
								<select id="activationStatus" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-sm">
									<option value="0">Completed</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr class="mt-1">
			<div class="row d-flex justify-content-center">
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-12">
						<div class="comment border border-secondary">
							<h6>User1</h6>
							<p>This message from User1</p>
						</div>
						<div class="comment  border border-secondary">
							<h6>User2</h6>
							<p>This message from User2</p>
						</div>
						</div>
						
					</div>
					<div class="row">
						<div class="col-md-12">
						<textarea class="form-control mt-1" placeholder="Comment Write Here.."></textarea>
						<button id="btnUpdate" class="btn btn-sm btn-primary mt-1">Update</button>
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
	src="${pageContext.request.contextPath}/js/support/activation-tms-details.js"></script>
