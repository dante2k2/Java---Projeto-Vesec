package br.unipe.dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unipe.conexao.Conexao;
import br.unipe.model.Seguro;
import br.unipe.model.Veiculo;


	public class SeguroDAO {
		ArrayList<Seguro> segurosCad=new ArrayList<Seguro>();
		public void adicionar(Seguro seguro) throws SQLException{
			Connection con=null;
			String sql="INSERT INTO seguros (chassiVeiculo,valor,tempo)"
					+ "values(?,?,?)";
			
			try {
				con=Conexao.getConexao();
				PreparedStatement smt=con.prepareStatement(sql);
				smt.setString(1, seguro.getVeiculo().getChassi());
				smt.setString(2, seguro.getValor());
				smt.setInt(3, seguro.getTempo());
				
				smt.execute();
				smt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				con.close();
			}
		}
		public ArrayList<Seguro> getLista() throws SQLException{
			Connection con=null;
			ArrayList<Seguro> seguros=new ArrayList<Seguro>();
			
			try {
				con=Conexao.getConexao();
				PreparedStatement smt =con.prepareStatement("SELECT * FROM seguros");
				ResultSet rs= smt.executeQuery();
				Seguro seguro=null;
				Veiculo veiculo=null;
				while(rs.next()){
					seguro=new Seguro();
					seguro.setId(rs.getInt("id"));
					veiculo=new Veiculo();
					veiculo.setChassi(rs.getString("chassiVeiculo"));
					seguro.setVeiculo(veiculo);
					seguro.setValor(rs.getString("valor"));
					seguro.setTempo(rs.getInt("tempo"));
					seguros.add(seguro);
				}
				rs.close();
				smt.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally{
				con.close();
			}
			return seguros;
		}
		public void alterar(Seguro seguro) throws SQLException {
			Connection con=null;
			String sql="UPDATE seguros SET chassiVeiculo=?,valor=?,tempo=? WHERE id=?";
			try {
				con=Conexao.getConexao();
				PreparedStatement smt=con.prepareStatement(sql);
				smt.setString(1, seguro.getVeiculo().getChassi());
				smt.setString(2, seguro.getValor());
				smt.setInt(3, seguro.getTempo());
				smt.setInt(4, seguro.getId());
				smt.execute();
				smt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally{
				con.close();
			}
			
		}
		public void remover(Seguro seguro) throws SQLException{
			Connection con=null;
			try {
				con=Conexao.getConexao();
				PreparedStatement smt=con.prepareStatement("delete from seguros where id=?");
				smt.setInt(1,seguro.getId());
				smt.execute();
				smt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally{
				con.close();
			}
		}
		public boolean existeSeguro(int id) throws SQLException{
			segurosCad=getLista();
			for(Seguro s:segurosCad){
				if(id==s.getId()){
					return true;
				}
			}
			return false;
		}
		public boolean existeSeguro(String chassi) throws SQLException{
			segurosCad=getLista();
			for(Seguro s:segurosCad){
				if(s.getVeiculo().getChassi().equals(chassi)){
					return true;
				}
			}
			return false;
		}
		public void listar() throws SQLException{
			segurosCad=getLista();
			if(segurosCad.size()==0){
				JOptionPane.showMessageDialog(null, "Não há seguros cadastrados");
				return;
			}
			for(Seguro s:segurosCad){
				JOptionPane.showMessageDialog(null,s);
			}
		}
		public Seguro seguro(int id) throws SQLException{
			segurosCad=getLista();
			
			for(Seguro s:segurosCad){
				if(s.getId()==id){
					return s;
				}
			}
			return null;
		}
		
	}
	
	

