<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="agenda.ModelPessoa"%>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<style type="text/css">
	
	
	/* Todos os elementos da página */
*{
    margin: 0;
    padding: 0;
}

/* Elementos com o ID "titulo" */
#titulo {
    font-family: sans-serif;
    color: #002b7a;
    padding-top: 2%;
    animation-name: fadebotao;
    animation-duration: 2s;
    
} 


/* Elementos com o ID "subtitulo" */
#subtitulo {
    font-family: sans-serif;
    color: #002b7a;
    margin-left:6%;
    animation-name: fadebotao;
    animation-duration: 2s;
} 

table{
    text-align: center;
	margin-left: 28%;
	border-color: #F0F8FF;
	margin-top: 2%;
	animation-name: fade;
    animation-duration: 2s;
	overflow: scroll;
}

table, td {
     border: 2px solid rgb(90, 90, 90);
}
tr:nth-child(even) {background-color: #f2f2f2}
td{
	padding: 5px;
}

#check{
    display: inline-block;
}

/* Elementos de tag <fieldset>*/
fieldset {
    border: 0;
    animation-name: fade;
    animation-duration: 1s;
}

/* Elemento de tag <body> */
body{
   background-color: #E0E0F8;   
    font-family: sans-serif;
    font-size: 1em;
    color: #002b7a;
   /* margin-top: 1%;*/
    /*margin-left: 39%;*/
     
}


/* Elementos de tags <body>, <input>, <Select>, <textarea> e <button> */
input, select, textarea, button {
    font-family: sans-serif;
    font-size: 1em;
    color: #002b7a;
    border-radius: 5px;
    animation-name: fade;
    animation-duration: 1s;
}

/* Elementos de classe "grupo" nos estados das pseudoclasses "before" e "after" */
.grupo:before, .grupo:after {
    display: table;
    

}

/* Elementos de classe "grupo" no estado da pseudoclasse "after" */
.grupo:after {
    clear: both;
    
    
}
exc{
	cursor: pointer;
	color: #002b7a
}

exc:hover{
	color: #FF0000;
}

edt{
	cursor: pointer;
	color: #002b7a;
}

edt:hover{
color: #00BFFF;

}

/* Elementos de classe "campo" */
.campo {
    margin-bottom: 1em;
    justify-content: center;
    animation-name: fade;
    animation-duration: 1s;
}

#formulario{
	margin-left: 40%;
}

/* Elementos de classe "campo" de tag <label> */
.campo label {
    margin-bottom: 0.2em;
    color: #002b7a;
    animation-name: fade;
    animation-duration: 1s;
    display: block;
}

/* Elementos de classe "campo" ou "grupo" de tag <fieldset> */
fieldset.grupo .campo {
    float:  left;
    margin-right: 1em;
    /*margin-top: 20px;*/
    animation-name: fade;
    animation-duration: 1s;
}

/* Elementos de classe "campo" das tags <input> com atributo text e date, da tag <select> e da tag <textarea>*/
.campo input[type="text"], .campo input[type="date"], .campo input[type="phone"], .campo select{
    padding: 0.2em;
    border: 1px solid #59429d;
    box-shadow: 2px 2px 2px rgba(0,0,0,0.2);
    display: block;
    animation-name: fade;
    animation-duration: 1s;
}

/* Elementos de classe "campo" de tag <select> e <option>*/
.campo select option {
    padding-right: 1em;
    animation-name: fade;
    animation-duration: 1s;
}

/* Elemento de classe "campo" com tag <input>, <select> e <textarea> tocas com estado da pseudoclasse "focus"*/
.campo input:focus, .campo select:focus, .campo textarea:focus {
    background: #E0E0F8;
    animation-name: fade;
    animation-duration: 1s;
}

/* Elemento de classe "botao" */
#botaoEnviar {
    font-size: 1.2em;
    background: #59429d;
    border: 0;
    margin-bottom: 1em;
    color: #ffffff;
    padding: 0.2em 0.6em;
    box-shadow: 2px 2px 2px rgba(0,0,0,0.2);
    text-shadow: 1px 1px 1px rgba(0,0,0,0.5);
    position: absolute;
    top: 42%;
    left: 51%;
    animation-name: fadebotao;
    animation-duration: 3s;
    margin-right: -50%;
    cursor: pointer;
    transform: translate(-50%, -50%);
}

#botaoAtualizar{
 font-size: 1.2em;
    background: #59429d;
    border: 0;
    margin-bottom: 1em;
    cursor: pointer;
    color: #ffffff;
    padding: 0.2em 0.6em;
    box-shadow: 2px 2px 2px rgba(0,0,0,0.2);
    text-shadow: 1px 1px 1px rgba(0,0,0,0.5);
    position: absolute;
    top: 42%;
    left: 72%;
    animation-name: fadebotao;
    animation-duration: 3s;
    margin-right: -50%;
    transform: translate(-50%, -50%);
}

/* Elemento de classe "botao" com o estado da pseudoclasse "hover" */
#botaoEnviar:hover {
    background: #CCBBFF;
    box-shadow: inset 2px 2px 2px rgba(0,0,0,0.2);
    text-shadow: none;
}



#botaoAtualizar:hover{
	background: #CCBBFF;
    box-shadow: inset 2px 2px 2px rgba(0,0,0,0.2);
    text-shadow: none;

}

#check{
    display: inline-block;
}


@keyframes fade {
    from{
        opacity: 0;
        transform: scale(0.8);
    }to{
        opacity: 1;
        transform: scale(1);
    }
}

@keyframes fadebotao {
    from{
        opacity: 0;     
    }to{
        opacity: 1;      
    }
}

	
	
	
	
	
	</style>
	
	
	
	
	
	<title>Agenda Telefônica</title>

<script>
	function confirmar(pi){
		if(window.confirm("Confirma a exclusão?")){
			location.href="excluir?act=excluir&i="+pi;	
		}			
	}		
					
</script>


	
</head>




<body>

<%
		ModelPessoa modelPessoaEdit = (ModelPessoa) request.getAttribute("contatoEditar");						
%>



	<form id="formulario" method="post" action="enviar">
		<div>
			<h1 id="titulo">Cadastro Agenda Telefônica</h1>
			<p id="subtitulo">Complete as informações do contato</p>
			<br>
		</div>

		<fieldset class="grupo">
			<div class="campo">
				<label for="nome"> <strong>Nome:</strong></label> 
				<input type="text" name="nome" id="nome" required 
				value = <%if(modelPessoaEdit!=null){out.print("'"+modelPessoaEdit.getNome()+"'");} %>>
			</div>

			<div class="campo">
				<label for="sobrenome"><strong>Sobrenome:</strong></label> 
				<input type="text" name="sobrenome" id="sobrenome" required
				value = <%if(modelPessoaEdit!=null){out.print("'"+modelPessoaEdit.getSobrenome()+"'");} %>>
			</div>
		</fieldset>

		<fieldset class="grupo">

			<div class="campo">
				<label for="telefone"><strong>Número:</strong></label> 
				<input type="phone" pattern="[0-9]+$" name="telefone1" required
				value = <%if(modelPessoaEdit!=null){out.print("'"+modelPessoaEdit.getNumero1()+"'");} %>>
			</div>

			<div class="campo">
				<label for="dataNaascimento"><strong>Data deNascimento:</strong></label> 
				<input type="date" name="data" id="data" required
				value = <%if(modelPessoaEdit!=null){
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dataNacEdit = sdf.parse(modelPessoaEdit.getDataNascimento());
					sdf = new SimpleDateFormat("yyyy-MM-dd");
	
					out.print("'"+sdf.format(dataNacEdit)+"'");			
				
					} %>>
			</div>

		</fieldset>

		<fieldset class="grupo">
			<div class="campo">
				<label for="telefone"><strong>Número 2:</strong></label> 
				<input type="phone" pattern="[0-9]+$" name="telefone2"
				value= <%if(modelPessoaEdit!=null){out.print("'"+modelPessoaEdit.getNumero2()+"'");} %>>
			</div>

			<div class="campo">
				<label for="telefone"><strong>Número 3:</strong></label> 
				<input type="phone" pattern="[0-9]+$" name="telefone3"
				value= <%if(modelPessoaEdit!=null){out.print("'"+modelPessoaEdit.getNumero3()+"'");} %>>
			</div>
		</fieldset>

		<div class="campo">
			<label> <strong>Qual o grau de parentesco?</strong> </label>
			 
			<label> <input type="radio" name="opcao" value="Mae/Pai" id="opcao" 
			<% if(modelPessoaEdit!=null && modelPessoaEdit.getParentesco().equals("Mae/Pai")){out.print("checked");}%>>Mãe/Pai</label> 
			
			<label> <input type="radio" name="opcao" value="Filho(a)" id="opcao"
			<% if(modelPessoaEdit!=null && modelPessoaEdit.getParentesco().equals("Filho(a)")){out.print("checked");}%>>Filho(a)</label> 
			
			<label> <input type="radio" name="opcao" value="Avôs" id="opcao"
			<% if(modelPessoaEdit!=null && modelPessoaEdit.getParentesco().equals("Avôs")){out.print("checked");}%>>Avô/Avó</label> 
			
			<label> <input type="radio" name="opcao" value="Outro" id="opcao"
			<% if(modelPessoaEdit!=null && modelPessoaEdit.getParentesco().equals("Outro")){out.print("checked");}%>>Outro</label>
		</div>

		<div id="sobotao">
			<button id="botaoEnviar" type="submit" onsubmit="">Concluído</button>
			
		</div>
	</form>
	
	
	<a href="http://localhost:8080/AgendaTelefonica/"><button id="botaoAtualizar" type="button">Atualizar</button></a>


	<table border="1">
				<tr> 
					<td><strong> Editar: </strong></td>
					<td><strong> Excluir: </strong></td>
					<td><strong> Nome: </strong></td>
					<td><strong>Sobrenome: </strong></td>
					<td><strong>Data de nascimento: </strong></td>
					<td><strong>Parentesco: </strong></td>
					<td><strong>Telefone 1: </strong></td>
					<td><strong>Telefone 2: </strong></td>
					<td><strong>Telefone 3: </strong></td>
				</tr>	
				
				
	<%
	
	 //<br/>
	if(request.getAttribute("cadastros") != null){
		List<ModelPessoa> lista = (List<ModelPessoa>)request.getAttribute("cadastros");	
		
		
		for(ModelPessoa mp: lista){
			if(lista != null){
							
				out.print("<tr>"+ 
							"<td> <a  href='editar?act=editar&i="+mp.getId()+"'> <edt> Editar </edt></a></td>"+ 
							"<td> <a  href='javascript:confirmar("+mp.getId()+")'> <exc> X </exc></a></td>"+ 
							"<td>"+mp.getNome()+"</td>"+ 
							"<td>"+mp.getSobrenome()+"</td>"+ 
							"<td>"+mp.getDataNascimento()+"</td>"+
							"<td>"+mp.getParentesco()+"</td>"+
							"<td>"+mp.getNumero1()+"</td>"+
							"<td>"+mp.getNumero2()+"</td>"+
							"<td>"+mp.getNumero3()+"</td>"+
							"</tr>");		
			}
		}
	}else{
		
	}
	
	
	

	%>
	
	</table>

	
	

</body>


</html>