package agenda;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ConexaoMySQL {

	public   List <ModelPessoa>lista = new ArrayList<ModelPessoa>();
	PessoaServlet pessoaServlet = new PessoaServlet();
	
	public void conectar() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Erro no driver SQL ");
		}

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbAgenda", "root", "");
			
			//Statement stm = conn.createStatement();
			//stm.executeUpdate(insert);
			
			PessoaServlet pessoaServlet = new PessoaServlet();
					
			String insert = "INSERT INTO tbAgenda(nome, sobrenome, dataNac, numero1, numero2, numero3, parentesco) VALUES(?,?,?,?,?,?,?)";
			System.out.println("teste2 ");
			PreparedStatement stmt = conn.prepareStatement(insert);  
			
			stmt.setString(1, pessoaServlet.modelPessoa.getNome());
			stmt.setString(2, pessoaServlet.modelPessoa.getSobrenome());
			stmt.setString(3, pessoaServlet.modelPessoa.getDataNascimento());
			stmt.setString(4, pessoaServlet.modelPessoa.getNumero1());
			stmt.setString(5, pessoaServlet.modelPessoa.getNumero2());
			stmt.setString(6, pessoaServlet.modelPessoa.getNumero3());
			stmt.setString(7, pessoaServlet.modelPessoa.getParentesco());
			
			stmt.execute();
			stmt.close();
			conn.close();
			


		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Erro ao conectar ao banco de dados");
		}

	}
	
	public void consultar() {
		pessoaServlet.listaPessoas.clear();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
			
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbAgenda", "root", "");
			Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tbAgenda");
			
            while(rs.next()){
            	ModelPessoa modelPessoa = new ModelPessoa();
            	
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String dataNascimento = rs.getString("dataNac");
                String numero1 = rs.getString("numero1");
                String numero2 = rs.getString("numero2");
                String numero3 = rs.getString("numero3");
                String parentesco = rs.getString("parentesco");
                
                modelPessoa.setNome(nome);
                modelPessoa.setSobrenome(sobrenome);
                modelPessoa.setDataNascimento(dataNascimento);
                modelPessoa.setNumero1(numero1);
                modelPessoa.setNumero2(numero2);
                modelPessoa.setNumero3(numero3);
                modelPessoa.setParentesco(parentesco);
                
                pessoaServlet.listaPessoas.add(modelPessoa);
                
                 System.out.println("Id: " + id);
                 System.out.println("Nome: " + nome);
                 System.out.println("sobrenome: " + sobrenome);
                 System.out.println("N1: " + numero1);
                 System.out.println("N2: " + numero2);
                 System.out.println("N3: " + numero3);
                 System.out.println("parentesco: " + parentesco );
                 System.out.println("Data de nascimento: " + dataNascimento);
                
             }
             stm.close();
             conn.close();
			
			
		} catch (SQLException e) {
				System.out.println("Erro ao conectar com o banco de dados");
			e.printStackTrace();
		}
		
	}

}
