<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Talento Digital</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.css">

<!-- Llamado a boostrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

</head>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a style="border: none;" class="navbar-brand" href="#">Simulacion 5</a>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/borrar">Borrar Comments y Post</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cargaPosts">Cargar Post</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cargaComments">Cargar Comentarios</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/listarPosts">Listar Posts</a></li>
			</ul>
		</div>
	</nav>
	
<div class="container">
		<table class="table">
			<thead class="thead_dark">
				<tr>
					<th> Id Post </th>
					<th>Title</th>
					<th>User Name</th>
					<th>Number of Comments</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="p">
					<tr>
						<td><c:out value="${p.getId()}" /></td>
						<td><c:out value="${p.getTitle()}" /></td>
						<td><c:out value="${p.getUser().getName()}" /></td>
						<td><c:out value="${p.getCantidadComments()}" /></td>
						<td><a class="btn btn-primary"
							href="${pageContext.request.contextPath}/listarComments/${p.getId()}">Ver Comentarios</a></td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.js"></script>
	<!-- Jss boostrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	</body>
</html>