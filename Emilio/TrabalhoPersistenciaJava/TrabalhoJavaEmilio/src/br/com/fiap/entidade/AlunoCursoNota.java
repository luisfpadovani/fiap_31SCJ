package br.com.fiap.entidade;


public class AlunoCursoNota {
	private int id; 
	private int nota; 
	private AlunoCurso alunoCurso;

	
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AlunoCurso getAlunoCurso() {
		return alunoCurso;
	}
	public void setAlunoCurso(AlunoCurso alunoCurso) {
		this.alunoCurso = alunoCurso;
	}
	 
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	} 
	
}