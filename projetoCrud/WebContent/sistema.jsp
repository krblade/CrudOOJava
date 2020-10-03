
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Formulario Cliente</h2>

<form  id="form1" method ="post" action="Controller" >
<hr/>

<br/>Nome <br/>
<input type="text" id="nome"  name="nome" size ="30"/>
<br/>Email <br/>
<input type ="text" id ="email" name="email" size ="30"/>
<br/>imagem<br/>
<input type ="text" id ="imagem" name="imagem" size ="50"/>
<br/>
<input type ="hidden" id ="cmd" name="cmd" value="gravar" />

<br/>

<button type ="button" onclick="validar()">
   Enviar Dados </button>
<br/>
${msg}

<br/>
<div id="saida"> </div>

<div id="erro">  </div>
</form>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="entity.*,java.util.*" %>
<jsp:useBean id="mb" class="manager.ManagerBean"></jsp:useBean>
<table >
	<tr>
	<th>Id</th>
	<th>Nome</th>
	<th>Email</th>
	<th>Imagem</th>
	<th>Alterar</th>
	<th>Excluir</th>
	</tr>

<c:forEach items="${mb.clientes}" var="linha"> 
<tr>
 	<td>${linha.id}</td>
 	<td>${linha.nome}</td>
 	<td>${linha.email}</td>
 	<td><img src="${linha.image}" width="30px" height = "30px"/></td>
    <td> <a href="#" onclick="javascript:excluir(${linha.id})">Excluir</a> </td>
    <td><a href="Controller?cmd=editar&id=${linha.id }">Editar</a></td>
  </tr>

</c:forEach>

</table>


<script>

 class Cliente {
	    constructor(id,nome,email,imagem){
		this.id=id;
		this.nome=nome;
		this.email=email;
		this.imagem=imagem;
	}
	toString(){
	return this.id +"," + this.nome + "," 
	+ this.email + "," + this.imagem;
	}
	isNome(){
	var reg = new RegExp("[a-z A-Z]{2,50}");
	return reg.test(this.nome);//true ou false
	}
	
	isEmail(){
		var reg = /^([_a-zA-Z0-9)])+@([a-zA-Z0-9])+\.([a-z])+$/ 
			return reg.test(this.email);
		}

	
	isImagem(){
		if(this.imagem.length>5){
			 return true;
	}
	return false;
	
}
}

   var cliente =null
   
   function validar(){
	   
	var vnome = document.getElementById("nome").value;
	var vemail = document.getElementById("email").value;
	var vimagem = document.getElementById("imagem").value;
   // var cmd = document.getElementById("cmd").value;
	
	cliente = new Cliente(0,vnome,vemail,vimagem);
	
		var flag=1;
	    var msg ="";
	if(!cliente.isNome()){
		flag=0;
		msg+="<li>nome Invalido</li>";
	}
	if(!cliente.isEmail()){
		flag=0;
		msg+= "<li>Email Invalido </li>";
	}
	if(!cliente.isImagem()){
		flag=0;
		msg+="<li>Imagem Invalida </li>";
	}
	
	if(flag==1){
		//alert("enviar dados");
		document.getElementById("erro").innerHTML ="";
		
		document.getElementById("form1").submit();
	}else{
		document.getElementById("erro").innerHTML = msg;
		
	}
}
  function excluir(vid){
	  if (window.confirm('deseja Excluir')){
		  window.location.href='Controller?cmd=excluir&id='+vid;
	  }
  }

 
  
</script>

</body>
</html>