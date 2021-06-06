package agenda;

import java.util.Date;

public class ModelPessoa {

	private int id;
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String numero1;
	private String numero2;
	private String numero3;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String parentesco;
	

	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String firstName) {
		nome = firstName;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String lastName) {
		sobrenome = lastName;
	}
	
	public String getNumero1() {
		return numero1;
	}
	public void setNumero1(String numero1) {
		this.numero1 = numero1;
	}
	public String getNumero2() {
		return numero2;
	}
	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}
	public String getNumero3() {
		return numero3;
	}
	public void setNumero3(String numero3) {
		this.numero3 = numero3;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	
}

