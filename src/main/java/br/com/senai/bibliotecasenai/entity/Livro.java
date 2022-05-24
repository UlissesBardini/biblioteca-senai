package br.com.senai.bibliotecasenai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "Livro")
@Table(name = "livros")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	@Column(name = "titulo")
	@NotNull(message = "O tipo não pode ser nulo")
	@Size(max = 100, message = "O título não pode conter mais que 100 caracteres")
	private String titulo;
	@Column(name = "autor")
	@NotNull(message = "O autor não pode ser nulo")
	@Size(max = 100, message = "O autor não pode conter mais que 100 caracteres")
	private String autor;
	@Column(name = "editora")
	@NotNull(message = "A editora não pode ser nula")
	@Size(max = 100, message = "A editora não pode conter mais que 100 caracteres")
	private String editora;
	@NotNull(message = "O ano não pode ser nulo")
	private int ano;
	
}