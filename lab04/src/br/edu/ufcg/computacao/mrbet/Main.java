package br.edu.ufcg.computacao.mrbet;

import java.util.Scanner;

/**
 * Classe inicial do projeto, controla as principais entradas e relaciona com as outras classes do programa.
 * @author daniele.oliveira.sousa
 *
 */
public class Main {
	
	/**
	 * Inicializa o Mr. Bet e seus principais componentes.
	 * @param args
	 */
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		MrBetSistema sistema = new MrBetSistema();
		
		while(true) {
			comando(menu(scanner), sistema, scanner);
		}
		
	}
	
	/**
	 * Menu que indica ao usuário o menu principal para que a escolha de itens seja identificada.
	 * @param scanner lê os dados do usuário
	 * @return 
	 */
	private static String menu(Scanner scanner) {
		System.out.println("\n--- Menu --- \n"
				+ "(M)Minha inclusão de times \n"
				+ "(R)Recuperar time \n"
				+ "(.)Adicionar campeonato \n"
				+ "(B)Bora incluir time em campeonato e Verificar se time está em campeonato \n"
				+ "(E)Exibir campeonatos que o time participa \n"
				+ "(T)Tentar a sorte e status \n"
				+ "(!)Já pode fechar o programa!\n"
				+ "\n"
				+ "Opção> ");
		
		return scanner.next().toUpperCase();
	}
	
	/**
	 * Menu de opções para que o usuário selecione.
	 * @param opcao opção escolhida pelo usuário
	 * @param sistema Objeto criado pela classe Sistema
	 * @param scanner Scanner que recebe os dados do usuário
	 */
	private static void comando(String opcao, MrBetSistema sistema, Scanner scanner) {
		switch (opcao) {
		case "M":
			cadastraTime(sistema, scanner);
			break;
		case "R":
			exibeTime(sistema, scanner);
			break;
		case ".":
			cadastraCampeonato(sistema, scanner);
			break;
		case "B":
			verificaTime(sistema, scanner);
			break;
		case "E":
			exibeCampeonato(sistema, scanner);
			break;
		case "T":
			criaAposta(sistema, scanner);
			break;
		case "!":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * Passa os dados para cadastrar time no sistema.
	 * @param sistema Objeto criado pela classe sistema
	 * @param scanner Scanner que recebe os dados do usuário.
	 */
	private static void cadastraTime(MrBetSistema sistema, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String codigo = scanner.next();
		System.out.print("\nNome: ");
		String nome = scanner.next();
		System.out.print("\nMascote: ");
		String mascote = scanner.next();
		
		Time novoTime = new  Time(codigo, nome, mascote);
		 
		System.out.print(sistema.cadastraTime(codigo, nome, mascote));
	}
	
	/**
	 * Passa os dados para exiber os times cadastrados no sistema
	 * @param sistema Objeto criado pela classe Sistema.
	 * @param scanner Scanner que recebe os dados do usuário.
	 */
	private static void exibeTime(MrBetSistema sistema, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String codigo = scanner.next();
		System.out.println(sistema.recuperaTimes(codigo));
	}
	
	/**
	 * Passa os dados para o cadastro do campeonato no Sistema.
	 * @param sistema Objeto criado pela classe Sistema.
	 * @param scanner Scanner que recebe os dados do usuário.
	 */
	private static void cadastraCampeonato(MrBetSistema sistema, Scanner scanner) {
		System.out.print("\nCampeonato: ");
		String nomeCampeonato = scanner.next();
		System.out.print("\nparticipantes: ");
		int participantes = scanner.nextInt();
		
		System.out.print(sistema.cadastraCampeonato(nomeCampeonato, participantes));
	}
	
	/**
	 * Passa os dados para verificar se time está incluído no sistema.
	 * @param sistema Objeto criado pela classe Sistema.
	 * @param scanner Scanner que recebe os dados do usuário.
	 */
	private static void verificaTime(MrBetSistema sistema, Scanner scanner) {
		System.out.print("\n(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
		String opcao = scanner.next();
		
		switch (opcao) {
			case "I":
				incluirTime(sistema, scanner);
				break;
			case "V":
				verificarTime(sistema, scanner);
				break;
			default:
				System.out.println("Opção inválida!");
			}
	}
	
	/**
	 * Recebe os dados e passa para incluir um time em um campeonato.
	 * @param sistema Objeto criado pela classe Sistema.
	 * @param scanner Scanner que recebe os dados do usuário.
	 */
	private static void incluirTime(MrBetSistema sistema, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String codigo = scanner.next();
		System.out.print("\nCampeonato: ");
		String campeonato= scanner.next();
		
		System.out.print(sistema.incluirTimeCampeonato(codigo, campeonato));
	}
	
	/**
	 * Passa os dados para verificar se os times estão incluídos no sistema
	 * @param sistema Objeto criado pela classe Sistema.
	 * @param scanner Scanner que recebe os dados do usuário.
	 */
	private static void verificarTime(MrBetSistema sistema, Scanner scanner ) {
		System.out.print("\nCódigo: ");
		String codigo = scanner.next();
		System.out.print("\nCampeonato: ");
		String campeonato= scanner.next();
		
		System.out.print(sistema.verificarTimeCampeonato(codigo, campeonato));
	}
	
	/**
	 * Recebe os dados e passa para exibir campeonato.
	 * @param sistema Objeto criado pela classe Sistema.
	 * @param scanner Scanner que recebe os dados do usuário.
	 */
	private static void exibeCampeonato(MrBetSistema sistema, Scanner scanner) {
		System.out.print("\nTime: ");
		String codigo = scanner.next();
		
		System.out.print(sistema.exibeCampeonato(codigo));
	}
	
	/**
	 * Recebe os dados para criar aposta.
	 * @param sistema Objeto criado pela classe Sistema
	 * @param scanner Scanner que recebe os dados do usuário
	 */
	private static void criaAposta(MrBetSistema sistema, Scanner scanner) {
		System.out.print("\n(A)Apostar ou (S)Status das Apostas? ");
		String opcao = scanner.next();
		
		switch (opcao) {
			case "A":
				incluirAposta(sistema, scanner);
				break;
			case "S":
				status(sistema);
				break;
			default:
				System.out.println("Opção inválida!");
			}
	}
	
	/**
	 * Recebe os dados para incluir aposta no sistema
	 * @param sistema Objeto criado pela classe Sistema
	 * @param scanner Scanner que recebe os dados do usuário
	 */
	private static void incluirAposta(MrBetSistema sistema, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String codigo = scanner.next();
		System.out.print("\nCampeonato: ");
		String campeonato = scanner.next();
		System.out.print("\nColocação: ");
		int colocacao = scanner.nextInt();
		System.out.print("\nValor da aposta: ");
		String valor = scanner.next();
		
		System.out.print(sistema.adicionarAposta(codigo, campeonato, colocacao, valor));
	}
	
	/**
	 * Exibe todas as apostas cadastradas.
	 * @param sistema Objeto criado pela classe Sistema
	 */
	private static void status(MrBetSistema sistema) {
		System.out.print(sistema.exibeAposta());
	}
	
	/**
	 * Sai do sistema e finaliza o código
	 */
	private static void sai() {
		System.out.println("Por hoje é só pessoal!");
		System.exit(0);
	}
	
	
}