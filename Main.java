package conta_bancaria;

import java.util.Scanner;

public class Main {

	/**
	 * Instancia uma conta corrente
	 */
	static ContaBancaria conta = new ContaBancaria(0001, 2000, true);

	/**
	 * M�todo Principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * La�o de repeti��o para que a leitura do teclado no console permane�a em
		 * execu��o
		 */
		while (true) {
			/**
			 * Exibe o menu de op��es (m�todo est�tico)
			 */
			exibirMenu();

			/**
			 * Inicializa o funcionamento do menu (m�todo est�tico)
			 */
			manipularMenu();
		}
	}

	/**
	 * M�todo que cont�m a 
	 * impress�o do menu de op��es
	 */
	public static void exibirMenu() {
		/**
		 * Imprime o Menu de op��es na tela
		 */
		System.out.println("==================");
		System.out.println("+++ BANCO JAVA +++");
		System.out.println("==================");
		System.out.println();
		System.out.println("Selecione a op��o desejada:");
		System.out.println();
		System.out.println("1 - Consulta de saldo e limite");
		System.out.println("2 - Saque comum");
		System.out.println("3 - Saque especial");
		System.out.println("4 - Dep�sito");
		System.out.println("5 - sair");
	}

	/**
	 * M�todo respons�vel por acionar as op��es do menu
	 */
	public static void manipularMenu() {

		//Recebe valores do teclado
		double valor = 0;
		
		//Recebe o n�mero da op��o escolhida
		int opcao = 0;

		/**
		 * Bloco try contendo a l�gica do teclado
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
					System.out.println("Aplica��o encerrada");
					scanner.close();
					break;
				default:
					System.out.println("Op��o Inv�lida");
					break;
				}
			}
			/**
			 * Bloco Catch que imprime mensagem
			 * no caso de uma op��o inv�lida 
			 * se inserida no menu.
			 */
		} catch (NumberFormatException e) {
			System.out.println("Op��o inv�lida");
		}
	}
}
