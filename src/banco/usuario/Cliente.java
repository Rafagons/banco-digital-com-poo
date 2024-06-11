package banco.usuario;

import banco.contas.Conta;
import banco.contas.ContaPoupanca;
import banco.contas.ContaCorrente;
import exception.AbrirContaEx;
import exception.SaldoInsuficienteEx;
import exception.ValorInvalidoEx;

public class Cliente extends Pessoa {

	private ContaPoupanca contaPoupanca;
	private ContaCorrente contaCorrente;

	public Cliente(int cpf, String nome, String senha) {
		super(cpf, nome, senha);
		this.contaPoupanca = null;
		this.contaCorrente = null;
	}

	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void abrirConta(ContaPoupanca conta) throws AbrirContaEx {
		if (contaPoupanca != null) throw new AbrirContaEx();

		contaPoupanca = conta;
	}

	public void abrirConta(ContaCorrente conta) throws AbrirContaEx {
		if (contaCorrente != null) throw new AbrirContaEx();

		contaCorrente = conta;
	}

	public void depositar(double valor, Conta conta) throws ValorInvalidoEx {
		conta.depositar(valor);
	}

	public void sacar(double valor, Conta conta) throws ValorInvalidoEx, SaldoInsuficienteEx {
		conta.sacar(valor);
	}

	public void transferir(double valor, Conta conta, Conta contaDestino) throws SaldoInsuficienteEx, ValorInvalidoEx {
		conta.transferir(valor, contaDestino);
	}

}



