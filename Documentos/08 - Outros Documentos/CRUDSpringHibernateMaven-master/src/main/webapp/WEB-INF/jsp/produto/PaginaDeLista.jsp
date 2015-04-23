<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de Visualização de Produtos</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/menu/Menu.jsp" />
	<form method="post">
		<h2>Página de Visualização de Produtos</h2>
		<div>
			<c:if test="${mensagemTitulo != null }">
				<br />
				${mensagemTitulo }
				<br /><br />
			</c:if>
			
		</div>
		<div>
			<table>
				<tr>
					<td>Nome</td>
					<td>Descricao</td>
					<td>R$</td>
				</tr>

				<c:forEach var="produto" items="${listaDeProdutos }">
					<tr>
						<td><label>${produto.nome}</label></td>
						<td><label>${produto.descricao}</label></td>
						<td><label>${produto.preco}</label></td>
						<td><a href="<c:url value='/produto/editar?produtoId=${produto.id}'/>">Editar</a></td>	
						<td><a href"" >Excluir</a></td>						
					</tr>
					
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>