package br.com.fiap.jpa.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.CursoAluno;
import br.com.fiap.interfaces.ICursoAluno;

public class CursoAlunoHelper implements ICursoAluno{
	private EntityManager em;

	public CursoAlunoHelper(EntityManager em) {
		this.em = em;
	}

	@Override
	public int Insert(CursoAluno item) {
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
	public int Update(CursoAluno item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CursoAluno> GetAll() {
		TypedQuery<CursoAluno> query = em.createQuery("Select e from CursoAluno e", CursoAluno.class);
		return query.getResultList();
	}

	@Override
	public CursoAluno GetBy(int id) {
		TypedQuery<CursoAluno> query = em.createQuery("Select e from CursoAluno e where e.id = :id", CursoAluno.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
