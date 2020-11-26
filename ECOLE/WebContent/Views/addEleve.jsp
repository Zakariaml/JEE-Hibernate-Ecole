<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Elèves</title>
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
 	<c:choose>
 		<c:when test="${error == true }">
 		<div class="alert alert-danger" role="alert">
 		 Veuillez saisir un CNE non-existant!
		</div>
 		</c:when>
 	</c:choose>
	<div class="row"> 
	
	<div class="col-md-8 order-md-1">
		<form action="EleveSave.php" method="post">
  <div class="form-group">
    <label for="CNE">CNE</label>
    <c:choose>
    	<c:when test="${eleve.cne_eleve ==null }">
    		<input type="text" class="form-control" id="CNE" name="cne" aria-describedby="CNEHelp" value="${eleve.cne_eleve }" placeholder="Entrer un CNE" required>
    		<small id="CNEHelp" class="form-text text-muted">Le Code National d'Elève doit etre différent à les autres CNE.</small>
    		<input type="hidden" name="addOrUpdate" value="add">
    	</c:when>
    	<c:otherwise>
    		<input type="text" class="form-control" id="CNE" name="cne" aria-describedby="CNEHelp" value="${eleve.cne_eleve }" placeholder="Entrer un CNE" required readonly="readonly">
    		<small id="CNEHelp" class="form-text text-muted">Vous pouvez pas changer le CNE d'un élève</small>
    		<input type="hidden" name="addOrUpdate" value="update">
    	</c:otherwise>
    </c:choose>
      </div>
  <div class="form-group">
    <label for="ElveName">Nom d'élève : </label>
    <input type="text" class="form-control" id="EleveName" name="EleveName" value="${eleve.nom_eleve }" placeholder="Entrer le nom d'élève" required>
  </div>
  <div class="form-group">
    <label for="ElvePrenom">Prénom d'élève : </label>
    <input type="text" class="form-control" id="ElvePrenom" name="ElevePrenom" value="${eleve.prenom_eleve }" placeholder="Entrer le prénom d'élève" required>
  </div>
  <button type="submit" name="action" value="save" class="btn btn-primary">Sauvgarder</button>
	</form>	
	</div>
		
	</div>

</div>
<br><br>
	<%@ include file="footer.html" %>
</body>
</html>