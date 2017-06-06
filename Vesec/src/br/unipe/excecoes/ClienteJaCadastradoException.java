package br.unipe.excecoes;

public class ClienteJaCadastradoException extends Exception{
	public ClienteJaCadastradoException(){
		super("Cliente Já cadastrado");
	}
}
