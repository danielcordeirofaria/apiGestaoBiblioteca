package com.Biblioteca.service;

import java.util.ArrayList;

import com.Biblioteca.model.Livros;

public interface ILivrosService {

	public Livros adicionarNovoLivro(Livros novo);

	public ArrayList<Livros> recuperarTodos();

	public Livros recuperarPeloCodigo(int id);

	public ArrayList<Livros> recuperarPeloNome(String nome);

	public ArrayList<Livros> recuperarPeloAutor(String autor);

	public Livros atualizarDados(int id, Livros li);

	ArrayList<Livros> recuperarPeloIsbn(String isbn);

	public void saveAll(ArrayList<Livros> lista);




	

}
