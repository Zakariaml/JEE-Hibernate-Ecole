<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table class="table table-striped" >
		<thead>
		<tr>
			<th> Nom élève </th>
			
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${mylist}" var="n">
				<tr>	
					<td> ${n} </td>
				</tr>
			</c:forEach>
		</tbody>
			</table>
</body>
</html>