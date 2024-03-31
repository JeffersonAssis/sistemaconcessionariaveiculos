package br.com.fuctura.tela;

import java.util.Scanner;

import br.com.fuctura.controle.ClienteControle;
import br.com.fuctura.controle.LojaControle;
import br.com.fuctura.controle.TipoVeiculoControle;
import br.com.fuctura.controle.VeiculoControle;
import br.com.fuctura.controle.VendedorControle;

public class Menu {

	static void menu() throws Exception {
		Scanner scM = new Scanner(System.in);
		ClienteControle clienteControle = new ClienteControle();
		LojaControle lojaControle = new LojaControle();
		VendedorControle vendedorControle = new VendedorControle();
		VeiculoControle veiculoControle = new VeiculoControle();
		TipoVeiculoControle tipoVeiculoControle = new TipoVeiculoControle();

		boolean menu1 = true, menu2 = true, menu3 = true;
		int op1 = 0, op2 = 0, op3 = 0;

		do {
			menu2 = true;
			System.out
					.println("Opção 1 - Frente de Loja.\n" + "Opção 2 - Manuteção no Cadastro.\n" + "Opção 3 - Sair.");
			op1 = scM.nextInt();

			switch (op1) {
			case 1: {
				do {
					menu3 = true;
					System.out.println("Opção 1 - Gerenciar Veículo\n" + "Opção 2 - Gerenciar Loja\n"
							+ "Opção 3 - Gerenciar Vendedor\n" + "Opção 4 - Gerenciar Cliente\n"
							+ "Opção 5 - Gerenciar Venda\n" + "Opção 6 - Voltar para o menu superior.");
					op2 = scM.nextInt();
					switch (op2) {
					case 1: {
						do {
						System.out.println("Opção 1 - Consultar Veículo por Placa\n"
								+ "Opção 2 - Voltar para o menu superior.");
						op3 = scM.nextInt();
						
						switch (op3) {
						case 1: {
							veiculoControle.buscar();
							break;
						}
						case 2 : {
							menu3 = false;
							break;
						}
						default:
							System.out.println("Opção Invalida!");
						}
						
						}while(menu3);
						break;
					}
					case 2: {
						do {
							System.out.println("Opção 1 - Listar todas as Lojas\n"
									+ "Opção 2 - Voltar para o menu superior.");
							op3 = scM.nextInt();
							
							switch (op3) {
							case 1: {
								lojaControle.listarLojas();
								break;
							}
							case 2 : {
								menu3 = false;
								break;
							}
							default:
								System.out.println("Opção Invalida!");
							}
							
							}while(menu3);
						break;
					}
					case 3: {
						do {
							System.out.println("Opção 1 - Consultar Vendedor por Nome\n"
									+ "Opção 2 - Voltar para o menu superior.");
							op3 = scM.nextInt();
							
							switch (op3) {
							case 1: {
								vendedorControle.buscar();
								break;
							}
							case 2 : {
								menu3 = false;
								break;
							}
							default:
								System.out.println("Opção Invalida!");
							}
							
							}while(menu3);
						break;
					}
					case 4: {
						do {
							System.out.println("Opção 1 - Cadastrar Cliente\n"
									+ "Opção 2 - Consultar Cliente por CPF\n"
									+ "Opção 3 - Voltar para o menu superior.");
							op3 = scM.nextInt();
							
							switch (op3) {
							case 1: {
								
								clienteControle.cadastra();
								
								break;
							}
							case 2 : {
								
								clienteControle.buscar();
							
								break;
							}
							case 3 : {
								menu3 = false;
								break;
							}
							default:
								System.out.println("Opção Invalida!");
							}
							
							}while(menu3);
						break;
					}
					case 5: {
						do {
							System.out.println("Opção 1 - Realizar Venda.\n"
									+ "Opção 2 - Voltar para o menu superior.");
							op3 = scM.nextInt();
							
							switch (op3) {
							case 1: {
								//cadastrar venda
								break;
							}
							case 2 : {
								menu3 = false;
								break;
							}
							default:
								System.out.println("Opção Invalida!");
							}
							
							}while(menu3);
						break;
					}
					case 6: {
						menu2 = false;
						break;
					}
					default:
						System.out.println("Opção Invalida!");
					}

				} while (menu2);

				break;
			}
			case 2: {

				do {
					menu3 = true;
					System.out.println("Opção 1 - Gerenciar Veículo\n" + "Opção 2 - Gerenciar Loja\n"
							+ "Opção 3 - Gerenciar Vendedor\n" + "Opção 4 - Gerenciar Cliente\n"
							+ "Opção 5 - Gerenciar Venda\n" + "Opção 6 - Voltar para o menu superior.");
					op2 = scM.nextInt();
					switch (op2) {
					case 1: {
						do {
						System.out.println("Informação de veiculo");
						System.out.println("Opção 1 - Cadastrar veículo.\n"
								+ "Opção 2 - Excluir veículo.\n"
								+ "Opção 3 - Alterar dados do veículo.\n"
								+ "Opção 4 - Listar tipos de veiculos.\n"
								+ "Opção 5 - Cadastra tipo de veiculo.\n"
								+ "Opção 6 - Voltar para o menu superior.");
						op3 = scM.nextInt();
						
						switch (op3) {
						case 1: {
							veiculoControle.cadastra();
							break;
						}
						case 2: {
							veiculoControle.excluir();
							break;
						}
						case 3: {
							//Alterar veiculo
							break;
						}
						case 6 : {
							menu3 = false;
							break;
						}
						case 5: {
							tipoVeiculoControle.cadastraTipo();
							break;
						}
						case 4: {
							tipoVeiculoControle.listaTipo();
							break;
						}
						default:
							System.out.println("Opção Invalida!");
						}
						
						}while(menu3);
						break;
					}
					case 2: {
						do {
							System.out.println("Informação da Loja");
							System.out.println("Opção 1 - Cadastrar Loja\n"
									+ "Opção 2 - Excluir Loja\n"
									+ "Opção 3 - Alterar dados da Loja\n"
									+ "Opção 4 - Voltar para o menu superior.");
							op3 = scM.nextInt();
							
							switch (op3) {
							case 1: {
								lojaControle.cadastra();
								break;
							}
							case 2: {
								lojaControle.excluir();
								break;
							}
							case 3: {
								lojaControle.atualizar();
								break;
							}
							case 4 : {
								menu3 = false;
								break;
							}
							default:
								System.out.println("Opção Invalida!");
							}
							
							}while(menu3);
						break;
					}
					case 3: {
						do {
							System.out.println("Informação de Vendedor");
							System.out.println("Opção 1 - Cadastrar Vendedor\n"
									+ "Opção 2 - Excluir Vendedor\n"
									+ "Opção 3 - Alterar dados do Vendedor\n"
									+ "Opção 4 - Voltar para o menu superior.");
							op3 = scM.nextInt();
							
							switch (op3) {
							case 1: {
								vendedorControle.cadastra();
								break;
							}
							case 2: {
								vendedorControle.excluir();
								break;
							}
							case 3: {
								vendedorControle.atualizar();
								break;
							}
							case 4 : {
								menu3 = false;
								break;
							}
							default:
								System.out.println("Opção Invalida!");
							}
							
							}while(menu3);
						break;
					}
					case 4: {
						do {
							System.out.println("Informação de Cliente");
							System.out.println("Opção 1 - Cadastrar Cliente\n"
									+ "Opção 2 - Excluir Cliente\n"
									+ "Opção 3 - Alterar dados do Cliente\n"
									+ "Opção 4 - Voltar para o menu superior.");
							op3 = scM.nextInt();
							
							switch (op3) {
							case 1: {
								clienteControle.cadastra();
								break;
							}
							case 2: {
								clienteControle.excluir();
								break;
							}
							case 3: {
								clienteControle.atualizar();
								break;
							}
							case 4 : {
								menu3 = false;
								break;
							}
							default:
								System.out.println("Opção Invalida!");
							}
							
							}while(menu3);
						break;
					}
					case 5: {
						do {
							System.out.println("Opção 1 - Excluir Venda\n"
									+ "Opção 2 - Voltar para o menu superior.");
							op3 = scM.nextInt();
							
							switch (op3) {
							case 1: {
								//Excluir Venda
								break;
							}
							case 2 : {
								menu3 = false;
								break;
							}
							default:
								System.out.println("Opção Invalida!");
							}
							
							}while(menu3);
						break;
					}
					case 6: {
						menu2 = false;
						break;
					}
					default:
						System.out.println("Opção Invalida!");
					}

				} while (menu2);
				
				break;
			}
			case 3: {
				System.err.println("Programa Encerrado!");
				menu1 = false;
				break;
			}
			default:
				System.out.println("Opção Invalida!");
			}

		} while (menu1);
		
		scM.close();
	}
	
}
