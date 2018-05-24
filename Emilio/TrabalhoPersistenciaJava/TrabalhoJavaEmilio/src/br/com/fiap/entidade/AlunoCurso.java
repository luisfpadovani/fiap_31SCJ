package br.com.fiap.entidade;

import java.util.List;

public class AlunoCurso {
	private int id; 
	private Aluno aluno; 
	private Curso curso;
	private List<AlunoCursoNota> alunoCursoNota;
	
	public List<AlunoCursoNota> getAlunoCursoNota() {
		return alunoCursoNota;
	}
	public void setAlunoCursoNota(List<AlunoCursoNota> alunoCursoNota) {
		this.alunoCursoNota = alunoCursoNota;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	} 
}