package br.com.senai.bibliotecasenai.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.bibliotecasenai.entity.Emprestimo;
import br.com.senai.bibliotecasenai.entity.Livro;
import br.com.senai.bibliotecasenai.entity.Usuario;
import br.com.senai.bibliotecasenai.repository.EmprestimoRepository;

public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;
	
	public Emprestimo inserir(@Valid @NotNull(message = "O empréstimo não pode ser nulo") Emprestimo novoEmprestimo) {
		Emprestimo emprestimoSalvo = repository.save(novoEmprestimo);
		return emprestimoSalvo;
	}

	public Emprestimo alterar(@Valid @NotNull(message = "O empréstimo não pode ser nulo") Emprestimo emprestimoSalvo) {
		Emprestimo emprestimoAtualizado = repository.save(emprestimoSalvo);
		return emprestimoAtualizado;
	}

	public List<Emprestimo> listarPor(
			@NotEmpty(message = "O livro para busca é obrigatório") @NotBlank(message = "O livro para busca não deve conter espaços em branco") Livro livro) {
		return new ArrayList<Emprestimo>();
	}
	
	public List<Emprestimo> listarPor(
			@NotEmpty(message = "O usuario para busca é obrigatório") @NotBlank(message = "O usuario para busca não deve conter espaços em branco") Usuario usuario) {
		return new ArrayList<Emprestimo>();
	}


	public void removerPor(
			@NotNull(message = "O id para remoção não pode ser nulo") @Min(value = 1, message = "O id deve ser maior que zero") Integer id) {
		this.repository.deleteById(id);
	}
	
}
