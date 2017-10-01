<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="img" value="/resources/img" />
<spring:url var="js" value="/resources/js" />
<spring:url var="vendor" value="/resources/vendor" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Coffee - ${title}</title>

<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap core CSS -->
<link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/page.css" rel="stylesheet">




</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navigation.jsp"%>


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
		</div>
		<!-- Page Content end -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${vendor}/jquery/jquery.min.js"></script>
		<script src="${vendor}/popper/popper.min.js"></script>
		<script src="${vendor}/bootstrap/js/bootstrap.min.js"></script>
		<!-- Custom scripts -->
		<script src="${js}/shineMenuName.js"></script>
	</div>
</body>

</html>

