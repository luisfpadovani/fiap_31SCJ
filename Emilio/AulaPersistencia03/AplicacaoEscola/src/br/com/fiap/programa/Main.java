package br.com.fiap.programa;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fiap.entidades.Curso;
import br.com.fiap.entidades.Disciplina;
import br.com.fiap.entidades.Escola;
import br.com.fiap.jdbc.JdbcCursoDao;
import br.com.fiap.jdbc.JdbcDisciplinaDao;
import br.com.fiap.jdbc.JdbcEscolaCursoDao;
import br.com.fiap.jdbc.JdbcEscolaDao;
import br.com.fiap.viewmodel.EscolaCurso;
  

public class Main {
	public static void main(String[] args) {
		while(true) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente fazer novamente?", null, JOptionPane.YES_NO_OPTION);
			if (resposta == JOptionPane.NO_OPTION) {
				break;
			} 
			incluirEscola();
			incluirCurso(); 
		} 
	}
	
	private static ApplicationContext criarInstancia() {
		return  new ClassPathXmlApplicationContext("beanJdbc.xml");
	}

	private static void listarEscolasComCursos() {
		try { 
			List<EscolaCurso> escolas = ((JdbcEscolaCursoDao)criarInstancia().getBean("jdbcEscolaCursoDao"))
					.listarEscolasComCursos();

			for (EscolaCurso vm : escolas) {
				System.out.println("Escola: " + vm.getDescricao());
				System.out.println("Num. Cursos: " + vm.getNumCursos());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void incluirEscola() {
		try { 
			JdbcEscolaDao dao = (JdbcEscolaDao) criarInstancia().getBean("jdbcEscolaDao");
			Escola escola = new Escola();
			escola.setDescricao(JOptionPane.showInputDialog("Digite o nome da escola"));
			escola.setDataString(JOptionPane.showInputDialog("Digite o data que ela foi criada da escola"));
			escola.setEndereco(JOptionPane.showInputDialog("Digite o endere�o"));
			dao.incluirEscola(escola);
			JOptionPane.showMessageDialog(null, "Escola inclu�da com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void incluirCurso() {
		try { 
			List<Escola> escolas = ((JdbcEscolaDao) criarInstancia().getBean("jdbcEscolaDao")).listarEscolas();
			JdbcCursoDao dao = (JdbcCursoDao) criarInstancia().getBean("jdbcCursoDao");
			
			Curso curso = new Curso();  
			
			curso.setEscola((Escola)JOptionPane.showInputDialog(
					null, 
					"Selecione uma escola", "Escola",
					JOptionPane.DEFAULT_OPTION,
					null,
					escolas.toArray(),
					null));
			
			curso.setDescricao(JOptionPane.showInputDialog("Digite a descri��o do curso"));
			dao.incluirCurso(curso);
			JOptionPane.showMessageDialog(null, "Curso inclu�do com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
