package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;
import com.uca.capas.domain.*;

@Controller
public class MainController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	LibroService libroService;
	
	@RequestMapping("/index")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;
		
		try { libros = libroService.findAll(); }
		catch(Exception e) { e.printStackTrace(); }
		
		mav.addObject("libros", libros);
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping("/ingresarCat")
	public ModelAndView ingresarCat() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("ingresarCat");
		return mav;
	}
	
	@RequestMapping("/ingresarLib")
	public ModelAndView ingresarLib() {
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		List<Categoria> categorias = null;
		
		try { categorias = categoriaService.findAll(); }
		catch(Exception e) { e.printStackTrace(); }
		
		mav.addObject("categorias", categorias);
		mav.addObject("libro", libro);
		mav.setViewName("ingresarLib");
		return mav;
	}
	
	@RequestMapping("/filterLib")
	public ModelAndView filterLib(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List<Categoria> categorias = null;
			
			try { categorias = categoriaService.findAll(); }
			catch(Exception e) { e.printStackTrace(); }
			
			mav.addObject("categorias", categorias);
			mav.setViewName("filterLib");
		} else {
			try { libroService.insert(libro); }
			catch(Exception e) { e.printStackTrace(); }
			
			libro = new Libro();
			mav.setViewName("filterLib");
		}
		return mav;
	}
	
	@RequestMapping("/filterCat")
	public ModelAndView filterCat(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) { mav.setViewName("filterCat"); } 
		else {
			try { categoriaService.insert(categoria); }
			catch(Exception e) { e.printStackTrace(); }
			
			categoria = new Categoria();
			mav.setViewName("filterCat");
		}
		return mav;
	}
	
}