package conta_bancaria;

/**
 * Representa uma conta corrente
 * 
 * @author Rafael.Valle
 *
 */
public class ContaBancaria {

	//N�mero da conta
	private int numero;
	
	//Saldo da conta
	private double saldo;
	
	//Status: especial ou n�o
	private boolean especial;
	
	//limite da conta
	private double limite;
	
	
	/**
	 * Construtor do objeto
	 * 
	 * @param numero da conta
	 * @param saldo da conta
	 * @param especial true se possuir limite especial, do contr�rio, false
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
		//verifica se o saldo � suficiente e se o valor � positivo
		if ((valor > 0) && ((saldo - valor) >= 0)) {
			//Caso o valor seja v�lido, saca o valor do saldo
			saldo -= valor;
			System.out.println("Saque de " + valor + " efetuado");
		} else {
			//imprime mensagem de erro, caso o valor seja inv�lido
			System.out.println("Valor inv�lido");
		}
			
	}
	
	/**
	 * Realiza saque especial
	 * @param valor : recebe o valor a ser sacado
	 */
	public void saqueEspecial(double valor) {
		//verifica se o saldo especial � suficiente e se o valor � positivo
		if ((valor > 0) && ((limite - valor) >= 0)) {
			//Caso o valor seja v�lido, saca o valor do limite
			limite -= valor;
			System.out.println("Saque de " + valor + " efetuado");
		} else {
			//imprime mensagem de erro, caso o valor seja inv�lido
			System.out.println("Valor inv�lido");
		}
			
	}
	
	/**
	 * Efetua um dep�sito
	 * @param valor : recebe o valor a ser depositado
	 */
	public void depositar(double valor) {
		//Checa se o valor a ser depositado � positivo
		if (valor > 0) {
			//Caso o valor seja positivo, efetua o dep�sito
			saldo += valor;
			System.out.println("Dep�sito de R$" + valor + " efetuado.\n"
					+ "Saldo atual de " + saldo);
		}
	}
	
	/**
	 * Indica o saldo
	 * @return String com descri��o do saldo e
	 * 			do limite se houver limite especial,
	 * 			do contr�rio, exibe apenas o saldo
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
	 * 		   do contr�rio, false. 
	 */
	public boolean isEspecial() {
		return especial;
	}
}
