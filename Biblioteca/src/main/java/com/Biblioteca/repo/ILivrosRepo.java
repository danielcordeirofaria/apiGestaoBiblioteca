package com.Biblioteca.repo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.Biblioteca.model.Livros;

public interface ILivrosRepo extends CrudRepository<Livros, Integer>{

	ArrayList<Livros> findByAutorContaining(String autor);

	ArrayList<Livros> findByTituloContainingIgnoreCase(String palavraChave);

	ArrayList<Livros> findByTituloContaining(String nome);

	Optional<Livros> findTopByOrderByIdLivro();

	Optional<Livros> findTopByOrderByIdLivroDesc();
	
	

}
