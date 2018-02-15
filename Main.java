package conta_bancaria;

import java.util.Scanner;

public class Main {

	/**
	 * Instancia uma conta corrente
	 */
	static ContaBancaria conta = new ContaBancaria(0001, 2000, true);

	/**
	 * Método Principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Laço de repetição para que a leitura do teclado no console permaneça em
		 * execução
		 */
		while (true) {
			/**
			 * Exibe o menu de opções (método estático)
			 */
			exibirMenu();

			/**
			 * Inicializa o funcionamento do menu (método estático)
			 */
			manipularMenu();
		}
	}

	/**
	 * Método que contém a 
	 * impressão do menu de opções
	 */
	public static void exibirMenu() {
		/**
		 * Imprime o Menu de opções na tela
		 */
		System.out.println("==================");
		System.out.println("+++ BANCO JAVA +++");
		System.out.println("==================");
		System.out.println();
		System.out.println("Selecione a opção desejada:");
		System.out.println();
		System.out.println("1 - Consulta de saldo e limite");
		System.out.println("2 - Saque comum");
		System.out.println("3 - Saque especial");
		System.out.println("4 - Depósito");
		System.out.println("5 - sair");
	}

	/**
	 * Método responsável por acionar as opções do menu
	 */
	public static void manipularMenu() {

		//Recebe valores do teclado
		double valor = 0;
		
		//Recebe o número da opção escolhida
		int opcao = 0;

		/**
		 * Bloco try contendo a lógica do teclado
		 */
		try {
			/**
			 * Scanner de entrada via teclado no console
			 */
			Scanner scanner = new Scanner(System.in);
			String entrada = scanner.next();

			opcao = Integer.parseInt(entrada);

			if (opcao > 0 && opcao <= 5) {
				switch (opcao) {
				case 1:
					System.out.println(conta.consultarSaldo());
					break;
				case 2:
					System.out.println("Insira o valor a ser sacado da conta comum");
					valor = scanner.nextDouble();
					conta.saqueComum(valor);
					break;
				case 3:
					System.out.println("Insira o valor a ser sacado da conta especial");
					valor = scanner.nextDouble();
					conta.saqueEspecial(valor);
					break;
				case 4:
					System.out.println("Insira o valor a ser depositado");
					valor = scanner.nextDouble();
					conta.depositar(valor);
					break;
				case 5:
					System.out.println("Aplicação encerrada");
					scanner.close();
					break;
				default:
					System.out.println("Opção Inválida");
					break;
				}
			}
			/**
			 * Bloco Catch que imprime mensagem
			 * no caso de uma opção inválida 
			 * se inserida no menu.
			 */
		} catch (NumberFormatException e) {
			System.out.println("Opção inválida");
		}
	}
}
