package com.Biblioteca.repo;

import org.springframework.data.repository.CrudRepository;

import com.Biblioteca.model.Usuario;

public interface IUsuarioRepo extends CrudRepository<Usuario, Integer>{

	Object findByEmail(String email);

	Object findByRg(String rg);	
	
}
