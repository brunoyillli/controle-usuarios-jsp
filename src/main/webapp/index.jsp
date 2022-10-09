<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<title>Gerenciamento de Usuarios</title>


<style type="text/css">
.formulario {
	position: absolute;
	top: 40%;
	left: 33%;
	right: 33%;
}

.titulo {
	position: absolute;
	top: 30%;
	left: 33%;
}

.mensagemErro {
	font-size: 15px;
	color: #842029;
    background-color: #f8d7da;
    border-color: #f5c2c7;
}

.botao {
	width: 90%
}
</style>
</head>
<body>
	<h1 class="titulo">Gerenciamento de Usuarios</h1>

	<form action="<%=request.getContextPath()%>/Login" method="post"
		class="mb-3 row formulario needs-validation" novalidate>
		<input type="hidden" value="<%=request.getParameter("url")%>"
			name="url">
		<div class="mb-3">
			<label class="form-label">Login</label>
			<div class="col-sm-10">
				<input class="form-control" name="login" type="text" required>
				<div class="invalid-feedback">Digite o login</div>
			</div>
		</div>
		<div class="mb-3">
			<label class="form-label">Senha</label>
			<div class="col-sm-10">
				<input class="form-control" name="senha" type="password" required>
				<div class="invalid-feedback">Digite a senha</div>
			</div>
		</div>
		<div class="mb-3">
			<input class="btn btn-primary botao" type="submit" value="Acessar">
		</div>
		<h4 class="mensagemErro">${mensagem}</h4>
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		(() => {
			  'use strict'
			  const forms = document.querySelectorAll('.needs-validation')
		
			  Array.from(forms).forEach(form => {
			    form.addEventListener('submit', event => {
			      if (!form.checkValidity()) {
			        event.preventDefault()
			        event.stopPropagation()
			      }
		
			      form.classList.add('was-validated')
			    }, false)
			  })
			})()
	</script>
</body>
</html>