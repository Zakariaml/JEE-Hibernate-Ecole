<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des notes par rapport les modules</title>
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

		<script src="js/bootstrap.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/jquery-3.4.1.js" type="text/javascript"></script>
		<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>

</head>
<body>

<%@ include file="header.html" %>

	
		<div class="container">
          <h1 class="jumbotron-heading">Gestion des notes</h1>
          <p class="lead text-muted">Vous pouvez gérer les notes des modules à partir de cette page.</p>
          <p>
         	 <c:choose>
			<c:when test="${ConfirmSuccess =='updated' }">
				<div id="hideit" class="alert alert-success" role="alert">
  					Le module bien modifié!
				</div>
			</c:when>
			<c:when test="${ConfirmSuccess =='added' }">
				<div id="hideit" class="alert alert-success" role="alert">
  					Le module bien ajouté!
				</div>
			</c:when>
			</c:choose>
   
          </p>
        </div>
	
		<div class="container">
			<table class="table table-striped" >
		<thead>
		<tr>
			<th> Module Libelle </th>
			<th> Action </th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${modules}" var="m">
				<tr>	
					<td> ${m.module_libelle } </td>
					<td> 	
			<a class="btn btn-outline-secondary" href="GestionNote.html?action=show&ref=${m.module_id}"> Afficher les notes</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
			</table>
		</div>

<br><br>
<%@ include file="footer.html" %>



</body>
</html>