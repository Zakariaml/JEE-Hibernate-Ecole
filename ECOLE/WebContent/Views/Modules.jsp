<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestion des matières</title>
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
          <h1 class="jumbotron-heading">Listes des modules</h1>
          <p class="lead text-muted">Vous pouvez ajouter,supprimer et modifier un modules dans cette liste.</p>
          
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
            <a href="Module.aspx?action=add" class="btn btn-primary my-2">Ajouter un module</a>
   
          </p>
        </div>
	
		<div class="container">
			<table class="table table-striped" >
		<thead>
		<tr>
			<th> Reference Module </th>
			<th> Module Libelle </th>
			<th> Action </th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${modules}" var="m">
				<tr>	
					<td> ${m.module_id } </td>
					<td> ${m.module_libelle } </td>
					<td> 	
			<a class="btn btn-outline-secondary" href="ModuleUpdate.aspx?action=update&ref=${m.module_id}"> Modifier</a> | 
			<a class="btn btn-outline-danger" href="ModuleDelete.aspx?action=delete&ref=${m.module_id}" 
			onclick="if (!(confirm('Lorsque vous supprimez un modules, toutes les notes qui sont attachées à cet module seront aussi supprimés! Continuer ?'))) return false">Supprimer</a>
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