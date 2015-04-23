 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de cadastro de usuário</title>
</head>
<body>
	<form action="<c:url value='/usuario/cadastrarUsuario' />"
		method="post">
		<h2>Página de Cadastro de Usuário</h2>
		<c:if test="${mensagemTitulo != null }">
			<br />
				${mensagemTitulo }
			<br />
			<br />
		</c:if>
		<form:errors path="usuario.nome" cssStyle="color:red" />
		<br /> 
		Nome: <input type="text" name="nome" /> 
		<br />
		<form:errors path="usuario.sobrenome" cssStyle="color:red" />
		<br /> 
		Sobrenome: <input type="text" name="sobrenome" /> 
		<br />
		<form:errors path="usuario.email" cssStyle="color:red" />
		<br />
		Email: <input type="text" name="email" /> 
		<br />
		<form:errors path="usuario.username" cssStyle="color:red" />
		<br /> 
		Username: <input type="text" name="username" /> 
		<br />
		<form:errors path="usuario.senha" cssStyle="color:red" />
		<br /> 
		Senha: <input type="password" name="senha" /> 
		<br />
		<form:errors path="usuario.confirmaSenha" cssStyle="color:red" />
		<br /> 
		Confirma Senha: <input type="password" name="confirmaSenha" />
		<br />
		<br /> 
		<input type="submit" value="Cadastrar Usuário" />
	</form>
</body>
</html>