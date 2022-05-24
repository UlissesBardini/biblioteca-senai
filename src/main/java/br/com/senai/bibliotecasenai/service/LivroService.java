package br.com.senai.bibliotecasenai.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.bibliotecasenai.entity.Livro;
import br.com.senai.bibliotecasenai.repository.LivroRepository;

public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	public Livro inserir(@Valid @NotNull(message = "O livro não pode ser nulo") Livro novoLivro) {
		Livro livroSalvo = repository.save(novoLivro);
		return livroSalvo;
	}

	public Livro alterar(@Valid @NotNull(message = "O livro não pode ser nulo") Livro livroSalvo) {
		Livro livroAtualizado = repository.save(livroSalvo);
		return livroAtualizado;
	}

	public List<Livro> listarPor(
			@NotEmpty(message = "O nome completo para busca é obrigatório") @NotBlank(message = "O nome completo para busca não deve conter espaços em branco") String nomeCompleto) {
		return new ArrayList<Livro>();
	}

	public void removerPor(
			@NotNull(message = "O id para remoção não pode ser nulo") @Min(value = 1, message = "O id deve ser maior que zero") Integer id) {
		this.repository.deleteById(id);
	}
	
}