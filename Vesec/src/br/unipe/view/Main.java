package br.unipe.view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.unipe.control.Fachada;
import br.unipe.excecoes.ClienteInvalidoException;
import br.unipe.excecoes.ClienteJaCadastradoException;
import br.unipe.excecoes.DadoInvalidoException;
import br.unipe.excecoes.SeguroInvalidoException;
import br.unipe.excecoes.SeguroJaCadastradoException;
import br.unipe.excecoes.VeiculoInvalidoException;
import br.unipe.excecoes.VeiculoJaCadastradoException;
import br.unipe.model.Cliente;
import br.unipe.model.Seguro;
import br.unipe.model.Veiculo;


public class Main {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,"Bem-vindo a Seguradora Exemplo");
		Fachada fachada=new Fachada();
		int opcao=0;
		while(true){
			try {
				opcao=Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar cliente\n2 - Listar Clientes\n"
						+ "3 - Atualizar dados de Clientes\n4 - Remover Cliente\n"
						+ "5 - Cadastrar Veiculo\n6 - Listar Veiculos\n"
						+ "7 - Atualizar Veiculos\n8 - Remover Veiculos\n"
						+ "9 - Adicionar Seguro\n10 - Listar Seguros\n"
						+ "11 - Atualizar Seguro\n12 - Remover Seguro\n"
						+ "13 - Finalizar Sistema"));
				switch(opcao){
				case 1:
					
					String nome=JOptionPane.showInputDialog("Digite o nome do cliente: ");
					if (nome == null || nome.length() < 2) break;
					String profissao=JOptionPane.showInputDialog("Digite a profissão do cliente: ");
					if (profissao == null || profissao.length() < 2) break;
					String cpf=JOptionPane.showInputDialog("Digite o cpf do cliente: ");
					if (cpf == null || cpf.length() < 11) break;
					String email=JOptionPane.showInputDialog("Digite o email do cliente: ");
					if (email == null || email.length() < 8) break;
					String endereco=JOptionPane.showInputDialog("Digite o endereço do cliente: ");
					if (endereco == null || endereco.length() < 5) break;
					String telefone=JOptionPane.showInputDialog("Digite o telefone do cliente: ");
					if (telefone == null || telefone.length() < 7) break;
					try {
						fachada.cadastrarCliente(nome,profissao, cpf, email,endereco,telefone);
						JOptionPane.showMessageDialog(null, "Cliente Cadastrado");
					} catch (ClienteJaCadastradoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}catch(SQLException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					
					break;
				case 2:
					try{
						fachada.listarClientes();
					}
					catch(SQLException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					break;
				case 3:
					cpf = JOptionPane.showInputDialog("Digite o cpf do cliente: ");
					if (cpf == null) break;
					Cliente cliente = fachada.verificaCliente(cpf);
					if (cliente != null) {
						String confirma = "";
						String opc = JOptionPane.showInputDialog(null,"O que deseja alterar? "+"\n"
								+ "1 - Nome \n"
								+ "2 - Profissão \n"
								+ "3 - E-mail \n"
								+ "4 - Endereço \n"
								+ "5 - Telefone \n"
								);
						switch (opc) {
						case "1":
							nome=JOptionPane.showInputDialog("Digite o nome do cliente: ");
							if (nome == null || nome.length() < 2) break;
							cliente.setNome(nome); confirma = "ok";
							break;
						case "2":
							profissao=JOptionPane.showInputDialog("Digite a profissão do cliente: ");
							if (profissao == null || profissao.length() < 2) break;
							cliente.setProfissao(profissao); confirma = "ok";
							break;
						case "3":
							email=JOptionPane.showInputDialog("Digite o email do cliente: ");
							if (email == null || email.length() < 8) break;
							cliente.setEmail(email); confirma = "ok";
							break;
						case "4":
							endereco=JOptionPane.showInputDialog("Digite o endereço do cliente: ");
							if (endereco == null || endereco.length() < 5) break;
							cliente.setEndereco(endereco); confirma = "ok";
							break;
						case "5":
							telefone=JOptionPane.showInputDialog("Digite o telefone do cliente: ");
							if (telefone == null || telefone.length() < 7) break;
							cliente.setTelefone(telefone); confirma = "ok";
							break;
						default:
							JOptionPane.showConfirmDialog(null, "Opção Inválida!", "", JOptionPane.DEFAULT_OPTION);
							break;
						}
						try {
							if (confirma.equals("ok")) {
								fachada.alteraCliente(cliente);
								JOptionPane.showMessageDialog(null, "Cliente Alterado");
							}
						} catch (ClienteInvalidoException e) {
							JOptionPane.showMessageDialog(null,e.getMessage());
						}catch(SQLException e){
							JOptionPane.showMessageDialog(null,e.getMessage());
						}
					} else {
						JOptionPane.showConfirmDialog(null, "Cliente não encontrado!", "", JOptionPane.DEFAULT_OPTION);
					}
					
					break;
				case 4:
					cpf=JOptionPane.showInputDialog("Digite o cpf do cliente: ");
					if (cpf == null || cpf.length() < 11) break;
					try {
						fachada.remover(cpf);
						JOptionPane.showMessageDialog(null, "Cliente Removido");
					} catch (ClienteInvalidoException e) {
						JOptionPane.showMessageDialog(null,e.getMessage());
					}catch(SQLException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					break;
					
				case 5:
					
					String placa=JOptionPane.showInputDialog("Digite a placa do veiculo:    Ex: 5ABC-0000");
					if (placa == null || placa.length() < 7) break;
					String marca=JOptionPane.showInputDialog("Digite a marca do veiculo: ");
					if (marca == null  || marca.length() < 1) break;
					String modelo=JOptionPane.showInputDialog("Digite o modelo do veiculo: ");
					if (modelo == null || modelo.length() < 1) break;
					int ano=Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricação: "));
					if (ano < 1910  || ano > 2017) break;
					String cor=JOptionPane.showInputDialog("Digite a cor do veiculo: ");
					if (cor == null || cor.length() < 1) break;
					String chassi=JOptionPane.showInputDialog("Digite o chassi do veiculo: ");
					while (chassi.length() > 17) {
						JOptionPane.showConfirmDialog(null, "Chassi Inválido!", "", JOptionPane.DEFAULT_OPTION);
						chassi = JOptionPane.showInputDialog("Digite o chassi do veiculo: "); }
					if (chassi == null || chassi.length() < 1) break;
					String cpfCliente=JOptionPane.showInputDialog("Digite o cpf do proprietário: ");
					if (cpfCliente == null || cpfCliente.length() < 11) break;
					try {
						fachada.cadastraVeiculo(placa,marca,modelo,ano,cor,chassi,cpfCliente);
						JOptionPane.showMessageDialog(null, "Veiculo Cadastrado");
					} catch (VeiculoJaCadastradoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}catch(ClienteInvalidoException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					catch(SQLException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					
					break;
					
				
				case 6:
					try{
						fachada.listarVeiculos();
					}
					catch(SQLException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					break;
					
				case 7:
					
					chassi = JOptionPane.showInputDialog("Digite o chassi do veiculo: ");
					if (chassi == null) break;
					Veiculo veiculo = fachada.verificaVeiculo(chassi);
					if(veiculo!=null) {
						String opc = "";
						String confirma = "";
						
							opc = JOptionPane.showInputDialog(null,"O que deseja alterar? "+"\n"
									+ "1 - Placa \n"
									+ "2 - Marca \n"
									+ "3 - Modelo \n"
									+ "4 - Ano de Fabricação \n"
									+ "5 - Cor \n"
									);
						
					
							
							switch (opc) {
							case "1":
								placa=JOptionPane.showInputDialog("Digite a placa do veiculo: ");
								if (placa == null || placa.length() < 7) break;
								veiculo.setPlaca(placa); confirma = "ok";
								break;
							case "2":
								marca=JOptionPane.showInputDialog("Digite a marca do veiculo: ");
								if (marca == null || marca.length() < 1) break;
								veiculo.setMarca(marca); confirma = "ok";
								break;
							case "3":
								modelo=JOptionPane.showInputDialog("Digite o modelo do veiculo: ");
								if (modelo == null || modelo.length() < 1) break;
								veiculo.setModelo(modelo); confirma = "ok";
								break;
							case "4":
								ano=Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricação: "));
								if (ano < 1910  || ano > 2017) break;
								
								veiculo.setAnoFabricacao(ano); confirma = "ok";
								break;
							case "5":
								cor=JOptionPane.showInputDialog("Digite a cor do veiculo: ");
								if (cor == null || cor.length() < 1) break;
								veiculo.setCor(cor); confirma = "ok";
								break;
							default:
								JOptionPane.showConfirmDialog(null, "Opção Inválida!", "", JOptionPane.DEFAULT_OPTION);
								break;
							}
							try {
								if (confirma.equals("ok")) {
									fachada.alteraVeiculo(veiculo);
									System.out.println(veiculo);
									JOptionPane.showMessageDialog(null, "Veiculo Alterado");
								}
							} catch (VeiculoInvalidoException e) {
								JOptionPane.showMessageDialog(null,e.getMessage());
							}catch(SQLException e){
								JOptionPane.showMessageDialog(null,e.getMessage());
							}
				
					
					
					}else{
						JOptionPane.showConfirmDialog(null, "Veículo não encontrado!", "", JOptionPane.DEFAULT_OPTION);
					}
					break;
				case 8:
					chassi=JOptionPane.showInputDialog("Digite o chassi do veiculo: ");
					if (chassi == null || chassi.length() < 1) break;
					try {
						fachada.removerVeiculo(chassi);
						JOptionPane.showMessageDialog(null, "Veículo Removido");
					} catch (VeiculoInvalidoException e) {
						JOptionPane.showMessageDialog(null,e.getMessage());
					}catch(SQLException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					break;
					
				case 9:
					chassi=JOptionPane.showInputDialog("Digite o chassi do veiculo: ");
					if (chassi == null || chassi.length() < 1) break;
					String valor=JOptionPane.showInputDialog("Digite o valor do seguro: ");
					if (valor == null || valor.length() < 1) break;
					int tempo=Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de duração: ", "Ex: 1 (para 1 ano)"));
					if (tempo < 1) break;
					
					try {
						fachada.adicionaSeguro(chassi,valor,tempo);
						JOptionPane.showMessageDialog(null, "Seguro Cadastrado");
					}catch (SeguroJaCadastradoException e) {
						JOptionPane.showMessageDialog(null,e.getMessage());
					} 
					catch(VeiculoInvalidoException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					catch(SQLException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					
					break;
				
				case 10:
					try{
						fachada.listarSeguros();
					}
					catch(SQLException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					break;
				case 11:
					int id=Integer.parseInt(JOptionPane.showInputDialog("Digite o id do seguro: "));
					if (id<1) break;
					Seguro seguro = fachada.verificaSeguro(id);
					if(seguro!=null) {
						String opc = "";
						String confirma = "";
						while(!opc.equalsIgnoreCase("3")){
							opc = JOptionPane.showInputDialog(null,"O que deseja alterar? "+"\n"
									+ "1 - Valor \n"
									+ "2 - Tempo \n"
									
									);
						}
					
							
							switch (opc) {
							case "1":
								valor=JOptionPane.showInputDialog("Digite o valor do seguro: ");
								if (valor == null || valor.length() < 1) break;
								seguro.setValor(valor); confirma = "ok";
								break;
							case "2":
								tempo=Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de duração: "));
								if (tempo <1) break;
								seguro.setTempo(tempo); confirma = "ok";
								break;
							
							default:
								JOptionPane.showConfirmDialog(null, "Opção Inválida!", "", JOptionPane.DEFAULT_OPTION);
								break;
							}
							try {
								if (confirma.equals("ok")) {
									fachada.alteraSeguro(seguro);;
									JOptionPane.showMessageDialog(null, "Seguro Alterado");
								}
							} catch (SeguroInvalidoException e) {
								JOptionPane.showMessageDialog(null,e.getMessage());
							}catch(SQLException e){
								JOptionPane.showMessageDialog(null,e.getMessage());
							}
				
					
					
					}else{
						JOptionPane.showConfirmDialog(null, "Seguro não encontrado!", "", JOptionPane.DEFAULT_OPTION);
					}
				
					
					break;
				case 12:
					id=Integer.parseInt(JOptionPane.showInputDialog("Digite o id do seguro: "));
					try {
						fachada.removerSeguro(id);
						JOptionPane.showMessageDialog(null, "Seguro Removido");
					} catch (VeiculoInvalidoException e) {
						JOptionPane.showMessageDialog(null,e.getMessage());
					}catch(SQLException e){
						JOptionPane.showMessageDialog(null,e.getMessage());
					}
					break;
				case 13:
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null,"Informe uma opção válida");
				
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,new DadoInvalidoException().getMessage());
			}
		}
	}
	
	
}
