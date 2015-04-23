<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de produto.</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/menu/Menu.jsp" />
	<form action="<c:url value='/produto/salvarProduto'/>" method="POST">
		<h2>Cadastro de Produto</h2>
		
		<div>
			<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" /> - Fortaleza/CE/Brasil
		</div>		
		<div>
			<c:if test="${mensagemTitulo != null }">
				<br />
				${mensagemTitulo }
			</c:if>
		</div>
		<br /> <br />
		<div>
			<form:errors path="produto.nome" cssStyle="color:red"/>
			<br /> Nome: <input type="text" name="nome" />
		</div>
		<div>
			<br />
			<form:errors path="produto.descricao" cssStyle="color:red"/>
			<br /> Descricao: <input type="text" name="descricao" />
		</div>
		<br />
		<div>
			Preco: <input type="text" name="preco" />
		</div>
		<br />
		<div>
			<input type="hidden" value="${usuarioLogado.id }" name="idUsuario" />
			Usuário: <input type="text" value="${usuarioLogado.username }" readonly="readonly" disabled="disabled"/>
		</div>
		<br />
		<br /> <input type="submit" value="Cadastrar" />
	</form>

</body>
</html>