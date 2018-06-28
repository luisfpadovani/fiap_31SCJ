package br.com.fiap.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fiap.entity.Aluno;
import br.com.fiap.jdbc.dao.AlunoDao;
import br.com.fiap.jpa.helper.AlunoHelper;

public class Main {

	public static final String[] tecnologias = { "JDBC", "JPA" };
	public static String tecnologiaSelecionada;
	
	public static final String[] menus = { "CADASTRAR ALUNO", "CADASTRAR CURSO", "CADASTRAR NOTA", "LISTAR ALUNOS", "LISTAR CURSOS", "LISTAR NOTAS" };
	public static String menuSelecionado;
	
	private static boolean encerrarPrograma = false;

	public static void main(String[] args) {
		while (!encerrarPrograma) {
			Tecnologia();
			Menu();
			RealizarAcao();
			DesejaNovamente();
		}
	}
	
	private static void DesejaNovamente(){
		encerrarPrograma = true;
	}
	
	private static void RealizarAcao() {
		
	}

	private static void Menu() {
		JFrame frame = new JFrame("Menu a selecionar");
		menuSelecionado = (String) JOptionPane.showInputDialog(frame, "Selecione qual a��o deseja usar", "Menu",
				JOptionPane.QUESTION_MESSAGE, null, menus, menus[0]);

		if (menuSelecionado == null) {
			menuSelecionado = menus[0];
		} 
	}

	private static void Tecnologia() {
		JFrame frame = new JFrame("Tecnologia a se usar");
		tecnologiaSelecionada = (String) JOptionPane.showInputDialog(frame, "Selecione qual tecnologia deseja usar", "Tecnologia",
				JOptionPane.QUESTION_MESSAGE, null, tecnologias, tecnologias[0]);

		if (tecnologiaSelecionada == null) {
			tecnologiaSelecionada = tecnologias[0];
		}
	}

	private static void Teste() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		AlunoHelper alunoHelper = new AlunoHelper(em);

		ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
		AlunoDao alunoDao = (AlunoDao) context.getBean("AlunoDao");

		Aluno aluno = new Aluno();
		aluno.setNome("Aluno 1");
		aluno.setEmail("aluno@fiap.com.br");

		alunoDao.Insert(aluno);
		alunoHelper.Insert(aluno);

		System.out.println("Cadastro realizado com sucesso");
	}
}
