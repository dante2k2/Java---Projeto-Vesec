package br.unipe.model;
/*
 * 
 * 
 * create table veiculos(
 	placa varchar(30),
    marca varchar(30),
    modelo varchar(30),
    anoFabricacao int,
    cor varchar(15),
    chassi varchar(17) PRIMARY KEY,
    cpfCliente varchar(11),
    CONSTRAINT fk_clientesVeiculos FOREIGN KEY (cpfCliente) REFERENCES clientes (cpf)
    
)*/






public class Veiculo {
	public Veiculo(String placa, String marca, String modelo,
			int anoFabricacao, String cor, String chassi, Cliente cliente) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
		this.chassi = chassi;
		this.cliente = cliente;
	}
	public Veiculo(){
		
	}
	public Veiculo(String chassi){
		this.chassi=chassi;
	}
	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", marca=" + marca + ", modelo="
				+ modelo + ", anoFabricacao=" + anoFabricacao + ", cor=" + cor
				+ ", chassi=" + chassi + ", Cpf do cliente=" + cliente.getCpf() + "]";
	}
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	private String cor;
	private String chassi;
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
}
