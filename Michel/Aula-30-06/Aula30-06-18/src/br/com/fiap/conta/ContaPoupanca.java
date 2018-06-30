package br.com.fiap.conta;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.fiap.exepction.SaldoInsuficiente;

public class ContaPoupanca extends ContaBancaria {

	public ContaPoupanca(String nomeCliente, String endCliente, String cpfCliente, LocalDate dataNascimento,
			LocalDate dataCriacaoConta) {
		super(nomeCliente, endCliente, cpfCliente, dataNascimento, dataCriacaoConta);
	}

	public void saque(double valor) throws SaldoInsuficiente { 
		long meses = ChronoUnit.MONTHS.between(dataCriacaoconta, getDataAtual()); 
		if ((saldo - valor- 0.10) < 0) {
			throw new SaldoInsuficiente("Saldo Insuficiente para o Saque.");
		}

		if (meses > 12) {
			System.out.println("Cliente registrado h� " + meses);
			saldo -= valor;
		} else {
			saldo -= valor - 0.10;
		}

	}

	public boolean equals(Object obj) {
		ContaPoupanca conta = (ContaPoupanca) obj;
		return (conta.cpfCliente.equals(this.cpfCliente));
	}
}