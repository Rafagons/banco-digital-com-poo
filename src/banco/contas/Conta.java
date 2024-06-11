package banco.contas;

import exception.SaldoInsuficienteEx;
import exception.ValorInvalidoEx;

public abstract class Conta {
	
	protected final int numero;
	protected final int agencia;
	protected String extrato;
	protected double saldo;

	public Conta(int numero, int agencia) {
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = 0.00;
	}

	public int getNumero() {
		return numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getExtrato() {
		String extrato = this.extrato;
		extrato += "Saldo: " + saldo;
		return extrato;
	}

	public void depositar(double valor) throws ValorInvalidoEx {
		if (valor <= 0) throw new ValorInvalidoEx();

		saldo += valor;
		extrato += "Depósito: " + valor + "\n";
	}

	public void sacar(double valor) throws ValorInvalidoEx, SaldoInsuficienteEx {
		if (valor <= 0) throw new ValorInvalidoEx();
		if (valor > saldo) throw new SaldoInsuficienteEx();

		saldo -= valor;
		extrato += "Saque: " + valor + "\n";
	}

	public void transferir(double valor, Conta conta) throws SaldoInsuficienteEx, ValorInvalidoEx {
		if (valor > saldo) throw new SaldoInsuficienteEx();
		if (valor <= 0) throw new ValorInvalidoEx();

		this.saldo -= valor;
		conta.saldo += valor;
		extrato += "Transfêrencia: -" + valor + "\n";
		conta.extrato += "Transfêrencia: +" + valor + "\n";
	}

}
