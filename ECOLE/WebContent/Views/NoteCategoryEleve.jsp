<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des notes par rapport les élèves</title>
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
          <p class="lead text-muted">Vous pouvez gérer les notes des modules pour chaque élève à partir de cette page.</p>
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
			<table class="table table-hover" >
		<thead>
		<tr>
			<th> CNE </th>
			<th> Nom </th>
			<th> Prénom </th>
			<th> Action </th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${eleves}" var="e">
				<tr>	
					<td> ${e.cne_eleve } </td>
					<td> ${e.nom_eleve } </td>
					<td> ${e.prenom_eleve } </td>
					<td> 	
			<a class="btn btn-outline-secondary" href="?action=showNoteEleve&ref=${e.cne_eleve}"> Afficher les notes</a>
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