package com.Biblioteca.service;

import java.util.ArrayList;

import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.Biblioteca.MensagemDeErro.GerenteDuplicadoException;
import com.Biblioteca.MensagemDeErro.UsuarioDuplicadoException;
import com.Biblioteca.model.Gerente;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.repo.IGerenteRepo;
import com.Biblioteca.repo.IUsuarioRepo;
//import com.br.biblioteca.security.EBibliotecaToken;

@Component
public class GerenteServiceImpl {

	@Autowired
	private IGerenteRepo repo;

	public ArrayList<Gerente> recuperarTodos() {
		return (ArrayList<Gerente>) repo.findAll();
	}

	public Gerente recuperarPeloId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public Gerente cadastrarGerente(Gerente gerente) {
		if (repo.findByEmail(gerente.getEmail()) != null) {
			throw new GerenteDuplicadoException("Email já cadastrados");
		} else if (repo.findByNomeGerente(gerente.getNomeGerente()) != null) {
			throw new GerenteDuplicadoException("Nome já cadastrados");
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String novaSenha = encoder.encode(gerente.getPassword());
		gerente.setPassword(novaSenha);

		if (gerente.getUsername() == null) {
			throw new IllegalArgumentException("O username não pode ser nulo");
		}
		return repo.save(gerente);
	}

	public Gerente atualizarDados(int id, Gerente gerente) {
		Gerente gerenteExistente = repo.findById(id).orElse(null);
		if (gerenteExistente == null) {
			return null;
		}
		if (gerente.getNomeGerente() != null) {
			gerenteExistente.setNomeGerente(gerente.getNomeGerente());
		}
		if (gerente.getEmail() != null) {
			gerenteExistente.setEmail(gerente.getEmail());
		}
		if (gerente.getTelefone() != null) {
			gerenteExistente.setTelefone(gerente.getTelefone());
		}

		return repo.save(gerenteExistente);
	}

}
