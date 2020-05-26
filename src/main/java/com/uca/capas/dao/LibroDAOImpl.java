package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {


	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		@SuppressWarnings("unchecked")
		List<Libro> resultset = query.getResultList();
		
		return resultset;
	}

	@Override
	public void insert(Libro libro) throws DataAccessException {
		entityManager.persist(libro);
	}

}
