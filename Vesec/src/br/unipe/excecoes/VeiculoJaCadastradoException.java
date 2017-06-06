package br.unipe.excecoes;

public class VeiculoJaCadastradoException extends Exception{
	public VeiculoJaCadastradoException(){
		super("Veiculo já cadastrado!");
	}
}
