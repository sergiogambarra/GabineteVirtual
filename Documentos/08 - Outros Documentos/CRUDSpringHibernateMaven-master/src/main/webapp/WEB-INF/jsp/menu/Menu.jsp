<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu principal</title>
</head>
<body>
	<fieldset>
		<h5>Menu</h5>
		<div>
			<ul>
				<li>
					<a href="<c:url value='/produto' />">Cadastro de Produto</a>
				</li>
			</ul>
			<ul>
				<li>
					<a href="<c:url value='/produto/visualizarProdutos' />">Visualizar Produtos</a>
				</li>
			</ul>
		</div>
		<a href="<c:url value='/login/logout' />">Logout</a>
	</fieldset>
</body>
</html>