package br.com.fiap.Paralelismo;

public class Cavalo implements Runnable {
	Cavalo(String nome){
		this.nome = nome;
	} 
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void run() {
		for(int i=0;i<11;i++) { 
			try {
				System.out.println("Nome" + getNome() + " I: " + i);
				Thread.sleep((int)(Math.random() * 5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
