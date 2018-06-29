package br.com.fiap.jpa.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Aluno;
import br.com.fiap.interfaces.IAluno;

public class AlunoHelper implements IAluno {
	private EntityManager em;

	public AlunoHelper(EntityManager em) {
		this.em = em;
	}

	@Override
	public int Insert(Aluno item) {
		try {
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int Update(Aluno item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Aluno> GetAll() {
		TypedQuery<Aluno> query = em.createQuery("Select e from Aluno e", Aluno.class);
		return query.getResultList();
	}

	@Override
	public Aluno GetBy(int id) {
		TypedQuery<Aluno> query = em.createQuery("Select e from Aluno e where  e.id = :id", Aluno.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
