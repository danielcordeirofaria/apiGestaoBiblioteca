package com.Biblioteca.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Biblioteca.model.Livros;
import com.Biblioteca.repo.ILivrosRepo;

@Component
public class LivrosServiceImpl implements ILivrosService {

	@Autowired
	private ILivrosRepo repo;

	@Override
	public Livros adicionarNovoLivro(Livros novo) {
		System.out.println(novo.getIdLivro());
		if (novo.getIdLivro() == 0) {
			int ultimoIdLivro = repo.findTopByOrderByIdLivroDesc().map(Livros::getIdLivro).orElse(0);
			novo.setIdLivro(ultimoIdLivro + 1);
		}
		if (novo.getTitulo() == null) {
			throw new IllegalArgumentException("O título do livro não pode ser nulo.");
		}
		if (novo.getDataAdicionadoAoAcervo() == null) {
			throw new IllegalArgumentException("É preciso informar a data que o livro foi adicionado ao acervo.");
		}
		if (novo.getAutor() == null) {
			throw new IllegalArgumentException("Informe o autor do livro");
		}
		if(novo.getLocalEdicao() == null) {
			throw new IllegalArgumentException("Informe o local da edição");
		}
		if(novo.getAnoDaEdicao() == null) {
			throw new IllegalArgumentException("Informe o ano da edição");
		}
		if(novo.getOrigem() == null) {
			throw new IllegalArgumentException("Informe a origem. DOACAO ou COMPRA");
		}
		
		return repo.save(novo);
	}

	@Override
	public ArrayList<Livros> recuperarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Livros>) repo.findAll();
	}

	@Override
	public Livros recuperarPeloCodigo(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public ArrayList<Livros> recuperarPeloAutor(String autor) {
		// TODO Auto-generated method stub
		return repo.findByAutorContaining(autor);
	}

	@Override
	public ArrayList<Livros> recuperarPeloNome(String nome) {
		// TODO Auto-generated method stub
		return repo.findByTituloContaining(nome);
	}

	@Override
	public ArrayList<Livros> recuperarPeloIsbn(String isbn) {
		// TODO Auto-generated method stub
		return repo.findByAutorContaining(isbn);
	}

	@Override
	public Livros atualizarDados(int id, Livros li) {
		Livros livroExistente = repo.findById(id).orElse(null);
		if (livroExistente == null) {
			return null;
		}
		if (li.getTitulo() != null) {
			livroExistente.setTitulo(li.getTitulo());
		}

		if (li.getnVolumeOuEdicao() != null) {
			livroExistente.setnVolumeOuEdicao(li.getnVolumeOuEdicao());
		}

		if (li.getLocalEdicao() != null) {
			livroExistente.setLocalEdicao(li.getLocalEdicao());
		}

		if (li.getEditora() != null) {
			livroExistente.setEditora(li.getEditora());
		}

		if (li.getAnoDaEdicao() != null) {
			livroExistente.setAnoDaEdicao(li.getAnoDaEdicao());
		}

		if (li.getOrigem() != null) {
			livroExistente.setOrigem(li.getOrigem());
		}

		if (li.getClassificacao() != null) {
			livroExistente.setClassificacao(li.getClassificacao());
		}

		if (li.getIsbn() != null) {
			livroExistente.setIsbn(li.getIsbn());
		}

		if (li.getObservacao() != null) {
			livroExistente.setObservacao(li.getObservacao());
		}

		if (li.getStatus() != null) {
			livroExistente.setStatus(li.getStatus());
		}

		return repo.save(livroExistente);
	}

	@Override
	public void saveAll(ArrayList<Livros> lista) {
		for (Livros livro : lista) {
			// Chama o método adicionarNovo para cada livro na lista
			try {
				adicionarNovoLivro(livro);
			} catch (Exception e) {
				System.out.println("Não deu: " + e.getMessage());
			}
		}
	}

}