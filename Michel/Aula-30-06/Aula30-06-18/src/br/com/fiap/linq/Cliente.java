package br.com.fiap.linq;

import java.time.LocalDate;

public class Cliente {
	
	Cliente(String nome, int idade, boolean ativo, LocalDate dataPrimeiraCompra){
		this.nome = nome;
		this.idade = idade;
		this.ativo = ativo;
		this.dataPrimeiraCompra = dataPrimeiraCompra;
	}
	
	private String nome;
	private int idade;
	private boolean ativo;
	private LocalDate dataPrimeiraCompra;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public LocalDate getDataPrimeiraCompra() {
		return dataPrimeiraCompra;
	}
	public void setDataPrimeiraCompra(LocalDate dataPrimeiraCompra) {
		this.dataPrimeiraCompra = dataPrimeiraCompra;
	}
	
	@Override
	public String toString() { 
		return "Nome: " + getNome()+ " Idade: " + getIdade()+ " Ativo: " + isAtivo()+ " Compra: " + getDataPrimeiraCompra();
	}
	
	public void setInativo() {
		 this.ativo = false;
	}
}
