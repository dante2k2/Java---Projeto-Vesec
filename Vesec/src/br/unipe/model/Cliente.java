package br.unipe.model;



/* create table clientes(
 *  nome varchar(40),
 *  profissao varchar(30),
 *  cpf varchar(11) PRIMARY KEY,
 *  email varchar(30),
 *   endereco varchar(50),
 *   telefone varchar(12)
 *    )*/
public class Cliente {
	public Cliente(){
		
	}
	public Cliente(String cpf){
		this.cpf=cpf;
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", profissao=" + profissao + ", cpf="
				+ cpf + ", email=" + email + ", Endereco=" + Endereco
				+ ", telefone=" + telefone + "]";
	}
	public Cliente(String nome, String profissao, String cpf, String email,
			String endereco, String telefone) {
		super();
		this.nome = nome;
		this.profissao = profissao;
		this.cpf = cpf;
		this.email = email;
		Endereco = endereco;
		this.telefone = telefone;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	private String nome;
	private String profissao;
	private String cpf;
	private String email;
	private String Endereco;
	private String telefone;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
