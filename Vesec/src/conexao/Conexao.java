package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection getConexao(){
		Connection conexao = null;
		String servidor = "jdbc:mysql://localhost";
		String porta = "3306";
		String banco = "vesec";
		String usuario = "root";
		String senha = "";
		String url = servidor+":"+porta+"/"+banco;
		try {
			
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			conexao = DriverManager.getConnection(url,usuario,senha);
			
		} catch (Exception e) {
			e.getMessage();
		}
		return conexao;
	}
	
	public static void main(String[] args) {
		Connection conexao = null;
		try {
			for(int i=0;i<5;i++){
				conexao = new Conexao().getConexao();
				System.out.println("Conexão: "+(i+1)+" - "+conexao.toString());
				conexao.close();
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
