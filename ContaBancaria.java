package conta_bancaria;

/**
 * Representa uma conta corrente
 * 
 * @author Rafael.Valle
 *
 */
public class ContaBancaria {

	//Número da conta
	private int numero;
	
	//Saldo da conta
	private double saldo;
	
	//Status: especial ou não
	private boolean especial;
	
	//limite da conta
	private double limite;
	
	
	/**
	 * Construtor do objeto
	 * 
	 * @param numero da conta
	 * @param saldo da conta
	 * @param especial true se possuir limite especial, do contrário, false
	 */
	public ContaBancaria(int numero, double saldo, boolean especial) {
		this.numero = numero;
		this.saldo = saldo;
		this.especial = especial;
		//Se houver cheque especial, adiciona limite de 3000
		if (especial) {
			this.limite = 3000; // valor de exemplo para o limite
		}
	}

	/**
	 * Realiza saque comum
	 * @param valor : recebe o valor a ser sacado
	 */
	public void saqueComum(double valor) {
		//verifica se o saldo é suficiente e se o valor é positivo
		if ((valor > 0) && ((saldo - valor) >= 0)) {
			//Caso o valor seja válido, saca o valor do saldo
			saldo -= valor;
			System.out.println("Saque de " + valor + " efetuado");
		} else {
			//imprime mensagem de erro, caso o valor seja inválido
			System.out.println("Valor inválido");
		}
			
	}
	
	/**
	 * Realiza saque especial
	 * @param valor : recebe o valor a ser sacado
	 */
	public void saqueEspecial(double valor) {
		//verifica se o saldo especial é suficiente e se o valor é positivo
		if ((valor > 0) && ((limite - valor) >= 0)) {
			//Caso o valor seja válido, saca o valor do limite
			limite -= valor;
			System.out.println("Saque de " + valor + " efetuado");
		} else {
			//imprime mensagem de erro, caso o valor seja inválido
			System.out.println("Valor inválido");
		}
			
	}
	
	/**
	 * Efetua um depósito
	 * @param valor : recebe o valor a ser depositado
	 */
	public void depositar(double valor) {
		//Checa se o valor a ser depositado é positivo
		if (valor > 0) {
			//Caso o valor seja positivo, efetua o depósito
			saldo += valor;
			System.out.println("Depósito de R$" + valor + " efetuado.\n"
					+ "Saldo atual de " + saldo);
		}
	}
	
	/**
	 * Indica o saldo
	 * @return String com descrição do saldo e
	 * 			do limite se houver limite especial,
	 * 			do contrário, exibe apenas o saldo
	 */
	public String consultarSaldo() {
		if(especial) {
			return "Saldo atual na conta " + numero + ": R$" + saldo + " | Limite: R$" + limite;
		}
		return "Saldo atual: R$" + saldo;
	}
	
	/**
	 * 
	 * @return true se for conta especial,
	 * 		   do contrário, false. 
	 */
	public boolean isEspecial() {
		return especial;
	}
}
