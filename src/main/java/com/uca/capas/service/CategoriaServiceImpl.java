package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDAO.findAll();
	}

	@Override
	public Categoria findOne(Integer c_categoria) throws DataAccessException {
		return categoriaDAO.findOne(c_categoria);
	}
	
	@Transactional
	@Override
	public void insert(Categoria categoria) throws DataAccessException {
		categoriaDAO.insert(categoria);
	}

}
