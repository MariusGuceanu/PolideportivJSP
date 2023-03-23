<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="modelo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
	
	<h1>Modificar Usuario</h1>
	<%=usuario %>
	<form action="ModificarUsuario" method="POST">
		<label for="nombre">Nombre</label>
        <input type="text" name="nombre" value="<%=usuario.getNombre()%>">
        <label for="contrasena">Contrasena</label>
        <input type="text" name="contrasena" value="<%=usuario.getContrasena()%>">
        </form>
        <form action="VerUsuarios">
    	<input type="submit" value="volver">
    </form>
</body>
</html>