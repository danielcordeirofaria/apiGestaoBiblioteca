package com.Biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import com.Biblioteca.model.Emprestimos;
import com.Biblioteca.model.Livros;
import com.Biblioteca.model.Usuario;

public interface IEmprestimosService {
    public Emprestimos criarEmprestimo(Emprestimos novo);
    List<Emprestimos> recuperarTodos();
	ArrayList<Emprestimos> findByUsuario(Usuario idUsuario);
	ArrayList<Emprestimos> findByLivro(Livros livro);
	Emprestimos atualizarDados(Long id, Emprestimos emp);
}
