package com.Biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.Biblioteca.model.Emprestimos;
import com.Biblioteca.model.Livros;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.repo.IEmprestimosRepo;

@Component
public class EmprestimosServiceImpl implements IEmprestimosService {
	
	@Autowired
	private IEmprestimosRepo repo;

	
	@Override
	public ArrayList<Emprestimos> findByUsuario(Usuario idUsuario) {
		return (ArrayList<Emprestimos>) repo.findByUsuario(idUsuario);
	}

	@Override
	public ArrayList<Emprestimos> findByLivro(Livros idLivro) {
		return (ArrayList<Emprestimos>) repo.findByLivro(idLivro);
	}

	@Override
	public Emprestimos criarEmprestimo(Emprestimos novo) {
		return repo.save(novo);
	}

	@Override
	public List<Emprestimos> recuperarTodos() {
		// TODO Auto-generated method stub
		return (List<Emprestimos>)repo.findAll();
	}

	@Override
	public Emprestimos atualizarDados(Long id, Emprestimos emp) {
	    Emprestimos emprestimoExistente = repo.findById(id).orElse(null);
	    	if(emprestimoExistente == null) {
	    		return null;
	    	}
	    	if(emp.getDataDevolucaoReal() != null) {
	    		emprestimoExistente.setDataDevolucaoReal(emp.getDataDevolucaoReal());
	    	}
	    	
	    return repo.save(emprestimoExistente);
	}

}
