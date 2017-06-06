package br.unipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




import javax.swing.JOptionPane;

import br.unipe.conexao.Conexao;
import br.unipe.model.Cliente;
import br.unipe.model.Veiculo;


public class VeiculoDAO {
	ArrayList<Veiculo> veiculosCad=new ArrayList<Veiculo>();
	public void adicionar(Veiculo veiculo) throws SQLException{
		Connection con=null;
		String sql="INSERT INTO veiculos (placa,marca,modelo,anoFabricacao,cor,chassi,cpfCliente)"
				+ "values(?,?,?,?,?,?,?)";
		
		try {
			con=Conexao.getConexao();
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, veiculo.getPlaca());
			smt.setString(2, veiculo.getMarca());
			smt.setString(3, veiculo.getModelo());
			smt.setInt(4,veiculo.getAnoFabricacao());
			smt.setString(5, veiculo.getCor());
			smt.setString(6, veiculo.getChassi());
			smt.setString(7, veiculo.getCliente().getCpf());
			smt.execute();
			smt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
	public ArrayList<Veiculo> getLista() throws SQLException{
		Connection con=null;
		ArrayList<Veiculo> veiculos=new ArrayList<Veiculo>();
		
		try {
			con=Conexao.getConexao();
			PreparedStatement smt =con.prepareStatement("SELECT * FROM veiculos");
			ResultSet rs= smt.executeQuery();
			Veiculo veiculo=null;
			Cliente cliente=null;
			while(rs.next()){
				veiculo=new Veiculo();
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setAnoFabricacao(rs.getInt("anoFabricacao"));
				veiculo.setCor(rs.getString("cor"));
				veiculo.setChassi(rs.getString("chassi"));
				cliente=new Cliente();
				cliente.setCpf(rs.getString("cpfCliente"));
				veiculo.setCliente(cliente);
				veiculos.add(veiculo);
			}
			rs.close();
			smt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			con.close();
		}
		return veiculos;
	}
	public void alterar(Veiculo veiculo) throws SQLException {
		Connection con=null;
		String sql="UPDATE veiculos SET placa=?,marca=?,modelo=?,anoFabricacao=?,cor=?,cpfCliente=? WHERE chassi=?";
		try {
			con=Conexao.getConexao();
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, veiculo.getPlaca());
			smt.setString(2, veiculo.getMarca());
			smt.setString(3, veiculo.getModelo());
			smt.setInt(4,veiculo.getAnoFabricacao());
			smt.setString(5, veiculo.getCor());
			smt.setString(6, veiculo.getCliente().getCpf());
			smt.setString(7, veiculo.getChassi());
			smt.execute();
			smt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			con.close();
		}
		
	}
	public void remover(Veiculo veiculo) throws SQLException{
		Connection con=null;
		try {
			con=Conexao.getConexao();
			PreparedStatement smt=con.prepareStatement("delete from veiculos where chassi=?");
			smt.setString(1,veiculo.getChassi());
			smt.execute();
			smt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			con.close();
		}
	}
	public boolean existeVeiculo(String chassi) throws SQLException{
		veiculosCad=getLista();
		for(Veiculo v:veiculosCad){
			if(chassi.equals(v.getChassi())){
				return true;
			}
		}
		return false;
	}
	public void listar() throws SQLException{
		veiculosCad=getLista();
		if(veiculosCad.size()==0){
			JOptionPane.showMessageDialog(null, "Não há veiculos cadastrados");
			return;
		}
		for(Veiculo v:veiculosCad){
			JOptionPane.showMessageDialog(null,v);
		}
	}
	public Veiculo veiculo(String chassi) throws SQLException{
		veiculosCad=getLista();
		
		for(Veiculo v:veiculosCad){
			if(v.getChassi().equals(chassi)){
				return v;
			}
		}
		return null;
	}
}
