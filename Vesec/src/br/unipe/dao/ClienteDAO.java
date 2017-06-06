package br.unipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unipe.conexao.Conexao;
import br.unipe.model.Cliente;


public class ClienteDAO {
	ArrayList<Cliente> clientesCad=new ArrayList<Cliente>();
	
	public void adicionar(Cliente cliente) throws SQLException{
		Connection con=null;
		String sql="INSERT INTO clientes (nome,profissao,cpf,email,endereco,telefone)"
				+ "values(?,?,?,?,?,?)";
		
		try {
			con=Conexao.getConexao();
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, cliente.getNome());
			smt.setString(2, cliente.getProfissao());
			smt.setString(3, cliente.getCpf());
			smt.setString(4,cliente.getEmail());
			smt.setString(5, cliente.getEndereco());
			smt.setString(6, cliente.getTelefone());
			smt.execute();
			smt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
	public ArrayList<Cliente> getLista() throws SQLException{
		Connection con=null;
		ArrayList<Cliente> clientes=new ArrayList<Cliente>();
		
		try {
			con=Conexao.getConexao();
			PreparedStatement smt =con.prepareStatement("SELECT * FROM clientes");
			ResultSet rs= smt.executeQuery();
			Cliente cliente=null;
			while(rs.next()){
				cliente=new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setProfissao(rs.getString("profissao"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefone(rs.getString("telefone"));
				
				clientes.add(cliente);
			}
			rs.close();
			smt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			con.close();
		}
		return clientes;
	}
	public void alterar(Cliente cliente) throws SQLException {
		Connection con=null;
		String sql="UPDATE clientes SET nome=?,profissao=?,email=?,endereco=?,telefone=? WHERE cpf=?";
		try {
			con=Conexao.getConexao();
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, cliente.getNome());
			smt.setString(2, cliente.getProfissao());			
			smt.setString(3, cliente.getEmail());
			smt.setString(4, cliente.getEndereco());
			smt.setString(5, cliente.getTelefone());
			smt.setString(6, cliente.getCpf());
			smt.execute();
			smt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			con.close();
		}
		
	}
	public void remover(Cliente cliente) throws SQLException{
		Connection con=null;
		try {
			con=Conexao.getConexao();
			PreparedStatement smt=con.prepareStatement("delete from clientes where cpf=?");
			smt.setString(1,cliente.getCpf());
			smt.execute();
			smt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			con.close();
		}
	}
	public boolean existeCliente(String cpf) throws SQLException{
		clientesCad=getLista();
		for(Cliente c:clientesCad){
			if(cpf.equals(c.getCpf())){
				return true;
			}
		}
		return false;
	}
	public void listar() throws SQLException{
		clientesCad=getLista();
		if(clientesCad.size()==0){
			JOptionPane.showMessageDialog(null, "Não há clientes cadastrados");
			return;
		}
		for(Cliente c:clientesCad){
			JOptionPane.showMessageDialog(null,c);
		}
	}
	public Cliente cliente(String cpf) throws SQLException{
		clientesCad=getLista();
		
		for(Cliente c:clientesCad){
			if(c.getCpf().equals(cpf)){
				return c;
			}
		}
		return null;
	}
}
