<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciamento de Usuarios</title>
</head>
<body>
	<h1>Login - Gerenciamento de Usuarios</h1>

	<form action="Login" method="post">
	<input type="hidden" value="<%= request.getParameter("url")%> name="url">
		<table>
			<tr>
				<td><label>Login</label></td>
				<td><input name="login" type="text"></td>
			</tr>
			<tr>
				<td><label>Senha</label></td>
				<td><input name="senha" type="password"></td>
			</tr>
			<tr>
				<td/>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
		<h4>${mensagem}</h4>
	</form>
</body>
</html>