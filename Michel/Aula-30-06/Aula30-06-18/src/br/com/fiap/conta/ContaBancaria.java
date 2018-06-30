package br.com.fiap.conta;

import java.time.LocalDate; 

import br.com.fiap.exepction.SaldoInsuficiente;

public class ContaBancaria {

	protected double saldo;
	protected String nomeCliente;
	protected String endCliente;
	protected String cpfCliente;
	protected LocalDate dataNascimento;
	protected LocalDate dataCriacaoconta;
	protected LocalDate dataAtual;
	
	public ContaBancaria(String nomeCliente, String endCliente, String cpfCliente, LocalDate dataNascimento, LocalDate dataCriacaoconta) {
		super();
		this.nomeCliente = nomeCliente;
		this.endCliente = endCliente;
		this.cpfCliente = cpfCliente;
		this.dataNascimento = dataNascimento;
		this.dataCriacaoconta = dataCriacaoconta;
	}
	
	public void saque(double valor) throws SaldoInsuficiente{
		saldo -= valor;
	}
	public void deposita(double valor){
		saldo += valor;
	}
	
	public LocalDate getDataAtual() {
		return LocalDate.now();
	}

}