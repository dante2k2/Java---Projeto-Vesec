package br.unipe.excecoes;

public class DadoInvalidoException extends Exception{
	public DadoInvalidoException(){
		super("Dado inválido informado");
	}
}
