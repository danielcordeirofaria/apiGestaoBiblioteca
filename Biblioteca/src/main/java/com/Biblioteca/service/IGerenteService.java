package com.Biblioteca.service;

import java.util.ArrayList;

import com.Biblioteca.model.Gerente;
//import com.br.biblioteca.security.EBibliotecaToken;

public interface IGerenteService {

	 
	Gerente cadastrarGerente(Gerente g);
	
	ArrayList<Gerente> recuperarTodos();
	
	Gerente recuperarPeloId(int id);

	Gerente atualizarDados(int id, Gerente g);

//	public EBibliotecaToken fazerLogin(String nickName, String senha);

}
