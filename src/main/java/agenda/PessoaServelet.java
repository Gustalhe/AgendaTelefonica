package agenda;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/enviar") // pode ser um vetor de strings com varias /nome, /nome
public class PessoaServelet extends HttpServlet {

	// parte backend, o que vai rodar na parte do servidor

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Para aparecer os acentos
		resp.setCharacterEncoding("UTF-8");

		// para mostrar uma mensagem ao usuario
		resp.getWriter().print("Chamou no método Get");

		// System.out.println("chamou no método get chamaaaaa");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Para aparecer os acentos
		resp.setCharacterEncoding("UTF-8");

		// para mostrar uma mensagem ao usuario
		resp.getWriter().print("Chamou no método Post");

		// System.out.println("Chamou no método Post chamaaaa");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Para aparecer os acentos
		resp.setCharacterEncoding("UTF-8");

		// para mostrar uma mensagem ao usuario
		resp.getWriter().print("Chamou no método Delete");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Para aparecer os acentos
		resp.setCharacterEncoding("UTF-8");

		// para mostrar uma mensagem ao usuario
		resp.getWriter().print("Chamou no método Put");
	}

}
