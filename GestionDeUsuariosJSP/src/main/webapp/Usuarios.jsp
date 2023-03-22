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
			

		</tr>
		<%
		}
		%>
	</table>
	
			<a href="EliminarForm.jsp">Eliminar</a>
			<a href="ModificarForm.jsp">Modificar</a>
			<a href="InsertarForm.jsp">Insercion</a>
		

</body>
</html>