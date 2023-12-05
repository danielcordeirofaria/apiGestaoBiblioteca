package com.Biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Biblioteca.MensagemDeErro.MensagemErro;
import com.Biblioteca.MensagemDeErro.UsuarioDuplicadoException;
import com.Biblioteca.model.Livros;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.repo.IUsuarioRepo;

@Component
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepo repo;

	@Override
	public Usuario cadastrarUsuario(Usuario u) {
		// Verifica se o e-mail já está cadastrado
		if (repo.findByEmail(u.getEmail()) != null) {
			throw new UsuarioDuplicadoException("Email já cadastrados");
		} else if (repo.findByRg(u.getRg()) != null) {
			throw new UsuarioDuplicadoException("RG já cadastrados");
		}
		
		return repo.save(u);
	}

	@Override
	public ArrayList<Usuario> recuperarTodos() {
		return (ArrayList<Usuario>) repo.findAll();
	}

	@Override
	public Usuario recuperarPeloId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Usuario atualizarDados(int id, Usuario u) {
		Usuario usuarioExistente = repo.findById(id).orElse(null);
		if (usuarioExistente == null) {
			return null;
		}
		if (u.getNomeUsuario() != null) {
			usuarioExistente.setNomeUsuario(u.getNomeUsuario());
		}
		if (u.getEmail() != null) {
			usuarioExistente.setEmail(u.getEmail());
		}
		if (u.getTelefone() != null) {
			usuarioExistente.setTelefone(u.getTelefone());
		}
		if (u.getLogradouro() != null) {
			usuarioExistente.setLogradouro(u.getLogradouro());
		}
		if (u.getNumero() != null) {
			usuarioExistente.setNumero(u.getNumero());
		}
		if (u.getComplemento() != null) {
			usuarioExistente.setComplemento(u.getComplemento());
		}
		if (u.getCidade() != null) {
			usuarioExistente.setCidade(u.getCidade());
		}
		if (u.getUf() != null) {
			usuarioExistente.setUf(u.getUf());
		}
		if (u.getCep() != null) {
			usuarioExistente.setCep(u.getCep());
		}
		if (u.getDataNascimento() != null) {
			usuarioExistente.setDataNascimento(u.getDataNascimento());
		}
		if (u.getRg() != null) {
			usuarioExistente.setRg(u.getRg());
		}
		if (u.getProfissao() != null) {
			usuarioExistente.setProfissao(u.getProfissao());
		}
		if (u.getDataUltimoEmprestimo() != null) {
			usuarioExistente.setDataUltimoEmprestimo(u.getDataUltimoEmprestimo());
		}
		if (u.getDataUltimaDevolucao() != null) {
			usuarioExistente.setDataUltimaDevolucao(u.getDataUltimaDevolucao());
		}

		return repo.save(usuarioExistente);
	}

}
