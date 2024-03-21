import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaSeq listaSeq = new ListaSeq();
		Scanner scanner = new Scanner(System.in);
			
		int pos = 0;
		
		while (true) {
			
			System.out.println("\n1 - Criar Lista\n2 - Cadastrar Aluno\n3 - Mostrar Lista\n4 - Buscar Contato\n5 - Remover Contato\n0 - Sair");
			int cont = scanner.nextInt();
			
			// Consumir a quebra de linha pendente após o próximo inteiro
			scanner.nextLine();
			
			switch (cont) {
			
				case 1:{
					
					System.out.println("\nLista criada!");
					
				break;
					
				}
				case 2:{
					
					System.out.println("-------------------------------------------------------------------------");	
					System.out.print("\nRGM: (ou 'fim' para sair): ");
					String RGM = scanner.nextLine();
					
					if (RGM.equalsIgnoreCase("fim")) {
						break;
					}
					
					System.out.print("\nNome: ");
					String nome = scanner.nextLine();
					
//					System.out.println("\nDigite o número do contato que deseja adicionar: ");
//					String numero =  scanner.nextLine();
					
					Alunos newctt = new Alunos(RGM, nome);
					
					// Verifica se a lista não está cheia antes de tentar adicionar um novo contato
				    if (listaSeq.tamanhoLista() < listaSeq.MAX) {
				        // Código para adicionar um novo contato
				        if (listaSeq.insertContato(pos, newctt)) {
				            System.out.println("\nContato adicionado com sucesso!");
				            pos++; // Incrementa a posição apenas se o contato for adicionado com sucesso
				        } else {
				            System.out.println("\nNão foi possível adicionar o contato. A lista está cheia");
				        }
				    } else {
				        System.out.println("\nNão foi possível adicionar o contato. A lista está cheia");
				    }
				    // Código para exibir a lista atualizada
				    
					System.out.println("\nLista de contatos: ");
					listaSeq.ordenar();
					listaSeq.showList();
					
				break;
				
				}
				
				
				case 3:{
					
					System.out.println("\nLista de contatos: ");
					listaSeq.ordenar();
					listaSeq.showList();
					
				break;
					
				}
				
				case 4:{
					
					System.out.println("\n1 - Busca Binária\n2 - Busca Sequencial ");
					int esc = scanner.nextInt();
					scanner.nextLine();
					
					switch (esc) {
						case 1:{
							
							System.out.println("\nNome do contato que deseja buscar(ou 'fim' para sair): ");
							String ctt = scanner.nextLine();
							
							if (ctt.equalsIgnoreCase("fim")) {
								break;
							}
							
							Alunos contatoEncontrado = listaSeq.Buscar(ctt);
								
							if(contatoEncontrado != null) {
								System.out.println("\nContato encontrado: "  + "" + contatoEncontrado.nome + " | "  + "(" + contatoEncontrado.RGM + ") " /*+  contatoEncontrado.numero*/);
							} else {
								System.out.println("\nContato não econtrado na lista.");
							}
						break;
						
						}
						
						case 2:{
							System.out.println("\nÍndice do contato que deseja buscar(ou '0' para sair): ");
							int ctt = scanner.nextInt();
							
							if (ctt == 0) {
								break;
							}
							
							int index = ctt - 1;
							listaSeq.ordenar();
								
								Alunos contatoEncontrado = listaSeq.BuscarSeq(index);
									
								if(contatoEncontrado != null) {
									System.out.println("\nContato encontrado: "  + "" + contatoEncontrado.nome + " | "  + "(" + contatoEncontrado.RGM + ") " /*+  contatoEncontrado.numero*/);
								} else {
									System.out.println("\nContato não econtrado na lista.");
								}

						break;
						
						}
					}
					
					
					
				break;
					
				}
					
				case 5:{
					
					System.out.println("\nBuscar nome do contato que deseja remover(ou 'fim' para sair): ");
					String ctt = scanner.nextLine();
					
					if (ctt.equalsIgnoreCase("fim")) {
						break;
					}
					
					Alunos contatoEncontrado = listaSeq.Buscar(ctt);
						
					if(contatoEncontrado != null) {
						System.out.println("\nContato encontrado: "  + "" + contatoEncontrado.nome + " | "  + "(" + contatoEncontrado.RGM + ") " /*+  contatoEncontrado.numero*/);
						System.out.println("\nTem certeza que deseja remover este contato?\n1 - Sim\n2 - Não");
						int esc = scanner.nextInt();
						scanner.nextLine();
						
						if(esc == 1) {
							if(listaSeq.remove(contatoEncontrado)) {
								System.out.println("\nContato removido com sucesso!");
								 pos--; // Decrementa a posição após a remoção do contato
							} else {
								System.out.println("\nFalha ao remover o contato");
							}
						}
					} else {
						System.out.println("\nContato não econtrado na lista.");
					}
					
					System.out.println("\nLista de contatos: ");
					listaSeq.ordenar();
					listaSeq.showList();
					
				break;
					
				}
				default:{
					
					System.out.println("Encerrando o programa.");
				    System.exit(0);
					
				break;	
				}
			}
			
			scanner.close();
		}
	}
}

