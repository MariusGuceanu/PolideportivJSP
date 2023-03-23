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
<link rel="stylesheet" href="style.css"></link>
<body>

	<%
	ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
	%>

	<h1>Ver todos los usuarios</h1>

	<table border=2>
		<tr>
			<td>ID</td>
			<td>Nombre</td>
			<td>Contrasena</td>
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
				<%
				out.print(usuarios.get(i).getContrasena());
				%>
			</td>
			
			
			<td>
			<a href="ModificarForm.jsp">Modificar</a>
			</td>
			

		</tr>
		<%
		}
		%>
	</table>
	
	<br>
			<a class="linkE" style="border-style: solid; padding:1%;" href="EliminarForm.jsp">Eliminar</a>
			
	<br> <br> <br>
	
			<a class="linkI" style="border-style: solid; padding:1%;" href="InsertarUsuario">Insercion</a>
		

</body>
</html>