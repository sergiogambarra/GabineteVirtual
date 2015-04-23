<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="<c:url value='/login/logar'/>" method="post">
		<h2>Login</h2>
		<c:if test="${mensagemTitulo != null }">
			<br />
				${mensagemTitulo }
			<br /><br />
		</c:if>
		<form:errors path="usuario.username" cssStyle="color:red"/>
		<br />
		Username: <input type="text" name="username" /> 
		<br /> 
		<form:errors path="usuario.senha" cssStyle="color:red"/>
		<br />
		Senha: <input type="password" name="senha" /> <br />
		<br /> 
		<input type="submit" value="Efetuar login" />
		<br/>
		<a href="<c:url value='/usuario'/>">Não possui cadastro? Cadastre-se aqui!</a>
	</form>
</body>
</html>