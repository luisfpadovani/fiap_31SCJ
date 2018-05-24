package br.com.fiap.entidade;

import java.util.List;

public class Aluno {
	private int id;
	private String nome;
	private String matricula;
	
	private List<AlunoCurso> alunoCurso;
	private List<AlunoCursoNota> alunoCursoNota;

	public List<AlunoCurso> getAlunoCurso() {
		return alunoCurso;
	}
	public void setAlunoCurso(AlunoCurso alunoCurso) {
		this.alunoCurso.add(alunoCurso);
	}
	public List<AlunoCursoNota> getAlunoCursoNota() {
		return alunoCursoNota;
	}
	public void setAlunoCursoNota(AlunoCursoNota alunoCursoNota) {
		this.alunoCursoNota.add(alunoCursoNota);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}