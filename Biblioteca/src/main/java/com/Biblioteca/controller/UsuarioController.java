package com.Biblioteca.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Biblioteca.MensagemDeErro.MensagemErro;
import com.Biblioteca.MensagemDeErro.UsuarioDuplicadoException;
import com.Biblioteca.model.Livros;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.service.IUsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@GetMapping("/usuarios")
	public ArrayList<Usuario> recuperarTodos() {
		return service.recuperarTodos();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> recuperarPeloId(@PathVariable int id) {
		Usuario u = service.recuperarPeloId(id);
		if (u != null) {
			return ResponseEntity.ok(u);
		}
		return ResponseEntity.status(404).body(new MensagemErro(404, "Usuario não existe."));

	}

	@PostMapping("/usuarios")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario u) {
		try {
			Usuario res = service.cadastrarUsuario(u);
			return ResponseEntity.status(201).body(res);
		} catch (UsuarioDuplicadoException ex) {
			return ResponseEntity.status(400).body(new MensagemErro(400, ex.getMessage()));
		}
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> atualizarDados(@PathVariable("id") int id, @RequestBody Usuario u) {
		Usuario res = service.atualizarDados(id, u);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.notFound().build();
	}

}
