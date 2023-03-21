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
				<a href="">Eliminar</a>
				<a href="">Modificar</a>
			</td>

		</tr>
		<%
		}
		%>
	</table>
	
		<form action="InsertarUsuario" method="POST">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" size="20" name="nombre"></td>
			</tr>
		</form>
		</table>
		

</body>
</html>