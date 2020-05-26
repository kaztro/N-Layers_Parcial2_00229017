package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "CAT_LIBRO")
public class Libro {
	@Id
	@Column(name = "c_libro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_libro;
	
	@Size(message = "Maximo 500 caracteres", max = 500)
	@NotEmpty(message = "No se permiten campos en blanco")
	@Column(name = "s_titulo")
	private String s_titulo;
	
	@Size(message = "Maximo 150 caracteres", max = 150)
	@NotEmpty(message = "No se permiten campos en blanco")
	@Column(name = "s_autor")
	private String s_autor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer c_categoria;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "f_ingreso")
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date f_ingreso;
	
	@NotNull
	@Column(name = "b_estado", nullable = false)
	private Boolean b_estado; 
	
	@Size(message = "Maximo 10 caracteres", max = 10)
	@NotEmpty(message = "No se permiten campos en blanco")
	@Column(name = "s_isbn")
	private String s_isbn;
	
	public String getF_ingreso() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		return formatter.format(f_ingreso);
	}
	
	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}
	
	public Libro() {
		
	}

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}
	
	public String getEstadoDelegate() {
		if(this.b_estado == null) return "";
		else { return b_estado == true ? "Activo":"Inactivo"; }
	}
	
}
