<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des notes</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

		<script src="js/bootstrap.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/jquery-3.4.1.js" type="text/javascript"></script>
		<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>

</head>
<body>
<%@ include file="header.html" %>
<section class="jumbotron text-center">
<div class="container">
          <h1 class="jumbotron-heading">Gestion des notes</h1>
          <p class="lead text-muted">
          Vous pouvez choisir entre l'affichage des notes par rapport à les élèves et par rapport aux modules.
          </p>
          <p>
            <a href="ModuleNote.html?action=ParRapportEleve" class="btn btn-primary btn-lg my-2">Notes des modules pour chaque élève</a>
            <a href="ModuleNote.html?action=ParRapportModule" class="btn btn-secondary btn-lg my-2">Notes des élèves pour chaque module</a>
          </p>
</div>
</section>

<br><br>
<%@ include file="footer.html" %>
</body>
</html>