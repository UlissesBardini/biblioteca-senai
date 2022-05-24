package br.com.senai.bibliotecasenai.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import br.com.senai.bibliotecasenai.enums.Tipo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "Usuario")
@Table(name = "usuarios")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	@Column(name = "tipo")
	@NotNull(message = "O tipo não pode ser nulo")
	private Tipo tipo;
	@Column(name = "nome_completo")
	@NotEmpty(message = "O nome completo não pode ser vazio")
	@Size(max = 100, message = "O nome completo deve possuir no máximo 100 caracteres")
	private String nomeCompleto;
	@Column(name = "data_nascimento")
	@NotNull(message = "A data não pode ser nula")
	@Past(message = "A data de nascimento deve ser mais cedo do que hoje")
	private LocalDate dataNascimento;
	@Column(name = "email")
	@NotEmpty(message = "O email não pode ser vazio")
	@Size(max = 100, message = "O email deve possuir no máximo 100 caracteres")
	private String email;
	@Column(name = "telefone")
	@NotEmpty(message = "O telefone não pode ser vazio")
	@Size(min = 14, max = 14, message = "O telefone deve ser no formato (12)91234-5678")
	private String telefone;

}
