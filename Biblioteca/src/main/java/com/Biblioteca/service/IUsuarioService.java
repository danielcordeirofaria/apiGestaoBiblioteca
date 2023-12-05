package com.Biblioteca.service;

import java.util.ArrayList;

import com.Biblioteca.model.Usuario;

public interface IUsuarioService {

	Usuario cadastrarUsuario(Usuario u);

	ArrayList<Usuario> recuperarTodos();

	Usuario recuperarPeloId(int id);

	Usuario atualizarDados(int id, Usuario u);
	
}
