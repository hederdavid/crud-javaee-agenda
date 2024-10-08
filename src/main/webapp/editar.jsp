<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td>
					<input id="caixa3" type="text" name="idcon" readonly value="<%out.print(request.getAttribute("idcon")); %>">
				</td>
			</tr>
			
			<tr>
				<td>
					<input class="caixa1" type="text" name="nome" placeholder="Nome" value="<%out.print(request.getAttribute("nome")); %>">
				</td>
			</tr>
		
			<tr>
				<td>
					<input class="caixa2" type="text" name="fone" placeholder="Fone" value="<%out.print(request.getAttribute("fone")); %>">
				</td>
			</tr>
		
			<tr>
				<td>
					<input class="caixa1" type="text" name="email" placeholder="E-mail" value="<%out.print(request.getAttribute("email")); %>">
				</td>
			</tr>
		</table>
		
		<input class="botao-index" type="button" value="Salvar" onclick="validar()" >
	</form>
	
	<script src="scripts/validador.js"></script>

</body>
</html>