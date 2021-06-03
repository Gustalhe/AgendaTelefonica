package agenda;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConexaoMySQL {

	public void conectar() {

			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbAgenda", "root", "");
			Statement stm = conn.createStatement();
			
			PessoaServlet pessoaServlet = new PessoaServlet();
					
			System.out.println("chegou no destino e o nome do contato é: "+pessoaServlet.modelPessoa.getNome());
			
			//fazer as inserções no banco de dados
			
			 /*
			  stm.executeUpdate("insert into tbCliente(nome, dataNascimento)" +
			 "values (\"" + nome + " \", '" + "" + dataNascimento + "');");*/
			 

			stm.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Erro ao conectar ao banco de dados");
		}

	}

}
