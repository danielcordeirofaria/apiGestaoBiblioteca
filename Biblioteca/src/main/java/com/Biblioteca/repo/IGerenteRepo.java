package com.Biblioteca.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Biblioteca.model.Gerente;

@Repository
public interface IGerenteRepo extends JpaRepository<Gerente, Integer>{

	Gerente findByEmail(String email);
		
	Gerente findByNomeGerente(String nomeGerente);
	
	Gerente findByLogin(String login);
	
	
}
