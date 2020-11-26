<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter ou modifier un module</title>
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
 		 Veuillez saisir une référence non-existant!
		</div>
 		</c:when>
 	</c:choose>
	<div class="row"> 
	
	<div class="col-md-8 order-md-1">
		<form action="Modules.aspx" method="post">
  <div class="form-group">
    <label for="moduleID">Module Référence</label>
    <c:choose>
    	<c:when test="${module.module_id ==null }">
    		<input type="text" class="form-control" id="moduleID" name="moduleId" aria-describedby="ModuleHelp" value="${module.module_id }" placeholder="Entrer une référence" required>
    		<small id="ModuleHelp" class="form-text text-muted">La réféence doit etre différente à les autres modules.</small>
    		<input type="hidden" name="addOrUpdate" value="add">
    	</c:when>
    	<c:otherwise>
    		<input type="text" class="form-control" id="moduleID" name="moduleId" aria-describedby="ModuleHelp" value="${module.module_id }" placeholder="Entrer une référence" required readonly="readonly">
    		<small id="ModuleHelp" class="form-text text-muted">Vous pouvez pas changer la référence d'un module</small>
    		<input type="hidden" name="addOrUpdate" value="update">
    	</c:otherwise>
    </c:choose>
      </div>
  <div class="form-group">
    <label for="ModuleName">Module libelle</label>
    <input type="text" class="form-control" id="ModuleName" name="moduleName" value="${module.module_libelle }" placeholder="Module libelle" required>
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