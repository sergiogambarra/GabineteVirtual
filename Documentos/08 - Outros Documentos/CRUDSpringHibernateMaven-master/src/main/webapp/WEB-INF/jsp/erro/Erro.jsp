<%@ page language="java" isErrorPage="true"	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page!</title>
</head>
<body>
	<fieldset>
		<jsp:include page="/WEB-INF/jsp/menu/MenuLogin.jsp" />
	</fieldset>
	
	Um erro ocorreu!

	<div>
		<img src="<c:url value='/imagens/pageNotFound.png'/>" />
	</div>
</body>
</html>