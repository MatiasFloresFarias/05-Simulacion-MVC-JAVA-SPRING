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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Simulacion 5</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
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
		<h1 class="text-center">Lista de Comentarios</h1>

		<div class="container">
		<table class="table">
			<thead class="thead_dark">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>email</th>
					<th>body</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="c">
					<tr>
						<td><c:out value="${c.getId()}" /></td>
						<td><c:out value="${c.getName()}" /></td>
						<td><c:out value="${c.getEmail()}" /></td>
						<c:set var="top20" value="${c.getBody()}"/>  
						<td><c:out value="${fn:substring(top20, 0, 20)}  " /></td>
					</tr>
				</c:forEach>
		</table>
	</div>
	
			<div class="col-3">
				<a class="btn btn-danger"
					href="${pageContext.request.contextPath}/listarPosts">Volver
					al listado de Posts</a>
			</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.js"></script>
	<script>
		$(".confirm").confirm({
			title : "Confirmacion necesaria",
			content : "estas seguro?",
		});
	</script>
</body>
</html>