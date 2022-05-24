package br.com.senai.bibliotecasenai.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "Emprestimo")
@Table(name = "emprestimos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	@NotNull(message = "O livro não pode ser nulo")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_livro")
	private Livro livro;
	@NotNull(message = "O usuario não pode ser nulo")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")	
	private Usuario usuario;
	@Column(name = "data_retirada")
	@NotNull(message = "A data da retirada não pode ser nula")
	private LocalDate dataRetirada;
	@Column(name = "data_entrega")
	@NotNull(message = "A data de entrega não pode ser nula")	
	private LocalDate dataEntrega;
	@Column(name = "is_devolvido")
	@NotNull(message = "isDevolvido não pode ser nulo")	
	private boolean isDevolvido;
	
}
