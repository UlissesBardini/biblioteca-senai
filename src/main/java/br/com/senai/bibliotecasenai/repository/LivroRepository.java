package br.com.senai.bibliotecasenai.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.bibliotecasenai.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}