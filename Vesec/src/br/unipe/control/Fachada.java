package br.unipe.control;

import java.sql.SQLException;

import br.unipe.dao.ClienteDAO;
import br.unipe.dao.SeguroDAO;
import br.unipe.dao.VeiculoDAO;
import br.unipe.excecoes.ClienteInvalidoException;
import br.unipe.excecoes.ClienteJaCadastradoException;
import br.unipe.excecoes.SeguroInvalidoException;
import br.unipe.excecoes.SeguroJaCadastradoException;
import br.unipe.excecoes.VeiculoInvalidoException;
import br.unipe.excecoes.VeiculoJaCadastradoException;
import br.unipe.model.Cliente;
import br.unipe.model.Seguro;
import br.unipe.model.Veiculo;



public class Fachada {
	Cliente cliente;
	Veiculo veiculo;
	ClienteDAO clienteDao;
	VeiculoDAO veiculoDao;
	SeguroDAO seguroDao;
	Seguro seguro;
	public Fachada(){
		clienteDao=new ClienteDAO();
		veiculoDao=new VeiculoDAO();
		seguroDao=new SeguroDAO();
	}
	public void cadastrarCliente(String nome,String profissao,String cpf,String email,String endereco,String telefone)
			throws ClienteJaCadastradoException, SQLException{
		if(!clienteDao.existeCliente(cpf)){
			cliente=new Cliente(nome,profissao,cpf,email,endereco,telefone);
			clienteDao.adicionar(cliente);
		}
		else{
			throw new ClienteJaCadastradoException();
		}
		
	}
	public void listarClientes() throws SQLException{
		clienteDao.listar();
	}
	public void alteraCliente(Cliente cliente)
			throws ClienteInvalidoException, SQLException{
		if(clienteDao.existeCliente(cliente.getCpf())){
			clienteDao.alterar(cliente);
		}
		else{
			throw new ClienteInvalidoException();
		}
	}
	public void remover(String cpf) throws ClienteInvalidoException, SQLException{
		if(clienteDao.existeCliente(cpf)){
			cliente=new Cliente(cpf);
			clienteDao.remover(cliente);
		}
		else{
			throw new ClienteInvalidoException();
		}
	}
	public void cadastraVeiculo(String placa,String marca,String modelo,int ano,String cor,String chassi,String cpfCliente)
			throws ClienteInvalidoException,VeiculoJaCadastradoException,SQLException{
		if(!veiculoDao.existeVeiculo(chassi)){
			if(clienteDao.existeCliente(cpfCliente)){
				cliente=clienteDao.cliente(cpfCliente);
				veiculo=new Veiculo(placa,marca,modelo,ano,cor,chassi,cliente);
				veiculoDao.adicionar(veiculo);
			}
			else{
				throw new ClienteInvalidoException();
			}
			
		}
		else{
			throw new VeiculoJaCadastradoException();
		}
	}
	public void listarVeiculos() throws SQLException{
		veiculoDao.listar();
	}
	public void alteraVeiculo(Veiculo veiculo)
			throws VeiculoInvalidoException,SQLException{
		if(!veiculoDao.existeVeiculo(veiculo.getChassi())){
			veiculoDao.alterar(veiculo);
		}
		else{
			throw new VeiculoInvalidoException();
		}
	}
	public void removerVeiculo(String chassi) throws VeiculoInvalidoException, SQLException{
		if(veiculoDao.existeVeiculo(chassi)){
			veiculo=new Veiculo(chassi);
			veiculoDao.remover(veiculo);;
		}
		else{
			throw new VeiculoInvalidoException();
		}
	}
	public void adicionaSeguro(String chassi,String valor,int tempo) throws VeiculoInvalidoException,SQLException,SeguroJaCadastradoException{
		if(!seguroDao.existeSeguro(chassi)){
			if(veiculoDao.existeVeiculo(chassi)){
				veiculo=veiculoDao.veiculo(chassi);
				seguro=new Seguro(veiculo,valor,tempo);
				seguroDao.adicionar(seguro);
			}else{
				throw new VeiculoInvalidoException();
			}
			
		}
		else{
			throw new SeguroJaCadastradoException();
		}
			
	}
	public void listarSeguros() throws SQLException{
		seguroDao.listar();
	}
	public void alteraSeguro(Seguro seguro) throws SQLException,SeguroInvalidoException{
		if(seguroDao.existeSeguro(seguro.getId())){
			
			seguroDao.alterar(seguro);
		}
		else{
			throw new SeguroInvalidoException();
		}
		
	}
	public void removerSeguro(int id) throws VeiculoInvalidoException, SQLException{
		if(seguroDao.existeSeguro(id)){
			seguro=new Seguro(id);
			seguroDao.remover(seguro);;
		}
		else{
			throw new VeiculoInvalidoException();
		}
	}
	
	public Cliente verificaCliente(String cpf) throws SQLException {
		return clienteDao.cliente(cpf);
	}
	public Veiculo verificaVeiculo(String chassi) throws SQLException {
		return veiculoDao.veiculo(chassi);
	}
	public Seguro verificaSeguro(int id) throws SQLException {
		return seguroDao.seguro(id);
	}
	
}
