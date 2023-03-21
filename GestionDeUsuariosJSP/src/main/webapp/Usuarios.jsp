<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@   page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="modelo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<style>
body{
	background-color:burlywod;
}
</style>
<body>

	<%
	ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
	%>

	<h1>Ver todos los usuarios</h1>

	<table border=2>
		<tr>
			<td>ID</td>
			<td>Nombre</td>
			<td>Acciones</td>
		</tr>

		<%
		for (int i = 0; i < usuarios.size(); i++) {
		%>
		<tr>
			<td>
				<%
				out.print(usuarios.get(i).getId());
				%>
			</td>

			<td>
				<%
				out.print(usuarios.get(i).getNombre());
				%>
			</td>
			<td>
				<a href="Eliminar?id=<% %>">Eliminar</a>
				<a href="">Modificar</a>
				<a href="">Ver</a>
			</td>

		</tr>
		<%
		}
		%>
	</table>
	
	<form method="POST" action="Borrar">
		<br> <input type="submit" name="borrar" placeholder="borrar" /><br>
	</form>

</body>
</html>