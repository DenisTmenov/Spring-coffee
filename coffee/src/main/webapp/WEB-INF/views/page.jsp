<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="images" value="/resources/images" />
<spring:url var="js" value="/resources/js" />
<spring:url var="vendor" value="/resources/vendor" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Denis">
<meta name="author" content="Denis">

<title>Coffee - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${vendor}/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap dataTables CSS -->
<link href="${vendor}/bootstrap/css/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/page.css" rel="stylesheet">
<link href="${css}/docs.min.css" rel="stylesheet">

<!-- FontAwesome -->
<link href="${css}/font-awesome.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>


		<!-- Page Content start -->
		<div class="content">
			<!-- Home page -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- About page -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Contacts page -->
			<c:if test="${userClickContacts == true}">
				<%@include file="contacts.jsp"%>
			</c:if>

			<!-- Services page -->
			<c:if test="${userClickServices == true}">
				<%@include file="services.jsp"%>
			</c:if>

			<!-- View all product page -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>


			<!-- View single product page -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>


			<!-- View manage products page -->
			<c:if test="${userClickManageProduct == true}">
				<%@include file="manageProduct.jsp"%>
			</c:if>





		</div>
		<!-- Page Content end -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>


		<!-- jQuery -->
		<script src="${vendor}/jquery/jquery.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${vendor}/popper/popper.js"></script>
		<script src="${vendor}/bootstrap/js/bootstrap.js"></script>

		<!-- DataTable Plugin -->
		<script src="${vendor}/jquery/jquery.dataTables.js"></script>

		<!-- Bootstrap dataTables JavaScript -->
		<script src="${vendor}/bootstrap/js/dataTables.bootstrap4.js"></script>

		<!-- BootBox script -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Custom scripts -->
		<script src="${js}/userApp.js"></script>




	</div>
</body>

</html>
<!-- http://fontawesome.io/icons/ -->
