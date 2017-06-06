package br.unipe.model;
/*  create table seguros(
		 id int PRIMARY KEY ,
		 chassiVeiculo varchar(17),
		 valor varchar(10),
		 tempo int,
     	 FOREIGN KEY (chassiVeiculo) REFERENCES veiculos (chassi)
    )


*/
public class Seguro {
	private int id;
	private Veiculo veiculo;
	private String valor;
	private int tempo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	@Override
	public String toString() {
		return "Seguro [id=" + id + ",Chassi do veiculo=" + veiculo.getChassi() + ", valor=" + valor
				+ ", tempo=" + tempo + "]";
	}
	
	public Seguro(int id, Veiculo veiculo, String valor, int tempo) {
		super();
		this.id=id;
		this.veiculo = veiculo;
		this.valor = valor;
		this.tempo = tempo;
	}
	public Seguro(Veiculo veiculo, String valor, int tempo) {
		super();
		this.veiculo = veiculo;
		this.valor = valor;
		this.tempo = tempo;
	}
	public Seguro(){
		
	}
	
	public Seguro(int id){
		this.id=id;
	}
	
	
	
}
