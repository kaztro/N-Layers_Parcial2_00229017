package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Libro;

public interface LibroService {
	public List<Libro> findAll() throws DataAccessException;
	public void insert(Libro libro) throws DataAccessException; 
}
