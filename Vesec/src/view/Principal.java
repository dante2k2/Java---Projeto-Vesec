package view;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import dao.VeiculoDAO;
import entidade.Veiculo;

public class Principal {

	public static void main(String[] args) throws SQLException {
		VeiculoDAO vdao = new VeiculoDAO();
		String chassi;
		
		
		String opc = "";
		
		while(!opc.equalsIgnoreCase("6") || opc != null){
			
			try {
				opc = JOptionPane.showInputDialog(null,"" 
									+ "1 - Cadastrar Veículo \n"
									+ "2 - Consultar veículo \n"
									+ "3 - Alterar veículo \n"
									+ "4 - Excluir veículo \n"
									+ "5 - Listar veículos \n"
									+ "6 - Encerrar sistema");
				
				switch(opc){
				
				case "1":
					String placa = JOptionPane.showInputDialog("Numeração da placa:   Ex: ABC-0000");
					if (placa == null || placa.length() < 7) break;
					String marca = JOptionPane.showInputDialog("Marca do veículo: ");
					if (marca == null  || marca.length() < 1) break;
					String modelo = JOptionPane.showInputDialog("Modelo do veículo: ");
					if (modelo == null || modelo.length() < 1) break;
					Integer ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de fabricação do veículo: "));
					if (ano < 1910  || ano > 2017) break;
					String cor = JOptionPane.showInputDialog("Cor do veículo: ");
					if (cor == null || cor.length() < 1) break;
					chassi = JOptionPane.showInputDialog("Numeração do chassi do veículo: ");
					while (chassi.length() > 17) {
						JOptionPane.showConfirmDialog(null, "Chassi Inválido!", "", JOptionPane.DEFAULT_OPTION);
						chassi = JOptionPane.showInputDialog("Numeração do chassi do veículo: "); }
					if (chassi == null || chassi.length() < 1) break;
					Veiculo veiculo = new Veiculo(placa, marca, modelo, ano, cor, chassi);
					if (vdao.adicionar(veiculo)) {
						JOptionPane.showConfirmDialog(null, "Cliente Cadastrado!", "", JOptionPane.DEFAULT_OPTION);
					} else {
						JOptionPane.showConfirmDialog(null, "Falha ao Tentar Cadastrar!", "", JOptionPane.DEFAULT_OPTION);}
					break;
				case "2":
					chassi = JOptionPane.showInputDialog("Numeração do chassi do veículo: ");
					if (chassi == null) break;
					ArrayList<Veiculo> veiculos2dao = vdao.getLista();
					boolean encontrou = false;
					for(Veiculo veiculo2 : veiculos2dao){
						if(veiculo2.getNumerochassi().equalsIgnoreCase(chassi)){
							JOptionPane.showConfirmDialog(null, veiculo2.toString(), "", JOptionPane.DEFAULT_OPTION);
							encontrou = true;
						}
					}
					if(encontrou=false){
						JOptionPane.showConfirmDialog(null, "Veículo não encontrado", "", JOptionPane.DEFAULT_OPTION);
					}
					break;
				case "3":
					chassi = JOptionPane.showInputDialog("Numeração do chassi do veículo: ");
					if (chassi == null) break;
					ArrayList<Veiculo> veiculos3dao = vdao.getLista();
					for(Veiculo veiculo3 : veiculos3dao){
						if(veiculo3.getNumerochassi().equalsIgnoreCase(chassi)){
							String opc2 = "";
							while(!opc2.equalsIgnoreCase("6")){
							opc2 = JOptionPane.showInputDialog(null,"O que deseja alterar? "+"\n"
									+ "1 - Placa \n"
									+ "2 - Marca \n"
									+ "3 - Modelo \n"
									+ "4 - Ano de Fabricação \n"
									+ "5 - Cor \n"
									+ "6 - Voltar \n"
									);
							switch(opc2){
							
								case "1":
									placa = JOptionPane.showInputDialog("Digite a placa: ");
									if (placa == null) break;
									veiculo3.setPlaca(placa);
									if (vdao.alterar(veiculo3)) {
										JOptionPane.showConfirmDialog(null, "Cliente Atualizado!", "", JOptionPane.DEFAULT_OPTION);
									} else {
										JOptionPane.showConfirmDialog(null, "Falha ao Tentar Atualizar!", "", JOptionPane.DEFAULT_OPTION);}
									break;
								case "2":
									marca = JOptionPane.showInputDialog("Digite a marca: ");
									if (marca == null) break;
									veiculo3.setMarca(marca);
									if (vdao.alterar(veiculo3)) {
										JOptionPane.showConfirmDialog(null, "Cliente Atualizado!", "", JOptionPane.DEFAULT_OPTION);
									} else {
										JOptionPane.showConfirmDialog(null, "Falha ao Tentar Atualizar!", "", JOptionPane.DEFAULT_OPTION);}
									break;
								case "3":
									modelo = JOptionPane.showInputDialog("Digite o modelo: ");
									if (modelo == null) break;
									veiculo3.setModelo(modelo);
									if (vdao.alterar(veiculo3)) {
										JOptionPane.showConfirmDialog(null, "Cliente Atualizado!", "", JOptionPane.DEFAULT_OPTION);
									} else {
										JOptionPane.showConfirmDialog(null, "Falha ao Tentar Atualizar!", "", JOptionPane.DEFAULT_OPTION);}
									break;
								case "4":
									ano =  Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricação: "));
									if (ano < 1910  || ano > 2017) break;
									veiculo3.setAnofabricacao(ano);
									if (vdao.alterar(veiculo3)) {
										JOptionPane.showConfirmDialog(null, "Cliente Atualizado!", "", JOptionPane.DEFAULT_OPTION);
									} else {
										JOptionPane.showConfirmDialog(null, "Falha ao Tentar Atualizar!", "", JOptionPane.DEFAULT_OPTION);}
									break;
								case "5":
									cor = JOptionPane.showInputDialog("Digite a cor: ");
									if (cor == null) break;
									veiculo3.setCor(cor);
									if (vdao.alterar(veiculo3)) {
										JOptionPane.showConfirmDialog(null, "Cliente Atualizado!", "", JOptionPane.DEFAULT_OPTION);
									} else {
										JOptionPane.showConfirmDialog(null, "Falha ao Tentar Atualizar!", "", JOptionPane.DEFAULT_OPTION);}
									break;
								}
							}
						}
					}
					break;
				case "4":
					chassi = JOptionPane.showInputDialog("Numeração do chassi do veículo: ");
					if (chassi == null) break;
					ArrayList<Veiculo> veiculos4dao = vdao.getLista();
					for(Veiculo veiculo4 : veiculos4dao) {
						if(veiculo4.getNumerochassi().equalsIgnoreCase(chassi)){
							if (vdao.remover(veiculo4)) {
								JOptionPane.showConfirmDialog(null, "Cliente Apagado!", "", JOptionPane.DEFAULT_OPTION);
							} else {
								JOptionPane.showConfirmDialog(null, "Falha ao Tentar Apagar!", "", JOptionPane.DEFAULT_OPTION);}
						}
					}
					break;
				case "5":
					ArrayList<Veiculo> veiculos = vdao.getLista();
					JOptionPane.showConfirmDialog(null, veiculos, "", JOptionPane.DEFAULT_OPTION);
					break;
				case "6":
					System.exit(0);
				default:
					JOptionPane.showConfirmDialog(null, "Opção Inválida!", "", JOptionPane.DEFAULT_OPTION);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}
