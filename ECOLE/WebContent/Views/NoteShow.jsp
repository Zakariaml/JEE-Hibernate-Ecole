<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
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
          <h1 class="jumbotron-heading">Affichage des notes pour le module ${moduleName.module_libelle}</h1>
          <p class="lead text-muted">Vous pouvez modifier les notes de ce module pour chaque étudiant.</p>
         	<p class="lead text-muted">La note O, représente une note null! La note 1 représente que l'élève ABS
         </p>
          <p>
         	  <c:if test="${ConfirmSuccess =='updated' }">
         	  	<div id="hideit" class="alert alert-success" role="alert">
  					Les notes bien modifié!
				</div>
         	  </c:if>
			<a href="NoteUpdate.html?action=updateNoteForModule&ref=${moduleName.module_id}" class="btn btn-primary my-2">
			Modifier les notes 
			</a>
   
          </p>
        </div>
	
		<div class="container">
			<table class="table table-striped" >
		<thead>
		<tr>
			<th> Nom élève </th>
			<th> Prénom élève </th>
			<th> Note </th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${notes}" var="n">
				<tr>	
					<td> ${n.eleve.nom_eleve} </td>
					<td> ${n.eleve.prenom_eleve} </td>
					<td> ${n.note} </td>
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
            }, 4000);
        });
	</script>

</html>