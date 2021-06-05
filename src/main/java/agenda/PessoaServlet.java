package agenda;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/","/pessoa", "/enviar","/atualizar"}) // pode ser um vetor de strings com varias /nome, /nome
public class PessoaServlet extends HttpServlet{

	
	public static List listaPessoas = new ArrayList<ModelPessoa>();
	
	public static ModelPessoa modelPessoa = new ModelPessoa();
	

	public PessoaServlet() {
		//chamado somente quando é construido pela primeira vez o servlet
		System.out.println("Construindo Servlet...");
	}

	@Override
	public void init() throws ServletException {
		//chamado somente quando é construido pela primeira vez o servlet
		System.out.println("Inicializando Servlet");
		super.init();
	}

	// método mais genérico que recebe o request e response
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// apartir daqui que ele decide que vai para o método do get ou do post...
		System.out.println("Chamando o Service...");

		// esse faz o tratamento direto para ser post ou get:
		super.service(req, resp);
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// para mostrar uma mensagem ao usuario, pagina carregada pelo servlet
		
		//esse objeto ele permite configurar um objeto de encaminhamento, capaz de encaminhar a requisição
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("pessoa.jsp"); //faz encaminhamento do fluxo

		
		
		ConexaoMySQL conexao = new ConexaoMySQL();
		conexao.consultar();
		

		
			if(modelPessoa.getNumero1() != null || !listaPessoas.isEmpty()) {
				req.setAttribute("cadastros", listaPessoas);	
			}
				
	
		
		requestDispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//inserir dados no model (Modelo de arquitetura de software MVVM)
			
		String nomeCadastro = req.getParameter("nome");
		String sobrenomeCadastro = req.getParameter("sobrenome");
		String numero1 = req.getParameter("telefone1");
		String numero2 = req.getParameter("telefone2");
		String numero3 = req.getParameter("telefone3"); 
		String parentesco = req.getParameter("opcao");
		
		if(parentesco == null) {
			parentesco="";
		}
		
		
		String dataNascimento = req.getParameter("data");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date dataFormatada = (Date)sdf.parse(dataNascimento);
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			dataNascimento = sdf.format(dataFormatada);
		} catch (ParseException e) {
			System.out.println("Erro ao converter a data!");
		}
		modelPessoa.setNome(nomeCadastro);
		modelPessoa.setSobrenome(sobrenomeCadastro);
		modelPessoa.setDataNascimento(dataNascimento);
		modelPessoa.setParentesco(parentesco);
		modelPessoa.setNumero1(numero1);
		modelPessoa.setNumero2(numero2);
		modelPessoa.setNumero3(numero3);
		
		System.out.println("teste1 "+modelPessoa.getNome());
		
		//iniciar objeto da classe que realmente faz a conexão com o sgbd
		ConexaoMySQL conexao = new ConexaoMySQL();
		//fazer o insert no banco
		conexao.conectar();
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("CadastroConcluido.jsp"); //faz encaminhamento do fluxo
		requestDispatcher.forward(req, resp);
		
		// para mostrar uma mensagem ao usuario
		//resp.getWriter().print("O contato "+nomeCadastro+" foi cadastrado com sucesso!!");	
		
		
		//recarrega a pagina e mostra inserido o novo cadastro na tabela
		//doGet(req, resp);
		
					
	
		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// para mostrar uma mensagem ao usuario
		resp.getWriter().print("Chamou no método Delete");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		// para mostrar uma mensagem ao usuario
		resp.getWriter().print("Chamou no método Put");
	}

	// Momento que o servlet vai ser destruido e deixar de existir
	@Override
	public void destroy() {
		System.out.println("Servlet está sendo destruido");
		super.destroy();
	}

}
