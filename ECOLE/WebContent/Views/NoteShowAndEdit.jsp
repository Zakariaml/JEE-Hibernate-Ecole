<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editer les notes</title>

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
          <h1 class="jumbotron-heading">Les notes pour le module ${moduleName.module_libelle}</h1>
          <p class="lead text-muted">Vous pouvez modifier les notes de ce module pour chaque étudiant.</p>
         <p class="lead text-muted">La note O, représente une note null! La note 1 représente que l'élève ABS
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
		<form action="notes.html" method="post"> 
		<c:forEach items="${notes}" var="n">
				<tr>	
					<td> ${n.eleve.nom_eleve} </td>
					<td> ${n.eleve.prenom_eleve} </td>
					<td> <input type="number" name="note" value="${n.note}">  </td>
					<input type="hidden" name="listCneEleve" value="${n.eleve.cne_eleve}">	
				</tr>
				
			</c:forEach>
			
			<input type="hidden" name="IdModule" value="${moduleName.module_id}">	
			
			<button type="submit" class="btn btn-primary btn-md btn-block float-right" name="action" value="saveNote">
			Enregister
			</button>
			<br><br><br>
		</form>
			
		</tbody>
			</table>
		</div>

<br><br>
<%@ include file="footer.html" %>



</body>

</body>
</html>