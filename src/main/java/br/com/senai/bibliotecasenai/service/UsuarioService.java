package br.com.senai.bibliotecasenai.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.bibliotecasenai.entity.Usuario;
import br.com.senai.bibliotecasenai.repository.UsuarioRepository;

public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario inserir(@Valid @NotNull(message = "O usuario não pode ser nulo") Usuario novoUsuario) {
		Usuario usuarioSalvo = repository.save(novoUsuario);
		return usuarioSalvo;
	}

	public Usuario alterar(@Valid @NotNull(message = "O usuario não pode ser nulo") Usuario usuarioSalvo) {
		Usuario usuarioAtualizado = repository.save(usuarioSalvo);
		return usuarioAtualizado;
	}

	public List<Usuario> listarPor(
			@NotEmpty(message = "O nome completo para busca é obrigatório") @NotBlank(message = "O nome completo para busca não deve conter espaços em branco") String nomeCompleto) {
		return new ArrayList<Usuario>();
	}

	public void removerPor(
			@NotNull(message = "O id para remoção não pode ser nulo") @Min(value = 1, message = "O id deve ser maior que zero") Integer id) {
		this.repository.deleteById(id);
	}
	
}