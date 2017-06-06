package br.unipe.conexao;
import java.sql.*;
public class Conexao {
	public static Connection getConexao(){ //throws ConexaoException{
		
		Connection conexao=null;
		String servidor="jdbc:mysql://localhost";
		String porta="3306";
		String banco="unipe";
		String usuario="root";
		String senha="";
		String url=servidor+":"+porta+"/"+banco;
		try{
			String driveName="com.mysql.jdbc.Driver";
			Class.forName(driveName);
			conexao=DriverManager.getConnection(url,usuario,senha);
		}catch(Exception e){
			e.getMessage();
		}
		return conexao;
	}
	/*
	public static void main(String[] args) {
		Connection conexao=null;
		try{
			for(int i=0;i<5;i++){
				conexao=new Conexao().getConexao();
				System.out.println("Conexao: "+i+"-"+conexao.toString());
				conexao.close();
				
			}
		}catch(Exception e){
			e.getMessage();
		}
	}*/
}
