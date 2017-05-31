package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import conexao.Conexao;
import entidade.Veiculo;

public class VeiculoDAO {
	
	public static boolean adicionar(Veiculo veiculo) throws SQLException{
		Connection conn = null;
		String sql = "insert into veiculo (placa,marca,modelo,anofabricacao,cor,numerochassi) " + "values(?,?,?,?,?,?)";
		try {
			conn = Conexao.getConexao();
			PreparedStatement smt = conn.prepareStatement(sql); 
			smt.setString(1, veiculo.getPlaca());
			smt.setString(2, veiculo.getMarca());
			smt.setString(3, veiculo.getModelo());
			smt.setInt(4, veiculo.getAnofabricacao());
			smt.setString(5, veiculo.getCor());
			smt.setString(6, veiculo.getNumerochassi());
			smt.execute();
			smt.close();
			conn.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			conn.close();
		}
		return false;
	}
	/*public static void main(String[] args) {
		try {
			adicionar(new Contato());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/
	
	public static ArrayList<Veiculo> getLista() throws SQLException{
		Connection conn = null;
		ArrayList <Veiculo> veiculos = new ArrayList<Veiculo>();
		
		try {
			
			conn = Conexao.getConexao();
			PreparedStatement smt = conn.prepareStatement("select * from veiculo");
			ResultSet rs = smt.executeQuery();
			Veiculo veiculo = null;
			while(rs.next()){
				veiculo = new Veiculo();
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setAnofabricacao(rs.getInt("anofabricacao"));
				veiculo.setCor(rs.getString("cor"));
				veiculo.setNumerochassi(rs.getString("numerochassi"));
				veiculos.add(veiculo);
				
			}
			
			rs.close();
			smt.close();
			
		} catch (Exception e) {
			e.getMessage();
			
		}
		finally {
			conn.close();
		}
		return veiculos;
	}
	
	public static ArrayList<Veiculo> consulta() throws SQLException{
		Connection conn = null;
		ArrayList <Veiculo> veiculos = new ArrayList<Veiculo>();
		
		try {
			
			conn = Conexao.getConexao();
			PreparedStatement smt = conn.prepareStatement("select * from veiculo where numerochassi = ?");
			ResultSet rs = smt.executeQuery();
			Veiculo veiculo = null;
			while(rs.next()){
				veiculo = new Veiculo();
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setAnofabricacao(rs.getInt("anofabricacao"));
				veiculo.setCor(rs.getString("cor"));
				veiculo.setNumerochassi(rs.getString("numerochassi"));
				veiculos.add(veiculo);
				
			}
			
			rs.close();
			smt.close();
			
		} catch (Exception e) {
			e.getMessage();
			
		}
		finally {
			conn.close();
		}
		return veiculos;
	}
	public boolean alterar(Veiculo veiculo) throws SQLException{
		Connection conn = null;
		String sql = "update veiculo set placa = ?, marca = ?, modelo = ?, anofabricacao = ?, cor = ? where numerochassi = ?  ";
		try {
			conn = Conexao.getConexao();
			PreparedStatement smt = conn.prepareStatement(sql);
			smt.setString(1, veiculo.getPlaca());
			smt.setString(2, veiculo.getMarca());
			smt.setString(3, veiculo.getModelo());
			smt.setInt(4,veiculo.getAnofabricacao());
			smt.setString(5, veiculo.getCor());
			smt.setString(6, veiculo.getNumerochassi());
			
			smt.execute();
			smt.close();
			conn.close();
			return true;
			
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			conn.close();
		}
		return false;
	}
	
	public boolean remover(Veiculo veiculo) throws SQLException{
		Connection conn = null;
		String sql = "delete from veiculo where numerochassi=?";
		try {
			conn = Conexao.getConexao();
			PreparedStatement smt = conn.prepareStatement(sql);
			smt.setString(1, veiculo.getNumerochassi());
			smt.executeUpdate();
			smt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			conn.close();
		}
		return false;
	}
}
