<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des élèves</title>
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
          <h1 class="jumbotron-heading">Listes des élèves</h1>
          <p class="lead text-muted">Vous pouvez ajouter,supprimer et modifier un élève dans cette liste.</p>
          
          <p>
          <c:choose>
			<c:when test="${ConfirmSuccess =='updated' }">
				<div id="hideit" class="alert alert-success" role="alert">
  					L'élève bien modifié!
				</div>
			</c:when>
			<c:when test="${ConfirmSuccess =='added' }">
				<div id="hideit" class="alert alert-success" role="alert">
  					L'élève bien ajouté!
				</div>
			</c:when>
			<c:when test="${ConfirmSuccess =='deleted' }">
				<div id="hideit" class="alert alert-success" role="alert">
  					L'élève bien supprimé!
				</div>
			</c:when>
	</c:choose>
            <a href="Eleve.php?action=add" class="btn btn-primary my-2">Ajouter un élève</a>
   
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
			<a class="btn btn-outline-secondary" href="EleveUpdate.php?action=update&ref=${e.cne_eleve}"> Modifier</a> | 
			<a class="btn btn-outline-danger" href="EleveDelete.php?action=delete&ref=${e.cne_eleve}" 
			onclick="if (!(confirm('Are you sure you want to delete this module ?'))) return false">Supprimer</a>
			  		</td>
				</tr>
			</c:forEach>
		</tbody>
			</table>
		</div>


<br><br>
<%@ include file="footer.html" %>
</body>

<script type="text/javascript">
		$(document).ready(function () {
            setTimeout(function () {
                $('#hideit').fadeOut();
            }, 5000);
        });
	</script>
</html>