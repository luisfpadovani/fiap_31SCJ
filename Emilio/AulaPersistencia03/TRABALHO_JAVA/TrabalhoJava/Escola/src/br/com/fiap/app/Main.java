package br.com.fiap.app;

import java.awt.Dimension;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.CursoAluno;
import br.com.fiap.interfaces.IAluno;
import br.com.fiap.interfaces.ICurso;
import br.com.fiap.interfaces.ICursoAluno;

import br.com.fiap.jdbc.dao.AlunoDao;
import br.com.fiap.jpa.helper.AlunoHelper;
import br.com.fiap.jdbc.dao.CursoDao;
import br.com.fiap.jpa.helper.CursoHelper;
import br.com.fiap.jdbc.dao.CursoAlunoDao;
import br.com.fiap.jpa.helper.CursoAlunoHelper;

public class Main {

	public static EntityManager em = (Persistence.createEntityManagerFactory("jpaPU")).createEntityManager();
	public static ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");

	public static final String[] tecnologias = { "JDBC", "JPA" };
	public static String tecnologiaSelecionada;

	public static final String[] menus = { "CADASTRAR ALUNO", "CADASTRAR CURSO", "CADASTRAR NOTA", "LISTAR ALUNOS",
			"LISTAR CURSOS", "LISTAR NOTAS" };
	public static String menuSelecionado;

	private static boolean encerrarPrograma = false;
	public static final String[] operacoes = { "SIM", "N�O" };
	public static String operacaoSelecionada;

	public static IAluno iAluno;
	public static ICurso iCurso;
	public static ICursoAluno iCursoAluno;

	public static void main(String[] args) {
		while (!encerrarPrograma) {
			Tecnologia();
			Menu();
			RealizarAcao();
			DesejaNovamente();
		}
	}

	private static void RealizarAcao() {
		switch (menuSelecionado) {
		case "CADASTRAR ALUNO":
			if (tecnologiaSelecionada == "JDBC") {
				iAluno = (AlunoDao) context.getBean("AlunoDao");
			} else {
				iAluno = new AlunoHelper(em);
			}
			CadastrarAluno();
			break;
		case "CADASTRAR CURSO":
			if (tecnologiaSelecionada == "JDBC") {
				iCurso = (CursoDao) context.getBean("CursoDao");
			} else {
				iCurso = new CursoHelper(em);
			}
			CadastrarCurso();
			break;
		case "CADASTRAR NOTA":
			if (tecnologiaSelecionada == "JDBC") {
				iCursoAluno = (CursoAlunoDao) context.getBean("CursoAlunoDao");
				iCurso = (CursoDao) context.getBean("CursoDao");
				iAluno = (AlunoDao) context.getBean("AlunoDao");
			} else {
				iCurso = new CursoHelper(em);
				iCursoAluno = new CursoAlunoHelper(em);
				iAluno = new AlunoHelper(em);
			}
			CadastrarCursoAluno();
			break;
		case "LISTAR ALUNOS":
			if (tecnologiaSelecionada == "JDBC") {
				iAluno = (AlunoDao) context.getBean("AlunoDao");
			} else {
				iAluno = new AlunoHelper(em);
			}
			ListarAluno();
			break;
		case "LISTAR CURSOS":
			if (tecnologiaSelecionada == "JDBC") {
				iCurso = (CursoDao) context.getBean("CursoDao");
			} else {
				iCurso = new CursoHelper(em);
			}
			ListarCurso();
			break;
		case "LISTAR NOTAS":
			if (tecnologiaSelecionada == "JDBC") {
				iCursoAluno = (CursoAlunoDao) context.getBean("CursoAlunoDao");
				iCurso = (CursoDao) context.getBean("CursoDao");
				iAluno = (AlunoDao) context.getBean("AlunoDao");
			} else {
				iCurso = new CursoHelper(em);
				iCursoAluno = new CursoAlunoHelper(em);
				iAluno = new AlunoHelper(em);
			}
			ListarCursoAluno();
			break;
		}
	}

	private static void DesejaNovamente() {
		JFrame frame = new JFrame("Selecione");
		operacaoSelecionada = (String) JOptionPane.showInputDialog(frame, "Fazer outra opera��o?", "Opera��o",
				JOptionPane.QUESTION_MESSAGE, null, operacoes, operacoes[0]);

		if (operacaoSelecionada == "SIM") {
			encerrarPrograma = false;
		} else {
			encerrarPrograma = true;
		}

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
		tecnologiaSelecionada = (String) JOptionPane.showInputDialog(frame, "Selecione qual tecnologia deseja usar",
				"Tecnologia", JOptionPane.QUESTION_MESSAGE, null, tecnologias, tecnologias[0]);

		if (tecnologiaSelecionada == null) {
			tecnologiaSelecionada = tecnologias[0];
		}
	}

	private static void CadastrarAluno() {
		Aluno aluno = new Aluno();
		String nome = JOptionPane.showInputDialog(null, "Insira seu nome", "Cadastro de aluno",
				JOptionPane.QUESTION_MESSAGE);
		aluno.setNome(nome);
		String email = JOptionPane.showInputDialog(null, "Insira seu e-mail", "Cadastro de aluno",
				JOptionPane.QUESTION_MESSAGE);
		aluno.setEmail(email);
		iAluno.Insert(aluno);
		JFrame frame = new JFrame("SUCESSO");
		JOptionPane.showMessageDialog(frame, "Cadastro de aluno realizado com sucesso!");
	}

	private static void CadastrarCurso() {
		Curso curso = new Curso();
		String nome = JOptionPane.showInputDialog(null, "Insira o nome do curso", "Cadastro de curso",
				JOptionPane.QUESTION_MESSAGE);
		curso.setNome(nome);
		iCurso.Insert(curso);
		JFrame frame = new JFrame("SUCESSO");
		JOptionPane.showMessageDialog(frame, "Cadastro de curso realizado com sucesso!");
	}

	private static void CadastrarCursoAluno() {

		List<Aluno> listaAluno = iAluno.GetAll();
		List<Curso> listaCurso = iCurso.GetAll();

		if (listaAluno.toArray().length <= 0 || listaCurso.toArray().length <= 0) {
			JFrame frame = new JFrame("AVISO");
			JOptionPane.showMessageDialog(frame, "Necessario um aluno ou curso cadastrado!");
		} else {

			CursoAluno cursoAluno = new CursoAluno();
			Curso curso = new Curso();
			Aluno aluno = new Aluno();

			curso = ((Curso) JOptionPane.showInputDialog(null, "Selecione um curso", "Cursos",
					JOptionPane.DEFAULT_OPTION, null, listaCurso.toArray(), null));

			aluno = ((Aluno) JOptionPane.showInputDialog(null, "Selecione um aluno", "Alunos",
					JOptionPane.DEFAULT_OPTION, null, listaAluno.toArray(), null));

			String notaString = JOptionPane.showInputDialog(null, "Insira a nota do aluno neste curso",
					"Cadastro de nota", JOptionPane.QUESTION_MESSAGE);

			cursoAluno.setNota(Double.parseDouble(notaString));
			cursoAluno.setId_aluno(aluno.getId());
			cursoAluno.setId_curso(curso.getId());
			iCursoAluno.Insert(cursoAluno);
			JFrame frame = new JFrame("SUCESSO");
			JOptionPane.showMessageDialog(frame, "Cadastro de nota realizado com sucesso!");
		}
	}

	private static void ListarAluno() { 
		List<Aluno> listaAluno = iAluno.GetAll();
		if (listaAluno.toArray().length <= 0) {
			JFrame frame = new JFrame("AVISO");
			JOptionPane.showMessageDialog(frame, "Nao possui aluno cadastrado!");
		} else {
			String mensagem = "";
			for (Aluno item : listaAluno) {
				mensagem += item.getNome() + "\n";
			}
			JTextArea msg = new JTextArea(mensagem);
			msg.setLineWrap(true);
			msg.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(msg);
			JOptionPane.showMessageDialog(null, scrollPane);
		}
	}

	private static void ListarCurso() {
		List<Curso> listaCurso = iCurso.GetAll();
		if (listaCurso.toArray().length <= 0) {
			JFrame frame = new JFrame("AVISO");
			JOptionPane.showMessageDialog(frame, "Nao possui curso cadastrado!");
		} else {
			String mensagem = "";
			for (Curso item : listaCurso) {
				mensagem += item.getNome() + "\n";
			}
			JTextArea msg = new JTextArea(mensagem);
			msg.setLineWrap(true);
			msg.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(msg);
			JOptionPane.showMessageDialog(null, scrollPane);
		}
	}

	private static void ListarCursoAluno() {
		List<CursoAluno> listaCursoAluno = iCursoAluno.GetAll();
		if (listaCursoAluno.toArray().length <= 0) {
			JFrame frame = new JFrame("AVISO");
			JOptionPane.showMessageDialog(frame, "Nao possui nota cadastrada!");
		} else {
			String mensagem = "";
			for (CursoAluno item : listaCursoAluno) {
				Aluno nomeAluno = iAluno.GetBy(item.getId_aluno());
				Curso nomeCurso = iCurso.GetBy(item.getId_curso());
				mensagem += nomeAluno.toString() + " --- " + nomeCurso.toString() + " --- Nota: "  + Double.toString(item.getNota()) + "\n";
			} 
			  
			JTextArea textArea = new JTextArea(mensagem);
			JScrollPane scrollPane = new JScrollPane(textArea);  
			textArea.setLineWrap(true);  
			textArea.setWrapStyleWord(true); 
			scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
			JOptionPane.showMessageDialog(null, scrollPane, "", JOptionPane.WARNING_MESSAGE);
		}
	}
}
