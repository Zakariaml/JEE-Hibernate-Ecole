<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher les notes d'�l�ve</title>

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
          <h1 class="jumbotron-heading">Les notes pour l'�l�ve ${eleve.getNom_eleve()} ${eleve.getPrenom_eleve()}</h1>
          <p class="lead text-muted">Vous pouvez modifier les notes d'�l�ve pour chaque module.</p>
         	<p class="lead text-muted">La note O, repr�sente une note null! La note 1 repr�sente que l'�l�ve ABS
         </p>
         <p>
         	 <c:choose>
			<c:when test="${ConfirmSuccess =='updated' }">
				<div id="hideit" class="alert alert-success" role="alert">
  					Le module bien modifi�!
				</div>
			</c:when>
			<c:when test="${ConfirmSuccess =='added' }">
				<div id="hideit" class="alert alert-success" role="alert">
  					Le module bien ajout�!
				</div>
			</c:when>
			</c:choose>
			<a href="NoteUpdate.html?action=updateNoteForEleve&ref=${eleve.getCne_eleve()}" class="btn btn-primary my-2">
			Modifier les notes 
			</a>
   
          </p>
        </div>
	
		<div class="container">
			<table class="table table-striped" >
		<thead>
		<tr>
			<th> R�f�rence module </th>
			<th> Libelle module </th>
			<th> Note </th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${notes}" var="n">
				<tr>	
					<td> ${n.module.module_id} </td>
					<td> ${n.module.module_libelle} </td>
					<td> ${n.note} </td>
				</tr>
			</c:forEach>
			
		</tbody>
			</table>
		</div>

<br><br>
<%@ include file="footer.html" %>



</body>

</body>
</html>