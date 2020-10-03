
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Alterar Cliente</h2> 
	
	<form id="form1" method="post" action="Controller"> 
	<hr/> 
	<br/>Id<br/> 
	<input type="text" id="id" name="id" value="${cliente.id}" size="10" readonly="readonly" /> 
	<br/>Nome<br/> 
	<input type="text" id="nome" 
	name="nome" value="${cliente.nome}" size="30" pattern="[a-zA-Z]{2,50}" 
	required="required"/> 
	<br/>Email<br/> 
	<input type="email" id="email" name="email" value="${cliente.email}" size="30" 
	required="required" /> 
	<br/>Imagem<br/> 
	<input type="text" id="imagem" name="imagem" required="required" value="${cliente.image}" size="50" />
	 <br/> 
	 <input type="hidden" id="cmd" name="cmd" value="alterar" /> 
	 <br/> 
	 <button type="submit" > Alterar Dados</button> </form>
<br/> 



</body>
</html>