<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<!-- Begin Page Content -->

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- 404 Error Text -->
	<div class="text-center">
		<div class="error mx-auto" data-text="404">404</div>
		<p class="lead text-gray-800 mb-5">Page Not Found</p>
		<p class="text-gray-500 mb-0">It looks like you found a glitch in
			the matrix...</p>
		<a href="${pageContext.request.contextPath}/dashboard">&larr; Back to Dashboard</a>
	</div>

</div>

<!-- /.container-fluid -->
<jsp:include page="../include/footer.jsp" />
