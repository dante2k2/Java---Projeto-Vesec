package entidade;

import java.util.Calendar;

public class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private int anofabricacao;
	private String cor;
	private String numerochassi;//<----- é uma marcação de numeros e letras de 17 caracteres
	
	public Veiculo () {}
	
	public Veiculo(String placa, String marca, String modelo, int anofabricacao, String cor, String numerochassi) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anofabricacao = anofabricacao;
		this.cor = cor;
		this.numerochassi = numerochassi;
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
	public int getAnofabricacao() {
		return anofabricacao;
	}
	public void setAnofabricacao(int anofabricacao) {
		this.anofabricacao = anofabricacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getNumerochassi() {
		return numerochassi;
	}
	public void setNumerochassi(String numerochassi) {
		this.numerochassi = numerochassi;
	}
	
	@Override
	public String toString() {
		
		return "-----------------"+"\n"+"Placa: "+this.getPlaca()+"\n"+"Marca: "+this.getMarca()+"\n"+"Modelo: "+this.getModelo()
		+"\n"+"Ano de Fabricação: "+this.getAnofabricacao()+"\n"+"Cor: "+this.getCor()+"\n"+"NIV: "+this.getNumerochassi()+"\n";
	}
	
}
