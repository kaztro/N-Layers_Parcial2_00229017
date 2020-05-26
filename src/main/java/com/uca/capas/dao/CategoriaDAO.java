package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Categoria;


public interface CategoriaDAO {
	public List<Categoria> findAll() throws DataAccessException;
	public Categoria findOne(Integer c_categoria) throws DataAccessException;
	public void insert(Categoria categoria) throws DataAccessException;
}
